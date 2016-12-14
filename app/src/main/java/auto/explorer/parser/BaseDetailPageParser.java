package auto.explorer.parser;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import auto.explorer.model.Car;

import static auto.explorer.util.Const.USER_AGENT;

/**
 * Created by Eugene on 11.11.2016
 */

public abstract class BaseDetailPageParser {

    @Nullable
    protected synchronized static Document getDocument(@NonNull final Car car) {
        Document document = null;
        try {
            Connection.Response response = Jsoup.connect(car.getLinkToDetails()).userAgent(USER_AGENT)
                    .timeout(10000).ignoreHttpErrors(true).ignoreContentType(true).execute();
            document = Jsoup.parseBodyFragment(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    protected static void onParse(final RequestParserHelper.DetailPageLoadListener listener) {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (listener != null) listener.onCarDetailPageLoad();
            }
        });
    }
}

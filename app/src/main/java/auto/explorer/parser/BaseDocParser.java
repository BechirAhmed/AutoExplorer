package auto.explorer.parser;

import android.support.annotation.NonNull;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import auto.explorer.model.CurrentState;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Eugene on 27.11.2016
 */

public abstract class BaseDocParser {

    protected static final int UNKNOWN = -1;

    protected static void addCountResult(int count) {
        if (count != UNKNOWN) {
            CurrentState currentState = CurrentState.getInstance();
            currentState.setTotalFound(currentState.getTotalFound() + count);
        }
    }

    public static void queryList(Document doc, String query, ArrayList<String> list) {
        list.clear();
        Elements elements = doc.select(query);
        for (Element e : elements) if (!isEmpty(e.text())) list.add(e.text());
    }

//    @NonNull
//    public static String queryString(@NonNull Document doc, @NonNull String query) {
//        Element e = doc.select(query).first();
//        return e == null ? "": e.text().trim();
//    }

    @NonNull
    public static String queryString(@NonNull Element element, @NonNull String query) {
        return element.select(query).text().trim();
    }
}

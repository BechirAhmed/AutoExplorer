package auto.explorer.parser.auto.de;

import android.support.annotation.NonNull;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import auto.explorer.model.Car;
import auto.explorer.parser.BaseDetailPageParser;
import auto.explorer.parser.RequestParserHelper;

import static android.text.TextUtils.isEmpty;
import static android.text.TextUtils.join;
import static auto.explorer.parser.BaseDocParser.queryList;
import static auto.explorer.parser.BaseDocParser.queryString;

/**
 * Created by Eugene on 11.11.2016
 */

public final class DetailPageAutoDe extends BaseDetailPageParser {

    private DetailPageAutoDe() {
    }

    public synchronized static void parsePage(final Car car, final RequestParserHelper.DetailPageLoadListener listener) {
        final Document doc = getDocument(car);
        if (doc != null) parse(doc, car);
        onParse(listener);
    }

    private static void parse(@NonNull Document doc, @NonNull Car car) {
        queryList(doc, "div[id=rbt-envkv.consumption-v] strong", car.getDetailConsumption());
        car.setDetailGear(queryString(doc, "div[id=rbt-transmission-v] strong"));
//        car.setDetailExtColor(queryString(doc, "dt.sc-grid-col-6:contains(Außenfarbe)+dd"));
        car.setDetailOwner(queryString(doc, "div[id=rbt-numberOfPreviousOwners-v]"));

        car.setDetailSellerName(queryString(doc, "div#rbt-dealer-details div.u-margin-bottom-18:first-child>p:first-child b"));
        // phone
        final ArrayList<String> ph = new ArrayList<>();
        queryList(doc, "div#rbt-dealer-details div.u-margin-bottom-18 p#rbt-db-phone span", ph);
        car.setDetailSellerPhone(ph.isEmpty() ? "" : join(",\n", ph));
        // address
        car.setDetailSellerAddress(queryString(doc, "div#rbt-dealer-details p#rbt-db-address"));
        // equip
        queryList(doc, "div#rbt-features p", car.getDetailEquipment());
        // description
        String html = doc.select("div.description").html();
        if (!isEmpty(html)) html = html.replaceAll("<li>", "• ").replaceAll("</li>", "<br>");
        car.setDetailDescription(html);
        //
        extractPhotos(doc, car);
    }

    private static void extractPhotos(Document doc, Car car) {
        final ArrayList<String> photos = car.getPhotos();
        photos.clear();
        Elements elements = doc.select("img");
        for (Element e : elements) {
            String src = e.attr("data-lazy");
            if (src.isEmpty() || !src.contains("$_57.jpg")) continue;
            if (src.startsWith("/")) src = "http://" + src.replaceAll("^/+", "");
            photos.add(src);
        }
    }
}

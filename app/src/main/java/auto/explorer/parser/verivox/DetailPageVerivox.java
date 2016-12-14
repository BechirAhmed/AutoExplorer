package auto.explorer.parser.verivox;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import auto.explorer.model.Car;
import auto.explorer.parser.BaseDetailPageParser;
import auto.explorer.parser.RequestParserHelper;

import static android.text.TextUtils.isEmpty;
import static auto.explorer.parser.BaseDocParser.queryList;
import static auto.explorer.parser.BaseDocParser.queryString;

/**
 * Created by Eugene on 11.11.2016
 */

public final class DetailPageVerivox extends BaseDetailPageParser {

    private DetailPageVerivox() {
    }

    public synchronized static void parsePage(final Car car, final RequestParserHelper.DetailPageLoadListener listener) {
        final Document doc = getDocument(car);
        if (doc != null) parse(doc, car);
        onParse(listener);
    }

    private static void parse(@NonNull Document doc, @NonNull Car car) {
        if (car.getLinkToDetails().contains("://ww3.")) {
            queryList(doc, "div.gridWidth2:contains(Kraftstoffverbrauch*:)+div>div", car.getDetailConsumption());
            car.setDetailGear(queryString(doc, "div.gridWidth2:contains(Getriebe:)+div"));
            car.setDetailExtColor(queryString(doc, "div.gridWidth2:contains(Außenfarbe:)+div"));
            car.setDetailOwner(queryString(doc, "div.gridWidth2:contains(Fahrzeughalter:)+div"));
            car.setDetailSellerName(queryString(doc, "div[data-test=sellerCompany]"));
            car.setDetailSellerPhone(queryString(doc, "div#sellerinfo div.paddingBottomS"));
            car.setDetailSellerAddress(queryString(doc, "div#sellerinfo div[data-test=cityData]"));
            //
            queryList(doc, "div[data-test=equipment-content] p:not(:contains(Glossar))", car.getDetailEquipment());
            // description
            String html = doc.select("div[data-test=description-content]").html();
            if (!isEmpty(html)) html = html.replaceAll("<li>", "- ").replaceAll("</li>", "<br>");
            car.setDetailDescription(html);
        } else {
            queryList(doc, "dt.sc-grid-col-6:contains(Kraftstoffverbrauch*)~dd>div", car.getDetailConsumption());
            car.setDetailGear(queryString(doc, "dt.sc-grid-col-6:contains(Getriebeart)+dd"));
            car.setDetailExtColor(queryString(doc, "dt.sc-grid-col-6:contains(Außenfarbe)+dd"));
            car.setDetailOwner(queryString(doc, "dt.sc-grid-col-6:contains(Fahrzeughalter)+dd"));

            car.setDetailSellerName(queryString(doc, "div.cldt-vendor-info.sc-grid-col-6.sc-grid-col-s-12.sc-grid-col-m-12 h3"));
            // phone
            final ArrayList<String> ph = new ArrayList<>();
            queryList(doc, "div.cldt-vendor-contact-box div.cldt-vendor-phones>p", ph);
            Set<String> s = new HashSet<>();
            s.addAll(ph);
            car.setDetailSellerPhone(ph.isEmpty() ? "" : TextUtils.join(",\n", s.toArray()));
            // address
            final ArrayList<String> addr = new ArrayList<>();
            String str = queryString(doc, "div.cldt-vendor-contact-box div[data-item-name=vendor-contact-name]");
            if (!isEmpty(str)) addr.add(str);
            str = queryString(doc, "div.cldt-vendor-contact-box div[data-item-name=vendor-contact-street]");
            if (!isEmpty(str)) addr.add(str);
            str = queryString(doc, "div.cldt-vendor-contact-box div[data-item-name=vendor-contact-city]");
            if (!isEmpty(str)) addr.add(str);
            car.setDetailSellerAddress(addr.isEmpty() ? "" : TextUtils.join(",\n", addr));
            // equip
            queryList(doc, "div[data-item-name=equipments] span", car.getDetailEquipment());
            // description
            String html = doc.select("div[data-type=description]").html();
            if (!isEmpty(html)) html = html.replaceAll("<li>", "• ").replaceAll("</li>", "<br>");
            car.setDetailDescription(html);
        }
        //
        extractPhotos(doc, car);
    }

    private static void extractPhotos(Document doc, Car car) {
        final ArrayList<String> photos = car.getPhotos();
        photos.clear();
        Elements elements = doc.select("img.gallery-picture__image");
        for (Element e : elements) {
            String src = e.attr("src");
            if (src.isEmpty() || !src.startsWith("http")) src = e.attr("data-src");
            if (src.startsWith("http")) photos.add(src);
        }
        if (photos.isEmpty()) {
            final Pattern p = Pattern.compile("\"https?:.*?\"");
            final Matcher matcher = p.matcher(doc.html());
            while (matcher.find()) {
                String s = matcher.group();
                if (s.contains("autoscout24.net/images-small/")) {
                    photos.add(s.replaceAll("\"", "").replaceAll("images-small", "images-big"));
                }
            }
        }
    }
}

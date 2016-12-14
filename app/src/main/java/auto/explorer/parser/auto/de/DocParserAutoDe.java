package auto.explorer.parser.auto.de;

import android.support.annotation.NonNull;
import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import auto.explorer.model.Car;
import auto.explorer.parser.BaseDocParser;
import auto.explorer.util.Const;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Eugene on 27.11.2016
 */

final class DocParserAutoDe extends BaseDocParser {

    @NonNull
    static ArrayList<Car> parseDoc(@NonNull Document document) {
        foundedCount(document);
        final ArrayList<Car> carList = new ArrayList<>();
        final Elements cards = document.select("div.cBox-body--resultitem");
        for (Element e : cards) if (e != null) addCar(carList, e);
        return carList;
    }

    private static void addCar(@NonNull ArrayList<Car> carList, @NonNull Element e) {
        final Car car = new Car(Const.SITE_MOBILE_DE);
        car.setTitle(queryString(e, "span.h3.u-text-break-word"));
        car.setEquip(queryString(e, "div.g-col-12>:not(div.rbt-regMilPow,div.g-row.u-margin-top-9)"));
        car.setPrice(queryString(e, "div.price-block"));
        manMilePow(e, car);
        fuel(e, car);
        sellerAddress(e, car);
        // link to car details page
        String link = e.select("[data-ad-id]").attr("href").replaceAll("(https?://.*?)&.*", "$1");
        car.setLinkToDetails(link);
        // photos in gallery
        String photoQty = queryString(e, "span.numImages-display.u-text-white").replaceAll("[^0-9]", "");
        car.setPhotosQty(photoQty.length() > 0 ? Integer.valueOf(photoQty) : 0);
        //
        posterLink(e, car);
        Log.i("***", "" + link);
        carList.add(car);
    }

    private static void manMilePow(@NonNull Element e, Car car) {
        String[] arr = queryString(e, "div.g-col-12>div.rbt-regMilPow").split(",");
        for (String str : arr) {
            if (isEmpty(str)) continue;
            String s = str.toLowerCase();
            if (s.contains("ez")) {
                car.setManufactured(str.replaceAll("^EZ|ez", "").trim());
            } else if (s.contains("km")) {
                car.setMileage(str.trim());
            } else if (s.contains("kw") || s.contains("ps")) {
                car.setPower(str.trim());
            }
        }
    }

    private static void fuel(@NonNull Element e, Car car) {
        Elements elements = e.select("div.g-col-12>:not(div.rbt-regMilPow,div.g-row.u-margin-top-9)");
        elements.select("b").remove();
        String f = elements.text();
        String[] arr = f.replaceAll(", ,", ",").replaceAll(", ,", ",").split(",");
        if (arr.length > 1) car.setFuelType(arr[1]);
    }

    private static void sellerAddress(@NonNull Element e, Car car) {
        String[] sellerArr = queryString(e, "div.g-col-12 div.g-col-12").split(",");
        if (sellerArr.length > 0) car.setAddress(sellerArr[0].trim());
        if (sellerArr.length > 1) car.setSeller(sellerArr[1].trim());
    }

    private static void posterLink(@NonNull Element e, Car car) {
        Elements select = e.select("img.img-responsive");
        String src = select.attr("src");
        if (src.isEmpty()) src = select.attr("data-original");
        if (src.startsWith("/")) src = "http://" + src.replaceAll("^/+", "");
        if (src.contains("$_103.jpg")) src = src.replaceAll("\\$_103.jpg", "\\$_105.jpg");
        car.setPosterUrl(src);
    }

    private static void foundedCount(Element element) {
        String countStr = queryString(element, "h1.rbt-result-list-headline");
        countStr = countStr.replaceAll("(^[\\d.,]*).*", "$1").replaceAll("[,.]", "");
        if (countStr.isEmpty()) addCountResult(UNKNOWN);
        else addCountResult(Integer.valueOf(countStr));
    }
}

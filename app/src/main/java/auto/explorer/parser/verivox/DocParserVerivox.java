package auto.explorer.parser.verivox;

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
import static auto.explorer.parser.autoscout24.CallableAutoScout24.URL;
import static java.util.Arrays.asList;

/**
 * Created by Eugene on 27.11.2016
 */

final class DocParserVerivox extends BaseDocParser {

    @NonNull
    static ArrayList<Car> parseDoc(@NonNull Document document) {
        foundedCount(document);
        final ArrayList<Car> carList = new ArrayList<>();
        final Elements cards = document.select("div[data-total-count] .sc-grid-col-12");
        for (Element e : cards) if (e != null) addCar(carList, e);
        return carList;
    }

    private static void addCar(@NonNull ArrayList<Car> carList, @NonNull Element e) {
        final Car car = new Car(Const.SITE_AUTO_SCOUT_24);
        car.setTitle(queryString(e, ".title"));
        car.setEquip(queryString(e, ".sub-title"));
        car.setPrice(queryString(e, "div.details span[data-test=price][data-long]"));
        car.setManufactured(queryString(e, "span[data-test=firstRegistration]"));
        car.setMileage(queryString(e, "span[data-test=milage]"));
        car.setPower(queryString(e, "span[data-test=power]"));
        //
        final ArrayList<String> list = new ArrayList<>(asList(e.select(".envkv").text().split(",\\s")));
        car.setFuelType(list.size() > 1 ? list.remove(1) : "");
        //
        String seller = queryString(e, "div[data-item=companyName]");
        String address = queryString(e, "div[data-item=contact-person-address]");
        if (isEmpty(seller) && isEmpty(address)) {
            seller = queryString(e, "div[data-item=vendorType]");
            address = queryString(e, "div[data-item=vendorAddress]");
        }
        car.setSeller(seller);
        car.setAddress(address);
        //
        String link = e.select("a[data-item-name=detail-page-link]").attr("href").trim();
        car.setLinkToDetails(link.startsWith("/") ? URL + link : link);
        //
        String[] arr = e.select("div[role=indicator]").text().replaceAll("[^0-9/]", "").split("/");
        car.setPhotosQty(arr.length == 2 ? Integer.valueOf(arr[1]) : 0);
        //
        posterLink(e, car);
        Log.i("***", "" + link);
        carList.add(car);
    }

    private static void posterLink(@NonNull Element e, Car car) {
        Element el = e.select("img.sc-lazy-image, div.image-thumbnail").first();
        if (el != null) {
            String posterUrl = el.attr("src");
            if (posterUrl.isEmpty()) posterUrl = el.attr("style").replaceAll(".*\\((.*)\\).*", "$1").trim();
            if (!posterUrl.startsWith("http://") && !posterUrl.startsWith("https://")) posterUrl = "";
            car.setPosterUrl(posterUrl);
        }
    }

    private static void foundedCount(Element element) {
        String countStr = element.select("div[data-total-count]")
                .attr("data-total-count").replaceAll("[^0-9]", "").trim();
        if (countStr.isEmpty()) addCountResult(UNKNOWN);
        else addCountResult(Integer.valueOf(countStr));
    }
}

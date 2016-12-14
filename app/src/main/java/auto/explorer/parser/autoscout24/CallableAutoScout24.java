package auto.explorer.parser.autoscout24;

import android.support.annotation.NonNull;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

import auto.explorer.model.Car;
import auto.explorer.model.SearchProfile;
import auto.explorer.parser.RequestParserHelper;
import auto.explorer.util.Const;

import static android.text.TextUtils.isEmpty;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.carTypeCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.damagedCarsCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.extColorCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.fuelTypeCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.gearTypeCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.interiorEquipCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.landCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.providerCodes;
import static auto.explorer.parser.autoscout24.MapsAutoScout24.sortTypeCodes;
import static auto.explorer.util.Const.ALL;
import static auto.explorer.util.Const.PAGE_SIZE;
import static auto.explorer.util.Const.USER_AGENT;

/**
 * Created by Eugene on 19.10.2016
 */

public final class CallableAutoScout24 implements Callable<ArrayList<Car>> {

    public static final String URL = "https://www.autoscout24.de";
    private static final String SEARCH_SUFFIX = "/ergebnisse";

    private final SearchProfile p;
    private final String page;
    private final RequestParserHelper.TaskCompleteListener listener;
    private final Collection<Connection.KeyVal> queryMap = new ArrayList<>();

    public CallableAutoScout24(@NonNull SearchProfile profile, String page, RequestParserHelper.TaskCompleteListener listener) {
        this.p = profile;
        this.page = page;
        this.listener = listener;
    }

    @Override
    public ArrayList<Car> call() throws Exception {
        ArrayList<Car> cars = null;
        addParam("atype", "C");
        final String markCode = MapsAutoScout24.marksCarCodes.get(p.getMark());
        if (markCode != null && !markCode.equals(Const.ALL)) {
            addParam("mmvmk0", markCode);
            if (!p.getModel().equals(ALL)) {
                final String modelCode = MapsAutoScout24.getModelCode(p.getMark(), p.getModel());
                if (modelCode != null && !modelCode.equals(Const.ALL))
                    addParam("mmvmd0", modelCode);
                Log.i("***", "+++++++++++ model code " + modelCode);
            }
        }
        addParam("size", PAGE_SIZE);
        addParam("page", page);
        if (!p.getPriceFrom().equals(ALL)) addParam("pricefrom", p.getPriceFrom());
        if (!p.getPriceUntil().equals(ALL)) addParam("priceto", p.getPriceUntil());
        if (!p.getMileageFrom().equals(ALL)) addParam("kmfrom", p.getMileageFrom());
        if (!p.getMileageUntil().equals(ALL)) addParam("kmto", p.getMileageUntil());
        if (!p.getManFrom().equals(ALL)) addParam("fregfrom", p.getManFrom());
        if (!p.getManUntil().equals(ALL)) addParam("fregto", p.getManUntil());
        if (!p.getFuelType().equals(ALL)) queryFuel();
        if (!p.getGearType().equals(ALL)) queryGear();
        if (!p.getOwnerQty().equals(ALL)) queryOwnerQty();
        if (!p.getEcoClass().equals(ALL)) queryEcoClass();
        if (!p.getEcoFilter().equals(ALL)) queryEcoFilter();
        if (!p.getInteriorEquip().equals(ALL)) queryInteriorEquip();
        queryColors();
        queryCarType();
        if (!p.getLand().equals(ALL)) queryLand();
        queryPower();
        querySortType();
        queryDamagedCars();
        if (!p.getProvider().equals(ALL)) queryProvider();
        if (!p.getAdAge().equals(ALL)) queryAdAge();
        //
        if (p.isServiceBook()) addParam("eq", "49");
        if (p.isInspection()) addParam("eq", "120");
        if (p.isWithPhoto()) addParam("pic", "True");
        if (p.isWarranty()) addParam("eq", "37");
        if (p.isAllWheelDrive()) addParam("eq", "11");
        if (p.isParkAssistant()) addParam("eq", "40");
        if (p.isHeadUpDisplay()) addParam("eq", "123");
        if (p.isConditioner()) addParam("eq", "5");
        if (p.isNavSystem()) addParam("eq", "23");
        if (p.isSunRoof()) addParam("eq", "4");
        if (p.isSeatHeating()) addParam("eq", "34");
        if (p.isTrackingAssist()) addParam("eq", "31");
        if (p.isHeating()) addParam("eq", "52");
        if (p.isStartStopAuto()) addParam("eq", "113");
        try {
            Connection.Response response = Jsoup.connect(URL + SEARCH_SUFFIX).userAgent(USER_AGENT).data(queryMap)
                    .timeout(10000).ignoreHttpErrors(true).ignoreContentType(true).execute();
            Log.i("***", "Jsoup response " + response.url());
            Document document = Jsoup.parseBodyFragment(response.body());
            cars = DocParserAutoScout24.parseDoc(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (listener != null) listener.onTaskComplete();
        return cars;
    }

    private void addParam(@NonNull String key, @NonNull String value) {
        queryMap.add(HttpConnection.KeyVal.create(key, value));
    }

    private void queryColors() {
        if (p.isMetallic()) addParam("ptype", "M");
        final ArrayList<String> extColors = p.getExtColors();
        for (String color : extColors) {
            Log.i("***", "color " + color);
            final String value = extColorCodes.get(color);
            if (!isEmpty(value)) addParam("bcol", value);
        }
    }

    private void queryCarType() {
        final ArrayList<String> carTypes = p.getCarTypes();
        for (String type : carTypes) {
            final String value = carTypeCodes.get(type);
            Log.i("***", "type " + type + "\t" + value);
            if (!isEmpty(value)) addParam("body", value);
        }
    }

    private void queryPower() {
        boolean requestPower = false;
        if (!p.getPowerFrom().equals(ALL)) {
            int pow = Math.round(Integer.valueOf(p.getPowerFrom()) * 0.7355f);
            addParam("powerfrom", String.valueOf(pow));
            requestPower = true;
        }
        if (!p.getPowerUntil().equals(ALL)) {
            int pow = Math.round(Integer.valueOf(p.getPowerUntil()) * 0.7355f);
            addParam("powerto", String.valueOf(pow));
            requestPower = true;
        }
        if (requestPower) addParam("powertype", "hp");
    }

    private void queryLand() {
        final String value = landCodes.get(p.getLand());
        if (!isEmpty(value)) addParam("cy", value);
    }

    private void queryFuel() {
        final String value = fuelTypeCodes.get(p.getFuelType());
        if (!isEmpty(value)) addParam("fuel", value);
    }

    private void queryGear() {
        final String value = gearTypeCodes.get(p.getGearType());
        if (!isEmpty(value)) addParam("gear", value);
    }

    private void queryOwnerQty() {
        final String value = p.getOwnerQty().replaceAll("[^0-9]", "");
        if (!isEmpty(value)) addParam("prevownersid", value);
    }

    private void queryEcoClass() {
        final String value = p.getEcoClass().replaceAll("[^0-9]", "");
        if (!isEmpty(value)) addParam("emclass", value);
    }

    private void queryInteriorEquip() {
        final String value = interiorEquipCodes.get(p.getInteriorEquip());
        if (!isEmpty(value)) addParam("uph", value);
    }

    private void queryEcoFilter() {
        addParam("ensticker", p.getEcoFilter());
    }

    private void queryDamagedCars() {
        addParam("ustate", damagedCarsCodes.get(p.getDamagedCars()));
    }

    private void queryProvider() {
        addParam("custtype", providerCodes.get(p.getProvider()));
    }

    private void queryAdAge() {
        final String value = p.getAdAge().replaceAll("[^0-9]", "");
        if (!isEmpty(value)) addParam("adage", value);
    }

    private void querySortType() {
        final String value = sortTypeCodes.get(p.getSortType());
        if (!isEmpty(value)) {
            final String[] arr = value.split("[&=]");
            addParam("sort", arr[0]);
            if (arr.length == 3) addParam("desc", "1");
        }
    }
}
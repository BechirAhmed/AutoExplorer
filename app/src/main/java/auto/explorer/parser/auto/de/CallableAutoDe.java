package auto.explorer.parser.auto.de;

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
import static auto.explorer.parser.auto.de.MapsAutoDe.carTypeCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.damagedCarsCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.extColorCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.fuelTypeCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.gearTypeCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.interiorEquipCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.landCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.providerCodes;
import static auto.explorer.parser.auto.de.MapsAutoDe.sortTypeCodes;
import static auto.explorer.util.Const.ALL;
import static auto.explorer.util.Const.USER_AGENT;

/**
 * Created by Eugene on 19.10.2016
 */

public final class CallableAutoDe implements Callable<ArrayList<Car>> {

    private static final String URL = "http://www.auto.de/search/findoffer";

    private final SearchProfile p;
    private final String page;
    private final RequestParserHelper.TaskCompleteListener listener;
    private final Collection<Connection.KeyVal> queryMap = new ArrayList<>();

    public CallableAutoDe(@NonNull SearchProfile profile, String page, RequestParserHelper.TaskCompleteListener listener) {
        this.p = profile;
        this.page = page;
        this.listener = listener;
    }

    @Override
    public ArrayList<Car> call() throws Exception {
        ArrayList<Car> cars = null;
//        addParam("scopeId", "C");
//        addParam("isSearchRequest", "true");
        final String markCode = MapsAutoDe.marksCarCodes.get(p.getMark());
        if (markCode != null && !markCode.equals(Const.ALL)) {
            addParam("sci[]", markCode);
            if (!p.getModel().equals(ALL)) {
                final String modelCode = MapsAutoDe.getModelCode(p.getMark(), p.getModel());
                if (modelCode != null && !modelCode.equals(Const.ALL))
                    addParam("spi[]", modelCode);
                Log.i("***", "+++++++++++ model code " + modelCode);
            }
        }
        addParam("pageNumber", page);
        if (!p.getPriceFrom().equals(ALL)) addParam("minPrice", p.getPriceFrom());
        if (!p.getPriceUntil().equals(ALL)) addParam("maxPrice", p.getPriceUntil());
        if (!p.getMileageFrom().equals(ALL)) addParam("minMileage", p.getMileageFrom());
        if (!p.getMileageUntil().equals(ALL)) addParam("maxMileage", p.getMileageUntil());
        if (!p.getManFrom().equals(ALL))
            addParam("minFirstRegistrationDate", p.getManFrom() + "-01-01");
        if (!p.getManUntil().equals(ALL))
            addParam("maxFirstRegistrationDate", p.getManUntil() + "-12-31");
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
        if (p.isServiceBook()) addParam("features", "FULL_SERVICE_HISTORY");
        if (p.isInspection()) addParam("minHu", "0");
        if (p.isWithPhoto()) addParam("withImage", "true");
        if (p.isWarranty()) addParam("features", "WARRANTY");
        if (p.isAllWheelDrive()) addParam("features", "FOUR_WHEEL_DRIVE");
        if (p.isParkAssistant()) {
            addParam("parkAssistents", "REAR_SENSORS");
            addParam("parkAssistents", "FRONT_SENSORS");
            addParam("parkAssistents", "REAR_VIEW_CAM");
        }
        if (p.isHeadUpDisplay()) addParam("features", "HEAD_UP_DISPLAY");
        if (p.isConditioner()) addParam("climatisation", "MANUAL_OR_AUTOMATIC_CLIMATISATION");
        if (p.isNavSystem()) addParam("features", "NAVIGATION_SYSTEM");
        if (p.isSunRoof()) addParam("features", "SUNROOF");
        if (p.isSeatHeating()) addParam("features", "ELECTRIC_HEATED_SEATS");
        if (p.isTrackingAssist()) addParam("features", "LANE_DEPARTURE_WARNING");
        if (p.isHeating()) addParam("features", "AUXILIARY_HEATING");
        if (p.isStartStopAuto()) addParam("features", "START_STOP_SYSTEM");
        try {
            Connection.Response response = Jsoup.connect(URL).userAgent(USER_AGENT).data(queryMap)
                    .timeout(10000).ignoreHttpErrors(true).ignoreContentType(true).execute();
            Log.i("***", "Jsoup response " + response.url());
            Document document = Jsoup.parseBodyFragment(response.body());
            cars = DocParserAutoDe.parseDoc(document);
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
        if (p.isMetallic()) addParam("features", "METALLIC");
        final ArrayList<String> extColors = p.getExtColors();
        for (String color : extColors) {
            Log.i("***", "color " + color);
            final String value = extColorCodes.get(color);
            if (!isEmpty(value)) addParam("colors", value);
        }
    }

    private void queryCarType() {
        final ArrayList<String> carTypes = p.getCarTypes();
        for (String type : carTypes) {
            final String value = carTypeCodes.get(type);
            Log.i("***", "type " + type + "\t" + value);
            if (!isEmpty(value)) addParam("categories", value);
        }
    }

    private void queryPower() {
        if (!p.getPowerFrom().equals(ALL)) {
            addParam("minPowerAsArray", p.getPowerFrom());
        }
        if (!p.getPowerUntil().equals(ALL)) {
            addParam("maxPowerAsArray", p.getPowerUntil());
        }
        addParam("minPowerAsArray", "PS");
        addParam("maxPowerAsArray", "PS");
    }

    private void queryLand() {
        final String value = landCodes.get(p.getLand());
        if (!isEmpty(value)) addParam("cn", value);
    }

    private void queryFuel() {
        final String value = fuelTypeCodes.get(p.getFuelType());
        if (!isEmpty(value)) addParam("fuels", value);
    }

    private void queryGear() {
        final String value = gearTypeCodes.get(p.getGearType());
        if (!isEmpty(value)) addParam("transmissions", value);
    }

    private void queryOwnerQty() {
        final String value = p.getOwnerQty().replaceAll("[^0-9]", "");
        if (!isEmpty(value)) addParam("numberOfPreviousOwners", value);
    }

    private void queryEcoClass() {
        final String value = p.getEcoClass().replaceAll("[^0-9]", "");
        if (!isEmpty(value)) addParam("emissionClass", "EURO" + value);
    }

    private void queryInteriorEquip() {
        final String value = interiorEquipCodes.get(p.getInteriorEquip());
        if (!isEmpty(value)) addParam("uph", value);
    }

    private void queryEcoFilter() {
        switch (p.getEcoFilter()) {
            case "2":
                addParam("emissionsSticker", "EMISSIONSSTICKER_RED");
                break;
            case "3":
                addParam("emissionsSticker", "EMISSIONSSTICKER_YELLOW");
                break;
            case "4":
                addParam("emissionsSticker", "EMISSIONSSTICKER_GREEN");
                break;
        }
    }

    private void queryDamagedCars() {
        addParam("damageUnrepaired", damagedCarsCodes.get(p.getDamagedCars()));
    }

    private void queryProvider() {
        addParam("adLimitation", providerCodes.get(p.getProvider()));
    }

    private void queryAdAge() {
        final String value = p.getAdAge().replaceAll("[^0-9]", "");
        if (!isEmpty(value)) addParam("daysAfterCreation", value);
    }

    private void querySortType() {
        final String value = sortTypeCodes.get(p.getSortType());
        if (!isEmpty(value)) {
            final String[] arr = value.split("[&=]");
            addParam("sortOption.sortBy", arr[0]);
            if (arr.length == 3) addParam(arr[1], arr[2]);
        }
    }
}
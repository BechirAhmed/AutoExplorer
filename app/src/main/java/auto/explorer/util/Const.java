package auto.explorer.util;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import auto.explorer.model.Car;
import auto.explorer.model.SearchProfile;

public final class Const {
    public static final String ALL = "Alle";
    public static final String PAGE_SIZE = "20";
    public static final int SPINNER_MAX_DROP_DOWN_ITEMS = 7;
    public static final int[] textStyleAttr = {android.R.attr.textStyle};
    //
//    public static final GenericTypeIndicator<HashMap<String, ArrayList<String>>> hashMapType = new GenericTypeIndicator<HashMap<String, ArrayList<String>>>() {
//    };
//    public static final GenericTypeIndicator<ArrayList<String>> arrListType = new GenericTypeIndicator<ArrayList<String>>() {
//    };
    public static final Type carListTypeToken = new TypeToken<ArrayList<Car>>() {
    }.getType();
    public static final Type profilesListTypeToken = new TypeToken<ArrayList<SearchProfile>>() {
    }.getType();
    //
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0";
    public static final int PARSERS_QTY = 3;
    public static final int NOT_EXIST = -1;
    //
    public static final String CAR_POS_IN_LIST = "CAR_POS_IN_LIST";
    public static final String GET_FROM_FAV = "GET_FROM_FAV";

    // fragment tags
    public static final String SEARCH_FRAGMENT = "SEARCH_FRAGMENT";
    public static final String CARDS_FRAGMENT = "CARDS_FRAGMENT";
    public static final String DETAILS_FRAGMENT = "DETAILS_FRAGMENT";
    public static final String FAV_FRAGMENT = "FAV_FRAGMENT";
    public static final String PROFILES_FRAGMENT = "PROFILES_FRAGMENT";
    public static final String SETTINGS_FRAGMENT = "SETTINGS_FRAGMENT";

    // Car origin sites
    public static final String SITE_AUTO_SCOUT_24 = "SITE_AUTO_SCOUT_24";
    public static final String SITE_MOBILE_DE= "SITE_MOBILE_DE";
    public static final String SITE_AUTO_DE= "SITE_AUTO_DE";
    public static final String SITE_VERIVOX= "SITE_VERIVOX";

    // PREFS NAMES
    public static final String PREFS_NAME = "SNIPER_PREFS";
    public static final String PREF_FAV_LIST = "PREF_FAV_LIST";
    public static final String PREF_PROFILES_LIST = "PREF_PROFILES_LIST";
    public static final String PREF_SETTINGS = "PREF_SETTINGS";
}

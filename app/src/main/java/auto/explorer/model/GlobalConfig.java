package auto.explorer.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import auto.explorer.R;
import auto.explorer.SplashActivity;
import auto.explorer.util.Util;

import static auto.explorer.util.Const.ALL;

/**
 * Created by Eugene on 15.10.2016
 */

public class GlobalConfig {

    public Map<String, ArrayList<String>> autoMap = new HashMap<>();

    @SerializedName("FuelType")
    public ArrayList<String> fuelList = new ArrayList<>();
    @SerializedName("Manufactured")
    public ArrayList<String> manList = new ArrayList<>();
    @SerializedName("Mileage")
    public ArrayList<String> mileageList = new ArrayList<>();
    @SerializedName("Gear")
    public ArrayList<String> gearList = new ArrayList<>();
    @SerializedName("PowerFrom")
    public ArrayList<String> powerFromList = new ArrayList<>();
    @SerializedName("PowerUntil")
    public ArrayList<String> powerUntilList = new ArrayList<>();
    @SerializedName("ExteriorColor")
    public ArrayList<String> extColorList = new ArrayList<>();
    @SerializedName("Price")
    public ArrayList<String> priceList = new ArrayList<>();
    @SerializedName("Land")
    public ArrayList<String> landList = new ArrayList<>();
    @SerializedName("PLZ")
    public ArrayList<String> plzList = new ArrayList<>();
    @SerializedName("Radius")
    public ArrayList<String> radiusList = new ArrayList<>();
    public ArrayList<String> carTypeList = new ArrayList<>();
    @SerializedName("OwnerQty")
    public ArrayList<String> ownerQtyList = new ArrayList<>();
    @SerializedName("EcoClass")
    public ArrayList<String> ecoClassList = new ArrayList<>();
    public ArrayList<String> damagedCarList = new ArrayList<>();
    public ArrayList<String> ecoFilterList = new ArrayList<>();
    public ArrayList<String> providerList = new ArrayList<>();
    @SerializedName("AdAge")
    public ArrayList<String> adAgeList = new ArrayList<>();
    public ArrayList<String> interiorEquip = new ArrayList<>();
    public ArrayList<String> sortType = new ArrayList<>();
    //
    public static GlobalConfig instance;

    public static GlobalConfig getInstance() {
        return instance;
    }

    public GlobalConfig() {
    }

    private void fill() {
        initMarkModels();
        fillAndSort(fuelList);
        initManufactured();
        fillAndSort(mileageList);
        fillAndSort(gearList);
        fillAndSort(powerFromList);
        fillAndSort(powerUntilList);
        fillAndSort(extColorList);
        fillAndSort(priceList);
        fillAndSort(landList);
        fillAndSort(plzList);
        fillAndSort(radiusList);
        fillAndSort(ownerQtyList);
        fillAndSort(ecoClassList);
        fillAndSort(adAgeList);
        initDamagedCar();
        initCarType();
        initEcoFilter();
        initProvider();
        initInteriorEquip();
        initSortList();
    }

    public ArrayList<String> getMarks() {
        final ArrayList<String> marks = new ArrayList<>();
        marks.addAll(getInstance().autoMap.keySet());
        Util.sort(marks);
        marks.remove(ALL);
        marks.add(0, ALL);
        return marks;
    }

    public static void init(SplashActivity context) {
        final InputStream is = context.getResources().openRawResource(R.raw.spinners);
        final Reader reader = new InputStreamReader(is);
        instance = new Gson().fromJson(reader, GlobalConfig.class);
        instance.fill();
        context.onGlobalConfigCreated();
    }

    private void initManufactured() {
        fillAndSort(manList);
        final String all = manList.remove(0);
        Collections.reverse(manList);
        manList.add(0, all);
    }

    private void initMarkModels() {
        final Set<String> keySet = autoMap.keySet();
        for (String s : keySet) {
            if (s.equals(ALL)) continue;
            ArrayList<String> list = autoMap.get(s);
            Util.sort(list);
            list.add(0, ALL);
        }
    }

    private static void fillAndSort(ArrayList<String> list) {
        Util.sort(list);
        list.add(0, ALL);
    }

    private void initDamagedCar() {
        damagedCarList.add("Nicht anzeigen");
        damagedCarList.add("Nur anzeigen");
        damagedCarList.add("Auch anzeigen");
    }

    private void initEcoFilter() {
        ecoFilterList.add(ALL);
        ecoFilterList.add("4");
        ecoFilterList.add("3");
        ecoFilterList.add("2");
    }

    private void initProvider() {
        providerList.add(ALL);
        providerList.add("Händler");
        providerList.add("Privat");
    }

    private void initCarType() {
        carTypeList.add("Kleinwagen");
        carTypeList.add("Cabrio");
        carTypeList.add("Coupé");
        carTypeList.add("SUV/Geländewagen");
        carTypeList.add("Limousine");
        carTypeList.add("Kombi");
        carTypeList.add("Transporter");
        carTypeList.add("Van/Kleinbus");
    }

    private void initInteriorEquip() {
        interiorEquip.add(ALL);
        interiorEquip.add("Alcantara");
        interiorEquip.add("Vollleder");
        interiorEquip.add("Teilleder");
        interiorEquip.add("Stoff");
        interiorEquip.add("Velours");
    }

    private void initSortList() {
        sortType.add("Standard");
        sortType.add("Preis aufsteigend");
        sortType.add("Preis absteigend");
        sortType.add("Neueste Angebote zuerst");
        sortType.add("Kilometerstand aufsteigend");
        sortType.add("Kilometerstand absteigend");
        sortType.add("Erstzulassung aufsteigend");
        sortType.add("Erstzulassung absteigend");
    }
}

package auto.explorer.model;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;

import static auto.explorer.util.Const.ALL;

/**
 * Created by Eugene on 15.10.2016
 */

public class SearchProfile {

    private String mark = ALL;
    private String model = ALL;
    private String priceFrom = ALL;
    private String priceUntil = ALL;
    private String manFrom = ALL;
    private String manUntil = ALL;
    private String mileageFrom = ALL;
    private String mileageUntil = ALL;
    private String fuelType = ALL;
    private String gearType = ALL;
    private String powerFrom = ALL;
    private String powerUntil = ALL;
    private ArrayList<String> extColors = new ArrayList<>();
    private ArrayList<String> carTypes = new ArrayList<>();
    private boolean metallic;
    private String land = ALL;
    private String plz = ALL;
    private String radius = ALL;
    private String ownerQty = ALL;
    private String ecoClass = ALL;
    private String damagedCars = "Nicht anzeigen";
    private String ecoFilter = ALL;
    private String provider = ALL;
    private String adAge = ALL;
    private String interiorEquip = ALL;
    // checkers
    private boolean serviceBook;
    private boolean inspection;
    private boolean withPhoto;
    private boolean warranty;
    private boolean allWheelDrive;
    private boolean parkAssistant;
    private boolean headUpDisplay;
    private boolean conditioner;
    private boolean navSystem;
    private boolean sunRoof;
    private boolean seatHeating;
    private boolean trackingAssist;
    private boolean heating;
    private boolean startStopAuto;
    //
    private String sortType = "Standard";

    public SearchProfile() {
    }

    public static final SearchProfile DEFAULT = new SearchProfile();

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getManFrom() {
        return manFrom;
    }

    public String getManUntil() {
        return manUntil;
    }

    public void setManFrom(String manFrom) {
        this.manFrom = manFrom;
    }

    public void setManUntil(String manUntil) {
        this.manUntil = manUntil;
    }

    public String getMileageFrom() {
        return mileageFrom;
    }

    public void setMileageFrom(String mileageFrom) {
        this.mileageFrom = mileageFrom;
    }

    public String getMileageUntil() {
        return mileageUntil;
    }

    public void setMileageUntil(String mileageUntil) {
        this.mileageUntil = mileageUntil;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getPowerFrom() {
        return powerFrom;
    }

    public void setPowerFrom(String powerFrom) {
        this.powerFrom = powerFrom;
    }

    public String getPowerUntil() {
        return powerUntil;
    }

    public void setPowerUntil(String powerUntil) {
        this.powerUntil = powerUntil;
    }

    public boolean isMetallic() {
        return metallic;
    }

    public void setMetallic(boolean metallic) {
        this.metallic = metallic;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceUntil() {
        return priceUntil;
    }

    public void setPriceUntil(String priceUntil) {
        this.priceUntil = priceUntil;
    }

    public String getPlz() {
        return plz;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public ArrayList<String> getExtColors() {
        return extColors;
    }

    public String getOwnerQty() {
        return ownerQty;
    }

    public void setOwnerQty(String ownerQty) {
        this.ownerQty = ownerQty;
    }

    public String getEcoClass() {
        return ecoClass;
    }

    public void setEcoClass(String ecoClass) {
        this.ecoClass = ecoClass;
    }

    public String getDamagedCars() {
        return damagedCars;
    }

    public void setDamagedCars(String damagedCars) {
        this.damagedCars = damagedCars;
    }

    public String getEcoFilter() {
        return ecoFilter;
    }

    public void setEcoFilter(String ecoFilter) {
        this.ecoFilter = ecoFilter;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAdAge() {
        return adAge;
    }

    public void setAdAge(String adAge) {
        this.adAge = adAge;
    }

    public ArrayList<String> getCarTypes() {
        return carTypes;
    }

    public boolean isServiceBook() {
        return serviceBook;
    }

    public void setServiceBook(boolean serviceBook) {
        this.serviceBook = serviceBook;
    }

    public boolean isInspection() {
        return inspection;
    }

    public void setInspection(boolean inspection) {
        this.inspection = inspection;
    }

    public void setWithPhoto(boolean withPhoto) {
        this.withPhoto = withPhoto;
    }

    public void setExtColors(ArrayList<String> extColors) {
        this.extColors = extColors;
    }

    public void setCarTypes(ArrayList<String> carTypes) {
        this.carTypes = carTypes;
    }

    public boolean isWithPhoto() {
        return withPhoto;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public boolean isAllWheelDrive() {
        return allWheelDrive;
    }

    public void setAllWheelDrive(boolean allWheelDrive) {
        this.allWheelDrive = allWheelDrive;
    }

    public boolean isParkAssistant() {
        return parkAssistant;
    }

    public void setParkAssistant(boolean parkAssistant) {
        this.parkAssistant = parkAssistant;
    }

    public boolean isHeadUpDisplay() {
        return headUpDisplay;
    }

    public void setHeadUpDisplay(boolean headUpDisplay) {
        this.headUpDisplay = headUpDisplay;
    }

    public String getInteriorEquip() {
        return interiorEquip;
    }

    public void setInteriorEquip(String interiorEquip) {
        this.interiorEquip = interiorEquip;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public boolean isNavSystem() {
        return navSystem;
    }

    public void setNavSystem(boolean navSystem) {
        this.navSystem = navSystem;
    }

    public boolean isSunRoof() {
        return sunRoof;
    }

    public void setSunRoof(boolean sunRoof) {
        this.sunRoof = sunRoof;
    }

    public boolean isSeatHeating() {
        return seatHeating;
    }

    public void setSeatHeating(boolean seatHeating) {
        this.seatHeating = seatHeating;
    }

    public boolean isTrackingAssist() {
        return trackingAssist;
    }

    public void setTrackingAssist(boolean trackingAssist) {
        this.trackingAssist = trackingAssist;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean isStartStopAuto() {
        return startStopAuto;
    }

    public void setStartStopAuto(boolean startStopAuto) {
        this.startStopAuto = startStopAuto;
    }

    public static SearchProfile getDeepClone(@NonNull SearchProfile source) {
        final Gson gson = new Gson();
        return gson.fromJson(gson.toJson(source), SearchProfile.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchProfile that = (SearchProfile) o;
        return metallic == that.metallic && serviceBook == that.serviceBook
                && inspection == that.inspection && withPhoto == that.withPhoto
                && warranty == that.warranty && allWheelDrive == that.allWheelDrive
                && parkAssistant == that.parkAssistant && headUpDisplay == that.headUpDisplay
                && conditioner == that.conditioner && navSystem == that.navSystem
                && sunRoof == that.sunRoof && seatHeating == that.seatHeating
                && trackingAssist == that.trackingAssist && heating == that.heating
                && startStopAuto == that.startStopAuto && mark.equals(that.mark)
                && model.equals(that.model) && priceFrom.equals(that.priceFrom)
                && priceUntil.equals(that.priceUntil) && manFrom.equals(that.manFrom)
                && manUntil.equals(that.manUntil) && mileageFrom.equals(that.mileageFrom)
                && mileageUntil.equals(that.mileageUntil) && fuelType.equals(that.fuelType)
                && gearType.equals(that.gearType) && powerFrom.equals(that.powerFrom)
                && powerUntil.equals(that.powerUntil) && extColors.equals(that.extColors)
                && carTypes.equals(that.carTypes) && land.equals(that.land) && plz.equals(that.plz)
                && radius.equals(that.radius) && ownerQty.equals(that.ownerQty)
                && ecoClass.equals(that.ecoClass) && damagedCars.equals(that.damagedCars)
                && ecoFilter.equals(that.ecoFilter) && provider.equals(that.provider)
                && adAge.equals(that.adAge) && interiorEquip.equals(that.interiorEquip) && sortType.equals(that.sortType);
    }

    @Override
    public int hashCode() {
        int result = mark.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + priceFrom.hashCode();
        result = 31 * result + priceUntil.hashCode();
        result = 31 * result + manFrom.hashCode();
        result = 31 * result + manUntil.hashCode();
        result = 31 * result + mileageFrom.hashCode();
        result = 31 * result + mileageUntil.hashCode();
        result = 31 * result + fuelType.hashCode();
        result = 31 * result + gearType.hashCode();
        result = 31 * result + powerFrom.hashCode();
        result = 31 * result + powerUntil.hashCode();
        result = 31 * result + extColors.hashCode();
        result = 31 * result + carTypes.hashCode();
        result = 31 * result + (metallic ? 1 : 0);
        result = 31 * result + land.hashCode();
        result = 31 * result + plz.hashCode();
        result = 31 * result + radius.hashCode();
        result = 31 * result + ownerQty.hashCode();
        result = 31 * result + ecoClass.hashCode();
        result = 31 * result + damagedCars.hashCode();
        result = 31 * result + ecoFilter.hashCode();
        result = 31 * result + provider.hashCode();
        result = 31 * result + adAge.hashCode();
        result = 31 * result + interiorEquip.hashCode();
        result = 31 * result + (serviceBook ? 1 : 0);
        result = 31 * result + (inspection ? 1 : 0);
        result = 31 * result + (withPhoto ? 1 : 0);
        result = 31 * result + (warranty ? 1 : 0);
        result = 31 * result + (allWheelDrive ? 1 : 0);
        result = 31 * result + (parkAssistant ? 1 : 0);
        result = 31 * result + (headUpDisplay ? 1 : 0);
        result = 31 * result + (conditioner ? 1 : 0);
        result = 31 * result + (navSystem ? 1 : 0);
        result = 31 * result + (sunRoof ? 1 : 0);
        result = 31 * result + (seatHeating ? 1 : 0);
        result = 31 * result + (trackingAssist ? 1 : 0);
        result = 31 * result + (heating ? 1 : 0);
        result = 31 * result + (startStopAuto ? 1 : 0);
        result = 31 * result + sortType.hashCode();
        return result;
    }

    public static void copy(SearchProfile from, SearchProfile to) {
        to.mark = from.mark;
        to.model = from.model;
        to.priceFrom = from.priceFrom;
        to.priceUntil = from.priceUntil;
        to.manFrom = from.manUntil;
        to.manUntil = from.manFrom;
        to.mileageFrom = from.mileageFrom;
        to.mileageUntil = from.mileageUntil;
        to.fuelType = from.fuelType;
        to.gearType = from.gearType;
        to.powerFrom = from.powerFrom;
        to.powerUntil = from.powerUntil;
        to.extColors.clear();
        to.extColors.addAll(from.getExtColors());
        to.carTypes.clear();
        to.carTypes.addAll(from.getCarTypes());
        to.metallic = from.metallic;
        to.land = from.land;
        to.plz = from.plz;
        to.radius = from.radius;
        to.ownerQty = from.ownerQty;
        to.ecoClass = from.ecoClass;
        to.damagedCars = from.damagedCars;
        to.ecoFilter = from.ecoFilter;
        to.provider = from.provider;
        to.adAge = from.adAge;
        to.interiorEquip = from.interiorEquip;
        //
        to.serviceBook = from.serviceBook;
        to.inspection = from.inspection;
        to.withPhoto = from.withPhoto;
        to.warranty = from.warranty;
        to.allWheelDrive = from.allWheelDrive;
        to.parkAssistant = from.parkAssistant;
        to.headUpDisplay = from.headUpDisplay;
        to.conditioner = from.conditioner;
        to.navSystem = from.navSystem;
        to.sunRoof = from.sunRoof;
        to.seatHeating = from.seatHeating;
        to.trackingAssist = from.trackingAssist;
        to.heating = from.heating;
        to.startStopAuto = from.startStopAuto;
        //
        to.sortType = from.sortType;
    }
}
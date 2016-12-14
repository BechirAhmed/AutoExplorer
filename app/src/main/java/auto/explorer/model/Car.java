package auto.explorer.model;

/**
 * Created by Eugene on 15.10.2016
 */

import java.util.ArrayList;

public class Car {

    private final String origin;
    private String title;
    private String price;
    private String manufactured;
    private String mileage;
    private String power;
    private String fuelType;
    private String equip;
    private String seller;
    private String address;
    private String linkToDetails = "";
    private String posterUrl;
    private int photosQty;
    private final ArrayList<String> photos = new ArrayList<>();
    //
    private final ArrayList<String> detailConsumption = new ArrayList<>();
    private transient String detailGear;
    private transient String detailOwner;
    private transient String detailExtColor;
    private transient String detailSellerName;
    private transient String detailSellerPhone;
    private transient String detailSellerAddress;
    private final ArrayList<String> detailEquipment = new ArrayList<>();
    private transient String detailDescription;

    public Car(String origin) {
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = trim(title);
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = trim(equip);
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = trim(fuelType);
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = trim(manufactured);
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = trim(mileage);
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = trim(power);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = trim(price);
    }

    public String getLinkToDetails() {
        return linkToDetails;
    }

    public void setLinkToDetails(String linkToDetails) {
        this.linkToDetails = trim(linkToDetails);
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = trim(posterUrl);
    }

    private static String trim(String s) {
        return s == null ? null : s.trim();
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public String getOrigin() {
        return origin;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhotosQty() {
        return photosQty;
    }

    public void setPhotosQty(int photos) {
        this.photosQty = photos;
    }

    public ArrayList<String> getDetailConsumption() {
        return detailConsumption;
    }

    public String getDetailGear() {
        return detailGear;
    }

    public void setDetailGear(String detailGear) {
        this.detailGear = detailGear;
    }

    public String getDetailOwner() {
        return detailOwner;
    }

    public void setDetailOwner(String detailOwner) {
        this.detailOwner = detailOwner;
    }

    public String getDetailExtColor() {
        return detailExtColor;
    }

    public void setDetailExtColor(String detailExtColor) {
        this.detailExtColor = detailExtColor;
    }

    public String getDetailSellerName() {
        return detailSellerName;
    }

    public void setDetailSellerName(String detailSellerName) {
        this.detailSellerName = detailSellerName;
    }

    public String getDetailSellerPhone() {
        return detailSellerPhone;
    }

    public void setDetailSellerPhone(String detailSellerPhone) {
        this.detailSellerPhone = detailSellerPhone;
    }

    public String getDetailSellerAddress() {
        return detailSellerAddress;
    }

    public void setDetailSellerAddress(String detailSellerAddress) {
        this.detailSellerAddress = detailSellerAddress;
    }

    public ArrayList<String> getDetailEquipment() {
        return detailEquipment;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }
}
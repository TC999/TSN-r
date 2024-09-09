package xyz.adscope.amps.report.model.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdModel {
    private String accessType;
    private String adSdkVersion;
    private String adType;
    private String bidType;
    private String expPrice;
    private String floorPrice;
    private String loadType;
    private String maxWaitTime;
    private String quantity;

    public AdModel() {
        this.accessType = "";
        this.adSdkVersion = "";
        this.loadType = "";
        this.bidType = "";
        this.maxWaitTime = "";
        this.adType = "";
        this.floorPrice = "";
        this.quantity = "";
        this.expPrice = "";
    }

    public String getAccessType() {
        return this.accessType;
    }

    public String getAdSdkVersion() {
        return this.adSdkVersion;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getBidType() {
        return this.bidType;
    }

    public String getExpPrice() {
        return this.expPrice;
    }

    public String getFloorPrice() {
        return this.floorPrice;
    }

    public String getLoadType() {
        return this.loadType;
    }

    public String getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setAccessType(String str) {
        this.accessType = str;
    }

    public void setAdSdkVersion(String str) {
        this.adSdkVersion = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setBidType(String str) {
        this.bidType = str;
    }

    public void setExpPrice(String str) {
        this.expPrice = str;
    }

    public void setFloorPrice(String str) {
        this.floorPrice = str;
    }

    public void setLoadType(String str) {
        this.loadType = str;
    }

    public void setMaxWaitTime(String str) {
        this.maxWaitTime = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public String toString() {
        return "{\"accessType\":\"" + this.accessType + "\", \"adSdkVersion\":\"" + this.adSdkVersion + "\", \"loadType\":\"" + this.loadType + "\", \"bidType\":\"" + this.bidType + "\", \"maxWaitTime\":\"" + this.maxWaitTime + "\", \"adType\":\"" + this.adType + "\", \"floorPrice\":\"" + this.floorPrice + "\", \"quantity\":\"" + this.quantity + "\", \"expPrice\":\"" + this.expPrice + "\"}";
    }

    public AdModel(AdModel adModel) {
        this.accessType = "";
        this.adSdkVersion = "";
        this.loadType = "";
        this.bidType = "";
        this.maxWaitTime = "";
        this.adType = "";
        this.floorPrice = "";
        this.quantity = "";
        this.expPrice = "";
        this.accessType = adModel.getAccessType();
        this.adSdkVersion = adModel.getAdSdkVersion();
        this.loadType = adModel.getLoadType();
        this.bidType = adModel.getBidType();
        this.maxWaitTime = adModel.getMaxWaitTime();
        this.adType = adModel.getAdType();
        this.floorPrice = adModel.getFloorPrice();
        this.quantity = adModel.getQuantity();
        this.expPrice = adModel.getExpPrice();
    }
}

package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RequestUrlModel {
    private String adUrl;
    private String carshUrl;
    private String configUrl;

    public String getAdUrl() {
        return this.adUrl;
    }

    public String getCarshUrl() {
        return this.carshUrl;
    }

    public String getConfigUrl() {
        return this.configUrl;
    }

    public void setAdUrl(String str) {
        this.adUrl = str;
    }

    public void setCarshUrl(String str) {
        this.carshUrl = str;
    }

    public void setConfigUrl(String str) {
        this.configUrl = str;
    }

    public String toString() {
        return "{\"configUrl\":\"" + this.configUrl + "\", \"adUrl\":\"" + this.adUrl + "\", \"carshUrl\":\"" + this.carshUrl + "\"}";
    }
}

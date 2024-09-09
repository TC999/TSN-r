package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CrashModel {
    private String crashUrl;

    public String getCrashUrl() {
        return this.crashUrl;
    }

    public void setCrashUrl(String str) {
        this.crashUrl = str;
    }

    public String toString() {
        return "{\"crashUrl\":\"" + this.crashUrl + "\"}";
    }
}

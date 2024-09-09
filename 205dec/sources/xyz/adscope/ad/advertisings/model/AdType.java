package xyz.adscope.ad.advertisings.model;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public enum AdType {
    SPLASH("splash", 1),
    INTERSTITIAL("interstitial", 2),
    NATIVE("nativeExpress", 3),
    BANNER("banner", 4),
    REWARDEDVIDEO("rewardVideo", 5),
    PREFETCH("prefetch", 6);
    
    private int code;
    private String value;

    AdType(String str, int i4) {
        this.value = str;
        this.code = i4;
    }

    public int getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}

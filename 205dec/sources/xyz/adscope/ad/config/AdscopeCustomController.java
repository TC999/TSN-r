package xyz.adscope.ad.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AdscopeCustomController {
    public String getOaid() {
        return "";
    }

    public int getTagForUnderAgeOfConsent() {
        return -1;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isSupportPersonalized() {
        return true;
    }
}

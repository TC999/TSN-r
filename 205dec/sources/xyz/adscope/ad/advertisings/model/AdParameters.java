package xyz.adscope.ad.advertisings.model;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdParameters {
    private int adCount;
    private String adType;
    private String adUnitId;
    private String bidToken;
    private WeakReference<Context> contextWeakReference;
    private int countryCN;
    private int testAd;

    public AdParameters(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    public int getAdCount() {
        return this.adCount;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public int getCountryCN() {
        return this.countryCN;
    }

    public int getTestAd() {
        return this.testAd;
    }

    public void setAdCount(int i4) {
        this.adCount = i4;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setCountryCN(int i4) {
        this.countryCN = i4;
    }

    public void setTestAd(int i4) {
        this.testAd = i4;
    }
}

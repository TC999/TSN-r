package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationCustomInitConfig {

    /* renamed from: c  reason: collision with root package name */
    private String f36134c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f36135f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private String f36136k;

    /* renamed from: p  reason: collision with root package name */
    private String f36137p;

    /* renamed from: r  reason: collision with root package name */
    private String f36138r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f36139w;
    private String xv;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.xv = str;
        this.f36134c = str2;
        this.f36139w = str3;
        this.sr = str4;
        this.ux = str5;
        this.f36135f = str6;
        this.f36138r = str7;
        this.ev = str8;
        this.gd = str9;
        this.f36137p = str10;
        this.f36136k = str11;
    }

    public String getADNName() {
        return this.xv;
    }

    public String getAdnInitClassName() {
        return this.sr;
    }

    public String getAppId() {
        return this.f36134c;
    }

    public String getAppKey() {
        return this.f36139w;
    }

    public String getBannerClassName() {
        return this.ux;
    }

    public String getDrawClassName() {
        return this.f36136k;
    }

    public String getFeedClassName() {
        return this.f36137p;
    }

    public String getFullVideoClassName() {
        return this.ev;
    }

    public String getInterstitialClassName() {
        return this.f36135f;
    }

    public String getRewardClassName() {
        return this.f36138r;
    }

    public String getSplashClassName() {
        return this.gd;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f36134c + "', mAppKey='" + this.f36139w + "', mADNName='" + this.xv + "', mAdnInitClassName='" + this.sr + "', mBannerClassName='" + this.ux + "', mInterstitialClassName='" + this.f36135f + "', mRewardClassName='" + this.f36138r + "', mFullVideoClassName='" + this.ev + "', mSplashClassName='" + this.gd + "', mFeedClassName='" + this.f36137p + "', mDrawClassName='" + this.f36136k + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.xv = valueSet.stringValue(8003);
            this.f36134c = valueSet.stringValue(8534);
            this.f36139w = valueSet.stringValue(8535);
            this.sr = valueSet.stringValue(8536);
            this.ux = valueSet.stringValue(8537);
            this.f36135f = valueSet.stringValue(8538);
            this.f36138r = valueSet.stringValue(8539);
            this.ev = valueSet.stringValue(8540);
            this.gd = valueSet.stringValue(8541);
            this.f36137p = valueSet.stringValue(8542);
            this.f36136k = valueSet.stringValue(8543);
        }
    }
}

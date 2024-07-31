package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.p110vk.openvk.api.proto.ValueSet;
import p655w1.C16237a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationCustomInitConfig {

    /* renamed from: a */
    private String f22757a;

    /* renamed from: bl */
    private String f22758bl;

    /* renamed from: h */
    private String f22759h;

    /* renamed from: k */
    private String f22760k;

    /* renamed from: kf */
    private String f22761kf;

    /* renamed from: n */
    private String f22762n;

    /* renamed from: ok */
    private String f22763ok;

    /* renamed from: p */
    private String f22764p;

    /* renamed from: q */
    private String f22765q;

    /* renamed from: r */
    private String f22766r;

    /* renamed from: s */
    private String f22767s;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f22758bl = str;
        this.f22763ok = str2;
        this.f22757a = str3;
        this.f22767s = str4;
        this.f22762n = str5;
        this.f22761kf = str6;
        this.f22759h = str7;
        this.f22764p = str8;
        this.f22765q = str9;
        this.f22760k = str10;
        this.f22766r = str11;
    }

    public String getADNName() {
        return this.f22758bl;
    }

    public String getAdnInitClassName() {
        return this.f22767s;
    }

    public String getAppId() {
        return this.f22763ok;
    }

    public String getAppKey() {
        return this.f22757a;
    }

    public String getBannerClassName() {
        return this.f22762n;
    }

    public String getDrawClassName() {
        return this.f22766r;
    }

    public String getFeedClassName() {
        return this.f22760k;
    }

    public String getFullVideoClassName() {
        return this.f22764p;
    }

    public String getInterstitialClassName() {
        return this.f22761kf;
    }

    public String getRewardClassName() {
        return this.f22759h;
    }

    public String getSplashClassName() {
        return this.f22765q;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f22763ok + "', mAppKey='" + this.f22757a + "', mADNName='" + this.f22758bl + "', mAdnInitClassName='" + this.f22767s + "', mBannerClassName='" + this.f22762n + "', mInterstitialClassName='" + this.f22761kf + "', mRewardClassName='" + this.f22759h + "', mFullVideoClassName='" + this.f22764p + "', mSplashClassName='" + this.f22765q + "', mFeedClassName='" + this.f22760k + "', mDrawClassName='" + this.f22766r + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f22758bl = valueSet.stringValue(C16237a.f47148e);
            this.f22763ok = valueSet.stringValue(8534);
            this.f22757a = valueSet.stringValue(8535);
            this.f22767s = valueSet.stringValue(8536);
            this.f22762n = valueSet.stringValue(8537);
            this.f22761kf = valueSet.stringValue(8538);
            this.f22759h = valueSet.stringValue(8539);
            this.f22764p = valueSet.stringValue(8540);
            this.f22765q = valueSet.stringValue(8541);
            this.f22760k = valueSet.stringValue(8542);
            this.f22766r = valueSet.stringValue(8543);
        }
    }
}

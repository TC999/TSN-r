package com.bytedance.msdk.api;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdLoadInfo {
    public static final String AD_LOADED = "广告加载成功";
    public static final String AD_LOADING = "广告请求中";

    /* renamed from: a */
    private String f21530a;

    /* renamed from: b */
    private String f21531b;

    /* renamed from: c */
    private String f21532c;

    /* renamed from: d */
    private int f21533d;

    /* renamed from: e */
    private String f21534e;

    public String getAdType() {
        return this.f21532c;
    }

    public String getAdnName() {
        return this.f21531b;
    }

    public int getErrCode() {
        return this.f21533d;
    }

    public String getErrMsg() {
        return this.f21534e;
    }

    public String getMediationRit() {
        return this.f21530a;
    }

    public AdLoadInfo setAdType(String str) {
        this.f21532c = str;
        return this;
    }

    public AdLoadInfo setAdnName(String str) {
        this.f21531b = str;
        return this;
    }

    public AdLoadInfo setErrCode(int i) {
        this.f21533d = i;
        return this;
    }

    public AdLoadInfo setErrMsg(String str) {
        this.f21534e = str;
        return this;
    }

    public AdLoadInfo setMediationRit(String str) {
        this.f21530a = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.f21530a + "', adnName='" + this.f21531b + "', adType='" + this.f21532c + "', errCode=" + this.f21533d + ", errMsg=" + this.f21534e + '}';
    }
}

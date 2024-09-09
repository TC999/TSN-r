package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdLoadInfo {
    public static final String AD_LOADED = "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f";
    public static final String AD_LOADING = "\u5e7f\u544a\u8bf7\u6c42\u4e2d";

    /* renamed from: a  reason: collision with root package name */
    private String f27266a;

    /* renamed from: b  reason: collision with root package name */
    private String f27267b;

    /* renamed from: c  reason: collision with root package name */
    private String f27268c;

    /* renamed from: d  reason: collision with root package name */
    private int f27269d;

    /* renamed from: e  reason: collision with root package name */
    private String f27270e;

    public String getAdType() {
        return this.f27268c;
    }

    public String getAdnName() {
        return this.f27267b;
    }

    public int getErrCode() {
        return this.f27269d;
    }

    public String getErrMsg() {
        return this.f27270e;
    }

    public String getMediationRit() {
        return this.f27266a;
    }

    public AdLoadInfo setAdType(String str) {
        this.f27268c = str;
        return this;
    }

    public AdLoadInfo setAdnName(String str) {
        this.f27267b = str;
        return this;
    }

    public AdLoadInfo setErrCode(int i4) {
        this.f27269d = i4;
        return this;
    }

    public AdLoadInfo setErrMsg(String str) {
        this.f27270e = str;
        return this;
    }

    public AdLoadInfo setMediationRit(String str) {
        this.f27266a = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.f27266a + "', adnName='" + this.f27267b + "', adType='" + this.f27268c + "', errCode=" + this.f27269d + ", errMsg=" + this.f27270e + '}';
    }
}

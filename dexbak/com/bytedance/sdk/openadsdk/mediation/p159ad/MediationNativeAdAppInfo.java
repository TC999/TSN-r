package com.bytedance.sdk.openadsdk.mediation.p159ad;

import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationNativeAdAppInfo {

    /* renamed from: a */
    private String f22663a;

    /* renamed from: bl */
    private long f22664bl;

    /* renamed from: h */
    private String f22665h;

    /* renamed from: kf */
    private String f22666kf;

    /* renamed from: n */
    private Map<String, String> f22667n;

    /* renamed from: ok */
    private String f22668ok;

    /* renamed from: p */
    private String f22669p;

    /* renamed from: q */
    private Map<String, Object> f22670q;

    /* renamed from: s */
    private String f22671s;

    public Map<String, Object> getAppInfoExtra() {
        return this.f22670q;
    }

    public String getAppName() {
        return this.f22668ok;
    }

    public String getAuthorName() {
        return this.f22663a;
    }

    public String getFunctionDescUrl() {
        return this.f22669p;
    }

    public long getPackageSizeBytes() {
        return this.f22664bl;
    }

    public Map<String, String> getPermissionsMap() {
        return this.f22667n;
    }

    public String getPermissionsUrl() {
        return this.f22671s;
    }

    public String getPrivacyAgreement() {
        return this.f22666kf;
    }

    public String getVersionName() {
        return this.f22665h;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f22670q = map;
    }

    public void setAppName(String str) {
        this.f22668ok = str;
    }

    public void setAuthorName(String str) {
        this.f22663a = str;
    }

    public void setFunctionDescUrl(String str) {
        this.f22669p = str;
    }

    public void setPackageSizeBytes(long j) {
        this.f22664bl = j;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.f22667n = map;
    }

    public void setPermissionsUrl(String str) {
        this.f22671s = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f22666kf = str;
    }

    public void setVersionName(String str) {
        this.f22665h = str;
    }
}

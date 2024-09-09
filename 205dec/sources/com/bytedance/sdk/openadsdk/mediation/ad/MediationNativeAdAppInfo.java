package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationNativeAdAppInfo {

    /* renamed from: c  reason: collision with root package name */
    private String f36008c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f36009f;
    private Map<String, Object> gd;

    /* renamed from: r  reason: collision with root package name */
    private String f36010r;
    private String sr;
    private Map<String, String> ux;

    /* renamed from: w  reason: collision with root package name */
    private String f36011w;
    private long xv;

    public Map<String, Object> getAppInfoExtra() {
        return this.gd;
    }

    public String getAppName() {
        return this.f36008c;
    }

    public String getAuthorName() {
        return this.f36011w;
    }

    public String getFunctionDescUrl() {
        return this.ev;
    }

    public long getPackageSizeBytes() {
        return this.xv;
    }

    public Map<String, String> getPermissionsMap() {
        return this.ux;
    }

    public String getPermissionsUrl() {
        return this.sr;
    }

    public String getPrivacyAgreement() {
        return this.f36009f;
    }

    public String getVersionName() {
        return this.f36010r;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.gd = map;
    }

    public void setAppName(String str) {
        this.f36008c = str;
    }

    public void setAuthorName(String str) {
        this.f36011w = str;
    }

    public void setFunctionDescUrl(String str) {
        this.ev = str;
    }

    public void setPackageSizeBytes(long j4) {
        this.xv = j4;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.ux = map;
    }

    public void setPermissionsUrl(String str) {
        this.sr = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f36009f = str;
    }

    public void setVersionName(String str) {
        this.f36010r = str;
    }
}

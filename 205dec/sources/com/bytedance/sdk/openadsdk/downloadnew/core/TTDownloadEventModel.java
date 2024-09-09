package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class TTDownloadEventModel {

    /* renamed from: a  reason: collision with root package name */
    private String f35814a;
    private JSONObject bl;
    private String ok;

    /* renamed from: s  reason: collision with root package name */
    private JSONObject f35815s;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.bl;
    }

    public String getLabel() {
        return this.f35814a;
    }

    public JSONObject getMaterialMeta() {
        return this.f35815s;
    }

    public String getTag() {
        return this.ok;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.bl = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f35814a = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.f35815s = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.ok = str;
        return this;
    }
}

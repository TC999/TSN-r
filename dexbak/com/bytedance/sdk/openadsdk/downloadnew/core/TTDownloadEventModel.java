package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TTDownloadEventModel {

    /* renamed from: a */
    private String f22556a;

    /* renamed from: bl */
    private JSONObject f22557bl;

    /* renamed from: ok */
    private String f22558ok;

    /* renamed from: s */
    private JSONObject f22559s;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f22557bl;
    }

    public String getLabel() {
        return this.f22556a;
    }

    public JSONObject getMaterialMeta() {
        return this.f22559s;
    }

    public String getTag() {
        return this.f22558ok;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f22557bl = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f22556a = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.f22559s = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.f22558ok = str;
        return this;
    }
}

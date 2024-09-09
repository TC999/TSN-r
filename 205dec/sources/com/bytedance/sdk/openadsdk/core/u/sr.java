package com.bytedance.sdk.openadsdk.core.u;

import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private String f34818c;

    /* renamed from: f  reason: collision with root package name */
    private int f34819f;

    /* renamed from: r  reason: collision with root package name */
    private String f34820r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34821w;
    private String xv;

    public String c() {
        return this.f34820r;
    }

    public JSONObject ev() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", xv());
            jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, r());
            jSONObject.put("comment_num", f());
            jSONObject.put(DownloadModel.DOWNLOAD_URL, w());
            jSONObject.put("package_name", sr());
            jSONObject.put("score", ux());
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv(e4.toString());
        }
        return jSONObject;
    }

    public int f() {
        return this.ux;
    }

    public int r() {
        return this.f34819f;
    }

    public String sr() {
        return this.xv;
    }

    public int ux() {
        return this.sr;
    }

    public String w() {
        return this.f34818c;
    }

    public String xv() {
        return this.f34821w;
    }

    public void c(String str) {
        this.f34820r = str;
    }

    public void sr(String str) {
        this.xv = str;
    }

    public void w(String str) {
        this.f34818c = str;
    }

    public void xv(String str) {
        this.f34821w = str;
    }

    public void c(int i4) {
        this.sr = i4;
    }

    public void w(int i4) {
        this.ux = i4;
    }

    public void xv(int i4) {
        this.f34819f = i4;
    }
}

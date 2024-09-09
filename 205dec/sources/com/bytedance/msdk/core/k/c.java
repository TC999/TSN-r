package com.bytedance.msdk.core.k;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f28021c;

    /* renamed from: w  reason: collision with root package name */
    private String f28022w;
    private com.bytedance.msdk.api.sr.c.w.xv.w xv;

    public c(String str, String str2) {
        this.f28021c = str;
        this.f28022w = str2;
        this.xv = new com.bytedance.msdk.api.sr.c.w.xv.w();
    }

    public String c() {
        return this.f28021c;
    }

    public boolean sr() {
        com.bytedance.msdk.api.sr.c.w.xv.w wVar = this.xv;
        return wVar != null && wVar.sr();
    }

    public String toString() {
        return "AdNetworkConfValue{mAppId='" + this.f28021c + "', mAppKey='" + this.f28022w + "', mGMCustomConfig=" + this.xv + '}';
    }

    public String ux() {
        com.bytedance.msdk.api.sr.c.w.xv.w wVar = this.xv;
        if (wVar != null) {
            return wVar.w();
        }
        return null;
    }

    public String w() {
        return this.f28022w;
    }

    public com.bytedance.msdk.api.sr.c.w.xv.w xv() {
        return this.xv;
    }

    public static c c(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("app_id");
            String optString2 = jSONObject.optString("app_key");
            String optString3 = jSONObject.optString("custom_type");
            if (!TextUtils.equals(optString3, "1")) {
                return new c(optString, optString2);
            }
            return new c(str, optString, optString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), optString3);
        }
        return null;
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f28021c = str2;
        this.f28022w = str3;
        this.xv = new com.bytedance.msdk.api.sr.c.w.xv.w(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }
}

package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private boolean f33168c;

    /* renamed from: w  reason: collision with root package name */
    private String f33169w;
    private String xv;

    public boolean c() {
        return this.f33168c;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.f33168c));
            jSONObject.putOpt("upload_api", this.f33169w);
            jSONObject.putOpt("alert_text", this.xv);
        } catch (JSONException e4) {
            a.xv("OncallUploadConfig", e4);
        }
        return jSONObject.toString();
    }

    public String w() {
        return this.f33169w;
    }

    public String xv() {
        return this.xv;
    }

    public static w c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (JSONException e4) {
            a.sr("OncallUploadConfig", "parse failed:" + e4);
            return null;
        }
    }

    public static w c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        w wVar = new w();
        wVar.f33168c = jSONObject.optBoolean("enable");
        wVar.f33169w = jSONObject.optString("upload_api");
        wVar.xv = jSONObject.optString("alert_text");
        return wVar;
    }
}

package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public String f49035c;
    public String sr;
    public String ux;

    /* renamed from: w  reason: collision with root package name */
    public int f49036w = -1;
    public String xv;

    public String c() {
        return w().toString();
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f49035c);
            jSONObject.put("error_code", String.valueOf(this.f49036w));
            jSONObject.put("error_msg", this.xv);
            jSONObject.put("real_device_plan", this.sr);
            jSONObject.put("device_plans", this.ux);
        } catch (Throwable unused) {
        }
    }

    public static c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.ux = jSONObject.optString("device_plans", null);
            cVar.sr = jSONObject.optString("real_device_plan", null);
            cVar.xv = jSONObject.optString("error_msg", null);
            cVar.f49035c = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                cVar.f49036w = -1;
            } else {
                cVar.f49036w = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return cVar;
    }
}

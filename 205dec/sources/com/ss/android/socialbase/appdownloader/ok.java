package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: a  reason: collision with root package name */
    public int f49159a = -1;
    public String bl;

    /* renamed from: n  reason: collision with root package name */
    public String f49160n;
    public String ok;

    /* renamed from: s  reason: collision with root package name */
    public String f49161s;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        ok(jSONObject);
        return jSONObject;
    }

    public String ok() {
        return a().toString();
    }

    public void ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.ok);
            jSONObject.put("error_code", String.valueOf(this.f49159a));
            jSONObject.put("error_msg", this.bl);
            jSONObject.put("real_device_plan", this.f49161s);
            jSONObject.put("device_plans", this.f49160n);
        } catch (Throwable unused) {
        }
    }

    public static ok ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ok okVar = new ok();
        try {
            JSONObject jSONObject = new JSONObject(str);
            okVar.f49160n = jSONObject.optString("device_plans", null);
            okVar.f49161s = jSONObject.optString("real_device_plan", null);
            okVar.bl = jSONObject.optString("error_msg", null);
            okVar.ok = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                okVar.f49159a = -1;
            } else {
                okVar.f49159a = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return okVar;
    }
}

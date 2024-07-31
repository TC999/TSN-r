package com.p521ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12340ok {

    /* renamed from: a */
    public int f34802a = -1;

    /* renamed from: bl */
    public String f34803bl;

    /* renamed from: n */
    public String f34804n;

    /* renamed from: ok */
    public String f34805ok;

    /* renamed from: s */
    public String f34806s;

    /* renamed from: a */
    public JSONObject m18115a() {
        JSONObject jSONObject = new JSONObject();
        m18112ok(jSONObject);
        return jSONObject;
    }

    /* renamed from: ok */
    public String m18114ok() {
        return m18115a().toString();
    }

    /* renamed from: ok */
    public void m18112ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f34805ok);
            jSONObject.put("error_code", String.valueOf(this.f34802a));
            jSONObject.put("error_msg", this.f34803bl);
            jSONObject.put("real_device_plan", this.f34806s);
            jSONObject.put("device_plans", this.f34804n);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ok */
    public static C12340ok m18113ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C12340ok c12340ok = new C12340ok();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c12340ok.f34804n = jSONObject.optString("device_plans", null);
            c12340ok.f34806s = jSONObject.optString("real_device_plan", null);
            c12340ok.f34803bl = jSONObject.optString("error_msg", null);
            c12340ok.f34805ok = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                c12340ok.f34802a = -1;
            } else {
                c12340ok.f34802a = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return c12340ok;
    }
}

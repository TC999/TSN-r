package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7310x {
    /* renamed from: a */
    public JSONArray m33722a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String m34251e = C7191bh.m34251e();
            if (!TextUtils.isEmpty(m34251e) && !m34251e.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(m34251e);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i).getString("appName"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i).getString("pkgName"));
                    jSONObject.put("3", jSONArray2.getJSONObject(i).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}

package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String e4 = bh.e();
            if (!TextUtils.isEmpty(e4) && !e4.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(e4);
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i4).getString("appName"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i4).getString("pkgName"));
                    jSONObject.put("3", jSONArray2.getJSONObject(i4).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i4).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i4).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i4).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}

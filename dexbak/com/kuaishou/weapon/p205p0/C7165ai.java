package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ai */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7165ai {
    /* renamed from: a */
    public static JSONObject m34413a(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int parseInt = Integer.parseInt(property2);
            if (TextUtils.isEmpty(property) || parseInt == -1) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("h", property);
            jSONObject.put("p", parseInt);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}

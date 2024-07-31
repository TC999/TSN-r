package com.kuaishou.weapon.p205p0;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.dk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7267dk {
    /* renamed from: a */
    public static JSONObject m33954a() {
        try {
            String str = System.getenv("LD_PRELOAD");
            String str2 = System.getenv("LD_LIBRARY_PATH");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("0", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("1", str2);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m33953b() {
        try {
            String m34214a = C7195bk.m34214a();
            if (TextUtils.isEmpty(m34214a) || m34214a.contains("arm64")) {
                return 0;
            }
            return !m34214a.contains("64") ? 1 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}

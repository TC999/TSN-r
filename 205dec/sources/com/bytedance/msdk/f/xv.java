package com.bytedance.msdk.f;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static Random f28369c = new SecureRandom();

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String c4 = c(jSONObject.toString());
                if (!TextUtils.isEmpty(c4)) {
                    jSONObject2.put("message", c4);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable th) {
            com.bytedance.msdk.adapter.sr.xv.c(th.getMessage());
        }
        return jSONObject2;
    }

    public static String w() {
        String c4 = c(8);
        if (c4 == null || c4.length() != 16) {
            return null;
        }
        return c4;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String c4 = c();
        String c5 = c(c4, 32);
        String w3 = w();
        String str2 = null;
        if (c5 != null && w3 != null) {
            str2 = c.c(str, w3, c5);
        }
        return 3 + c4 + w3 + str2;
    }

    public static String c() {
        String c4 = c(16);
        if (c4 == null || c4.length() != 32) {
            return null;
        }
        return c4;
    }

    public static String c(String str, int i4) {
        if (str == null || str.length() != i4) {
            return null;
        }
        int i5 = i4 / 2;
        return str.substring(i5, i4) + str.substring(0, i5);
    }

    public static String c(int i4) {
        try {
            byte[] bArr = new byte[i4];
            f28369c.nextBytes(bArr);
            return ys.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

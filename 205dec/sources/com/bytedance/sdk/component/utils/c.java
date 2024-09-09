package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.component.utils.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0452c {

        /* renamed from: c  reason: collision with root package name */
        static final Random f30184c = c.xv();
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return c(jSONObject.toString());
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String c4 = c();
        String c5 = c(c4, 32);
        String w3 = w();
        String str2 = null;
        if (c5 != null && w3 != null) {
            str2 = com.bytedance.sdk.component.sr.c.c(str, w3, c5);
        }
        return 3 + c4 + w3 + str2;
    }

    public static String xv(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String c4 = c(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || c4 == null) ? str : com.bytedance.sdk.component.sr.c.w(str.substring(49), substring, c4);
    }

    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String w3 = w(str);
                if (!TextUtils.isEmpty(w3)) {
                    jSONObject.put("message", w3);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            a.c(th.getMessage());
        }
        return jSONObject;
    }

    public static Random xv() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    public static String w() {
        String c4 = c(8);
        if (c4 == null || c4.length() != 16) {
            return null;
        }
        return c4;
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
            C0452c.f30184c.nextBytes(bArr);
            return ux.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

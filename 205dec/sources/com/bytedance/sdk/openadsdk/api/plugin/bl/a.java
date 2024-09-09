package com.bytedance.sdk.openadsdk.api.plugin.bl;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {
    public static String a() {
        String ok = ok(8);
        if (ok == null || ok.length() != 16) {
            return null;
        }
        return ok;
    }

    private static SecureRandom bl() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    @JProtect
    public static String ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String ok = ok();
        String ok2 = ok(ok, 32);
        String a4 = a();
        String str2 = null;
        if (ok2 != null && a4 != null) {
            str2 = ok.ok(str, a4, ok2);
        }
        return 3 + ok + a4 + str2;
    }

    @JProtect
    public static JSONObject ok(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String ok = ok(jSONObject.toString());
                if (!TextUtils.isEmpty(ok)) {
                    jSONObject2.put("message", ok);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static String ok() {
        String ok = ok(16);
        if (ok == null || ok.length() != 32) {
            return null;
        }
        return ok;
    }

    public static String ok(String str, int i4) {
        if (str == null || str.length() != i4) {
            return null;
        }
        int i5 = i4 / 2;
        return str.substring(i5, i4) + str.substring(0, i5);
    }

    public static String ok(int i4) {
        try {
            byte[] bArr = new byte[i4];
            bl().nextBytes(bArr);
            return bl.ok(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

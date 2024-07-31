package com.bytedance.sdk.openadsdk.api.plugin.p136bl;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.bl.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C6322a {
    /* renamed from: a */
    public static String m36602a() {
        String m36599ok = m36599ok(8);
        if (m36599ok == null || m36599ok.length() != 16) {
            return null;
        }
        return m36599ok;
    }

    /* renamed from: bl */
    private static SecureRandom m36601bl() {
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
    /* renamed from: ok */
    public static String m36598ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String m36600ok = m36600ok();
        String m36597ok = m36597ok(m36600ok, 32);
        String m36602a = m36602a();
        String str2 = null;
        if (m36597ok != null && m36602a != null) {
            str2 = C6324ok.m36593ok(str, m36602a, m36597ok);
        }
        return 3 + m36600ok + m36602a + str2;
    }

    @JProtect
    /* renamed from: ok */
    public static JSONObject m36596ok(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String m36598ok = m36598ok(jSONObject.toString());
                if (!TextUtils.isEmpty(m36598ok)) {
                    jSONObject2.put("message", m36598ok);
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

    /* renamed from: ok */
    public static String m36600ok() {
        String m36599ok = m36599ok(16);
        if (m36599ok == null || m36599ok.length() != 32) {
            return null;
        }
        return m36599ok;
    }

    /* renamed from: ok */
    public static String m36597ok(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    /* renamed from: ok */
    public static String m36599ok(int i) {
        try {
            byte[] bArr = new byte[i];
            m36601bl().nextBytes(bArr);
            return C6323bl.m36595ok(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

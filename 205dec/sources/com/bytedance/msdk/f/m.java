package com.bytedance.msdk.f;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m {

    /* renamed from: c  reason: collision with root package name */
    private static String f28340c = null;
    private static String sr = "ToolUtils";

    /* renamed from: w  reason: collision with root package name */
    private static String f28341w;
    private static String xv;

    public static synchronized String c() {
        String str;
        synchronized (m.class) {
            if (TextUtils.isEmpty(f28340c) && com.bytedance.msdk.core.c.getContext() != null) {
                f28340c = com.bytedance.msdk.core.c.getContext().getPackageName();
            }
            str = f28340c;
        }
        return str;
    }

    public static String sr() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i4 = lastIndexOf + 1;
            String substring = str.substring(0, i4);
            String substring2 = str.substring(i4);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= '\u007f') {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String ux() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return ys.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized String w() {
        String str;
        synchronized (m.class) {
            if (TextUtils.isEmpty(f28341w) && com.bytedance.msdk.core.c.getContext() != null) {
                PackageInfo packageInfo = com.bytedance.msdk.core.c.getContext().getPackageManager().getPackageInfo(c(), 0);
                f28341w = String.valueOf(packageInfo.versionCode);
                xv = packageInfo.versionName;
            }
            str = f28341w;
        }
        return str;
    }

    public static synchronized String xv() {
        String str;
        synchronized (m.class) {
            if (TextUtils.isEmpty(xv) && com.bytedance.msdk.core.c.getContext() != null) {
                PackageInfo packageInfo = com.bytedance.msdk.core.c.getContext().getPackageManager().getPackageInfo(c(), 0);
                f28341w = String.valueOf(packageInfo.versionCode);
                xv = packageInfo.versionName;
            }
            str = xv;
        }
        return str;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return c.w(str.substring(17), w(str.substring(1, 17)));
    }

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String c4 = c.c();
                String str = 2 + c4 + c.c(jSONObject.toString(), c.c(c4));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
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

    private static String w(String str) {
        String c4 = c.c(str);
        if (str == null) {
            String c5 = w.c();
            return c5.concat(c5).substring(8, 24);
        }
        return c4;
    }
}

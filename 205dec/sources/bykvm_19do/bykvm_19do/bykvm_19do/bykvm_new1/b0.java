package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: ToolUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static String f627a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f628b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f629c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f630d = "ToolUtils";

    public static synchronized String a() {
        String str;
        synchronized (b0.class) {
            if (TextUtils.isEmpty(f627a) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() != null) {
                f627a = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d().getPackageName();
            }
            str = f627a;
        }
        return str;
    }

    private static String b(String str) {
        String a4 = a.a(str);
        if (str == null) {
            String a5 = b.a();
            return a5.concat(a5).substring(8, 24);
        }
        return a4;
    }

    public static String c() {
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

    public static synchronized String d() {
        String str;
        synchronized (b0.class) {
            if (TextUtils.isEmpty(f628b) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() != null) {
                PackageInfo packageInfo = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d().getPackageManager().getPackageInfo(a(), 0);
                f628b = String.valueOf(packageInfo.versionCode);
                f629c = packageInfo.versionName;
            }
            str = f628b;
        }
        return str;
    }

    public static synchronized String e() {
        String str;
        synchronized (b0.class) {
            if (TextUtils.isEmpty(f629c) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() != null) {
                PackageInfo packageInfo = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d().getPackageManager().getPackageInfo(a(), 0);
                f628b = String.valueOf(packageInfo.versionCode);
                f629c = packageInfo.versionName;
            }
            str = f629c;
        }
        return str;
    }

    public static String b() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return j.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return a.a(str.substring(17), b(str.substring(1, 17)));
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String a4 = a.a();
                String str = 2 + a4 + a.b(jSONObject.toString(), a.a(a4));
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
}

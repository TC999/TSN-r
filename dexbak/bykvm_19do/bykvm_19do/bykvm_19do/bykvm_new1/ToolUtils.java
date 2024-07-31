package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import java.security.SecureRandom;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ToolUtils {

    /* renamed from: a */
    private static String f634a = null;

    /* renamed from: b */
    private static String f635b = null;

    /* renamed from: c */
    private static String f636c = null;

    /* renamed from: d */
    private static String f637d = "ToolUtils";

    /* renamed from: a */
    public static synchronized String m59259a() {
        String str;
        synchronized (ToolUtils.class) {
            if (TextUtils.isEmpty(f634a) && InternalContainer.m59945d() != null) {
                f634a = InternalContainer.m59945d().getPackageName();
            }
            str = f634a;
        }
        return str;
    }

    /* renamed from: b */
    private static String m59255b(String str) {
        String m59266a = AES.m59266a(str);
        if (str == null) {
            String m59260a = AESKey.m59260a();
            return m59260a.concat(m59260a).substring(8, 24);
        }
        return m59266a;
    }

    /* renamed from: c */
    public static String m59254c() {
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
            int i = lastIndexOf + 1;
            String substring = str.substring(0, i);
            String substring2 = str.substring(i);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static synchronized String m59253d() {
        String str;
        synchronized (ToolUtils.class) {
            if (TextUtils.isEmpty(f635b) && InternalContainer.m59945d() != null) {
                PackageInfo packageInfo = InternalContainer.m59945d().getPackageManager().getPackageInfo(m59259a(), 0);
                f635b = String.valueOf(packageInfo.versionCode);
                f636c = packageInfo.versionName;
            }
            str = f635b;
        }
        return str;
    }

    /* renamed from: e */
    public static synchronized String m59252e() {
        String str;
        synchronized (ToolUtils.class) {
            if (TextUtils.isEmpty(f636c) && InternalContainer.m59945d() != null) {
                PackageInfo packageInfo = InternalContainer.m59945d().getPackageManager().getPackageInfo(m59259a(), 0);
                f635b = String.valueOf(packageInfo.versionCode);
                f636c = packageInfo.versionName;
            }
            str = f636c;
        }
        return str;
    }

    /* renamed from: b */
    public static String m59256b() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return DigestUtils.m59204a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m59258a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return AES.m59265a(str.substring(17), m59255b(str.substring(1, 17)));
    }

    /* renamed from: a */
    public static JSONObject m59257a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String m59267a = AES.m59267a();
                String str = 2 + m59267a + AES.m59264b(jSONObject.toString(), AES.m59266a(m59267a));
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

package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Arrays;

/* renamed from: com.amap.api.col.3l.e6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SPUtil {

    /* renamed from: b */
    static byte[] f3929b;

    /* renamed from: c */
    static byte[] f3930c;

    /* renamed from: a */
    private String f3931a;

    public SPUtil(String str) {
        this.f3931a = C1849l4.m54583d(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    /* renamed from: a */
    public static int m55234a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "giv");
            return i;
        }
    }

    /* renamed from: b */
    public static long m55233b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "glv");
            return j;
        }
    }

    /* renamed from: c */
    public static SharedPreferences.Editor m55232c(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "sp", "ge");
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m55231d(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return C1925p4.m54197g(m55218q(context, C1925p4.m54179y(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static void m55230e(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, C1925p4.m54206E(m55221n(context, C1925p4.m54189o(str3))));
            m55229f(edit);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public static void m55229f(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "sp", SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_COUNT);
        }
    }

    /* renamed from: g */
    public static void m55228g(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "sp", "rk");
            }
        }
    }

    /* renamed from: h */
    public static void m55227h(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "putPrefsInt");
        }
    }

    /* renamed from: i */
    public static void m55226i(SharedPreferences.Editor editor, String str, long j) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "plv");
        }
    }

    /* renamed from: j */
    public static void m55225j(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "sp", "ps");
            }
        }
    }

    /* renamed from: k */
    public static void m55224k(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "setPrefsStr");
        }
    }

    /* renamed from: l */
    public static boolean m55223l(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "gbv");
            return z;
        }
    }

    /* renamed from: m */
    private static byte[] m55222m(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f3929b;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = C1780e4.m55240j(context).getBytes();
            f3929b = bytes;
            return bytes;
        }
        return bArr;
    }

    /* renamed from: n */
    public static byte[] m55221n(Context context, byte[] bArr) {
        try {
            return Encrypt.m54717h(m55222m(context), bArr, m55219p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    /* renamed from: o */
    public static String m55220o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CampaignUnit.JSON_KEY_CSP, "gsv");
            return str3;
        }
    }

    /* renamed from: p */
    private static byte[] m55219p(Context context) {
        byte[] bArr = f3930c;
        if (bArr == null || bArr.length <= 0) {
            byte[] copyOfRange = Arrays.copyOfRange(m55222m(context), 0, m55222m(context).length / 2);
            f3930c = copyOfRange;
            return copyOfRange;
        }
        return bArr;
    }

    /* renamed from: q */
    public static byte[] m55218q(Context context, byte[] bArr) {
        try {
            return Encrypt.m54720e(m55222m(context), bArr, m55219p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}

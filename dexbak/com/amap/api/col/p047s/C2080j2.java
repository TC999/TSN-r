package com.amap.api.col.p047s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Arrays;

/* compiled from: SPUtil.java */
/* renamed from: com.amap.api.col.s.j2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2080j2 {

    /* renamed from: b */
    static byte[] f6222b;

    /* renamed from: c */
    static byte[] f6223c;

    /* renamed from: a */
    private String f6224a;

    public C2080j2(String str) {
        this.f6224a = C2059g1.m52992a(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    /* renamed from: a */
    public static int m52850a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "giv");
            return i;
        }
    }

    /* renamed from: b */
    public static long m52849b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "glv");
            return j;
        }
    }

    /* renamed from: c */
    public static SharedPreferences.Editor m52848c(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                C2041d2.m53085e(th, "sp", "ge");
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m52847d(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return C2079j1.m52870g(m52834q(context, C2079j1.m52853x(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static void m52846e(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, C2079j1.m52878D(m52837n(context, C2079j1.m52862o(str3))));
            m52845f(edit);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public static void m52845f(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            C2041d2.m53085e(th, "sp", SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_COUNT);
        }
    }

    /* renamed from: g */
    public static void m52844g(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                C2041d2.m53085e(th, "sp", "rk");
            }
        }
    }

    /* renamed from: h */
    public static void m52843h(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "putPrefsInt");
        }
    }

    /* renamed from: i */
    public static void m52842i(SharedPreferences.Editor editor, String str, long j) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "plv");
        }
    }

    /* renamed from: j */
    public static void m52841j(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                C2041d2.m53085e(th, "sp", "ps");
            }
        }
    }

    /* renamed from: k */
    public static void m52840k(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "setPrefsStr");
        }
    }

    /* renamed from: l */
    public static boolean m52839l(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "gbv");
            return z;
        }
    }

    /* renamed from: m */
    private static byte[] m52838m(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f6222b;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = C2199x0.m52327i(context).getBytes();
            f6222b = bytes;
            return bytes;
        }
        return bArr;
    }

    /* renamed from: n */
    public static byte[] m52837n(Context context, byte[] bArr) {
        try {
            return C2040d1.m53089h(m52838m(context), bArr, m52835p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    /* renamed from: o */
    public static String m52836o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            C2060g2.m52972o(th, CampaignUnit.JSON_KEY_CSP, "gsv");
            return str3;
        }
    }

    /* renamed from: p */
    private static byte[] m52835p(Context context) {
        byte[] bArr = f6223c;
        if (bArr == null || bArr.length <= 0) {
            byte[] copyOfRange = Arrays.copyOfRange(m52838m(context), 0, m52838m(context).length / 2);
            f6223c = copyOfRange;
            return copyOfRange;
        }
        return bArr;
    }

    /* renamed from: q */
    public static byte[] m52834q(Context context, byte[] bArr) {
        try {
            return C2040d1.m53092e(m52838m(context), bArr, m52835p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}

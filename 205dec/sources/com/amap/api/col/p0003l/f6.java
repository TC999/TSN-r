package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SPUtil.java */
/* renamed from: com.amap.api.col.3l.f6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f6 {

    /* renamed from: b  reason: collision with root package name */
    static byte[] f7718b;

    /* renamed from: c  reason: collision with root package name */
    static byte[] f7719c;

    /* renamed from: a  reason: collision with root package name */
    private String f7720a;

    public f6(String str) {
        this.f7720a = m4.d(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(Context context, String str, String str2, int i4) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i4);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "giv");
            return i4;
        }
    }

    public static long b(Context context, String str, String str2, long j4) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j4);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "glv");
            return j4;
        }
    }

    public static SharedPreferences.Editor c(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                q5.e(th, "sp", "ge");
            }
        }
        return null;
    }

    public static String d(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return q4.g(q(context, q4.y(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, q4.E(n(context, q4.o(str3))));
            f(edit);
        } catch (Throwable unused) {
        }
    }

    public static void f(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            q5.e(th, "sp", "cm");
        }
    }

    public static void g(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                q5.e(th, "sp", "rk");
            }
        }
    }

    public static void h(SharedPreferences.Editor editor, String str, int i4) {
        try {
            editor.putInt(str, i4);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "putPrefsInt");
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, long j4) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j4);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "plv");
        }
    }

    public static void j(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                q5.e(th, "sp", "ps");
            }
        }
    }

    public static void k(SharedPreferences.Editor editor, String str, boolean z3) {
        try {
            editor.putBoolean(str, z3);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "setPrefsStr");
        }
    }

    public static boolean l(Context context, String str, String str2, boolean z3) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z3);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "gbv");
            return z3;
        }
    }

    private static byte[] m(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f7718b;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = e4.j(context).getBytes();
            f7718b = bytes;
            return bytes;
        }
        return bArr;
    }

    public static byte[] n(Context context, byte[] bArr) {
        try {
            return j4.h(m(context), bArr, p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            u5.p(th, CampaignUnit.JSON_KEY_CSP, "gsv");
            return str3;
        }
    }

    private static byte[] p(Context context) {
        byte[] bArr = f7719c;
        if (bArr == null || bArr.length <= 0) {
            byte[] copyOfRange = Arrays.copyOfRange(m(context), 0, m(context).length / 2);
            f7719c = copyOfRange;
            return copyOfRange;
        }
        return bArr;
    }

    public static byte[] q(Context context, byte[] bArr) {
        try {
            return j4.e(m(context), bArr, p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
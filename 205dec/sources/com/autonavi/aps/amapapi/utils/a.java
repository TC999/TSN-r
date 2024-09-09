package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.f7;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.h7;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.u5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AuthUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f11986i = false;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f11987j = true;

    /* renamed from: k  reason: collision with root package name */
    private static int f11988k = 1000;

    /* renamed from: l  reason: collision with root package name */
    private static int f11989l = 200;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f11990m = false;

    /* renamed from: n  reason: collision with root package name */
    private static int f11991n = 20;

    /* renamed from: o  reason: collision with root package name */
    private static int f11992o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static volatile int f11993p = 0;

    /* renamed from: q  reason: collision with root package name */
    private static boolean f11994q = true;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f11995r = false;

    /* renamed from: s  reason: collision with root package name */
    private static int f11996s = -1;

    /* renamed from: t  reason: collision with root package name */
    private static long f11997t;

    /* renamed from: u  reason: collision with root package name */
    private static ArrayList<String> f11998u = new ArrayList<>();

    /* renamed from: v  reason: collision with root package name */
    private static ArrayList<String> f11999v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f12000w = false;

    /* renamed from: x  reason: collision with root package name */
    private static boolean f12001x = true;

    /* renamed from: y  reason: collision with root package name */
    private static long f12002y = 300000;

    /* renamed from: z  reason: collision with root package name */
    private static boolean f12003z = false;
    private static double A = 0.618d;
    private static boolean B = true;
    private static int C = 80;
    private static int D = 5;

    /* renamed from: a  reason: collision with root package name */
    static long f11978a = 3600000;
    private static boolean E = false;
    private static boolean F = true;
    private static boolean G = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile long f11979b = 0;

    /* renamed from: c  reason: collision with root package name */
    static boolean f11980c = false;
    private static boolean H = true;
    private static long I = -1;
    private static boolean J = true;
    private static int K = 1;

    /* renamed from: L  reason: collision with root package name */
    private static boolean f11977L = false;
    private static int M = 5;
    private static boolean N = false;
    private static String O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long P = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f11981d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f11982e = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f11983f = 20480;

    /* renamed from: g  reason: collision with root package name */
    public static int f11984g = 10800000;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f11985h = false;

    public static void a(final Context context) {
        if (f11986i) {
            return;
        }
        f11986i = true;
        g4.i(context, b.c(), b.d(), new g4.b() { // from class: com.autonavi.aps.amapapi.utils.a.1
            @Override // com.amap.api.col.p0003l.g4.b
            public final void a(g4.c cVar) {
                a.a(context, cVar);
            }
        });
    }

    public static int b() {
        return f11989l;
    }

    public static int c() {
        if (f11993p < 0) {
            f11993p = 0;
        }
        return f11993p;
    }

    public static long d() {
        return f12002y;
    }

    public static boolean e() {
        return f12001x;
    }

    public static boolean f() {
        return f12003z;
    }

    public static double g() {
        return A;
    }

    public static boolean h() {
        return B;
    }

    public static int i() {
        return C;
    }

    public static int j() {
        return D;
    }

    public static boolean k() {
        return F;
    }

    public static boolean l() {
        return G;
    }

    public static boolean m() {
        return f11980c;
    }

    public static boolean n() {
        return H;
    }

    public static long o() {
        return I;
    }

    public static boolean p() {
        return N;
    }

    public static boolean q() {
        return f11977L;
    }

    public static String r() {
        return q4.u(O);
    }

    public static boolean s() {
        return J && K > 0;
    }

    public static int t() {
        return K;
    }

    public static long u() {
        return P;
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean x3 = g4.x(jSONObject2.optString("able"), false);
                i.a(editor, "197a", x3);
                if (x3) {
                    i.a(editor, "197dv", jSONObject2.optString("sv", ""));
                    i.a(editor, "197tv", jSONObject2.optString("tv", ""));
                    return;
                }
                i.a(editor, "197dv", "");
                i.a(editor, "197tv", "");
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean x3 = g4.x(optJSONObject.optString("able"), true);
                B = x3;
                if (x3) {
                    C = optJSONObject.optInt("c", C);
                    D = optJSONObject.optInt("t", D);
                }
                i.a(editor, "13J_able", B);
                i.a(editor, "13J_c", C);
                i.a(editor, "13J_t", D);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean x3 = g4.x(jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_REASON), false);
            f11980c = x3;
            i.a(editor, "fr", x3);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (g4.x(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(Build.MANUFACTURER))) {
                    I = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    I = -1L;
                }
                i.a(editor, "awsi", I);
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean x3 = g4.x(jSONObject2.optString("able"), false);
                f11981d = x3;
                i.a(editor, "17ya", x3);
                boolean x4 = g4.x(jSONObject2.optString("mup"), false);
                f11982e = x4;
                i.a(editor, "17ym", x4);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    i.a(editor, "17yx", optInt);
                    f11983f = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    i.a(editor, "17yi", optInt2);
                    f11984g = optInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean x3 = g4.x(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", K);
                P = optJSONObject.optLong("sysTime", P);
                i.a(editor, "15ua", x3);
                i.a(editor, "15un", optInt);
                i.a(editor, "15ust", P);
            }
        } catch (Throwable unused) {
        }
    }

    private static void i(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean x3 = g4.x(optJSONObject.optString("able"), false);
                f11977L = x3;
                i.a(editor, "ok9", x3);
                if (x3) {
                    String optString = optJSONObject.optString("auth");
                    String optString2 = optJSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_HOST);
                    O = optString2;
                    i.a(editor, "ok11", optString2);
                    g4.x(optString, false);
                    N = g4.x(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString("tm");
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    M = parseInt;
                    i.a(editor, "ok10", parseInt);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        return f11987j;
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("1A6");
            if (jSONObject2 != null) {
                boolean x3 = g4.x(jSONObject2.optString("ic"), false);
                i.a(editor, "1A6", x3);
                f11985h = x3;
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(g4.c cVar, SharedPreferences.Editor editor) {
        try {
            g4.c.a aVar = cVar.f7845g;
            if (aVar != null) {
                boolean z3 = aVar.f7848a;
                f11987j = z3;
                i.a(editor, "exception", z3);
                JSONObject jSONObject = aVar.f7850c;
                if (jSONObject != null) {
                    f11988k = jSONObject.optInt("fn", f11988k);
                    int optInt = jSONObject.optInt("mpn", f11989l);
                    f11989l = optInt;
                    if (optInt > 500) {
                        f11989l = 500;
                    }
                    if (f11989l < 30) {
                        f11989l = 30;
                    }
                    f11990m = g4.x(jSONObject.optString("igu"), false);
                    f11991n = jSONObject.optInt("ms", f11991n);
                    f11993p = jSONObject.optInt("rot", 0);
                    f11992o = jSONObject.optInt("pms", 0);
                }
                f7.c(f11988k, f11990m, f11991n, f11992o);
                h7.f(f11990m, f11992o);
                i.a(editor, "fn", f11988k);
                i.a(editor, "mpn", f11989l);
                i.a(editor, "igu", f11990m);
                i.a(editor, "ms", f11991n);
                i.a(editor, "rot", f11993p);
                i.a(editor, "pms", f11992o);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    public static void c(Context context) {
        try {
            p4 c4 = b.c();
            c4.c(f11987j);
            u5.g(context, c4);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        if (f12000w) {
            return;
        }
        f12000w = true;
        try {
            f11987j = i.a(context, "pref", "exception", f11987j);
            c(context);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f11988k = i.a(context, "pref", "fn", f11988k);
            f11989l = i.a(context, "pref", "mpn", f11989l);
            f11990m = i.a(context, "pref", "igu", f11990m);
            f11991n = i.a(context, "pref", "ms", f11991n);
            f11993p = i.a(context, "pref", "rot", 0);
            int a4 = i.a(context, "pref", "pms", 0);
            f11992o = a4;
            f7.c(f11988k, f11990m, f11991n, a4);
            h7.f(f11990m, f11992o);
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            f12001x = i.a(context, "pref", "ca", f12001x);
            f12002y = i.a(context, "pref", "ct", f12002y);
            f12003z = i.a(context, "pref", "11G_fa", f12003z);
            double doubleValue = Double.valueOf(i.a(context, "pref", "11G_ms", String.valueOf(A))).doubleValue();
            A = doubleValue;
            A = Math.max(0.2d, doubleValue);
        } catch (Throwable th3) {
            b.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f11980c = i.a(context, "pref", "fr", f11980c);
        } catch (Throwable th4) {
            b.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            H = i.a(context, "pref", "asw", H);
        } catch (Throwable th5) {
            b.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            I = i.a(context, "pref", "awsi", I);
        } catch (Throwable th6) {
            b.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            J = i.a(context, "pref", "15ua", J);
            K = i.a(context, "pref", "15un", K);
            P = i.a(context, "pref", "15ust", P);
        } catch (Throwable th7) {
            b.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            f11977L = i.a(context, "pref", "ok9", f11977L);
            M = i.a(context, "pref", "ok10", M);
            O = i.a(context, "pref", "ok11", O);
        } catch (Throwable th8) {
            b.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            f11981d = i.a(context, "pref", "17ya", false);
            f11982e = i.a(context, "pref", "17ym", false);
            f11984g = i.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f11983f = i.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            b.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            f11979b = j.b();
            f11978a = i.a(context, "pref", "13S_at", f11978a);
            F = i.a(context, "pref", "13S_nla", F);
            B = i.a(context, "pref", "13J_able", B);
            C = i.a(context, "pref", "13J_c", C);
            D = i.a(context, "pref", "13J_t", D);
        } catch (Throwable th10) {
            b.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        g4.D(context);
        try {
            String a5 = i.a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(a5)) {
                G = a(context, new JSONArray(q4.u(a5)));
            }
        } catch (Throwable th11) {
            b.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean a6 = i.a(context, "pref", "197a", false);
            String a7 = i.a(context, "pref", "197dv", "");
            String a8 = i.a(context, "pref", "197tv", "");
            if (a6 && b.f12005a.equals(a7)) {
                for (String str : b.f12006b) {
                    if (str.equals(a8)) {
                        b.f12005a = a8;
                    }
                }
            }
        } catch (Throwable th12) {
            b.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            f11985h = i.a(context, "pref", "1A6", f11985h);
        } catch (Throwable th13) {
            b.a(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean x3 = g4.x(optJSONObject.optString("able"), true);
                f12001x = x3;
                if (x3) {
                    f12002y = optJSONObject.optInt("c", 300) * 1000;
                }
                f12003z = g4.x(optJSONObject.optString("fa"), false);
                A = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                i.a(editor, "ca", f12001x);
                i.a(editor, "ct", f12002y);
                i.a(editor, "11G_fa", f12003z);
                i.a(editor, "11G_ms", String.valueOf(A));
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    static boolean a(Context context, g4.c cVar) {
        SharedPreferences.Editor editor;
        try {
            editor = i.a(context, "pref");
            try {
                a(cVar, editor);
                c(context);
                JSONObject jSONObject = cVar.f7844f;
                if (jSONObject == null) {
                    if (editor != null) {
                        try {
                            i.a(editor);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                a(context, jSONObject, editor);
                a(jSONObject, editor);
                d(jSONObject, editor);
                f(jSONObject, editor);
                h(jSONObject, editor);
                g(jSONObject, editor);
                i(jSONObject, editor);
                b(jSONObject, editor);
                c(jSONObject, editor);
                if (editor != null) {
                    try {
                        i.a(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            } catch (Throwable unused3) {
                if (editor != null) {
                    try {
                        i.a(editor);
                        return false;
                    } catch (Throwable unused4) {
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable unused5) {
            editor = null;
        }
    }

    public static boolean a(long j4) {
        if (f12001x) {
            long a4 = j.a() - j4;
            long j5 = f12002y;
            return j5 < 0 || a4 < j5;
        }
        return false;
    }

    private static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                long optInt = optJSONObject.optInt("at", 123) * 60 * 1000;
                f11978a = optInt;
                i.a(editor, "13S_at", optInt);
                e(optJSONObject, editor);
                try {
                    boolean x3 = g4.x(optJSONObject.optString("nla"), true);
                    F = x3;
                    i.a(editor, "13S_nla", x3);
                } catch (Throwable unused) {
                }
                try {
                    boolean x4 = g4.x(optJSONObject.optString("asw"), true);
                    H = x4;
                    i.a(editor, "asw", x4);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray != null && optJSONArray.length() > 0 && context != null) {
                        i.a(editor, "13S_mlpl", q4.q(optJSONArray.toString()));
                        G = a(context, optJSONArray);
                        return;
                    }
                    G = false;
                    i.a(editor, "13S_mlpl");
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        if (j.b(context, jSONArray.getString(i4))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}

package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.col.p0463l.C1925p4;
import com.amap.api.col.p0463l.OfflineLocManager;
import com.amap.api.col.p0463l.SDKInfo;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.col.p0463l.StatisticsManager;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.autonavi.aps.amapapi.utils.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AuthUtil {

    /* renamed from: i */
    private static volatile boolean f8348i = false;

    /* renamed from: j */
    private static boolean f8349j = true;

    /* renamed from: k */
    private static int f8350k = 1000;

    /* renamed from: l */
    private static int f8351l = 200;

    /* renamed from: m */
    private static boolean f8352m = false;

    /* renamed from: n */
    private static int f8353n = 20;

    /* renamed from: o */
    private static int f8354o = 0;

    /* renamed from: p */
    private static volatile int f8355p = 0;

    /* renamed from: q */
    private static boolean f8356q = true;

    /* renamed from: r */
    private static boolean f8357r = false;

    /* renamed from: s */
    private static int f8358s = -1;

    /* renamed from: t */
    private static long f8359t;

    /* renamed from: u */
    private static ArrayList<String> f8360u = new ArrayList<>();

    /* renamed from: v */
    private static ArrayList<String> f8361v = new ArrayList<>();

    /* renamed from: w */
    private static volatile boolean f8362w = false;

    /* renamed from: x */
    private static boolean f8363x = true;

    /* renamed from: y */
    private static long f8364y = 300000;

    /* renamed from: z */
    private static boolean f8365z = false;

    /* renamed from: A */
    private static double f8324A = 0.618d;

    /* renamed from: B */
    private static boolean f8325B = true;

    /* renamed from: C */
    private static int f8326C = 80;

    /* renamed from: D */
    private static int f8327D = 5;

    /* renamed from: a */
    static long f8340a = C7193bi.f24584s;

    /* renamed from: E */
    private static boolean f8328E = false;

    /* renamed from: F */
    private static boolean f8329F = true;

    /* renamed from: G */
    private static boolean f8330G = false;

    /* renamed from: b */
    public static volatile long f8341b = 0;

    /* renamed from: c */
    static boolean f8342c = false;

    /* renamed from: H */
    private static boolean f8331H = true;

    /* renamed from: I */
    private static long f8332I = -1;

    /* renamed from: J */
    private static boolean f8333J = true;

    /* renamed from: K */
    private static int f8334K = 1;

    /* renamed from: L */
    private static boolean f8335L = false;

    /* renamed from: M */
    private static int f8336M = 5;

    /* renamed from: N */
    private static boolean f8337N = false;

    /* renamed from: O */
    private static String f8338O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";

    /* renamed from: P */
    private static long f8339P = 0;

    /* renamed from: d */
    public static boolean f8343d = false;

    /* renamed from: e */
    public static boolean f8344e = false;

    /* renamed from: f */
    public static int f8345f = 20480;

    /* renamed from: g */
    public static int f8346g = 10800000;

    /* renamed from: h */
    public static boolean f8347h = false;

    /* renamed from: a */
    public static void m51347a(final Context context) {
        if (f8348i) {
            return;
        }
        f8348i = true;
        AuthConfigManager.m55055i(context, C2428b.m51294c(), C2428b.m51292d(), new AuthConfigManager.InterfaceC1800b() { // from class: com.autonavi.aps.amapapi.utils.a.1
            @Override // com.amap.api.col.p0463l.AuthConfigManager.InterfaceC1800b
            /* renamed from: a */
            public final void mo51311a(AuthConfigManager.C1801c c1801c) {
                AuthUtil.m51346a(context, c1801c);
            }
        });
    }

    /* renamed from: b */
    public static int m51341b() {
        return f8351l;
    }

    /* renamed from: c */
    public static int m51338c() {
        if (f8355p < 0) {
            f8355p = 0;
        }
        return f8355p;
    }

    /* renamed from: d */
    public static long m51335d() {
        return f8364y;
    }

    /* renamed from: e */
    public static boolean m51333e() {
        return f8363x;
    }

    /* renamed from: f */
    public static boolean m51331f() {
        return f8365z;
    }

    /* renamed from: g */
    public static double m51329g() {
        return f8324A;
    }

    /* renamed from: h */
    public static boolean m51327h() {
        return f8325B;
    }

    /* renamed from: i */
    public static int m51325i() {
        return f8326C;
    }

    /* renamed from: j */
    public static int m51323j() {
        return f8327D;
    }

    /* renamed from: k */
    public static boolean m51322k() {
        return f8329F;
    }

    /* renamed from: l */
    public static boolean m51321l() {
        return f8330G;
    }

    /* renamed from: m */
    public static boolean m51320m() {
        return f8342c;
    }

    /* renamed from: n */
    public static boolean m51319n() {
        return f8331H;
    }

    /* renamed from: o */
    public static long m51318o() {
        return f8332I;
    }

    /* renamed from: p */
    public static boolean m51317p() {
        return f8337N;
    }

    /* renamed from: q */
    public static boolean m51316q() {
        return f8335L;
    }

    /* renamed from: r */
    public static String m51315r() {
        return C1925p4.m54183u(f8338O);
    }

    /* renamed from: s */
    public static boolean m51314s() {
        return f8333J && f8334K > 0;
    }

    /* renamed from: t */
    public static int m51313t() {
        return f8334K;
    }

    /* renamed from: u */
    public static long m51312u() {
        return f8339P;
    }

    /* renamed from: b */
    private static void m51339b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean m55040x = AuthConfigManager.m55040x(jSONObject2.optString("able"), false);
                C2431i.m51212a(editor, "197a", m55040x);
                if (m55040x) {
                    C2431i.m51213a(editor, "197dv", jSONObject2.optString("sv", ""));
                    C2431i.m51213a(editor, "197tv", jSONObject2.optString("tv", ""));
                    return;
                }
                C2431i.m51213a(editor, "197dv", "");
                C2431i.m51213a(editor, "197tv", "");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private static void m51334d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("able"), true);
                f8325B = m55040x;
                if (m55040x) {
                    f8326C = optJSONObject.optInt("c", f8326C);
                    f8327D = optJSONObject.optInt(UMCommonContent.f37782aL, f8327D);
                }
                C2431i.m51212a(editor, "13J_able", f8325B);
                C2431i.m51215a(editor, "13J_c", f8326C);
                C2431i.m51215a(editor, "13J_t", f8327D);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    /* renamed from: e */
    private static void m51332e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean m55040x = AuthConfigManager.m55040x(jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_REASON), false);
            f8342c = m55040x;
            C2431i.m51212a(editor, SocializeProtocolConstants.PROTOCOL_KEY_FR, m55040x);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    /* renamed from: f */
    private static void m51330f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (AuthConfigManager.m55040x(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(Build.MANUFACTURER))) {
                    f8332I = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    f8332I = -1L;
                }
                C2431i.m51214a(editor, "awsi", f8332I);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private static void m51328g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean m55040x = AuthConfigManager.m55040x(jSONObject2.optString("able"), false);
                f8343d = m55040x;
                C2431i.m51212a(editor, "17ya", m55040x);
                boolean m55040x2 = AuthConfigManager.m55040x(jSONObject2.optString("mup"), false);
                f8344e = m55040x2;
                C2431i.m51212a(editor, "17ym", m55040x2);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    C2431i.m51215a(editor, "17yx", optInt);
                    f8345f = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    C2431i.m51215a(editor, "17yi", optInt2);
                    f8346g = optInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    private static void m51326h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", f8334K);
                f8339P = optJSONObject.optLong("sysTime", f8339P);
                C2431i.m51212a(editor, "15ua", m55040x);
                C2431i.m51215a(editor, "15un", optInt);
                C2431i.m51214a(editor, "15ust", f8339P);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private static void m51324i(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("able"), false);
                f8335L = m55040x;
                C2431i.m51212a(editor, "ok9", m55040x);
                if (m55040x) {
                    String optString = optJSONObject.optString("auth");
                    String optString2 = optJSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_HOST);
                    f8338O = optString2;
                    C2431i.m51213a(editor, "ok11", optString2);
                    AuthConfigManager.m55040x(optString, false);
                    f8337N = AuthConfigManager.m55040x(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString("tm");
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    f8336M = parseInt;
                    C2431i.m51215a(editor, "ok10", parseInt);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m51349a() {
        return f8349j;
    }

    /* renamed from: c */
    private static void m51336c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("1A6");
            if (jSONObject2 != null) {
                boolean m55040x = AuthConfigManager.m55040x(jSONObject2.optString("ic"), false);
                C2431i.m51212a(editor, "1A6", m55040x);
                f8347h = m55040x;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m51343a(AuthConfigManager.C1801c c1801c, SharedPreferences.Editor editor) {
        try {
            AuthConfigManager.C1801c.C1802a c1802a = c1801c.f4133g;
            if (c1802a != null) {
                boolean z = c1802a.f4136a;
                f8349j = z;
                C2431i.m51212a(editor, "exception", z);
                JSONObject jSONObject = c1802a.f4138c;
                if (jSONObject != null) {
                    f8350k = jSONObject.optInt("fn", f8350k);
                    int optInt = jSONObject.optInt("mpn", f8351l);
                    f8351l = optInt;
                    if (optInt > 500) {
                        f8351l = 500;
                    }
                    if (f8351l < 30) {
                        f8351l = 30;
                    }
                    f8352m = AuthConfigManager.m55040x(jSONObject.optString("igu"), false);
                    f8353n = jSONObject.optInt("ms", f8353n);
                    f8355p = jSONObject.optInt("rot", 0);
                    f8354o = jSONObject.optInt("pms", 0);
                }
                OfflineLocManager.m55215c(f8350k, f8352m, f8353n, f8354o);
                StatisticsManager.m54909f(f8352m, f8354o);
                C2431i.m51215a(editor, "fn", f8350k);
                C2431i.m51215a(editor, "mpn", f8351l);
                C2431i.m51212a(editor, "igu", f8352m);
                C2431i.m51215a(editor, "ms", f8353n);
                C2431i.m51215a(editor, "rot", f8355p);
                C2431i.m51215a(editor, "pms", f8354o);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    /* renamed from: c */
    public static void m51337c(Context context) {
        try {
            SDKInfo m51294c = C2428b.m51294c();
            m51294c.m54398c(f8349j);
            SDKLogHandler.m53872g(context, m51294c);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static void m51340b(Context context) {
        if (f8362w) {
            return;
        }
        f8362w = true;
        try {
            f8349j = C2431i.m51218a(context, "pref", "exception", f8349j);
            m51337c(context);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f8350k = C2431i.m51221a(context, "pref", "fn", f8350k);
            f8351l = C2431i.m51221a(context, "pref", "mpn", f8351l);
            f8352m = C2431i.m51218a(context, "pref", "igu", f8352m);
            f8353n = C2431i.m51221a(context, "pref", "ms", f8353n);
            f8355p = C2431i.m51221a(context, "pref", "rot", 0);
            int m51221a = C2431i.m51221a(context, "pref", "pms", 0);
            f8354o = m51221a;
            OfflineLocManager.m55215c(f8350k, f8352m, f8353n, m51221a);
            StatisticsManager.m54909f(f8352m, f8354o);
        } catch (Throwable th2) {
            C2428b.m51299a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            f8363x = C2431i.m51218a(context, "pref", "ca", f8363x);
            f8364y = C2431i.m51220a(context, "pref", "ct", f8364y);
            f8365z = C2431i.m51218a(context, "pref", "11G_fa", f8365z);
            double doubleValue = Double.valueOf(C2431i.m51219a(context, "pref", "11G_ms", String.valueOf(f8324A))).doubleValue();
            f8324A = doubleValue;
            f8324A = Math.max(0.2d, doubleValue);
        } catch (Throwable th3) {
            C2428b.m51299a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f8342c = C2431i.m51218a(context, "pref", SocializeProtocolConstants.PROTOCOL_KEY_FR, f8342c);
        } catch (Throwable th4) {
            C2428b.m51299a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            f8331H = C2431i.m51218a(context, "pref", "asw", f8331H);
        } catch (Throwable th5) {
            C2428b.m51299a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            f8332I = C2431i.m51220a(context, "pref", "awsi", f8332I);
        } catch (Throwable th6) {
            C2428b.m51299a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            f8333J = C2431i.m51218a(context, "pref", "15ua", f8333J);
            f8334K = C2431i.m51221a(context, "pref", "15un", f8334K);
            f8339P = C2431i.m51220a(context, "pref", "15ust", f8339P);
        } catch (Throwable th7) {
            C2428b.m51299a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            f8335L = C2431i.m51218a(context, "pref", "ok9", f8335L);
            f8336M = C2431i.m51221a(context, "pref", "ok10", f8336M);
            f8338O = C2431i.m51219a(context, "pref", "ok11", f8338O);
        } catch (Throwable th8) {
            C2428b.m51299a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            f8343d = C2431i.m51218a(context, "pref", "17ya", false);
            f8344e = C2431i.m51218a(context, "pref", "17ym", false);
            f8346g = C2431i.m51221a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f8345f = C2431i.m51221a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            C2428b.m51299a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            f8341b = C2432j.m51186b();
            f8340a = C2431i.m51220a(context, "pref", "13S_at", f8340a);
            f8329F = C2431i.m51218a(context, "pref", "13S_nla", f8329F);
            f8325B = C2431i.m51218a(context, "pref", "13J_able", f8325B);
            f8326C = C2431i.m51221a(context, "pref", "13J_c", f8326C);
            f8327D = C2431i.m51221a(context, "pref", "13J_t", f8327D);
        } catch (Throwable th10) {
            C2428b.m51299a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        AuthConfigManager.m55084D(context);
        try {
            String m51219a = C2431i.m51219a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(m51219a)) {
                f8330G = m51345a(context, new JSONArray(C1925p4.m54183u(m51219a)));
            }
        } catch (Throwable th11) {
            C2428b.m51299a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean m51218a = C2431i.m51218a(context, "pref", "197a", false);
            String m51219a2 = C2431i.m51219a(context, "pref", "197dv", "");
            String m51219a3 = C2431i.m51219a(context, "pref", "197tv", "");
            if (m51218a && C2428b.f8367a.equals(m51219a2)) {
                for (String str : C2428b.f8368b) {
                    if (str.equals(m51219a3)) {
                        C2428b.f8367a = m51219a3;
                    }
                }
            }
        } catch (Throwable th12) {
            C2428b.m51299a(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            f8347h = C2431i.m51218a(context, "pref", "1A6", f8347h);
        } catch (Throwable th13) {
            C2428b.m51299a(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    /* renamed from: a */
    private static void m51342a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("able"), true);
                f8363x = m55040x;
                if (m55040x) {
                    f8364y = optJSONObject.optInt("c", 300) * 1000;
                }
                f8365z = AuthConfigManager.m55040x(optJSONObject.optString("fa"), false);
                f8324A = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                C2431i.m51212a(editor, "ca", f8363x);
                C2431i.m51214a(editor, "ct", f8364y);
                C2431i.m51212a(editor, "11G_fa", f8365z);
                C2431i.m51213a(editor, "11G_ms", String.valueOf(f8324A));
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    /* renamed from: a */
    static boolean m51346a(Context context, AuthConfigManager.C1801c c1801c) {
        SharedPreferences.Editor editor;
        try {
            editor = C2431i.m51222a(context, "pref");
            try {
                m51343a(c1801c, editor);
                m51337c(context);
                JSONObject jSONObject = c1801c.f4132f;
                if (jSONObject == null) {
                    if (editor != null) {
                        try {
                            C2431i.m51217a(editor);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                m51344a(context, jSONObject, editor);
                m51342a(jSONObject, editor);
                m51334d(jSONObject, editor);
                m51330f(jSONObject, editor);
                m51326h(jSONObject, editor);
                m51328g(jSONObject, editor);
                m51324i(jSONObject, editor);
                m51339b(jSONObject, editor);
                m51336c(jSONObject, editor);
                if (editor != null) {
                    try {
                        C2431i.m51217a(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            } catch (Throwable unused3) {
                if (editor != null) {
                    try {
                        C2431i.m51217a(editor);
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

    /* renamed from: a */
    public static boolean m51348a(long j) {
        if (f8363x) {
            long m51211a = C2432j.m51211a() - j;
            long j2 = f8364y;
            return j2 < 0 || m51211a < j2;
        }
        return false;
    }

    /* renamed from: a */
    private static void m51344a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                long optInt = optJSONObject.optInt("at", 123) * 60 * 1000;
                f8340a = optInt;
                C2431i.m51214a(editor, "13S_at", optInt);
                m51332e(optJSONObject, editor);
                try {
                    boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("nla"), true);
                    f8329F = m55040x;
                    C2431i.m51212a(editor, "13S_nla", m55040x);
                } catch (Throwable unused) {
                }
                try {
                    boolean m55040x2 = AuthConfigManager.m55040x(optJSONObject.optString("asw"), true);
                    f8331H = m55040x2;
                    C2431i.m51212a(editor, "asw", m55040x2);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray != null && optJSONArray.length() > 0 && context != null) {
                        C2431i.m51213a(editor, "13S_mlpl", C1925p4.m54187q(optJSONArray.toString()));
                        f8330G = m51345a(context, optJSONArray);
                        return;
                    }
                    f8330G = false;
                    C2431i.m51216a(editor, "13S_mlpl");
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    /* renamed from: a */
    private static boolean m51345a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (C2432j.m51182b(context, jSONArray.getString(i))) {
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

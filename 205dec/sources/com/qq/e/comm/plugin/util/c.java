package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f46383a = new ConcurrentHashMap<>();

    public static int a() {
        return 1;
    }

    public static List<JSONObject> a(JSONArray jSONArray, com.qq.e.comm.plugin.b.m mVar) {
        return a(jSONArray, mVar, (boolean[]) null, (com.qq.e.comm.plugin.b.d) null);
    }

    private static boolean a(int i4) {
        return i4 == 3;
    }

    private static boolean b(int i4) {
        return i4 == 46;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 1000;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 30;
    }

    @Deprecated
    public static boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return a(jSONObject.optInt("mini_program_type"));
    }

    @Deprecated
    public static boolean e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return b(jSONObject.optInt("producttype"));
    }

    @Deprecated
    public static boolean f(JSONObject jSONObject) {
        return e(jSONObject) || d(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e4 A[Catch: all -> 0x0112, TryCatch #1 {all -> 0x0112, blocks: (B:44:0x00c9, B:51:0x00e4, B:52:0x00e6, B:60:0x00fa, B:48:0x00d6, B:49:0x00de), top: B:90:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<org.json.JSONObject> a(org.json.JSONArray r18, com.qq.e.comm.plugin.b.m r19, boolean[] r20, com.qq.e.comm.plugin.b.d r21) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.c.a(org.json.JSONArray, com.qq.e.comm.plugin.b.m, boolean[], com.qq.e.comm.plugin.b.d):java.util.List");
    }

    public static long b(com.qq.e.comm.plugin.g0.e eVar) {
        return a(eVar) + (a(eVar.j(), a(eVar.q0(), eVar.p0(), eVar.o())) * 60 * 1000);
    }

    public static boolean c(com.qq.e.comm.plugin.g0.e eVar) {
        return a(b(eVar));
    }

    public static boolean d(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return false;
        }
        return a(eVar.g0());
    }

    public static boolean e(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return false;
        }
        return b(eVar.g());
    }

    public static boolean f(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return false;
        }
        return e(eVar) || d(eVar);
    }

    private static void a(com.qq.e.comm.plugin.b.m mVar, JSONArray jSONArray, JSONObject jSONObject, String str, boolean z3, int i4, com.qq.e.comm.plugin.b.d dVar) throws Throwable {
        int i5;
        com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
        dVar2.a("package_name", str);
        dVar2.a(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis() + "");
        dVar2.a("install_status", z3 ? "1" : "0");
        dVar2.a("plc", com.qq.e.comm.plugin.l0.g.a(mVar));
        jSONArray.put(dVar2);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.c(mVar.c());
        cVar.a(mVar.a());
        String optString = jSONObject.optString("cl");
        cVar.a(optString);
        cVar.a(jSONObject);
        cVar.a(jSONObject.optInt("producttype"));
        String str2 = mVar.c() + "_" + optString;
        long currentTimeMillis = System.currentTimeMillis();
        Long l4 = f46383a.get(str2);
        if (l4 == null) {
            i5 = -999;
        } else {
            long longValue = currentTimeMillis - l4.longValue();
            if (longValue <= 60000) {
                i5 = ((int) (longValue / 1000)) + 1;
            } else {
                i5 = ((int) ((longValue / 60000) * (-1))) - 1;
            }
        }
        f46383a.put(str2, Long.valueOf(currentTimeMillis));
        com.qq.e.comm.plugin.n0.v.a(100202, cVar, Integer.valueOf(i4), Integer.valueOf(i5), dVar2);
        if (dVar == null || !mVar.a().j()) {
            return;
        }
        com.qq.e.comm.plugin.n0.v.a(1400015, cVar, Integer.valueOf((dVar.A() != 0 ? 2 : 1) + (i4 * 10)), Integer.valueOf(i5), dVar2);
    }

    public static int a(Context context, JSONObject jSONObject) {
        boolean d4 = e.d(jSONObject);
        boolean a4 = a(jSONObject);
        boolean b4 = b(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = null;
        String optString = optJSONObject != null ? optJSONObject.optString("pkg_name") : null;
        boolean z3 = b4 && !TextUtils.isEmpty(optString);
        if (d4 || a4 || z3) {
            if (d4) {
                str = e.c(jSONObject);
            } else if (a4) {
                str = "com.jingdong.app.mall";
            } else if (z3) {
                str = optString;
            }
            boolean b5 = com.qq.e.comm.plugin.apkmanager.x.b.b(context, str);
            int optInt = jSONObject.optInt("reltarget");
            if (b5 && optInt == 1) {
                return 2;
            }
            return (b5 || optInt != 2) ? 0 : 1;
        }
        return 0;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 25;
    }

    public static void a(JSONObject jSONObject, Context context) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("last_ads")) || context == null || com.qq.e.comm.plugin.d0.a.d().f().a("cookieForLastAds", 0) != 1) {
            return;
        }
        u1.b("last_ads", jSONObject.optString("last_ads"));
    }

    public static String a(Context context) {
        if (context == null || com.qq.e.comm.plugin.d0.a.d().f().a("cookieForLastAds", 0) != 1) {
            return null;
        }
        return u1.a("last_ads", "");
    }

    public static Pair<JSONArray, Pair<Integer, Integer>> a(JSONObject jSONObject, String str, com.qq.e.comm.plugin.n0.c cVar, boolean z3) {
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            com.qq.e.comm.plugin.l0.e.a(cVar, optInt, z3);
            return new Pair<>(null, new Pair(5004, 2001));
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            com.qq.e.comm.plugin.l0.e.a(cVar, 5004, z3);
            return new Pair<>(null, new Pair(5004, 2002));
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 == null) {
            com.qq.e.comm.plugin.l0.e.a(cVar, 5004, z3);
            return new Pair<>(null, new Pair(5004, 2003));
        }
        int optInt2 = optJSONObject2.optInt("ret");
        if (optInt2 != 0) {
            com.qq.e.comm.plugin.l0.e.a(cVar, optInt2, z3);
            return new Pair<>(null, new Pair(Integer.valueOf(optInt2), 2004));
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            return new Pair<>(optJSONArray, new Pair(2000, 2000));
        }
        com.qq.e.comm.plugin.l0.e.a(cVar, 5025, z3);
        return new Pair<>(null, new Pair(5004, 2005));
    }

    public static boolean a(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar.X0()) {
            if (com.qq.e.comm.plugin.apkmanager.w.b.a().d(context, eVar.q().e()) == 1) {
                return true;
            }
        }
        return false;
    }

    public static long a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return SystemClock.elapsedRealtime();
        }
        long i4 = eVar.i();
        if (eVar.e1() && i4 <= System.currentTimeMillis()) {
            return (i4 - System.currentTimeMillis()) + SystemClock.elapsedRealtime();
        }
        return SystemClock.elapsedRealtime();
    }

    public static int a(int i4, int i5) {
        if (i5 <= 0 || i4 <= 0) {
            if (i5 > 0) {
                return i5;
            }
            if (i4 > 0) {
                return i4;
            }
            return 1560;
        }
        return Math.min(i5, i4);
    }

    public static int a(String str, com.qq.e.comm.plugin.g0.b0 b0Var, com.qq.e.comm.plugin.b.g gVar) {
        return com.qq.e.comm.plugin.edgeanalytics.e.a(gVar, str, b0Var);
    }

    public static boolean a(long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= j4 || j4 <= 0) {
            return false;
        }
        long j5 = elapsedRealtime - j4;
        GDTLogger.e(String.format("\u5f53\u524d\u65f6\u95f4: %s, \u5e7f\u544a\u6709\u6548\u671f: %s, \u5df2\u8fc7\u671f %s:%s:%s\uff0c\u8bf7\u91cd\u65b0\u62c9\u53d6\u5e7f\u544a", Long.valueOf(elapsedRealtime), Long.valueOf(j4), Long.valueOf(j5 / 3600000), Long.valueOf((j5 / 60000) % 60), Long.valueOf((j5 / 1000) % 60)));
        return true;
    }

    public static boolean a(String str) {
        String d4 = com.qq.e.comm.plugin.l0.d.d();
        String c4 = com.qq.e.comm.plugin.l0.d.c();
        String host = Uri.parse(str).getHost();
        return host.equals(Uri.parse("https://mi.gdt.qq.com/").getHost()) || (!TextUtils.isEmpty(d4) && host.equals(Uri.parse(d4).getHost())) || (!TextUtils.isEmpty(c4) && host.equals(Uri.parse(c4).getHost()));
    }
}

package cn.jiguang.y;

import android.content.Context;
import cn.jiguang.ao.e;
import cn.jiguang.internal.JConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static JSONArray a(Context context) {
        JSONObject a4;
        if (cn.jiguang.ar.a.a().g(2600)) {
            return new JSONArray();
        }
        synchronized ("crs.catch") {
            a4 = e.a(context, "crs.catch");
        }
        if (a4 == null) {
            a4 = new JSONObject();
        }
        JSONArray optJSONArray = a4.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cn.jiguang.w.a.b("JDataCollectHelper", "no save data");
            return new JSONArray();
        }
        return a(context, optJSONArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x03a3 A[Catch: all -> 0x04ad, TryCatch #1 {all -> 0x04ad, blocks: (B:75:0x0278, B:77:0x0282, B:79:0x0292, B:127:0x03ff, B:97:0x02e0, B:99:0x02ea, B:101:0x02fe, B:103:0x0309, B:105:0x0319, B:107:0x0326, B:109:0x0336, B:111:0x0343, B:113:0x0353, B:115:0x0360, B:117:0x0370, B:118:0x03a3, B:120:0x03b8, B:122:0x03c8, B:124:0x03d3, B:126:0x03e3, B:84:0x02b3, B:87:0x02bd, B:128:0x0463), top: B:147:0x0278 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONArray a(android.content.Context r32, org.json.JSONArray r33) {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.y.a.a(android.content.Context, org.json.JSONArray):org.json.JSONArray");
    }

    private static JSONObject a(cn.jiguang.z.a aVar) {
        if (aVar == null) {
            cn.jiguang.w.a.b("JDataCollectHelper", "collect is empty, no need cache");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("c_type", aVar.a());
            jSONObject.put("s_type", aVar.b());
            jSONObject.put("result", aVar.c());
            jSONObject.put("c_time", aVar.d());
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.w.a.h("JDataCollectHelper", "formatReportData:" + th);
            return null;
        }
    }

    private static void a(Context context, cn.jiguang.z.a aVar) {
        JSONObject a4 = a(aVar);
        cn.jiguang.w.a.b("JDataCollectHelper", "collect json:" + a4);
        if (a4 != null) {
            a(context, a4);
        }
    }

    public static void a(Context context, String str, int i4) {
        a(context, str, str, i4);
    }

    public static void a(Context context, String str, String str2, int i4) {
        if (cn.jiguang.ar.a.a().f(2600)) {
            if (context == null) {
                context = JConstants.getAppContext(context);
            }
            a(context, new cn.jiguang.z.a().a(str).b(str2).a(i4).a(System.currentTimeMillis()));
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.w.a.b("JDataCollectHelper", "collect data is null for no data to save");
            return;
        }
        cn.jiguang.w.a.b("JDataCollectHelper", "save collect data: " + jSONObject.toString());
        try {
            synchronized ("crs.catch") {
                JSONObject a4 = e.a(context, "crs.catch");
                if (a4 == null) {
                    a4 = new JSONObject();
                }
                JSONArray optJSONArray = a4.optJSONArray("data");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a4.put("data", optJSONArray);
                e.a(context, "crs.catch", a4);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataCollectHelper", "saveData failed: " + th.getMessage());
        }
    }

    public static void b(Context context) {
        synchronized ("crs.catch") {
            e.e(context, "crs.catch");
        }
    }
}

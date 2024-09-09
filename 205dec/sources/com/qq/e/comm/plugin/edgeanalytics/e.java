package com.qq.e.comm.plugin.edgeanalytics;

import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.util.d2;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    public static int a(c cVar) {
        JSONObject a4 = b.c().a(cVar);
        if (a4 != null) {
            return a4.optInt("r");
        }
        return 0;
    }

    public static int b(com.qq.e.comm.plugin.b.g gVar) {
        JSONObject a4 = b.c().a(d.b(gVar));
        if (a4 == null) {
            return 0;
        }
        return a4.optInt("cs", 0);
    }

    public static int c(com.qq.e.comm.plugin.b.g gVar) {
        JSONObject a4 = b.c().a(d.b(gVar));
        if (a4 == null) {
            return 0;
        }
        return a4.optInt("to", 0);
    }

    public static boolean d(com.qq.e.comm.plugin.b.g gVar) {
        JSONObject a4 = b.c().a(d.a(gVar));
        if (a4 == null) {
            return true;
        }
        int optInt = a4.optInt("st", 0);
        int optInt2 = a4.optInt("ed", 0);
        if (optInt < 0 || optInt2 < 0) {
            return false;
        }
        if (optInt == optInt2) {
            return true;
        }
        int a5 = d2.a();
        return optInt < optInt2 ? a5 >= optInt && a5 < optInt2 : a5 >= optInt || a5 < optInt2;
    }

    public static int a(com.qq.e.comm.plugin.d0.e.d dVar, int i4) {
        JSONObject a4 = b.c().a(d.a());
        if (a4 == null) {
            return i4;
        }
        if (com.qq.e.comm.plugin.d0.e.d.WIFI.equals(dVar)) {
            return a4.optInt("wf", i4);
        }
        return a4.optInt("mb", i4);
    }

    public static JSONArray a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONArray("alist");
    }

    public static int a(com.qq.e.comm.plugin.b.g gVar) {
        JSONObject a4 = b.c().a(d.a(gVar));
        if (a4 == null) {
            return 0;
        }
        return a4.optInt("fztime", 0);
    }

    public static boolean a(long j4, com.qq.e.comm.plugin.b.g gVar) {
        int a4 = a(gVar);
        return a4 > 0 && System.currentTimeMillis() - j4 <= ((long) (a4 * 1000)) * 60;
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        return a(eVar.d0(), eVar.o());
    }

    public static int a(com.qq.e.comm.plugin.b.g gVar, String str, b0 b0Var) {
        JSONObject a4 = b.c().a(d.a(gVar, str, b0Var));
        if (a4 == null) {
            return 0;
        }
        return a4.optInt("aet", 0);
    }
}

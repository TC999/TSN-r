package com.qq.e.comm.plugin.q;

import android.util.Log;
import com.qq.e.comm.plugin.n0.v;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {
    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(9130030, cVar, 1, Integer.valueOf(a(i4)), null);
    }

    public static void b() {
        v.a(9130040, (com.qq.e.comm.plugin.n0.c) null);
    }

    public static void b(int i4, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(9130030, cVar, 3, Integer.valueOf(a(i4)), null);
    }

    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, String str) {
        com.qq.e.comm.plugin.n0.d dVar;
        if (i4 > 100) {
            dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", str);
        } else {
            dVar = null;
        }
        v.a(9130030, cVar, 2, Integer.valueOf(a(i4)), dVar);
    }

    public static void b(long j4, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(9130030, cVar, 5, Integer.valueOf(a((int) j4)), null);
    }

    public static void b(String str, com.qq.e.comm.plugin.n0.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("eventId", -1);
            if (optInt == -1) {
                return;
            }
            int optInt2 = jSONObject.optInt("enumCode", -1);
            int optInt3 = jSONObject.optInt("errorCode", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("extra");
            com.qq.e.comm.plugin.n0.d dVar = null;
            Integer valueOf = optInt2 == -1 ? null : Integer.valueOf(optInt2);
            Integer valueOf2 = optInt3 == -1 ? null : Integer.valueOf(optInt3);
            if (optJSONObject != null) {
                dVar = new com.qq.e.comm.plugin.n0.d(optJSONObject);
            }
            v.a(optInt, cVar, valueOf, valueOf2, dVar);
        } catch (Exception unused) {
        }
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(9130031, cVar, 1, 1, null);
    }

    public static void a() {
        v.a(9130031, null, 1, 2, null);
    }

    public static void a(long j4, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(9130030, cVar, 6, Integer.valueOf(a((int) j4)), null);
    }

    public static void a(String str, com.qq.e.comm.plugin.n0.c cVar, Throwable th) {
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        String stackTraceString = Log.getStackTraceString(th);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str + "...\nstack: " + stackTraceString);
        v.a(9130030, cVar, 4, 0, dVar);
    }

    public static void a(String str, com.qq.e.comm.plugin.n0.c cVar) {
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str);
        v.a(9130030, cVar, 4, 1, dVar);
    }

    private static int a(int i4) {
        if (i4 > 100) {
            return 100;
        }
        return i4 / 5;
    }
}

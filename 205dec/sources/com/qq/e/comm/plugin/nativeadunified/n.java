package com.qq.e.comm.plugin.nativeadunified;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (!TextUtils.isEmpty(str)) {
            dVar.a("msg", str);
        }
        v.b(1401001, cVar, Integer.valueOf(i4), dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, int i4, long j4, long j5) {
        v.a(1130115, cVar, 0, new com.qq.e.comm.plugin.n0.d().a("progress", Integer.valueOf(i4)).a("finished", Long.valueOf(j4)).a("total", Long.valueOf(j5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.c(cVar, j4);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.d(cVar, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1060031, cVar, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1060033, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401000, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401002, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1060031, cVar, 1);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1405003, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, boolean z3) {
        v.a(1060029, cVar, Integer.valueOf(z3 ? 1 : 2), 0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.b(cVar, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1060031, cVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, com.qq.e.comm.plugin.n0.c cVar, int i4) {
        if (z3) {
            v.a(1060014, cVar);
        } else {
            v.b(1060013, cVar, Integer.valueOf(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, long j4, long j5) {
        v.a(1130114, cVar, 0, new com.qq.e.comm.plugin.n0.d().a("progress", Integer.valueOf(i4)).a("finished", Long.valueOf(j4)).a("total", Long.valueOf(j5)));
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.a(cVar, j4);
    }

    public static boolean a(com.qq.e.comm.plugin.n0.c cVar, View... viewArr) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < viewArr.length; i4++) {
                View view = viewArr[i4];
                if (!view.isShown() && (view.getWidth() <= 0 || view.getHeight() <= 0)) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("w", Integer.valueOf(view.getWidth()));
                jSONObject.putOpt("h", Integer.valueOf(view.getHeight()));
                jSONObject.putOpt("a", Integer.valueOf((int) (o2.a(view) * 100.0f)));
                jSONArray.put(i4, jSONObject);
            }
            dVar.a("nvi", jSONArray);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        v.a(1060021, cVar, null, null, dVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        v.a(1060032, cVar, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1060031, cVar, 3);
    }
}

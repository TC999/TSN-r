package com.qq.e.comm.plugin.apkmanager.t.b;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.u.i;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends i {

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.t.b.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class C0787b {

        /* renamed from: a  reason: collision with root package name */
        static final b f41894a = new b();
    }

    public static b b() {
        return C0787b.f41894a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "pauseDownloadTask";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return;
        }
        int optInt = d4.optInt("taskId");
        boolean z3 = false;
        ApkDownloadTask a4 = k.e().a(optInt);
        if (a4 != null) {
            com.qq.e.comm.plugin.n0.w.b.b(4001004, a4, 1, 104);
            z3 = k.e().a(a4);
        }
        if (z3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("taskId", optInt);
            } catch (JSONException unused) {
                hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45549d, ""));
            }
            hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45548c, jSONObject));
            return;
        }
        hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45549d, ""));
    }

    private b() {
    }
}

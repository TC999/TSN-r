package com.qq.e.comm.plugin.apkmanager.t.b;

import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.u.i;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f41895a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final c f41896a = new c();
    }

    public static c b() {
        return b.f41896a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "removeDownloadTask";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return;
        }
        int optInt = d4.optInt("taskId");
        if (k.e().a(k.e().a(optInt), this.f41895a)) {
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

    private c() {
        this.f41895a = com.qq.e.comm.plugin.d0.a.d().f().a("dfwrdtdl", 1) == 1;
    }
}

package com.qq.e.comm.plugin.d0;

import android.content.Context;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.d0.c.d;
import com.qq.e.comm.plugin.d0.d.h;
import com.qq.e.comm.plugin.d0.e.c;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.e1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private volatile Context f42201a;

    /* renamed from: b  reason: collision with root package name */
    private volatile h f42202b;

    /* renamed from: c  reason: collision with root package name */
    private volatile d f42203c;

    /* renamed from: d  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.d0.e.a f42204d;

    /* renamed from: e  reason: collision with root package name */
    private volatile c f42205e;

    /* renamed from: f  reason: collision with root package name */
    private volatile JSONObject f42206f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static a f42207a = new a();
    }

    private void a(Context context, JSONObject jSONObject) {
        this.f42201a = context.getApplicationContext();
        this.f42204d = new com.qq.e.comm.plugin.d0.e.a(jSONObject.optString("appId"), context, jSONObject.optString("pn"));
        this.f42205e = new c(this.f42201a);
        this.f42203c = new d(jSONObject.optInt("pv"), jSONObject.optString("sig"));
        this.f42202b = new h(this.f42201a);
        this.f42206f = jSONObject;
    }

    private void c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("ict");
        if (optInt >= 0) {
            com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2030014);
            hVar.b(optInt);
            v.a(hVar);
        }
    }

    public static a d() {
        return b.f42207a;
    }

    private void e(JSONObject jSONObject) {
        int i4;
        if (this.f42203c.b() > 10000) {
            i4 = 1;
        } else if (this.f42203c.b() < SDKStatus.getBuildInPluginVersion()) {
            i4 = 2;
        } else if (SDKStatus.getBuildInPluginVersion() > 0) {
            return;
        } else {
            i4 = 3;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", jSONObject.optString("vas"));
        dVar.a("data", Integer.valueOf(e1.a()));
        v.b(9120028, null, Integer.valueOf(i4), dVar);
    }

    private void g() {
        c(this.f42206f);
        e(this.f42206f);
        d(this.f42206f);
    }

    public synchronized boolean b(Context context, JSONObject jSONObject) {
        a(context, jSONObject);
        return true;
    }

    public h f() {
        return this.f42202b;
    }

    private a() {
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject.optBoolean("mup", true)) {
            return;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", this.f42204d.e());
        v.b(9120038, null, 0, dVar);
    }

    public com.qq.e.comm.plugin.d0.e.a b() {
        return this.f42204d;
    }

    public void b(JSONObject jSONObject) {
        this.f42205e.u();
        a(jSONObject);
        g();
    }

    public c c() {
        return this.f42205e;
    }

    public Context a() {
        return this.f42201a;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        v.a(1440000, null, Integer.valueOf(jSONObject.optInt("scr", -1)));
    }

    public d e() {
        return this.f42203c;
    }
}

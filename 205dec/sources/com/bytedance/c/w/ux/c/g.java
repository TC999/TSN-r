package com.bytedance.c.w.ux.c;

import android.content.Context;
import android.os.Process;
import com.bytedance.c.w.b;
import com.bytedance.c.w.xv;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    protected xv f26605a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f26606b;

    /* renamed from: c  reason: collision with root package name */
    protected com.bytedance.c.w.g f26607c = com.bytedance.c.w.d.a().f();

    /* renamed from: d  reason: collision with root package name */
    protected f f26608d;

    /* renamed from: e  reason: collision with root package name */
    protected d f26609e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(xv xvVar, Context context, f fVar, d dVar) {
        this.f26605a = xvVar;
        this.f26606b = context;
        this.f26608d = fVar;
        this.f26609e = dVar;
    }

    private void d(com.bytedance.c.w.xv.a aVar) {
        List<com.bytedance.c.w.a> a4 = com.bytedance.c.w.d.k().a(this.f26605a);
        if (a4 != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.bytedance.c.w.a aVar2 : a4) {
                Map<? extends String, ? extends String> a5 = aVar2.a(this.f26605a);
                if (a5 != null) {
                    try {
                        for (String str : a5.keySet()) {
                            jSONObject.put(str, a5.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.k("custom", jSONObject);
        }
    }

    public com.bytedance.c.w.xv.a a(com.bytedance.c.w.xv.a aVar) {
        if (aVar == null) {
            aVar = new com.bytedance.c.w.xv.a();
        }
        e(aVar);
        d(aVar);
        return aVar;
    }

    protected boolean b() {
        return true;
    }

    protected void c(com.bytedance.c.w.xv.a aVar) {
        aVar.l(com.bytedance.c.w.ux.e.b(com.bytedance.c.w.d.j().c(), com.bytedance.c.w.d.j().d()));
    }

    void e(com.bytedance.c.w.xv.a aVar) {
        f fVar;
        if (f() && (fVar = this.f26608d) != null) {
            aVar.d(fVar);
        }
        aVar.b(com.bytedance.c.w.d.d());
        f fVar2 = this.f26608d;
        aVar.k("is_background", Boolean.valueOf((fVar2 == null || !fVar2.B()) && !b.e.f(this.f26606b)));
        aVar.k("pid", Integer.valueOf(Process.myPid()));
        aVar.k("battery", Integer.valueOf(this.f26609e.a()));
        aVar.h(this.f26607c.ux());
        aVar.m(com.bytedance.c.w.d.e());
        aVar.a(com.bytedance.c.w.d.g(), com.bytedance.c.w.d.f());
        aVar.g(this.f26607c.f());
        aVar.i(b.r.b(this.f26606b));
        if (b()) {
            c(aVar);
        }
        aVar.f(this.f26607c.sr());
        String h4 = com.bytedance.c.w.d.h();
        if (h4 != null) {
            aVar.k("business", h4);
        }
        if (com.bytedance.c.w.d.c()) {
            aVar.k("is_mp", 1);
        }
        aVar.n(com.bytedance.c.w.d.k().b());
        aVar.k("crash_uuid", UUID.randomUUID().toString());
    }

    protected boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(com.bytedance.c.w.xv.a aVar) {
        Map<String, Object> a4 = com.bytedance.c.w.d.a().a();
        if (a4 == null) {
            return;
        }
        if (a4.containsKey("app_version")) {
            aVar.k("crash_version", a4.get("app_version"));
        }
        if (a4.containsKey("version_name")) {
            aVar.k("app_version", a4.get("version_name"));
        }
        if (a4.containsKey("version_code")) {
            try {
                aVar.k("crash_version_code", Integer.valueOf(Integer.parseInt(a4.get("version_code").toString())));
            } catch (Exception unused) {
                aVar.k("crash_version_code", a4.get("version_code"));
            }
        }
        if (a4.containsKey("update_version_code")) {
            try {
                aVar.k("crash_update_version_code", Integer.valueOf(Integer.parseInt(a4.get("update_version_code").toString())));
            } catch (Exception unused2) {
                aVar.k("crash_update_version_code", a4.get("update_version_code"));
            }
        }
    }
}

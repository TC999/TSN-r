package com.beizi.fusion.sm.a.a;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;

/* compiled from: OAIDFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static com.beizi.fusion.sm.a.d f15057a;

    public static com.beizi.fusion.sm.a.d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        com.beizi.fusion.sm.a.d dVar = f15057a;
        if (dVar != null) {
            return dVar;
        }
        com.beizi.fusion.sm.a.d b4 = b(context);
        f15057a = b4;
        if (b4 != null && b4.a()) {
            com.beizi.fusion.sm.a.f.a("Manufacturer interface has been found: " + f15057a.getClass().getName());
            return f15057a;
        }
        com.beizi.fusion.sm.a.d c4 = c(context);
        f15057a = c4;
        return c4;
    }

    private static com.beizi.fusion.sm.a.d b(Context context) {
        if (!com.beizi.fusion.sm.a.g.k() && !com.beizi.fusion.sm.a.g.n()) {
            if (com.beizi.fusion.sm.a.g.j()) {
                return new i(context);
            }
            if (com.beizi.fusion.sm.a.g.l()) {
                return new k(context);
            }
            if (!com.beizi.fusion.sm.a.g.e() && !com.beizi.fusion.sm.a.g.f() && !com.beizi.fusion.sm.a.g.g()) {
                if (com.beizi.fusion.sm.a.g.i()) {
                    return new o(context);
                }
                if (com.beizi.fusion.sm.a.g.d()) {
                    return new p(context);
                }
                if (com.beizi.fusion.sm.a.g.m()) {
                    return new a(context);
                }
                if (!com.beizi.fusion.sm.a.g.a() && !com.beizi.fusion.sm.a.g.b()) {
                    if (!com.beizi.fusion.sm.a.g.c() && !com.beizi.fusion.sm.a.g.h()) {
                        if (com.beizi.fusion.sm.a.g.a(context)) {
                            return new b(context);
                        }
                        if (com.beizi.fusion.sm.a.g.p()) {
                            return new c(context);
                        }
                        if (com.beizi.fusion.sm.a.g.o()) {
                            return new e(context);
                        }
                        return null;
                    }
                    return new n(context);
                }
                return new g(context);
            }
            return new q(context);
        }
        return new h(context);
    }

    private static com.beizi.fusion.sm.a.d c(Context context) {
        j jVar = new j(context);
        if (jVar.a()) {
            com.beizi.fusion.sm.a.f.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        f fVar = new f(context);
        if (fVar.a()) {
            com.beizi.fusion.sm.a.f.a("Google Play Service has been found: " + f.class.getName());
            return fVar;
        }
        d dVar = new d();
        com.beizi.fusion.sm.a.f.a("OAID was not supported: " + d.class.getName());
        return dVar;
    }
}

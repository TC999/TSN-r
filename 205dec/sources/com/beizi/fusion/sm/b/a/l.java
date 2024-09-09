package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;

/* compiled from: OAIDFactory.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static com.beizi.fusion.sm.b.c f15094a;

    public static com.beizi.fusion.sm.b.c a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        com.beizi.fusion.sm.b.c cVar = f15094a;
        if (cVar != null) {
            return cVar;
        }
        com.beizi.fusion.sm.b.c b4 = b(context);
        f15094a = b4;
        if (b4 != null && b4.a()) {
            com.beizi.fusion.sm.b.e.a("Manufacturer interface has been found: " + f15094a.getClass().getName());
            return f15094a;
        }
        com.beizi.fusion.sm.b.c c4 = c(context);
        f15094a = c4;
        return c4;
    }

    private static com.beizi.fusion.sm.b.c b(Context context) {
        if (!com.beizi.fusion.sm.b.f.k() && !com.beizi.fusion.sm.b.f.n()) {
            if (com.beizi.fusion.sm.b.f.j()) {
                return new i(context);
            }
            if (com.beizi.fusion.sm.b.f.l()) {
                return new k(context);
            }
            if (!com.beizi.fusion.sm.b.f.e() && !com.beizi.fusion.sm.b.f.f() && !com.beizi.fusion.sm.b.f.g()) {
                if (com.beizi.fusion.sm.b.f.i()) {
                    return new o(context);
                }
                if (com.beizi.fusion.sm.b.f.d()) {
                    return new p(context);
                }
                if (com.beizi.fusion.sm.b.f.m()) {
                    return new a(context);
                }
                if (!com.beizi.fusion.sm.b.f.a() && !com.beizi.fusion.sm.b.f.b()) {
                    if (!com.beizi.fusion.sm.b.f.c() && !com.beizi.fusion.sm.b.f.h()) {
                        if (com.beizi.fusion.sm.b.f.a(context)) {
                            return new b(context);
                        }
                        if (com.beizi.fusion.sm.b.f.p()) {
                            return new c(context);
                        }
                        if (com.beizi.fusion.sm.b.f.o()) {
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

    private static com.beizi.fusion.sm.b.c c(Context context) {
        j jVar = new j(context);
        if (jVar.a()) {
            com.beizi.fusion.sm.b.e.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        f fVar = new f(context);
        if (fVar.a()) {
            com.beizi.fusion.sm.b.e.a("Google Play Service has been found: " + f.class.getName());
            return fVar;
        }
        d dVar = new d();
        com.beizi.fusion.sm.b.e.a("OAID was not supported: " + d.class.getName());
        return dVar;
    }
}

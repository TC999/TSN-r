package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: VolleyManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static n f39644c;

    /* renamed from: a  reason: collision with root package name */
    private j f39645a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.d.b f39646b;

    private n() {
    }

    public static void a(Context context) {
        if (f39644c == null) {
            n nVar = new n();
            f39644c = nVar;
            nVar.f39645a = new j(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            f39644c.f39646b = new com.mbridge.msdk.foundation.same.net.d.b(b(), 3);
        }
    }

    private static j b() {
        n nVar = f39644c;
        if (nVar != null) {
            j jVar = nVar.f39645a;
            if (jVar != null) {
                return jVar;
            }
            nVar.f39645a = new j(com.mbridge.msdk.foundation.controller.a.f().j());
            return f39644c.f39645a;
        }
        n nVar2 = new n();
        f39644c = nVar2;
        if (nVar2.f39645a == null) {
            nVar2.f39645a = new j(com.mbridge.msdk.foundation.controller.a.f().j());
        }
        return f39644c.f39645a;
    }

    public static void a(i iVar) {
        b().a(iVar);
    }

    public static com.mbridge.msdk.foundation.same.net.d.b a() {
        n nVar = f39644c;
        if (nVar != null) {
            com.mbridge.msdk.foundation.same.net.d.b bVar = nVar.f39646b;
            if (bVar != null) {
                return bVar;
            }
            nVar.f39646b = new com.mbridge.msdk.foundation.same.net.d.b(b(), 3);
            return f39644c.f39646b;
        }
        n nVar2 = new n();
        f39644c = nVar2;
        if (nVar2.f39646b == null) {
            nVar2.f39646b = new com.mbridge.msdk.foundation.same.net.d.b(b(), 3);
        }
        return f39644c.f39646b;
    }
}

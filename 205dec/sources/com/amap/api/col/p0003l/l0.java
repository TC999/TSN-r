package com.amap.api.col.p0003l;

import android.content.Context;
import com.stub.StubApp;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TaskManager.java */
/* renamed from: com.amap.api.col.3l.l0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l0 {

    /* renamed from: d  reason: collision with root package name */
    private static l0 f8290d;

    /* renamed from: a  reason: collision with root package name */
    private z7 f8291a;

    /* renamed from: b  reason: collision with root package name */
    private LinkedHashMap<String, a8> f8292b = new LinkedHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f8293c = true;

    private l0() {
        try {
            if (this.f8291a == null) {
                this.f8291a = z7.k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static l0 a() {
        return f();
    }

    private static synchronized l0 f() {
        l0 l0Var;
        synchronized (l0.class) {
            try {
                l0 l0Var2 = f8290d;
                if (l0Var2 == null) {
                    f8290d = new l0();
                } else if (l0Var2.f8291a == null) {
                    l0Var2.f8291a = z7.j();
                }
                l0Var = f8290d;
            }
        }
        return l0Var;
    }

    private void g() {
        synchronized (this.f8292b) {
            if (this.f8292b.size() <= 0) {
                return;
            }
            for (Map.Entry<String, a8> entry : this.f8292b.entrySet()) {
                entry.getKey();
                ((h0) entry.getValue()).a();
            }
            this.f8292b.clear();
        }
    }

    private static void h() {
        f8290d = null;
    }

    public final void b(k0 k0Var) {
        synchronized (this.f8292b) {
            h0 h0Var = (h0) this.f8292b.get(k0Var.b());
            if (h0Var == null) {
                return;
            }
            h0Var.a();
            this.f8292b.remove(k0Var.b());
        }
    }

    public final void c(k0 k0Var, Context context) throws fk {
        if (!this.f8292b.containsKey(k0Var.b())) {
            h0 h0Var = new h0((b1) k0Var, StubApp.getOrigApplicationContext(context.getApplicationContext()), (byte) 0);
            synchronized (this.f8292b) {
                this.f8292b.put(k0Var.b(), h0Var);
            }
        }
        this.f8291a.b(this.f8292b.get(k0Var.b()));
    }

    public final void d() {
        g();
        this.f8291a.g();
        this.f8291a = null;
        h();
    }

    public final void e(k0 k0Var) {
        h0 h0Var = (h0) this.f8292b.get(k0Var.b());
        if (h0Var != null) {
            synchronized (this.f8292b) {
                h0Var.b();
                this.f8292b.remove(k0Var.b());
            }
        }
    }
}

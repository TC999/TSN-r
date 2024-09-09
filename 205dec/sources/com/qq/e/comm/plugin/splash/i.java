package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.plugin.g0.c0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class i {

    /* renamed from: d  reason: collision with root package name */
    private k f46118d;

    /* renamed from: f  reason: collision with root package name */
    private h f46120f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46121g;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<Boolean> f46115a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f46116b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.r.g f46117c = new com.qq.e.comm.plugin.splash.r.g();

    /* renamed from: e  reason: collision with root package name */
    private final List<k> f46119e = new ArrayList(4);

    public String d() {
        k kVar = this.f46118d;
        if (kVar == null) {
            return null;
        }
        return kVar.e();
    }

    public boolean e() {
        return this.f46117c.f46178c == null;
    }

    public File b() {
        k kVar = this.f46118d;
        if (kVar == null) {
            return null;
        }
        return kVar.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0 c() {
        k kVar = this.f46118d;
        if (kVar == null) {
            return null;
        }
        return kVar.d();
    }

    public void a(h hVar, com.qq.e.comm.plugin.splash.r.f fVar) {
        this.f46120f = hVar;
        this.f46121g = hVar.f46106r;
        this.f46117c.f46178c = fVar;
        this.f46115a.set(null);
        this.f46116b.set(0);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements com.qq.e.comm.plugin.splash.r.f {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f46122c;

        a(k kVar) {
            this.f46122c = kVar;
        }

        @Override // com.qq.e.comm.plugin.splash.r.f
        public void a() {
            if (i.this.e() || !i.this.f46115a.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
                return;
            }
            i.this.f46118d = this.f46122c;
            i.this.f46117c.a();
        }

        @Override // com.qq.e.comm.plugin.splash.r.f
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            if (!i.this.e() && i.this.f46116b.decrementAndGet() == 0 && i.this.f46115a.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
                i.this.f46117c.a(dVar);
            }
        }
    }

    public void a() {
        this.f46115a.set(null);
        this.f46117c.f46178c = null;
        for (k kVar : this.f46119e) {
            if (kVar != null) {
                kVar.a();
            }
        }
        this.f46119e.clear();
    }

    public void a(boolean z3) {
        this.f46121g = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c0 c0Var) {
        if (c0Var == null || e()) {
            return;
        }
        if (this.f46115a.compareAndSet(null, Boolean.FALSE) || !this.f46115a.get().booleanValue()) {
            this.f46116b.incrementAndGet();
            k kVar = new k(this.f46121g);
            if (this.f46118d == null) {
                this.f46118d = kVar;
            }
            kVar.a(this.f46120f, new a(kVar));
            kVar.b();
            this.f46119e.add(kVar);
        }
    }
}

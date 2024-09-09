package com.qq.e.comm.plugin.splash;

import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.s0;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<Boolean> f46127a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f46128b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.r.g f46129c = new com.qq.e.comm.plugin.splash.r.g();

    /* renamed from: d  reason: collision with root package name */
    private volatile File f46130d;

    /* renamed from: e  reason: collision with root package name */
    private volatile String f46131e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f46132f;

    /* renamed from: g  reason: collision with root package name */
    private c0 f46133g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f46134h;

    /* renamed from: i  reason: collision with root package name */
    private h f46135i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.b0.c {
        a() {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
            k.this.a((File) null, (String) null);
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            File d4 = fVar.d();
            if (d4 == null || !d4.exists()) {
                k.this.a((File) null, (String) null);
            } else {
                k.this.a(d4, (String) null);
            }
            if (fVar.a()) {
                return;
            }
            v.a(9130005, k.this.f46135i.c(), 3);
        }
    }

    public k(boolean z3) {
        this.f46132f = z3;
    }

    public void b() {
        if (!f() && this.f46127a.compareAndSet(null, Boolean.FALSE) && this.f46128b.compareAndSet(0, 2)) {
            a(this.f46133g);
            a(this.f46133g, false);
        }
    }

    public File c() {
        return this.f46130d;
    }

    public c0 d() {
        return this.f46133g;
    }

    public String e() {
        if (this.f46134h) {
            this.f46134h = false;
            a(this.f46133g, true);
        }
        return this.f46131e;
    }

    public boolean f() {
        return this.f46129c.f46178c == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.p.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f46137a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f46138b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c0 f46139c;

        b(boolean z3, String str, c0 c0Var) {
            this.f46137a = z3;
            this.f46138b = str;
            this.f46139c = c0Var;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
            if (this.f46137a) {
                k.this.a((File) null, this.f46138b);
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
            k.this.f46134h = false;
            k.this.a((File) null, (String) null);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
            if (this.f46137a) {
                k.this.a((File) null, this.f46138b);
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            k.this.f46134h = false;
            if (k.this.a(file, this.f46139c)) {
                k.this.a((File) null, file.getAbsolutePath());
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
            if (!z3 || !this.f46137a) {
                k.this.f46134h = false;
                k.this.a((File) null, (String) null);
                return;
            }
            k.this.f46134h = true;
            k.this.a((File) null, this.f46138b);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            k.this.f46134h = false;
            k.this.a((File) null, (String) null);
        }
    }

    public void a(h hVar, com.qq.e.comm.plugin.splash.r.f fVar) {
        this.f46135i = hVar;
        this.f46133g = hVar.b();
        this.f46129c.f46178c = fVar;
        this.f46127a.set(null);
        this.f46128b.set(0);
    }

    public void a() {
        this.f46127a.set(null);
        this.f46131e = null;
        this.f46130d = null;
        this.f46129c.f46178c = null;
        this.f46128b.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, String str) {
        if (f()) {
            return;
        }
        if (file != null) {
            if (this.f46130d == null) {
                this.f46128b.decrementAndGet();
            }
            this.f46130d = file;
        } else if (str != null) {
            if (this.f46131e == null) {
                this.f46128b.decrementAndGet();
            }
            this.f46131e = str;
        } else {
            this.f46128b.decrementAndGet();
        }
        if (this.f46131e == null && (this.f46130d == null || this.f46128b.get() != 0)) {
            if (this.f46128b.get() == 0 && this.f46127a.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
                this.f46129c.a(new com.qq.e.comm.plugin.p.d(this.f46133g.l1() ? 5002 : 5008, ""));
            }
        } else if (this.f46127a.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
            this.f46129c.a();
        }
    }

    private void a(c0 c0Var) {
        if (c0Var == null) {
            a((File) null, (String) null);
            return;
        }
        String X = c0Var.X();
        if (TextUtils.isEmpty(X)) {
            a((File) null, (String) null);
            return;
        }
        File file = new File(b1.b(), b1.e(X));
        if (file.exists()) {
            a(file, (String) null);
            return;
        }
        com.qq.e.comm.plugin.b0.b a4 = com.qq.e.comm.plugin.b0.b.a();
        a aVar = new a();
        a4.a(X, aVar, com.qq.e.comm.plugin.util.v2.a.b("vcri") + c0Var.o().d());
    }

    private void a(c0 c0Var, boolean z3) {
        if (c0Var == null) {
            a((File) null, (String) null);
            return;
        }
        String L0 = c0Var.L0();
        if (TextUtils.isEmpty(L0)) {
            a((File) null, (String) null);
            return;
        }
        String d4 = b1.d(L0);
        File c4 = b1.c(L0);
        if (a(c4, c0Var)) {
            a((File) null, c4.getAbsolutePath());
        } else if (this.f46130d != null && c0Var.y1() && com.qq.e.comm.plugin.util.v2.a.e(c0Var)) {
            a((File) null, (String) null);
            n.a(this.f46135i.c());
        } else {
            String a4 = com.qq.e.comm.plugin.p0.e.a().a(L0);
            boolean z4 = !TextUtils.isEmpty(a4);
            b.C0867b c5 = new b.C0867b().d(L0).a(b1.p()).a(d4).d(!z4).a(com.qq.e.comm.plugin.n0.c.a(c0Var)).c(com.qq.e.comm.plugin.util.v2.a.b("vcrp") + c0Var.o().d());
            if (z4 && !this.f46132f && !z3 && com.qq.e.comm.plugin.util.v2.a.c(c0Var)) {
                double H = c0Var.H();
                if (com.qq.e.comm.plugin.util.v2.a.a(H)) {
                    this.f46134h = true;
                    a((File) null, a4);
                    v.a(1400011, this.f46135i.c(), 0);
                    return;
                } else if (com.qq.e.comm.plugin.util.v2.a.b(H)) {
                    this.f46134h = true;
                    c5.a(com.qq.e.comm.plugin.util.v2.a.a(H, c0Var.M0()));
                }
            }
            com.qq.e.comm.plugin.o0.g.a.a().a(c5.a(), new b(z4, a4, c0Var));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(File file, c0 c0Var) {
        if (c0Var == null || file == null || !file.exists()) {
            return false;
        }
        return (c0Var.Y0() && c0Var.e1() && !TextUtils.isEmpty(c0Var.v1()) && j.g() && !c0Var.v1().equals(s0.a(file))) ? false : true;
    }
}

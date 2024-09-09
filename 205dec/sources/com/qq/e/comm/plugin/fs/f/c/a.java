package com.qq.e.comm.plugin.fs.f.c;

import com.qq.e.comm.plugin.dl.LandingPageCallback;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.h.f;
import com.qq.e.comm.plugin.util.j0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final j0 f43312a;

    /* renamed from: b  reason: collision with root package name */
    private final s f43313b;

    /* renamed from: c  reason: collision with root package name */
    private final f f43314c;

    /* renamed from: d  reason: collision with root package name */
    private final LandingPageCallback f43315d;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0827a extends com.qq.e.comm.plugin.h.d<Void> {
        C0827a(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r3) {
            a.this.f43312a.a("bottomCardVis", 0);
            a.this.f43313b.a(a.this.f43312a.a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b extends com.qq.e.comm.plugin.h.d<Integer> {
        b(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            if (num == null) {
                return;
            }
            a.this.f43312a.a("autoTipVis", 0);
            a.this.f43312a.a("tipText", num.toString());
            a.this.f43313b.a(a.this.f43312a.a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c extends com.qq.e.comm.plugin.h.d<Void> {
        c(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r3) {
            a.this.f43312a.a("autoTipVis", 2);
            a.this.f43313b.a(a.this.f43312a.a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d extends com.qq.e.comm.plugin.h.d<Void> {
        d(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r3) {
            a.this.f43312a.a("autoTipVis", 2);
            a.this.f43312a.a("bottomCardVis", 2);
            a.this.f43313b.a(a.this.f43312a.a());
        }
    }

    public a(e eVar, j0 j0Var, s sVar, f fVar) {
        this.f43312a = j0Var;
        this.f43313b = sVar;
        this.f43314c = fVar;
        this.f43315d = (LandingPageCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), LandingPageCallback.class);
    }

    public void c() {
        this.f43315d.K().a(new C0827a(this.f43314c));
        this.f43315d.n().a(new b(this.f43314c));
        this.f43315d.q().a(new c(this.f43314c));
        this.f43315d.u().a(new d(this.f43314c));
    }

    public void a() {
        this.f43315d.F().a();
        this.f43312a.a("bottomCardVis", 2);
        this.f43312a.a("autoTipVis", 2);
        this.f43313b.a(this.f43312a.a());
    }

    public void b() {
        this.f43315d.q().a();
        this.f43312a.a("autoTipVis", 2);
        this.f43313b.a(this.f43312a.a());
    }
}

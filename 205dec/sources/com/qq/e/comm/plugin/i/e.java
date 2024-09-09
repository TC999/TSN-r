package com.qq.e.comm.plugin.i;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a extends com.qq.e.comm.plugin.i.a {
        public a() {
            this.f44053a.add(y.class);
            this.f44053a.add(q.class);
            this.f44053a.add(s.class);
            this.f44053a.add(t.class);
            this.f44053a.add(b0.class);
            this.f44053a.add(l.class);
            this.f44053a.add(com.qq.e.comm.plugin.i.c.class);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b extends com.qq.e.comm.plugin.i.a {
        public b() {
            this.f44053a.add(z.class);
            this.f44053a.add(k.class);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c extends com.qq.e.comm.plugin.i.a {
        public c() {
            this.f44053a.add(y.class);
            this.f44053a.add(q.class);
            this.f44053a.add(r.class);
            this.f44053a.add(l.class);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class d extends com.qq.e.comm.plugin.i.a {
        public d() {
            this.f44053a.add(y.class);
            this.f44053a.add(v.class);
            this.f44053a.add(l.class);
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.i.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class C0845e extends com.qq.e.comm.plugin.i.a {
        public C0845e() {
            this.f44053a.add(y.class);
            this.f44053a.add(x.class);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class f extends com.qq.e.comm.plugin.i.a {
        public f() {
            this.f44053a.add(y.class);
            this.f44053a.add(q.class);
            this.f44053a.add(n.class);
            this.f44053a.add(m.class);
            this.f44053a.add(l.class);
        }
    }

    public static p a(h hVar) {
        if (hVar.C.k1()) {
            return new c0();
        }
        if (hVar.C.m1()) {
            return new C0845e();
        }
        if (hVar.f44135h) {
            return new a();
        }
        if (hVar.f44137j != null) {
            return new f();
        }
        if (hVar.C.g1()) {
            return new d();
        }
        return new c();
    }

    public static p a() {
        return new b();
    }
}

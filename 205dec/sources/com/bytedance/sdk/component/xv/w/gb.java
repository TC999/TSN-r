package com.bytedance.sdk.component.xv.w;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class gb implements ux {

    /* renamed from: c  reason: collision with root package name */
    final j f31013c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31014f;
    final boolean sr;
    private fp ux;

    /* renamed from: w  reason: collision with root package name */
    final com.bytedance.sdk.component.xv.w.c.xv.p f31015w;
    final n xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class c extends com.bytedance.sdk.component.xv.w.c.w {
        private final f xv;

        c(f fVar) {
            super("OkHttp %s", gb.this.r());
            this.xv = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String c() {
            return gb.this.xv.c().r();
        }

        public void w() {
            z zVar;
            n nVar = gb.this.xv;
            if (nVar == null || (zVar = nVar.f31068f) == null) {
                return;
            }
            zVar.k();
        }

        @Override // com.bytedance.sdk.component.xv.w.c.w
        protected void xv() {
            ba ev;
            z zVar;
            boolean z3 = false;
            try {
                try {
                    try {
                        n nVar = gb.this.xv;
                        if (nVar != null && (zVar = nVar.f31068f) != null) {
                            zVar.c();
                        }
                        ev = gb.this.ev();
                        try {
                            if (gb.this.f31015w.w()) {
                                this.xv.c(gb.this, new IOException("Canceled"));
                            } else {
                                this.xv.c(gb.this, ev);
                            }
                        } catch (IOException e4) {
                            e = e4;
                            z3 = true;
                            if (!z3) {
                                gb.this.ux.c(gb.this, e);
                                this.xv.c(gb.this, e);
                            } else {
                                com.bytedance.sdk.component.xv.w.c.r.ux w3 = com.bytedance.sdk.component.xv.w.c.r.ux.w();
                                w3.c(4, "Callback failure for " + gb.this.f(), e);
                            }
                            return;
                        }
                    } catch (Exception e5) {
                        gb.this.ux.c(gb.this, new IOException(e5));
                        this.xv.c(gb.this, new IOException(e5));
                    }
                } catch (IOException e6) {
                    e = e6;
                }
                if (ev.xv != 0) {
                    return;
                }
                throw new IOException(ev.sr);
            } finally {
                gb.this.f31013c.fz().w(this);
            }
        }
    }

    private gb(j jVar, n nVar, boolean z3) {
        this.f31013c = jVar;
        this.xv = nVar;
        this.sr = z3;
        this.f31015w = new com.bytedance.sdk.component.xv.w.c.xv.p(jVar, z3);
    }

    private void gd() {
        this.f31015w.c(com.bytedance.sdk.component.xv.w.c.r.ux.w().c("response.body().close()"));
    }

    ba ev() throws IOException {
        ArrayList arrayList = new ArrayList(this.f31013c.q());
        arrayList.add(this.f31015w);
        arrayList.add(new com.bytedance.sdk.component.xv.w.c.xv.c(this.f31013c.f()));
        arrayList.add(new com.bytedance.sdk.component.xv.w.c.c.c(this.f31013c.r()));
        arrayList.add(new com.bytedance.sdk.component.xv.w.c.w.c(this.f31013c));
        if (!this.sr) {
            arrayList.addAll(this.f31013c.j());
        }
        arrayList.add(new com.bytedance.sdk.component.xv.w.c.xv.w(this.sr));
        return new com.bytedance.sdk.component.xv.w.c.xv.r(arrayList, null, null, null, 0, this.xv, this, this.ux, this.f31013c.c(), this.f31013c.w(), this.f31013c.xv()).c(this.xv);
    }

    String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(xv() ? "canceled " : "");
        sb.append(this.sr ? "web socket" : "call");
        sb.append(" to ");
        sb.append(r());
        return sb.toString();
    }

    String r() {
        return this.xv.c().bk();
    }

    @Override // com.bytedance.sdk.component.xv.w.ux
    /* renamed from: ux */
    public gb sr() {
        return c(this.f31013c, this.xv, this.sr);
    }

    @Override // com.bytedance.sdk.component.xv.w.ux
    public void w() {
        this.f31015w.c();
    }

    @Override // com.bytedance.sdk.component.xv.w.ux
    public boolean xv() {
        return this.f31015w.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static gb c(j jVar, n nVar, boolean z3) {
        gb gbVar = new gb(jVar, nVar, z3);
        gbVar.ux = jVar.ls().c(gbVar);
        return gbVar;
    }

    @Override // com.bytedance.sdk.component.xv.w.ux
    public ba c() throws IOException {
        synchronized (this) {
            if (!this.f31014f) {
                this.f31014f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        gd();
        this.ux.c(this);
        try {
            try {
                z zVar = this.xv.f31068f;
                if (zVar != null) {
                    zVar.c();
                }
                this.f31013c.fz().c(this);
                ba ev = ev();
                if (ev != null) {
                    if (ev.xv != 0) {
                        return ev;
                    }
                    throw new IOException(ev.sr);
                }
                throw new IOException("Canceled");
            } catch (IOException e4) {
                this.ux.c(this, e4);
                return null;
            } catch (Exception e5) {
                this.ux.c(this, new IOException(e5));
                return null;
            }
        } finally {
            this.f31013c.fz().w(this);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.ux
    public void c(f fVar) {
        try {
            synchronized (this) {
                if (!this.f31014f) {
                    this.f31014f = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            gd();
            this.ux.c(this);
            this.f31013c.fz().c(new c(fVar));
        } catch (Throwable th) {
            if (fVar != null) {
                fVar.c(this, new IOException(th.getMessage()));
            }
        }
    }
}

package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealCall.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class x implements e {

    /* renamed from: a  reason: collision with root package name */
    final v f1437a;

    /* renamed from: b  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j f1438b;

    /* renamed from: c  reason: collision with root package name */
    private p f1439c;

    /* renamed from: d  reason: collision with root package name */
    final y f1440d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f1441e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1442f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public final class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        private final f f1443b;

        a(f fVar) {
            super("OkHttp %s", x.this.c());
            this.f1443b = fVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        protected void b() {
            IOException e4;
            a0 a4;
            boolean z3 = true;
            try {
                try {
                    a4 = x.this.a();
                } catch (IOException e5) {
                    e4 = e5;
                    z3 = false;
                }
                try {
                    if (x.this.f1438b.a()) {
                        this.f1443b.a(x.this, new IOException("Canceled"));
                    } else {
                        this.f1443b.a(x.this, a4);
                    }
                } catch (IOException e6) {
                    e4 = e6;
                    if (!z3) {
                        x.this.f1439c.a(x.this, e4);
                        this.f1443b.a(x.this, e4);
                    } else {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e b4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b();
                        b4.a(4, "Callback failure for " + x.this.d(), e4);
                    }
                }
            } finally {
                x.this.f1437a.g().b(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String c() {
            return x.this.f1440d.g().g();
        }
    }

    private x(v vVar, y yVar, boolean z3) {
        this.f1437a = vVar;
        this.f1440d = yVar;
        this.f1441e = z3;
        this.f1438b = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j(vVar, z3);
    }

    private void e() {
        this.f1438b.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a("response.body().close()"));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e
    public a0 A() throws IOException {
        synchronized (this) {
            if (!this.f1442f) {
                this.f1442f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        e();
        this.f1439c.b(this);
        try {
            try {
                this.f1437a.g().a(this);
                a0 a4 = a();
                if (a4 != null) {
                    return a4;
                }
                throw new IOException("Canceled");
            } catch (IOException e4) {
                this.f1439c.a(this, e4);
                throw e4;
            }
        } finally {
            this.f1437a.g().b(this);
        }
    }

    public boolean b() {
        return this.f1438b.a();
    }

    String c() {
        return this.f1440d.g().l();
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.f1441e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(c());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x a(v vVar, y yVar, boolean z3) {
        x xVar = new x(vVar, yVar, z3);
        xVar.f1439c = vVar.i().a(xVar);
        return xVar;
    }

    /* renamed from: clone */
    public x m8clone() {
        return a(this.f1437a, this.f1440d, this.f1441e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e
    public void a(f fVar) {
        synchronized (this) {
            if (!this.f1442f) {
                this.f1442f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        e();
        this.f1439c.b(this);
        this.f1437a.g().a(new a(fVar));
    }

    a0 a() throws IOException {
        ArrayList arrayList = new ArrayList(this.f1437a.m());
        arrayList.add(this.f1438b);
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.a(this.f1437a.f()));
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a(this.f1437a.n()));
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.a(this.f1437a));
        if (!this.f1441e) {
            arrayList.addAll(this.f1437a.o());
        }
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.b(this.f1441e));
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.g(arrayList, null, null, null, 0, this.f1440d, this, this.f1439c, this.f1437a.c(), this.f1437a.t(), this.f1437a.x()).a(this.f1440d);
    }
}

package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* compiled from: StreamAllocation.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class g {

    /* renamed from: o  reason: collision with root package name */
    static final /* synthetic */ boolean f984o = true;

    /* renamed from: a  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a f985a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f986b;

    /* renamed from: c  reason: collision with root package name */
    private c0 f987c;

    /* renamed from: d  reason: collision with root package name */
    private final j f988d;

    /* renamed from: e  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f989e;

    /* renamed from: f  reason: collision with root package name */
    public final p f990f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f991g;

    /* renamed from: h  reason: collision with root package name */
    private final f f992h;

    /* renamed from: i  reason: collision with root package name */
    private int f993i;

    /* renamed from: j  reason: collision with root package name */
    private c f994j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f995k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f996l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f997m;

    /* renamed from: n  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c f998n;

    /* compiled from: StreamAllocation.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f999a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f999a = obj;
        }
    }

    public g(j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar, Object obj) {
        this.f988d = jVar;
        this.f985a = aVar;
        this.f989e = eVar;
        this.f990f = pVar;
        this.f992h = new f(aVar, g(), eVar, pVar);
        this.f991g = obj;
    }

    private Socket f() {
        if (f984o || Thread.holdsLock(this.f988d)) {
            c cVar = this.f994j;
            if (cVar == null || !cVar.f966k) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    private d g() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(this.f988d);
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a(v vVar, t.a aVar, boolean z3) {
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a4 = a(aVar.c(), aVar.d(), aVar.a(), vVar.u(), z3).a(vVar, aVar, this);
            synchronized (this.f988d) {
                this.f998n = a4;
            }
            return a4;
        } catch (IOException e4) {
            throw new e(e4);
        }
    }

    public synchronized c b() {
        return this.f994j;
    }

    public boolean c() {
        f.a aVar;
        return this.f987c != null || ((aVar = this.f986b) != null && aVar.b()) || this.f992h.a();
    }

    public void d() {
        c cVar;
        Socket a4;
        synchronized (this.f988d) {
            cVar = this.f994j;
            a4 = a(true, false, false);
            if (this.f994j != null) {
                cVar = null;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a4);
        if (cVar != null) {
            this.f990f.b(this.f989e, cVar);
        }
    }

    public void e() {
        c cVar;
        Socket a4;
        synchronized (this.f988d) {
            cVar = this.f994j;
            a4 = a(false, true, false);
            if (this.f994j != null) {
                cVar = null;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a4);
        if (cVar != null) {
            this.f990f.b(this.f989e, cVar);
        }
    }

    public String toString() {
        c b4 = b();
        return b4 != null ? b4.toString() : this.f985a.toString();
    }

    private void b(c cVar) {
        int size = cVar.f969n.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (cVar.f969n.get(i4).get() == this) {
                cVar.f969n.remove(i4);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private c a(int i4, int i5, int i6, boolean z3, boolean z4) throws IOException {
        while (true) {
            c a4 = a(i4, i5, i6, z3);
            synchronized (this.f988d) {
                if (a4.f967l == 0) {
                    return a4;
                }
                if (a4.a(z4)) {
                    return a4;
                }
                d();
            }
        }
    }

    private c a(int i4, int i5, int i6, boolean z3) throws IOException {
        c cVar;
        Socket f4;
        c cVar2;
        Socket socket;
        c0 c0Var;
        boolean z4;
        boolean z5;
        f.a aVar;
        synchronized (this.f988d) {
            if (!this.f996l) {
                if (this.f998n == null) {
                    if (!this.f997m) {
                        cVar = this.f994j;
                        f4 = f();
                        cVar2 = this.f994j;
                        socket = null;
                        if (cVar2 != null) {
                            cVar = null;
                        } else {
                            cVar2 = null;
                        }
                        if (!this.f995k) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(this.f988d, this.f985a, this, null);
                            c cVar3 = this.f994j;
                            if (cVar3 != null) {
                                cVar2 = cVar3;
                                z4 = true;
                                c0Var = null;
                            } else {
                                c0Var = this.f987c;
                            }
                        } else {
                            c0Var = null;
                        }
                        z4 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(f4);
        if (cVar != null) {
            this.f990f.b(this.f989e, cVar);
        }
        if (z4) {
            this.f990f.a(this.f989e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (c0Var != null || ((aVar = this.f986b) != null && aVar.b())) {
            z5 = false;
        } else {
            this.f986b = this.f992h.b();
            z5 = true;
        }
        synchronized (this.f988d) {
            if (this.f997m) {
                throw new IOException("Canceled");
            }
            if (z5) {
                List<c0> a4 = this.f986b.a();
                int size = a4.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    c0 c0Var2 = a4.get(i7);
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(this.f988d, this.f985a, this, c0Var2);
                    c cVar4 = this.f994j;
                    if (cVar4 != null) {
                        this.f987c = c0Var2;
                        cVar2 = cVar4;
                        z4 = true;
                        break;
                    }
                    i7++;
                }
            }
            if (!z4) {
                if (c0Var == null) {
                    c0Var = this.f986b.c();
                }
                this.f987c = c0Var;
                this.f993i = 0;
                cVar2 = new c(this.f988d, c0Var);
                a(cVar2, false);
            }
        }
        if (z4) {
            this.f990f.a(this.f989e, cVar2);
            return cVar2;
        }
        cVar2.a(i4, i5, i6, z3, this.f989e, this.f990f);
        g().a(cVar2.a());
        synchronized (this.f988d) {
            this.f995k = true;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.b(this.f988d, cVar2);
            if (cVar2.c()) {
                socket = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(this.f988d, this.f985a, this);
                cVar2 = this.f994j;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socket);
        this.f990f.a(this.f989e, cVar2);
        return cVar2;
    }

    public void a(boolean z3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVar, long j4, IOException iOException) {
        c cVar2;
        Socket a4;
        boolean z4;
        this.f990f.b(this.f989e, j4);
        synchronized (this.f988d) {
            if (cVar != null) {
                if (cVar == this.f998n) {
                    if (!z3) {
                        this.f994j.f967l++;
                    }
                    cVar2 = this.f994j;
                    a4 = a(z3, false, true);
                    if (this.f994j != null) {
                        cVar2 = null;
                    }
                    z4 = this.f996l;
                }
            }
            throw new IllegalStateException("expected " + this.f998n + " but was " + cVar);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a4);
        if (cVar2 != null) {
            this.f990f.b(this.f989e, cVar2);
        }
        if (iOException != null) {
            this.f990f.a(this.f989e, iOException);
        } else if (z4) {
            this.f990f.a(this.f989e);
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVar;
        synchronized (this.f988d) {
            cVar = this.f998n;
        }
        return cVar;
    }

    private Socket a(boolean z3, boolean z4, boolean z5) {
        Socket socket;
        if (f984o || Thread.holdsLock(this.f988d)) {
            if (z5) {
                this.f998n = null;
            }
            if (z4) {
                this.f996l = true;
            }
            c cVar = this.f994j;
            if (cVar != null) {
                if (z3) {
                    cVar.f966k = true;
                }
                if (this.f998n == null) {
                    if (this.f996l || cVar.f966k) {
                        b(cVar);
                        if (this.f994j.f969n.isEmpty()) {
                            this.f994j.f970o = System.nanoTime();
                            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(this.f988d, this.f994j)) {
                                socket = this.f994j.d();
                                this.f994j = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f994j = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z3;
        Socket a4;
        synchronized (this.f988d) {
            cVar = null;
            if (iOException instanceof o) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = ((o) iOException).f1198a;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM;
                if (bVar == bVar2) {
                    this.f993i++;
                }
                if (bVar != bVar2 || this.f993i > 1) {
                    this.f987c = null;
                    z3 = true;
                }
                z3 = false;
            } else {
                c cVar2 = this.f994j;
                if (cVar2 != null && (!cVar2.c() || (iOException instanceof bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a))) {
                    if (this.f994j.f967l == 0) {
                        c0 c0Var = this.f987c;
                        if (c0Var != null && iOException != null) {
                            this.f992h.a(c0Var, iOException);
                        }
                        this.f987c = null;
                    }
                    z3 = true;
                }
                z3 = false;
            }
            c cVar3 = this.f994j;
            a4 = a(z3, false, true);
            if (this.f994j == null && this.f995k) {
                cVar = cVar3;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a4);
        if (cVar != null) {
            this.f990f.b(this.f989e, cVar);
        }
    }

    public void a(c cVar, boolean z3) {
        if (!f984o && !Thread.holdsLock(this.f988d)) {
            throw new AssertionError();
        }
        if (this.f994j == null) {
            this.f994j = cVar;
            this.f995k = z3;
            cVar.f969n.add(new a(this, this.f991g));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (f984o || Thread.holdsLock(this.f988d)) {
            if (this.f998n == null && this.f994j.f969n.size() == 1) {
                Socket a4 = a(true, false, false);
                this.f994j = cVar;
                cVar.f969n.add(this.f994j.f969n.get(0));
                return a4;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }
}

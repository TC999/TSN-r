package com.bytedance.sdk.component.xv.w.c.w;

import com.bytedance.sdk.component.xv.w.c.ux.ys;
import com.bytedance.sdk.component.xv.w.c.w.f;
import com.bytedance.sdk.component.xv.w.eq;
import com.bytedance.sdk.component.xv.w.fp;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.p;
import com.bytedance.sdk.component.xv.w.u;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class r {
    static final /* synthetic */ boolean sr = true;

    /* renamed from: a  reason: collision with root package name */
    private boolean f30918a;
    private boolean bk;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.xv.w.c f30919c;
    private final Object ev;

    /* renamed from: f  reason: collision with root package name */
    private eq f30920f;
    private final f gd;

    /* renamed from: k  reason: collision with root package name */
    private xv f30921k;

    /* renamed from: p  reason: collision with root package name */
    private int f30922p;

    /* renamed from: r  reason: collision with root package name */
    private final p f30923r;

    /* renamed from: t  reason: collision with root package name */
    private boolean f30924t;
    private f.c ux;

    /* renamed from: w  reason: collision with root package name */
    public final com.bytedance.sdk.component.xv.w.ux f30925w;
    public final fp xv;
    private com.bytedance.sdk.component.xv.w.c.xv.xv ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c extends WeakReference<r> {

        /* renamed from: c  reason: collision with root package name */
        public final Object f30926c;

        c(r rVar, Object obj) {
            super(rVar);
            this.f30926c = obj;
        }
    }

    public r(p pVar, com.bytedance.sdk.component.xv.w.c cVar, com.bytedance.sdk.component.xv.w.ux uxVar, fp fpVar, Object obj) throws IOException {
        this.f30923r = pVar;
        this.f30919c = cVar;
        this.f30925w = uxVar;
        this.xv = fpVar;
        this.gd = new f(cVar, ev(), uxVar, fpVar);
        this.ev = obj;
    }

    private sr ev() {
        return com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.f30923r);
    }

    private Socket r() {
        if (sr || Thread.holdsLock(this.f30923r)) {
            xv xvVar = this.f30921k;
            if (xvVar == null || !xvVar.f30933c) {
                return null;
            }
            return c(false, false, true);
        }
        throw new AssertionError();
    }

    public com.bytedance.sdk.component.xv.w.c.xv.xv c(j jVar, u.c cVar, boolean z3) {
        try {
            com.bytedance.sdk.component.xv.w.c.xv.xv c4 = c(cVar.w(), cVar.xv(), cVar.sr(), jVar.s(), z3).c(jVar, cVar, this);
            synchronized (this.f30923r) {
                this.ys = c4;
            }
            return c4;
        } catch (IOException e4) {
            throw new ux(e4);
        }
    }

    public boolean f() {
        f.c cVar;
        return this.f30920f != null || ((cVar = this.ux) != null && cVar.c()) || this.gd.c();
    }

    public void sr() {
        xv xvVar;
        Socket c4;
        synchronized (this.f30923r) {
            xvVar = this.f30921k;
            c4 = c(true, false, false);
            if (this.f30921k != null) {
                xvVar = null;
            }
        }
        com.bytedance.sdk.component.xv.w.c.xv.c(c4);
        if (xvVar != null) {
            this.xv.w(this.f30925w, xvVar);
        }
    }

    public String toString() {
        xv w3 = w();
        return w3 != null ? w3.toString() : this.f30919c.toString();
    }

    public void ux() {
        com.bytedance.sdk.component.xv.w.c.xv.xv xvVar;
        xv xvVar2;
        synchronized (this.f30923r) {
            this.f30924t = true;
            xvVar = this.ys;
            xvVar2 = this.f30921k;
        }
        if (xvVar != null) {
            xvVar.xv();
        } else if (xvVar2 != null) {
            xvVar2.w();
        }
    }

    public synchronized xv w() {
        return this.f30921k;
    }

    public void xv() {
        xv xvVar;
        Socket c4;
        synchronized (this.f30923r) {
            xvVar = this.f30921k;
            c4 = c(false, true, false);
            if (this.f30921k != null) {
                xvVar = null;
            }
        }
        com.bytedance.sdk.component.xv.w.c.xv.c(c4);
        if (xvVar != null) {
            this.xv.w(this.f30925w, xvVar);
        }
    }

    private void w(xv xvVar) {
        int size = xvVar.sr.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (xvVar.sr.get(i4).get() == this) {
                xvVar.sr.remove(i4);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private xv c(int i4, int i5, int i6, boolean z3, boolean z4) throws IOException {
        while (true) {
            xv c4 = c(i4, i5, i6, z3);
            synchronized (this.f30923r) {
                if (c4.f30938w == 0) {
                    return c4;
                }
                if (c4.c(z4)) {
                    return c4;
                }
                sr();
            }
        }
    }

    private xv c(int i4, int i5, int i6, boolean z3) throws IOException {
        xv xvVar;
        Socket r3;
        xv xvVar2;
        Socket socket;
        eq eqVar;
        boolean z4;
        boolean z5;
        f.c cVar;
        synchronized (this.f30923r) {
            if (!this.bk) {
                if (this.ys == null) {
                    if (!this.f30924t) {
                        xvVar = this.f30921k;
                        r3 = r();
                        xvVar2 = this.f30921k;
                        socket = null;
                        if (xvVar2 != null) {
                            xvVar = null;
                        } else {
                            xvVar2 = null;
                        }
                        if (!this.f30918a) {
                            xvVar = null;
                        }
                        if (xvVar2 == null) {
                            com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.f30923r, this.f30919c, this, null);
                            xv xvVar3 = this.f30921k;
                            if (xvVar3 != null) {
                                xvVar2 = xvVar3;
                                z4 = true;
                                eqVar = null;
                            } else {
                                eqVar = this.f30920f;
                            }
                        } else {
                            eqVar = null;
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
        com.bytedance.sdk.component.xv.w.c.xv.c(r3);
        if (xvVar != null) {
            this.xv.w(this.f30925w, xvVar);
        }
        if (z4) {
            this.xv.c(this.f30925w, xvVar2);
        }
        if (xvVar2 != null) {
            return xvVar2;
        }
        if (eqVar != null || ((cVar = this.ux) != null && cVar.c())) {
            z5 = false;
        } else {
            this.ux = this.gd.w();
            z5 = true;
        }
        synchronized (this.f30923r) {
            if (this.f30924t) {
                throw new IOException("Canceled");
            }
            if (z5) {
                List<eq> xv = this.ux.xv();
                int size = xv.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    eq eqVar2 = xv.get(i7);
                    com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.f30923r, this.f30919c, this, eqVar2);
                    xv xvVar4 = this.f30921k;
                    if (xvVar4 != null) {
                        this.f30920f = eqVar2;
                        xvVar2 = xvVar4;
                        z4 = true;
                        break;
                    }
                    i7++;
                }
            }
            if (!z4) {
                if (eqVar == null) {
                    eqVar = this.ux.w();
                }
                this.f30920f = eqVar;
                this.f30922p = 0;
                xvVar2 = new xv(this.f30923r, eqVar);
                c(xvVar2, false);
            }
        }
        if (z4) {
            this.xv.c(this.f30925w, xvVar2);
            return xvVar2;
        }
        xvVar2.c(i4, i5, i6, z3, this.f30925w, this.xv);
        ev().w(xvVar2.c());
        synchronized (this.f30923r) {
            this.f30918a = true;
            com.bytedance.sdk.component.xv.w.c.c.f30735c.w(this.f30923r, xvVar2);
            if (xvVar2.ux()) {
                socket = com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.f30923r, this.f30919c, this);
                xvVar2 = this.f30921k;
            }
        }
        com.bytedance.sdk.component.xv.w.c.xv.c(socket);
        this.xv.c(this.f30925w, xvVar2);
        return xvVar2;
    }

    public void c(boolean z3, com.bytedance.sdk.component.xv.w.c.xv.xv xvVar, long j4, IOException iOException) {
        xv xvVar2;
        Socket c4;
        boolean z4;
        this.xv.w(this.f30925w, j4);
        synchronized (this.f30923r) {
            if (xvVar != null) {
                if (xvVar == this.ys) {
                    if (!z3) {
                        this.f30921k.f30938w++;
                    }
                    xvVar2 = this.f30921k;
                    c4 = c(z3, false, true);
                    if (this.f30921k != null) {
                        xvVar2 = null;
                    }
                    z4 = this.bk;
                }
            }
            throw new IllegalStateException("expected " + this.ys + " but was " + xvVar);
        }
        com.bytedance.sdk.component.xv.w.c.xv.c(c4);
        if (xvVar2 != null) {
            this.xv.w(this.f30925w, xvVar2);
        }
        if (iOException != null) {
            this.xv.c(this.f30925w, iOException);
        } else if (z4) {
            this.xv.r(this.f30925w);
        }
    }

    public com.bytedance.sdk.component.xv.w.c.xv.xv c() {
        com.bytedance.sdk.component.xv.w.c.xv.xv xvVar;
        synchronized (this.f30923r) {
            xvVar = this.ys;
        }
        return xvVar;
    }

    private Socket c(boolean z3, boolean z4, boolean z5) {
        Socket socket;
        if (sr || Thread.holdsLock(this.f30923r)) {
            if (z5) {
                this.ys = null;
            }
            if (z4) {
                this.bk = true;
            }
            xv xvVar = this.f30921k;
            if (xvVar != null) {
                if (z3) {
                    xvVar.f30933c = true;
                }
                if (this.ys == null) {
                    if (this.bk || xvVar.f30933c) {
                        w(xvVar);
                        if (this.f30921k.sr.isEmpty()) {
                            this.f30921k.ux = System.nanoTime();
                            if (com.bytedance.sdk.component.xv.w.c.c.f30735c.c(this.f30923r, this.f30921k)) {
                                socket = this.f30921k.xv();
                                this.f30921k = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f30921k = null;
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

    public void c(IOException iOException) {
        xv xvVar;
        boolean z3;
        Socket c4;
        synchronized (this.f30923r) {
            xvVar = null;
            if (iOException instanceof ys) {
                com.bytedance.sdk.component.xv.w.c.ux.w wVar = ((ys) iOException).f30909c;
                com.bytedance.sdk.component.xv.w.c.ux.w wVar2 = com.bytedance.sdk.component.xv.w.c.ux.w.REFUSED_STREAM;
                if (wVar == wVar2) {
                    this.f30922p++;
                }
                if (wVar != wVar2 || this.f30922p > 1) {
                    this.f30920f = null;
                    z3 = true;
                }
                z3 = false;
            } else {
                xv xvVar2 = this.f30921k;
                if (xvVar2 != null && (!xvVar2.ux() || (iOException instanceof com.bytedance.sdk.component.xv.w.c.ux.c))) {
                    if (this.f30921k.f30938w == 0) {
                        eq eqVar = this.f30920f;
                        if (eqVar != null && iOException != null) {
                            this.gd.c(eqVar, iOException);
                        }
                        this.f30920f = null;
                    }
                    z3 = true;
                }
                z3 = false;
            }
            xv xvVar3 = this.f30921k;
            c4 = c(z3, false, true);
            if (this.f30921k == null && this.f30918a) {
                xvVar = xvVar3;
            }
        }
        com.bytedance.sdk.component.xv.w.c.xv.c(c4);
        if (xvVar != null) {
            this.xv.w(this.f30925w, xvVar);
        }
    }

    public void c(xv xvVar, boolean z3) {
        if (!sr && !Thread.holdsLock(this.f30923r)) {
            throw new AssertionError();
        }
        if (this.f30921k == null) {
            this.f30921k = xvVar;
            this.f30918a = z3;
            xvVar.sr.add(new c(this, this.ev));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket c(xv xvVar) {
        if (sr || Thread.holdsLock(this.f30923r)) {
            if (this.ys == null && this.f30921k.sr.size() == 1) {
                Socket c4 = c(true, false, false);
                this.f30921k = xvVar;
                xvVar.sr.add(this.f30921k.sr.get(0));
                return c4;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }
}

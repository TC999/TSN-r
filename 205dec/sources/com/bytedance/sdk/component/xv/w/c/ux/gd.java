package com.bytedance.sdk.component.xv.w.c.ux;

import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.s;
import com.bytedance.sdk.component.xv.c.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class gd {
    static final /* synthetic */ boolean gd = true;

    /* renamed from: a  reason: collision with root package name */
    private boolean f30834a;
    private final w bk;

    /* renamed from: k  reason: collision with root package name */
    private List<com.bytedance.sdk.component.xv.w.c.ux.xv> f30837k;

    /* renamed from: p  reason: collision with root package name */
    private final List<com.bytedance.sdk.component.xv.w.c.ux.xv> f30838p;
    final r sr;
    final c ux;

    /* renamed from: w  reason: collision with root package name */
    long f30840w;
    final int xv;

    /* renamed from: c  reason: collision with root package name */
    long f30835c = 0;

    /* renamed from: f  reason: collision with root package name */
    final xv f30836f = new xv();

    /* renamed from: r  reason: collision with root package name */
    final xv f30839r = new xv();
    com.bytedance.sdk.component.xv.w.c.ux.w ev = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class xv extends com.bytedance.sdk.component.xv.c.c {
        xv() {
        }

        public void ev() throws IOException {
            if (w()) {
                throw w((IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.c
        protected IOException w(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.bytedance.sdk.component.xv.c.c
        protected void y_() {
            gd.this.w(com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(int i4, r rVar, boolean z3, boolean z4, List<com.bytedance.sdk.component.xv.w.c.ux.xv> list) {
        if (rVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.xv = i4;
            this.sr = rVar;
            this.f30840w = rVar.bk.sr();
            w wVar = new w(rVar.f30857a.sr());
            this.bk = wVar;
            c cVar = new c();
            this.ux = cVar;
            wVar.f30846w = z4;
            cVar.f30842w = z3;
            this.f30838p = list;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    void a() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public int c() {
        return this.xv;
    }

    public s ev() {
        synchronized (this) {
            if (!this.f30834a && !xv()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.ux;
    }

    public u f() {
        return this.f30839r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gd() {
        boolean w3;
        if (!gd && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.bk.f30846w = true;
            w3 = w();
            notifyAll();
        }
        if (w3) {
            return;
        }
        this.sr.w(this.xv);
    }

    void k() throws IOException {
        c cVar = this.ux;
        if (!cVar.f30841c) {
            if (!cVar.f30842w) {
                if (this.ev != null) {
                    throw new ys(this.ev);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    void p() throws IOException {
        boolean z3;
        boolean w3;
        if (!gd && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            w wVar = this.bk;
            if (!wVar.f30846w && wVar.f30843c) {
                c cVar = this.ux;
                if (cVar.f30842w || cVar.f30841c) {
                    z3 = true;
                    w3 = w();
                }
            }
            z3 = false;
            w3 = w();
        }
        if (z3) {
            c(com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
        } else if (w3) {
        } else {
            this.sr.w(this.xv);
        }
    }

    public fz r() {
        return this.bk;
    }

    public synchronized List<com.bytedance.sdk.component.xv.w.c.ux.xv> sr() throws IOException {
        List<com.bytedance.sdk.component.xv.w.c.ux.xv> list;
        if (xv()) {
            this.f30836f.c();
            while (this.f30837k == null && this.ev == null) {
                a();
            }
            this.f30836f.ev();
            list = this.f30837k;
            if (list != null) {
                this.f30837k = null;
            } else {
                throw new ys(this.ev);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public u ux() {
        return this.f30836f;
    }

    public synchronized boolean w() {
        if (this.ev != null) {
            return false;
        }
        w wVar = this.bk;
        if (wVar.f30846w || wVar.f30843c) {
            c cVar = this.ux;
            if (cVar.f30842w || cVar.f30841c) {
                if (this.f30834a) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean xv() {
        return this.sr.f30867w == ((this.xv & 1) == 1);
    }

    public void c(com.bytedance.sdk.component.xv.w.c.ux.w wVar) throws IOException {
        if (sr(wVar)) {
            this.sr.w(this.xv, wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void xv(com.bytedance.sdk.component.xv.w.c.ux.w wVar) {
        if (this.ev == null) {
            this.ev = wVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(List<com.bytedance.sdk.component.xv.w.c.ux.xv> list) {
        boolean z3;
        if (!gd && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z3 = true;
            this.f30834a = true;
            if (this.f30837k == null) {
                this.f30837k = list;
                z3 = w();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f30837k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f30837k = arrayList;
            }
        }
        if (z3) {
            return;
        }
        this.sr.w(this.xv);
    }

    public void w(com.bytedance.sdk.component.xv.w.c.ux.w wVar) {
        if (sr(wVar)) {
            this.sr.c(this.xv, wVar);
        }
    }

    private boolean sr(com.bytedance.sdk.component.xv.w.c.ux.w wVar) {
        if (gd || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.ev != null) {
                    return false;
                }
                if (this.bk.f30846w && this.ux.f30842w) {
                    return false;
                }
                this.ev = wVar;
                notifyAll();
                this.sr.w(this.xv);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class c implements s {
        static final /* synthetic */ boolean xv = true;

        /* renamed from: c  reason: collision with root package name */
        boolean f30841c;
        private final com.bytedance.sdk.component.xv.c.xv ux = new com.bytedance.sdk.component.xv.c.xv();

        /* renamed from: w  reason: collision with root package name */
        boolean f30842w;

        c() {
        }

        private void c(boolean z3) throws IOException {
            gd gdVar;
            long min;
            gd gdVar2;
            synchronized (gd.this) {
                gd.this.f30839r.c();
                while (true) {
                    gdVar = gd.this;
                    if (gdVar.f30840w > 0 || this.f30842w || this.f30841c || gdVar.ev != null) {
                        break;
                    }
                    gdVar.a();
                }
                gdVar.f30839r.ev();
                gd.this.k();
                min = Math.min(gd.this.f30840w, this.ux.w());
                gdVar2 = gd.this;
                gdVar2.f30840w -= min;
            }
            gdVar2.f30839r.c();
            try {
                gd gdVar3 = gd.this;
                gdVar3.sr.c(gdVar3.xv, z3 && min == this.ux.w(), this.ux, min);
            } finally {
                gd.this.f30839r.ev();
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.s
        public void a_(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (!xv && Thread.holdsLock(gd.this)) {
                throw new AssertionError();
            }
            this.ux.a_(xvVar, j4);
            while (this.ux.w() >= 16384) {
                c(false);
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!xv && Thread.holdsLock(gd.this)) {
                throw new AssertionError();
            }
            synchronized (gd.this) {
                if (this.f30841c) {
                    return;
                }
                if (!gd.this.ux.f30842w) {
                    if (this.ux.w() > 0) {
                        while (this.ux.w() > 0) {
                            c(true);
                        }
                    } else {
                        gd gdVar = gd.this;
                        gdVar.sr.c(gdVar.xv, true, (com.bytedance.sdk.component.xv.c.xv) null, 0L);
                    }
                }
                synchronized (gd.this) {
                    this.f30841c = true;
                }
                gd.this.sr.w();
                gd.this.p();
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
        public void flush() throws IOException {
            if (!xv && Thread.holdsLock(gd.this)) {
                throw new AssertionError();
            }
            synchronized (gd.this) {
                gd.this.k();
            }
            while (this.ux.w() > 0) {
                c(false);
                gd.this.sr.w();
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.s
        public u c() {
            return gd.this.f30839r;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.component.xv.c.ux uxVar, int i4) throws IOException {
        if (!gd && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.bk.c(uxVar, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class w implements fz {
        static final /* synthetic */ boolean xv = true;

        /* renamed from: c  reason: collision with root package name */
        boolean f30843c;

        /* renamed from: r  reason: collision with root package name */
        private final long f30845r;

        /* renamed from: w  reason: collision with root package name */
        boolean f30846w;
        private final com.bytedance.sdk.component.xv.c.xv ux = new com.bytedance.sdk.component.xv.c.xv();

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.c.xv f30844f = new com.bytedance.sdk.component.xv.c.xv();

        w(long j4) {
            this.f30845r = j4;
        }

        private void w() throws IOException {
            gd.this.f30836f.c();
            while (this.f30844f.w() == 0 && !this.f30846w && !this.f30843c) {
                try {
                    gd gdVar = gd.this;
                    if (gdVar.ev != null) {
                        break;
                    }
                    gdVar.a();
                } finally {
                    gd.this.f30836f.ev();
                }
            }
        }

        private void xv() throws IOException {
            if (!this.f30843c) {
                if (gd.this.ev != null) {
                    throw new ys(gd.this.ev);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        @Override // com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (j4 >= 0) {
                synchronized (gd.this) {
                    w();
                    xv();
                    if (this.f30844f.w() == 0) {
                        return -1L;
                    }
                    com.bytedance.sdk.component.xv.c.xv xvVar2 = this.f30844f;
                    long c4 = xvVar2.c(xvVar, Math.min(j4, xvVar2.w()));
                    gd gdVar = gd.this;
                    long j5 = gdVar.f30835c + c4;
                    gdVar.f30835c = j5;
                    if (j5 >= gdVar.sr.f30857a.sr() / 2) {
                        gd gdVar2 = gd.this;
                        gdVar2.sr.c(gdVar2.xv, gdVar2.f30835c);
                        gd.this.f30835c = 0L;
                    }
                    synchronized (gd.this.sr) {
                        r rVar = gd.this.sr;
                        long j6 = rVar.f30861p + c4;
                        rVar.f30861p = j6;
                        if (j6 >= rVar.f30857a.sr() / 2) {
                            r rVar2 = gd.this.sr;
                            rVar2.c(0, rVar2.f30861p);
                            gd.this.sr.f30861p = 0L;
                        }
                    }
                    return c4;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (gd.this) {
                this.f30843c = true;
                this.f30844f.s();
                gd.this.notifyAll();
            }
            gd.this.p();
        }

        void c(com.bytedance.sdk.component.xv.c.ux uxVar, long j4) throws IOException {
            boolean z3;
            boolean z4;
            boolean z5;
            if (!xv && Thread.holdsLock(gd.this)) {
                throw new AssertionError();
            }
            while (j4 > 0) {
                synchronized (gd.this) {
                    z3 = this.f30846w;
                    z4 = true;
                    z5 = this.f30844f.w() + j4 > this.f30845r;
                }
                if (z5) {
                    uxVar.ev(j4);
                    gd.this.w(com.bytedance.sdk.component.xv.w.c.ux.w.FLOW_CONTROL_ERROR);
                    return;
                } else if (z3) {
                    uxVar.ev(j4);
                    return;
                } else {
                    long c4 = uxVar.c(this.ux, j4);
                    if (c4 != -1) {
                        j4 -= c4;
                        synchronized (gd.this) {
                            if (this.f30844f.w() != 0) {
                                z4 = false;
                            }
                            this.f30844f.c(this.ux);
                            if (z4) {
                                gd.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.fz
        public u c() {
            return gd.this.f30836f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j4) {
        this.f30840w += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }
}

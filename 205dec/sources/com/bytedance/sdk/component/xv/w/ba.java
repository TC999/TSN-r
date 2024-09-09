package com.bytedance.sdk.component.xv.w;

import com.bytedance.sdk.component.xv.w.s;
import java.io.Closeable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ba implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final long f30714a;
    private volatile sr bk;

    /* renamed from: c  reason: collision with root package name */
    final n f30715c;
    final ba ev;

    /* renamed from: f  reason: collision with root package name */
    final s f30716f;
    final ba gd;

    /* renamed from: k  reason: collision with root package name */
    final long f30717k;

    /* renamed from: p  reason: collision with root package name */
    final ba f30718p;

    /* renamed from: r  reason: collision with root package name */
    final y f30719r;
    final String sr;
    final ia ux;

    /* renamed from: w  reason: collision with root package name */
    final ls f30720w;
    final int xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        long f30721a;

        /* renamed from: c  reason: collision with root package name */
        n f30722c;
        ba ev;

        /* renamed from: f  reason: collision with root package name */
        s.c f30723f;
        ba gd;

        /* renamed from: k  reason: collision with root package name */
        long f30724k;

        /* renamed from: p  reason: collision with root package name */
        ba f30725p;

        /* renamed from: r  reason: collision with root package name */
        y f30726r;
        String sr;
        ia ux;

        /* renamed from: w  reason: collision with root package name */
        ls f30727w;
        int xv;

        public c() {
            this.xv = -1;
            this.f30723f = new s.c();
        }

        private void sr(ba baVar) {
            if (baVar.f30719r != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public c c(n nVar) {
            this.f30722c = nVar;
            return this;
        }

        public c w(ba baVar) {
            if (baVar != null) {
                c("cacheResponse", baVar);
            }
            this.gd = baVar;
            return this;
        }

        public c xv(ba baVar) {
            if (baVar != null) {
                sr(baVar);
            }
            this.f30725p = baVar;
            return this;
        }

        public c c(ls lsVar) {
            this.f30727w = lsVar;
            return this;
        }

        public c c(int i4) {
            this.xv = i4;
            return this;
        }

        public c w(long j4) {
            this.f30721a = j4;
            return this;
        }

        c(ba baVar) {
            this.xv = -1;
            this.f30722c = baVar.f30715c;
            this.f30727w = baVar.f30720w;
            this.xv = baVar.xv;
            this.sr = baVar.sr;
            this.ux = baVar.ux;
            this.f30723f = baVar.f30716f.w();
            this.f30726r = baVar.f30719r;
            this.ev = baVar.ev;
            this.gd = baVar.gd;
            this.f30725p = baVar.f30718p;
            this.f30724k = baVar.f30717k;
            this.f30721a = baVar.f30714a;
        }

        public c c(String str) {
            this.sr = str;
            return this;
        }

        public c c(ia iaVar) {
            this.ux = iaVar;
            return this;
        }

        public c c(String str, String str2) {
            this.f30723f.c(str, str2);
            return this;
        }

        public c c(s sVar) {
            this.f30723f = sVar.w();
            return this;
        }

        public c c(y yVar) {
            this.f30726r = yVar;
            return this;
        }

        public c c(ba baVar) {
            if (baVar != null) {
                c("networkResponse", baVar);
            }
            this.ev = baVar;
            return this;
        }

        private void c(String str, ba baVar) {
            if (baVar.f30719r == null) {
                if (baVar.ev == null) {
                    if (baVar.gd == null) {
                        if (baVar.f30718p == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public c c(long j4) {
            this.f30724k = j4;
            return this;
        }

        public ba c() {
            if (this.f30722c != null) {
                if (this.f30727w != null) {
                    if (this.xv >= 0) {
                        if (this.sr != null) {
                            return new ba(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.xv);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    ba(c cVar) {
        this.f30715c = cVar.f30722c;
        this.f30720w = cVar.f30727w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f30716f = cVar.f30723f.c();
        this.f30719r = cVar.f30726r;
        this.ev = cVar.ev;
        this.gd = cVar.gd;
        this.f30718p = cVar.f30725p;
        this.f30717k = cVar.f30724k;
        this.f30714a = cVar.f30721a;
    }

    public sr a() {
        sr srVar = this.bk;
        if (srVar != null) {
            return srVar;
        }
        sr c4 = sr.c(this.f30716f);
        this.bk = c4;
        return c4;
    }

    public long bk() {
        return this.f30717k;
    }

    public n c() {
        return this.f30715c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        y yVar = this.f30719r;
        if (yVar != null) {
            yVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public y ev() {
        return this.f30719r;
    }

    public ia f() {
        return this.ux;
    }

    public c gd() {
        return new c(this);
    }

    public ba k() {
        return this.f30718p;
    }

    public ba p() {
        return this.ev;
    }

    public s r() {
        return this.f30716f;
    }

    public boolean sr() {
        int i4 = this.xv;
        return i4 >= 200 && i4 < 300;
    }

    public long t() {
        return this.f30714a;
    }

    public String toString() {
        return "Response{protocol=" + this.f30720w + ", code=" + this.xv + ", message=" + this.sr + ", url=" + this.f30715c.c() + '}';
    }

    public String ux() {
        return this.sr;
    }

    public ls w() {
        return this.f30720w;
    }

    public int xv() {
        return this.xv;
    }

    public z ys() {
        n nVar = this.f30715c;
        if (nVar == null) {
            return null;
        }
        return nVar.f31068f;
    }

    public String c(String str) {
        return c(str, null);
    }

    public String c(String str, String str2) {
        String c4 = this.f30716f.c(str);
        return c4 != null ? c4 : str2;
    }
}

package com.bytedance.sdk.component.xv.w.c.sr;

import com.bytedance.sdk.component.xv.c.a;
import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.gd;
import com.bytedance.sdk.component.xv.c.s;
import com.bytedance.sdk.component.xv.c.u;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.c.w.r;
import com.bytedance.sdk.component.xv.w.c.xv.ev;
import com.bytedance.sdk.component.xv.w.c.xv.k;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.s;
import com.bytedance.sdk.component.xv.w.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements com.bytedance.sdk.component.xv.w.c.xv.xv {

    /* renamed from: c  reason: collision with root package name */
    final j f30803c;
    final com.bytedance.sdk.component.xv.c.sr sr;

    /* renamed from: w  reason: collision with root package name */
    final r f30805w;
    final com.bytedance.sdk.component.xv.c.ux xv;
    int ux = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f30804f = 262144;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.component.xv.w.c.sr.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public abstract class AbstractC0462c implements fz {

        /* renamed from: c  reason: collision with root package name */
        protected final gd f30806c;

        /* renamed from: w  reason: collision with root package name */
        protected boolean f30807w;
        protected long xv;

        private AbstractC0462c() {
            this.f30806c = new gd(c.this.xv.c());
            this.xv = 0L;
        }

        @Override // com.bytedance.sdk.component.xv.c.fz
        public u c() {
            return this.f30806c;
        }

        @Override // com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            try {
                long c4 = c.this.xv.c(xvVar, j4);
                if (c4 > 0) {
                    this.xv += c4;
                }
                return c4;
            } catch (IOException e4) {
                c(false, e4);
                throw e4;
            }
        }

        protected final void c(boolean z3, IOException iOException) throws IOException {
            c cVar = c.this;
            int i4 = cVar.ux;
            if (i4 == 6) {
                return;
            }
            if (i4 == 5) {
                cVar.c(this.f30806c);
                c cVar2 = c.this;
                cVar2.ux = 6;
                r rVar = cVar2.f30805w;
                if (rVar != null) {
                    rVar.c(!z3, cVar2, this.xv, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + c.this.ux);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f extends AbstractC0462c {

        /* renamed from: f  reason: collision with root package name */
        private boolean f30808f;

        f() {
            super();
        }

        @Override // com.bytedance.sdk.component.xv.w.c.sr.c.AbstractC0462c, com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (j4 >= 0) {
                if (!this.f30807w) {
                    if (this.f30808f) {
                        return -1L;
                    }
                    long c4 = super.c(xvVar, j4);
                    if (c4 == -1) {
                        this.f30808f = true;
                        c(true, (IOException) null);
                        return -1L;
                    }
                    return c4;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f30807w) {
                return;
            }
            if (!this.f30808f) {
                c(false, (IOException) null);
            }
            this.f30807w = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class sr implements s {
        private long sr;

        /* renamed from: w  reason: collision with root package name */
        private final gd f30810w;
        private boolean xv;

        sr(long j4) {
            this.f30810w = new gd(c.this.sr.c());
            this.sr = j4;
        }

        @Override // com.bytedance.sdk.component.xv.c.s
        public void a_(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (!this.xv) {
                com.bytedance.sdk.component.xv.w.c.xv.c(xvVar.w(), 0L, j4);
                if (j4 <= this.sr) {
                    c.this.sr.a_(xvVar, j4);
                    this.sr -= j4;
                    return;
                }
                throw new ProtocolException("expected " + this.sr + " bytes but received " + j4);
            }
            throw new IllegalStateException("closed");
        }

        @Override // com.bytedance.sdk.component.xv.c.s
        public u c() {
            return this.f30810w;
        }

        @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xv) {
                return;
            }
            this.xv = true;
            if (this.sr <= 0) {
                c.this.c(this.f30810w);
                c.this.ux = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
        public void flush() throws IOException {
            if (this.xv) {
                return;
            }
            c.this.sr.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class ux extends AbstractC0462c {

        /* renamed from: f  reason: collision with root package name */
        private long f30811f;

        ux(long j4) throws IOException {
            super();
            this.f30811f = j4;
            if (j4 == 0) {
                c(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.sr.c.AbstractC0462c, com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (j4 >= 0) {
                if (!this.f30807w) {
                    long j5 = this.f30811f;
                    if (j5 == 0) {
                        return -1L;
                    }
                    long c4 = super.c(xvVar, Math.min(j5, j4));
                    if (c4 != -1) {
                        long j6 = this.f30811f - c4;
                        this.f30811f = j6;
                        if (j6 == 0) {
                            c(true, (IOException) null);
                        }
                        return c4;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    c(false, (IOException) protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f30807w) {
                return;
            }
            if (this.f30811f != 0 && !com.bytedance.sdk.component.xv.w.c.xv.c(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, (IOException) null);
            }
            this.f30807w = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class w implements s {

        /* renamed from: w  reason: collision with root package name */
        private final gd f30813w;
        private boolean xv;

        w() {
            this.f30813w = new gd(c.this.sr.c());
        }

        @Override // com.bytedance.sdk.component.xv.c.s
        public void a_(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (this.xv) {
                throw new IllegalStateException("closed");
            }
            if (j4 == 0) {
                return;
            }
            c.this.sr.k(j4);
            c.this.sr.w("\r\n");
            c.this.sr.a_(xvVar, j4);
            c.this.sr.w("\r\n");
        }

        @Override // com.bytedance.sdk.component.xv.c.s
        public u c() {
            return this.f30813w;
        }

        @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.xv) {
                return;
            }
            this.xv = true;
            c.this.sr.w("0\r\n\r\n");
            c.this.c(this.f30813w);
            c.this.ux = 3;
        }

        @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.xv) {
                return;
            }
            c.this.sr.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class xv extends AbstractC0462c {
        private boolean ev;

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.component.xv.w.fz f30814f;

        /* renamed from: r  reason: collision with root package name */
        private long f30815r;

        xv(com.bytedance.sdk.component.xv.w.fz fzVar) {
            super();
            this.f30815r = -1L;
            this.ev = true;
            this.f30814f = fzVar;
        }

        private void w() throws IOException {
            if (this.f30815r != -1) {
                c.this.xv.fp();
            }
            try {
                this.f30815r = c.this.xv.bk();
                String trim = c.this.xv.fp().trim();
                if (this.f30815r >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.f30815r == 0) {
                        this.ev = false;
                        com.bytedance.sdk.component.xv.w.c.xv.ux.c(c.this.f30803c.f(), this.f30814f, c.this.sr());
                        c(true, (IOException) null);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f30815r + trim + "\"");
            } catch (NumberFormatException e4) {
                throw new ProtocolException(e4.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.sr.c.AbstractC0462c, com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            if (j4 >= 0) {
                if (!this.f30807w) {
                    if (this.ev) {
                        long j5 = this.f30815r;
                        if (j5 == 0 || j5 == -1) {
                            w();
                            if (!this.ev) {
                                return -1L;
                            }
                        }
                        long c4 = super.c(xvVar, Math.min(j4, this.f30815r));
                        if (c4 != -1) {
                            this.f30815r -= c4;
                            return c4;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        c(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f30807w) {
                return;
            }
            if (this.ev && !com.bytedance.sdk.component.xv.w.c.xv.c(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, (IOException) null);
            }
            this.f30807w = true;
        }
    }

    public c(j jVar, r rVar, com.bytedance.sdk.component.xv.c.ux uxVar, com.bytedance.sdk.component.xv.c.sr srVar) {
        this.f30803c = jVar;
        this.f30805w = rVar;
        this.xv = uxVar;
        this.sr = srVar;
    }

    private String r() throws IOException {
        String ux2 = this.xv.ux(this.f30804f);
        this.f30804f -= ux2.length();
        return ux2;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public s c(n nVar, long j4) {
        if ("chunked".equalsIgnoreCase(nVar.c("Transfer-Encoding"))) {
            return ux();
        }
        if (j4 != -1) {
            return c(j4);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public fz f() throws IOException {
        if (this.ux == 4) {
            r rVar = this.f30805w;
            if (rVar != null) {
                this.ux = 5;
                rVar.sr();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.ux);
    }

    public com.bytedance.sdk.component.xv.w.s sr() throws IOException {
        s.c cVar = new s.c();
        while (true) {
            String r3 = r();
            if (r3.length() != 0) {
                com.bytedance.sdk.component.xv.w.c.c.f30735c.c(cVar, r3);
            } else {
                return cVar.c();
            }
        }
    }

    public com.bytedance.sdk.component.xv.c.s ux() {
        if (this.ux == 1) {
            this.ux = 2;
            return new w();
        }
        throw new IllegalStateException("state: " + this.ux);
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void w() throws IOException {
        this.sr.flush();
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void xv() {
        com.bytedance.sdk.component.xv.w.c.w.xv w3 = this.f30805w.w();
        if (w3 != null) {
            w3.w();
        }
    }

    public fz w(long j4) throws IOException {
        if (this.ux == 4) {
            this.ux = 5;
            return new ux(j4);
        }
        throw new IllegalStateException("state: " + this.ux);
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void c(n nVar) throws IOException {
        c(nVar.xv(), com.bytedance.sdk.component.xv.w.c.xv.gd.c(nVar, this.f30805w.w().c().w().type()));
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public y c(ba baVar) throws IOException {
        r rVar = this.f30805w;
        rVar.xv.f(rVar.f30925w);
        String c4 = baVar.c("Content-Type");
        if (!com.bytedance.sdk.component.xv.w.c.xv.ux.xv(baVar)) {
            return new ev(c4, 0L, a.c(w(0L)));
        }
        if ("chunked".equalsIgnoreCase(baVar.c("Transfer-Encoding"))) {
            return new ev(c4, -1L, a.c(c(baVar.c().c())));
        }
        long c5 = com.bytedance.sdk.component.xv.w.c.xv.ux.c(baVar);
        if (c5 != -1) {
            return new ev(c4, c5, a.c(w(c5)));
        }
        return new ev(c4, -1L, a.c(f()));
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void c() throws IOException {
        this.sr.flush();
    }

    public void c(com.bytedance.sdk.component.xv.w.s sVar, String str) throws IOException {
        if (this.ux == 0) {
            this.sr.w(str).w("\r\n");
            int c4 = sVar.c();
            for (int i4 = 0; i4 < c4; i4++) {
                this.sr.w(sVar.c(i4)).w(": ").w(sVar.w(i4)).w("\r\n");
            }
            this.sr.w("\r\n");
            this.ux = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.ux);
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public ba.c c(boolean z3) throws IOException {
        int i4 = this.ux;
        if (i4 != 1 && i4 != 3) {
            throw new IllegalStateException("state: " + this.ux);
        }
        try {
            k c4 = k.c(r());
            ba.c c5 = new ba.c().c(c4.f30953c).c(c4.f30954w).c(c4.xv).c(sr());
            if (z3 && c4.f30954w == 100) {
                return null;
            }
            this.ux = 4;
            return c5;
        } catch (EOFException e4) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f30805w);
            iOException.initCause(e4);
            throw iOException;
        }
    }

    public com.bytedance.sdk.component.xv.c.s c(long j4) {
        if (this.ux == 1) {
            this.ux = 2;
            return new sr(j4);
        }
        throw new IllegalStateException("state: " + this.ux);
    }

    public fz c(com.bytedance.sdk.component.xv.w.fz fzVar) throws IOException {
        if (this.ux == 4) {
            this.ux = 5;
            return new xv(fzVar);
        }
        throw new IllegalStateException("state: " + this.ux);
    }

    void c(gd gdVar) {
        u c4 = gdVar.c();
        gdVar.c(u.xv);
        c4.f();
        c4.ux();
    }
}

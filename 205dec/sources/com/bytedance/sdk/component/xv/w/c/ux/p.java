package com.bytedance.sdk.component.xv.w.c.ux;

import com.bytedance.sdk.component.xv.w.c.ux.sr;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class p implements Closeable {

    /* renamed from: w  reason: collision with root package name */
    private static final Logger f30852w = Logger.getLogger(ux.class.getName());

    /* renamed from: c  reason: collision with root package name */
    final sr.w f30853c;

    /* renamed from: f  reason: collision with root package name */
    private int f30854f;

    /* renamed from: r  reason: collision with root package name */
    private boolean f30855r;
    private final boolean sr;
    private final com.bytedance.sdk.component.xv.c.xv ux;
    private final com.bytedance.sdk.component.xv.c.sr xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(com.bytedance.sdk.component.xv.c.sr srVar, boolean z3) {
        this.xv = srVar;
        this.sr = z3;
        com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
        this.ux = xvVar;
        this.f30853c = new sr.w(xvVar);
        this.f30854f = 16384;
    }

    public synchronized void c() throws IOException {
        if (!this.f30855r) {
            if (this.sr) {
                Logger logger = f30852w;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(com.bytedance.sdk.component.xv.w.c.xv.c(">> CONNECTION %s", ux.f30899c.ux()));
                }
                this.xv.xv(ux.f30899c.ev());
                this.xv.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f30855r = true;
        this.xv.close();
    }

    public synchronized void w() throws IOException {
        if (!this.f30855r) {
            this.xv.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public int xv() {
        return this.f30854f;
    }

    public synchronized void w(t tVar) throws IOException {
        if (!this.f30855r) {
            int i4 = 0;
            c(0, tVar.w() * 6, (byte) 4, (byte) 0);
            while (i4 < 10) {
                if (tVar.c(i4)) {
                    this.xv.ev(i4 == 4 ? 3 : i4 == 7 ? 4 : i4);
                    this.xv.r(tVar.w(i4));
                }
                i4++;
            }
            this.xv.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(t tVar) throws IOException {
        if (!this.f30855r) {
            this.f30854f = tVar.sr(this.f30854f);
            if (tVar.xv() != -1) {
                this.f30853c.c(tVar.xv());
            }
            c(0, 0, (byte) 4, (byte) 1);
            this.xv.flush();
        } else {
            throw new IOException("closed");
        }
    }

    private void w(int i4, long j4) throws IOException {
        while (j4 > 0) {
            int min = (int) Math.min(this.f30854f, j4);
            long j5 = min;
            j4 -= j5;
            c(i4, min, (byte) 9, j4 == 0 ? (byte) 4 : (byte) 0);
            this.xv.a_(this.ux, j5);
        }
    }

    public synchronized void c(int i4, int i5, List<xv> list) throws IOException {
        if (!this.f30855r) {
            this.f30853c.c(list);
            long w3 = this.ux.w();
            int min = (int) Math.min(this.f30854f - 4, w3);
            long j4 = min;
            c(i4, min + 4, (byte) 5, w3 == j4 ? (byte) 4 : (byte) 0);
            this.xv.r(i5 & Integer.MAX_VALUE);
            this.xv.a_(this.ux, j4);
            if (w3 > j4) {
                w(i4, w3 - j4);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(boolean z3, int i4, int i5, List<xv> list) throws IOException {
        if (!this.f30855r) {
            c(z3, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(int i4, w wVar) throws IOException {
        if (!this.f30855r) {
            if (wVar.f30904r != -1) {
                c(i4, 4, (byte) 3, (byte) 0);
                this.xv.r(wVar.f30904r);
                this.xv.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(boolean z3, int i4, com.bytedance.sdk.component.xv.c.xv xvVar, int i5) throws IOException {
        if (!this.f30855r) {
            c(i4, z3 ? (byte) 1 : (byte) 0, xvVar, i5);
        } else {
            throw new IOException("closed");
        }
    }

    void c(int i4, byte b4, com.bytedance.sdk.component.xv.c.xv xvVar, int i5) throws IOException {
        c(i4, i5, (byte) 0, b4);
        if (i5 > 0) {
            this.xv.a_(xvVar, i5);
        }
    }

    public synchronized void c(boolean z3, int i4, int i5) throws IOException {
        if (!this.f30855r) {
            c(0, 8, (byte) 6, z3 ? (byte) 1 : (byte) 0);
            this.xv.r(i4);
            this.xv.r(i5);
            this.xv.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(int i4, w wVar, byte[] bArr) throws IOException {
        if (!this.f30855r) {
            if (wVar.f30904r != -1) {
                c(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.xv.r(i4);
                this.xv.r(wVar.f30904r);
                if (bArr.length > 0) {
                    this.xv.xv(bArr);
                }
                this.xv.flush();
            } else {
                throw ux.c("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(int i4, long j4) throws IOException {
        if (this.f30855r) {
            throw new IOException("closed");
        }
        if (j4 != 0 && j4 <= 2147483647L) {
            c(i4, 4, (byte) 8, (byte) 0);
            this.xv.r((int) j4);
            this.xv.flush();
        } else {
            throw ux.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
        }
    }

    public void c(int i4, int i5, byte b4, byte b5) throws IOException {
        Logger logger = f30852w;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(ux.c(false, i4, i5, b4, b5));
        }
        int i6 = this.f30854f;
        if (i5 > i6) {
            throw ux.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i6), Integer.valueOf(i5));
        }
        if ((Integer.MIN_VALUE & i4) != 0) {
            throw ux.c("reserved bit set: %s", Integer.valueOf(i4));
        }
        c(this.xv, i5);
        this.xv.gd(b4 & 255);
        this.xv.gd(b5 & 255);
        this.xv.r(i4 & Integer.MAX_VALUE);
    }

    private static void c(com.bytedance.sdk.component.xv.c.sr srVar, int i4) throws IOException {
        srVar.gd((i4 >>> 16) & 255);
        srVar.gd((i4 >>> 8) & 255);
        srVar.gd(i4 & 255);
    }

    void c(boolean z3, int i4, List<xv> list) throws IOException {
        if (!this.f30855r) {
            this.f30853c.c(list);
            long w3 = this.ux.w();
            int min = (int) Math.min(this.f30854f, w3);
            long j4 = min;
            byte b4 = w3 == j4 ? (byte) 4 : (byte) 0;
            if (z3) {
                b4 = (byte) (b4 | 1);
            }
            c(i4, min, (byte) 1, b4);
            this.xv.a_(this.ux, j4);
            if (w3 > j4) {
                w(i4, w3 - j4);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}

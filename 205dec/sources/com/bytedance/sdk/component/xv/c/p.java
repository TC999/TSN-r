package com.bytedance.sdk.component.xv.c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class p implements fz {
    private final k sr;

    /* renamed from: w  reason: collision with root package name */
    private final ux f30691w;
    private final Inflater xv;

    /* renamed from: c  reason: collision with root package name */
    private int f30690c = 0;
    private final CRC32 ux = new CRC32();

    public p(fz fzVar) {
        if (fzVar != null) {
            Inflater inflater = new Inflater(true);
            this.xv = inflater;
            ux c4 = a.c(fzVar);
            this.f30691w = c4;
            this.sr = new k(c4, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void w() throws IOException {
        this.f30691w.c(10L);
        byte w3 = this.f30691w.xv().w(3L);
        boolean z3 = ((w3 >> 1) & 1) == 1;
        if (z3) {
            c(this.f30691w.xv(), 0L, 10L);
        }
        c("ID1ID2", 8075, this.f30691w.gd());
        this.f30691w.ev(8L);
        if (((w3 >> 2) & 1) == 1) {
            this.f30691w.c(2L);
            if (z3) {
                c(this.f30691w.xv(), 0L, 2L);
            }
            long k4 = this.f30691w.xv().k();
            this.f30691w.c(k4);
            if (z3) {
                c(this.f30691w.xv(), 0L, k4);
            }
            this.f30691w.ev(k4);
        }
        if (((w3 >> 3) & 1) == 1) {
            long c4 = this.f30691w.c((byte) 0);
            if (c4 != -1) {
                if (z3) {
                    c(this.f30691w.xv(), 0L, c4 + 1);
                }
                this.f30691w.ev(c4 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((w3 >> 4) & 1) == 1) {
            long c5 = this.f30691w.c((byte) 0);
            if (c5 != -1) {
                if (z3) {
                    c(this.f30691w.xv(), 0L, c5 + 1);
                }
                this.f30691w.ev(c5 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z3) {
            c("FHCRC", this.f30691w.k(), (short) this.ux.getValue());
            this.ux.reset();
        }
    }

    private void xv() throws IOException {
        c("CRC", this.f30691w.a(), (int) this.ux.getValue());
        c("ISIZE", this.f30691w.a(), (int) this.xv.getBytesWritten());
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public long c(xv xvVar, long j4) throws IOException {
        if (j4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (j4 == 0) {
            return 0L;
        } else {
            if (this.f30690c == 0) {
                w();
                this.f30690c = 1;
            }
            if (this.f30690c == 1) {
                long j5 = xvVar.f30701w;
                long c4 = this.sr.c(xvVar, j4);
                if (c4 != -1) {
                    c(xvVar, j5, c4);
                    return c4;
                }
                this.f30690c = 2;
            }
            if (this.f30690c == 2) {
                xv();
                this.f30690c = 3;
                if (!this.f30691w.ux()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sr.close();
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public u c() {
        return this.f30691w.c();
    }

    private void c(xv xvVar, long j4, long j5) {
        int i4;
        ys ysVar = xvVar.f30700c;
        while (true) {
            int i5 = ysVar.xv;
            int i6 = ysVar.f30706w;
            if (j4 < i5 - i6) {
                break;
            }
            j4 -= i5 - i6;
            ysVar = ysVar.f30704f;
        }
        while (j5 > 0) {
            int min = (int) Math.min(ysVar.xv - i4, j5);
            this.ux.update(ysVar.f30703c, (int) (ysVar.f30706w + j4), min);
            j5 -= min;
            ysVar = ysVar.f30704f;
            j4 = 0;
        }
    }

    private void c(String str, int i4, int i5) throws IOException {
        if (i5 != i4) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i5), Integer.valueOf(i4)));
        }
    }
}

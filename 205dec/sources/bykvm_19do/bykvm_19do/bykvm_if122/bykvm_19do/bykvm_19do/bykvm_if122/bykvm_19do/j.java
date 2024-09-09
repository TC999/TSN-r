package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class j implements s {

    /* renamed from: b  reason: collision with root package name */
    private final e f808b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f809c;

    /* renamed from: d  reason: collision with root package name */
    private final k f810d;

    /* renamed from: a  reason: collision with root package name */
    private int f807a = 0;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f811e = new CRC32();

    public j(s sVar) {
        if (sVar != null) {
            Inflater inflater = new Inflater(true);
            this.f809c = inflater;
            e a4 = l.a(sVar);
            this.f808b = a4;
            this.f810d = new k(a4, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void b() throws IOException {
        a("CRC", this.f808b.w(), (int) this.f811e.getValue());
        a("ISIZE", this.f808b.w(), (int) this.f809c.getBytesWritten());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j4) throws IOException {
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (i4 == 0) {
            return 0L;
        } else {
            if (this.f807a == 0) {
                a();
                this.f807a = 1;
            }
            if (this.f807a == 1) {
                long j5 = cVar.f798b;
                long a4 = this.f810d.a(cVar, j4);
                if (a4 != -1) {
                    a(cVar, j5, a4);
                    return a4;
                }
                this.f807a = 2;
            }
            if (this.f807a == 2) {
                b();
                this.f807a = 3;
                if (!this.f808b.x()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f810d.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t t() {
        return this.f808b.t();
    }

    private void a() throws IOException {
        this.f808b.c(10L);
        byte a4 = this.f808b.o().a(3L);
        boolean z3 = ((a4 >> 1) & 1) == 1;
        if (z3) {
            a(this.f808b.o(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f808b.readShort());
        this.f808b.skip(8L);
        if (((a4 >> 2) & 1) == 1) {
            this.f808b.c(2L);
            if (z3) {
                a(this.f808b.o(), 0L, 2L);
            }
            long u3 = this.f808b.o().u();
            this.f808b.c(u3);
            if (z3) {
                a(this.f808b.o(), 0L, u3);
            }
            this.f808b.skip(u3);
        }
        if (((a4 >> 3) & 1) == 1) {
            long a5 = this.f808b.a((byte) 0);
            if (a5 != -1) {
                if (z3) {
                    a(this.f808b.o(), 0L, a5 + 1);
                }
                this.f808b.skip(a5 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((a4 >> 4) & 1) == 1) {
            long a6 = this.f808b.a((byte) 0);
            if (a6 != -1) {
                if (z3) {
                    a(this.f808b.o(), 0L, a6 + 1);
                }
                this.f808b.skip(a6 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z3) {
            a("FHCRC", this.f808b.u(), (short) this.f811e.getValue());
            this.f811e.reset();
        }
    }

    private void a(c cVar, long j4, long j5) {
        int i4;
        o oVar = cVar.f797a;
        while (true) {
            long j6 = oVar.f830c - oVar.f829b;
            if (j4 < j6) {
                break;
            }
            j4 -= j6;
            oVar = oVar.f833f;
        }
        while (j5 > 0) {
            int min = (int) Math.min(oVar.f830c - i4, j5);
            this.f811e.update(oVar.f828a, (int) (oVar.f829b + j4), min);
            j5 -= min;
            oVar = oVar.f833f;
            j4 = 0;
        }
    }

    private void a(String str, int i4, int i5) throws IOException {
        if (i5 != i4) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i5), Integer.valueOf(i4)));
        }
    }
}

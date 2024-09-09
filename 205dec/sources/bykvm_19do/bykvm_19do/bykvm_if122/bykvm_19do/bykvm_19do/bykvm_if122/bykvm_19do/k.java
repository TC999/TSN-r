package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class k implements s {

    /* renamed from: a  reason: collision with root package name */
    private final e f812a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f813b;

    /* renamed from: c  reason: collision with root package name */
    private int f814c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f815d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f812a = eVar;
            this.f813b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void b() throws IOException {
        int i4 = this.f814c;
        if (i4 == 0) {
            return;
        }
        int remaining = i4 - this.f813b.getRemaining();
        this.f814c -= remaining;
        this.f812a.skip(remaining);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j4) throws IOException {
        o b4;
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0) {
            if (this.f815d) {
                throw new IllegalStateException("closed");
            }
            if (i4 == 0) {
                return 0L;
            }
            while (true) {
                boolean a4 = a();
                try {
                    b4 = cVar.b(1);
                    int inflate = this.f813b.inflate(b4.f828a, b4.f830c, (int) Math.min(j4, 8192 - b4.f830c));
                    if (inflate > 0) {
                        b4.f830c += inflate;
                        long j5 = inflate;
                        cVar.f798b += j5;
                        return j5;
                    } else if (this.f813b.finished() || this.f813b.needsDictionary()) {
                        break;
                    } else if (a4) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e4) {
                    throw new IOException(e4);
                }
            }
            b();
            if (b4.f829b == b4.f830c) {
                cVar.f797a = b4.b();
                p.a(b4);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f815d) {
            return;
        }
        this.f813b.end();
        this.f815d = true;
        this.f812a.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t t() {
        return this.f812a.t();
    }

    public final boolean a() throws IOException {
        if (this.f813b.needsInput()) {
            b();
            if (this.f813b.getRemaining() == 0) {
                if (this.f812a.x()) {
                    return true;
                }
                o oVar = this.f812a.o().f797a;
                int i4 = oVar.f830c;
                int i5 = oVar.f829b;
                int i6 = i4 - i5;
                this.f814c = i6;
                this.f813b.setInput(oVar.f828a, i5, i6);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }
}

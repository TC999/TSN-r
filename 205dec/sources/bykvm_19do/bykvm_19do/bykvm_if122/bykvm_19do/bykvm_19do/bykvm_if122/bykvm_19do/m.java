package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSink.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f822a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final r f823b;

    /* renamed from: c  reason: collision with root package name */
    boolean f824c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar != null) {
            this.f823b = rVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public void b(c cVar, long j4) throws IOException {
        if (!this.f824c) {
            this.f822a.b(cVar, j4);
            z();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f824c) {
            return;
        }
        try {
            c cVar = this.f822a;
            long j4 = cVar.f798b;
            if (j4 > 0) {
                this.f823b.b(cVar, j4);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f823b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f824c = true;
        if (th == null) {
            return;
        }
        u.a(th);
        throw null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d d(String str) throws IOException {
        if (!this.f824c) {
            this.f822a.d(str);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f824c) {
            c cVar = this.f822a;
            long j4 = cVar.f798b;
            if (j4 > 0) {
                this.f823b.b(cVar, j4);
            }
            this.f823b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d g(long j4) throws IOException {
        if (!this.f824c) {
            this.f822a.g(j4);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f824c;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c o() {
        return this.f822a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public t t() {
        return this.f823b.t();
    }

    public String toString() {
        return "buffer(" + this.f823b + ")";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d write(byte[] bArr) throws IOException {
        if (!this.f824c) {
            this.f822a.write(bArr);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d writeByte(int i4) throws IOException {
        if (!this.f824c) {
            this.f822a.writeByte(i4);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d writeInt(int i4) throws IOException {
        if (!this.f824c) {
            this.f822a.writeInt(i4);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d writeShort(int i4) throws IOException {
        if (!this.f824c) {
            this.f822a.writeShort(i4);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d z() throws IOException {
        if (!this.f824c) {
            long b4 = this.f822a.b();
            if (b4 > 0) {
                this.f823b.b(this.f822a, b4);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public d write(byte[] bArr, int i4, int i5) throws IOException {
        if (!this.f824c) {
            this.f822a.write(bArr, i4, i5);
            return z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f824c) {
            int write = this.f822a.write(byteBuffer);
            z();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}

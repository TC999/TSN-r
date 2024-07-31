package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: a */
    public final Buffer f829a = new Buffer();

    /* renamed from: b */
    public final Sink f830b;

    /* renamed from: c */
    boolean f831c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSink(Sink sink) {
        if (sink != null) {
            this.f830b = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
    /* renamed from: b */
    public void mo58561b(Buffer buffer, long j) throws IOException {
        if (!this.f831c) {
            this.f829a.mo58561b(buffer, j);
            mo58916z();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f831c) {
            return;
        }
        try {
            Buffer buffer = this.f829a;
            long j = buffer.f805b;
            if (j > 0) {
                this.f830b.mo58561b(buffer, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f830b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f831c = true;
        if (th == null) {
            return;
        }
        Util.m58866a(th);
        throw null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: d */
    public BufferedSink mo58918d(String str) throws IOException {
        if (!this.f831c) {
            this.f829a.mo58918d(str);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f831c) {
            Buffer buffer = this.f829a;
            long j = buffer.f805b;
            if (j > 0) {
                this.f830b.mo58561b(buffer, j);
            }
            this.f830b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: g */
    public BufferedSink mo58917g(long j) throws IOException {
        if (!this.f831c) {
            this.f829a.mo58917g(j);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f831c;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: o */
    public Buffer mo58905o() {
        return this.f829a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
    /* renamed from: t */
    public Timeout mo58560t() {
        return this.f830b.mo58560t();
    }

    public String toString() {
        return "buffer(" + this.f830b + ")";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.f831c) {
            this.f829a.write(bArr);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public BufferedSink writeByte(int i) throws IOException {
        if (!this.f831c) {
            this.f829a.writeByte(i);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public BufferedSink writeInt(int i) throws IOException {
        if (!this.f831c) {
            this.f829a.writeInt(i);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (!this.f831c) {
            this.f829a.writeShort(i);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: z */
    public BufferedSink mo58916z() throws IOException {
        if (!this.f831c) {
            long m58954b = this.f829a.m58954b();
            if (m58954b > 0) {
                this.f830b.mo58561b(this.f829a, m58954b);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f831c) {
            this.f829a.write(bArr, i, i2);
            return mo58916z();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f831c) {
            int write = this.f829a.write(byteBuffer);
            mo58916z();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}

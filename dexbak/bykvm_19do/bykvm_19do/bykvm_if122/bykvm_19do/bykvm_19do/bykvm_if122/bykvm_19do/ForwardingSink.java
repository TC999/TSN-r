package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class ForwardingSink implements Sink {

    /* renamed from: a */
    private final Sink f811a;

    public ForwardingSink(Sink sink) {
        if (sink != null) {
            this.f811a = sink;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
    /* renamed from: b */
    public void mo58561b(Buffer buffer, long j) throws IOException {
        this.f811a.mo58561b(buffer, j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f811a.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f811a.flush();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
    /* renamed from: t */
    public Timeout mo58560t() {
        return this.f811a.mo58560t();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f811a.toString() + ")";
    }
}

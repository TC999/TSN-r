package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;

/* compiled from: ForwardingSink.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class g implements r {

    /* renamed from: a  reason: collision with root package name */
    private final r f804a;

    public g(r rVar) {
        if (rVar != null) {
            this.f804a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public void b(c cVar, long j4) throws IOException {
        this.f804a.b(cVar, j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f804a.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    public void flush() throws IOException {
        this.f804a.flush();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public t t() {
        return this.f804a.t();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f804a.toString() + ")";
    }
}

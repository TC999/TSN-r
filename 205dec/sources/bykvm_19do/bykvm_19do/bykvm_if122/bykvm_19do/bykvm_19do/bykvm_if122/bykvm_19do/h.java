package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;

/* compiled from: ForwardingSource.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class h implements s {

    /* renamed from: a  reason: collision with root package name */
    private final s f805a;

    public h(s sVar) {
        if (sVar != null) {
            this.f805a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final s a() {
        return this.f805a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f805a.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t t() {
        return this.f805a.t();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f805a.toString() + ")";
    }
}

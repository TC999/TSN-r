package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class ForwardingSource implements Source {

    /* renamed from: a */
    private final Source f812a;

    public ForwardingSource(Source source) {
        if (source != null) {
            this.f812a = source;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final Source m58936a() {
        return this.f812a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f812a.close();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: t */
    public Timeout mo58555t() {
        return this.f812a.mo58555t();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f812a.toString() + ")";
    }
}

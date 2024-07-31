package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface Source extends Closeable {
    /* renamed from: a */
    long mo58558a(Buffer buffer, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    /* renamed from: t */
    Timeout mo58555t();
}

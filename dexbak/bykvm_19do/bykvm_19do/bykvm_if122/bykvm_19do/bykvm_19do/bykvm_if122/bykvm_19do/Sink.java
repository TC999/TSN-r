package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface Sink extends Closeable, Flushable {
    /* renamed from: b */
    void mo58561b(Buffer buffer, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    /* renamed from: t */
    Timeout mo58560t();
}

package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    /* renamed from: d */
    BufferedSink mo58918d(String str) throws IOException;

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
    void flush() throws IOException;

    /* renamed from: g */
    BufferedSink mo58917g(long j) throws IOException;

    /* renamed from: o */
    Buffer mo58905o();

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i, int i2) throws IOException;

    BufferedSink writeByte(int i) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int i) throws IOException;

    /* renamed from: z */
    BufferedSink mo58916z() throws IOException;
}

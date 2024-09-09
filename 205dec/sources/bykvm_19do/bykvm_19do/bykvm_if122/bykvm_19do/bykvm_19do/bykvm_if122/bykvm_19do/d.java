package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public interface d extends r, WritableByteChannel {
    d d(String str) throws IOException;

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    void flush() throws IOException;

    d g(long j4) throws IOException;

    c o();

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i4, int i5) throws IOException;

    d writeByte(int i4) throws IOException;

    d writeInt(int i4) throws IOException;

    d writeShort(int i4) throws IOException;

    d z() throws IOException;
}

package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b4) throws IOException;

    String a(Charset charset) throws IOException;

    boolean a(long j4, f fVar) throws IOException;

    void c(long j4) throws IOException;

    f d(long j4) throws IOException;

    String e(long j4) throws IOException;

    byte[] f(long j4) throws IOException;

    @Deprecated
    c o();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j4) throws IOException;

    short u() throws IOException;

    String v() throws IOException;

    int w() throws IOException;

    boolean x() throws IOException;

    long y() throws IOException;
}

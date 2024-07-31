package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    /* renamed from: a */
    long mo58915a(byte b) throws IOException;

    /* renamed from: a */
    String mo58910a(Charset charset) throws IOException;

    /* renamed from: a */
    boolean mo58912a(long j, ByteString byteString) throws IOException;

    /* renamed from: c */
    void mo58909c(long j) throws IOException;

    /* renamed from: d */
    ByteString mo58908d(long j) throws IOException;

    /* renamed from: e */
    String mo58907e(long j) throws IOException;

    /* renamed from: f */
    byte[] mo58906f(long j) throws IOException;

    @Deprecated
    /* renamed from: o */
    Buffer mo58905o();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;

    /* renamed from: u */
    short mo58904u() throws IOException;

    /* renamed from: v */
    String mo58903v() throws IOException;

    /* renamed from: w */
    int mo58902w() throws IOException;

    /* renamed from: x */
    boolean mo58901x() throws IOException;

    /* renamed from: y */
    long mo58900y() throws IOException;
}

package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(Source source, long j4) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i4, int i5) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int i4) throws IOException;

    BufferedSink writeDecimalLong(long j4) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j4) throws IOException;

    BufferedSink writeInt(int i4) throws IOException;

    BufferedSink writeIntLe(int i4) throws IOException;

    BufferedSink writeLong(long j4) throws IOException;

    BufferedSink writeLongLe(long j4) throws IOException;

    BufferedSink writeShort(int i4) throws IOException;

    BufferedSink writeShortLe(int i4) throws IOException;

    BufferedSink writeString(String str, int i4, int i5, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int i4, int i5) throws IOException;

    BufferedSink writeUtf8CodePoint(int i4) throws IOException;
}

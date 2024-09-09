package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer buffer();

    boolean exhausted() throws IOException;

    long indexOf(byte b4) throws IOException;

    long indexOf(byte b4, long j4) throws IOException;

    long indexOf(byte b4, long j4, long j5) throws IOException;

    long indexOf(ByteString byteString) throws IOException;

    long indexOf(ByteString byteString, long j4) throws IOException;

    long indexOfElement(ByteString byteString) throws IOException;

    long indexOfElement(ByteString byteString, long j4) throws IOException;

    InputStream inputStream();

    boolean rangeEquals(long j4, ByteString byteString) throws IOException;

    boolean rangeEquals(long j4, ByteString byteString, int i4, int i5) throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i4, int i5) throws IOException;

    long readAll(Sink sink) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long j4) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long j4) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(Buffer buffer, long j4) throws IOException;

    void readFully(byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readString(long j4, Charset charset) throws IOException;

    String readString(Charset charset) throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long j4) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @Nullable
    String readUtf8Line() throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long j4) throws IOException;

    boolean request(long j4) throws IOException;

    void require(long j4) throws IOException;

    int select(Options options) throws IOException;

    void skip(long j4) throws IOException;
}

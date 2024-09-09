package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BufferedSource.kt */
@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\b\u0010\u0017\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001eH&J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001eH&J \u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011H&J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020$H&J\b\u0010'\u001a\u00020&H&J\u0010\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u0007H&J\n\u0010(\u001a\u0004\u0018\u00010&H&J\b\u0010)\u001a\u00020&H&J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0007H&J\b\u0010+\u001a\u00020\u0011H&J\u0010\u0010.\u001a\u00020&2\u0006\u0010-\u001a\u00020,H&J\u0018\u0010.\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H&J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\fH&J\u0018\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0007H&J \u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\f2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H&J\u0010\u00100\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0019H&J\u0018\u00100\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0007H&J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0019H&J\u0018\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0007H&J\u0018\u00106\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0019H&J(\u00106\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011H&J\b\u00108\u001a\u00020\u0000H&J\b\u0010:\u001a\u000209H&R\u0014\u0010\u0004\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010<\u00a8\u0006="}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "", "exhausted", "", "byteCount", "Lkotlin/f1;", "require", "request", "", "readByte", "", "readShort", "readShortLe", "", "readInt", "readIntLe", "readLong", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "Lokio/ByteString;", "readByteString", "Lokio/Options;", "options", "select", "", "readByteArray", "sink", "read", "readFully", "offset", "Lokio/Sink;", "readAll", "", "readUtf8", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "Ljava/nio/charset/Charset;", "charset", "readString", "b", "indexOf", "fromIndex", "toIndex", "bytes", "targetBytes", "indexOfElement", "rangeEquals", "bytesOffset", "peek", "Ljava/io/InputStream;", "inputStream", "getBuffer", "()Lokio/Buffer;", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    @NotNull
    Buffer buffer();

    boolean exhausted() throws IOException;

    @NotNull
    Buffer getBuffer();

    long indexOf(byte b4) throws IOException;

    long indexOf(byte b4, long j4) throws IOException;

    long indexOf(byte b4, long j4, long j5) throws IOException;

    long indexOf(@NotNull ByteString byteString) throws IOException;

    long indexOf(@NotNull ByteString byteString, long j4) throws IOException;

    long indexOfElement(@NotNull ByteString byteString) throws IOException;

    long indexOfElement(@NotNull ByteString byteString, long j4) throws IOException;

    @NotNull
    InputStream inputStream();

    @NotNull
    BufferedSource peek();

    boolean rangeEquals(long j4, @NotNull ByteString byteString) throws IOException;

    boolean rangeEquals(long j4, @NotNull ByteString byteString, int i4, int i5) throws IOException;

    int read(@NotNull byte[] bArr) throws IOException;

    int read(@NotNull byte[] bArr, int i4, int i5) throws IOException;

    long readAll(@NotNull Sink sink) throws IOException;

    byte readByte() throws IOException;

    @NotNull
    byte[] readByteArray() throws IOException;

    @NotNull
    byte[] readByteArray(long j4) throws IOException;

    @NotNull
    ByteString readByteString() throws IOException;

    @NotNull
    ByteString readByteString(long j4) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(@NotNull Buffer buffer, long j4) throws IOException;

    void readFully(@NotNull byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    @NotNull
    String readString(long j4, @NotNull Charset charset) throws IOException;

    @NotNull
    String readString(@NotNull Charset charset) throws IOException;

    @NotNull
    String readUtf8() throws IOException;

    @NotNull
    String readUtf8(long j4) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @Nullable
    String readUtf8Line() throws IOException;

    @NotNull
    String readUtf8LineStrict() throws IOException;

    @NotNull
    String readUtf8LineStrict(long j4) throws IOException;

    boolean request(long j4) throws IOException;

    void require(long j4) throws IOException;

    int select(@NotNull Options options) throws IOException;

    void skip(long j4) throws IOException;
}

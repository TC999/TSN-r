package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BufferedSink.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&J \u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\bH&J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H&J(\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bH&J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bH&J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000eH&J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000eH&J\u0010\u0010%\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000eH&J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000eH&J\b\u0010(\u001a\u00020'H&J\b\u0010)\u001a\u00020\u0000H&J\b\u0010*\u001a\u00020\u0000H&J\b\u0010,\u001a\u00020+H&R\u0014\u0010\u0004\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u0006/"}, d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/Buffer;", "buffer", "Lokio/ByteString;", "byteString", "write", "", "offset", "byteCount", "", "source", "Lokio/Source;", "", "writeAll", "", "string", "writeUtf8", "beginIndex", "endIndex", "codePoint", "writeUtf8CodePoint", "Ljava/nio/charset/Charset;", "charset", "writeString", "b", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", "v", "writeLong", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "Lkotlin/f1;", "flush", "emit", "emitCompleteSegments", "Ljava/io/OutputStream;", "outputStream", "getBuffer", "()Lokio/Buffer;", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    @NotNull
    Buffer buffer();

    @NotNull
    BufferedSink emit() throws IOException;

    @NotNull
    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    @NotNull
    Buffer getBuffer();

    @NotNull
    OutputStream outputStream();

    @NotNull
    BufferedSink write(@NotNull ByteString byteString) throws IOException;

    @NotNull
    BufferedSink write(@NotNull ByteString byteString, int i4, int i5) throws IOException;

    @NotNull
    BufferedSink write(@NotNull Source source, long j4) throws IOException;

    @NotNull
    BufferedSink write(@NotNull byte[] bArr) throws IOException;

    @NotNull
    BufferedSink write(@NotNull byte[] bArr, int i4, int i5) throws IOException;

    long writeAll(@NotNull Source source) throws IOException;

    @NotNull
    BufferedSink writeByte(int i4) throws IOException;

    @NotNull
    BufferedSink writeDecimalLong(long j4) throws IOException;

    @NotNull
    BufferedSink writeHexadecimalUnsignedLong(long j4) throws IOException;

    @NotNull
    BufferedSink writeInt(int i4) throws IOException;

    @NotNull
    BufferedSink writeIntLe(int i4) throws IOException;

    @NotNull
    BufferedSink writeLong(long j4) throws IOException;

    @NotNull
    BufferedSink writeLongLe(long j4) throws IOException;

    @NotNull
    BufferedSink writeShort(int i4) throws IOException;

    @NotNull
    BufferedSink writeShortLe(int i4) throws IOException;

    @NotNull
    BufferedSink writeString(@NotNull String str, int i4, int i5, @NotNull Charset charset) throws IOException;

    @NotNull
    BufferedSink writeString(@NotNull String str, @NotNull Charset charset) throws IOException;

    @NotNull
    BufferedSink writeUtf8(@NotNull String str) throws IOException;

    @NotNull
    BufferedSink writeUtf8(@NotNull String str, int i4, int i5) throws IOException;

    @NotNull
    BufferedSink writeUtf8CodePoint(int i4) throws IOException;
}

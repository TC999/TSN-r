package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RealBufferedSink.kt */
@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J(\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0017H\u0016J \u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0019H\u0016J\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0001H\u0016J\b\u0010)\u001a\u00020\u0001H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u00020\rH\u0016R\u0014\u00103\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020-8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010\u0003\u001a\u00020\u00028\u00d6\u0002X\u0096\u0004\u00a2\u0006\f\u0012\u0004\b<\u0010=\u001a\u0004\b:\u0010;\u00a8\u0006@"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Buffer;", "buffer", "source", "", "byteCount", "Lkotlin/f1;", "write", "Lokio/ByteString;", "byteString", "", "offset", "", "string", "writeUtf8", "beginIndex", "endIndex", "codePoint", "writeUtf8CodePoint", "Ljava/nio/charset/Charset;", "charset", "writeString", "", "Ljava/nio/ByteBuffer;", "Lokio/Source;", "writeAll", "b", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", "v", "writeLong", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "emit", "Ljava/io/OutputStream;", "outputStream", "flush", "", "isOpen", "close", "Lokio/Timeout;", "timeout", "toString", "bufferField", "Lokio/Buffer;", "closed", "Z", "Lokio/Sink;", "sink", "Lokio/Sink;", "getBuffer", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RealBufferedSink implements BufferedSink {
    @JvmField
    @NotNull
    public final Buffer bufferField;
    @JvmField
    public boolean closed;
    @JvmField
    @NotNull
    public final Sink sink;

    public RealBufferedSink(@NotNull Sink sink) {
        f0.p(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emit() {
        if (!this.closed) {
            long size = this.bufferField.size();
            if (size > 0) {
                this.sink.write(this.bufferField, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.bufferField, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!this.closed) {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            @NotNull
            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i4) {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.writeByte((int) ((byte) i4));
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] data, int i4, int i5) {
                f0.p(data, "data");
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.write(data, i4, i5);
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) {
        f0.p(source, "source");
        if (!this.closed) {
            int write = this.bufferField.write(source);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) {
        f0.p(source, "source");
        long j4 = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192);
            if (read == -1) {
                return j4;
            }
            j4 += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeByte(int i4) {
        if (!this.closed) {
            this.bufferField.writeByte(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeDecimalLong(long j4) {
        if (!this.closed) {
            this.bufferField.writeDecimalLong(j4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long j4) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeInt(int i4) {
        if (!this.closed) {
            this.bufferField.writeInt(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeIntLe(int i4) {
        if (!this.closed) {
            this.bufferField.writeIntLe(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLong(long j4) {
        if (!this.closed) {
            this.bufferField.writeLong(j4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLongLe(long j4) {
        if (!this.closed) {
            this.bufferField.writeLongLe(j4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShort(int i4) {
        if (!this.closed) {
            this.bufferField.writeShort(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShortLe(int i4) {
        if (!this.closed) {
            this.bufferField.writeShortLe(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String string, @NotNull Charset charset) {
        f0.p(string, "string");
        f0.p(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(string, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string) {
        f0.p(string, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(string);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8CodePoint(int i4) {
        if (!this.closed) {
            this.bufferField.writeUtf8CodePoint(i4);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j4) {
        f0.p(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, j4);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String string, int i4, int i5, @NotNull Charset charset) {
        f0.p(string, "string");
        f0.p(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(string, i4, i5, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string, int i4, int i5) {
        f0.p(string, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(string, i4, i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        f0.p(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int i4, int i5) {
        f0.p(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i4, i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] source) {
        f0.p(source, "source");
        if (!this.closed) {
            this.bufferField.write(source);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] source, int i4, int i5) {
        f0.p(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, i4, i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull Source source, long j4) {
        f0.p(source, "source");
        while (j4 > 0) {
            long read = source.read(this.bufferField, j4);
            if (read != -1) {
                j4 -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}

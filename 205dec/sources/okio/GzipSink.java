package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GzipSink.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u000f\u0010\u0012\u001a\u00020\u000fH\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0012\u001a\u00020\u000f8G\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "Lkotlin/f1;", "writeFooter", "Lokio/Buffer;", "buffer", "", "byteCount", "updateCrc", "source", "write", "flush", "Lokio/Timeout;", "timeout", "close", "Ljava/util/zip/Deflater;", "-deprecated_deflater", "()Ljava/util/zip/Deflater;", "deflater", "Lokio/RealBufferedSink;", "sink", "Lokio/RealBufferedSink;", "Ljava/util/zip/Deflater;", "Lokio/DeflaterSink;", "deflaterSink", "Lokio/DeflaterSink;", "", "closed", "Z", "Ljava/util/zip/CRC32;", "crc", "Ljava/util/zip/CRC32;", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;
    @NotNull
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(@NotNull Sink sink) {
        f0.p(sink, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        this.sink = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new DeflaterSink((BufferedSink) realBufferedSink, deflater);
        this.crc = new CRC32();
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void updateCrc(Buffer buffer, long j4) {
        Segment segment = buffer.head;
        f0.m(segment);
        while (j4 > 0) {
            int min = (int) Math.min(j4, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, min);
            j4 -= min;
            segment = segment.next;
            f0.m(segment);
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))
    @JvmName(name = "-deprecated_deflater")
    @NotNull
    /* renamed from: -deprecated_deflater  reason: not valid java name */
    public final Deflater m281deprecated_deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            this.deflaterSink.finishDeflate$okio();
            writeFooter();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.deflater.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @JvmName(name = "deflater")
    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j4) throws IOException {
        f0.p(source, "source");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (j4 == 0) {
        } else {
            updateCrc(source, j4);
            this.deflaterSink.write(source, j4);
        }
    }
}

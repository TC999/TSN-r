package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: GzipSource.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "Lkotlin/f1;", "consumeHeader", "consumeTrailer", "Lokio/Buffer;", "buffer", "", "offset", "byteCount", "updateCrc", "", "name", "", "expected", "actual", "checkEqual", "sink", "read", "Lokio/Timeout;", "timeout", "close", "", "section", "B", "Lokio/RealBufferedSource;", "source", "Lokio/RealBufferedSource;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/InflaterSource;", "inflaterSource", "Lokio/InflaterSource;", "Ljava/util/zip/CRC32;", "crc", "Ljava/util/zip/CRC32;", "<init>", "(Lokio/Source;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(@NotNull Source source) {
        f0.p(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String str, int i4, int i5) {
        if (i5 == i4) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i4)}, 3));
        f0.o(format, "java.lang.String.format(this, *args)");
        throw new IOException(format);
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b4 = this.source.bufferField.getByte(3L);
        boolean z3 = ((b4 >> 1) & 1) == 1;
        if (z3) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b4 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z3) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long readShortLe = this.source.bufferField.readShortLe();
            this.source.require(readShortLe);
            if (z3) {
                updateCrc(this.source.bufferField, 0L, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b4 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z3) {
                    updateCrc(this.source.bufferField, 0L, indexOf + 1);
                }
                this.source.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b4 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z3) {
                    updateCrc(this.source.bufferField, 0L, indexOf2 + 1);
                }
                this.source.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z3) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j4, long j5) {
        int i4;
        Segment segment = buffer.head;
        f0.m(segment);
        while (true) {
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (j4 < i5 - i6) {
                break;
            }
            j4 -= i5 - i6;
            segment = segment.next;
            f0.m(segment);
        }
        while (j5 > 0) {
            int min = (int) Math.min(segment.limit - i4, j5);
            this.crc.update(segment.data, (int) (segment.pos + j4), min);
            j5 -= min;
            segment = segment.next;
            f0.m(segment);
            j4 = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j4) throws IOException {
        f0.p(sink, "sink");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (j4 == 0) {
            return 0L;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = (byte) 1;
            }
            if (this.section == 1) {
                long size = sink.size();
                long read = this.inflaterSource.read(sink, j4);
                if (read != -1) {
                    updateCrc(sink, size, read);
                    return read;
                }
                this.section = (byte) 2;
            }
            if (this.section == 2) {
                consumeTrailer();
                this.section = (byte) 3;
                if (!this.source.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }
}

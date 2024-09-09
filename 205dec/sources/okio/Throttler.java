package okio;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Throttler.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aB\t\b\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001bJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J$\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lokio/Throttler;", "", "", "nanosToBytes", "bytesToNanos", "nanosToWait", "Lkotlin/f1;", "waitNanos", "bytesPerSecond", "waitByteCount", "maxByteCount", "byteCount", "take$okio", "(J)J", "take", "now", "byteCountOrWaitNanos$okio", "(JJ)J", "byteCountOrWaitNanos", "Lokio/Source;", "source", "Lokio/Sink;", "sink", "J", "allocatedUntil", "<init>", "(J)V", "()V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j4) {
        this.allocatedUntil = j4;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j4, long j5, long j6, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j5 = throttler.waitByteCount;
        }
        long j7 = j5;
        if ((i4 & 4) != 0) {
            j6 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j4, j7, j6);
    }

    private final long bytesToNanos(long j4) {
        return (j4 * C.NANOS_PER_SECOND) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j4) {
        return (j4 * this.bytesPerSecond) / C.NANOS_PER_SECOND;
    }

    private final void waitNanos(long j4) {
        long j5 = j4 / C.MICROS_PER_SECOND;
        wait(j5, (int) (j4 - (C.MICROS_PER_SECOND * j5)));
    }

    public final long byteCountOrWaitNanos$okio(long j4, long j5) {
        if (this.bytesPerSecond == 0) {
            return j5;
        }
        long max = Math.max(this.allocatedUntil - j4, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j5) {
            this.allocatedUntil = j4 + max + bytesToNanos(j5);
            return j5;
        }
        long j6 = this.waitByteCount;
        if (nanosToBytes >= j6) {
            this.allocatedUntil = j4 + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j6, j5);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos == 0) {
            this.allocatedUntil = j4 + bytesToNanos(this.maxByteCount);
            return min;
        }
        return -bytesToNanos;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j4) {
        bytesPerSecond$default(this, j4, 0L, 0L, 6, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j4, long j5) {
        bytesPerSecond$default(this, j4, j5, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j4, long j5, long j6) {
        synchronized (this) {
            if (!(j4 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j5 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (j6 >= j5) {
                this.bytesPerSecond = j4;
                this.waitByteCount = j5;
                this.maxByteCount = j6;
                notifyAll();
                f1 f1Var = f1.f55527a;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        f0.p(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long j4) throws IOException {
                f0.p(source, "source");
                while (j4 > 0) {
                    try {
                        long take$okio = Throttler.this.take$okio(j4);
                        super.write(source, take$okio);
                        j4 -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        f0.p(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long j4) {
                f0.p(sink, "sink");
                try {
                    return super.read(sink, Throttler.this.take$okio(j4));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j4) {
        long byteCountOrWaitNanos$okio;
        if (j4 > 0) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j4);
                    if (byteCountOrWaitNanos$okio < 0) {
                        waitNanos(-byteCountOrWaitNanos$okio);
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Throttler() {
        this(System.nanoTime());
    }
}

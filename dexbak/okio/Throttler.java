package okio;

import android.support.p015v4.media.session.PlaybackStateCompat;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Throttler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aB\t\b\u0016¢\u0006\u0004\b\u0019\u0010\u001bJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J$\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001c"}, m12616d2 = {"Lokio/Throttler;", "", "", "nanosToBytes", "bytesToNanos", "nanosToWait", "Lkotlin/f1;", "waitNanos", "bytesPerSecond", "waitByteCount", "maxByteCount", "byteCount", "take$okio", "(J)J", "take", "now", "byteCountOrWaitNanos$okio", "(JJ)J", "byteCountOrWaitNanos", "Lokio/Source;", SocialConstants.PARAM_SOURCE, "Lokio/Sink;", "sink", "J", "allocatedUntil", "<init>", "(J)V", "()V", "okio"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j) {
        this.allocatedUntil = j;
        this.waitByteCount = 8192L;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = throttler.waitByteCount;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            j3 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j, j4, j3);
    }

    private final long bytesToNanos(long j) {
        return (j * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j) {
        return (j * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long j) {
        long j2 = j / 1000000;
        wait(j2, (int) (j - (1000000 * j2)));
    }

    public final long byteCountOrWaitNanos$okio(long j, long j2) {
        if (this.bytesPerSecond == 0) {
            return j2;
        }
        long max = Math.max(this.allocatedUntil - j, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j2) {
            this.allocatedUntil = j + max + bytesToNanos(j2);
            return j2;
        }
        long j3 = this.waitByteCount;
        if (nanosToBytes >= j3) {
            this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j3, j2);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos == 0) {
            this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
            return min;
        }
        return -bytesToNanos;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0L, 0L, 6, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j, long j2, long j3) {
        synchronized (this) {
            if (!(j >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j2 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (j3 >= j2) {
                this.bytesPerSecond = j;
                this.waitByteCount = j2;
                this.maxByteCount = j3;
                notifyAll();
                Unit unit = Unit.f41048a;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        C14342f0.m8184p(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long j) throws IOException {
                C14342f0.m8184p(source, "source");
                while (j > 0) {
                    try {
                        long take$okio = Throttler.this.take$okio(j);
                        super.write(source, take$okio);
                        j -= take$okio;
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
        C14342f0.m8184p(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long j) {
                C14342f0.m8184p(sink, "sink");
                try {
                    return super.read(sink, Throttler.this.take$okio(j));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j) {
        long byteCountOrWaitNanos$okio;
        if (j > 0) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j);
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

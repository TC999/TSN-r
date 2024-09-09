package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import java.util.AbstractMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    private volatile int maxBytesPerIndividualRead;
    private volatile int maxBytesPerRead;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class HandleImpl implements RecvByteBufAllocator.Handle {
        private int attemptBytesRead;
        private int bytesToRead;
        private int individualReadMax;
        private int lastBytesRead;

        /* renamed from: io.netty.channel.DefaultMaxBytesRecvByteBufAllocator$HandleImpl$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        class AnonymousClass1 implements UncheckedBooleanSupplier {
            AnonymousClass1() {
            }

            @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
            public boolean get() {
                return HandleImpl.access$000(HandleImpl.this) == HandleImpl.access$100(HandleImpl.this);
            }
        }

        private HandleImpl() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int i4) {
            this.attemptBytesRead = i4;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public boolean continueReading() {
            return this.bytesToRead > 0 && this.attemptBytesRead == this.lastBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return Math.min(this.individualReadMax, this.bytesToRead);
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void incMessagesRead(int i4) {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i4) {
            this.lastBytesRead = i4;
            this.bytesToRead -= i4;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void reset(ChannelConfig channelConfig) {
            this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
            this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int attemptedBytesRead() {
            return this.attemptBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int lastBytesRead() {
            return this.lastBytesRead;
        }
    }

    public DefaultMaxBytesRecvByteBufAllocator() {
        this(65536, 65536);
    }

    private void checkMaxBytesPerReadPair(int i4, int i5) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxBytesPerRead: " + i4 + " (expected: > 0)");
        } else if (i5 <= 0) {
            throw new IllegalArgumentException("maxBytesPerIndividualRead: " + i5 + " (expected: > 0)");
        } else if (i4 >= i5) {
        } else {
            throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + i5 + "): " + i4);
        }
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl();
    }

    public DefaultMaxBytesRecvByteBufAllocator(int i4, int i5) {
        checkMaxBytesPerReadPair(i4, i5);
        this.maxBytesPerRead = i4;
        this.maxBytesPerIndividualRead = i5;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerIndividualRead() {
        return this.maxBytesPerIndividualRead;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerRead() {
        return this.maxBytesPerRead;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public synchronized Map.Entry<Integer, Integer> maxBytesPerReadPair() {
        return new AbstractMap.SimpleEntry(Integer.valueOf(this.maxBytesPerRead), Integer.valueOf(this.maxBytesPerIndividualRead));
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i4) {
        if (i4 > 0) {
            synchronized (this) {
                int maxBytesPerRead = maxBytesPerRead();
                if (i4 <= maxBytesPerRead) {
                    this.maxBytesPerIndividualRead = i4;
                } else {
                    throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + maxBytesPerRead + "): " + i4);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("maxBytesPerIndividualRead: " + i4 + " (expected: > 0)");
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int i4) {
        if (i4 > 0) {
            synchronized (this) {
                int maxBytesPerIndividualRead = maxBytesPerIndividualRead();
                if (i4 >= maxBytesPerIndividualRead) {
                    this.maxBytesPerRead = i4;
                } else {
                    throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + maxBytesPerIndividualRead + "): " + i4);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("maxBytesPerRead: " + i4 + " (expected: > 0)");
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i4, int i5) {
        checkMaxBytesPerReadPair(i4, i5);
        synchronized (this) {
            this.maxBytesPerRead = i4;
            this.maxBytesPerIndividualRead = i5;
        }
        return this;
    }
}

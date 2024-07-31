package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    private volatile int maxBytesPerIndividualRead;
    private volatile int maxBytesPerRead;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class HandleImpl implements RecvByteBufAllocator.Handle {
        private int attemptBytesRead;
        private int bytesToRead;
        private int individualReadMax;
        private int lastBytesRead;

        private HandleImpl() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int i) {
            this.attemptBytesRead = i;
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
        public void incMessagesRead(int i) {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i) {
            this.lastBytesRead = i;
            this.bytesToRead -= i;
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

    private void checkMaxBytesPerReadPair(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxBytesPerRead: " + i + " (expected: > 0)");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("maxBytesPerIndividualRead: " + i2 + " (expected: > 0)");
        } else if (i >= i2) {
        } else {
            throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + i2 + "): " + i);
        }
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl();
    }

    public DefaultMaxBytesRecvByteBufAllocator(int i, int i2) {
        checkMaxBytesPerReadPair(i, i2);
        this.maxBytesPerRead = i;
        this.maxBytesPerIndividualRead = i2;
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
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i) {
        if (i > 0) {
            synchronized (this) {
                int maxBytesPerRead = maxBytesPerRead();
                if (i <= maxBytesPerRead) {
                    this.maxBytesPerIndividualRead = i;
                } else {
                    throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + maxBytesPerRead + "): " + i);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("maxBytesPerIndividualRead: " + i + " (expected: > 0)");
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int i) {
        if (i > 0) {
            synchronized (this) {
                int maxBytesPerIndividualRead = maxBytesPerIndividualRead();
                if (i >= maxBytesPerIndividualRead) {
                    this.maxBytesPerRead = i;
                } else {
                    throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + maxBytesPerIndividualRead + "): " + i);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("maxBytesPerRead: " + i + " (expected: > 0)");
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i, int i2) {
        checkMaxBytesPerReadPair(i, i2);
        synchronized (this) {
            this.maxBytesPerRead = i;
            this.maxBytesPerIndividualRead = i2;
        }
        return this;
    }
}

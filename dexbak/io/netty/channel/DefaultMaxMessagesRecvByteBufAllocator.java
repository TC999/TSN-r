package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class DefaultMaxMessagesRecvByteBufAllocator implements MaxMessagesRecvByteBufAllocator {
    private volatile int maxMessagesPerRead;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public abstract class MaxMessageHandle implements RecvByteBufAllocator.Handle {
        private int attemptedBytesRead;
        private ChannelConfig config;
        private int lastBytesRead;
        private int maxMessagePerRead;
        private int totalBytesRead;
        private int totalMessages;

        public MaxMessageHandle() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int attemptedBytesRead() {
            return this.attemptedBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public boolean continueReading() {
            return this.config.isAutoRead() && this.attemptedBytesRead == this.lastBytesRead && this.totalMessages < this.maxMessagePerRead && this.totalBytesRead < Integer.MAX_VALUE;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void incMessagesRead(int i) {
            this.totalMessages += i;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void lastBytesRead(int i) {
            this.lastBytesRead = i;
            int i2 = this.totalBytesRead + i;
            this.totalBytesRead = i2;
            if (i2 < 0) {
                this.totalBytesRead = Integer.MAX_VALUE;
            }
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void reset(ChannelConfig channelConfig) {
            this.config = channelConfig;
            this.maxMessagePerRead = DefaultMaxMessagesRecvByteBufAllocator.this.maxMessagesPerRead();
            this.totalBytesRead = 0;
            this.totalMessages = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final int totalBytesRead() {
            return this.totalBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int i) {
            this.attemptedBytesRead = i;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final int lastBytesRead() {
            return this.lastBytesRead;
        }
    }

    public DefaultMaxMessagesRecvByteBufAllocator() {
        this(1);
    }

    @Override // io.netty.channel.MaxMessagesRecvByteBufAllocator
    public int maxMessagesPerRead() {
        return this.maxMessagesPerRead;
    }

    public DefaultMaxMessagesRecvByteBufAllocator(int i) {
        maxMessagesPerRead(i);
    }

    @Override // io.netty.channel.MaxMessagesRecvByteBufAllocator
    public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int i) {
        if (i > 0) {
            this.maxMessagesPerRead = i;
            return this;
        }
        throw new IllegalArgumentException("maxMessagesPerRead: " + i + " (expected: > 0)");
    }
}

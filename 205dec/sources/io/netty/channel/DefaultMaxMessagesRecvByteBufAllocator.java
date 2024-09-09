package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class DefaultMaxMessagesRecvByteBufAllocator implements MaxMessagesRecvByteBufAllocator {
    private volatile int maxMessagesPerRead;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public abstract class MaxMessageHandle implements RecvByteBufAllocator.Handle {
        private int attemptedBytesRead;
        private ChannelConfig config;
        private int lastBytesRead;
        private int maxMessagePerRead;
        private int totalBytesRead;
        private int totalMessages;

        /* renamed from: io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator$MaxMessageHandle$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        class AnonymousClass1 implements UncheckedBooleanSupplier {
            AnonymousClass1() {
            }

            @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
            public boolean get() {
                return MaxMessageHandle.access$100(MaxMessageHandle.this) == MaxMessageHandle.access$200(MaxMessageHandle.this);
            }
        }

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
        public final void incMessagesRead(int i4) {
            this.totalMessages += i4;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void lastBytesRead(int i4) {
            this.lastBytesRead = i4;
            int i5 = this.totalBytesRead + i4;
            this.totalBytesRead = i5;
            if (i5 < 0) {
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
        public void attemptedBytesRead(int i4) {
            this.attemptedBytesRead = i4;
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

    public DefaultMaxMessagesRecvByteBufAllocator(int i4) {
        maxMessagesPerRead(i4);
    }

    @Override // io.netty.channel.MaxMessagesRecvByteBufAllocator
    public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int i4) {
        if (i4 > 0) {
            this.maxMessagesPerRead = i4;
            return this;
        }
        throw new IllegalArgumentException("maxMessagesPerRead: " + i4 + " (expected: > 0)");
    }
}

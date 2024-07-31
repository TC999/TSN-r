package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.MessageSizeEstimator;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DefaultMessageSizeEstimator implements MessageSizeEstimator {
    public static final MessageSizeEstimator DEFAULT = new DefaultMessageSizeEstimator(8);
    private final MessageSizeEstimator.Handle handle;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class HandleImpl implements MessageSizeEstimator.Handle {
        private final int unknownSize;

        @Override // io.netty.channel.MessageSizeEstimator.Handle
        public int size(Object obj) {
            if (obj instanceof ByteBuf) {
                return ((ByteBuf) obj).readableBytes();
            }
            if (obj instanceof ByteBufHolder) {
                return ((ByteBufHolder) obj).content().readableBytes();
            }
            if (obj instanceof FileRegion) {
                return 0;
            }
            return this.unknownSize;
        }

        private HandleImpl(int i) {
            this.unknownSize = i;
        }
    }

    public DefaultMessageSizeEstimator(int i) {
        if (i >= 0) {
            this.handle = new HandleImpl(i);
            return;
        }
        throw new IllegalArgumentException("unknownSize: " + i + " (expected: >= 0)");
    }

    @Override // io.netty.channel.MessageSizeEstimator
    public MessageSizeEstimator.Handle newHandle() {
        return this.handle;
    }
}

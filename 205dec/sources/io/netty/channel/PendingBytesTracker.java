package io.netty.channel;

import io.netty.channel.MessageSizeEstimator;
import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
abstract class PendingBytesTracker implements MessageSizeEstimator.Handle {
    private final MessageSizeEstimator.Handle estimatorHandle;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class ChannelOutboundBufferPendingBytesTracker extends PendingBytesTracker {
        private final ChannelOutboundBuffer buffer;

        ChannelOutboundBufferPendingBytesTracker(ChannelOutboundBuffer channelOutboundBuffer, MessageSizeEstimator.Handle handle) {
            super(handle);
            this.buffer = channelOutboundBuffer;
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j4) {
            this.buffer.decrementPendingOutboundBytes(j4);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j4) {
            this.buffer.incrementPendingOutboundBytes(j4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class DefaultChannelPipelinePendingBytesTracker extends PendingBytesTracker {
        private final DefaultChannelPipeline pipeline;

        DefaultChannelPipelinePendingBytesTracker(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline.estimatorHandle());
            this.pipeline = defaultChannelPipeline;
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j4) {
            this.pipeline.decrementPendingOutboundBytes(j4);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j4) {
            this.pipeline.incrementPendingOutboundBytes(j4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class NoopPendingBytesTracker extends PendingBytesTracker {
        NoopPendingBytesTracker(MessageSizeEstimator.Handle handle) {
            super(handle);
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long j4) {
        }

        @Override // io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long j4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PendingBytesTracker newTracker(Channel channel) {
        if (channel.pipeline() instanceof DefaultChannelPipeline) {
            return new DefaultChannelPipelinePendingBytesTracker((DefaultChannelPipeline) channel.pipeline());
        }
        ChannelOutboundBuffer outboundBuffer = channel.unsafe().outboundBuffer();
        MessageSizeEstimator.Handle newHandle = channel.config().getMessageSizeEstimator().newHandle();
        return outboundBuffer == null ? new NoopPendingBytesTracker(newHandle) : new ChannelOutboundBufferPendingBytesTracker(outboundBuffer, newHandle);
    }

    public abstract void decrementPendingOutboundBytes(long j4);

    public abstract void incrementPendingOutboundBytes(long j4);

    @Override // io.netty.channel.MessageSizeEstimator.Handle
    public final int size(Object obj) {
        return this.estimatorHandle.size(obj);
    }

    private PendingBytesTracker(MessageSizeEstimator.Handle handle) {
        this.estimatorHandle = (MessageSizeEstimator.Handle) ObjectUtil.checkNotNull(handle, "estimatorHandle");
    }
}

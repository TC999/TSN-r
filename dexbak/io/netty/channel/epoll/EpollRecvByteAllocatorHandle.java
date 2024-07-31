package io.netty.channel.epoll;

import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class EpollRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle {
    private final ChannelConfig config;
    private boolean isEdgeTriggered;
    private boolean receivedRdHup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollRecvByteAllocatorHandle(RecvByteBufAllocator.Handle handle, ChannelConfig channelConfig) {
        super(handle);
        this.config = channelConfig;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public final boolean continueReading() {
        return this.receivedRdHup || (maybeMoreDataToRead() && this.config.isAutoRead()) || super.continueReading();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void edgeTriggered(boolean z) {
        this.isEdgeTriggered = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEdgeTriggered() {
        return this.isEdgeTriggered;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean maybeMoreDataToRead() {
        return this.isEdgeTriggered && lastBytesRead() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void receivedRdHup() {
        this.receivedRdHup = true;
    }
}

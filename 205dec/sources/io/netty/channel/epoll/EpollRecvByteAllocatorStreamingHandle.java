package io.netty.channel.epoll;

import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class EpollRecvByteAllocatorStreamingHandle extends EpollRecvByteAllocatorHandle {
    public EpollRecvByteAllocatorStreamingHandle(RecvByteBufAllocator.Handle handle, ChannelConfig channelConfig) {
        super(handle, channelConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.epoll.EpollRecvByteAllocatorHandle
    public boolean maybeMoreDataToRead() {
        return isEdgeTriggered() && lastBytesRead() == attemptedBytesRead();
    }
}

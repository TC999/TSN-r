package io.netty.channel.epoll;

import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class EpollRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle {
    private final ChannelConfig config;
    private boolean isEdgeTriggered;
    private boolean receivedRdHup;

    /* renamed from: io.netty.channel.epoll.EpollRecvByteAllocatorHandle$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass1 implements UncheckedBooleanSupplier {
        AnonymousClass1() {
        }

        @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
        public boolean get() {
            return EpollRecvByteAllocatorHandle.this.maybeMoreDataToRead();
        }
    }

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
    public final void edgeTriggered(boolean z3) {
        this.isEdgeTriggered = z3;
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

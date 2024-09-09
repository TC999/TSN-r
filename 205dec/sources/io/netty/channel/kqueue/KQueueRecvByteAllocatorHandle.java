package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class KQueueRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier;
    private long numberBytesPending;
    private boolean overrideGuess;
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator;
    private boolean readEOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KQueueRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
        this.preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
        this.defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle.1
            @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
            public boolean get() {
                return KQueueRecvByteAllocatorHandle.this.maybeMoreDataToRead();
            }
        };
    }

    private int guess0() {
        return (int) Math.min(this.numberBytesPending, 2147483647L);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
        this.preferredDirectByteBufAllocator.updateAllocator(byteBufAllocator);
        return this.overrideGuess ? this.preferredDirectByteBufAllocator.ioBuffer(guess0()) : delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(uncheckedBooleanSupplier);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public int guess() {
        return this.overrideGuess ? guess0() : delegate().guess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReadEOF() {
        return this.readEOF;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public void lastBytesRead(int i4) {
        this.numberBytesPending = i4 >= 0 ? Math.max(0L, this.numberBytesPending - i4) : 0L;
        delegate().lastBytesRead(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean maybeMoreDataToRead() {
        return this.numberBytesPending != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void numberBytesPending(long j4) {
        this.numberBytesPending = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readEOF() {
        this.readEOF = true;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public void reset(ChannelConfig channelConfig) {
        this.overrideGuess = ((KQueueChannelConfig) channelConfig).getRcvAllocTransportProvidesGuess();
        delegate().reset(channelConfig);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }
}

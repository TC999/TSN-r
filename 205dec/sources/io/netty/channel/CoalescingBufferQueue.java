package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class CoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ArrayDeque<Object> bufAndListenerPairs;
    private final Channel channel;
    private int readableBytes;

    public CoalescingBufferQueue(Channel channel) {
        this(channel, 4);
    }

    private ByteBuf compose(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == null) {
            return byteBuf2;
        }
        if (byteBuf instanceof CompositeByteBuf) {
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            compositeByteBuf.addComponent(true, byteBuf2);
            return compositeByteBuf;
        }
        CompositeByteBuf compositeBuffer = this.channel.alloc().compositeBuffer(this.bufAndListenerPairs.size() + 2);
        compositeBuffer.addComponent(true, byteBuf);
        compositeBuffer.addComponent(true, byteBuf2);
        return compositeBuffer;
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        this.readableBytes = 0;
        Throwable th = null;
        while (true) {
            Object poll = this.bufAndListenerPairs.poll();
            if (poll == null) {
                break;
            }
            try {
                if (poll instanceof ByteBuf) {
                    ReferenceCountUtil.safeRelease(poll);
                } else {
                    ((ChannelFutureListener) poll).operationComplete(channelFuture);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    public void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public void copyTo(CoalescingBufferQueue coalescingBufferQueue) {
        coalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        coalescingBufferQueue.readableBytes += this.readableBytes;
    }

    public boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public int readableBytes() {
        return this.readableBytes;
    }

    public void releaseAndFailAll(Throwable th) {
        releaseAndCompleteAll(this.channel.newFailedFuture(th));
    }

    public ByteBuf remove(int i4, ChannelPromise channelPromise) {
        if (i4 >= 0) {
            ObjectUtil.checkNotNull(channelPromise, "aggregatePromise");
            if (this.bufAndListenerPairs.isEmpty()) {
                return Unpooled.EMPTY_BUFFER;
            }
            int min = Math.min(i4, this.readableBytes);
            ByteBuf byteBuf = null;
            int i5 = min;
            while (true) {
                Object poll = this.bufAndListenerPairs.poll();
                if (poll == null) {
                    break;
                } else if (poll instanceof ChannelFutureListener) {
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) ((ChannelFutureListener) poll));
                } else {
                    ByteBuf byteBuf2 = (ByteBuf) poll;
                    if (byteBuf2.readableBytes() > i5) {
                        this.bufAndListenerPairs.addFirst(byteBuf2);
                        if (i5 > 0) {
                            byteBuf = compose(byteBuf, byteBuf2.readRetainedSlice(i5));
                            i5 = 0;
                        }
                    } else {
                        byteBuf = compose(byteBuf, byteBuf2);
                        i5 -= byteBuf2.readableBytes();
                    }
                }
            }
            this.readableBytes -= min - i5;
            return byteBuf;
        }
        throw new IllegalArgumentException("bytes (expected >= 0): " + i4);
    }

    public CoalescingBufferQueue(Channel channel, int i4) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
        this.bufAndListenerPairs = new ArrayDeque<>(i4);
    }

    public void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        add(byteBuf, channelPromise.isVoid() ? null : new ChannelPromiseNotifier(channelPromise));
    }

    public void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        ObjectUtil.checkNotNull(byteBuf, "buf");
        if (this.readableBytes <= Integer.MAX_VALUE - byteBuf.readableBytes()) {
            this.bufAndListenerPairs.add(byteBuf);
            if (channelFutureListener != null) {
                this.bufAndListenerPairs.add(channelFutureListener);
            }
            this.readableBytes += byteBuf.readableBytes();
            return;
        }
        throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + byteBuf.readableBytes());
    }
}

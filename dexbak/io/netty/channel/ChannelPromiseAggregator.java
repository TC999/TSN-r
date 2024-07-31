package io.netty.channel;

import io.netty.util.concurrent.PromiseAggregator;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ChannelPromiseAggregator extends PromiseAggregator<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseAggregator(ChannelPromise channelPromise) {
        super(channelPromise);
    }
}

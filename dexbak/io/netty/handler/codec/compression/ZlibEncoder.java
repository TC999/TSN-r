package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class ZlibEncoder extends MessageToByteEncoder<ByteBuf> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ZlibEncoder() {
        super(false);
    }

    public abstract ChannelFuture close();

    public abstract ChannelFuture close(ChannelPromise channelPromise);

    public abstract boolean isClosed();
}

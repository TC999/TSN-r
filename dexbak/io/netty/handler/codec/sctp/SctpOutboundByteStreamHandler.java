package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SctpOutboundByteStreamHandler extends MessageToMessageEncoder<ByteBuf> {
    private final int protocolIdentifier;
    private final int streamIdentifier;
    private final boolean unordered;

    public SctpOutboundByteStreamHandler(int i, int i2) {
        this(i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public SctpOutboundByteStreamHandler(int i, int i2, boolean z) {
        this.streamIdentifier = i;
        this.protocolIdentifier = i2;
        this.unordered = z;
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(new SctpMessage(this.streamIdentifier, this.protocolIdentifier, this.unordered, byteBuf.retain()));
    }
}

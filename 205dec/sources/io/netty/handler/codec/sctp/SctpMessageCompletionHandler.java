package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SctpMessageCompletionHandler extends MessageToMessageDecoder<SctpMessage> {
    private final Map<Integer, ByteBuf> fragments = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List list) throws Exception {
        decode2(channelHandlerContext, sctpMessage, (List<Object>) list);
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List<Object> list) throws Exception {
        ByteBuf byteBuf;
        ByteBuf content = sctpMessage.content();
        int protocolIdentifier = sctpMessage.protocolIdentifier();
        int streamIdentifier = sctpMessage.streamIdentifier();
        boolean isComplete = sctpMessage.isComplete();
        boolean isUnordered = sctpMessage.isUnordered();
        if (this.fragments.containsKey(Integer.valueOf(streamIdentifier))) {
            byteBuf = this.fragments.remove(Integer.valueOf(streamIdentifier));
        } else {
            byteBuf = Unpooled.EMPTY_BUFFER;
        }
        if (isComplete && !byteBuf.isReadable()) {
            list.add(sctpMessage);
        } else if (!isComplete && byteBuf.isReadable()) {
            this.fragments.put(Integer.valueOf(streamIdentifier), Unpooled.wrappedBuffer(byteBuf, content));
        } else if (isComplete && byteBuf.isReadable()) {
            this.fragments.remove(Integer.valueOf(streamIdentifier));
            list.add(new SctpMessage(protocolIdentifier, streamIdentifier, isUnordered, Unpooled.wrappedBuffer(byteBuf, content)));
        } else {
            this.fragments.put(Integer.valueOf(streamIdentifier), content);
        }
        content.retain();
    }
}

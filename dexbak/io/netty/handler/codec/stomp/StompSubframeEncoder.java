package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.AsciiHeadersEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StompSubframeEncoder extends MessageToMessageEncoder<StompSubframe> {
    private static ByteBuf encodeContent(StompContentSubframe stompContentSubframe, ChannelHandlerContext channelHandlerContext) {
        if (stompContentSubframe instanceof LastStompContentSubframe) {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(stompContentSubframe.content().readableBytes() + 1);
            buffer.writeBytes(stompContentSubframe.content());
            buffer.writeByte(0);
            return buffer;
        }
        return stompContentSubframe.content().retain();
    }

    private static ByteBuf encodeFrame(StompHeadersSubframe stompHeadersSubframe, ChannelHandlerContext channelHandlerContext) {
        ByteBuf buffer = channelHandlerContext.alloc().buffer();
        buffer.writeBytes(stompHeadersSubframe.command().toString().getBytes(CharsetUtil.US_ASCII));
        buffer.writeByte(10);
        AsciiHeadersEncoder asciiHeadersEncoder = new AsciiHeadersEncoder(buffer, AsciiHeadersEncoder.SeparatorType.COLON, AsciiHeadersEncoder.NewlineType.LF);
        for (Map.Entry<CharSequence, CharSequence> entry : stompHeadersSubframe.headers()) {
            asciiHeadersEncoder.encode(entry);
        }
        buffer.writeByte(10);
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, StompSubframe stompSubframe, List list) throws Exception {
        encode2(channelHandlerContext, stompSubframe, (List<Object>) list);
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, StompSubframe stompSubframe, List<Object> list) throws Exception {
        if (stompSubframe instanceof StompFrame) {
            StompFrame stompFrame = (StompFrame) stompSubframe;
            list.add(encodeFrame(stompFrame, channelHandlerContext));
            list.add(encodeContent(stompFrame, channelHandlerContext));
        } else if (stompSubframe instanceof StompHeadersSubframe) {
            list.add(encodeFrame((StompHeadersSubframe) stompSubframe, channelHandlerContext));
        } else if (stompSubframe instanceof StompContentSubframe) {
            list.add(encodeContent((StompContentSubframe) stompSubframe, channelHandlerContext));
        }
    }
}

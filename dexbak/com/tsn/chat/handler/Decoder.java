package com.tsn.chat.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* renamed from: com.tsn.chat.handler.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Decoder extends ByteToMessageDecoder {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        byteBuf.markReaderIndex();
        byteBuf.readByte();
        short readShort = byteBuf.readShort();
        byteBuf.resetReaderIndex();
        if (readableBytes < readShort) {
            return;
        }
        list.add(byteBuf.readBytes(readShort));
    }
}

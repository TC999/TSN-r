package com.tsn.chat.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Decoder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends ByteToMessageDecoder {
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

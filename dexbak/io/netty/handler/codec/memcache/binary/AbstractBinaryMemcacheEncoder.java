package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder;
import io.netty.handler.codec.memcache.MemcacheMessage;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractBinaryMemcacheEncoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectEncoder<M> {
    private static final int MINIMUM_HEADER_SIZE = 24;

    private static void encodeExtras(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 == null || !byteBuf2.isReadable()) {
            return;
        }
        byteBuf.writeBytes(byteBuf2);
    }

    private static void encodeKey(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 == null || !byteBuf2.isReadable()) {
            return;
        }
        byteBuf.writeBytes(byteBuf2);
    }

    protected abstract void encodeHeader(ByteBuf byteBuf, M m);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder
    protected /* bridge */ /* synthetic */ ByteBuf encodeMessage(ChannelHandlerContext channelHandlerContext, MemcacheMessage memcacheMessage) {
        return encodeMessage(channelHandlerContext, (ChannelHandlerContext) ((BinaryMemcacheMessage) memcacheMessage));
    }

    protected ByteBuf encodeMessage(ChannelHandlerContext channelHandlerContext, M m) {
        ByteBuf buffer = channelHandlerContext.alloc().buffer(m.extrasLength() + BinaryMemcacheOpcodes.FLUSHQ + m.keyLength());
        encodeHeader(buffer, m);
        encodeExtras(buffer, m.extras());
        encodeKey(buffer, m.key());
        return buffer;
    }
}

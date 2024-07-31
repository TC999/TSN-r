package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.memcache.MemcacheMessage;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractMemcacheObjectEncoder<M extends MemcacheMessage> extends MessageToMessageEncoder<Object> {
    private boolean expectingMoreContent;

    private static int contentLength(Object obj) {
        if (obj instanceof MemcacheContent) {
            return ((MemcacheContent) obj).content().readableBytes();
        }
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return (int) ((FileRegion) obj).count();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    private static Object encodeAndRetain(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).retain();
        }
        if (obj instanceof MemcacheContent) {
            return ((MemcacheContent) obj).content().retain();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).retain();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof MemcacheObject) || (obj instanceof ByteBuf) || (obj instanceof FileRegion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        if (obj instanceof MemcacheMessage) {
            if (!this.expectingMoreContent) {
                list.add(encodeMessage(channelHandlerContext, (MemcacheMessage) obj));
            } else {
                throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
            }
        }
        if ((obj instanceof MemcacheContent) || (obj instanceof ByteBuf) || (obj instanceof FileRegion)) {
            if (contentLength(obj) > 0) {
                list.add(encodeAndRetain(obj));
            } else {
                list.add(Unpooled.EMPTY_BUFFER);
            }
            this.expectingMoreContent = !(obj instanceof LastMemcacheContent);
        }
    }

    protected abstract ByteBuf encodeMessage(ChannelHandlerContext channelHandlerContext, M m);
}

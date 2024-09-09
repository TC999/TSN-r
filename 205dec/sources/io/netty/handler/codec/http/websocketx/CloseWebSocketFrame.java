package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.EmptyArrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CloseWebSocketFrame extends WebSocketFrame {
    public CloseWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    private static ByteBuf newBinaryData(int i4, String str) {
        byte[] bArr = EmptyArrays.EMPTY_BYTES;
        if (str != null) {
            bArr = str.getBytes(CharsetUtil.UTF_8);
        }
        ByteBuf buffer = Unpooled.buffer(bArr.length + 2);
        buffer.writeShort(i4);
        if (bArr.length > 0) {
            buffer.writeBytes(bArr);
        }
        buffer.readerIndex(0);
        return buffer;
    }

    public String reasonText() {
        ByteBuf content = content();
        if (content == null || content.capacity() <= 2) {
            return "";
        }
        content.readerIndex(2);
        String byteBuf = content.toString(CharsetUtil.UTF_8);
        content.readerIndex(0);
        return byteBuf;
    }

    public int statusCode() {
        ByteBuf content = content();
        if (content == null || content.capacity() == 0) {
            return -1;
        }
        content.readerIndex(0);
        short readShort = content.readShort();
        content.readerIndex(0);
        return readShort;
    }

    public CloseWebSocketFrame(int i4, String str) {
        this(true, 0, i4, str);
    }

    public CloseWebSocketFrame(boolean z3, int i4) {
        this(z3, i4, Unpooled.buffer(0));
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame copy() {
        return (CloseWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame duplicate() {
        return (CloseWebSocketFrame) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame replace(ByteBuf byteBuf) {
        return new CloseWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame retainedDuplicate() {
        return (CloseWebSocketFrame) super.retainedDuplicate();
    }

    public CloseWebSocketFrame(boolean z3, int i4, int i5, String str) {
        super(z3, i4, newBinaryData(i5, str));
    }

    public CloseWebSocketFrame(boolean z3, int i4, ByteBuf byteBuf) {
        super(z3, i4, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}

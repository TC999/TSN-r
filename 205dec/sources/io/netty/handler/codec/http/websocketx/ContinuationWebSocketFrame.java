package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ContinuationWebSocketFrame extends WebSocketFrame {
    public ContinuationWebSocketFrame() {
        this(Unpooled.buffer(0));
    }

    private static ByteBuf fromText(String str) {
        if (str != null && !str.isEmpty()) {
            return Unpooled.copiedBuffer(str, CharsetUtil.UTF_8);
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public String text() {
        return content().toString(CharsetUtil.UTF_8);
    }

    public ContinuationWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public ContinuationWebSocketFrame(boolean z3, int i4, ByteBuf byteBuf) {
        super(z3, i4, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame copy() {
        return (ContinuationWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame duplicate() {
        return (ContinuationWebSocketFrame) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame replace(ByteBuf byteBuf) {
        return new ContinuationWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ContinuationWebSocketFrame retainedDuplicate() {
        return (ContinuationWebSocketFrame) super.retainedDuplicate();
    }

    public ContinuationWebSocketFrame(boolean z3, int i4, String str) {
        this(z3, i4, fromText(str));
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public ContinuationWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}

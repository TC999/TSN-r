package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class WebSocketFrame extends DefaultByteBufHolder {
    private final boolean finalFragment;
    private final int rsv;

    /* JADX INFO: Access modifiers changed from: protected */
    public WebSocketFrame(ByteBuf byteBuf) {
        this(true, 0, byteBuf);
    }

    public boolean isFinalFragment() {
        return this.finalFragment;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public abstract WebSocketFrame replace(ByteBuf byteBuf);

    public int rsv() {
        return this.rsv;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(data: " + contentToString() + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebSocketFrame(boolean z3, int i4, ByteBuf byteBuf) {
        super(byteBuf);
        this.finalFragment = z3;
        this.rsv = i4;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public WebSocketFrame copy() {
        return (WebSocketFrame) super.copy();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public WebSocketFrame duplicate() {
        return (WebSocketFrame) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public WebSocketFrame retainedDuplicate() {
        return (WebSocketFrame) super.retainedDuplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public WebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}

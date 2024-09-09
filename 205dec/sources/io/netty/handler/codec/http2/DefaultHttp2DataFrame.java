package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DefaultHttp2DataFrame extends AbstractHttp2StreamFrame implements Http2DataFrame {
    private final ByteBuf content;
    private final boolean endStream;
    private final int padding;

    public DefaultHttp2DataFrame(ByteBuf byteBuf) {
        this(byteBuf, false);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        if (this.content.refCnt() > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(this.content.refCnt());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2DataFrame) {
            DefaultHttp2DataFrame defaultHttp2DataFrame = (DefaultHttp2DataFrame) obj;
            return super.equals(defaultHttp2DataFrame) && this.content.equals(defaultHttp2DataFrame.content()) && this.endStream == defaultHttp2DataFrame.endStream && this.padding == defaultHttp2DataFrame.padding;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.content.hashCode()) * 31) + (!this.endStream ? 1 : 0)) * 31) + this.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public boolean isEndStream() {
        return this.endStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "DATA";
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public int padding() {
        return this.padding;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        return "DefaultHttp2DataFrame(streamId=" + streamId() + ", content=" + this.content + ", endStream=" + this.endStream + ", padding=" + this.padding + ")";
    }

    public DefaultHttp2DataFrame(boolean z3) {
        this(Unpooled.EMPTY_BUFFER, z3);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        return this.content.release(i4);
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z3) {
        this(byteBuf, z3, 0);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2DataFrame(byteBuf, this.endStream, this.padding);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2DataFrame setStreamId(int i4) {
        super.setStreamId(i4);
        return this;
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z3, int i4) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.endStream = z3;
        Http2CodecUtil.verifyPadding(i4);
        this.padding = i4;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame retain(int i4) {
        this.content.retain(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}

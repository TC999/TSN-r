package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DefaultHttp2GoAwayFrame extends DefaultByteBufHolder implements Http2GoAwayFrame {
    private final long errorCode;
    private int extraStreamIds;
    private int lastStreamId;

    public DefaultHttp2GoAwayFrame(Http2Error http2Error) {
        this(http2Error.code());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2GoAwayFrame) {
            DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = (DefaultHttp2GoAwayFrame) obj;
            return super.equals(obj) && this.errorCode == defaultHttp2GoAwayFrame.errorCode && content().equals(defaultHttp2GoAwayFrame.content()) && this.extraStreamIds == defaultHttp2GoAwayFrame.extraStreamIds;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public int extraStreamIds() {
        return this.extraStreamIds;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        long j4 = this.errorCode;
        return (((((-1230679765) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + content().hashCode()) * 31) + this.extraStreamIds;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public int lastStreamId() {
        return this.lastStreamId;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "GOAWAY";
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public Http2GoAwayFrame setExtraStreamIds(int i4) {
        if (i4 >= 0) {
            this.extraStreamIds = i4;
            return this;
        }
        throw new IllegalArgumentException("extraStreamIds must be non-negative");
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return "DefaultHttp2GoAwayFrame(errorCode=" + this.errorCode + ", content=" + content() + ", extraStreamIds=" + this.extraStreamIds + ", lastStreamId=" + this.lastStreamId + ")";
    }

    public DefaultHttp2GoAwayFrame(long j4) {
        this(j4, Unpooled.EMPTY_BUFFER);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame copy() {
        return new DefaultHttp2GoAwayFrame(this.lastStreamId, this.errorCode, content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame duplicate() {
        return (Http2GoAwayFrame) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2GoAwayFrame(this.errorCode, byteBuf).setExtraStreamIds(this.extraStreamIds);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame retainedDuplicate() {
        return (Http2GoAwayFrame) super.retainedDuplicate();
    }

    public DefaultHttp2GoAwayFrame(Http2Error http2Error, ByteBuf byteBuf) {
        this(http2Error.code(), byteBuf);
    }

    public DefaultHttp2GoAwayFrame(long j4, ByteBuf byteBuf) {
        this(-1, j4, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultHttp2GoAwayFrame(int i4, long j4, ByteBuf byteBuf) {
        super(byteBuf);
        this.errorCode = j4;
        this.lastStreamId = i4;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}

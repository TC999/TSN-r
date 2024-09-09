package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class DefaultHttp2UnknownFrame extends DefaultByteBufHolder implements Http2UnknownFrame {
    private final Http2Flags flags;
    private final byte frameType;
    private Http2FrameStream stream;

    public DefaultHttp2UnknownFrame(byte b4, Http2Flags http2Flags) {
        this(b4, http2Flags, Unpooled.EMPTY_BUFFER);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2UnknownFrame) {
            DefaultHttp2UnknownFrame defaultHttp2UnknownFrame = (DefaultHttp2UnknownFrame) obj;
            return (super.equals(defaultHttp2UnknownFrame) && flags().equals(defaultHttp2UnknownFrame.flags()) && frameType() == defaultHttp2UnknownFrame.frameType() && stream() == null && defaultHttp2UnknownFrame.stream() == null) || stream().equals(defaultHttp2UnknownFrame.stream());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame
    public Http2Flags flags() {
        return this.flags;
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame
    public byte frameType() {
        return this.frameType;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        int hashCode = (((super.hashCode() * 31) + frameType()) * 31) + flags().hashCode();
        return stream() != null ? (hashCode * 31) + stream().hashCode() : hashCode;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "UNKNOWN";
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(frameType=" + ((int) frameType()) + ", stream=" + stream() + ", flags=" + flags() + ", content=" + contentToString() + ')';
    }

    public DefaultHttp2UnknownFrame(byte b4, Http2Flags http2Flags, ByteBuf byteBuf) {
        super(byteBuf);
        this.frameType = b4;
        this.flags = http2Flags;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2UnknownFrame(this.frameType, this.flags, byteBuf).stream(stream());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public DefaultHttp2UnknownFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame
    public Http2FrameStream stream() {
        return this.stream;
    }

    @Override // io.netty.handler.codec.http2.Http2UnknownFrame
    public DefaultHttp2UnknownFrame stream(Http2FrameStream http2FrameStream) {
        this.stream = http2FrameStream;
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public DefaultHttp2UnknownFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}

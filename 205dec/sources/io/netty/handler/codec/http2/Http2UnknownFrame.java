package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface Http2UnknownFrame extends Http2StreamFrame, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    Http2UnknownFrame copy();

    @Override // io.netty.buffer.ByteBufHolder
    Http2UnknownFrame duplicate();

    Http2Flags flags();

    byte frameType();

    @Override // io.netty.buffer.ByteBufHolder
    Http2UnknownFrame replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2UnknownFrame retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2UnknownFrame retain(int i4);

    @Override // io.netty.buffer.ByteBufHolder
    Http2UnknownFrame retainedDuplicate();

    Http2FrameStream stream();

    Http2UnknownFrame stream(Http2FrameStream http2FrameStream);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2UnknownFrame touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    Http2UnknownFrame touch(Object obj);
}

package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2DataFrame extends Http2StreamFrame, ByteBufHolder {
    ByteBuf content();

    Http2DataFrame copy();

    Http2DataFrame duplicate();

    boolean isEndStream();

    int padding();

    Http2DataFrame replace(ByteBuf byteBuf);

    Http2DataFrame retain();

    Http2DataFrame retain(int i4);

    Http2DataFrame retainedDuplicate();

    Http2DataFrame touch();

    Http2DataFrame touch(Object obj);
}

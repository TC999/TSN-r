package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface FullHttpMessage extends HttpMessage, LastHttpContent {
    FullHttpMessage copy();

    FullHttpMessage duplicate();

    FullHttpMessage replace(ByteBuf byteBuf);

    FullHttpMessage retain();

    FullHttpMessage retain(int i4);

    FullHttpMessage retainedDuplicate();

    FullHttpMessage touch();

    FullHttpMessage touch(Object obj);
}

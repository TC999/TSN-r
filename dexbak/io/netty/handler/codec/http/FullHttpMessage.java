package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface FullHttpMessage extends HttpMessage, LastHttpContent {
    FullHttpMessage copy();

    FullHttpMessage duplicate();

    FullHttpMessage replace(ByteBuf byteBuf);

    FullHttpMessage retain();

    FullHttpMessage retain(int i);

    FullHttpMessage retainedDuplicate();

    FullHttpMessage touch();

    FullHttpMessage touch(Object obj);
}

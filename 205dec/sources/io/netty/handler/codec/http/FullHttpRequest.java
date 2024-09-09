package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface FullHttpRequest extends HttpRequest, FullHttpMessage {
    FullHttpRequest copy();

    FullHttpRequest duplicate();

    FullHttpRequest replace(ByteBuf byteBuf);

    FullHttpRequest retain();

    FullHttpRequest retain(int i4);

    FullHttpRequest retainedDuplicate();

    @Override // 
    FullHttpRequest setMethod(HttpMethod httpMethod);

    @Override // 
    FullHttpRequest setProtocolVersion(HttpVersion httpVersion);

    @Override // 
    FullHttpRequest setUri(String str);

    FullHttpRequest touch();

    FullHttpRequest touch(Object obj);
}

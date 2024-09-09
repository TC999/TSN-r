package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface FullHttpResponse extends HttpResponse, FullHttpMessage {
    FullHttpResponse copy();

    FullHttpResponse duplicate();

    FullHttpResponse replace(ByteBuf byteBuf);

    FullHttpResponse retain();

    FullHttpResponse retain(int i4);

    FullHttpResponse retainedDuplicate();

    @Override // io.netty.handler.codec.http.HttpResponse, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    FullHttpResponse setProtocolVersion(HttpVersion httpVersion);

    @Override // 
    FullHttpResponse setStatus(HttpResponseStatus httpResponseStatus);

    FullHttpResponse touch();

    FullHttpResponse touch(Object obj);
}

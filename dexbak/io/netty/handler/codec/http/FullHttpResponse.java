package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface FullHttpResponse extends HttpResponse, FullHttpMessage {
    FullHttpResponse copy();

    FullHttpResponse duplicate();

    FullHttpResponse replace(ByteBuf byteBuf);

    FullHttpResponse retain();

    FullHttpResponse retain(int i);

    FullHttpResponse retainedDuplicate();

    @Override // io.netty.handler.codec.http.HttpResponse, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    FullHttpResponse setProtocolVersion(HttpVersion httpVersion);

    @Override // 
    FullHttpResponse setStatus(HttpResponseStatus httpResponseStatus);

    FullHttpResponse touch();

    FullHttpResponse touch(Object obj);
}

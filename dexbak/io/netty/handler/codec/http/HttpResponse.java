package io.netty.handler.codec.http;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface HttpResponse extends HttpMessage {
    @Deprecated
    HttpResponseStatus getStatus();

    @Override // io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    HttpResponse setProtocolVersion(HttpVersion httpVersion);

    HttpResponse setStatus(HttpResponseStatus httpResponseStatus);

    HttpResponseStatus status();
}

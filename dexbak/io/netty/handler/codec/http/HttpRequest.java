package io.netty.handler.codec.http;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface HttpRequest extends HttpMessage {
    @Deprecated
    HttpMethod getMethod();

    @Deprecated
    String getUri();

    HttpMethod method();

    HttpRequest setMethod(HttpMethod httpMethod);

    @Override // io.netty.handler.codec.http.FullHttpRequest
    HttpRequest setProtocolVersion(HttpVersion httpVersion);

    HttpRequest setUri(String str);

    String uri();
}

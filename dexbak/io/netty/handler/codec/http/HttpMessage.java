package io.netty.handler.codec.http;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface HttpMessage extends HttpObject {
    @Deprecated
    HttpVersion getProtocolVersion();

    HttpHeaders headers();

    HttpVersion protocolVersion();

    HttpMessage setProtocolVersion(HttpVersion httpVersion);
}

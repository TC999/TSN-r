package io.netty.handler.codec.http2;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Http2StreamVisitor {
    boolean visit(Http2Stream http2Stream) throws Http2Exception;
}
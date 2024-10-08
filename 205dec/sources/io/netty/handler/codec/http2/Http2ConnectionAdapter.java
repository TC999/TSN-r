package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Connection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Http2ConnectionAdapter implements Http2Connection.Listener {
    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onGoAwayReceived(int i4, long j4, ByteBuf byteBuf) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onGoAwaySent(int i4, long j4, ByteBuf byteBuf) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onPriorityTreeParentChanged(Http2Stream http2Stream, Http2Stream http2Stream2) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onPriorityTreeParentChanging(Http2Stream http2Stream, Http2Stream http2Stream2) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamActive(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamAdded(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamClosed(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamHalfClosed(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamRemoved(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onWeightChanged(Http2Stream http2Stream, short s3) {
    }
}

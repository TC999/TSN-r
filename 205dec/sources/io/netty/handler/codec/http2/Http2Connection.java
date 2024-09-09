package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2Connection {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Endpoint<F extends Http2FlowController> {
        void allowPushTo(boolean z3);

        boolean allowPushTo();

        boolean canOpenStream();

        Http2Stream createIdleStream(int i4) throws Http2Exception;

        Http2Stream createStream(int i4, boolean z3) throws Http2Exception;

        boolean created(Http2Stream http2Stream);

        F flowController();

        void flowController(F f4);

        int incrementAndGetNextStreamId();

        boolean isServer();

        boolean isValidStreamId(int i4);

        int lastStreamCreated();

        int lastStreamKnownByPeer();

        int maxActiveStreams();

        int maxStreams();

        void maxStreams(int i4, int i5) throws Http2Exception;

        boolean mayHaveCreatedStream(int i4);

        int numActiveStreams();

        Endpoint<? extends Http2FlowController> opposite();

        Http2Stream reservePushStream(int i4, Http2Stream http2Stream) throws Http2Exception;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Listener {
        void onGoAwayReceived(int i4, long j4, ByteBuf byteBuf);

        void onGoAwaySent(int i4, long j4, ByteBuf byteBuf);

        void onPriorityTreeParentChanged(Http2Stream http2Stream, Http2Stream http2Stream2);

        void onPriorityTreeParentChanging(Http2Stream http2Stream, Http2Stream http2Stream2);

        void onStreamActive(Http2Stream http2Stream);

        void onStreamAdded(Http2Stream http2Stream);

        void onStreamClosed(Http2Stream http2Stream);

        void onStreamHalfClosed(Http2Stream http2Stream);

        void onStreamRemoved(Http2Stream http2Stream);

        void onWeightChanged(Http2Stream http2Stream, short s3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface PropertyKey {
    }

    void addListener(Listener listener);

    Future<Void> close(Promise<Void> promise);

    Http2Stream connectionStream();

    Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception;

    void goAwayReceived(int i4, long j4, ByteBuf byteBuf);

    boolean goAwayReceived();

    void goAwaySent(int i4, long j4, ByteBuf byteBuf);

    boolean goAwaySent();

    boolean isServer();

    Endpoint<Http2LocalFlowController> local();

    PropertyKey newKey();

    int numActiveStreams();

    Endpoint<Http2RemoteFlowController> remote();

    void removeListener(Listener listener);

    Http2Stream stream(int i4);

    boolean streamMayHaveExisted(int i4);
}

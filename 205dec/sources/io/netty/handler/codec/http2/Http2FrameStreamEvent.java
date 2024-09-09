package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class Http2FrameStreamEvent {
    private final Http2FrameStream stream;
    private final Type type;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    enum Type {
        State,
        Writability
    }

    private Http2FrameStreamEvent(Http2FrameStream http2FrameStream, Type type) {
        this.stream = http2FrameStream;
        this.type = type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Http2FrameStreamEvent stateChanged(Http2FrameStream http2FrameStream) {
        return new Http2FrameStreamEvent(http2FrameStream, Type.State);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Http2FrameStreamEvent writabilityChanged(Http2FrameStream http2FrameStream) {
        return new Http2FrameStreamEvent(http2FrameStream, Type.Writability);
    }

    public Http2FrameStream stream() {
        return this.stream;
    }

    public Type type() {
        return this.type;
    }
}

package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Http2Stream {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum State {
        IDLE(false, false),
        RESERVED_LOCAL(false, false),
        RESERVED_REMOTE(false, false),
        OPEN(true, true),
        HALF_CLOSED_LOCAL(false, true),
        HALF_CLOSED_REMOTE(true, false),
        CLOSED(false, false);
        
        private final boolean localSideOpen;
        private final boolean remoteSideOpen;

        State(boolean z3, boolean z4) {
            this.localSideOpen = z3;
            this.remoteSideOpen = z4;
        }

        public boolean localSideOpen() {
            return this.localSideOpen;
        }

        public boolean remoteSideOpen() {
            return this.remoteSideOpen;
        }
    }

    Http2Stream close();

    Http2Stream closeLocalSide();

    Http2Stream closeRemoteSide();

    Http2Stream forEachChild(Http2StreamVisitor http2StreamVisitor) throws Http2Exception;

    <V> V getProperty(Http2Connection.PropertyKey propertyKey);

    int id();

    boolean isDescendantOf(Http2Stream http2Stream);

    boolean isLeaf();

    boolean isResetSent();

    boolean isRoot();

    int numChildren();

    Http2Stream open(boolean z3) throws Http2Exception;

    Http2Stream parent();

    <V> V removeProperty(Http2Connection.PropertyKey propertyKey);

    Http2Stream resetSent();

    Http2Stream setPriority(int i4, short s3, boolean z3) throws Http2Exception;

    <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v3);

    State state();

    short weight();
}

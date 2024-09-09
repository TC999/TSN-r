package io.netty.handler.codec.spdy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SpdyVersion {
    SPDY_3_1(3, 1);
    
    private final int minorVersion;
    private final int version;

    SpdyVersion(int i4, int i5) {
        this.version = i4;
        this.minorVersion = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinorVersion() {
        return this.minorVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersion() {
        return this.version;
    }
}

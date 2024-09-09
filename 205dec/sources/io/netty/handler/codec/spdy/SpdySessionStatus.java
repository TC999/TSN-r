package io.netty.handler.codec.spdy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdySessionStatus implements Comparable<SpdySessionStatus> {
    private final int code;
    private final String statusPhrase;
    public static final SpdySessionStatus OK = new SpdySessionStatus(0, "OK");
    public static final SpdySessionStatus PROTOCOL_ERROR = new SpdySessionStatus(1, "PROTOCOL_ERROR");
    public static final SpdySessionStatus INTERNAL_ERROR = new SpdySessionStatus(2, "INTERNAL_ERROR");

    public SpdySessionStatus(int i4, String str) {
        if (str != null) {
            this.code = i4;
            this.statusPhrase = str;
            return;
        }
        throw new NullPointerException("statusPhrase");
    }

    public static SpdySessionStatus valueOf(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return new SpdySessionStatus(i4, "UNKNOWN (" + i4 + ')');
                }
                return INTERNAL_ERROR;
            }
            return PROTOCOL_ERROR;
        }
        return OK;
    }

    public int code() {
        return this.code;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SpdySessionStatus) && code() == ((SpdySessionStatus) obj).code();
    }

    public int hashCode() {
        return code();
    }

    public String statusPhrase() {
        return this.statusPhrase;
    }

    public String toString() {
        return statusPhrase();
    }

    @Override // java.lang.Comparable
    public int compareTo(SpdySessionStatus spdySessionStatus) {
        return code() - spdySessionStatus.code();
    }
}

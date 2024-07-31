package io.netty.handler.codec.spdy;

import com.baidu.mobads.sdk.internal.C2640by;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SpdySessionStatus implements Comparable<SpdySessionStatus> {
    private final int code;
    private final String statusPhrase;

    /* renamed from: OK */
    public static final SpdySessionStatus f40268OK = new SpdySessionStatus(0, C2640by.f8773k);
    public static final SpdySessionStatus PROTOCOL_ERROR = new SpdySessionStatus(1, "PROTOCOL_ERROR");
    public static final SpdySessionStatus INTERNAL_ERROR = new SpdySessionStatus(2, "INTERNAL_ERROR");

    public SpdySessionStatus(int i, String str) {
        if (str != null) {
            this.code = i;
            this.statusPhrase = str;
            return;
        }
        throw new NullPointerException("statusPhrase");
    }

    public static SpdySessionStatus valueOf(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return new SpdySessionStatus(i, "UNKNOWN (" + i + ')');
                }
                return INTERNAL_ERROR;
            }
            return PROTOCOL_ERROR;
        }
        return f40268OK;
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

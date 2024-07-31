package io.netty.handler.codec.spdy;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SpdyStreamStatus implements Comparable<SpdyStreamStatus> {
    private final int code;
    private final String statusPhrase;
    public static final SpdyStreamStatus PROTOCOL_ERROR = new SpdyStreamStatus(1, "PROTOCOL_ERROR");
    public static final SpdyStreamStatus INVALID_STREAM = new SpdyStreamStatus(2, "INVALID_STREAM");
    public static final SpdyStreamStatus REFUSED_STREAM = new SpdyStreamStatus(3, "REFUSED_STREAM");
    public static final SpdyStreamStatus UNSUPPORTED_VERSION = new SpdyStreamStatus(4, "UNSUPPORTED_VERSION");
    public static final SpdyStreamStatus CANCEL = new SpdyStreamStatus(5, "CANCEL");
    public static final SpdyStreamStatus INTERNAL_ERROR = new SpdyStreamStatus(6, "INTERNAL_ERROR");
    public static final SpdyStreamStatus FLOW_CONTROL_ERROR = new SpdyStreamStatus(7, "FLOW_CONTROL_ERROR");
    public static final SpdyStreamStatus STREAM_IN_USE = new SpdyStreamStatus(8, "STREAM_IN_USE");
    public static final SpdyStreamStatus STREAM_ALREADY_CLOSED = new SpdyStreamStatus(9, "STREAM_ALREADY_CLOSED");
    public static final SpdyStreamStatus INVALID_CREDENTIALS = new SpdyStreamStatus(10, "INVALID_CREDENTIALS");
    public static final SpdyStreamStatus FRAME_TOO_LARGE = new SpdyStreamStatus(11, "FRAME_TOO_LARGE");

    public SpdyStreamStatus(int i, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("0 is not a valid status code for a RST_STREAM");
        }
        if (str != null) {
            this.code = i;
            this.statusPhrase = str;
            return;
        }
        throw new NullPointerException("statusPhrase");
    }

    public static SpdyStreamStatus valueOf(int i) {
        if (i != 0) {
            switch (i) {
                case 1:
                    return PROTOCOL_ERROR;
                case 2:
                    return INVALID_STREAM;
                case 3:
                    return REFUSED_STREAM;
                case 4:
                    return UNSUPPORTED_VERSION;
                case 5:
                    return CANCEL;
                case 6:
                    return INTERNAL_ERROR;
                case 7:
                    return FLOW_CONTROL_ERROR;
                case 8:
                    return STREAM_IN_USE;
                case 9:
                    return STREAM_ALREADY_CLOSED;
                case 10:
                    return INVALID_CREDENTIALS;
                case 11:
                    return FRAME_TOO_LARGE;
                default:
                    return new SpdyStreamStatus(i, "UNKNOWN (" + i + ')');
            }
        }
        throw new IllegalArgumentException("0 is not a valid status code for a RST_STREAM");
    }

    public int code() {
        return this.code;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SpdyStreamStatus) && code() == ((SpdyStreamStatus) obj).code();
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
    public int compareTo(SpdyStreamStatus spdyStreamStatus) {
        return code() - spdyStreamStatus.code();
    }
}

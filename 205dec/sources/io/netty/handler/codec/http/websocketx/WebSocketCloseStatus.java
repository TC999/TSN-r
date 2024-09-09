package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class WebSocketCloseStatus implements Comparable<WebSocketCloseStatus> {
    private final String reasonText;
    private final int statusCode;
    private String text;
    public static final WebSocketCloseStatus NORMAL_CLOSURE = new WebSocketCloseStatus(1000, "Bye");
    public static final WebSocketCloseStatus ENDPOINT_UNAVAILABLE = new WebSocketCloseStatus(1001, "Endpoint unavailable");
    public static final WebSocketCloseStatus PROTOCOL_ERROR = new WebSocketCloseStatus(1002, "Protocol error");
    public static final WebSocketCloseStatus INVALID_MESSAGE_TYPE = new WebSocketCloseStatus(1003, "Invalid message type");
    public static final WebSocketCloseStatus INVALID_PAYLOAD_DATA = new WebSocketCloseStatus(1007, "Invalid payload data");
    public static final WebSocketCloseStatus POLICY_VIOLATION = new WebSocketCloseStatus(1008, "Policy violation");
    public static final WebSocketCloseStatus MESSAGE_TOO_BIG = new WebSocketCloseStatus(1009, "Message too big");
    public static final WebSocketCloseStatus MANDATORY_EXTENSION = new WebSocketCloseStatus(1010, "Mandatory extension");
    public static final WebSocketCloseStatus INTERNAL_SERVER_ERROR = new WebSocketCloseStatus(1011, "Internal server error");
    public static final WebSocketCloseStatus SERVICE_RESTART = new WebSocketCloseStatus(1012, "Service Restart");
    public static final WebSocketCloseStatus TRY_AGAIN_LATER = new WebSocketCloseStatus(1013, "Try Again Later");
    public static final WebSocketCloseStatus BAD_GATEWAY = new WebSocketCloseStatus(1014, "Bad Gateway");

    public WebSocketCloseStatus(int i4, String str) {
        if (isValidStatusCode(i4)) {
            this.statusCode = i4;
            this.reasonText = (String) ObjectUtil.checkNotNull(str, "reasonText");
            return;
        }
        throw new IllegalArgumentException("WebSocket close status code does NOT comply with RFC-6455: " + i4);
    }

    public static boolean isValidStatusCode(int i4) {
        return i4 < 0 || (1000 <= i4 && i4 <= 1003) || ((1007 <= i4 && i4 <= 1014) || 3000 <= i4);
    }

    public static WebSocketCloseStatus valueOf(int i4) {
        switch (i4) {
            case 1000:
                return NORMAL_CLOSURE;
            case 1001:
                return ENDPOINT_UNAVAILABLE;
            case 1002:
                return PROTOCOL_ERROR;
            case 1003:
                return INVALID_MESSAGE_TYPE;
            case 1004:
            case 1005:
            case 1006:
            default:
                return new WebSocketCloseStatus(i4, "Close status #" + i4);
            case 1007:
                return INVALID_PAYLOAD_DATA;
            case 1008:
                return POLICY_VIOLATION;
            case 1009:
                return MESSAGE_TOO_BIG;
            case 1010:
                return MANDATORY_EXTENSION;
            case 1011:
                return INTERNAL_SERVER_ERROR;
            case 1012:
                return SERVICE_RESTART;
            case 1013:
                return TRY_AGAIN_LATER;
            case 1014:
                return BAD_GATEWAY;
        }
    }

    public int code() {
        return this.statusCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && WebSocketCloseStatus.class == obj.getClass() && this.statusCode == ((WebSocketCloseStatus) obj).statusCode;
    }

    public int hashCode() {
        return this.statusCode;
    }

    public String reasonText() {
        return this.reasonText;
    }

    public String toString() {
        String str = this.text;
        if (str == null) {
            String str2 = code() + " " + reasonText();
            this.text = str2;
            return str2;
        }
        return str;
    }

    @Override // java.lang.Comparable
    public int compareTo(WebSocketCloseStatus webSocketCloseStatus) {
        return code() - webSocketCloseStatus.code();
    }
}

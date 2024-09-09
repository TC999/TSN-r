package io.netty.handler.codec.http;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    private final byte[] bytes;
    private final int code;
    private final AsciiString codeAsText;
    private HttpStatusClass codeClass;
    private final String reasonPhrase;
    public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
    public static final HttpResponseStatus PROCESSING = newStatus(102, "Processing");
    public static final HttpResponseStatus OK = newStatus(200, "OK");
    public static final HttpResponseStatus CREATED = newStatus(201, "Created");
    public static final HttpResponseStatus ACCEPTED = newStatus(202, "Accepted");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    public static final HttpResponseStatus NO_CONTENT = newStatus(204, "No Content");
    public static final HttpResponseStatus RESET_CONTENT = newStatus(205, "Reset Content");
    public static final HttpResponseStatus PARTIAL_CONTENT = newStatus(206, "Partial Content");
    public static final HttpResponseStatus MULTI_STATUS = newStatus(207, "Multi-Status");
    public static final HttpResponseStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");
    public static final HttpResponseStatus FOUND = newStatus(302, "Found");
    public static final HttpResponseStatus SEE_OTHER = newStatus(303, "See Other");
    public static final HttpResponseStatus NOT_MODIFIED = newStatus(304, "Not Modified");
    public static final HttpResponseStatus USE_PROXY = newStatus(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, "Use Proxy");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus BAD_REQUEST = newStatus(400, "Bad Request");
    public static final HttpResponseStatus UNAUTHORIZED = newStatus(401, "Unauthorized");
    public static final HttpResponseStatus PAYMENT_REQUIRED = newStatus(402, "Payment Required");
    public static final HttpResponseStatus FORBIDDEN = newStatus(403, "Forbidden");
    public static final HttpResponseStatus NOT_FOUND = newStatus(404, "Not Found");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUEST_TIMEOUT = newStatus(408, "Request Timeout");
    public static final HttpResponseStatus CONFLICT = newStatus(409, "Conflict");
    public static final HttpResponseStatus GONE = newStatus(410, "Gone");
    public static final HttpResponseStatus LENGTH_REQUIRED = newStatus(411, "Length Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = newStatus(412, "Precondition Failed");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = newStatus(413, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = newStatus(414, "Request-URI Too Long");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = newStatus(415, "Unsupported Media Type");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(416, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus EXPECTATION_FAILED = newStatus(417, "Expectation Failed");
    public static final HttpResponseStatus MISDIRECTED_REQUEST = newStatus(421, "Misdirected Request");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = newStatus(422, "Unprocessable Entity");
    public static final HttpResponseStatus LOCKED = newStatus(423, "Locked");
    public static final HttpResponseStatus FAILED_DEPENDENCY = newStatus(424, "Failed Dependency");
    public static final HttpResponseStatus UNORDERED_COLLECTION = newStatus(425, "Unordered Collection");
    public static final HttpResponseStatus UPGRADE_REQUIRED = newStatus(426, "Upgrade Required");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(431, "Request Header Fields Too Large");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");
    public static final HttpResponseStatus NOT_IMPLEMENTED = newStatus(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, "Not Implemented");
    public static final HttpResponseStatus BAD_GATEWAY = newStatus(502, "Bad Gateway");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = newStatus(503, "Service Unavailable");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = newStatus(504, "Gateway Timeout");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = newStatus(505, "HTTP Version Not Supported");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = newStatus(506, "Variant Also Negotiates");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = newStatus(507, "Insufficient Storage");
    public static final HttpResponseStatus NOT_EXTENDED = newStatus(510, "Not Extended");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(511, "Network Authentication Required");

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class HttpStatusLineProcessor implements ByteProcessor {
        private static final byte ASCII_SPACE = 32;

        /* renamed from: i  reason: collision with root package name */
        private int f54785i;
        private int state;
        private HttpResponseStatus status;
        private final AsciiString string;

        public HttpStatusLineProcessor(AsciiString asciiString) {
            this.string = asciiString;
        }

        private void parseStatus(int i4) {
            int parseInt = this.string.parseInt(0, i4);
            this.status = HttpResponseStatus.valueOf(parseInt);
            if (i4 < this.string.length()) {
                AsciiString asciiString = this.string;
                String asciiString2 = asciiString.toString(i4 + 1, asciiString.length());
                if (this.status.reasonPhrase().contentEquals(asciiString2)) {
                    return;
                }
                this.status = new HttpResponseStatus(parseInt, asciiString2);
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b4) {
            int i4 = this.state;
            if (i4 != 0) {
                if (i4 == 1) {
                    parseStatus(this.f54785i);
                    this.state = 2;
                    return false;
                }
            } else if (b4 == 32) {
                this.state = 1;
            }
            this.f54785i++;
            return true;
        }

        public HttpResponseStatus status() {
            if (this.state <= 1) {
                parseStatus(this.string.length());
                this.state = 3;
            }
            return this.status;
        }
    }

    private HttpResponseStatus(int i4) {
        this(i4, ((Object) HttpStatusClass.valueOf(i4).defaultReasonPhrase()) + " (" + i4 + ')', false);
    }

    private static HttpResponseStatus newStatus(int i4, String str) {
        return new HttpResponseStatus(i4, str, true);
    }

    public static HttpResponseStatus parseLine(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        try {
            int indexOf = charSequence2.indexOf(32);
            if (indexOf == -1) {
                return valueOf(Integer.parseInt(charSequence2));
            }
            int parseInt = Integer.parseInt(charSequence2.substring(0, indexOf));
            String substring = charSequence2.substring(indexOf + 1);
            HttpResponseStatus valueOf = valueOf(parseInt);
            return valueOf.reasonPhrase().contentEquals(substring) ? valueOf : new HttpResponseStatus(parseInt, substring);
        } catch (Exception e4) {
            throw new IllegalArgumentException("malformed status line: " + charSequence2, e4);
        }
    }

    public static HttpResponseStatus valueOf(int i4) {
        if (i4 != 307) {
            if (i4 != 431) {
                if (i4 != 428) {
                    if (i4 != 429) {
                        if (i4 != 510) {
                            if (i4 != 511) {
                                switch (i4) {
                                    case 100:
                                        return CONTINUE;
                                    case 101:
                                        return SWITCHING_PROTOCOLS;
                                    case 102:
                                        return PROCESSING;
                                    default:
                                        switch (i4) {
                                            case 200:
                                                return OK;
                                            case 201:
                                                return CREATED;
                                            case 202:
                                                return ACCEPTED;
                                            case 203:
                                                return NON_AUTHORITATIVE_INFORMATION;
                                            case 204:
                                                return NO_CONTENT;
                                            case 205:
                                                return RESET_CONTENT;
                                            case 206:
                                                return PARTIAL_CONTENT;
                                            case 207:
                                                return MULTI_STATUS;
                                            default:
                                                switch (i4) {
                                                    case 300:
                                                        return MULTIPLE_CHOICES;
                                                    case 301:
                                                        return MOVED_PERMANENTLY;
                                                    case 302:
                                                        return FOUND;
                                                    case 303:
                                                        return SEE_OTHER;
                                                    case 304:
                                                        return NOT_MODIFIED;
                                                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO /* 305 */:
                                                        return USE_PROXY;
                                                    default:
                                                        switch (i4) {
                                                            case 400:
                                                                return BAD_REQUEST;
                                                            case 401:
                                                                return UNAUTHORIZED;
                                                            case 402:
                                                                return PAYMENT_REQUIRED;
                                                            case 403:
                                                                return FORBIDDEN;
                                                            case 404:
                                                                return NOT_FOUND;
                                                            case 405:
                                                                return METHOD_NOT_ALLOWED;
                                                            case 406:
                                                                return NOT_ACCEPTABLE;
                                                            case 407:
                                                                return PROXY_AUTHENTICATION_REQUIRED;
                                                            case 408:
                                                                return REQUEST_TIMEOUT;
                                                            case 409:
                                                                return CONFLICT;
                                                            case 410:
                                                                return GONE;
                                                            case 411:
                                                                return LENGTH_REQUIRED;
                                                            case 412:
                                                                return PRECONDITION_FAILED;
                                                            case 413:
                                                                return REQUEST_ENTITY_TOO_LARGE;
                                                            case 414:
                                                                return REQUEST_URI_TOO_LONG;
                                                            case 415:
                                                                return UNSUPPORTED_MEDIA_TYPE;
                                                            case 416:
                                                                return REQUESTED_RANGE_NOT_SATISFIABLE;
                                                            case 417:
                                                                return EXPECTATION_FAILED;
                                                            default:
                                                                switch (i4) {
                                                                    case 421:
                                                                        return MISDIRECTED_REQUEST;
                                                                    case 422:
                                                                        return UNPROCESSABLE_ENTITY;
                                                                    case 423:
                                                                        return LOCKED;
                                                                    case 424:
                                                                        return FAILED_DEPENDENCY;
                                                                    case 425:
                                                                        return UNORDERED_COLLECTION;
                                                                    case 426:
                                                                        return UPGRADE_REQUIRED;
                                                                    default:
                                                                        switch (i4) {
                                                                            case 500:
                                                                                return INTERNAL_SERVER_ERROR;
                                                                            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE /* 501 */:
                                                                                return NOT_IMPLEMENTED;
                                                                            case 502:
                                                                                return BAD_GATEWAY;
                                                                            case 503:
                                                                                return SERVICE_UNAVAILABLE;
                                                                            case 504:
                                                                                return GATEWAY_TIMEOUT;
                                                                            case 505:
                                                                                return HTTP_VERSION_NOT_SUPPORTED;
                                                                            case 506:
                                                                                return VARIANT_ALSO_NEGOTIATES;
                                                                            case 507:
                                                                                return INSUFFICIENT_STORAGE;
                                                                            default:
                                                                                return new HttpResponseStatus(i4);
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return NETWORK_AUTHENTICATION_REQUIRED;
                        }
                        return NOT_EXTENDED;
                    }
                    return TOO_MANY_REQUESTS;
                }
                return PRECONDITION_REQUIRED;
            }
            return REQUEST_HEADER_FIELDS_TOO_LARGE;
        }
        return TEMPORARY_REDIRECT;
    }

    public int code() {
        return this.code;
    }

    public AsciiString codeAsText() {
        return this.codeAsText;
    }

    public HttpStatusClass codeClass() {
        HttpStatusClass httpStatusClass = this.codeClass;
        if (httpStatusClass == null) {
            HttpStatusClass valueOf = HttpStatusClass.valueOf(this.code);
            this.codeClass = valueOf;
            return valueOf;
        }
        return httpStatusClass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            HttpUtil.encodeAscii0(String.valueOf(code()), byteBuf);
            byteBuf.writeByte(32);
            HttpUtil.encodeAscii0(String.valueOf(reasonPhrase()), byteBuf);
            return;
        }
        byteBuf.writeBytes(bArr);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpResponseStatus) && code() == ((HttpResponseStatus) obj).code();
    }

    public int hashCode() {
        return code();
    }

    public String reasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.reasonPhrase.length() + 5);
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.reasonPhrase);
        return sb.toString();
    }

    public HttpResponseStatus(int i4, String str) {
        this(i4, str, false);
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return code() - httpResponseStatus.code();
    }

    private HttpResponseStatus(int i4, String str, boolean z3) {
        if (i4 < 0) {
            throw new IllegalArgumentException("code: " + i4 + " (expected: 0+)");
        } else if (str != null) {
            for (int i5 = 0; i5 < str.length(); i5++) {
                char charAt = str.charAt(i5);
                if (charAt == '\n' || charAt == '\r') {
                    throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: " + str);
                }
            }
            this.code = i4;
            this.codeAsText = new AsciiString(Integer.toString(i4));
            this.reasonPhrase = str;
            if (z3) {
                this.bytes = (i4 + " " + str).getBytes(CharsetUtil.US_ASCII);
                return;
            }
            this.bytes = null;
        } else {
            throw new NullPointerException("reasonPhrase");
        }
    }

    public static HttpResponseStatus parseLine(AsciiString asciiString) {
        try {
            HttpStatusLineProcessor httpStatusLineProcessor = new HttpStatusLineProcessor(asciiString);
            asciiString.forEachByte(httpStatusLineProcessor);
            HttpResponseStatus status = httpStatusLineProcessor.status();
            if (status != null) {
                return status;
            }
            throw new IllegalArgumentException("unable to get status after parsing input");
        } catch (Exception e4) {
            throw new IllegalArgumentException("malformed status line: " + ((Object) asciiString), e4);
        }
    }
}

package io.netty.handler.codec.http;

import androidx.core.app.FrameMetricsAggregator;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.baidu.mobads.sdk.internal.C2640by;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.p518qq.p519e.comm.adevent.AdEventType;
import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import okhttp3.internal.http.StatusLine;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    private final byte[] bytes;
    private final int code;
    private final AsciiString codeAsText;
    private HttpStatusClass codeClass;
    private final String reasonPhrase;
    public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
    public static final HttpResponseStatus PROCESSING = newStatus(102, "Processing");

    /* renamed from: OK */
    public static final HttpResponseStatus f40230OK = newStatus(200, C2640by.f8773k);
    public static final HttpResponseStatus CREATED = newStatus(201, "Created");
    public static final HttpResponseStatus ACCEPTED = newStatus(202, "Accepted");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    public static final HttpResponseStatus NO_CONTENT = newStatus(AdEventType.VIDEO_PAUSE, "No Content");
    public static final HttpResponseStatus RESET_CONTENT = newStatus(AdEventType.VIDEO_STOP, "Reset Content");
    public static final HttpResponseStatus PARTIAL_CONTENT = newStatus(AdEventType.VIDEO_COMPLETE, "Partial Content");
    public static final HttpResponseStatus MULTI_STATUS = newStatus(AdEventType.VIDEO_ERROR, "Multi-Status");
    public static final HttpResponseStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");
    public static final HttpResponseStatus FOUND = newStatus(302, "Found");
    public static final HttpResponseStatus SEE_OTHER = newStatus(303, "See Other");
    public static final HttpResponseStatus NOT_MODIFIED = newStatus(AdEventType.COMPLAIN_SUCCESS, "Not Modified");
    public static final HttpResponseStatus USE_PROXY = newStatus(305, "Use Proxy");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus BAD_REQUEST = newStatus(FontStyle.WEIGHT_NORMAL, "Bad Request");
    public static final HttpResponseStatus UNAUTHORIZED = newStatus(401, "Unauthorized");
    public static final HttpResponseStatus PAYMENT_REQUIRED = newStatus(402, "Payment Required");
    public static final HttpResponseStatus FORBIDDEN = newStatus(403, "Forbidden");
    public static final HttpResponseStatus NOT_FOUND = newStatus(404, "Not Found");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUEST_TIMEOUT = newStatus(TTAdConstant.INTERACTION_TYPE_CODE, "Request Timeout");
    public static final HttpResponseStatus CONFLICT = newStatus(TTAdConstant.IMAGE_LIST_CODE, "Conflict");
    public static final HttpResponseStatus GONE = newStatus(TTAdConstant.IMAGE_LIST_SIZE_CODE, "Gone");
    public static final HttpResponseStatus LENGTH_REQUIRED = newStatus(TTAdConstant.IMAGE_CODE, "Length Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = newStatus(TTAdConstant.IMAGE_URL_CODE, "Precondition Failed");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = newStatus(TTAdConstant.VIDEO_INFO_CODE, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = newStatus(TTAdConstant.VIDEO_URL_CODE, "Request-URI Too Long");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = newStatus(TTAdConstant.VIDEO_COVER_URL_CODE, "Unsupported Media Type");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(TTAdConstant.LIVE_AD_CODE, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus EXPECTATION_FAILED = newStatus(TTAdConstant.LIVE_FEED_URL_CODE, "Expectation Failed");
    public static final HttpResponseStatus MISDIRECTED_REQUEST = newStatus(StatusLine.HTTP_MISDIRECTED_REQUEST, "Misdirected Request");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = newStatus(422, "Unprocessable Entity");
    public static final HttpResponseStatus LOCKED = newStatus(423, "Locked");
    public static final HttpResponseStatus FAILED_DEPENDENCY = newStatus(424, "Failed Dependency");
    public static final HttpResponseStatus UNORDERED_COLLECTION = newStatus(425, "Unordered Collection");
    public static final HttpResponseStatus UPGRADE_REQUIRED = newStatus(426, "Upgrade Required");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(431, "Request Header Fields Too Large");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");
    public static final HttpResponseStatus NOT_IMPLEMENTED = newStatus(501, "Not Implemented");
    public static final HttpResponseStatus BAD_GATEWAY = newStatus(502, "Bad Gateway");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = newStatus(503, "Service Unavailable");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = newStatus(504, "Gateway Timeout");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = newStatus(505, "HTTP Version Not Supported");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = newStatus(506, "Variant Also Negotiates");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = newStatus(507, "Insufficient Storage");
    public static final HttpResponseStatus NOT_EXTENDED = newStatus(510, "Not Extended");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(FrameMetricsAggregator.EVERY_DURATION, "Network Authentication Required");

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class HttpStatusLineProcessor implements ByteProcessor {
        private static final byte ASCII_SPACE = 32;

        /* renamed from: i */
        private int f40231i;
        private int state;
        private HttpResponseStatus status;
        private final AsciiString string;

        public HttpStatusLineProcessor(AsciiString asciiString) {
            this.string = asciiString;
        }

        private void parseStatus(int i) {
            int parseInt = this.string.parseInt(0, i);
            this.status = HttpResponseStatus.valueOf(parseInt);
            if (i < this.string.length()) {
                AsciiString asciiString = this.string;
                String asciiString2 = asciiString.toString(i + 1, asciiString.length());
                if (this.status.reasonPhrase().contentEquals(asciiString2)) {
                    return;
                }
                this.status = new HttpResponseStatus(parseInt, asciiString2);
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            int i = this.state;
            if (i != 0) {
                if (i == 1) {
                    parseStatus(this.f40231i);
                    this.state = 2;
                    return false;
                }
            } else if (b == 32) {
                this.state = 1;
            }
            this.f40231i++;
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

    private HttpResponseStatus(int i) {
        this(i, ((Object) HttpStatusClass.valueOf(i).defaultReasonPhrase()) + " (" + i + ')', false);
    }

    private static HttpResponseStatus newStatus(int i, String str) {
        return new HttpResponseStatus(i, str, true);
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
        } catch (Exception e) {
            throw new IllegalArgumentException("malformed status line: " + charSequence2, e);
        }
    }

    public static HttpResponseStatus valueOf(int i) {
        if (i != 307) {
            if (i != 431) {
                if (i != 428) {
                    if (i != 429) {
                        if (i != 510) {
                            if (i != 511) {
                                switch (i) {
                                    case 100:
                                        return CONTINUE;
                                    case 101:
                                        return SWITCHING_PROTOCOLS;
                                    case 102:
                                        return PROCESSING;
                                    default:
                                        switch (i) {
                                            case 200:
                                                return f40230OK;
                                            case 201:
                                                return CREATED;
                                            case 202:
                                                return ACCEPTED;
                                            case 203:
                                                return NON_AUTHORITATIVE_INFORMATION;
                                            case AdEventType.VIDEO_PAUSE /* 204 */:
                                                return NO_CONTENT;
                                            case AdEventType.VIDEO_STOP /* 205 */:
                                                return RESET_CONTENT;
                                            case AdEventType.VIDEO_COMPLETE /* 206 */:
                                                return PARTIAL_CONTENT;
                                            case AdEventType.VIDEO_ERROR /* 207 */:
                                                return MULTI_STATUS;
                                            default:
                                                switch (i) {
                                                    case 300:
                                                        return MULTIPLE_CHOICES;
                                                    case 301:
                                                        return MOVED_PERMANENTLY;
                                                    case 302:
                                                        return FOUND;
                                                    case 303:
                                                        return SEE_OTHER;
                                                    case AdEventType.COMPLAIN_SUCCESS /* 304 */:
                                                        return NOT_MODIFIED;
                                                    case 305:
                                                        return USE_PROXY;
                                                    default:
                                                        switch (i) {
                                                            case FontStyle.WEIGHT_NORMAL /* 400 */:
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
                                                            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                                                return REQUEST_TIMEOUT;
                                                            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                                                return CONFLICT;
                                                            case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                                                return GONE;
                                                            case TTAdConstant.IMAGE_CODE /* 411 */:
                                                                return LENGTH_REQUIRED;
                                                            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                                                return PRECONDITION_FAILED;
                                                            case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                                                return REQUEST_ENTITY_TOO_LARGE;
                                                            case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                                                return REQUEST_URI_TOO_LONG;
                                                            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                                                return UNSUPPORTED_MEDIA_TYPE;
                                                            case TTAdConstant.LIVE_AD_CODE /* 416 */:
                                                                return REQUESTED_RANGE_NOT_SATISFIABLE;
                                                            case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                                                                return EXPECTATION_FAILED;
                                                            default:
                                                                switch (i) {
                                                                    case StatusLine.HTTP_MISDIRECTED_REQUEST /* 421 */:
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
                                                                        switch (i) {
                                                                            case 500:
                                                                                return INTERNAL_SERVER_ERROR;
                                                                            case 501:
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
                                                                                return new HttpResponseStatus(i);
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
        sb.append(HttpConstants.SP_CHAR);
        sb.append(this.reasonPhrase);
        return sb.toString();
    }

    public HttpResponseStatus(int i, String str) {
        this(i, str, false);
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return code() - httpResponseStatus.code();
    }

    private HttpResponseStatus(int i, String str, boolean z) {
        if (i < 0) {
            throw new IllegalArgumentException("code: " + i + " (expected: 0+)");
        } else if (str != null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\n' || charAt == '\r') {
                    throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: " + str);
                }
            }
            this.code = i;
            this.codeAsText = new AsciiString(Integer.toString(i));
            this.reasonPhrase = str;
            if (z) {
                this.bytes = (i + " " + str).getBytes(CharsetUtil.US_ASCII);
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
        } catch (Exception e) {
            throw new IllegalArgumentException("malformed status line: " + ((Object) asciiString), e);
        }
    }
}

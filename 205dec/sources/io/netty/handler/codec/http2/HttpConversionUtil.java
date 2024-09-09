package io.netty.handler.codec.http2;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HttpConversionUtil {
    private static final AsciiString EMPTY_REQUEST_PATH;
    private static final CharSequenceMap<AsciiString> HTTP_TO_HTTP2_HEADER_BLACKLIST;
    public static final HttpMethod OUT_OF_MESSAGE_SEQUENCE_METHOD;
    public static final String OUT_OF_MESSAGE_SEQUENCE_PATH = "";
    public static final HttpResponseStatus OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum ExtensionHeaderNames {
        STREAM_ID("x-http2-stream-id"),
        SCHEME("x-http2-scheme"),
        PATH("x-http2-path"),
        STREAM_PROMISE_ID("x-http2-stream-promise-id"),
        STREAM_DEPENDENCY_ID("x-http2-stream-dependency-id"),
        STREAM_WEIGHT("x-http2-stream-weight");
        
        private final AsciiString text;

        ExtensionHeaderNames(String str) {
            this.text = new AsciiString(str);
        }

        public AsciiString text() {
            return this.text;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Http2ToHttpHeaderTranslator {
        private static final CharSequenceMap<AsciiString> REQUEST_HEADER_TRANSLATIONS;
        private static final CharSequenceMap<AsciiString> RESPONSE_HEADER_TRANSLATIONS;
        private final HttpHeaders output;
        private final int streamId;
        private final CharSequenceMap<AsciiString> translations;

        static {
            CharSequenceMap<AsciiString> charSequenceMap = new CharSequenceMap<>();
            REQUEST_HEADER_TRANSLATIONS = charSequenceMap;
            CharSequenceMap<AsciiString> charSequenceMap2 = new CharSequenceMap<>();
            RESPONSE_HEADER_TRANSLATIONS = charSequenceMap2;
            charSequenceMap2.add((CharSequenceMap<AsciiString>) Http2Headers.PseudoHeaderName.AUTHORITY.value(), HttpHeaderNames.HOST);
            charSequenceMap2.add((CharSequenceMap<AsciiString>) Http2Headers.PseudoHeaderName.SCHEME.value(), ExtensionHeaderNames.SCHEME.text());
            charSequenceMap.add(charSequenceMap2);
            charSequenceMap2.add((CharSequenceMap<AsciiString>) Http2Headers.PseudoHeaderName.PATH.value(), ExtensionHeaderNames.PATH.text());
        }

        Http2ToHttpHeaderTranslator(int i4, HttpHeaders httpHeaders, boolean z3) {
            this.streamId = i4;
            this.output = httpHeaders;
            this.translations = z3 ? REQUEST_HEADER_TRANSLATIONS : RESPONSE_HEADER_TRANSLATIONS;
        }

        public void translate(Map.Entry<CharSequence, CharSequence> entry) throws Http2Exception {
            CharSequence key = entry.getKey();
            CharSequence value = entry.getValue();
            AsciiString asciiString = this.translations.get(key);
            if (asciiString != null) {
                this.output.add(asciiString, AsciiString.of(value));
            } else if (Http2Headers.PseudoHeaderName.isPseudoHeader(key)) {
            } else {
                if (key.length() == 0 || key.charAt(0) == ':') {
                    throw Http2Exception.streamError(this.streamId, Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 header '%s' encountered in translation to HTTP/1.x", key);
                }
                AsciiString asciiString2 = HttpHeaderNames.COOKIE;
                if (asciiString2.equals(key)) {
                    String str = this.output.get(asciiString2);
                    HttpHeaders httpHeaders = this.output;
                    if (str != null) {
                        value = str + "; " + ((Object) value);
                    }
                    httpHeaders.set(asciiString2, value);
                    return;
                }
                this.output.add(key, value);
            }
        }
    }

    static {
        CharSequenceMap<AsciiString> charSequenceMap = new CharSequenceMap<>();
        HTTP_TO_HTTP2_HEADER_BLACKLIST = charSequenceMap;
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        AsciiString asciiString2 = AsciiString.EMPTY_STRING;
        charSequenceMap.add((CharSequenceMap<AsciiString>) asciiString, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.KEEP_ALIVE, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.PROXY_CONNECTION, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.TRANSFER_ENCODING, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.HOST, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.UPGRADE, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) ExtensionHeaderNames.STREAM_ID.text(), asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) ExtensionHeaderNames.SCHEME.text(), asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) ExtensionHeaderNames.PATH.text(), asciiString2);
        OUT_OF_MESSAGE_SEQUENCE_METHOD = HttpMethod.OPTIONS;
        OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE = HttpResponseStatus.OK;
        EMPTY_REQUEST_PATH = new AsciiString(TTPathConst.sSeparator);
    }

    private HttpConversionUtil() {
    }

    public static void addHttp2ToHttpHeaders(int i4, Http2Headers http2Headers, FullHttpMessage fullHttpMessage, boolean z3) throws Http2Exception {
        addHttp2ToHttpHeaders(i4, http2Headers, z3 ? fullHttpMessage.trailingHeaders() : fullHttpMessage.headers(), fullHttpMessage.protocolVersion(), z3, fullHttpMessage instanceof HttpRequest);
    }

    public static HttpResponseStatus parseStatus(CharSequence charSequence) throws Http2Exception {
        try {
            HttpResponseStatus parseLine = HttpResponseStatus.parseLine(charSequence);
            if (parseLine != HttpResponseStatus.SWITCHING_PROTOCOLS) {
                return parseLine;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 status code '%d'", Integer.valueOf(parseLine.code()));
        } catch (Http2Exception e4) {
            throw e4;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, th, "Unrecognized HTTP status code '%s' encountered in translation to HTTP/1.x", charSequence);
        }
    }

    private static void setHttp2Authority(String str, Http2Headers http2Headers) {
        if (str != null) {
            int indexOf = str.indexOf(64);
            if (indexOf < 0) {
                http2Headers.authority(new AsciiString(str));
                return;
            }
            int i4 = indexOf + 1;
            if (i4 < str.length()) {
                http2Headers.authority(new AsciiString(str.substring(i4)));
                return;
            }
            throw new IllegalArgumentException("autority: " + str);
        }
    }

    private static void setHttp2Scheme(HttpHeaders httpHeaders, URI uri, Http2Headers http2Headers) {
        String scheme = uri.getScheme();
        if (scheme != null) {
            http2Headers.scheme(new AsciiString(scheme));
            return;
        }
        String str = httpHeaders.get(ExtensionHeaderNames.SCHEME.text());
        if (str != null) {
            http2Headers.scheme(AsciiString.of(str));
            return;
        }
        int port = uri.getPort();
        HttpScheme httpScheme = HttpScheme.HTTPS;
        if (port == httpScheme.port()) {
            http2Headers.scheme(httpScheme.name());
            return;
        }
        int port2 = uri.getPort();
        HttpScheme httpScheme2 = HttpScheme.HTTP;
        if (port2 == httpScheme2.port()) {
            http2Headers.scheme(httpScheme2.name());
            return;
        }
        throw new IllegalArgumentException(":scheme must be specified. see https://tools.ietf.org/html/rfc7540#section-8.1.2.3");
    }

    public static FullHttpRequest toFullHttpRequest(int i4, Http2Headers http2Headers, ByteBufAllocator byteBufAllocator, boolean z3) throws Http2Exception {
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.valueOf(((CharSequence) ObjectUtil.checkNotNull(http2Headers.method(), "method header cannot be null in conversion to HTTP/1.x")).toString()), ((CharSequence) ObjectUtil.checkNotNull(http2Headers.path(), "path header cannot be null in conversion to HTTP/1.x")).toString(), byteBufAllocator.buffer(), z3);
        try {
            addHttp2ToHttpHeaders(i4, http2Headers, defaultFullHttpRequest, false);
            return defaultFullHttpRequest;
        } catch (Http2Exception e4) {
            defaultFullHttpRequest.release();
            throw e4;
        } catch (Throwable th) {
            defaultFullHttpRequest.release();
            throw Http2Exception.streamError(i4, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static Http2Headers toHttp2Headers(HttpMessage httpMessage, boolean z3) {
        HttpHeaders headers = httpMessage.headers();
        DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers(z3, headers.size());
        if (httpMessage instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) httpMessage;
            URI create = URI.create(httpRequest.uri());
            defaultHttp2Headers.path(toHttp2Path(create));
            defaultHttp2Headers.method(httpRequest.method().asciiName());
            setHttp2Scheme(headers, create, defaultHttp2Headers);
            if (!HttpUtil.isOriginForm(create) && !HttpUtil.isAsteriskForm(create)) {
                String asString = headers.getAsString(HttpHeaderNames.HOST);
                if (asString == null || asString.isEmpty()) {
                    asString = create.getAuthority();
                }
                setHttp2Authority(asString, defaultHttp2Headers);
            }
        } else if (httpMessage instanceof HttpResponse) {
            defaultHttp2Headers.status(new AsciiString(Integer.toString(((HttpResponse) httpMessage).status().code())));
        }
        toHttp2Headers(headers, defaultHttp2Headers);
        return defaultHttp2Headers;
    }

    private static AsciiString toHttp2Path(URI uri) {
        StringBuilder sb = new StringBuilder(StringUtil.length(uri.getRawPath()) + StringUtil.length(uri.getRawQuery()) + StringUtil.length(uri.getRawFragment()) + 2);
        if (!StringUtil.isNullOrEmpty(uri.getRawPath())) {
            sb.append(uri.getRawPath());
        }
        if (!StringUtil.isNullOrEmpty(uri.getRawQuery())) {
            sb.append('?');
            sb.append(uri.getRawQuery());
        }
        if (!StringUtil.isNullOrEmpty(uri.getRawFragment())) {
            sb.append('#');
            sb.append(uri.getRawFragment());
        }
        String sb2 = sb.toString();
        return sb2.isEmpty() ? EMPTY_REQUEST_PATH : new AsciiString(sb2);
    }

    public static HttpRequest toHttpRequest(int i4, Http2Headers http2Headers, boolean z3) throws Http2Exception {
        DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.valueOf(((CharSequence) ObjectUtil.checkNotNull(http2Headers.method(), "method header cannot be null in conversion to HTTP/1.x")).toString()), ((CharSequence) ObjectUtil.checkNotNull(http2Headers.path(), "path header cannot be null in conversion to HTTP/1.x")).toString(), z3);
        try {
            addHttp2ToHttpHeaders(i4, http2Headers, defaultHttpRequest.headers(), defaultHttpRequest.protocolVersion(), false, true);
            return defaultHttpRequest;
        } catch (Http2Exception e4) {
            throw e4;
        } catch (Throwable th) {
            throw Http2Exception.streamError(i4, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static FullHttpResponse toHttpResponse(int i4, Http2Headers http2Headers, ByteBufAllocator byteBufAllocator, boolean z3) throws Http2Exception {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, parseStatus(http2Headers.status()), byteBufAllocator.buffer(), z3);
        try {
            addHttp2ToHttpHeaders(i4, http2Headers, defaultFullHttpResponse, false);
            return defaultFullHttpResponse;
        } catch (Http2Exception e4) {
            defaultFullHttpResponse.release();
            throw e4;
        } catch (Throwable th) {
            defaultFullHttpResponse.release();
            throw Http2Exception.streamError(i4, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static void addHttp2ToHttpHeaders(int i4, Http2Headers http2Headers, HttpHeaders httpHeaders, HttpVersion httpVersion, boolean z3, boolean z4) throws Http2Exception {
        Http2ToHttpHeaderTranslator http2ToHttpHeaderTranslator = new Http2ToHttpHeaderTranslator(i4, httpHeaders, z4);
        try {
            Iterator<Map.Entry<CharSequence, CharSequence>> it = http2Headers.iterator();
            while (it.hasNext()) {
                http2ToHttpHeaderTranslator.translate(it.next());
            }
            httpHeaders.remove(HttpHeaderNames.TRANSFER_ENCODING);
            httpHeaders.remove(HttpHeaderNames.TRAILER);
            if (z3) {
                return;
            }
            httpHeaders.setInt(ExtensionHeaderNames.STREAM_ID.text(), i4);
            HttpUtil.setKeepAlive(httpHeaders, httpVersion, true);
        } catch (Http2Exception e4) {
            throw e4;
        } catch (Throwable th) {
            throw Http2Exception.streamError(i4, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static Http2Headers toHttp2Headers(HttpHeaders httpHeaders, boolean z3) {
        if (httpHeaders.isEmpty()) {
            return EmptyHttp2Headers.INSTANCE;
        }
        DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers(z3, httpHeaders.size());
        toHttp2Headers(httpHeaders, defaultHttp2Headers);
        return defaultHttp2Headers;
    }

    public static void toHttp2Headers(HttpHeaders httpHeaders, Http2Headers http2Headers) {
        AsciiString asciiString;
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            AsciiString lowerCase = AsciiString.of(next.getKey()).toLowerCase();
            if (!HTTP_TO_HTTP2_HEADER_BLACKLIST.contains(lowerCase)) {
                AsciiString asciiString2 = HttpHeaderNames.TE;
                if (lowerCase.contentEqualsIgnoreCase(asciiString2) && !AsciiString.contentEqualsIgnoreCase(next.getValue(), HttpHeaderValues.TRAILERS)) {
                    throw new IllegalArgumentException("Invalid value for " + ((Object) asciiString2) + ": " + ((Object) next.getValue()));
                }
                AsciiString asciiString3 = HttpHeaderNames.COOKIE;
                if (lowerCase.contentEqualsIgnoreCase(asciiString3)) {
                    AsciiString of = AsciiString.of(next.getValue());
                    try {
                        int forEachByte = of.forEachByte(ByteProcessor.FIND_SEMI_COLON);
                        if (forEachByte != -1) {
                            int i4 = 0;
                            do {
                                asciiString = HttpHeaderNames.COOKIE;
                                http2Headers.add((Http2Headers) asciiString, of.subSequence(i4, forEachByte, false));
                                i4 = forEachByte + 2;
                                if (i4 >= of.length()) {
                                    break;
                                }
                                forEachByte = of.forEachByte(i4, of.length() - i4, ByteProcessor.FIND_SEMI_COLON);
                            } while (forEachByte != -1);
                            if (i4 < of.length()) {
                                http2Headers.add((Http2Headers) asciiString, of.subSequence(i4, of.length(), false));
                            } else {
                                throw new IllegalArgumentException("cookie value is of unexpected format: " + ((Object) of));
                            }
                        } else {
                            http2Headers.add((Http2Headers) asciiString3, of);
                        }
                    } catch (Exception e4) {
                        throw new IllegalStateException(e4);
                    }
                } else {
                    http2Headers.add((Http2Headers) lowerCase, (AsciiString) next.getValue());
                }
            }
        }
    }
}

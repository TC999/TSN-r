package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HttpUtil {
    @Deprecated
    static final EmptyHttpHeaders EMPTY_HEADERS = new EmptyHttpHeaders();
    private static final AsciiString CHARSET_EQUALS = AsciiString.m12682of(((Object) HttpHeaderValues.CHARSET) + "=");
    private static final AsciiString SEMICOLON = AsciiString.m12682of(";");

    private HttpUtil() {
    }

    private static byte c2b(char c) {
        return c > 255 ? Utf8.REPLACEMENT_BYTE : (byte) c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void encodeAscii0(CharSequence charSequence, ByteBuf byteBuf) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            byteBuf.writeByte(c2b(charSequence.charAt(i)));
        }
    }

    public static Charset getCharset(HttpMessage httpMessage) {
        return getCharset(httpMessage, CharsetUtil.ISO_8859_1);
    }

    public static CharSequence getCharsetAsString(HttpMessage httpMessage) {
        AsciiString asciiString;
        int indexOfIgnoreCaseAscii;
        int length;
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
        if (str == null || (indexOfIgnoreCaseAscii = AsciiString.indexOfIgnoreCaseAscii(str, (asciiString = CHARSET_EQUALS), 0)) == -1 || (length = indexOfIgnoreCaseAscii + asciiString.length()) >= str.length()) {
            return null;
        }
        return str.subSequence(length, str.length());
    }

    public static long getContentLength(HttpMessage httpMessage) {
        AsciiString asciiString;
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_LENGTH);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = getWebSocketContentLength(httpMessage);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }
        throw new NumberFormatException("header not found: " + ((Object) asciiString));
    }

    public static CharSequence getMimeType(HttpMessage httpMessage) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
        if (str != null) {
            int indexOfIgnoreCaseAscii = AsciiString.indexOfIgnoreCaseAscii(str, SEMICOLON, 0);
            if (indexOfIgnoreCaseAscii != -1) {
                return str.subSequence(0, indexOfIgnoreCaseAscii);
            }
            if (str.length() > 0) {
                return str;
            }
            return null;
        }
        return null;
    }

    private static int getWebSocketContentLength(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        return httpMessage instanceof HttpRequest ? (HttpMethod.GET.equals(((HttpRequest) httpMessage).method()) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY1) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2)) ? 8 : -1 : ((httpMessage instanceof HttpResponse) && ((HttpResponse) httpMessage).status().code() == 101 && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_LOCATION)) ? 16 : -1;
    }

    public static boolean is100ContinueExpected(HttpMessage httpMessage) {
        if ((httpMessage instanceof HttpRequest) && httpMessage.protocolVersion().compareTo(HttpVersion.HTTP_1_1) >= 0) {
            HttpHeaders headers = httpMessage.headers();
            AsciiString asciiString = HttpHeaderNames.EXPECT;
            String str = headers.get(asciiString);
            if (str == null) {
                return false;
            }
            AsciiString asciiString2 = HttpHeaderValues.CONTINUE;
            if (asciiString2.contentEqualsIgnoreCase(str)) {
                return true;
            }
            return httpMessage.headers().contains((CharSequence) asciiString, (CharSequence) asciiString2, true);
        }
        return false;
    }

    public static boolean isAsteriskForm(URI uri) {
        return "*".equals(uri.getPath()) && uri.getScheme() == null && uri.getSchemeSpecificPart() == null && uri.getHost() == null && uri.getAuthority() == null && uri.getQuery() == null && uri.getFragment() == null;
    }

    public static boolean isContentLengthSet(HttpMessage httpMessage) {
        return httpMessage.headers().contains(HttpHeaderNames.CONTENT_LENGTH);
    }

    public static boolean isKeepAlive(HttpMessage httpMessage) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONNECTION);
        if (str == null || !HttpHeaderValues.CLOSE.contentEqualsIgnoreCase(str)) {
            if (httpMessage.protocolVersion().isKeepAliveDefault()) {
                return !HttpHeaderValues.CLOSE.contentEqualsIgnoreCase(str);
            }
            return HttpHeaderValues.KEEP_ALIVE.contentEqualsIgnoreCase(str);
        }
        return false;
    }

    public static boolean isOriginForm(URI uri) {
        return uri.getScheme() == null && uri.getSchemeSpecificPart() == null && uri.getHost() == null && uri.getAuthority() == null;
    }

    public static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        return httpMessage.headers().contains((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (CharSequence) HttpHeaderValues.CHUNKED, true);
    }

    public static void set100ContinueExpected(HttpMessage httpMessage, boolean z) {
        if (z) {
            httpMessage.headers().set(HttpHeaderNames.EXPECT, HttpHeaderValues.CONTINUE);
        } else {
            httpMessage.headers().remove(HttpHeaderNames.EXPECT);
        }
    }

    public static void setContentLength(HttpMessage httpMessage, long j) {
        httpMessage.headers().set(HttpHeaderNames.CONTENT_LENGTH, Long.valueOf(j));
    }

    public static void setKeepAlive(HttpMessage httpMessage, boolean z) {
        setKeepAlive(httpMessage.headers(), httpMessage.protocolVersion(), z);
    }

    public static void setTransferEncodingChunked(HttpMessage httpMessage, boolean z) {
        if (z) {
            httpMessage.headers().add(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            return;
        }
        List<String> all = httpMessage.headers().getAll(HttpHeaderNames.TRANSFER_ENCODING);
        if (all.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(all);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase((CharSequence) it.next())) {
                it.remove();
            }
        }
        if (arrayList.isEmpty()) {
            httpMessage.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
        } else {
            httpMessage.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Iterable<?>) arrayList);
        }
    }

    public static Charset getCharset(HttpMessage httpMessage, Charset charset) {
        CharSequence charsetAsString = getCharsetAsString(httpMessage);
        if (charsetAsString != null) {
            try {
                return Charset.forName(charsetAsString.toString());
            } catch (UnsupportedCharsetException unused) {
            }
        }
        return charset;
    }

    public static void setKeepAlive(HttpHeaders httpHeaders, HttpVersion httpVersion, boolean z) {
        if (httpVersion.isKeepAliveDefault()) {
            if (z) {
                httpHeaders.remove(HttpHeaderNames.CONNECTION);
            } else {
                httpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
            }
        } else if (z) {
            httpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        } else {
            httpHeaders.remove(HttpHeaderNames.CONNECTION);
        }
    }

    public static long getContentLength(HttpMessage httpMessage, long j) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_LENGTH);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = getWebSocketContentLength(httpMessage);
        return webSocketContentLength >= 0 ? webSocketContentLength : j;
    }

    public static int getContentLength(HttpMessage httpMessage, int i) {
        return (int) Math.min(2147483647L, getContentLength(httpMessage, i));
    }
}

package io.netty.handler.codec.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QueryStringEncoder {
    private final Charset charset;
    private final List<Param> params;
    private final String uri;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Param {
        final String name;
        final String value;

        Param(String str, String str2) {
            this.value = str2;
            this.name = str;
        }
    }

    public QueryStringEncoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private static String encodeComponent(String str, Charset charset) {
        try {
            return URLEncoder.encode(str, charset.name()).replace("+", "%20");
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }

    public void addParam(String str, String str2) {
        if (str != null) {
            this.params.add(new Param(str, str2));
            return;
        }
        throw new NullPointerException("name");
    }

    public String toString() {
        if (this.params.isEmpty()) {
            return this.uri;
        }
        StringBuilder sb = new StringBuilder(this.uri);
        sb.append('?');
        for (int i4 = 0; i4 < this.params.size(); i4++) {
            Param param = this.params.get(i4);
            sb.append(encodeComponent(param.name, this.charset));
            if (param.value != null) {
                sb.append('=');
                sb.append(encodeComponent(param.value, this.charset));
            }
            if (i4 != this.params.size() - 1) {
                sb.append('&');
            }
        }
        return sb.toString();
    }

    public URI toUri() throws URISyntaxException {
        return new URI(toString());
    }

    public QueryStringEncoder(String str, Charset charset) {
        this.params = new ArrayList();
        if (str == null) {
            throw new NullPointerException("getUri");
        }
        if (charset != null) {
            this.uri = str;
            this.charset = charset;
            return;
        }
        throw new NullPointerException("charset");
    }
}

package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultHttpRequest extends DefaultHttpMessage implements HttpRequest {
    private static final int HASH_CODE_PRIME = 31;
    private HttpMethod method;
    private String uri;

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str) {
        this(httpVersion, httpMethod, str, true);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttpRequest) {
            DefaultHttpRequest defaultHttpRequest = (DefaultHttpRequest) obj;
            return method().equals(defaultHttpRequest.method()) && uri().equalsIgnoreCase(defaultHttpRequest.uri()) && super.equals(obj);
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    @Deprecated
    public HttpMethod getMethod() {
        return method();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    @Deprecated
    public String getUri() {
        return uri();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((((this.method.hashCode() + 31) * 31) + this.uri.hashCode()) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    public HttpMethod method() {
        return this.method;
    }

    public HttpRequest setMethod(HttpMethod httpMethod) {
        if (httpMethod != null) {
            this.method = httpMethod;
            return this;
        }
        throw new NullPointerException("method");
    }

    public HttpRequest setUri(String str) {
        if (str != null) {
            this.uri = str;
            return this;
        }
        throw new NullPointerException("uri");
    }

    public String toString() {
        return HttpMessageUtil.appendRequest(new StringBuilder(256), this).toString();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    public String uri() {
        return this.uri;
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, boolean z3) {
        super(httpVersion, z3, false);
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, HttpHeaders httpHeaders) {
        super(httpVersion, httpHeaders);
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
    }
}

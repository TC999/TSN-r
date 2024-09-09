package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class DefaultHttpMessage extends DefaultHttpObject implements HttpMessage {
    private static final int HASH_CODE_PRIME = 31;
    private final HttpHeaders headers;
    private HttpVersion version;

    protected DefaultHttpMessage(HttpVersion httpVersion) {
        this(httpVersion, true, false);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttpMessage) {
            DefaultHttpMessage defaultHttpMessage = (DefaultHttpMessage) obj;
            return headers().equals(defaultHttpMessage.headers()) && protocolVersion().equals(defaultHttpMessage.protocolVersion()) && super.equals(obj);
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    @Deprecated
    public HttpVersion getProtocolVersion() {
        return protocolVersion();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((((this.headers.hashCode() + 31) * 31) + this.version.hashCode()) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpVersion protocolVersion() {
        return this.version;
    }

    public HttpMessage setProtocolVersion(HttpVersion httpVersion) {
        if (httpVersion != null) {
            this.version = httpVersion;
            return this;
        }
        throw new NullPointerException("version");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultHttpMessage(HttpVersion httpVersion, boolean z3, boolean z4) {
        this(httpVersion, z4 ? new CombinedHttpHeaders(z3) : new DefaultHttpHeaders(z3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultHttpMessage(HttpVersion httpVersion, HttpHeaders httpHeaders) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, "version");
        this.headers = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders, "headers");
    }
}

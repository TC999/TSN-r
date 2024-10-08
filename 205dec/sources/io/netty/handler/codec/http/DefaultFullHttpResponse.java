package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultFullHttpResponse extends DefaultHttpResponse implements FullHttpResponse {
    private final ByteBuf content;
    private int hash;
    private final HttpHeaders trailingHeaders;

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0));
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (obj instanceof DefaultFullHttpResponse) {
            DefaultFullHttpResponse defaultFullHttpResponse = (DefaultFullHttpResponse) obj;
            return super.equals(defaultFullHttpResponse) && content().equals(defaultFullHttpResponse.content()) && trailingHeaders().equals(defaultFullHttpResponse.trailingHeaders());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        int hashCode;
        int i4 = this.hash;
        if (i4 == 0) {
            if (content().refCnt() != 0) {
                try {
                    hashCode = content().hashCode() + 31;
                } catch (IllegalReferenceCountException unused) {
                }
                int hashCode2 = (((hashCode * 31) + trailingHeaders().hashCode()) * 31) + super.hashCode();
                this.hash = hashCode2;
                return hashCode2;
            }
            hashCode = 31;
            int hashCode22 = (((hashCode * 31) + trailingHeaders().hashCode()) * 31) + super.hashCode();
            this.hash = hashCode22;
            return hashCode22;
        }
        return i4;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse
    public String toString() {
        return HttpMessageUtil.appendFullResponse(new StringBuilder(256), this).toString();
    }

    @Override // io.netty.handler.codec.http.LastHttpContent
    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf) {
        this(httpVersion, httpResponseStatus, byteBuf, true);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        return this.content.release(i4);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse, io.netty.handler.codec.http.HttpResponse, io.netty.handler.codec.http.FullHttpResponse
    public FullHttpResponse setStatus(HttpResponseStatus httpResponseStatus) {
        super.setStatus(httpResponseStatus);
        return this;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z3) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0), z3, false);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse, io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    public FullHttpResponse setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z3, boolean z4) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0), z3, z4);
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, boolean z3) {
        this(httpVersion, httpResponseStatus, byteBuf, z3, false);
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse copy() {
        return replace(content().copy());
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse replace(ByteBuf byteBuf) {
        return new DefaultFullHttpResponse(protocolVersion(), status(), byteBuf, headers(), trailingHeaders());
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, boolean z3, boolean z4) {
        super(httpVersion, httpResponseStatus, z3, z4);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeaders = z4 ? new CombinedHttpHeaders(z3) : new DefaultHttpHeaders(z3);
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, HttpHeaders httpHeaders, HttpHeaders httpHeaders2) {
        super(httpVersion, httpResponseStatus, httpHeaders);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeaders = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders2, "trailingHeaders");
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse retain(int i4) {
        this.content.retain(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}

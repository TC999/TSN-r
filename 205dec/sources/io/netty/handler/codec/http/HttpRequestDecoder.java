package io.netty.handler.codec.http;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HttpRequestDecoder extends HttpObjectDecoder {
    public HttpRequestDecoder() {
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createInvalidMessage() {
        return new DefaultFullHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.GET, "/bad-request", this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createMessage(String[] strArr) throws Exception {
        return new DefaultHttpRequest(HttpVersion.valueOf(strArr[2]), HttpMethod.valueOf(strArr[0]), strArr[1], this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected boolean isDecodingRequest() {
        return true;
    }

    public HttpRequestDecoder(int i4, int i5, int i6) {
        super(i4, i5, i6, true);
    }

    public HttpRequestDecoder(int i4, int i5, int i6, boolean z3) {
        super(i4, i5, i6, true, z3);
    }

    public HttpRequestDecoder(int i4, int i5, int i6, boolean z3, int i7) {
        super(i4, i5, i6, true, z3, i7);
    }
}

package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpResponseEncoder extends HttpObjectEncoder<HttpResponse> {
    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return super.acceptOutboundMessage(obj) && !(obj instanceof HttpRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpResponse httpResponse) throws Exception {
        httpResponse.protocolVersion().encode(byteBuf);
        byteBuf.writeByte(32);
        httpResponse.status().encode(byteBuf);
        byteBuf.writeBytes(HttpObjectEncoder.CRLF);
    }
}

package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SocksInitResponse extends SocksResponse {
    private final SocksAuthScheme authScheme;

    public SocksInitResponse(SocksAuthScheme socksAuthScheme) {
        super(SocksResponseType.INIT);
        if (socksAuthScheme != null) {
            this.authScheme = socksAuthScheme;
            return;
        }
        throw new NullPointerException("authScheme");
    }

    public SocksAuthScheme authScheme() {
        return this.authScheme;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.authScheme.byteValue());
    }
}

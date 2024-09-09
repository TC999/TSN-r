package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class SocksResponse extends SocksMessage {
    private final SocksResponseType responseType;

    /* JADX INFO: Access modifiers changed from: protected */
    public SocksResponse(SocksResponseType socksResponseType) {
        super(SocksMessageType.RESPONSE);
        if (socksResponseType != null) {
            this.responseType = socksResponseType;
            return;
        }
        throw new NullPointerException("responseType");
    }

    public SocksResponseType responseType() {
        return this.responseType;
    }
}

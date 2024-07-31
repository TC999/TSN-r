package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SocksRequest extends SocksMessage {
    private final SocksRequestType requestType;

    /* JADX INFO: Access modifiers changed from: protected */
    public SocksRequest(SocksRequestType socksRequestType) {
        super(SocksMessageType.REQUEST);
        if (socksRequestType != null) {
            this.requestType = socksRequestType;
            return;
        }
        throw new NullPointerException("requestType");
    }

    public SocksRequestType requestType() {
        return this.requestType;
    }
}

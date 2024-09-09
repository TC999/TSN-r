package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

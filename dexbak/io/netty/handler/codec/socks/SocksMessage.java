package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SocksMessage {
    private final SocksProtocolVersion protocolVersion = SocksProtocolVersion.SOCKS5;
    private final SocksMessageType type;

    /* JADX INFO: Access modifiers changed from: protected */
    public SocksMessage(SocksMessageType socksMessageType) {
        if (socksMessageType != null) {
            this.type = socksMessageType;
            return;
        }
        throw new NullPointerException("type");
    }

    @Deprecated
    public abstract void encodeAsByteBuf(ByteBuf byteBuf);

    public SocksProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public SocksMessageType type() {
        return this.type;
    }
}

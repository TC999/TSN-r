package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);
    

    /* renamed from: b */
    private final byte f40255b;

    SocksSubnegotiationVersion(byte b) {
        this.f40255b = b;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40255b;
    }

    public static SocksSubnegotiationVersion valueOf(byte b) {
        SocksSubnegotiationVersion[] values;
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.f40255b == b) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }
}

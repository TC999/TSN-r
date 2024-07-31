package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    

    /* renamed from: b */
    private final byte f40254b;

    SocksProtocolVersion(byte b) {
        this.f40254b = b;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40254b;
    }

    public static SocksProtocolVersion valueOf(byte b) {
        SocksProtocolVersion[] values;
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.f40254b == b) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }
}

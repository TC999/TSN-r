package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);
    

    /* renamed from: b */
    private final byte f40243b;

    SocksAddressType(byte b) {
        this.f40243b = b;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40243b;
    }

    public static SocksAddressType valueOf(byte b) {
        SocksAddressType[] values;
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.f40243b == b) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }
}

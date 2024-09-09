package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54791b;

    SocksAddressType(byte b4) {
        this.f54791b = b4;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54791b;
    }

    public static SocksAddressType valueOf(byte b4) {
        SocksAddressType[] values;
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.f54791b == b4) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }
}

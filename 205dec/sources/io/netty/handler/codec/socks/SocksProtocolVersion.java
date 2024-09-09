package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54796b;

    SocksProtocolVersion(byte b4) {
        this.f54796b = b4;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54796b;
    }

    public static SocksProtocolVersion valueOf(byte b4) {
        SocksProtocolVersion[] values;
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.f54796b == b4) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }
}

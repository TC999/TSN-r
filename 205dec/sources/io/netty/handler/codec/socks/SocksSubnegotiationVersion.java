package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54797b;

    SocksSubnegotiationVersion(byte b4) {
        this.f54797b = b4;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54797b;
    }

    public static SocksSubnegotiationVersion valueOf(byte b4) {
        SocksSubnegotiationVersion[] values;
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.f54797b == b4) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }
}

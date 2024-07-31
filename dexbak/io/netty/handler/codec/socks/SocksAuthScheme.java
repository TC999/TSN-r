package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksAuthScheme {
    NO_AUTH((byte) 0),
    AUTH_GSSAPI((byte) 1),
    AUTH_PASSWORD((byte) 2),
    UNKNOWN((byte) -1);
    

    /* renamed from: b */
    private final byte f40246b;

    SocksAuthScheme(byte b) {
        this.f40246b = b;
    }

    @Deprecated
    public static SocksAuthScheme fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40246b;
    }

    public static SocksAuthScheme valueOf(byte b) {
        SocksAuthScheme[] values;
        for (SocksAuthScheme socksAuthScheme : values()) {
            if (socksAuthScheme.f40246b == b) {
                return socksAuthScheme;
            }
        }
        return UNKNOWN;
    }
}

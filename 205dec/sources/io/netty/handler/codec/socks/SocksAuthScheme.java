package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksAuthScheme {
    NO_AUTH((byte) 0),
    AUTH_GSSAPI((byte) 1),
    AUTH_PASSWORD((byte) 2),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54792b;

    SocksAuthScheme(byte b4) {
        this.f54792b = b4;
    }

    @Deprecated
    public static SocksAuthScheme fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54792b;
    }

    public static SocksAuthScheme valueOf(byte b4) {
        SocksAuthScheme[] values;
        for (SocksAuthScheme socksAuthScheme : values()) {
            if (socksAuthScheme.f54792b == b4) {
                return socksAuthScheme;
            }
        }
        return UNKNOWN;
    }
}

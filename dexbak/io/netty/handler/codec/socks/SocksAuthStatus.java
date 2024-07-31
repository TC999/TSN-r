package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);
    

    /* renamed from: b */
    private final byte f40247b;

    SocksAuthStatus(byte b) {
        this.f40247b = b;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40247b;
    }

    public static SocksAuthStatus valueOf(byte b) {
        SocksAuthStatus[] values;
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.f40247b == b) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }
}

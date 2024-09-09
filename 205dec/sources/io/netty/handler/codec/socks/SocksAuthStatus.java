package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54793b;

    SocksAuthStatus(byte b4) {
        this.f54793b = b4;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54793b;
    }

    public static SocksAuthStatus valueOf(byte b4) {
        SocksAuthStatus[] values;
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.f54793b == b4) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }
}

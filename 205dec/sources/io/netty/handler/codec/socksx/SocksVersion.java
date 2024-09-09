package io.netty.handler.codec.socksx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54798b;

    SocksVersion(byte b4) {
        this.f54798b = b4;
    }

    public byte byteValue() {
        return this.f54798b;
    }

    public static SocksVersion valueOf(byte b4) {
        SocksVersion socksVersion = SOCKS4a;
        if (b4 == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        return b4 == socksVersion2.byteValue() ? socksVersion2 : UNKNOWN;
    }
}

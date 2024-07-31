package io.netty.handler.codec.socksx;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    

    /* renamed from: b */
    private final byte f40256b;

    SocksVersion(byte b) {
        this.f40256b = b;
    }

    public byte byteValue() {
        return this.f40256b;
    }

    public static SocksVersion valueOf(byte b) {
        SocksVersion socksVersion = SOCKS4a;
        if (b == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        return b == socksVersion2.byteValue() ? socksVersion2 : UNKNOWN;
    }
}

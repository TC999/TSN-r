package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SocksCmdType {
    CONNECT((byte) 1),
    BIND((byte) 2),
    UDP((byte) 3),
    UNKNOWN((byte) -1);
    

    /* renamed from: b */
    private final byte f40251b;

    SocksCmdType(byte b) {
        this.f40251b = b;
    }

    @Deprecated
    public static SocksCmdType fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40251b;
    }

    public static SocksCmdType valueOf(byte b) {
        SocksCmdType[] values;
        for (SocksCmdType socksCmdType : values()) {
            if (socksCmdType.f40251b == b) {
                return socksCmdType;
            }
        }
        return UNKNOWN;
    }
}

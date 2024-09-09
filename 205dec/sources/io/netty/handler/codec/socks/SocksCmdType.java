package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksCmdType {
    CONNECT((byte) 1),
    BIND((byte) 2),
    UDP((byte) 3),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54795b;

    SocksCmdType(byte b4) {
        this.f54795b = b4;
    }

    @Deprecated
    public static SocksCmdType fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54795b;
    }

    public static SocksCmdType valueOf(byte b4) {
        SocksCmdType[] values;
        for (SocksCmdType socksCmdType : values()) {
            if (socksCmdType.f54795b == b4) {
                return socksCmdType;
            }
        }
        return UNKNOWN;
    }
}

package io.netty.handler.codec.socks;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum SocksCmdStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) 1),
    FORBIDDEN((byte) 2),
    NETWORK_UNREACHABLE((byte) 3),
    HOST_UNREACHABLE((byte) 4),
    REFUSED((byte) 5),
    TTL_EXPIRED((byte) 6),
    COMMAND_NOT_SUPPORTED((byte) 7),
    ADDRESS_NOT_SUPPORTED((byte) 8),
    UNASSIGNED((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f54794b;

    SocksCmdStatus(byte b4) {
        this.f54794b = b4;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b4) {
        return valueOf(b4);
    }

    public byte byteValue() {
        return this.f54794b;
    }

    public static SocksCmdStatus valueOf(byte b4) {
        SocksCmdStatus[] values;
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.f54794b == b4) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }
}

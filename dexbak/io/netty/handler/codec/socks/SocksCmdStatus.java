package io.netty.handler.codec.socks;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    

    /* renamed from: b */
    private final byte f40250b;

    SocksCmdStatus(byte b) {
        this.f40250b = b;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f40250b;
    }

    public static SocksCmdStatus valueOf(byte b) {
        SocksCmdStatus[] values;
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.f40250b == b) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }
}

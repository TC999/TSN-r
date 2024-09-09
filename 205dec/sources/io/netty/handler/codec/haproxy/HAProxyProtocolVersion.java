package io.netty.handler.codec.haproxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum HAProxyProtocolVersion {
    V1((byte) 16),
    V2((byte) 32);
    
    private static final byte VERSION_MASK = -16;
    private final byte byteValue;

    HAProxyProtocolVersion(byte b4) {
        this.byteValue = b4;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public static HAProxyProtocolVersion valueOf(byte b4) {
        int i4 = b4 & (-16);
        byte b5 = (byte) i4;
        if (b5 != 16) {
            if (b5 == 32) {
                return V2;
            }
            throw new IllegalArgumentException("unknown version: " + i4);
        }
        return V1;
    }
}

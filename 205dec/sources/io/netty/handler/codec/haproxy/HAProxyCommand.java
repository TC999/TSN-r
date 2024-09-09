package io.netty.handler.codec.haproxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum HAProxyCommand {
    LOCAL((byte) 0),
    PROXY((byte) 1);
    
    private static final byte COMMAND_MASK = 15;
    private final byte byteValue;

    HAProxyCommand(byte b4) {
        this.byteValue = b4;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public static HAProxyCommand valueOf(byte b4) {
        int i4 = b4 & 15;
        byte b5 = (byte) i4;
        if (b5 != 0) {
            if (b5 == 1) {
                return PROXY;
            }
            throw new IllegalArgumentException("unknown command: " + i4);
        }
        return LOCAL;
    }
}

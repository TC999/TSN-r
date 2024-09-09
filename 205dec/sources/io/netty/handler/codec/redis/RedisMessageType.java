package io.netty.handler.codec.redis;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum RedisMessageType {
    SIMPLE_STRING((byte) 43, true),
    ERROR((byte) 45, true),
    INTEGER((byte) 58, true),
    BULK_STRING((byte) 36, false),
    ARRAY_HEADER((byte) 42, false),
    ARRAY((byte) 42, false);
    
    private final boolean inline;
    private final byte value;

    RedisMessageType(byte b4, boolean z3) {
        this.value = b4;
        this.inline = z3;
    }

    public boolean isInline() {
        return this.inline;
    }

    public byte value() {
        return this.value;
    }

    public static RedisMessageType valueOf(byte b4) {
        if (b4 != 36) {
            if (b4 != 45) {
                if (b4 != 58) {
                    if (b4 != 42) {
                        if (b4 == 43) {
                            return SIMPLE_STRING;
                        }
                        throw new RedisCodecException("Unknown RedisMessageType: " + ((int) b4));
                    }
                    return ARRAY_HEADER;
                }
                return INTEGER;
            }
            return ERROR;
        }
        return BULK_STRING;
    }
}

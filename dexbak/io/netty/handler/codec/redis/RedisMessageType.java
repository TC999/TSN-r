package io.netty.handler.codec.redis;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum RedisMessageType {
    SIMPLE_STRING((byte) 43, true),
    ERROR((byte) 45, true),
    INTEGER(HttpConstants.COLON, true),
    BULK_STRING(BinaryMemcacheOpcodes.GATKQ, false),
    ARRAY_HEADER((byte) 42, false),
    ARRAY((byte) 42, false);
    
    private final boolean inline;
    private final byte value;

    RedisMessageType(byte b, boolean z) {
        this.value = b;
        this.inline = z;
    }

    public boolean isInline() {
        return this.inline;
    }

    public byte value() {
        return this.value;
    }

    public static RedisMessageType valueOf(byte b) {
        if (b != 36) {
            if (b != 45) {
                if (b != 58) {
                    if (b != 42) {
                        if (b == 43) {
                            return SIMPLE_STRING;
                        }
                        throw new RedisCodecException("Unknown RedisMessageType: " + ((int) b));
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

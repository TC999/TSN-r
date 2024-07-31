package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ArrayHeaderRedisMessage implements RedisMessage {
    private final long length;

    public ArrayHeaderRedisMessage(long j) {
        if (j >= -1) {
            this.length = j;
            return;
        }
        throw new RedisCodecException("length: " + j + " (expected: >= -1)");
    }

    public boolean isNull() {
        return this.length == -1;
    }

    public final long length() {
        return this.length;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[length=" + this.length + ']';
    }
}

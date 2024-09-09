package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ArrayHeaderRedisMessage implements RedisMessage {
    private final long length;

    public ArrayHeaderRedisMessage(long j4) {
        if (j4 >= -1) {
            this.length = j4;
            return;
        }
        throw new RedisCodecException("length: " + j4 + " (expected: >= -1)");
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

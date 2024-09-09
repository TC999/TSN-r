package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class IntegerRedisMessage implements RedisMessage {
    private final long value;

    public IntegerRedisMessage(long j4) {
        this.value = j4;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[value=" + this.value + ']';
    }

    public long value() {
        return this.value;
    }
}

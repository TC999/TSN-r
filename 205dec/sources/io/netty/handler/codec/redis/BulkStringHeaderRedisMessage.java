package io.netty.handler.codec.redis;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BulkStringHeaderRedisMessage implements RedisMessage {
    private final int bulkStringLength;

    public BulkStringHeaderRedisMessage(int i4) {
        if (i4 > 0) {
            this.bulkStringLength = i4;
            return;
        }
        throw new RedisCodecException("bulkStringLength: " + i4 + " (expected: > 0)");
    }

    public final int bulkStringLength() {
        return this.bulkStringLength;
    }

    public boolean isNull() {
        return this.bulkStringLength == -1;
    }
}

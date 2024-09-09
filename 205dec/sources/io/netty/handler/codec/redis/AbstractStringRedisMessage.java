package io.netty.handler.codec.redis;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractStringRedisMessage implements RedisMessage {
    private final String content;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStringRedisMessage(String str) {
        this.content = (String) ObjectUtil.checkNotNull(str, "content");
    }

    public final String content() {
        return this.content;
    }
}

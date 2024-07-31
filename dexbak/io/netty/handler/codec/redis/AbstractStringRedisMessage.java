package io.netty.handler.codec.redis;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

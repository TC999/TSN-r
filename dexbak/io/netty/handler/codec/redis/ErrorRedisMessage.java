package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ErrorRedisMessage extends AbstractStringRedisMessage {
    public ErrorRedisMessage(String str) {
        super(str);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[content=" + content() + ']';
    }
}

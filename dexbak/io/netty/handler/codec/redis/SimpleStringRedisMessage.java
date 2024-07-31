package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SimpleStringRedisMessage extends AbstractStringRedisMessage {
    public SimpleStringRedisMessage(String str) {
        super(str);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[content=" + content() + ']';
    }
}

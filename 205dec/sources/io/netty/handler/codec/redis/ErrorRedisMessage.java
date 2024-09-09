package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ErrorRedisMessage extends AbstractStringRedisMessage {
    public ErrorRedisMessage(String str) {
        super(str);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[content=" + content() + ']';
    }
}

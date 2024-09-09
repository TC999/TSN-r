package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttMessageIdVariableHeader {
    private final int messageId;

    private MqttMessageIdVariableHeader(int i4) {
        this.messageId = i4;
    }

    public static MqttMessageIdVariableHeader from(int i4) {
        if (i4 >= 1 && i4 <= 65535) {
            return new MqttMessageIdVariableHeader(i4);
        }
        throw new IllegalArgumentException("messageId: " + i4 + " (expected: 1 ~ 65535)");
    }

    public int messageId() {
        return this.messageId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[messageId=" + this.messageId + ']';
    }
}

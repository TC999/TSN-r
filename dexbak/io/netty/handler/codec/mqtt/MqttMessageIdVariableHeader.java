package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MqttMessageIdVariableHeader {
    private final int messageId;

    private MqttMessageIdVariableHeader(int i) {
        this.messageId = i;
    }

    public static MqttMessageIdVariableHeader from(int i) {
        if (i >= 1 && i <= 65535) {
            return new MqttMessageIdVariableHeader(i);
        }
        throw new IllegalArgumentException("messageId: " + i + " (expected: 1 ~ 65535)");
    }

    public int messageId() {
        return this.messageId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[messageId=" + this.messageId + ']';
    }
}

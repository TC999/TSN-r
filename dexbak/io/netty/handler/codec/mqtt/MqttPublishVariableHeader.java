package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MqttPublishVariableHeader {
    private final int messageId;
    private final String topicName;

    public MqttPublishVariableHeader(String str, int i) {
        this.topicName = str;
        this.messageId = i;
    }

    public int messageId() {
        return this.messageId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[topicName=" + this.topicName + ", messageId=" + this.messageId + ']';
    }

    public String topicName() {
        return this.topicName;
    }
}

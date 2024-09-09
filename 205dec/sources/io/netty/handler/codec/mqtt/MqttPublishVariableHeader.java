package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttPublishVariableHeader {
    private final int messageId;
    private final String topicName;

    public MqttPublishVariableHeader(String str, int i4) {
        this.topicName = str;
        this.messageId = i4;
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

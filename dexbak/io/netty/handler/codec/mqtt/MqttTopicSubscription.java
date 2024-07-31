package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MqttTopicSubscription {
    private final MqttQoS qualityOfService;
    private final String topicFilter;

    public MqttTopicSubscription(String str, MqttQoS mqttQoS) {
        this.topicFilter = str;
        this.qualityOfService = mqttQoS;
    }

    public MqttQoS qualityOfService() {
        return this.qualityOfService;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[topicFilter=" + this.topicFilter + ", qualityOfService=" + this.qualityOfService + ']';
    }

    public String topicName() {
        return this.topicFilter;
    }
}

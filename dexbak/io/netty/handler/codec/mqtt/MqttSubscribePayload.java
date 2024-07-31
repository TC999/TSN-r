package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MqttSubscribePayload {
    private final List<MqttTopicSubscription> topicSubscriptions;

    public MqttSubscribePayload(List<MqttTopicSubscription> list) {
        this.topicSubscriptions = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        sb.append('[');
        for (int i = 0; i < this.topicSubscriptions.size() - 1; i++) {
            sb.append(this.topicSubscriptions.get(i));
            sb.append(", ");
        }
        List<MqttTopicSubscription> list = this.topicSubscriptions;
        sb.append(list.get(list.size() - 1));
        sb.append(']');
        return sb.toString();
    }

    public List<MqttTopicSubscription> topicSubscriptions() {
        return this.topicSubscriptions;
    }
}

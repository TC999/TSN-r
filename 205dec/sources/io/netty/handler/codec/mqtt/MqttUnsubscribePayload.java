package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttUnsubscribePayload {
    private final List<String> topics;

    public MqttUnsubscribePayload(List<String> list) {
        this.topics = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        sb.append('[');
        for (int i4 = 0; i4 < this.topics.size() - 1; i4++) {
            sb.append("topicName = ");
            sb.append(this.topics.get(i4));
            sb.append(", ");
        }
        sb.append("topicName = ");
        List<String> list = this.topics;
        sb.append(list.get(list.size() - 1));
        sb.append(']');
        return sb.toString();
    }

    public List<String> topics() {
        return this.topics;
    }
}

package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MqttMessage {
    private final DecoderResult decoderResult;
    private final MqttFixedHeader mqttFixedHeader;
    private final Object payload;
    private final Object variableHeader;

    public MqttMessage(MqttFixedHeader mqttFixedHeader) {
        this(mqttFixedHeader, null, null);
    }

    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public MqttFixedHeader fixedHeader() {
        return this.mqttFixedHeader;
    }

    public Object payload() {
        return this.payload;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        sb.append('[');
        sb.append("fixedHeader=");
        sb.append(fixedHeader() != null ? fixedHeader().toString() : "");
        sb.append(", variableHeader=");
        sb.append(variableHeader() != null ? this.variableHeader.toString() : "");
        sb.append(", payload=");
        sb.append(payload() != null ? this.payload.toString() : "");
        sb.append(']');
        return sb.toString();
    }

    public Object variableHeader() {
        return this.variableHeader;
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj) {
        this(mqttFixedHeader, obj, null);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2) {
        this(mqttFixedHeader, obj, obj2, DecoderResult.SUCCESS);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2, DecoderResult decoderResult) {
        this.mqttFixedHeader = mqttFixedHeader;
        this.variableHeader = obj;
        this.payload = obj2;
        this.decoderResult = decoderResult;
    }
}

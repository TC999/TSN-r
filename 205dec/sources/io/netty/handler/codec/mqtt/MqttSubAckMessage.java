package io.netty.handler.codec.mqtt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttSubAckMessage extends MqttMessage {
    public MqttSubAckMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttSubAckPayload mqttSubAckPayload) {
        super(mqttFixedHeader, mqttMessageIdVariableHeader, mqttSubAckPayload);
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttSubAckPayload payload() {
        return (MqttSubAckPayload) super.payload();
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }
}

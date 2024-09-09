package io.netty.handler.codec.mqtt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttConnAckMessage extends MqttMessage {
    public MqttConnAckMessage(MqttFixedHeader mqttFixedHeader, MqttConnAckVariableHeader mqttConnAckVariableHeader) {
        super(mqttFixedHeader, mqttConnAckVariableHeader);
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttConnAckVariableHeader variableHeader() {
        return (MqttConnAckVariableHeader) super.variableHeader();
    }
}

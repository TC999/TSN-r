package io.netty.handler.codec.mqtt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttConnectMessage extends MqttMessage {
    public MqttConnectMessage(MqttFixedHeader mqttFixedHeader, MqttConnectVariableHeader mqttConnectVariableHeader, MqttConnectPayload mqttConnectPayload) {
        super(mqttFixedHeader, mqttConnectVariableHeader, mqttConnectPayload);
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttConnectPayload payload() {
        return (MqttConnectPayload) super.payload();
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttConnectVariableHeader variableHeader() {
        return (MqttConnectVariableHeader) super.variableHeader();
    }
}

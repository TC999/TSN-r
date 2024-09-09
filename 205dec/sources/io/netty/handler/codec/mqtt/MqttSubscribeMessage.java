package io.netty.handler.codec.mqtt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttSubscribeMessage extends MqttMessage {
    public MqttSubscribeMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttSubscribePayload mqttSubscribePayload) {
        super(mqttFixedHeader, mqttMessageIdVariableHeader, mqttSubscribePayload);
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttSubscribePayload payload() {
        return (MqttSubscribePayload) super.payload();
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }
}

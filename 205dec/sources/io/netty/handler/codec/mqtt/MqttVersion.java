package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum MqttVersion {
    MQTT_3_1("MQIsdp", (byte) 3),
    MQTT_3_1_1("MQTT", (byte) 4);
    
    private final byte level;
    private final String name;

    MqttVersion(String str, byte b4) {
        this.name = (String) ObjectUtil.checkNotNull(str, "protocolName");
        this.level = b4;
    }

    public static MqttVersion fromProtocolNameAndLevel(String str, byte b4) {
        MqttVersion[] values;
        for (MqttVersion mqttVersion : values()) {
            if (mqttVersion.name.equals(str)) {
                if (mqttVersion.level == b4) {
                    return mqttVersion;
                }
                throw new MqttUnacceptableProtocolVersionException(str + " and " + ((int) b4) + " are not match");
            }
        }
        throw new MqttUnacceptableProtocolVersionException(str + "is unknown protocol name");
    }

    public byte protocolLevel() {
        return this.level;
    }

    public String protocolName() {
        return this.name;
    }

    public byte[] protocolNameBytes() {
        return this.name.getBytes(CharsetUtil.UTF_8);
    }
}

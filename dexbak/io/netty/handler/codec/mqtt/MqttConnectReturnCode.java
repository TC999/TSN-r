package io.netty.handler.codec.mqtt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum MqttConnectReturnCode {
    CONNECTION_ACCEPTED((byte) 0),
    CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION((byte) 1),
    CONNECTION_REFUSED_IDENTIFIER_REJECTED((byte) 2),
    CONNECTION_REFUSED_SERVER_UNAVAILABLE((byte) 3),
    CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD((byte) 4),
    CONNECTION_REFUSED_NOT_AUTHORIZED((byte) 5);
    
    private static final Map<Byte, MqttConnectReturnCode> VALUE_TO_CODE_MAP;
    private final byte byteValue;

    static {
        MqttConnectReturnCode[] values;
        HashMap hashMap = new HashMap();
        for (MqttConnectReturnCode mqttConnectReturnCode : values()) {
            hashMap.put(Byte.valueOf(mqttConnectReturnCode.byteValue), mqttConnectReturnCode);
        }
        VALUE_TO_CODE_MAP = Collections.unmodifiableMap(hashMap);
    }

    MqttConnectReturnCode(byte b) {
        this.byteValue = b;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public static MqttConnectReturnCode valueOf(byte b) {
        Map<Byte, MqttConnectReturnCode> map = VALUE_TO_CODE_MAP;
        if (map.containsKey(Byte.valueOf(b))) {
            return map.get(Byte.valueOf(b));
        }
        throw new IllegalArgumentException("unknown connect return code: " + (b & UByte.f41242c));
    }
}

package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MqttConnectPayload {
    private final String clientIdentifier;
    private final String password;
    private final String userName;
    private final String willMessage;
    private final String willTopic;

    public MqttConnectPayload(String str, String str2, String str3, String str4, String str5) {
        this.clientIdentifier = str;
        this.willTopic = str2;
        this.willMessage = str3;
        this.userName = str4;
        this.password = str5;
    }

    public String clientIdentifier() {
        return this.clientIdentifier;
    }

    public String password() {
        return this.password;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[clientIdentifier=" + this.clientIdentifier + ", willTopic=" + this.willTopic + ", willMessage=" + this.willMessage + ", userName=" + this.userName + ", password=" + this.password + ']';
    }

    public String userName() {
        return this.userName;
    }

    public String willMessage() {
        return this.willMessage;
    }

    public String willTopic() {
        return this.willTopic;
    }
}

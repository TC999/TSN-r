package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class MqttMessageBuilders {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class ConnAckBuilder {
        private MqttConnectReturnCode returnCode;
        private boolean sessionPresent;

        ConnAckBuilder() {
        }

        public MqttConnAckMessage build() {
            return new MqttConnAckMessage(new MqttFixedHeader(MqttMessageType.CONNACK, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttConnAckVariableHeader(this.returnCode, this.sessionPresent));
        }

        public ConnAckBuilder returnCode(MqttConnectReturnCode mqttConnectReturnCode) {
            this.returnCode = mqttConnectReturnCode;
            return this;
        }

        public ConnAckBuilder sessionPresent(boolean z3) {
            this.sessionPresent = z3;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class ConnectBuilder {
        private boolean cleanSession;
        private String clientId;
        private boolean hasPassword;
        private boolean hasUser;
        private int keepAliveSecs;
        private byte[] password;
        private String username;
        private boolean willFlag;
        private byte[] willMessage;
        private boolean willRetain;
        private String willTopic;
        private MqttVersion version = MqttVersion.MQTT_3_1_1;
        private MqttQoS willQos = MqttQoS.AT_MOST_ONCE;

        ConnectBuilder() {
        }

        public MqttConnectMessage build() {
            return new MqttConnectMessage(new MqttFixedHeader(MqttMessageType.CONNECT, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttConnectVariableHeader(this.version.protocolName(), this.version.protocolLevel(), this.hasUser, this.hasPassword, this.willRetain, this.willQos.value(), this.willFlag, this.cleanSession, this.keepAliveSecs), new MqttConnectPayload(this.clientId, this.willTopic, this.willMessage, this.username, this.password));
        }

        public ConnectBuilder cleanSession(boolean z3) {
            this.cleanSession = z3;
            return this;
        }

        public ConnectBuilder clientId(String str) {
            this.clientId = str;
            return this;
        }

        public ConnectBuilder hasPassword(boolean z3) {
            this.hasPassword = z3;
            return this;
        }

        public ConnectBuilder hasUser(boolean z3) {
            this.hasUser = z3;
            return this;
        }

        public ConnectBuilder keepAlive(int i4) {
            this.keepAliveSecs = i4;
            return this;
        }

        @Deprecated
        public ConnectBuilder password(String str) {
            password(str == null ? null : str.getBytes(CharsetUtil.UTF_8));
            return this;
        }

        public ConnectBuilder protocolVersion(MqttVersion mqttVersion) {
            this.version = mqttVersion;
            return this;
        }

        public ConnectBuilder username(String str) {
            this.hasUser = str != null;
            this.username = str;
            return this;
        }

        public ConnectBuilder willFlag(boolean z3) {
            this.willFlag = z3;
            return this;
        }

        @Deprecated
        public ConnectBuilder willMessage(String str) {
            willMessage(str == null ? null : str.getBytes(CharsetUtil.UTF_8));
            return this;
        }

        public ConnectBuilder willQoS(MqttQoS mqttQoS) {
            this.willQos = mqttQoS;
            return this;
        }

        public ConnectBuilder willRetain(boolean z3) {
            this.willRetain = z3;
            return this;
        }

        public ConnectBuilder willTopic(String str) {
            this.willTopic = str;
            return this;
        }

        public ConnectBuilder password(byte[] bArr) {
            this.hasPassword = bArr != null;
            this.password = bArr;
            return this;
        }

        public ConnectBuilder willMessage(byte[] bArr) {
            this.willMessage = bArr;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class PublishBuilder {
        private int messageId;
        private ByteBuf payload;
        private MqttQoS qos;
        private boolean retained;
        private String topic;

        PublishBuilder() {
        }

        public MqttPublishMessage build() {
            return new MqttPublishMessage(new MqttFixedHeader(MqttMessageType.PUBLISH, false, this.qos, this.retained, 0), new MqttPublishVariableHeader(this.topic, this.messageId), Unpooled.buffer().writeBytes(this.payload));
        }

        public PublishBuilder messageId(int i4) {
            this.messageId = i4;
            return this;
        }

        public PublishBuilder payload(ByteBuf byteBuf) {
            this.payload = byteBuf;
            return this;
        }

        public PublishBuilder qos(MqttQoS mqttQoS) {
            this.qos = mqttQoS;
            return this;
        }

        public PublishBuilder retained(boolean z3) {
            this.retained = z3;
            return this;
        }

        public PublishBuilder topicName(String str) {
            this.topic = str;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class SubscribeBuilder {
        private int messageId;
        private List<MqttTopicSubscription> subscriptions;

        SubscribeBuilder() {
        }

        public SubscribeBuilder addSubscription(MqttQoS mqttQoS, String str) {
            if (this.subscriptions == null) {
                this.subscriptions = new ArrayList(5);
            }
            this.subscriptions.add(new MqttTopicSubscription(str, mqttQoS));
            return this;
        }

        public MqttSubscribeMessage build() {
            return new MqttSubscribeMessage(new MqttFixedHeader(MqttMessageType.SUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0), MqttMessageIdVariableHeader.from(this.messageId), new MqttSubscribePayload(this.subscriptions));
        }

        public SubscribeBuilder messageId(int i4) {
            this.messageId = i4;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class UnsubscribeBuilder {
        private int messageId;
        private List<String> topicFilters;

        UnsubscribeBuilder() {
        }

        public UnsubscribeBuilder addTopicFilter(String str) {
            if (this.topicFilters == null) {
                this.topicFilters = new ArrayList(5);
            }
            this.topicFilters.add(str);
            return this;
        }

        public MqttUnsubscribeMessage build() {
            return new MqttUnsubscribeMessage(new MqttFixedHeader(MqttMessageType.UNSUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0), MqttMessageIdVariableHeader.from(this.messageId), new MqttUnsubscribePayload(this.topicFilters));
        }

        public UnsubscribeBuilder messageId(int i4) {
            this.messageId = i4;
            return this;
        }
    }

    private MqttMessageBuilders() {
    }

    public static ConnAckBuilder connAck() {
        return new ConnAckBuilder();
    }

    public static ConnectBuilder connect() {
        return new ConnectBuilder();
    }

    public static PublishBuilder publish() {
        return new PublishBuilder();
    }

    public static SubscribeBuilder subscribe() {
        return new SubscribeBuilder();
    }

    public static UnsubscribeBuilder unsubscribe() {
        return new UnsubscribeBuilder();
    }
}

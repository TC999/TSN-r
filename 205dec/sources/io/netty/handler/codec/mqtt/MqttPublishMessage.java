package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.IllegalReferenceCountException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MqttPublishMessage extends MqttMessage implements ByteBufHolder {
    public MqttPublishMessage(MqttFixedHeader mqttFixedHeader, MqttPublishVariableHeader mqttPublishVariableHeader, ByteBuf byteBuf) {
        super(mqttFixedHeader, mqttPublishVariableHeader, byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        ByteBuf byteBuf = (ByteBuf) super.payload();
        if (byteBuf.refCnt() > 0) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(byteBuf.refCnt());
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return content().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return content().release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public ByteBuf payload() {
        return content();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        return content().release(i4);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage replace(ByteBuf byteBuf) {
        return new MqttPublishMessage(fixedHeader(), variableHeader(), byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public MqttPublishMessage retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.mqtt.MqttMessage
    public MqttPublishVariableHeader variableHeader() {
        return (MqttPublishVariableHeader) super.variableHeader();
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage retain() {
        content().retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage touch() {
        content().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage retain(int i4) {
        content().retain(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public MqttPublishMessage touch(Object obj) {
        content().touch(obj);
        return this;
    }
}

package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class MqttUnacceptableProtocolVersionException extends DecoderException {
    private static final long serialVersionUID = 4914652213232455749L;

    public MqttUnacceptableProtocolVersionException() {
    }

    public MqttUnacceptableProtocolVersionException(String str, Throwable th) {
        super(str, th);
    }

    public MqttUnacceptableProtocolVersionException(String str) {
        super(str);
    }

    public MqttUnacceptableProtocolVersionException(Throwable th) {
        super(th);
    }
}

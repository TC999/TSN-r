package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MqttDecoder extends ReplayingDecoder<DecoderState> {
    private static final int DEFAULT_MAX_BYTES_IN_MESSAGE = 8092;
    private int bytesRemainingInVariablePart;
    private final int maxBytesInMessage;
    private MqttFixedHeader mqttFixedHeader;
    private Object payload;
    private Object variableHeader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.mqtt.MqttDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138821 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;

        static {
            int[] iArr = new int[MqttMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = iArr;
            try {
                iArr[MqttMessageType.CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.CONNACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBSCRIBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.SUBACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.UNSUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBACK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBCOMP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBREL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PUBLISH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGREQ.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.PINGRESP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[MqttMessageType.DISCONNECT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr2 = new int[DecoderState.values().length];
            $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState = iArr2;
            try {
                iArr2[DecoderState.READ_FIXED_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.READ_VARIABLE_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.READ_PAYLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[DecoderState.BAD_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum DecoderState {
        READ_FIXED_HEADER,
        READ_VARIABLE_HEADER,
        READ_PAYLOAD,
        BAD_MESSAGE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Result<T> {
        private final int numberOfBytesConsumed;
        private final T value;

        Result(T t, int i) {
            this.value = t;
            this.numberOfBytesConsumed = i;
        }
    }

    public MqttDecoder() {
        this(DEFAULT_MAX_BYTES_IN_MESSAGE);
    }

    private static Result<String> decodeAsciiString(ByteBuf byteBuf) {
        Result<String> decodeString = decodeString(byteBuf, 0, Integer.MAX_VALUE);
        String str = (String) ((Result) decodeString).value;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return new Result<>(null, ((Result) decodeString).numberOfBytesConsumed);
            }
        }
        return new Result<>(str, ((Result) decodeString).numberOfBytesConsumed);
    }

    private static Result<MqttConnAckVariableHeader> decodeConnAckVariableHeader(ByteBuf byteBuf) {
        return new Result<>(new MqttConnAckVariableHeader(MqttConnectReturnCode.valueOf(byteBuf.readByte()), (byteBuf.readUnsignedByte() & 1) == 1), 2);
    }

    private static Result<MqttConnectPayload> decodeConnectionPayload(ByteBuf byteBuf, MqttConnectVariableHeader mqttConnectVariableHeader) {
        Result<String> result;
        Result<String> result2;
        Result<String> result3;
        Result<String> result4;
        Result<String> decodeString = decodeString(byteBuf);
        String str = (String) ((Result) decodeString).value;
        if (MqttCodecUtil.isValidClientId(MqttVersion.fromProtocolNameAndLevel(mqttConnectVariableHeader.name(), (byte) mqttConnectVariableHeader.version()), str)) {
            int i = ((Result) decodeString).numberOfBytesConsumed;
            if (mqttConnectVariableHeader.isWillFlag()) {
                result = decodeString(byteBuf, 0, 32767);
                int i2 = i + ((Result) result).numberOfBytesConsumed;
                result2 = decodeAsciiString(byteBuf);
                i = i2 + ((Result) result2).numberOfBytesConsumed;
            } else {
                result = null;
                result2 = null;
            }
            if (mqttConnectVariableHeader.hasUserName()) {
                result3 = decodeString(byteBuf);
                i += ((Result) result3).numberOfBytesConsumed;
            } else {
                result3 = null;
            }
            if (mqttConnectVariableHeader.hasPassword()) {
                result4 = decodeString(byteBuf);
                i += ((Result) result4).numberOfBytesConsumed;
            } else {
                result4 = null;
            }
            return new Result<>(new MqttConnectPayload((String) ((Result) decodeString).value, result != null ? (String) ((Result) result).value : null, result2 != null ? (String) ((Result) result2).value : null, result3 != null ? (String) ((Result) result3).value : null, result4 != null ? (String) ((Result) result4).value : null), i);
        }
        throw new MqttIdentifierRejectedException("invalid clientIdentifier: " + str);
    }

    private static Result<MqttConnectVariableHeader> decodeConnectionVariableHeader(ByteBuf byteBuf) {
        Result<String> decodeString = decodeString(byteBuf);
        int i = ((Result) decodeString).numberOfBytesConsumed;
        MqttVersion fromProtocolNameAndLevel = MqttVersion.fromProtocolNameAndLevel((String) ((Result) decodeString).value, byteBuf.readByte());
        short readUnsignedByte = byteBuf.readUnsignedByte();
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int i2 = i + 1 + 1 + ((Result) decodeMsbLsb).numberOfBytesConsumed;
        boolean z = (readUnsignedByte & 128) == 128;
        boolean z2 = (readUnsignedByte & 64) == 64;
        boolean z3 = (readUnsignedByte & 32) == 32;
        int i3 = (readUnsignedByte & 24) >> 3;
        boolean z4 = (readUnsignedByte & 4) == 4;
        boolean z5 = (readUnsignedByte & 2) == 2;
        if (fromProtocolNameAndLevel == MqttVersion.MQTT_3_1_1) {
            if (!((readUnsignedByte & 1) == 0)) {
                throw new DecoderException("non-zero reserved flag");
            }
        }
        return new Result<>(new MqttConnectVariableHeader(fromProtocolNameAndLevel.protocolName(), fromProtocolNameAndLevel.protocolLevel(), z, z2, z3, i3, z4, z5, ((Integer) ((Result) decodeMsbLsb).value).intValue()), i2);
    }

    private static MqttFixedHeader decodeFixedHeader(ByteBuf byteBuf) {
        int i;
        int i2;
        short readUnsignedByte = byteBuf.readUnsignedByte();
        MqttMessageType valueOf = MqttMessageType.valueOf(readUnsignedByte >> 4);
        int i3 = 0;
        boolean z = (readUnsignedByte & 8) == 8;
        int i4 = (readUnsignedByte & 6) >> 1;
        boolean z2 = (readUnsignedByte & 1) != 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            short readUnsignedByte2 = byteBuf.readUnsignedByte();
            i = ((readUnsignedByte2 & 127) * i6) + i3;
            i6 *= 128;
            i5++;
            i2 = readUnsignedByte2 & 128;
            if (i2 == 0 || i5 >= 4) {
                break;
            }
            i3 = i;
        }
        if (i5 == 4 && i2 != 0) {
            throw new DecoderException("remaining length exceeds 4 digits (" + valueOf + ')');
        }
        return MqttCodecUtil.validateFixedHeader(MqttCodecUtil.resetUnusedFields(new MqttFixedHeader(valueOf, z, MqttQoS.valueOf(i4), z2, i)));
    }

    private static Result<Integer> decodeMessageId(ByteBuf byteBuf) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        if (MqttCodecUtil.isValidMessageId(((Integer) ((Result) decodeMsbLsb).value).intValue())) {
            return decodeMsbLsb;
        }
        throw new DecoderException("invalid messageId: " + ((Result) decodeMsbLsb).value);
    }

    private static Result<MqttMessageIdVariableHeader> decodeMessageIdVariableHeader(ByteBuf byteBuf) {
        Result<Integer> decodeMessageId = decodeMessageId(byteBuf);
        return new Result<>(MqttMessageIdVariableHeader.from(((Integer) ((Result) decodeMessageId).value).intValue()), ((Result) decodeMessageId).numberOfBytesConsumed);
    }

    private static Result<Integer> decodeMsbLsb(ByteBuf byteBuf) {
        return decodeMsbLsb(byteBuf, 0, 65535);
    }

    private static Result<?> decodePayload(ByteBuf byteBuf, MqttMessageType mqttMessageType, int i, Object obj) {
        int i2 = C138821.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttMessageType.ordinal()];
        if (i2 != 1) {
            if (i2 != 11) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return new Result<>(null, 0);
                        }
                        return decodeSubackPayload(byteBuf, i);
                    }
                    return decodeUnsubscribePayload(byteBuf, i);
                }
                return decodeSubscribePayload(byteBuf, i);
            }
            return decodePublishPayload(byteBuf, i);
        }
        return decodeConnectionPayload(byteBuf, (MqttConnectVariableHeader) obj);
    }

    private static Result<ByteBuf> decodePublishPayload(ByteBuf byteBuf, int i) {
        return new Result<>(byteBuf.readRetainedSlice(i), i);
    }

    private static Result<MqttPublishVariableHeader> decodePublishVariableHeader(ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader) {
        Result<String> decodeString = decodeString(byteBuf);
        if (MqttCodecUtil.isValidPublishTopicName((String) ((Result) decodeString).value)) {
            int i = ((Result) decodeString).numberOfBytesConsumed;
            int i2 = -1;
            if (mqttFixedHeader.qosLevel().value() > 0) {
                Result<Integer> decodeMessageId = decodeMessageId(byteBuf);
                i2 = ((Integer) ((Result) decodeMessageId).value).intValue();
                i += ((Result) decodeMessageId).numberOfBytesConsumed;
            }
            return new Result<>(new MqttPublishVariableHeader((String) ((Result) decodeString).value, i2), i);
        }
        throw new DecoderException("invalid publish topic name: " + ((String) ((Result) decodeString).value) + " (contains wildcards)");
    }

    private static Result<String> decodeString(ByteBuf byteBuf) {
        return decodeString(byteBuf, 0, Integer.MAX_VALUE);
    }

    private static Result<MqttSubAckPayload> decodeSubackPayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            i2++;
            arrayList.add(Integer.valueOf(byteBuf.readUnsignedByte() & 3));
        }
        return new Result<>(new MqttSubAckPayload(arrayList), i2);
    }

    private static Result<MqttSubscribePayload> decodeSubscribePayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            Result<String> decodeString = decodeString(byteBuf);
            i2 = i2 + ((Result) decodeString).numberOfBytesConsumed + 1;
            arrayList.add(new MqttTopicSubscription((String) ((Result) decodeString).value, MqttQoS.valueOf(byteBuf.readUnsignedByte() & 3)));
        }
        return new Result<>(new MqttSubscribePayload(arrayList), i2);
    }

    private static Result<MqttUnsubscribePayload> decodeUnsubscribePayload(ByteBuf byteBuf, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            Result<String> decodeString = decodeString(byteBuf);
            i2 += ((Result) decodeString).numberOfBytesConsumed;
            arrayList.add(((Result) decodeString).value);
        }
        return new Result<>(new MqttUnsubscribePayload(arrayList), i2);
    }

    private static Result<?> decodeVariableHeader(ByteBuf byteBuf, MqttFixedHeader mqttFixedHeader) {
        switch (C138821.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()]) {
            case 1:
                return decodeConnectionVariableHeader(byteBuf);
            case 2:
                return decodeConnAckVariableHeader(byteBuf);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return decodeMessageIdVariableHeader(byteBuf);
            case 11:
                return decodePublishVariableHeader(byteBuf, mqttFixedHeader);
            case 12:
            case 13:
            case 14:
                return new Result<>(null, 0);
            default:
                return new Result<>(null, 0);
        }
    }

    private MqttMessage invalidMessage(Throwable th) {
        checkpoint(DecoderState.BAD_MESSAGE);
        return MqttMessageFactory.newInvalidMessage(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078 A[Catch: Exception -> 0x00be, TryCatch #0 {Exception -> 0x00be, blocks: (B:17:0x0059, B:19:0x0078, B:21:0x0092, B:22:0x00bd), top: B:31:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092 A[Catch: Exception -> 0x00be, TryCatch #0 {Exception -> 0x00be, blocks: (B:17:0x0059, B:19:0x0078, B:21:0x0092, B:22:0x00bd), top: B:31:0x0059 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            r2 = this;
            int[] r3 = io.netty.handler.codec.mqtt.MqttDecoder.C138821.$SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState
            java.lang.Object r0 = r2.state()
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r0 = (io.netty.handler.codec.mqtt.MqttDecoder.DecoderState) r0
            int r0 = r0.ordinal()
            r3 = r3[r0]
            r0 = 1
            if (r3 == r0) goto L28
            r0 = 2
            if (r3 == r0) goto L39
            r0 = 3
            if (r3 == r0) goto L59
            r5 = 4
            if (r3 != r5) goto L22
            int r3 = r2.actualReadableBytes()
            r4.skipBytes(r3)
            goto L91
        L22:
            java.lang.Error r3 = new java.lang.Error
            r3.<init>()
            throw r3
        L28:
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = decodeFixedHeader(r4)
            r2.mqttFixedHeader = r3
            int r3 = r3.remainingLength()
            r2.bytesRemainingInVariablePart = r3
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r3 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_VARIABLE_HEADER
            r2.checkpoint(r3)
        L39:
            int r3 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Le5
            int r0 = r2.maxBytesInMessage     // Catch: java.lang.Exception -> Le5
            if (r3 > r0) goto Lc7
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Le5
            io.netty.handler.codec.mqtt.MqttDecoder$Result r3 = decodeVariableHeader(r4, r3)     // Catch: java.lang.Exception -> Le5
            java.lang.Object r0 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$000(r3)     // Catch: java.lang.Exception -> Le5
            r2.variableHeader = r0     // Catch: java.lang.Exception -> Le5
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Le5
            int r3 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$100(r3)     // Catch: java.lang.Exception -> Le5
            int r0 = r0 - r3
            r2.bytesRemainingInVariablePart = r0     // Catch: java.lang.Exception -> Le5
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r3 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_PAYLOAD     // Catch: java.lang.Exception -> Le5
            r2.checkpoint(r3)     // Catch: java.lang.Exception -> Le5
        L59:
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Lbe
            io.netty.handler.codec.mqtt.MqttMessageType r3 = r3.messageType()     // Catch: java.lang.Exception -> Lbe
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Lbe
            java.lang.Object r1 = r2.variableHeader     // Catch: java.lang.Exception -> Lbe
            io.netty.handler.codec.mqtt.MqttDecoder$Result r3 = decodePayload(r4, r3, r0, r1)     // Catch: java.lang.Exception -> Lbe
            java.lang.Object r4 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$000(r3)     // Catch: java.lang.Exception -> Lbe
            r2.payload = r4     // Catch: java.lang.Exception -> Lbe
            int r4 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Lbe
            int r3 = io.netty.handler.codec.mqtt.MqttDecoder.Result.access$100(r3)     // Catch: java.lang.Exception -> Lbe
            int r4 = r4 - r3
            r2.bytesRemainingInVariablePart = r4     // Catch: java.lang.Exception -> Lbe
            if (r4 != 0) goto L92
            io.netty.handler.codec.mqtt.MqttDecoder$DecoderState r3 = io.netty.handler.codec.mqtt.MqttDecoder.DecoderState.READ_FIXED_HEADER     // Catch: java.lang.Exception -> Lbe
            r2.checkpoint(r3)     // Catch: java.lang.Exception -> Lbe
            io.netty.handler.codec.mqtt.MqttFixedHeader r3 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Lbe
            java.lang.Object r4 = r2.variableHeader     // Catch: java.lang.Exception -> Lbe
            java.lang.Object r0 = r2.payload     // Catch: java.lang.Exception -> Lbe
            io.netty.handler.codec.mqtt.MqttMessage r3 = io.netty.handler.codec.mqtt.MqttMessageFactory.newMessage(r3, r4, r0)     // Catch: java.lang.Exception -> Lbe
            r4 = 0
            r2.mqttFixedHeader = r4     // Catch: java.lang.Exception -> Lbe
            r2.variableHeader = r4     // Catch: java.lang.Exception -> Lbe
            r2.payload = r4     // Catch: java.lang.Exception -> Lbe
            r5.add(r3)     // Catch: java.lang.Exception -> Lbe
        L91:
            return
        L92:
            io.netty.handler.codec.DecoderException r3 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> Lbe
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbe
            r4.<init>()     // Catch: java.lang.Exception -> Lbe
            java.lang.String r0 = "non-zero remaining payload bytes: "
            r4.append(r0)     // Catch: java.lang.Exception -> Lbe
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Lbe
            r4.append(r0)     // Catch: java.lang.Exception -> Lbe
            java.lang.String r0 = " ("
            r4.append(r0)     // Catch: java.lang.Exception -> Lbe
            io.netty.handler.codec.mqtt.MqttFixedHeader r0 = r2.mqttFixedHeader     // Catch: java.lang.Exception -> Lbe
            io.netty.handler.codec.mqtt.MqttMessageType r0 = r0.messageType()     // Catch: java.lang.Exception -> Lbe
            r4.append(r0)     // Catch: java.lang.Exception -> Lbe
            r0 = 41
            r4.append(r0)     // Catch: java.lang.Exception -> Lbe
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lbe
            r3.<init>(r4)     // Catch: java.lang.Exception -> Lbe
            throw r3     // Catch: java.lang.Exception -> Lbe
        Lbe:
            r3 = move-exception
            io.netty.handler.codec.mqtt.MqttMessage r3 = r2.invalidMessage(r3)
            r5.add(r3)
            return
        Lc7:
            io.netty.handler.codec.DecoderException r3 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> Le5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le5
            r4.<init>()     // Catch: java.lang.Exception -> Le5
            java.lang.String r0 = "too large message: "
            r4.append(r0)     // Catch: java.lang.Exception -> Le5
            int r0 = r2.bytesRemainingInVariablePart     // Catch: java.lang.Exception -> Le5
            r4.append(r0)     // Catch: java.lang.Exception -> Le5
            java.lang.String r0 = " bytes"
            r4.append(r0)     // Catch: java.lang.Exception -> Le5
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Le5
            r3.<init>(r4)     // Catch: java.lang.Exception -> Le5
            throw r3     // Catch: java.lang.Exception -> Le5
        Le5:
            r3 = move-exception
            io.netty.handler.codec.mqtt.MqttMessage r3 = r2.invalidMessage(r3)
            r5.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public MqttDecoder(int i) {
        super(DecoderState.READ_FIXED_HEADER);
        this.maxBytesInMessage = i;
    }

    private static Result<Integer> decodeMsbLsb(ByteBuf byteBuf, int i, int i2) {
        int readUnsignedByte = byteBuf.readUnsignedByte() | (byteBuf.readUnsignedByte() << 8);
        return new Result<>(Integer.valueOf((readUnsignedByte < i || readUnsignedByte > i2) ? -1 : -1), 2);
    }

    private static Result<String> decodeString(ByteBuf byteBuf, int i, int i2) {
        Result<Integer> decodeMsbLsb = decodeMsbLsb(byteBuf);
        int intValue = ((Integer) ((Result) decodeMsbLsb).value).intValue();
        int i3 = ((Result) decodeMsbLsb).numberOfBytesConsumed;
        if (intValue >= i && intValue <= i2) {
            String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), intValue, CharsetUtil.UTF_8);
            byteBuf.skipBytes(intValue);
            return new Result<>(byteBuf2, i3 + intValue);
        }
        byteBuf.skipBytes(intValue);
        return new Result<>(null, i3 + intValue);
    }
}

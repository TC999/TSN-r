package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdyFrameDecoder {
    private final SpdyFrameDecoderDelegate delegate;
    private byte flags;
    private int length;
    private final int maxChunkSize;
    private int numSettings;
    private final int spdyVersion;
    private State state;
    private int streamId;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.spdy.SpdyFrameDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State = iArr;
            try {
                iArr[State.READ_COMMON_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_DATA_FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_STREAM_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_REPLY_FRAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_RST_STREAM_FRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTINGS_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_PING_FRAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_GOAWAY_FRAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADERS_FRAME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_WINDOW_UPDATE_FRAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADER_BLOCK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.DISCARD_FRAME.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.FRAME_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum State {
        READ_COMMON_HEADER,
        READ_DATA_FRAME,
        READ_SYN_STREAM_FRAME,
        READ_SYN_REPLY_FRAME,
        READ_RST_STREAM_FRAME,
        READ_SETTINGS_FRAME,
        READ_SETTING,
        READ_PING_FRAME,
        READ_GOAWAY_FRAME,
        READ_HEADERS_FRAME,
        READ_WINDOW_UPDATE_FRAME,
        READ_HEADER_BLOCK,
        DISCARD_FRAME,
        FRAME_ERROR
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate) {
        this(spdyVersion, spdyFrameDecoderDelegate, 8192);
    }

    private static State getNextState(int i4, int i5) {
        switch (i4) {
            case 0:
                return State.READ_DATA_FRAME;
            case 1:
                return State.READ_SYN_STREAM_FRAME;
            case 2:
                return State.READ_SYN_REPLY_FRAME;
            case 3:
                return State.READ_RST_STREAM_FRAME;
            case 4:
                return State.READ_SETTINGS_FRAME;
            case 5:
            default:
                if (i5 != 0) {
                    return State.DISCARD_FRAME;
                }
                return State.READ_COMMON_HEADER;
            case 6:
                return State.READ_PING_FRAME;
            case 7:
                return State.READ_GOAWAY_FRAME;
            case 8:
                return State.READ_HEADERS_FRAME;
            case 9:
                return State.READ_WINDOW_UPDATE_FRAME;
        }
    }

    private static boolean hasFlag(byte b4, byte b5) {
        return (b4 & b5) != 0;
    }

    private static boolean isValidFrameHeader(int i4, int i5, byte b4, int i6) {
        switch (i5) {
            case 0:
                return i4 != 0;
            case 1:
                return i6 >= 10;
            case 2:
                return i6 >= 4;
            case 3:
                return b4 == 0 && i6 == 8;
            case 4:
                return i6 >= 4;
            case 5:
            default:
                return true;
            case 6:
                return i6 == 4;
            case 7:
                return i6 == 8;
            case 8:
                return i6 >= 4;
            case 9:
                return i6 == 8;
        }
    }

    public void decode(ByteBuf byteBuf) {
        int i4;
        while (true) {
            int i5 = 0;
            r2 = false;
            boolean z3 = false;
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[this.state.ordinal()]) {
                case 1:
                    if (byteBuf.readableBytes() >= 8) {
                        int readerIndex = byteBuf.readerIndex();
                        int i6 = readerIndex + 4;
                        int i7 = readerIndex + 5;
                        byteBuf.skipBytes(8);
                        if ((byteBuf.getByte(readerIndex) & 128) != 0) {
                            i4 = SpdyCodecUtil.getUnsignedShort(byteBuf, readerIndex) & 32767;
                            int unsignedShort = SpdyCodecUtil.getUnsignedShort(byteBuf, readerIndex + 2);
                            this.streamId = 0;
                            i5 = unsignedShort;
                        } else {
                            i4 = this.spdyVersion;
                            this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, readerIndex);
                        }
                        this.flags = byteBuf.getByte(i6);
                        int unsignedMedium = SpdyCodecUtil.getUnsignedMedium(byteBuf, i7);
                        this.length = unsignedMedium;
                        if (i4 != this.spdyVersion) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SPDY Version");
                            break;
                        } else if (!isValidFrameHeader(this.streamId, i5, this.flags, unsignedMedium)) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid Frame Error");
                            break;
                        } else {
                            this.state = getNextState(i5, this.length);
                            break;
                        }
                    } else {
                        return;
                    }
                case 2:
                    int i8 = this.length;
                    if (i8 == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readDataFrame(this.streamId, hasFlag(this.flags, (byte) 1), Unpooled.buffer(0));
                        break;
                    } else {
                        int min = Math.min(this.maxChunkSize, i8);
                        if (byteBuf.readableBytes() >= min) {
                            ByteBuf buffer = byteBuf.alloc().buffer(min);
                            buffer.writeBytes(byteBuf, min);
                            int i9 = this.length - min;
                            this.length = i9;
                            if (i9 == 0) {
                                this.state = State.READ_COMMON_HEADER;
                            }
                            if (i9 == 0 && hasFlag(this.flags, (byte) 1)) {
                                z3 = true;
                            }
                            this.delegate.readDataFrame(this.streamId, z3, buffer);
                            break;
                        } else {
                            return;
                        }
                    }
                case 3:
                    if (byteBuf.readableBytes() >= 10) {
                        int readerIndex2 = byteBuf.readerIndex();
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, readerIndex2);
                        int unsignedInt = SpdyCodecUtil.getUnsignedInt(byteBuf, readerIndex2 + 4);
                        byte b4 = (byte) ((byteBuf.getByte(readerIndex2 + 8) >> 5) & 7);
                        boolean hasFlag = hasFlag(this.flags, (byte) 1);
                        boolean hasFlag2 = hasFlag(this.flags, (byte) 2);
                        byteBuf.skipBytes(10);
                        this.length -= 10;
                        int i10 = this.streamId;
                        if (i10 == 0) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SYN_STREAM Frame");
                            break;
                        } else {
                            this.state = State.READ_HEADER_BLOCK;
                            this.delegate.readSynStreamFrame(i10, unsignedInt, b4, hasFlag, hasFlag2);
                            break;
                        }
                    } else {
                        return;
                    }
                case 4:
                    if (byteBuf.readableBytes() >= 4) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        boolean hasFlag3 = hasFlag(this.flags, (byte) 1);
                        byteBuf.skipBytes(4);
                        this.length -= 4;
                        int i11 = this.streamId;
                        if (i11 == 0) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SYN_REPLY Frame");
                            break;
                        } else {
                            this.state = State.READ_HEADER_BLOCK;
                            this.delegate.readSynReplyFrame(i11, hasFlag3);
                            break;
                        }
                    } else {
                        return;
                    }
                case 5:
                    if (byteBuf.readableBytes() >= 8) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        byteBuf.skipBytes(8);
                        int i12 = this.streamId;
                        if (i12 != 0 && signedInt != 0) {
                            this.state = State.READ_COMMON_HEADER;
                            this.delegate.readRstStreamFrame(i12, signedInt);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid RST_STREAM Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 6:
                    if (byteBuf.readableBytes() >= 4) {
                        boolean hasFlag4 = hasFlag(this.flags, (byte) 1);
                        this.numSettings = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        byteBuf.skipBytes(4);
                        int i13 = this.length - 4;
                        this.length = i13;
                        if ((i13 & 7) == 0 && (i13 >> 3) == this.numSettings) {
                            this.state = State.READ_SETTING;
                            this.delegate.readSettingsFrame(hasFlag4);
                            break;
                        } else {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid SETTINGS Frame");
                            break;
                        }
                    } else {
                        return;
                    }
                case 7:
                    if (this.numSettings == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readSettingsEnd();
                        break;
                    } else if (byteBuf.readableBytes() >= 8) {
                        byte b5 = byteBuf.getByte(byteBuf.readerIndex());
                        int unsignedMedium2 = SpdyCodecUtil.getUnsignedMedium(byteBuf, byteBuf.readerIndex() + 1);
                        int signedInt2 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        boolean hasFlag5 = hasFlag(b5, (byte) 1);
                        boolean hasFlag6 = hasFlag(b5, (byte) 2);
                        byteBuf.skipBytes(8);
                        this.numSettings--;
                        this.delegate.readSetting(unsignedMedium2, signedInt2, hasFlag5, hasFlag6);
                        break;
                    } else {
                        return;
                    }
                case 8:
                    if (byteBuf.readableBytes() >= 4) {
                        int signedInt3 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
                        byteBuf.skipBytes(4);
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readPingFrame(signedInt3);
                        break;
                    } else {
                        return;
                    }
                case 9:
                    if (byteBuf.readableBytes() >= 8) {
                        int unsignedInt2 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        int signedInt4 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        byteBuf.skipBytes(8);
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readGoAwayFrame(unsignedInt2, signedInt4);
                        break;
                    } else {
                        return;
                    }
                case 10:
                    if (byteBuf.readableBytes() >= 4) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        boolean hasFlag7 = hasFlag(this.flags, (byte) 1);
                        byteBuf.skipBytes(4);
                        this.length -= 4;
                        int i14 = this.streamId;
                        if (i14 == 0) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid HEADERS Frame");
                            break;
                        } else {
                            this.state = State.READ_HEADER_BLOCK;
                            this.delegate.readHeadersFrame(i14, hasFlag7);
                            break;
                        }
                    } else {
                        return;
                    }
                case 11:
                    if (byteBuf.readableBytes() >= 8) {
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                        int unsignedInt3 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        byteBuf.skipBytes(8);
                        if (unsignedInt3 == 0) {
                            this.state = State.FRAME_ERROR;
                            this.delegate.readFrameError("Invalid WINDOW_UPDATE Frame");
                            break;
                        } else {
                            this.state = State.READ_COMMON_HEADER;
                            this.delegate.readWindowUpdateFrame(this.streamId, unsignedInt3);
                            break;
                        }
                    } else {
                        return;
                    }
                case 12:
                    if (this.length == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readHeaderBlockEnd();
                        break;
                    } else if (byteBuf.isReadable()) {
                        int min2 = Math.min(byteBuf.readableBytes(), this.length);
                        ByteBuf buffer2 = byteBuf.alloc().buffer(min2);
                        buffer2.writeBytes(byteBuf, min2);
                        this.length -= min2;
                        this.delegate.readHeaderBlock(buffer2);
                        break;
                    } else {
                        return;
                    }
                case 13:
                    int min3 = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(min3);
                    int i15 = this.length - min3;
                    this.length = i15;
                    if (i15 == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        break;
                    } else {
                        return;
                    }
                case 14:
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        }
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate, int i4) {
        if (spdyVersion == null) {
            throw new NullPointerException("spdyVersion");
        }
        if (spdyFrameDecoderDelegate == null) {
            throw new NullPointerException("delegate");
        }
        if (i4 > 0) {
            this.spdyVersion = spdyVersion.getVersion();
            this.delegate = spdyFrameDecoderDelegate;
            this.maxChunkSize = i4;
            this.state = State.READ_COMMON_HEADER;
            return;
        }
        throw new IllegalArgumentException("maxChunkSize must be a positive integer: " + i4);
    }
}

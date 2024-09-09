package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WebSocket08FrameDecoder extends ByteToMessageDecoder implements WebSocketFrameDecoder {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocket08FrameDecoder.class);
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final boolean expectMaskedFrames;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private boolean frameMasked;
    private int frameOpcode;
    private int framePayloadLen1;
    private long framePayloadLength;
    private int frameRsv;
    private byte[] maskingKey;
    private final long maxFramePayloadLength;
    private boolean receivedClosingHandshake;
    private State state;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State = iArr;
            try {
                iArr[State.READING_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.MASKING_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.PAYLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.CORRUPT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum State {
        READING_FIRST,
        READING_SECOND,
        READING_SIZE,
        MASKING_KEY,
        PAYLOAD,
        CORRUPT
    }

    public WebSocket08FrameDecoder(boolean z3, boolean z4, int i4) {
        this(z3, z4, i4, false);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, String str) {
        protocolViolation(channelHandlerContext, new CorruptedFrameException(str));
    }

    private static int toFrameLength(long j4) {
        if (j4 <= 2147483647L) {
            return (int) j4;
        }
        throw new TooLongFrameException("Length:" + j4);
    }

    private void unmask(ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        ByteOrder order = byteBuf.order();
        byte[] bArr = this.maskingKey;
        int i4 = (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        if (order == ByteOrder.LITTLE_ENDIAN) {
            i4 = Integer.reverseBytes(i4);
        }
        while (readerIndex + 3 < writerIndex) {
            byteBuf.setInt(readerIndex, byteBuf.getInt(readerIndex) ^ i4);
            readerIndex += 4;
        }
        while (readerIndex < writerIndex) {
            byteBuf.setByte(readerIndex, byteBuf.getByte(readerIndex) ^ this.maskingKey[readerIndex % 4]);
            readerIndex++;
        }
    }

    protected void checkCloseFrameBody(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (byteBuf == null || !byteBuf.isReadable()) {
            return;
        }
        if (byteBuf.readableBytes() == 1) {
            protocolViolation(channelHandlerContext, "Invalid close frame body");
        }
        int readerIndex = byteBuf.readerIndex();
        byteBuf.readerIndex(0);
        short readShort = byteBuf.readShort();
        if ((readShort >= 0 && readShort <= 999) || ((readShort >= 1004 && readShort <= 1006) || (readShort >= 1012 && readShort <= 2999))) {
            protocolViolation(channelHandlerContext, "Invalid close frame getStatus code: " + ((int) readShort));
        }
        if (byteBuf.isReadable()) {
            try {
                new Utf8Validator().check(byteBuf);
            } catch (CorruptedFrameException e4) {
                protocolViolation(channelHandlerContext, e4);
            }
        }
        byteBuf.readerIndex(readerIndex);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0179  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r18, io.netty.buffer.ByteBuf r19, java.util.List<java.lang.Object> r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public WebSocket08FrameDecoder(boolean z3, boolean z4, int i4, boolean z5) {
        this.state = State.READING_FIRST;
        this.expectMaskedFrames = z3;
        this.allowMaskMismatch = z5;
        this.allowExtensions = z4;
        this.maxFramePayloadLength = i4;
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, CorruptedFrameException corruptedFrameException) {
        Object closeWebSocketFrame;
        this.state = State.CORRUPT;
        if (channelHandlerContext.channel().isActive()) {
            if (this.receivedClosingHandshake) {
                closeWebSocketFrame = Unpooled.EMPTY_BUFFER;
            } else {
                closeWebSocketFrame = new CloseWebSocketFrame(1002, (String) null);
            }
            channelHandlerContext.writeAndFlush(closeWebSocketFrame).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        }
        throw corruptedFrameException;
    }
}

package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WebSocket08FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final int GATHERING_WRITE_THRESHOLD = 1024;
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocket08FrameEncoder.class);
    private final boolean maskPayload;

    public WebSocket08FrameEncoder(boolean z3) {
        this.maskPayload = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [io.netty.util.ReferenceCounted] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        int i4;
        ?? r4;
        boolean z3;
        int i5;
        ByteBuf buffer;
        ByteBuf content = webSocketFrame.content();
        int i6 = 0;
        if (webSocketFrame instanceof TextWebSocketFrame) {
            i4 = 1;
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            i4 = 9;
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            i4 = 10;
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            i4 = 8;
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            i4 = 2;
        } else if (!(webSocketFrame instanceof ContinuationWebSocketFrame)) {
            throw new UnsupportedOperationException("Cannot encode frame of type: " + webSocketFrame.getClass().getName());
        } else {
            i4 = 0;
        }
        int readableBytes = content.readableBytes();
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("Encoding WebSocket Frame opCode=" + i4 + " length=" + readableBytes);
        }
        int rsv = ((webSocketFrame.rsv() % 8) << 4) | (webSocketFrame.isFinalFragment() ? 128 : 0) | (i4 % 128);
        if (i4 == 9 && readableBytes > 125) {
            throw new TooLongFrameException("invalid payload for PING (payload length must be <= 125, was " + readableBytes);
        }
        try {
            z3 = this.maskPayload;
            i5 = z3 ? 4 : 0;
            r4 = 1024;
        } catch (Throwable th) {
            th = th;
            r4 = 0;
        }
        try {
            if (readableBytes <= 125) {
                int i7 = i5 + 2;
                if (z3 || readableBytes <= 1024) {
                    i7 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i7);
                buffer.writeByte(rsv);
                buffer.writeByte((byte) (this.maskPayload ? ((byte) readableBytes) | 128 : (byte) readableBytes));
            } else if (readableBytes <= 65535) {
                int i8 = i5 + 4;
                if (z3 || readableBytes <= 1024) {
                    i8 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i8);
                buffer.writeByte(rsv);
                buffer.writeByte(this.maskPayload ? 254 : 126);
                buffer.writeByte((readableBytes >>> 8) & 255);
                buffer.writeByte(readableBytes & 255);
            } else {
                int i9 = i5 + 10;
                if (z3 || readableBytes <= 1024) {
                    i9 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i9);
                buffer.writeByte(rsv);
                buffer.writeByte(this.maskPayload ? 255 : 127);
                buffer.writeLong(readableBytes);
            }
            if (this.maskPayload) {
                byte[] array = ByteBuffer.allocate(4).putInt((int) (Math.random() * 2.147483647E9d)).array();
                buffer.writeBytes(array);
                ByteOrder order = content.order();
                ByteOrder order2 = buffer.order();
                int readerIndex = content.readerIndex();
                int writerIndex = content.writerIndex();
                if (order == order2) {
                    int i10 = ((array[0] & 255) << 24) | ((array[1] & 255) << 16) | ((array[2] & 255) << 8) | (array[3] & 255);
                    if (order == ByteOrder.LITTLE_ENDIAN) {
                        i10 = Integer.reverseBytes(i10);
                    }
                    while (readerIndex + 3 < writerIndex) {
                        buffer.writeInt(content.getInt(readerIndex) ^ i10);
                        readerIndex += 4;
                    }
                }
                while (readerIndex < writerIndex) {
                    buffer.writeByte(content.getByte(readerIndex) ^ array[i6 % 4]);
                    readerIndex++;
                    i6++;
                }
                list.add(buffer);
            } else if (buffer.writableBytes() >= content.readableBytes()) {
                buffer.writeBytes(content);
                list.add(buffer);
            } else {
                list.add(buffer);
                list.add(content.retain());
            }
        } catch (Throwable th2) {
            th = th2;
            if (r4 != 0) {
                r4.release();
            }
            throw th;
        }
    }
}

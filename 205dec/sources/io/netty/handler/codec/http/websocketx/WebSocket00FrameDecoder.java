package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WebSocket00FrameDecoder extends ReplayingDecoder<Void> implements WebSocketFrameDecoder {
    static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    private final long maxFrameSize;
    private boolean receivedClosingHandshake;

    public WebSocket00FrameDecoder() {
        this(16384);
    }

    private WebSocketFrame decodeBinaryFrame(ChannelHandlerContext channelHandlerContext, byte b4, ByteBuf byteBuf) {
        byte readByte;
        int i4 = 0;
        long j4 = 0;
        do {
            readByte = byteBuf.readByte();
            j4 = (j4 << 7) | (readByte & Byte.MAX_VALUE);
            if (j4 > this.maxFrameSize) {
                throw new TooLongFrameException();
            }
            i4++;
            if (i4 > 8) {
                throw new TooLongFrameException();
            }
        } while ((readByte & 128) == 128);
        if (b4 == -1 && j4 == 0) {
            this.receivedClosingHandshake = true;
            return new CloseWebSocketFrame();
        }
        return new BinaryWebSocketFrame(ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, (int) j4));
    }

    private WebSocketFrame decodeTextFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int actualReadableBytes = actualReadableBytes();
        int indexOf = byteBuf.indexOf(readerIndex, readerIndex + actualReadableBytes, (byte) -1);
        if (indexOf == -1) {
            if (actualReadableBytes <= this.maxFrameSize) {
                return null;
            }
            throw new TooLongFrameException();
        }
        int i4 = indexOf - readerIndex;
        if (i4 <= this.maxFrameSize) {
            ByteBuf readBytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, i4);
            byteBuf.skipBytes(1);
            if (readBytes.indexOf(readBytes.readerIndex(), readBytes.writerIndex(), (byte) -1) < 0) {
                return new TextWebSocketFrame(readBytes);
            }
            readBytes.release();
            throw new IllegalArgumentException("a text frame should not contain 0xFF.");
        }
        throw new TooLongFrameException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        WebSocketFrame decodeTextFrame;
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        byte readByte = byteBuf.readByte();
        if ((readByte & 128) == 128) {
            decodeTextFrame = decodeBinaryFrame(channelHandlerContext, readByte, byteBuf);
        } else {
            decodeTextFrame = decodeTextFrame(channelHandlerContext, byteBuf);
        }
        if (decodeTextFrame != null) {
            list.add(decodeTextFrame);
        }
    }

    public WebSocket00FrameDecoder(int i4) {
        this.maxFrameSize = i4;
    }
}

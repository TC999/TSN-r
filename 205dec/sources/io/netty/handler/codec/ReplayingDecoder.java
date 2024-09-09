package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private int checkpoint;
    private final ReplayingDecoderByteBuf replayable;
    private S state;

    /* JADX INFO: Access modifiers changed from: protected */
    public ReplayingDecoder() {
        this(null);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i4;
        this.replayable.setCumulation(byteBuf);
        while (byteBuf.isReadable()) {
            try {
                int readerIndex = byteBuf.readerIndex();
                this.checkpoint = readerIndex;
                int size = list.size();
                if (size > 0) {
                    ByteToMessageDecoder.fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                    size = 0;
                }
                S s3 = this.state;
                int readableBytes = byteBuf.readableBytes();
                try {
                    decode(channelHandlerContext, this.replayable, list);
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                    if (size == list.size()) {
                        if (readableBytes == byteBuf.readableBytes() && s3 == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                        }
                    } else {
                        if (readerIndex == byteBuf.readerIndex() && s3 == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                        }
                        if (isSingleDecode()) {
                            return;
                        }
                    }
                } catch (Signal e4) {
                    e4.expect(REPLAY);
                    if (!channelHandlerContext.isRemoved() && (i4 = this.checkpoint) >= 0) {
                        byteBuf.readerIndex(i4);
                        return;
                    }
                    return;
                }
            } catch (DecoderException e5) {
                throw e5;
            } catch (Throwable th) {
                throw new DecoderException(th);
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    final void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        try {
            this.replayable.terminate();
            if (this.cumulation != null) {
                callDecode(channelHandlerContext, internalBuffer(), list);
                decodeLast(channelHandlerContext, this.replayable, list);
            } else {
                this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
                decodeLast(channelHandlerContext, this.replayable, list);
            }
        } catch (Signal e4) {
            e4.expect(REPLAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkpoint() {
        this.checkpoint = internalBuffer().readerIndex();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public S state() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReplayingDecoder(S s3) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = s3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkpoint(S s3) {
        checkpoint();
        state(s3);
    }

    protected S state(S s3) {
        S s4 = this.state;
        this.state = s3;
        return s4;
    }
}

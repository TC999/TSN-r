package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ByteToMessageCodec<I> extends ChannelDuplexHandler {
    private final ByteToMessageDecoder decoder;
    private final MessageToByteEncoder<I> encoder;
    private final TypeParameterMatcher outboundMsgMatcher;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Encoder extends MessageToByteEncoder<I> {
        Encoder(boolean z3) {
            super(z3);
        }

        @Override // io.netty.handler.codec.MessageToByteEncoder
        public boolean acceptOutboundMessage(Object obj) throws Exception {
            return ByteToMessageCodec.this.acceptOutboundMessage(obj);
        }

        @Override // io.netty.handler.codec.MessageToByteEncoder
        protected void encode(ChannelHandlerContext channelHandlerContext, I i4, ByteBuf byteBuf) throws Exception {
            ByteToMessageCodec.this.encode(channelHandlerContext, i4, byteBuf);
        }
    }

    protected ByteToMessageCodec() {
        this(true);
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.outboundMsgMatcher.match(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.decoder.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.decoder.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.decoder.channelReadComplete(channelHandlerContext);
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.isReadable()) {
            decode(channelHandlerContext, byteBuf, list);
        }
    }

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i4, ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.decoder.handlerAdded(channelHandlerContext);
        } finally {
            this.encoder.handlerAdded(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.decoder.handlerRemoved(channelHandlerContext);
        } finally {
            this.encoder.handlerRemoved(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        this.encoder.write(channelHandlerContext, obj, channelPromise);
    }

    protected ByteToMessageCodec(Class<? extends I> cls) {
        this(cls, true);
    }

    protected ByteToMessageCodec(boolean z3) {
        this.decoder = new ByteToMessageDecoder() { // from class: io.netty.handler.codec.ByteToMessageCodec.1
            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
                ByteToMessageCodec.this.decode(channelHandlerContext, byteBuf, list);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
                ByteToMessageCodec.this.decodeLast(channelHandlerContext, byteBuf, list);
            }
        };
        CodecUtil.ensureNotSharable(this);
        this.outboundMsgMatcher = TypeParameterMatcher.find(this, ByteToMessageCodec.class, "I");
        this.encoder = new Encoder(z3);
    }

    protected ByteToMessageCodec(Class<? extends I> cls, boolean z3) {
        this.decoder = new ByteToMessageDecoder() { // from class: io.netty.handler.codec.ByteToMessageCodec.1
            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
                ByteToMessageCodec.this.decode(channelHandlerContext, byteBuf, list);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
                ByteToMessageCodec.this.decodeLast(channelHandlerContext, byteBuf, list);
            }
        };
        CodecUtil.ensureNotSharable(this);
        this.outboundMsgMatcher = TypeParameterMatcher.get(cls);
        this.encoder = new Encoder(z3);
    }
}

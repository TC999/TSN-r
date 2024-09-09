package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.memcache.LastMemcacheContent;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class BinaryMemcacheClientCodec extends CombinedChannelDuplexHandler<BinaryMemcacheResponseDecoder, BinaryMemcacheRequestEncoder> {
    private final boolean failOnMissingResponse;
    private final AtomicLong requestResponseCounter;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Decoder extends BinaryMemcacheResponseDecoder {
        Decoder(int i4) {
            super(i4);
        }

        @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder, io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse) {
                long j4 = BinaryMemcacheClientCodec.this.requestResponseCounter.get();
                if (j4 > 0) {
                    channelHandlerContext.fireExceptionCaught((Throwable) new PrematureChannelClosureException("channel gone inactive with " + j4 + " missing response(s)"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder, io.netty.handler.codec.ByteToMessageDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    if (list.get(size2) instanceof LastMemcacheContent) {
                        BinaryMemcacheClientCodec.this.requestResponseCounter.decrementAndGet();
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Encoder extends BinaryMemcacheRequestEncoder {
        private Encoder() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
        public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            super.encode(channelHandlerContext, obj, list);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse && (obj instanceof LastMemcacheContent)) {
                BinaryMemcacheClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public BinaryMemcacheClientCodec() {
        this(8192);
    }

    public BinaryMemcacheClientCodec(int i4) {
        this(i4, false);
    }

    public BinaryMemcacheClientCodec(int i4, boolean z3) {
        this.requestResponseCounter = new AtomicLong();
        this.failOnMissingResponse = z3;
        init(new Decoder(i4), new Encoder());
    }
}

package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HttpClientCodec extends CombinedChannelDuplexHandler<HttpResponseDecoder, HttpRequestEncoder> implements HttpClientUpgradeHandler.SourceCodec {
    private boolean done;
    private final boolean failOnMissingResponse;
    private final Queue<HttpMethod> queue;
    private final AtomicLong requestResponseCounter;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Encoder extends HttpRequestEncoder {
        boolean upgraded;

        private Encoder() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
        public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            if (this.upgraded) {
                list.add(ReferenceCountUtil.retain(obj));
                return;
            }
            if ((obj instanceof HttpRequest) && !HttpClientCodec.this.done) {
                HttpClientCodec.this.queue.offer(((HttpRequest) obj).method());
            }
            super.encode(channelHandlerContext, obj, list);
            if (HttpClientCodec.this.failOnMissingResponse && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public HttpClientCodec() {
        this(4096, 8192, 8192, false);
    }

    public boolean isSingleDecode() {
        return inboundHandler().isSingleDecode();
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.SourceCodec
    public void prepareUpgradeFrom(ChannelHandlerContext channelHandlerContext) {
        ((Encoder) outboundHandler()).upgraded = true;
    }

    public void setSingleDecode(boolean z3) {
        inboundHandler().setSingleDecode(z3);
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Decoder extends HttpResponseDecoder {
        Decoder(int i4, int i5, int i6, boolean z3) {
            super(i4, i5, i6, z3);
        }

        private void decrement(Object obj) {
            if (obj != null && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.decrementAndGet();
            }
        }

        @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (HttpClientCodec.this.failOnMissingResponse) {
                long j4 = HttpClientCodec.this.requestResponseCounter.get();
                if (j4 > 0) {
                    channelHandlerContext.fireExceptionCaught((Throwable) new PrematureChannelClosureException("channel gone inactive with " + j4 + " missing response(s)"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            if (HttpClientCodec.this.done) {
                int actualReadableBytes = actualReadableBytes();
                if (actualReadableBytes == 0) {
                    return;
                }
                list.add(byteBuf.readBytes(actualReadableBytes));
                return;
            }
            super.decode(channelHandlerContext, byteBuf, list);
            if (HttpClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    decrement(list.get(size2));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http.HttpObjectDecoder
        public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
            int code = ((HttpResponse) httpMessage).status().code();
            if (code == 100) {
                return true;
            }
            HttpMethod httpMethod = (HttpMethod) HttpClientCodec.this.queue.poll();
            char charAt = httpMethod.name().charAt(0);
            if (charAt != 'C') {
                if (charAt == 'H' && HttpMethod.HEAD.equals(httpMethod)) {
                    return true;
                }
            } else if (code == 200 && HttpMethod.CONNECT.equals(httpMethod)) {
                HttpClientCodec.this.done = true;
                HttpClientCodec.this.queue.clear();
                return true;
            }
            return super.isContentAlwaysEmpty(httpMessage);
        }

        Decoder(int i4, int i5, int i6, boolean z3, int i7) {
            super(i4, i5, i6, z3, i7);
        }
    }

    public HttpClientCodec(int i4, int i5, int i6) {
        this(i4, i5, i6, false);
    }

    public HttpClientCodec(int i4, int i5, int i6, boolean z3) {
        this(i4, i5, i6, z3, true);
    }

    public HttpClientCodec(int i4, int i5, int i6, boolean z3, boolean z4) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i4, i5, i6, z4), new Encoder());
        this.failOnMissingResponse = z3;
    }

    public HttpClientCodec(int i4, int i5, int i6, boolean z3, boolean z4, int i7) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i4, i5, i6, z4, i7), new Encoder());
        this.failOnMissingResponse = z3;
    }
}

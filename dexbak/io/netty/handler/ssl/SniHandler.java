package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.util.AsyncMapping;
import io.netty.util.CharsetUtil;
import io.netty.util.DomainNameMapping;
import io.netty.util.Mapping;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.SocketAddress;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLEngine;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SniHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    private static final int MAX_SSL_RECORDS = 4;
    private boolean handshakeFailed;
    private final AsyncMapping<String, SslContext> mapping;
    private boolean readPending;
    private volatile Selection selection;
    private boolean suppressRead;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SniHandler.class);
    private static final Selection EMPTY_SELECTION = new Selection(null, null);

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class AsyncMappingAdapter implements AsyncMapping<String, SslContext> {
        private final Mapping<? super String, ? extends SslContext> mapping;

        private AsyncMappingAdapter(Mapping<? super String, ? extends SslContext> mapping) {
            this.mapping = (Mapping) ObjectUtil.checkNotNull(mapping, "mapping");
        }

        @Override // io.netty.util.AsyncMapping
        public Future<SslContext> map(String str, Promise<SslContext> promise) {
            try {
                return promise.setSuccess(this.mapping.map(str));
            } catch (Throwable th) {
                return promise.setFailure(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Selection {
        final SslContext context;
        final String hostname;

        Selection(SslContext sslContext, String str) {
            this.context = sslContext;
            this.hostname = str;
        }
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping) {
        this(new AsyncMappingAdapter(mapping));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceHandler(ChannelHandlerContext channelHandlerContext, Selection selection) {
        this.selection = selection;
        SSLEngine sSLEngine = null;
        try {
            sSLEngine = selection.context.newEngine(channelHandlerContext.alloc());
            channelHandlerContext.pipeline().replace(this, SslHandler.class.getName(), SslContext.newHandler(sSLEngine));
        } catch (Throwable th) {
            this.selection = EMPTY_SELECTION;
            ReferenceCountUtil.safeRelease(sSLEngine);
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private void select(final ChannelHandlerContext channelHandlerContext, final String str) {
        Future<SslContext> map = this.mapping.map(str, channelHandlerContext.executor().newPromise());
        if (map.isDone()) {
            if (map.isSuccess()) {
                replaceHandler(channelHandlerContext, new Selection(map.getNow(), str));
                return;
            }
            throw new DecoderException("failed to get the SslContext for " + str, map.cause());
        }
        this.suppressRead = true;
        map.addListener(new FutureListener<SslContext>() { // from class: io.netty.handler.ssl.SniHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<SslContext> future) throws Exception {
                try {
                    SniHandler.this.suppressRead = false;
                    if (future.isSuccess()) {
                        SniHandler.this.replaceHandler(channelHandlerContext, new Selection(future.getNow(), str));
                    } else {
                        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                        channelHandlerContext2.fireExceptionCaught((Throwable) new DecoderException("failed to get the SslContext for " + str, future.cause()));
                    }
                } finally {
                    if (SniHandler.this.readPending) {
                        SniHandler.this.readPending = false;
                        channelHandlerContext.read();
                    }
                }
            }
        });
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.suppressRead || this.handshakeFailed) {
            return;
        }
        int writerIndex = byteBuf.writerIndex();
        int i = 0;
        while (true) {
            if (i < 4) {
                try {
                    int readerIndex = byteBuf.readerIndex();
                    int i2 = writerIndex - readerIndex;
                    if (i2 >= 5) {
                        switch (byteBuf.getUnsignedByte(readerIndex)) {
                            case 20:
                            case 21:
                                int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, readerIndex);
                                if (encryptedPacketLength == -1) {
                                    this.handshakeFailed = true;
                                    NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
                                    byteBuf.skipBytes(byteBuf.readableBytes());
                                    channelHandlerContext.fireExceptionCaught((Throwable) notSslRecordException);
                                    SslUtils.notifyHandshakeFailure(channelHandlerContext, notSslRecordException);
                                    return;
                                } else if (i2 - 5 < encryptedPacketLength) {
                                    return;
                                } else {
                                    byteBuf.skipBytes(encryptedPacketLength);
                                    i++;
                                }
                            case 22:
                                if (byteBuf.getUnsignedByte(readerIndex + 1) == 3) {
                                    int unsignedShort = byteBuf.getUnsignedShort(readerIndex + 3) + 5;
                                    if (i2 >= unsignedShort) {
                                        int i3 = unsignedShort + readerIndex;
                                        int i4 = readerIndex + 43;
                                        if (i3 - i4 >= 6) {
                                            int unsignedByte = i4 + byteBuf.getUnsignedByte(i4) + 1;
                                            int unsignedShort2 = unsignedByte + byteBuf.getUnsignedShort(unsignedByte) + 2;
                                            int unsignedByte2 = unsignedShort2 + byteBuf.getUnsignedByte(unsignedShort2) + 1;
                                            int unsignedShort3 = byteBuf.getUnsignedShort(unsignedByte2);
                                            int i5 = unsignedByte2 + 2;
                                            int i6 = unsignedShort3 + i5;
                                            if (i6 <= i3) {
                                                while (true) {
                                                    if (i6 - i5 >= 4) {
                                                        int unsignedShort4 = byteBuf.getUnsignedShort(i5);
                                                        int i7 = i5 + 2;
                                                        int unsignedShort5 = byteBuf.getUnsignedShort(i7);
                                                        int i8 = i7 + 2;
                                                        if (i6 - i8 < unsignedShort5) {
                                                            break;
                                                        } else if (unsignedShort4 == 0) {
                                                            int i9 = i8 + 2;
                                                            if (i6 - i9 < 3) {
                                                                break;
                                                            } else {
                                                                short unsignedByte3 = byteBuf.getUnsignedByte(i9);
                                                                int i10 = i9 + 1;
                                                                if (unsignedByte3 == 0) {
                                                                    int unsignedShort6 = byteBuf.getUnsignedShort(i10);
                                                                    int i11 = i10 + 2;
                                                                    if (i6 - i11 >= unsignedShort6) {
                                                                        select(channelHandlerContext, IDN.toASCII(byteBuf.toString(i11, unsignedShort6, CharsetUtil.UTF_8), 1).toLowerCase(Locale.US));
                                                                        return;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            i5 = i8 + unsignedShort5;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                break;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Unexpected client hello packet: " + ByteBufUtil.hexDump(byteBuf), th);
                    }
                }
            }
        }
        select(channelHandlerContext, null);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    public String hostname() {
        return this.selection.hostname;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.suppressRead) {
            this.readPending = true;
        } else {
            channelHandlerContext.read();
        }
    }

    public SslContext sslContext() {
        return this.selection.context;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }

    public SniHandler(DomainNameMapping<? extends SslContext> domainNameMapping) {
        this((Mapping<? super String, ? extends SslContext>) domainNameMapping);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping) {
        this.selection = EMPTY_SELECTION;
        this.mapping = (AsyncMapping) ObjectUtil.checkNotNull(asyncMapping, "mapping");
    }
}

package io.netty.handler.codec.http2;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http2.HttpConversionUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpToHttp2ConnectionHandler extends Http2ConnectionHandler {
    private int currentStreamId;
    private final boolean validateHeaders;

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.validateHeaders = z;
    }

    private int getStreamId(HttpHeaders httpHeaders) throws Exception {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ae, code lost:
        if (r14 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bd, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[Catch: all -> 0x00ab, TRY_LEAVE, TryCatch #1 {all -> 0x00ab, blocks: (B:32:0x0089, B:34:0x009b), top: B:53:0x0089 }] */
    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(io.netty.channel.ChannelHandlerContext r12, java.lang.Object r13, io.netty.channel.ChannelPromise r14) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof io.netty.handler.codec.http.HttpMessage
            if (r0 != 0) goto Lc
            boolean r0 = r13 instanceof io.netty.handler.codec.http.HttpContent
            if (r0 != 0) goto Lc
            r12.write(r13, r14)
            return
        Lc:
            io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator r0 = new io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator
            io.netty.channel.Channel r1 = r12.channel()
            io.netty.util.concurrent.EventExecutor r2 = r12.executor()
            r0.<init>(r14, r1, r2)
            r14 = 1
            r1 = 0
            io.netty.handler.codec.http2.Http2ConnectionEncoder r9 = r11.encoder()     // Catch: java.lang.Throwable -> Lb1
            boolean r2 = r13 instanceof io.netty.handler.codec.http.HttpMessage     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L58
            r2 = r13
            io.netty.handler.codec.http.HttpMessage r2 = (io.netty.handler.codec.http.HttpMessage) r2     // Catch: java.lang.Throwable -> Lb1
            io.netty.handler.codec.http.HttpHeaders r3 = r2.headers()     // Catch: java.lang.Throwable -> Lb1
            int r3 = r11.getStreamId(r3)     // Catch: java.lang.Throwable -> Lb1
            r11.currentStreamId = r3     // Catch: java.lang.Throwable -> Lb1
            boolean r3 = r11.validateHeaders     // Catch: java.lang.Throwable -> Lb1
            io.netty.handler.codec.http2.Http2Headers r5 = io.netty.handler.codec.http2.HttpConversionUtil.toHttp2Headers(r2, r3)     // Catch: java.lang.Throwable -> Lb1
            boolean r2 = r13 instanceof io.netty.handler.codec.http.FullHttpMessage     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L49
            r2 = r13
            io.netty.handler.codec.http.FullHttpMessage r2 = (io.netty.handler.codec.http.FullHttpMessage) r2     // Catch: java.lang.Throwable -> Lb1
            io.netty.buffer.ByteBuf r2 = r2.content()     // Catch: java.lang.Throwable -> Lb1
            boolean r2 = r2.isReadable()     // Catch: java.lang.Throwable -> Lb1
            if (r2 != 0) goto L49
            r10 = 1
            goto L4a
        L49:
            r10 = 0
        L4a:
            int r4 = r11.currentStreamId     // Catch: java.lang.Throwable -> Lb1
            r6 = 0
            io.netty.channel.ChannelPromise r8 = r0.newPromise()     // Catch: java.lang.Throwable -> Lb1
            r2 = r9
            r3 = r12
            r7 = r10
            r2.writeHeaders(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb1
            goto L59
        L58:
            r10 = 0
        L59:
            if (r10 != 0) goto Lae
            boolean r2 = r13 instanceof io.netty.handler.codec.http.HttpContent     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto Lae
            io.netty.handler.codec.http2.EmptyHttp2Headers r2 = io.netty.handler.codec.http2.EmptyHttp2Headers.INSTANCE     // Catch: java.lang.Throwable -> Lb1
            boolean r3 = r13 instanceof io.netty.handler.codec.http.LastHttpContent     // Catch: java.lang.Throwable -> Lb1
            if (r3 == 0) goto L75
            r2 = r13
            io.netty.handler.codec.http.LastHttpContent r2 = (io.netty.handler.codec.http.LastHttpContent) r2     // Catch: java.lang.Throwable -> Lb1
            io.netty.handler.codec.http.HttpHeaders r2 = r2.trailingHeaders()     // Catch: java.lang.Throwable -> Lb1
            boolean r3 = r11.validateHeaders     // Catch: java.lang.Throwable -> Lb1
            io.netty.handler.codec.http2.Http2Headers r2 = io.netty.handler.codec.http2.HttpConversionUtil.toHttp2Headers(r2, r3)     // Catch: java.lang.Throwable -> Lb1
            r10 = r2
            r2 = 1
            goto L77
        L75:
            r10 = r2
            r2 = 0
        L77:
            r3 = r13
            io.netty.handler.codec.http.HttpContent r3 = (io.netty.handler.codec.http.HttpContent) r3     // Catch: java.lang.Throwable -> Lb1
            io.netty.buffer.ByteBuf r5 = r3.content()     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L88
            boolean r2 = r10.isEmpty()     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L88
            r7 = 1
            goto L89
        L88:
            r7 = 0
        L89:
            int r4 = r11.currentStreamId     // Catch: java.lang.Throwable -> Lab
            r6 = 0
            io.netty.channel.ChannelPromise r8 = r0.newPromise()     // Catch: java.lang.Throwable -> Lab
            r2 = r9
            r3 = r12
            r2.writeData(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lab
            boolean r14 = r10.isEmpty()     // Catch: java.lang.Throwable -> Lab
            if (r14 != 0) goto La9
            int r4 = r11.currentStreamId     // Catch: java.lang.Throwable -> Lab
            r6 = 0
            r7 = 1
            io.netty.channel.ChannelPromise r8 = r0.newPromise()     // Catch: java.lang.Throwable -> Lab
            r2 = r9
            r3 = r12
            r5 = r10
            r2.writeHeaders(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lab
        La9:
            r14 = 0
            goto Lae
        Lab:
            r12 = move-exception
            r14 = 0
            goto Lb2
        Lae:
            if (r14 == 0) goto Lba
            goto Lb7
        Lb1:
            r12 = move-exception
        Lb2:
            r0.setFailure(r12)     // Catch: java.lang.Throwable -> Lbe
            if (r14 == 0) goto Lba
        Lb7:
            io.netty.util.ReferenceCountUtil.release(r13)
        Lba:
            r0.doneAllocatingPromises()
            return
        Lbe:
            r12 = move-exception
            if (r14 == 0) goto Lc4
            io.netty.util.ReferenceCountUtil.release(r13)
        Lc4:
            r0.doneAllocatingPromises()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HttpToHttp2ConnectionHandler.write(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.channel.ChannelPromise):void");
    }
}

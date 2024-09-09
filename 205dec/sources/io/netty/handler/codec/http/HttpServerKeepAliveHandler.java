package io.netty.handler.codec.http;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class HttpServerKeepAliveHandler extends ChannelDuplexHandler {
    private static final String MULTIPART_PREFIX = "multipart";
    private int pendingResponses;
    private boolean persistentConnection = true;

    private static boolean isInformational(HttpResponse httpResponse) {
        return httpResponse.status().codeClass() == HttpStatusClass.INFORMATIONAL;
    }

    private static boolean isMultipart(HttpResponse httpResponse) {
        String str = httpResponse.headers().get(HttpHeaderNames.CONTENT_TYPE);
        return str != null && str.regionMatches(true, 0, MULTIPART_PREFIX, 0, 9);
    }

    private static boolean isSelfDefinedMessageLength(HttpResponse httpResponse) {
        return HttpUtil.isContentLengthSet(httpResponse) || HttpUtil.isTransferEncodingChunked(httpResponse) || isMultipart(httpResponse) || isInformational(httpResponse) || httpResponse.status().code() == HttpResponseStatus.NO_CONTENT.code();
    }

    private boolean shouldKeepAlive() {
        return this.pendingResponses != 0 || this.persistentConnection;
    }

    private void trackResponse(HttpResponse httpResponse) {
        if (isInformational(httpResponse)) {
            return;
        }
        this.pendingResponses--;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (this.persistentConnection) {
                this.pendingResponses++;
                this.persistentConnection = HttpUtil.isKeepAlive(httpRequest);
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            trackResponse(httpResponse);
            if (!HttpUtil.isKeepAlive(httpResponse) || !isSelfDefinedMessageLength(httpResponse)) {
                this.pendingResponses = 0;
                this.persistentConnection = false;
            }
            if (!shouldKeepAlive()) {
                HttpUtil.setKeepAlive(httpResponse, false);
            }
        }
        ChannelPromise channelPromise2 = channelPromise;
        if (obj instanceof LastHttpContent) {
            channelPromise2 = channelPromise;
            if (!shouldKeepAlive()) {
                channelPromise2 = channelPromise.unvoid().addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            }
        }
        super.write(channelHandlerContext, obj, channelPromise2);
    }
}

package io.netty.handler.codec.http.cors;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CorsHandler extends ChannelDuplexHandler {
    private static final String ANY_ORIGIN = "*";
    private static final String NULL_ORIGIN = "null";
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CorsHandler.class);
    private final CorsConfig config;
    private HttpRequest request;

    public CorsHandler(CorsConfig corsConfig) {
        this.config = (CorsConfig) ObjectUtil.checkNotNull(corsConfig, "config");
    }

    private void echoRequestOrigin(HttpResponse httpResponse) {
        setOrigin(httpResponse, this.request.headers().get(HttpHeaderNames.ORIGIN));
    }

    private static void forbidden(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        channelHandlerContext.writeAndFlush(new DefaultFullHttpResponse(httpRequest.protocolVersion(), HttpResponseStatus.FORBIDDEN)).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        ReferenceCountUtil.release(httpRequest);
    }

    private void handlePreflight(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(httpRequest.protocolVersion(), HttpResponseStatus.f40230OK, true, true);
        if (setOrigin(defaultFullHttpResponse)) {
            setAllowMethods(defaultFullHttpResponse);
            setAllowHeaders(defaultFullHttpResponse);
            setAllowCredentials(defaultFullHttpResponse);
            setMaxAge(defaultFullHttpResponse);
            setPreflightHeaders(defaultFullHttpResponse);
        }
        ReferenceCountUtil.release(httpRequest);
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
    }

    private static boolean isPreflightRequest(HttpRequest httpRequest) {
        HttpHeaders headers = httpRequest.headers();
        return httpRequest.method().equals(HttpMethod.OPTIONS) && headers.contains(HttpHeaderNames.ORIGIN) && headers.contains(HttpHeaderNames.ACCESS_CONTROL_REQUEST_METHOD);
    }

    private void setAllowCredentials(HttpResponse httpResponse) {
        if (!this.config.isCredentialsAllowed() || httpResponse.headers().get(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN).equals("*")) {
            return;
        }
        httpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
    }

    private void setAllowHeaders(HttpResponse httpResponse) {
        httpResponse.headers().set((CharSequence) HttpHeaderNames.ACCESS_CONTROL_ALLOW_HEADERS, (Iterable<?>) this.config.allowedRequestHeaders());
    }

    private void setAllowMethods(HttpResponse httpResponse) {
        httpResponse.headers().set((CharSequence) HttpHeaderNames.ACCESS_CONTROL_ALLOW_METHODS, (Iterable<?>) this.config.allowedRequestMethods());
    }

    private static void setAnyOrigin(HttpResponse httpResponse) {
        setOrigin(httpResponse, "*");
    }

    private void setExposeHeaders(HttpResponse httpResponse) {
        if (this.config.exposedHeaders().isEmpty()) {
            return;
        }
        httpResponse.headers().set((CharSequence) HttpHeaderNames.ACCESS_CONTROL_EXPOSE_HEADERS, (Iterable<?>) this.config.exposedHeaders());
    }

    private void setMaxAge(HttpResponse httpResponse) {
        httpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_MAX_AGE, Long.valueOf(this.config.maxAge()));
    }

    private static void setNullOrigin(HttpResponse httpResponse) {
        setOrigin(httpResponse, NULL_ORIGIN);
    }

    private boolean setOrigin(HttpResponse httpResponse) {
        String str = this.request.headers().get(HttpHeaderNames.ORIGIN);
        if (str != null) {
            if (NULL_ORIGIN.equals(str) && this.config.isNullOriginAllowed()) {
                setNullOrigin(httpResponse);
                return true;
            } else if (this.config.isAnyOriginSupported()) {
                if (this.config.isCredentialsAllowed()) {
                    echoRequestOrigin(httpResponse);
                    setVaryHeader(httpResponse);
                } else {
                    setAnyOrigin(httpResponse);
                }
                return true;
            } else if (this.config.origins().contains(str)) {
                setOrigin(httpResponse, str);
                setVaryHeader(httpResponse);
                return true;
            } else {
                logger.debug("Request origin [{}]] was not among the configured origins [{}]", str, this.config.origins());
                return false;
            }
        }
        return false;
    }

    private void setPreflightHeaders(HttpResponse httpResponse) {
        httpResponse.headers().add(this.config.preflightResponseHeaders());
    }

    private static void setVaryHeader(HttpResponse httpResponse) {
        httpResponse.headers().set(HttpHeaderNames.VARY, HttpHeaderNames.ORIGIN);
    }

    private boolean validateOrigin() {
        String str;
        if (this.config.isAnyOriginSupported() || (str = this.request.headers().get(HttpHeaderNames.ORIGIN)) == null) {
            return true;
        }
        if (NULL_ORIGIN.equals(str) && this.config.isNullOriginAllowed()) {
            return true;
        }
        return this.config.origins().contains(str);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.config.isCorsSupportEnabled() && (obj instanceof HttpRequest)) {
            HttpRequest httpRequest = (HttpRequest) obj;
            this.request = httpRequest;
            if (isPreflightRequest(httpRequest)) {
                handlePreflight(channelHandlerContext, this.request);
                return;
            } else if (this.config.isShortCircuit() && !validateOrigin()) {
                forbidden(channelHandlerContext, this.request);
                return;
            }
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.config.isCorsSupportEnabled() && (obj instanceof HttpResponse)) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (setOrigin(httpResponse)) {
                setAllowCredentials(httpResponse);
                setExposeHeaders(httpResponse);
            }
        }
        channelHandlerContext.writeAndFlush(obj, channelPromise);
    }

    private static void setOrigin(HttpResponse httpResponse, String str) {
        httpResponse.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, str);
    }
}

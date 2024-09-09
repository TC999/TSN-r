package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class HttpContentDecoder extends MessageToMessageDecoder<HttpObject> {
    static final String IDENTITY = HttpHeaderValues.IDENTITY.toString();
    private boolean continueResponse;
    protected ChannelHandlerContext ctx;
    private EmbeddedChannel decoder;

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            if (embeddedChannel.finish()) {
                while (true) {
                    ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
                    if (byteBuf == null) {
                        break;
                    }
                    byteBuf.release();
                }
            }
            this.decoder = null;
        }
    }

    private void decodeContent(HttpContent httpContent, List<Object> list) {
        decode(httpContent.content(), list);
        if (httpContent instanceof LastHttpContent) {
            finishDecode(list);
            HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
            if (trailingHeaders.isEmpty()) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            } else {
                list.add(new ComposedLastHttpContent(trailingHeaders));
            }
        }
    }

    private void fetchDecoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf == null) {
                return;
            }
            if (!byteBuf.isReadable()) {
                byteBuf.release();
            } else {
                list.add(new DefaultHttpContent(byteBuf));
            }
        }
    }

    private void finishDecode(List<Object> list) {
        if (this.decoder.finish()) {
            fetchDecoderOutput(list);
        }
        this.decoder = null;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.channelInactive(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        decode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    protected String getTargetContentEncoding(String str) throws Exception {
        return IDENTITY;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.handlerRemoved(channelHandlerContext);
    }

    protected abstract EmbeddedChannel newContentDecoder(String str) throws Exception;

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        String str;
        HttpMessage defaultHttpResponse;
        if ((httpObject instanceof HttpResponse) && ((HttpResponse) httpObject).status().code() == 100) {
            if (!(httpObject instanceof LastHttpContent)) {
                this.continueResponse = true;
            }
            list.add(ReferenceCountUtil.retain(httpObject));
        } else if (this.continueResponse) {
            if (httpObject instanceof LastHttpContent) {
                this.continueResponse = false;
            }
            list.add(ReferenceCountUtil.retain(httpObject));
        } else {
            if (httpObject instanceof HttpMessage) {
                cleanup();
                HttpMessage httpMessage = (HttpMessage) httpObject;
                HttpHeaders headers = httpMessage.headers();
                AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
                String str2 = headers.get(asciiString);
                if (str2 != null) {
                    str = str2.trim();
                } else {
                    str = IDENTITY;
                }
                EmbeddedChannel newContentDecoder = newContentDecoder(str);
                this.decoder = newContentDecoder;
                if (newContentDecoder == null) {
                    if (httpMessage instanceof HttpContent) {
                        ((HttpContent) httpMessage).retain();
                    }
                    list.add(httpMessage);
                    return;
                }
                headers.remove(HttpHeaderNames.CONTENT_LENGTH);
                headers.set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
                String targetContentEncoding = getTargetContentEncoding(str);
                if (HttpHeaderValues.IDENTITY.contentEquals(targetContentEncoding)) {
                    headers.remove(asciiString);
                } else {
                    headers.set(asciiString, targetContentEncoding);
                }
                if (httpMessage instanceof HttpContent) {
                    if (httpMessage instanceof HttpRequest) {
                        HttpRequest httpRequest = (HttpRequest) httpMessage;
                        defaultHttpResponse = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri());
                    } else if (httpMessage instanceof HttpResponse) {
                        HttpResponse httpResponse = (HttpResponse) httpMessage;
                        defaultHttpResponse = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                    } else {
                        throw new CodecException("Object of class " + httpMessage.getClass().getName() + " is not a HttpRequest or HttpResponse");
                    }
                    defaultHttpResponse.headers().set(httpMessage.headers());
                    defaultHttpResponse.setDecoderResult(httpMessage.decoderResult());
                    list.add(defaultHttpResponse);
                } else {
                    list.add(httpMessage);
                }
            }
            if (httpObject instanceof HttpContent) {
                HttpContent httpContent = (HttpContent) httpObject;
                if (this.decoder == null) {
                    list.add(httpContent.retain());
                } else {
                    decodeContent(httpContent, list);
                }
            }
        }
    }

    private void decode(ByteBuf byteBuf, List<Object> list) {
        this.decoder.writeInbound(byteBuf.retain());
        fetchDecoderOutput(list);
    }
}

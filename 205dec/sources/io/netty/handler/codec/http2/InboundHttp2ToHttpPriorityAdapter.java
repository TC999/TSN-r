package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class InboundHttp2ToHttpPriorityAdapter extends InboundHttp2ToHttpAdapter {
    private static final AsciiString OUT_OF_MESSAGE_SEQUENCE_METHOD = new AsciiString(HttpConversionUtil.OUT_OF_MESSAGE_SEQUENCE_METHOD.toString());
    private static final AsciiString OUT_OF_MESSAGE_SEQUENCE_PATH = new AsciiString("");
    private static final AsciiString OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE = new AsciiString(HttpConversionUtil.OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE.toString());
    private final Http2Connection.PropertyKey outOfMessageFlowHeadersKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InboundHttp2ToHttpPriorityAdapter(Http2Connection http2Connection, int i4, boolean z3, boolean z4) {
        super(http2Connection, i4, z3, z4);
        this.outOfMessageFlowHeadersKey = http2Connection.newKey();
    }

    private static void addHttpHeadersToHttp2Headers(HttpHeaders httpHeaders, Http2Headers http2Headers) {
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            http2Headers.add((Http2Headers) AsciiString.of(next.getKey()), AsciiString.of(next.getValue()));
        }
    }

    private void exportOutOfMessageFlowHeaders(Http2Stream http2Stream, HttpHeaders httpHeaders) {
        HttpHeaders outOfMessageFlowHeaders = getOutOfMessageFlowHeaders(http2Stream);
        if (outOfMessageFlowHeaders != null) {
            httpHeaders.setAll(outOfMessageFlowHeaders);
        }
    }

    private static HttpHeaders getActiveHeaders(FullHttpMessage fullHttpMessage) {
        return fullHttpMessage.content().isReadable() ? fullHttpMessage.trailingHeaders() : fullHttpMessage.headers();
    }

    private HttpHeaders getOutOfMessageFlowHeaders(Http2Stream http2Stream) {
        return (HttpHeaders) http2Stream.getProperty(this.outOfMessageFlowHeadersKey);
    }

    private void importOutOfMessageFlowHeaders(Http2Stream http2Stream, HttpHeaders httpHeaders) {
        HttpHeaders outOfMessageFlowHeaders = getOutOfMessageFlowHeaders(http2Stream);
        if (outOfMessageFlowHeaders == null) {
            putOutOfMessageFlowHeaders(http2Stream, httpHeaders);
        } else {
            outOfMessageFlowHeaders.setAll(httpHeaders);
        }
    }

    private void initializePseudoHeaders(Http2Headers http2Headers) {
        if (this.connection.isServer()) {
            http2Headers.method(OUT_OF_MESSAGE_SEQUENCE_METHOD).path(OUT_OF_MESSAGE_SEQUENCE_PATH);
        } else {
            http2Headers.status(OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE);
        }
    }

    private void putOutOfMessageFlowHeaders(Http2Stream http2Stream, HttpHeaders httpHeaders) {
        http2Stream.setProperty(this.outOfMessageFlowHeadersKey, httpHeaders);
    }

    private HttpHeaders removeOutOfMessageFlowHeaders(Http2Stream http2Stream) {
        return (HttpHeaders) http2Stream.removeProperty(this.outOfMessageFlowHeadersKey);
    }

    private static void removePriorityRelatedHeaders(HttpHeaders httpHeaders) {
        httpHeaders.remove(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text());
        httpHeaders.remove(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter
    public void fireChannelRead(ChannelHandlerContext channelHandlerContext, FullHttpMessage fullHttpMessage, boolean z3, Http2Stream http2Stream) {
        exportOutOfMessageFlowHeaders(http2Stream, getActiveHeaders(fullHttpMessage));
        super.fireChannelRead(channelHandlerContext, fullHttpMessage, z3, http2Stream);
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i4, int i5, short s3, boolean z3) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i4);
        if (stream != null && getMessage(stream) == null) {
            HttpHeaders removeOutOfMessageFlowHeaders = removeOutOfMessageFlowHeaders(stream);
            if (removeOutOfMessageFlowHeaders == null) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Priority Frame recieved for unknown stream id %d", Integer.valueOf(i4));
            }
            DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers(this.validateHttpHeaders, removeOutOfMessageFlowHeaders.size());
            initializePseudoHeaders(defaultHttp2Headers);
            addHttpHeadersToHttp2Headers(removeOutOfMessageFlowHeaders, defaultHttp2Headers);
            fireChannelRead(channelHandlerContext, newMessage(stream, defaultHttp2Headers, this.validateHttpHeaders, channelHandlerContext.alloc()), false, stream);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
    public void onPriorityTreeParentChanged(Http2Stream http2Stream, Http2Stream http2Stream2) {
        Http2Stream parent = http2Stream.parent();
        FullHttpMessage message = getMessage(http2Stream);
        if (message == null) {
            if (parent == null || parent.equals(this.connection.connectionStream())) {
                return;
            }
            DefaultHttpHeaders defaultHttpHeaders = new DefaultHttpHeaders();
            defaultHttpHeaders.setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), parent.id());
            importOutOfMessageFlowHeaders(http2Stream, defaultHttpHeaders);
        } else if (parent == null) {
            removePriorityRelatedHeaders(message.headers());
            removePriorityRelatedHeaders(message.trailingHeaders());
        } else if (parent.equals(this.connection.connectionStream())) {
        } else {
            getActiveHeaders(message).setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), parent.id());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
    public void onWeightChanged(Http2Stream http2Stream, short s3) {
        HttpHeaders activeHeaders;
        FullHttpMessage message = getMessage(http2Stream);
        if (message == null) {
            activeHeaders = new DefaultHttpHeaders();
            importOutOfMessageFlowHeaders(http2Stream, activeHeaders);
        } else {
            activeHeaders = getActiveHeaders(message);
        }
        activeHeaders.setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), http2Stream.weight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter
    public FullHttpMessage processHeadersBegin(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, Http2Headers http2Headers, boolean z3, boolean z4, boolean z5) throws Http2Exception {
        FullHttpMessage processHeadersBegin = super.processHeadersBegin(channelHandlerContext, http2Stream, http2Headers, z3, z4, z5);
        if (processHeadersBegin != null) {
            exportOutOfMessageFlowHeaders(http2Stream, getActiveHeaders(processHeadersBegin));
        }
        return processHeadersBegin;
    }
}

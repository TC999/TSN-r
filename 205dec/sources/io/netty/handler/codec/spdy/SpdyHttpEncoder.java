package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.spdy.SpdyHeaders;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdyHttpEncoder extends MessageToMessageEncoder<HttpObject> {
    private int currentStreamId;
    private final boolean headersToLowerCase;
    private final boolean validateHeaders;

    public SpdyHttpEncoder(SpdyVersion spdyVersion) {
        this(spdyVersion, true, true);
    }

    private SpdyHeadersFrame createHeadersFrame(HttpResponse httpResponse) throws Exception {
        SpdyHeadersFrame defaultSpdySynReplyFrame;
        HttpHeaders headers = httpResponse.headers();
        AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
        int intValue = headers.getInt(asciiString).intValue();
        headers.remove(asciiString);
        headers.remove(HttpHeaderNames.CONNECTION);
        headers.remove("Keep-Alive");
        headers.remove("Proxy-Connection");
        headers.remove(HttpHeaderNames.TRANSFER_ENCODING);
        if (SpdyCodecUtil.isServerId(intValue)) {
            defaultSpdySynReplyFrame = new DefaultSpdyHeadersFrame(intValue, this.validateHeaders);
        } else {
            defaultSpdySynReplyFrame = new DefaultSpdySynReplyFrame(intValue, this.validateHeaders);
        }
        SpdyHeaders headers2 = defaultSpdySynReplyFrame.headers();
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.STATUS, httpResponse.status().codeAsText());
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.VERSION, (AsciiString) httpResponse.protocolVersion().text());
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = headers.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            defaultSpdySynReplyFrame.headers().add((SpdyHeaders) (this.headersToLowerCase ? AsciiString.of(next.getKey()).toLowerCase() : (CharSequence) next.getKey()), (Object) next.getValue());
        }
        this.currentStreamId = intValue;
        defaultSpdySynReplyFrame.setLast(isLast(httpResponse));
        return defaultSpdySynReplyFrame;
    }

    private SpdySynStreamFrame createSynStreamFrame(HttpRequest httpRequest) throws Exception {
        HttpHeaders headers = httpRequest.headers();
        AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
        int intValue = headers.getInt(asciiString).intValue();
        AsciiString asciiString2 = SpdyHttpHeaders.Names.ASSOCIATED_TO_STREAM_ID;
        int i4 = headers.getInt(asciiString2, 0);
        AsciiString asciiString3 = SpdyHttpHeaders.Names.PRIORITY;
        AsciiString asciiString4 = SpdyHttpHeaders.Names.SCHEME;
        String str = headers.get(asciiString4);
        headers.remove(asciiString);
        headers.remove(asciiString2);
        headers.remove(asciiString3);
        headers.remove(asciiString4);
        headers.remove(HttpHeaderNames.CONNECTION);
        headers.remove("Keep-Alive");
        headers.remove("Proxy-Connection");
        headers.remove(HttpHeaderNames.TRANSFER_ENCODING);
        DefaultSpdySynStreamFrame defaultSpdySynStreamFrame = new DefaultSpdySynStreamFrame(intValue, i4, (byte) headers.getInt(asciiString3, 0), this.validateHeaders);
        SpdyHeaders headers2 = defaultSpdySynStreamFrame.headers();
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.METHOD, (AsciiString) httpRequest.method().name());
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.PATH, (AsciiString) httpRequest.uri());
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.VERSION, (AsciiString) httpRequest.protocolVersion().text());
        AsciiString asciiString5 = HttpHeaderNames.HOST;
        String str2 = headers.get(asciiString5);
        headers.remove(asciiString5);
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.HOST, (AsciiString) str2);
        if (str == null) {
            str = "https";
        }
        headers2.set((SpdyHeaders) SpdyHeaders.HttpNames.SCHEME, (AsciiString) str);
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = headers.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            headers2.add((SpdyHeaders) (this.headersToLowerCase ? AsciiString.of(next.getKey()).toLowerCase() : (CharSequence) next.getKey()), (Object) next.getValue());
        }
        this.currentStreamId = defaultSpdySynStreamFrame.streamId();
        if (i4 == 0) {
            defaultSpdySynStreamFrame.setLast(isLast(httpRequest));
        } else {
            defaultSpdySynStreamFrame.setUnidirectional(true);
        }
        return defaultSpdySynStreamFrame;
    }

    private static boolean isLast(HttpMessage httpMessage) {
        if (httpMessage instanceof FullHttpMessage) {
            FullHttpMessage fullHttpMessage = (FullHttpMessage) httpMessage;
            return fullHttpMessage.trailingHeaders().isEmpty() && !fullHttpMessage.content().isReadable();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        encode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    public SpdyHttpEncoder(SpdyVersion spdyVersion, boolean z3, boolean z4) {
        if (spdyVersion != null) {
            this.headersToLowerCase = z3;
            this.validateHeaders = z4;
            return;
        }
        throw new NullPointerException("version");
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (httpObject instanceof HttpRequest) {
            SpdySynStreamFrame createSynStreamFrame = createSynStreamFrame((HttpRequest) httpObject);
            list.add(createSynStreamFrame);
            z3 = createSynStreamFrame.isLast() || createSynStreamFrame.isUnidirectional();
            z4 = true;
        } else {
            z3 = false;
            z4 = false;
        }
        if (httpObject instanceof HttpResponse) {
            SpdyHeadersFrame createHeadersFrame = createHeadersFrame((HttpResponse) httpObject);
            list.add(createHeadersFrame);
            z3 = createHeadersFrame.isLast();
            z4 = true;
        }
        if (!(httpObject instanceof HttpContent) || z3) {
            z5 = z4;
        } else {
            HttpContent httpContent = (HttpContent) httpObject;
            httpContent.content().retain();
            DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(this.currentStreamId, httpContent.content());
            if (httpContent instanceof LastHttpContent) {
                HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
                if (trailingHeaders.isEmpty()) {
                    defaultSpdyDataFrame.setLast(true);
                    list.add(defaultSpdyDataFrame);
                } else {
                    DefaultSpdyHeadersFrame defaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(this.currentStreamId, this.validateHeaders);
                    defaultSpdyHeadersFrame.setLast(true);
                    Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = trailingHeaders.iteratorCharSequence();
                    while (iteratorCharSequence.hasNext()) {
                        Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
                        defaultSpdyHeadersFrame.headers().add((SpdyHeaders) (this.headersToLowerCase ? AsciiString.of(next.getKey()).toLowerCase() : (CharSequence) next.getKey()), (Object) next.getValue());
                    }
                    list.add(defaultSpdyDataFrame);
                    list.add(defaultSpdyHeadersFrame);
                }
            } else {
                list.add(defaultSpdyDataFrame);
            }
        }
        if (!z5) {
            throw new UnsupportedMessageTypeException(httpObject, new Class[0]);
        }
    }
}

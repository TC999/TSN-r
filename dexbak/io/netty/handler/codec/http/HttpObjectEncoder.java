package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class HttpObjectEncoder<H extends HttpMessage> extends MessageToMessageEncoder<Object> {
    static final byte[] CRLF;
    private static final ByteBuf CRLF_BUF;
    private static final int ST_CONTENT_CHUNK = 2;
    private static final int ST_CONTENT_NON_CHUNK = 1;
    private static final int ST_INIT = 0;
    private static final byte[] ZERO_CRLF = {48, 13, 10};
    private static final byte[] ZERO_CRLF_CRLF;
    private static final ByteBuf ZERO_CRLF_CRLF_BUF;
    private int state = 0;

    static {
        byte[] bArr = {13, 10};
        CRLF = bArr;
        byte[] bArr2 = {48, 13, 10, 13, 10};
        ZERO_CRLF_CRLF = bArr2;
        CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr.length).writeBytes(bArr));
        ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr2.length).writeBytes(bArr2));
    }

    private static long contentLength(Object obj) {
        if (obj instanceof HttpContent) {
            return ((HttpContent) obj).content().readableBytes();
        }
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    private static Object encodeAndRetain(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).retain();
        }
        if (obj instanceof HttpContent) {
            return ((HttpContent) obj).content().retain();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).retain();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    @Deprecated
    protected static void encodeAscii(String str, ByteBuf byteBuf) {
        HttpUtil.encodeAscii0(str, byteBuf);
    }

    private void encodeChunkedContent(ChannelHandlerContext channelHandlerContext, Object obj, long j, List<Object> list) {
        if (j > 0) {
            byte[] bytes = Long.toHexString(j).getBytes(CharsetUtil.US_ASCII);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(bytes.length + 2);
            buffer.writeBytes(bytes);
            buffer.writeBytes(CRLF);
            list.add(buffer);
            list.add(encodeAndRetain(obj));
            list.add(CRLF_BUF.duplicate());
        }
        if (!(obj instanceof LastHttpContent)) {
            if (j == 0) {
                list.add(Unpooled.EMPTY_BUFFER);
                return;
            }
            return;
        }
        HttpHeaders trailingHeaders = ((LastHttpContent) obj).trailingHeaders();
        if (trailingHeaders.isEmpty()) {
            list.add(ZERO_CRLF_CRLF_BUF.duplicate());
        } else {
            ByteBuf buffer2 = channelHandlerContext.alloc().buffer();
            buffer2.writeBytes(ZERO_CRLF);
            try {
                encodeHeaders(trailingHeaders, buffer2);
            } catch (Exception e) {
                buffer2.release();
                PlatformDependent.throwException(e);
            }
            buffer2.writeBytes(CRLF);
            list.add(buffer2);
        }
        this.state = 0;
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof HttpObject) || (obj instanceof ByteBuf) || (obj instanceof FileRegion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        ByteBuf byteBuf;
        if (!(obj instanceof HttpMessage)) {
            byteBuf = null;
        } else if (this.state == 0) {
            HttpMessage httpMessage = (HttpMessage) obj;
            byteBuf = channelHandlerContext.alloc().buffer();
            encodeInitialLine(byteBuf, httpMessage);
            encodeHeaders(httpMessage.headers(), byteBuf);
            byteBuf.writeBytes(CRLF);
            this.state = HttpUtil.isTransferEncodingChunked(httpMessage) ? 2 : 1;
        } else {
            throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
        }
        boolean z = obj instanceof ByteBuf;
        if (z && !((ByteBuf) obj).isReadable()) {
            list.add(Unpooled.EMPTY_BUFFER);
            return;
        }
        boolean z2 = obj instanceof HttpContent;
        if (!z2 && !z && !(obj instanceof FileRegion)) {
            if (byteBuf != null) {
                list.add(byteBuf);
            }
        } else if (this.state != 0) {
            long contentLength = contentLength(obj);
            int i = this.state;
            if (i != 1) {
                if (i == 2) {
                    if (byteBuf != null) {
                        list.add(byteBuf);
                    }
                    encodeChunkedContent(channelHandlerContext, obj, contentLength, list);
                    return;
                }
                throw new Error();
            }
            if (contentLength > 0) {
                if (byteBuf != null && byteBuf.writableBytes() >= contentLength && z2) {
                    byteBuf.writeBytes(((HttpContent) obj).content());
                    list.add(byteBuf);
                } else {
                    if (byteBuf != null) {
                        list.add(byteBuf);
                    }
                    list.add(encodeAndRetain(obj));
                }
            } else if (byteBuf != null) {
                list.add(byteBuf);
            } else {
                list.add(Unpooled.EMPTY_BUFFER);
            }
            if (obj instanceof LastHttpContent) {
                this.state = 0;
            }
        } else {
            throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
        }
    }

    protected void encodeHeaders(HttpHeaders httpHeaders, ByteBuf byteBuf) throws Exception {
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            HttpHeadersEncoder.encoderHeader(next.getKey(), next.getValue(), byteBuf);
        }
    }

    protected abstract void encodeInitialLine(ByteBuf byteBuf, H h) throws Exception;
}

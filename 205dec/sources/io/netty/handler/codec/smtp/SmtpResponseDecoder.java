package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class SmtpResponseDecoder extends LineBasedFrameDecoder {
    private List<CharSequence> details;

    public SmtpResponseDecoder(int i4) {
        super(i4);
    }

    private static DecoderException newDecoderException(ByteBuf byteBuf, int i4, int i5) {
        return new DecoderException("Received invalid line: '" + byteBuf.toString(i4, i5, CharsetUtil.US_ASCII) + '\'');
    }

    private static int parseCode(ByteBuf byteBuf) {
        return (parseNumber(byteBuf.readByte()) * 100) + (parseNumber(byteBuf.readByte()) * 10) + parseNumber(byteBuf.readByte());
    }

    private static int parseNumber(byte b4) {
        return Character.digit((char) b4, 10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.LineBasedFrameDecoder
    public SmtpResponse decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        try {
            int readableBytes = byteBuf2.readableBytes();
            int readerIndex = byteBuf2.readerIndex();
            if (readableBytes >= 3) {
                int parseCode = parseCode(byteBuf2);
                byte readByte = byteBuf2.readByte();
                String byteBuf3 = byteBuf2.isReadable() ? byteBuf2.toString(CharsetUtil.US_ASCII) : null;
                List list = this.details;
                if (readByte == 32) {
                    this.details = null;
                    if (list == null) {
                        list = byteBuf3 == null ? Collections.emptyList() : Collections.singletonList(byteBuf3);
                    } else if (byteBuf3 != null) {
                        list.add(byteBuf3);
                    }
                    return new DefaultSmtpResponse(parseCode, list);
                } else if (readByte == 45) {
                    if (byteBuf3 != null) {
                        if (list == null) {
                            list = new ArrayList(4);
                            this.details = list;
                        }
                        list.add(byteBuf3);
                    }
                    return null;
                } else {
                    throw newDecoderException(byteBuf, readerIndex, readableBytes);
                }
            }
            throw newDecoderException(byteBuf, readerIndex, readableBytes);
        } finally {
            byteBuf2.release();
        }
    }
}

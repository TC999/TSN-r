package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class SmtpRequestEncoder extends MessageToMessageEncoder<Object> {
    private static final int CRLF_SHORT = 3338;
    private static final ByteBuf DOT_CRLF_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(3).writeByte(46).writeByte(13).writeByte(10));
    private static final byte SP = 32;
    private boolean contentExpected;

    private static void writeParameters(List<CharSequence> list, ByteBuf byteBuf) {
        if (list.isEmpty()) {
            return;
        }
        byteBuf.writeByte(32);
        if (list instanceof RandomAccess) {
            int size = list.size() - 1;
            for (int i4 = 0; i4 < size; i4++) {
                ByteBufUtil.writeAscii(byteBuf, list.get(i4));
                byteBuf.writeByte(32);
            }
            ByteBufUtil.writeAscii(byteBuf, list.get(size));
            return;
        }
        Iterator<CharSequence> it = list.iterator();
        while (true) {
            ByteBufUtil.writeAscii(byteBuf, it.next());
            if (!it.hasNext()) {
                return;
            }
            byteBuf.writeByte(32);
        }
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof SmtpRequest) || (obj instanceof SmtpContent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        boolean z3 = false;
        if (obj instanceof SmtpRequest) {
            SmtpRequest smtpRequest = (SmtpRequest) obj;
            if (this.contentExpected) {
                if (smtpRequest.command().equals(SmtpCommand.RSET)) {
                    this.contentExpected = false;
                } else {
                    throw new IllegalStateException("SmtpContent expected");
                }
            }
            ByteBuf buffer = channelHandlerContext.alloc().buffer();
            try {
                smtpRequest.command().encode(buffer);
                writeParameters(smtpRequest.parameters(), buffer);
                ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
                list.add(buffer);
                try {
                    if (smtpRequest.command().isContentExpected()) {
                        this.contentExpected = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (z3) {
                        buffer.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z3 = true;
            }
        }
        if (obj instanceof SmtpContent) {
            if (this.contentExpected) {
                list.add(((SmtpContent) obj).content().retain());
                if (obj instanceof LastSmtpContent) {
                    list.add(DOT_CRLF_BUFFER.retainedDuplicate());
                    this.contentExpected = false;
                    return;
                }
                return;
            }
            throw new IllegalStateException("No SmtpContent expected");
        }
    }
}

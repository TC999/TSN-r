package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class TcpDnsQueryEncoder extends MessageToByteEncoder<DnsQuery> {
    private final DnsQueryEncoder encoder;

    public TcpDnsQueryEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    public TcpDnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = new DnsQueryEncoder(dnsRecordEncoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, DnsQuery dnsQuery, boolean z3) {
        if (z3) {
            return channelHandlerContext.alloc().ioBuffer(1024);
        }
        return channelHandlerContext.alloc().heapBuffer(1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, DnsQuery dnsQuery, ByteBuf byteBuf) throws Exception {
        byteBuf.writerIndex(byteBuf.writerIndex() + 2);
        this.encoder.encode(dnsQuery, byteBuf);
        byteBuf.setShort(0, byteBuf.readableBytes() - 2);
    }
}

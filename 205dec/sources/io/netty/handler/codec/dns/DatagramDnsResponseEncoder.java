package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DatagramDnsResponseEncoder extends MessageToMessageEncoder<AddressedEnvelope<DnsResponse, InetSocketAddress>> {
    private final DnsRecordEncoder recordEncoder;

    public DatagramDnsResponseEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    private static void encodeHeader(DnsResponse dnsResponse, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsResponse.id());
        int byteValue = ((dnsResponse.opCode().byteValue() & 255) << 11) | 32768;
        if (dnsResponse.isAuthoritativeAnswer()) {
            byteValue |= 1024;
        }
        if (dnsResponse.isTruncated()) {
            byteValue |= 512;
        }
        if (dnsResponse.isRecursionDesired()) {
            byteValue |= 256;
        }
        if (dnsResponse.isRecursionAvailable()) {
            byteValue |= 128;
        }
        byteBuf.writeShort(byteValue | (dnsResponse.z() << 4) | dnsResponse.code().intValue());
        byteBuf.writeShort(dnsResponse.count(DnsSection.QUESTION));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ANSWER));
        byteBuf.writeShort(dnsResponse.count(DnsSection.AUTHORITY));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ADDITIONAL));
    }

    private void encodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf) throws Exception {
        int count = dnsResponse.count(DnsSection.QUESTION);
        for (int i4 = 0; i4 < count; i4++) {
            this.recordEncoder.encodeQuestion((DnsQuestion) dnsResponse.recordAt(DnsSection.QUESTION, i4), byteBuf);
        }
    }

    private void encodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf) throws Exception {
        int count = dnsResponse.count(dnsSection);
        for (int i4 = 0; i4 < count; i4++) {
            this.recordEncoder.encodeRecord(dnsResponse.recordAt(dnsSection, i4), byteBuf);
        }
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope) throws Exception {
        return channelHandlerContext.alloc().ioBuffer(1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, List list) throws Exception {
        encode2(channelHandlerContext, addressedEnvelope, (List<Object>) list);
    }

    public DatagramDnsResponseEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.recordEncoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "recordEncoder");
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, List<Object> list) throws Exception {
        InetSocketAddress recipient = addressedEnvelope.recipient();
        DnsResponse content = addressedEnvelope.content();
        ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, addressedEnvelope);
        try {
            encodeHeader(content, allocateBuffer);
            encodeQuestions(content, allocateBuffer);
            encodeRecords(content, DnsSection.ANSWER, allocateBuffer);
            encodeRecords(content, DnsSection.AUTHORITY, allocateBuffer);
            encodeRecords(content, DnsSection.ADDITIONAL, allocateBuffer);
            list.add(new DatagramPacket(allocateBuffer, recipient, null));
        } catch (Throwable th) {
            allocateBuffer.release();
            throw th;
        }
    }
}

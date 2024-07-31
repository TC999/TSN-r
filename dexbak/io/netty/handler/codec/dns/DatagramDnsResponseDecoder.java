package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

@ChannelHandler.Sharable
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DatagramDnsResponseDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsRecordDecoder recordDecoder;

    public DatagramDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    private void decodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf, int i) throws Exception {
        while (i > 0) {
            dnsResponse.addRecord(DnsSection.QUESTION, (DnsRecord) this.recordDecoder.decodeQuestion(byteBuf));
            i--;
        }
    }

    private void decodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf, int i) throws Exception {
        while (i > 0) {
            DnsRecord decodeRecord = this.recordDecoder.decodeRecord(byteBuf);
            if (decodeRecord == null) {
                return;
            }
            dnsResponse.addRecord(dnsSection, decodeRecord);
            i--;
        }
    }

    private static DnsResponse newResponse(DatagramPacket datagramPacket, ByteBuf byteBuf) {
        int readUnsignedShort = byteBuf.readUnsignedShort();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        if ((readUnsignedShort2 >> 15) != 0) {
            DatagramDnsResponse datagramDnsResponse = new DatagramDnsResponse(datagramPacket.sender(), datagramPacket.recipient(), readUnsignedShort, DnsOpCode.valueOf((byte) ((readUnsignedShort2 >> 11) & 15)), DnsResponseCode.valueOf((byte) (readUnsignedShort2 & 15)));
            datagramDnsResponse.setRecursionDesired(((readUnsignedShort2 >> 8) & 1) == 1);
            datagramDnsResponse.setAuthoritativeAnswer(((readUnsignedShort2 >> 10) & 1) == 1);
            datagramDnsResponse.setTruncated(((readUnsignedShort2 >> 9) & 1) == 1);
            datagramDnsResponse.setRecursionAvailable(((readUnsignedShort2 >> 7) & 1) == 1);
            datagramDnsResponse.setZ((readUnsignedShort2 >> 4) & 7);
            return datagramDnsResponse;
        }
        throw new CorruptedFrameException("not a response");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) throws Exception {
        decode2(channelHandlerContext, datagramPacket, (List<Object>) list);
    }

    public DatagramDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        ByteBuf content = datagramPacket.content();
        DnsResponse newResponse = newResponse(datagramPacket, content);
        try {
            int readUnsignedShort = content.readUnsignedShort();
            int readUnsignedShort2 = content.readUnsignedShort();
            int readUnsignedShort3 = content.readUnsignedShort();
            int readUnsignedShort4 = content.readUnsignedShort();
            decodeQuestions(newResponse, content, readUnsignedShort);
            decodeRecords(newResponse, DnsSection.ANSWER, content, readUnsignedShort2);
            decodeRecords(newResponse, DnsSection.AUTHORITY, content, readUnsignedShort3);
            decodeRecords(newResponse, DnsSection.ADDITIONAL, content, readUnsignedShort4);
            list.add(newResponse);
        } catch (Throwable th) {
            newResponse.release();
            throw th;
        }
    }
}

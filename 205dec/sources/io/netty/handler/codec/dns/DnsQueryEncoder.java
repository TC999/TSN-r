package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class DnsQueryEncoder {
    private final DnsRecordEncoder recordEncoder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.recordEncoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "recordEncoder");
    }

    private static void encodeHeader(DnsQuery dnsQuery, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsQuery.id());
        int byteValue = ((dnsQuery.opCode().byteValue() & 255) << 14) | 0;
        if (dnsQuery.isRecursionDesired()) {
            byteValue |= 256;
        }
        byteBuf.writeShort(byteValue);
        byteBuf.writeShort(dnsQuery.count(DnsSection.QUESTION));
        byteBuf.writeShort(0);
        byteBuf.writeShort(0);
        byteBuf.writeShort(dnsQuery.count(DnsSection.ADDITIONAL));
    }

    private void encodeQuestions(DnsQuery dnsQuery, ByteBuf byteBuf) throws Exception {
        int count = dnsQuery.count(DnsSection.QUESTION);
        for (int i4 = 0; i4 < count; i4++) {
            this.recordEncoder.encodeQuestion((DnsQuestion) dnsQuery.recordAt(DnsSection.QUESTION, i4), byteBuf);
        }
    }

    private void encodeRecords(DnsQuery dnsQuery, DnsSection dnsSection, ByteBuf byteBuf) throws Exception {
        int count = dnsQuery.count(dnsSection);
        for (int i4 = 0; i4 < count; i4++) {
            this.recordEncoder.encodeRecord(dnsQuery.recordAt(dnsSection, i4), byteBuf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(DnsQuery dnsQuery, ByteBuf byteBuf) throws Exception {
        encodeHeader(dnsQuery, byteBuf);
        encodeQuestions(dnsQuery, byteBuf);
        encodeRecords(dnsQuery, DnsSection.ADDITIONAL, byteBuf);
    }
}

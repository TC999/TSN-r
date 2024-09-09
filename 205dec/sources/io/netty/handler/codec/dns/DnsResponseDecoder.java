package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
abstract class DnsResponseDecoder<A extends SocketAddress> {
    private final DnsRecordDecoder recordDecoder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    private void decodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf, int i4) throws Exception {
        while (i4 > 0) {
            dnsResponse.addRecord(DnsSection.QUESTION, (DnsRecord) this.recordDecoder.decodeQuestion(byteBuf));
            i4--;
        }
    }

    private void decodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf, int i4) throws Exception {
        while (i4 > 0) {
            DnsRecord decodeRecord = this.recordDecoder.decodeRecord(byteBuf);
            if (decodeRecord == null) {
                return;
            }
            dnsResponse.addRecord(dnsSection, decodeRecord);
            i4--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsResponse decode(A a4, A a5, ByteBuf byteBuf) throws Exception {
        int readUnsignedShort = byteBuf.readUnsignedShort();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        if ((readUnsignedShort2 >> 15) != 0) {
            DnsResponse newResponse = newResponse(a4, a5, readUnsignedShort, DnsOpCode.valueOf((byte) ((readUnsignedShort2 >> 11) & 15)), DnsResponseCode.valueOf((byte) (readUnsignedShort2 & 15)));
            newResponse.setRecursionDesired(((readUnsignedShort2 >> 8) & 1) == 1);
            newResponse.setAuthoritativeAnswer(((readUnsignedShort2 >> 10) & 1) == 1);
            newResponse.setTruncated(((readUnsignedShort2 >> 9) & 1) == 1);
            newResponse.setRecursionAvailable(((readUnsignedShort2 >> 7) & 1) == 1);
            newResponse.setZ((readUnsignedShort2 >> 4) & 7);
            try {
                int readUnsignedShort3 = byteBuf.readUnsignedShort();
                int readUnsignedShort4 = byteBuf.readUnsignedShort();
                int readUnsignedShort5 = byteBuf.readUnsignedShort();
                int readUnsignedShort6 = byteBuf.readUnsignedShort();
                decodeQuestions(newResponse, byteBuf, readUnsignedShort3);
                decodeRecords(newResponse, DnsSection.ANSWER, byteBuf, readUnsignedShort4);
                decodeRecords(newResponse, DnsSection.AUTHORITY, byteBuf, readUnsignedShort5);
                decodeRecords(newResponse, DnsSection.ADDITIONAL, byteBuf, readUnsignedShort6);
                return newResponse;
            } catch (Throwable th) {
                newResponse.release();
                throw th;
            }
        }
        throw new CorruptedFrameException("not a response");
    }

    protected abstract DnsResponse newResponse(A a4, A a5, int i4, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) throws Exception;
}

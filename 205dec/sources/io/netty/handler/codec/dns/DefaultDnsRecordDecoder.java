package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.CharsetUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultDnsRecordDecoder implements DnsRecordDecoder {
    static final String ROOT = ".";

    public static String decodeName(ByteBuf byteBuf) {
        int writerIndex = byteBuf.writerIndex();
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return ".";
        }
        StringBuilder sb = new StringBuilder(readableBytes << 1);
        int i4 = -1;
        int i5 = 0;
        while (byteBuf.isReadable()) {
            short readUnsignedByte = byteBuf.readUnsignedByte();
            if (!((readUnsignedByte & 192) == 192)) {
                if (readUnsignedByte == 0) {
                    break;
                } else if (byteBuf.isReadable(readUnsignedByte)) {
                    sb.append(byteBuf.toString(byteBuf.readerIndex(), readUnsignedByte, CharsetUtil.UTF_8));
                    sb.append('.');
                    byteBuf.skipBytes(readUnsignedByte);
                } else {
                    throw new CorruptedFrameException("truncated label in a name");
                }
            } else {
                if (i4 == -1) {
                    i4 = byteBuf.readerIndex() + 1;
                }
                if (byteBuf.isReadable()) {
                    int readUnsignedByte2 = ((readUnsignedByte & 63) << 8) | byteBuf.readUnsignedByte();
                    if (readUnsignedByte2 < writerIndex) {
                        byteBuf.readerIndex(readUnsignedByte2);
                        i5 += 2;
                        if (i5 >= writerIndex) {
                            throw new CorruptedFrameException("name contains a loop.");
                        }
                    } else {
                        throw new CorruptedFrameException("name has an out-of-range pointer");
                    }
                } else {
                    throw new CorruptedFrameException("truncated pointer in a name");
                }
            }
        }
        if (i4 != -1) {
            byteBuf.readerIndex(i4);
        }
        if (sb.length() == 0) {
            return ".";
        }
        if (sb.charAt(sb.length() - 1) != '.') {
            sb.append('.');
        }
        return sb.toString();
    }

    protected String decodeName0(ByteBuf byteBuf) {
        return decodeName(byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final DnsQuestion decodeQuestion(ByteBuf byteBuf) throws Exception {
        return new DefaultDnsQuestion(decodeName(byteBuf), DnsRecordType.valueOf(byteBuf.readUnsignedShort()), byteBuf.readUnsignedShort());
    }

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf) throws Exception {
        int readerIndex = byteBuf.readerIndex();
        String decodeName = decodeName(byteBuf);
        int writerIndex = byteBuf.writerIndex();
        if (writerIndex - readerIndex < 10) {
            byteBuf.readerIndex(readerIndex);
            return null;
        }
        DnsRecordType valueOf = DnsRecordType.valueOf(byteBuf.readUnsignedShort());
        int readUnsignedShort = byteBuf.readUnsignedShort();
        long readUnsignedInt = byteBuf.readUnsignedInt();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        int readerIndex2 = byteBuf.readerIndex();
        if (writerIndex - readerIndex2 < readUnsignedShort2) {
            byteBuf.readerIndex(readerIndex);
            return null;
        }
        T t3 = (T) decodeRecord(decodeName, valueOf, readUnsignedShort, readUnsignedInt, byteBuf, readerIndex2, readUnsignedShort2);
        byteBuf.readerIndex(readerIndex2 + readUnsignedShort2);
        return t3;
    }

    protected DnsRecord decodeRecord(String str, DnsRecordType dnsRecordType, int i4, long j4, ByteBuf byteBuf, int i5, int i6) throws Exception {
        if (dnsRecordType == DnsRecordType.PTR) {
            byteBuf.setIndex(i5, i5 + i6);
            return new DefaultDnsPtrRecord(str, i4, j4, decodeName0(byteBuf));
        }
        return new DefaultDnsRawRecord(str, dnsRecordType, i4, j4, byteBuf.retainedDuplicate().setIndex(i5, i5 + i6));
    }
}

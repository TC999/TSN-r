package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class DnsAddressDecoder {
    private static final int INADDRSZ4 = 4;
    private static final int INADDRSZ6 = 16;

    private DnsAddressDecoder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetAddress decodeAddress(DnsRecord dnsRecord, String str, boolean z3) {
        if (dnsRecord instanceof DnsRawRecord) {
            ByteBuf content = ((ByteBufHolder) dnsRecord).content();
            int readableBytes = content.readableBytes();
            if (readableBytes == 4 || readableBytes == 16) {
                byte[] bArr = new byte[readableBytes];
                content.getBytes(content.readerIndex(), bArr);
                if (z3) {
                    try {
                        str = IDN.toUnicode(str);
                    } catch (UnknownHostException e4) {
                        throw new Error(e4);
                    }
                }
                return InetAddress.getByAddress(str, bArr);
            }
            return null;
        }
        return null;
    }
}

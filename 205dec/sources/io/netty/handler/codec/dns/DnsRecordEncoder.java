package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DnsRecordEncoder {
    public static final DnsRecordEncoder DEFAULT = new DefaultDnsRecordEncoder();

    void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) throws Exception;

    void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception;
}

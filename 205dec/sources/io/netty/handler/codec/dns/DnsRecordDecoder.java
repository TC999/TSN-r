package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DnsRecordDecoder {
    public static final DnsRecordDecoder DEFAULT = new DefaultDnsRecordDecoder();

    DnsQuestion decodeQuestion(ByteBuf byteBuf) throws Exception;

    <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf) throws Exception;
}

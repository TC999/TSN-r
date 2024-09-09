package io.netty.handler.codec.dns;

import io.netty.util.ReferenceCounted;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DnsMessage extends ReferenceCounted {
    DnsMessage addRecord(DnsSection dnsSection, int i4, DnsRecord dnsRecord);

    DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    DnsMessage clear();

    DnsMessage clear(DnsSection dnsSection);

    int count();

    int count(DnsSection dnsSection);

    int id();

    boolean isRecursionDesired();

    DnsOpCode opCode();

    <T extends DnsRecord> T recordAt(DnsSection dnsSection);

    <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i4);

    <T extends DnsRecord> T removeRecord(DnsSection dnsSection, int i4);

    @Override // io.netty.util.ReferenceCounted
    DnsMessage retain();

    @Override // io.netty.util.ReferenceCounted
    DnsMessage retain(int i4);

    DnsMessage setId(int i4);

    DnsMessage setOpCode(DnsOpCode dnsOpCode);

    DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    <T extends DnsRecord> T setRecord(DnsSection dnsSection, int i4, DnsRecord dnsRecord);

    DnsMessage setRecursionDesired(boolean z3);

    DnsMessage setZ(int i4);

    @Override // io.netty.util.ReferenceCounted
    DnsMessage touch();

    @Override // io.netty.util.ReferenceCounted
    DnsMessage touch(Object obj);

    int z();
}

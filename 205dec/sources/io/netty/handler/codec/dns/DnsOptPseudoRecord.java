package io.netty.handler.codec.dns;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface DnsOptPseudoRecord extends DnsRecord {
    int extendedRcode();

    int flags();

    int version();
}

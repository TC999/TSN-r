package io.netty.handler.codec.dns;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface DnsOptEcsRecord extends DnsOptPseudoRecord {
    byte[] address();

    int scopePrefixLength();

    int sourcePrefixLength();
}

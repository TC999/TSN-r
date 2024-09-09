package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DatagramDnsResponse extends DefaultDnsResponse implements AddressedEnvelope<DatagramDnsResponse, InetSocketAddress> {
    private final InetSocketAddress recipient;
    private final InetSocketAddress sender;

    public DatagramDnsResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i4) {
        this(inetSocketAddress, inetSocketAddress2, i4, DnsOpCode.QUERY, DnsResponseCode.NOERROR);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public DatagramDnsResponse content() {
        return this;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof AddressedEnvelope)) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if (sender() == null) {
                if (addressedEnvelope.sender() != null) {
                    return false;
                }
            } else if (!sender().equals(addressedEnvelope.sender())) {
                return false;
            }
            if (recipient() == null) {
                if (addressedEnvelope.recipient() != null) {
                    return false;
                }
            } else if (!recipient().equals(addressedEnvelope.recipient())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage
    public int hashCode() {
        int hashCode = super.hashCode();
        if (sender() != null) {
            hashCode = (hashCode * 31) + sender().hashCode();
        }
        return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
    }

    public DatagramDnsResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i4, DnsOpCode dnsOpCode) {
        this(inetSocketAddress, inetSocketAddress2, i4, dnsOpCode, DnsResponseCode.NOERROR);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public InetSocketAddress recipient() {
        return this.recipient;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public InetSocketAddress sender() {
        return this.sender;
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.DnsResponse
    public DatagramDnsResponse setAuthoritativeAnswer(boolean z3) {
        return (DatagramDnsResponse) super.setAuthoritativeAnswer(z3);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.DnsResponse
    public DatagramDnsResponse setCode(DnsResponseCode dnsResponseCode) {
        return (DatagramDnsResponse) super.setCode(dnsResponseCode);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.DnsResponse
    public DatagramDnsResponse setRecursionAvailable(boolean z3) {
        return (DatagramDnsResponse) super.setRecursionAvailable(z3);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.DnsResponse
    public DatagramDnsResponse setTruncated(boolean z3) {
        return (DatagramDnsResponse) super.setTruncated(z3);
    }

    public DatagramDnsResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i4, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
        super(i4, dnsOpCode, dnsResponseCode);
        if (inetSocketAddress2 == null && inetSocketAddress == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.sender = inetSocketAddress;
        this.recipient = inetSocketAddress2;
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse setId(int i4) {
        return (DatagramDnsResponse) super.setId(i4);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse setOpCode(DnsOpCode dnsOpCode) {
        return (DatagramDnsResponse) super.setOpCode(dnsOpCode);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsResponse) super.setRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse setRecursionDesired(boolean z3) {
        return (DatagramDnsResponse) super.setRecursionDesired(z3);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse setZ(int i4) {
        return (DatagramDnsResponse) super.setZ(i4);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsResponse) super.addRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse clear(DnsSection dnsSection) {
        return (DatagramDnsResponse) super.clear(dnsSection);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse addRecord(DnsSection dnsSection, int i4, DnsRecord dnsRecord) {
        return (DatagramDnsResponse) super.addRecord(dnsSection, i4, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsResponse clear() {
        return (DatagramDnsResponse) super.clear();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsResponse retain() {
        return (DatagramDnsResponse) super.retain();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsResponse touch() {
        return (DatagramDnsResponse) super.touch();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsResponse retain(int i4) {
        return (DatagramDnsResponse) super.retain(i4);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsResponse, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.ReferenceCounted
    public DatagramDnsResponse touch(Object obj) {
        return (DatagramDnsResponse) super.touch(obj);
    }
}

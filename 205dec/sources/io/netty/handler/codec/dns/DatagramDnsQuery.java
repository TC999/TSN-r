package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DatagramDnsQuery extends DefaultDnsQuery implements AddressedEnvelope<DatagramDnsQuery, InetSocketAddress> {
    private final InetSocketAddress recipient;
    private final InetSocketAddress sender;

    public DatagramDnsQuery(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i4) {
        this(inetSocketAddress, inetSocketAddress2, i4, DnsOpCode.QUERY);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public DatagramDnsQuery content() {
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

    public DatagramDnsQuery(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i4, DnsOpCode dnsOpCode) {
        super(i4, dnsOpCode);
        if (inetSocketAddress2 == null && inetSocketAddress == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.sender = inetSocketAddress;
        this.recipient = inetSocketAddress2;
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

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setId(int i4) {
        return (DatagramDnsQuery) super.setId(i4);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setOpCode(DnsOpCode dnsOpCode) {
        return (DatagramDnsQuery) super.setOpCode(dnsOpCode);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.setRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setRecursionDesired(boolean z3) {
        return (DatagramDnsQuery) super.setRecursionDesired(z3);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setZ(int i4) {
        return (DatagramDnsQuery) super.setZ(i4);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.addRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery clear(DnsSection dnsSection) {
        return (DatagramDnsQuery) super.clear(dnsSection);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery addRecord(DnsSection dnsSection, int i4, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.addRecord(dnsSection, i4, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery clear() {
        return (DatagramDnsQuery) super.clear();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsQuery retain() {
        return (DatagramDnsQuery) super.retain();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsQuery touch() {
        return (DatagramDnsQuery) super.touch();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsQuery retain(int i4) {
        return (DatagramDnsQuery) super.retain(i4);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.ReferenceCounted
    public DatagramDnsQuery touch(Object obj) {
        return (DatagramDnsQuery) super.touch(obj);
    }
}

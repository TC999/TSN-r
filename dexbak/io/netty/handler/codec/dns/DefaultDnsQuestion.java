package io.netty.handler.codec.dns;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultDnsQuestion extends AbstractDnsRecord implements DnsQuestion {
    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType) {
        super(str, dnsRecordType, 0L);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(name());
        sb.append(HttpConstants.SP_CHAR);
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(HttpConstants.SP_CHAR);
        appendRecordClass.append(type().name());
        appendRecordClass.append(')');
        return sb.toString();
    }

    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType, int i) {
        super(str, dnsRecordType, i, 0L);
    }
}

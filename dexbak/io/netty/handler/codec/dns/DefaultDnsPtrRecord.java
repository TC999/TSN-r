package io.netty.handler.codec.dns;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultDnsPtrRecord extends AbstractDnsRecord implements DnsPtrRecord {
    private final String hostname;

    public DefaultDnsPtrRecord(String str, int i, long j, String str2) {
        super(str, DnsRecordType.PTR, i, j);
        this.hostname = (String) ObjectUtil.checkNotNull(str2, "hostname");
    }

    @Override // io.netty.handler.codec.dns.DnsPtrRecord
    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        DnsRecordType type = type();
        sb.append(name().isEmpty() ? "<root>" : name());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(timeToLive());
        sb.append(HttpConstants.SP_CHAR);
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(HttpConstants.SP_CHAR);
        appendRecordClass.append(type.name());
        sb.append(HttpConstants.SP_CHAR);
        sb.append(this.hostname);
        return sb.toString();
    }
}

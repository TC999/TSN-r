package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultDnsPtrRecord extends AbstractDnsRecord implements DnsPtrRecord {
    private final String hostname;

    public DefaultDnsPtrRecord(String str, int i4, long j4, String str2) {
        super(str, DnsRecordType.PTR, i4, j4);
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
        sb.append(' ');
        sb.append(timeToLive());
        sb.append(' ');
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(' ');
        appendRecordClass.append(type.name());
        sb.append(' ');
        sb.append(this.hostname);
        return sb.toString();
    }
}

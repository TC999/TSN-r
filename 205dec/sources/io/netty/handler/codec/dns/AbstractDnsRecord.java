package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractDnsRecord implements DnsRecord {
    private final short dnsClass;
    private int hashCode;
    private final String name;
    private final long timeToLive;
    private final DnsRecordType type;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDnsRecord(String str, DnsRecordType dnsRecordType, long j4) {
        this(str, dnsRecordType, 1, j4);
    }

    private static String appendTrailingDot(String str) {
        if (str.length() <= 0 || str.charAt(str.length() - 1) == '.') {
            return str;
        }
        return str + '.';
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public int dnsClass() {
        return this.dnsClass & 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DnsRecord) {
            DnsRecord dnsRecord = (DnsRecord) obj;
            int i4 = this.hashCode;
            return (i4 == 0 || i4 == dnsRecord.hashCode()) && type().intValue() == dnsRecord.type().intValue() && dnsClass() == dnsRecord.dnsClass() && name().equals(dnsRecord.name());
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.hashCode;
        if (i4 != 0) {
            return i4;
        }
        int hashCode = (this.name.hashCode() * 31) + (type().intValue() * 31) + dnsClass();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public long timeToLive() {
        return this.timeToLive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(name());
        sb.append(' ');
        sb.append(timeToLive());
        sb.append(' ');
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(' ');
        appendRecordClass.append(type().name());
        appendRecordClass.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public DnsRecordType type() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDnsRecord(String str, DnsRecordType dnsRecordType, int i4, long j4) {
        if (j4 >= 0) {
            this.name = appendTrailingDot(IDN.toASCII((String) ObjectUtil.checkNotNull(str, "name")));
            this.type = (DnsRecordType) ObjectUtil.checkNotNull(dnsRecordType, "type");
            this.dnsClass = (short) i4;
            this.timeToLive = j4;
            return;
        }
        throw new IllegalArgumentException("timeToLive: " + j4 + " (expected: >= 0)");
    }
}

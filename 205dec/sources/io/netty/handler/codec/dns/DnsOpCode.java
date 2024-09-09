package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DnsOpCode implements Comparable<DnsOpCode> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final DnsOpCode QUERY = new DnsOpCode(0, "QUERY");
    public static final DnsOpCode IQUERY = new DnsOpCode(1, "IQUERY");
    public static final DnsOpCode STATUS = new DnsOpCode(2, "STATUS");
    public static final DnsOpCode NOTIFY = new DnsOpCode(4, "NOTIFY");
    public static final DnsOpCode UPDATE = new DnsOpCode(5, "UPDATE");

    private DnsOpCode(int i4) {
        this(i4, "UNKNOWN");
    }

    public static DnsOpCode valueOf(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return new DnsOpCode(i4);
                        }
                        return UPDATE;
                    }
                    return NOTIFY;
                }
                return STATUS;
            }
            return IQUERY;
        }
        return QUERY;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DnsOpCode) && this.byteValue == ((DnsOpCode) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str == null) {
            String str2 = this.name + '(' + (this.byteValue & 255) + ')';
            this.text = str2;
            return str2;
        }
        return str;
    }

    public DnsOpCode(int i4, String str) {
        this.byteValue = (byte) i4;
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
    }

    @Override // java.lang.Comparable
    public int compareTo(DnsOpCode dnsOpCode) {
        return this.byteValue - dnsOpCode.byteValue;
    }
}

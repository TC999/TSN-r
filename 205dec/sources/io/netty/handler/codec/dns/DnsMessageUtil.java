package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class DnsMessageUtil {
    private DnsMessageUtil() {
    }

    private static StringBuilder appendAddresses(StringBuilder sb, DnsMessage dnsMessage) {
        if (dnsMessage instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) dnsMessage;
            SocketAddress sender = addressedEnvelope.sender();
            if (sender != null) {
                sb.append("from: ");
                sb.append(sender);
                sb.append(", ");
            }
            SocketAddress recipient = addressedEnvelope.recipient();
            if (recipient != null) {
                sb.append("to: ");
                sb.append(recipient);
                sb.append(", ");
            }
            return sb;
        }
        return sb;
    }

    private static void appendAllRecords(StringBuilder sb, DnsMessage dnsMessage) {
        appendRecords(sb, dnsMessage, DnsSection.QUESTION);
        appendRecords(sb, dnsMessage, DnsSection.ANSWER);
        appendRecords(sb, dnsMessage, DnsSection.AUTHORITY);
        appendRecords(sb, dnsMessage, DnsSection.ADDITIONAL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendQuery(StringBuilder sb, DnsQuery dnsQuery) {
        appendQueryHeader(sb, dnsQuery);
        appendAllRecords(sb, dnsQuery);
        return sb;
    }

    private static void appendQueryHeader(StringBuilder sb, DnsQuery dnsQuery) {
        sb.append(StringUtil.simpleClassName(dnsQuery));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsQuery);
        appendAddresses.append(dnsQuery.id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb.append(", RD");
        }
        if (dnsQuery.z() != 0) {
            sb.append(", Z: ");
            sb.append(dnsQuery.z());
        }
        sb.append(')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendRecordClass(StringBuilder sb, int i4) {
        int i5 = i4 & 65535;
        String str = i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 254 ? i5 != 255 ? null : "ANY" : "NONE" : "HESIOD" : "CHAOS" : "CSNET" : "IN";
        if (str != null) {
            sb.append(str);
        } else {
            sb.append("UNKNOWN(");
            sb.append(i5);
            sb.append(')');
        }
        return sb;
    }

    private static void appendRecords(StringBuilder sb, DnsMessage dnsMessage, DnsSection dnsSection) {
        int count = dnsMessage.count(dnsSection);
        for (int i4 = 0; i4 < count; i4++) {
            sb.append(StringUtil.NEWLINE);
            sb.append('\t');
            sb.append(dnsMessage.recordAt(dnsSection, i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendResponse(StringBuilder sb, DnsResponse dnsResponse) {
        appendResponseHeader(sb, dnsResponse);
        appendAllRecords(sb, dnsResponse);
        return sb;
    }

    private static void appendResponseHeader(StringBuilder sb, DnsResponse dnsResponse) {
        boolean z3;
        sb.append(StringUtil.simpleClassName(dnsResponse));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsResponse);
        appendAddresses.append(dnsResponse.id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.opCode());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.code());
        appendAddresses.append(',');
        boolean z4 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb.append(" RD");
            z3 = false;
        } else {
            z3 = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb.append(" AA");
            z3 = false;
        }
        if (dnsResponse.isTruncated()) {
            sb.append(" TC");
            z3 = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb.append(" RA");
        } else {
            z4 = z3;
        }
        if (dnsResponse.z() != 0) {
            if (!z4) {
                sb.append(',');
            }
            sb.append(" Z: ");
            sb.append(dnsResponse.z());
        }
        if (z4) {
            sb.setCharAt(sb.length() - 1, ')');
        } else {
            sb.append(')');
        }
    }
}

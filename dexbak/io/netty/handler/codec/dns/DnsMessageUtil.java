package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        appendAddresses.append(dnsQuery.mo12686id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb.append(", RD");
        }
        if (dnsQuery.mo12685z() != 0) {
            sb.append(", Z: ");
            sb.append(dnsQuery.mo12685z());
        }
        sb.append(')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendRecordClass(StringBuilder sb, int i) {
        int i2 = i & 65535;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 254 ? i2 != 255 ? null : "ANY" : "NONE" : "HESIOD" : "CHAOS" : "CSNET" : "IN";
        if (str != null) {
            sb.append(str);
        } else {
            sb.append("UNKNOWN(");
            sb.append(i2);
            sb.append(')');
        }
        return sb;
    }

    private static void appendRecords(StringBuilder sb, DnsMessage dnsMessage, DnsSection dnsSection) {
        int count = dnsMessage.count(dnsSection);
        for (int i = 0; i < count; i++) {
            sb.append(StringUtil.NEWLINE);
            sb.append('\t');
            sb.append(dnsMessage.recordAt(dnsSection, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder appendResponse(StringBuilder sb, DnsResponse dnsResponse) {
        appendResponseHeader(sb, dnsResponse);
        appendAllRecords(sb, dnsResponse);
        return sb;
    }

    private static void appendResponseHeader(StringBuilder sb, DnsResponse dnsResponse) {
        boolean z;
        sb.append(StringUtil.simpleClassName(dnsResponse));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsResponse);
        appendAddresses.append(dnsResponse.mo12686id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.opCode());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.code());
        appendAddresses.append(StringUtil.COMMA);
        boolean z2 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb.append(" RD");
            z = false;
        } else {
            z = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb.append(" AA");
            z = false;
        }
        if (dnsResponse.isTruncated()) {
            sb.append(" TC");
            z = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb.append(" RA");
        } else {
            z2 = z;
        }
        if (dnsResponse.mo12685z() != 0) {
            if (!z2) {
                sb.append(StringUtil.COMMA);
            }
            sb.append(" Z: ");
            sb.append(dnsResponse.mo12685z());
        }
        if (z2) {
            sb.setCharAt(sb.length() - 1, ')');
        } else {
            sb.append(')');
        }
    }
}

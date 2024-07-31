package io.netty.handler.codec.http.cookie;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.InternalThreadLocalMap;
import java.util.BitSet;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class CookieUtil {
    private static final BitSet VALID_COOKIE_NAME_OCTETS = validCookieNameOctets();
    private static final BitSet VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets();
    private static final BitSet VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS = validCookieAttributeValueOctets();

    private CookieUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(StringBuilder sb, String str, long j) {
        sb.append(str);
        sb.append('=');
        sb.append(j);
        sb.append(';');
        sb.append(HttpConstants.SP_CHAR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addQuoted(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str);
        sb.append('=');
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(';');
        sb.append(HttpConstants.SP_CHAR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int firstInvalidCookieNameOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_NAME_OCTETS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int firstInvalidCookieValueOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_VALUE_OCTETS);
    }

    static int firstInvalidOctet(CharSequence charSequence, BitSet bitSet) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (!bitSet.get(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder stringBuilder() {
        return InternalThreadLocalMap.get().stringBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String stripTrailingSeparator(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String stripTrailingSeparatorOrNull(StringBuilder sb) {
        if (sb.length() == 0) {
            return null;
        }
        return stripTrailingSeparator(sb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharSequence unwrapValue(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 0 || charSequence.charAt(0) != '\"') {
            return charSequence;
        }
        if (length >= 2) {
            int i = length - 1;
            if (charSequence.charAt(i) == '\"') {
                return length == 2 ? "" : charSequence.subSequence(1, i);
            }
        }
        return null;
    }

    private static BitSet validCookieAttributeValueOctets() {
        BitSet bitSet = new BitSet();
        for (int i = 32; i < 127; i++) {
            bitSet.set(i);
        }
        bitSet.set(59, false);
        return bitSet;
    }

    private static BitSet validCookieNameOctets() {
        BitSet bitSet = new BitSet();
        for (int i = 32; i < 127; i++) {
            bitSet.set(i);
        }
        int[] iArr = {40, 41, 60, 62, 64, 44, 59, 58, 92, 34, 47, 91, 93, 63, 61, 123, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI, 32, 9};
        for (int i2 = 0; i2 < 19; i2++) {
            bitSet.set(iArr[i2], false);
        }
        return bitSet;
    }

    private static BitSet validCookieValueOctets() {
        BitSet bitSet = new BitSet();
        bitSet.set(33);
        for (int i = 35; i <= 43; i++) {
            bitSet.set(i);
        }
        for (int i2 = 45; i2 <= 58; i2++) {
            bitSet.set(i2);
        }
        for (int i3 = 60; i3 <= 91; i3++) {
            bitSet.set(i3);
        }
        for (int i4 = 93; i4 <= 126; i4++) {
            bitSet.set(i4);
        }
        return bitSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String validateAttributeValue(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String trim = str2.trim();
        if (trim.isEmpty()) {
            return null;
        }
        int firstInvalidOctet = firstInvalidOctet(trim, VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS);
        if (firstInvalidOctet == -1) {
            return trim;
        }
        throw new IllegalArgumentException(str + " contains the prohibited characters: " + trim.charAt(firstInvalidOctet));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append('=');
        sb.append(str2);
        sb.append(';');
        sb.append(HttpConstants.SP_CHAR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(StringBuilder sb, String str) {
        sb.append(str);
        sb.append(';');
        sb.append(HttpConstants.SP_CHAR);
    }
}

package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.BitSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class CookieUtil {
    private static final BitSet VALID_COOKIE_NAME_OCTETS = validCookieNameOctets();
    private static final BitSet VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets();
    private static final BitSet VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS = validCookieAttributeValueOctets();

    private CookieUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(StringBuilder sb, String str, long j4) {
        sb.append(str);
        sb.append('=');
        sb.append(j4);
        sb.append(';');
        sb.append(' ');
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
        sb.append(' ');
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
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (!bitSet.get(charSequence.charAt(i4))) {
                return i4;
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
            int i4 = length - 1;
            if (charSequence.charAt(i4) == '\"') {
                return length == 2 ? "" : charSequence.subSequence(1, i4);
            }
        }
        return null;
    }

    private static BitSet validCookieAttributeValueOctets() {
        BitSet bitSet = new BitSet();
        for (int i4 = 32; i4 < 127; i4++) {
            bitSet.set(i4);
        }
        bitSet.set(59, false);
        return bitSet;
    }

    private static BitSet validCookieNameOctets() {
        BitSet bitSet = new BitSet();
        for (int i4 = 32; i4 < 127; i4++) {
            bitSet.set(i4);
        }
        int[] iArr = {40, 41, 60, 62, 64, 44, 59, 58, 92, 34, 47, 91, 93, 63, 61, 123, 125, 32, 9};
        for (int i5 = 0; i5 < 19; i5++) {
            bitSet.set(iArr[i5], false);
        }
        return bitSet;
    }

    private static BitSet validCookieValueOctets() {
        BitSet bitSet = new BitSet();
        bitSet.set(33);
        for (int i4 = 35; i4 <= 43; i4++) {
            bitSet.set(i4);
        }
        for (int i5 = 45; i5 <= 58; i5++) {
            bitSet.set(i5);
        }
        for (int i6 = 60; i6 <= 91; i6++) {
            bitSet.set(i6);
        }
        for (int i7 = 93; i7 <= 126; i7++) {
            bitSet.set(i7);
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
        sb.append(' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(StringBuilder sb, String str) {
        sb.append(str);
        sb.append(';');
        sb.append(' ');
    }
}

package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
        r10 = r8.nextElement();
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0130, code lost:
        if (r10 != null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010e  */
    static {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.<clinit>():void");
    }

    private NetUtil() {
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (isValidIpV6Address(str)) {
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length() - 1);
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return getIPv6ByName(str, true);
        }
        return null;
    }

    private static int decimalDigit(String str, int i4) {
        return str.charAt(i4) - '0';
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    public static String getHostname(InetSocketAddress inetSocketAddress) {
        return PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0168, code lost:
        if ((r6 - r9) <= 3) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0186, code lost:
        if (r19.charAt(0) == ':') goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0199, code lost:
        if (r7 <= 2) goto L166;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] getIPv6ByName(java.lang.CharSequence r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    private static boolean inRangeEndExclusive(int i4, int i5, int i6) {
        return i4 >= i5 && i4 < i6;
    }

    public static String intToIpAddress(int i4) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i4 >> 24) & 255);
        sb.append('.');
        sb.append((i4 >> 16) & 255);
        sb.append('.');
        sb.append((i4 >> 8) & 255);
        sb.append('.');
        sb.append(i4 & 255);
        return sb.toString();
    }

    private static byte ipv4WordToByte(String str, int i4, int i5) {
        int decimalDigit = decimalDigit(str, i4);
        int i6 = i4 + 1;
        if (i6 == i5) {
            return (byte) decimalDigit;
        }
        int decimalDigit2 = (decimalDigit * 10) + decimalDigit(str, i6);
        int i7 = i6 + 1;
        return i7 == i5 ? (byte) decimalDigit2 : (byte) ((decimalDigit2 * 10) + decimalDigit(str, i7));
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c4) {
        return (c4 >= '0' && c4 <= '9') || (c4 >= 'A' && c4 <= 'F') || (c4 >= 'a' && c4 <= 'f');
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i4, int i5, int i6) {
        boolean z3 = i6 + i5 >= 14;
        return i4 <= 12 && i4 >= 2 && (!z3 || i5 < 12) && isValidIPv4MappedSeparators(bArr[i4 + (-1)], bArr[i4 + (-2)], z3) && PlatformDependent.isZero(bArr, 0, i4 + (-3));
    }

    private static boolean isValidIPv4MappedChar(char c4) {
        return c4 == 'f' || c4 == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b4, byte b5, boolean z3) {
        return b4 == b5 && (b4 == 0 || (!z3 && b5 == -1));
    }

    public static boolean isValidIpV4Address(CharSequence charSequence) {
        return isValidIpV4Address(charSequence, 0, charSequence.length());
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence, int i4, int i5) {
        int indexOf;
        int i6;
        int indexOf2;
        int i7;
        int indexOf3;
        int i8 = i5 - i4;
        return i8 <= 15 && i8 >= 7 && (indexOf = AsciiString.indexOf(charSequence, '.', i4 + 1)) > 0 && isValidIpV4Word(charSequence, i4, indexOf) && (indexOf2 = AsciiString.indexOf(charSequence, '.', (i6 = indexOf + 2))) > 0 && isValidIpV4Word(charSequence, i6 - 1, indexOf2) && (indexOf3 = AsciiString.indexOf(charSequence, '.', (i7 = indexOf2 + 2))) > 0 && isValidIpV4Word(charSequence, i7 - 1, indexOf3) && isValidIpV4Word(charSequence, indexOf3 + 1, i5);
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i4, int i5) {
        char charAt;
        char charAt2;
        int i6 = i5 - i4;
        if (i6 < 1 || i6 > 3 || (charAt = charSequence.charAt(i4)) < '0') {
            return false;
        }
        if (i6 != 3) {
            if (charAt <= '9') {
                return i6 == 1 || isValidNumericChar(charSequence.charAt(i4 + 1));
            }
            return false;
        }
        char charAt3 = charSequence.charAt(i4 + 1);
        if (charAt3 < '0' || (charAt2 = charSequence.charAt(i4 + 2)) < '0') {
            return false;
        }
        if (charAt > '1' || charAt3 > '9' || charAt2 > '9') {
            if (charAt != '2' || charAt3 > '5') {
                return false;
            }
            if (charAt2 > '5' && (charAt3 >= '5' || charAt2 > '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }

    private static boolean isValidNumericChar(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z3) {
        int length = str.length();
        if (z3) {
            StringBuilder sb = new StringBuilder(length + 1 + str2.length());
            sb.append(str);
            return sb;
        }
        StringBuilder sb2 = new StringBuilder(length + 3 + str2.length());
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb2.append(str);
            return sb2;
        }
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process start = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine.startsWith(str)) {
                for (int length = readLine.length() - 1; length > str.length(); length--) {
                    if (!Character.isDigit(readLine.charAt(length))) {
                        Integer valueOf = Integer.valueOf(readLine.substring(length + 1));
                        bufferedReader.close();
                        start.destroy();
                        return valueOf;
                    }
                }
            }
            bufferedReader.close();
            start.destroy();
            return null;
        } catch (Throwable th) {
            if (start != null) {
                start.destroy();
            }
            throw th;
        }
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder newSocketAddressStringBuilder;
        String valueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            String hostname = getHostname(inetSocketAddress);
            newSocketAddressStringBuilder = newSocketAddressStringBuilder(hostname, valueOf, !isValidIpV6Address(hostname));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            newSocketAddressStringBuilder = newSocketAddressStringBuilder(toAddressString(address), valueOf, address instanceof Inet4Address);
        }
        newSocketAddressStringBuilder.append(':');
        newSocketAddressStringBuilder.append(valueOf);
        return newSocketAddressStringBuilder.toString();
    }

    static byte[] validIpV4ToBytes(String str) {
        int indexOf = str.indexOf(46, 1);
        int i4 = indexOf + 1;
        int indexOf2 = str.indexOf(46, indexOf + 2);
        int indexOf3 = str.indexOf(46, indexOf2 + 2);
        return new byte[]{ipv4WordToByte(str, 0, indexOf), ipv4WordToByte(str, i4, indexOf2), ipv4WordToByte(str, indexOf2 + 1, indexOf3), ipv4WordToByte(str, indexOf3 + 1, str.length())};
    }

    public static String bytesToIpAddress(byte[] bArr, int i4, int i5) {
        if (i5 != 4) {
            if (i5 == 16) {
                return toAddressString(bArr, i4, false);
            }
            throw new IllegalArgumentException("length: " + i5 + " (expected: 4 or 16)");
        }
        StringBuilder sb = new StringBuilder(15);
        sb.append(bArr[i4] & 255);
        sb.append('.');
        sb.append(bArr[i4 + 1] & 255);
        sb.append('.');
        sb.append(bArr[i4 + 2] & 255);
        sb.append('.');
        sb.append(bArr[i4 + 3] & 255);
        return sb.toString();
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z3) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z3);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i4;
        int i5;
        int length = charSequence.length();
        int i6 = 2;
        if (length < 2) {
            return false;
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '[') {
            length--;
            if (charSequence.charAt(length) != ']') {
                return false;
            }
            charAt = charSequence.charAt(1);
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (charAt != ':') {
            i6 = 0;
            i5 = -1;
        } else if (charSequence.charAt(i4 + 1) != ':') {
            return false;
        } else {
            int i7 = i4;
            i4 += 2;
            i5 = i7;
        }
        int i8 = i4;
        int i9 = 0;
        while (true) {
            if (i8 >= length) {
                break;
            }
            char charAt2 = charSequence.charAt(i8);
            if (!isValidHexChar(charAt2)) {
                if (charAt2 == '%') {
                    length = i8;
                    break;
                } else if (charAt2 == '.') {
                    if ((i5 >= 0 || i6 == 6) && ((i6 != 7 || i5 < i4) && i6 <= 7)) {
                        int i10 = i8 - i9;
                        int i11 = i10 - 2;
                        if (isValidIPv4MappedChar(charSequence.charAt(i11))) {
                            if (!isValidIPv4MappedChar(charSequence.charAt(i11 - 1)) || !isValidIPv4MappedChar(charSequence.charAt(i11 - 2)) || !isValidIPv4MappedChar(charSequence.charAt(i11 - 3))) {
                                return false;
                            }
                            i11 -= 5;
                        }
                        while (i11 >= i4) {
                            char charAt3 = charSequence.charAt(i11);
                            if (charAt3 != '0' && charAt3 != ':') {
                                return false;
                            }
                            i11--;
                        }
                        int indexOf = AsciiString.indexOf(charSequence, '%', i10 + 7);
                        if (indexOf >= 0) {
                            length = indexOf;
                        }
                        return isValidIpV4Address(charSequence, i10, length);
                    }
                    return false;
                } else if (charAt2 != ':' || i6 > 7) {
                    return false;
                } else {
                    int i12 = i8 - 1;
                    if (charSequence.charAt(i12) != ':') {
                        i9 = 0;
                    } else if (i5 >= 0) {
                        return false;
                    } else {
                        i5 = i12;
                    }
                    i6++;
                }
            } else if (i9 >= 4) {
                return false;
            } else {
                i9++;
            }
            i8++;
        }
        if (i5 < 0) {
            return i6 == 7 && i9 > 0;
        }
        if (i5 + 2 != length) {
            if (i9 <= 0) {
                return false;
            }
            if (i6 >= 8 && i5 > i4) {
                return false;
            }
        }
        return true;
    }

    public static String toAddressString(InetAddress inetAddress, boolean z3) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            return toAddressString(inetAddress.getAddress(), 0, z3);
        }
        throw new IllegalArgumentException("Unhandled type: " + inetAddress);
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i4, int i5) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i4, i5);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i4, i5);
        }
        return isValidIpV4Address0(charSequence, i4, i5);
    }

    private static boolean isValidIpV4Address(String str, int i4, int i5) {
        int indexOf;
        int i6;
        int indexOf2;
        int i7;
        int indexOf3;
        int i8 = i5 - i4;
        return i8 <= 15 && i8 >= 7 && (indexOf = str.indexOf(46, i4 + 1)) > 0 && isValidIpV4Word(str, i4, indexOf) && (indexOf2 = str.indexOf(46, (i6 = indexOf + 2))) > 0 && isValidIpV4Word(str, i6 - 1, indexOf2) && (indexOf3 = str.indexOf(46, (i7 = indexOf2 + 2))) > 0 && isValidIpV4Word(str, i7 - 1, indexOf3) && isValidIpV4Word(str, indexOf3 + 1, i5);
    }

    private static String toAddressString(byte[] bArr, int i4, boolean z3) {
        int i5;
        int i6;
        int[] iArr = new int[8];
        int i7 = i4 + 8;
        while (true) {
            i5 = 1;
            if (i4 >= i7) {
                break;
            }
            int i8 = i4 << 1;
            iArr[i4] = (bArr[i8 + 1] & 255) | ((bArr[i8] & 255) << 8);
            i4++;
        }
        int i9 = -1;
        boolean z4 = false;
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        int i13 = -1;
        while (i10 < 8) {
            if (iArr[i10] == 0) {
                if (i11 < 0) {
                    i11 = i10;
                }
            } else if (i11 >= 0) {
                int i14 = i10 - i11;
                if (i14 > i12) {
                    i12 = i14;
                } else {
                    i11 = i13;
                }
                i13 = i11;
                i11 = -1;
            }
            i10++;
        }
        if (i11 < 0 || (i6 = i10 - i11) <= i12) {
            i11 = i13;
        } else {
            i12 = i6;
        }
        if (i12 == 1) {
            i12 = 0;
        } else {
            i9 = i11;
        }
        int i15 = i12 + i9;
        StringBuilder sb = new StringBuilder(39);
        if (i15 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i5 < 8) {
                sb.append(':');
                sb.append(Integer.toHexString(iArr[i5]));
                i5++;
            }
        } else {
            if (inRangeEndExclusive(0, i9, i15)) {
                sb.append("::");
                if (z3 && i15 == 5 && iArr[5] == 65535) {
                    z4 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i5 < 8) {
                if (!inRangeEndExclusive(i5, i9, i15)) {
                    if (!inRangeEndExclusive(i5 - 1, i9, i15)) {
                        if (z4 && i5 != 6) {
                            sb.append('.');
                        } else {
                            sb.append(':');
                        }
                    }
                    if (z4 && i5 > 5) {
                        sb.append(iArr[i5] >> 8);
                        sb.append('.');
                        sb.append(iArr[i5] & 255);
                    } else {
                        sb.append(Integer.toHexString(iArr[i5]));
                    }
                } else if (!inRangeEndExclusive(i5 - 1, i9, i15)) {
                    sb.append("::");
                }
                i5++;
            }
        }
        return sb.toString();
    }

    public static String toSocketAddressString(String str, int i4) {
        String valueOf = String.valueOf(i4);
        StringBuilder newSocketAddressStringBuilder = newSocketAddressStringBuilder(str, valueOf, !isValidIpV6Address(str));
        newSocketAddressStringBuilder.append(':');
        newSocketAddressStringBuilder.append(valueOf);
        return newSocketAddressStringBuilder.toString();
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i4, int i5) {
        int indexOf;
        int i6;
        int indexOf2;
        int i7;
        int indexOf3;
        int i8 = i5 - i4;
        return i8 <= 15 && i8 >= 7 && (indexOf = asciiString.indexOf('.', i4 + 1)) > 0 && isValidIpV4Word(asciiString, i4, indexOf) && (indexOf2 = asciiString.indexOf('.', (i6 = indexOf + 2))) > 0 && isValidIpV4Word(asciiString, i6 - 1, indexOf2) && (indexOf3 = asciiString.indexOf('.', (i7 = indexOf2 + 2))) > 0 && isValidIpV4Word(asciiString, i7 - 1, indexOf3) && isValidIpV4Word(asciiString, indexOf3 + 1, i5);
    }
}

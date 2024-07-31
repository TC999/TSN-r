package io.netty.util;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.StringTokenizer;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class NetUtil {
    private static final int IPV4_BYTE_COUNT = 4;
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

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d6, code lost:
        r9 = r7.nextElement();
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012e, code lost:
        if (r9 != null) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    static {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.<clinit>():void");
    }

    private NetUtil() {
    }

    public static String bytesToIpAddress(byte[] bArr, int i, int i2) {
        if (i2 == 4) {
            StringBuilder sb = new StringBuilder(15);
            int i3 = i + 1;
            sb.append((bArr[i] >> BinaryMemcacheOpcodes.FLUSHQ) & 255);
            sb.append('.');
            int i4 = i3 + 1;
            sb.append((bArr[i3] >> 16) & 255);
            sb.append('.');
            sb.append((bArr[i4] >> 8) & 255);
            sb.append('.');
            sb.append(bArr[i4 + 1] & UByte.f41242c);
            return sb.toString();
        } else if (i2 == 16) {
            StringBuilder sb2 = new StringBuilder(39);
            int i5 = i + 14;
            while (i < i5) {
                StringUtil.toHexString(sb2, bArr, i, 2);
                sb2.append(':');
                i += 2;
            }
            StringUtil.toHexString(sb2, bArr, i, 2);
            return sb2.toString();
        } else {
            throw new IllegalArgumentException("length: " + i2 + " (expected: 4 or 16)");
        }
    }

    private static void convertToBytes(String str, byte[] bArr, int i) {
        int length = str.length();
        int i2 = 0;
        bArr[i] = 0;
        int i3 = i + 1;
        bArr[i3] = 0;
        if (length > 3) {
            bArr[i] = (byte) ((getIntValue(str.charAt(0)) << 4) | bArr[i]);
            i2 = 1;
        }
        if (length > 2) {
            bArr[i] = (byte) (getIntValue(str.charAt(i2)) | bArr[i]);
            i2++;
        }
        if (length > 1) {
            bArr[i3] = (byte) ((getIntValue(str.charAt(i2)) << 4) | bArr[i3]);
            i2++;
        }
        bArr[i3] = (byte) ((getIntValue(str.charAt(i2)) & 15) | bArr[i3]);
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        int i = 0;
        if (isValidIpV4Address(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            byte[] bArr = new byte[4];
            while (i < 4) {
                bArr[i] = (byte) Integer.parseInt(stringTokenizer.nextToken());
                i++;
            }
            return bArr;
        } else if (isValidIpV6Address(str)) {
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length() - 1);
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(str, ":.", true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            String str2 = "";
            String str3 = "";
            int i2 = -1;
            while (stringTokenizer2.hasMoreTokens()) {
                String nextToken = stringTokenizer2.nextToken();
                if (":".equals(nextToken)) {
                    if (":".equals(str3)) {
                        i2 = arrayList.size();
                    } else if (!str3.isEmpty()) {
                        arrayList.add(str3);
                    }
                } else if (".".equals(nextToken)) {
                    arrayList2.add(str3);
                }
                String str4 = str3;
                str3 = nextToken;
                str2 = str4;
            }
            if (":".equals(str2)) {
                if (":".equals(str3)) {
                    i2 = arrayList.size();
                } else {
                    arrayList.add(str3);
                }
            } else if (".".equals(str2)) {
                arrayList2.add(str3);
            }
            int i3 = arrayList2.isEmpty() ? 8 : 6;
            if (i2 != -1) {
                int size = i3 - arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.add(i2, "0");
                }
            }
            byte[] bArr2 = new byte[16];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                convertToBytes((String) arrayList.get(i5), bArr2, i5 << 1);
            }
            while (i < arrayList2.size()) {
                bArr2[i + 12] = (byte) (Integer.parseInt((String) arrayList2.get(i)) & 255);
                i++;
            }
            return bArr2;
        } else {
            return null;
        }
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    private static int getIntValue(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (Character.toLowerCase(c)) {
                    case 'a':
                        return 10;
                    case 'b':
                        return 11;
                    case 'c':
                        return 12;
                    case 'd':
                        return 13;
                    case 'e':
                        return 14;
                    case 'f':
                        return 15;
                    default:
                        return 0;
                }
        }
    }

    private static boolean inRangeEndExclusive(int i, int i2, int i3) {
        return i >= i2 && i < i3;
    }

    public static String intToIpAddress(int i) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i >> 24) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append(i & 255);
        return sb.toString();
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private static boolean isValidIp4Word(String str) {
        if (str.length() < 1 || str.length() > 3) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return Integer.parseInt(str) <= 255;
    }

    public static boolean isValidIpV4Address(String str) {
        int length = str.length();
        if (length > 15) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '.') {
                i++;
                if (i > 3 || sb.length() == 0 || Integer.parseInt(sb.toString()) > 255) {
                    return false;
                }
                sb.delete(0, sb.length());
            } else if (!Character.isDigit(charAt) || sb.length() > 2) {
                return false;
            } else {
                sb.append(charAt);
            }
        }
        return sb.length() != 0 && Integer.parseInt(sb.toString()) <= 255 && i == 3;
    }

    public static boolean isValidIpV6Address(String str) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int length2 = str.length();
        if (length2 < 2) {
            return false;
        }
        if (str.charAt(0) != '[') {
            i = 0;
        } else if (str.charAt(length2 - 1) != ']') {
            return false;
        } else {
            length2--;
            i = 1;
        }
        int indexOf = str.indexOf(37, i);
        if (indexOf >= 0) {
            length2 = indexOf;
        }
        int i2 = i;
        int i3 = 0;
        char c = 0;
        int i4 = 0;
        boolean z = false;
        while (i2 < length2) {
            char charAt = str.charAt(i2);
            if (charAt == '.') {
                i3++;
                if (i3 > 3 || !isValidIp4Word(sb.toString())) {
                    return false;
                }
                if (i4 != 6 && !z) {
                    return false;
                }
                if (i4 == 7 && str.charAt(i) != ':' && str.charAt(i + 1) != ':') {
                    return false;
                }
                sb.delete(0, sb.length());
            } else if (charAt != ':') {
                if (sb.length() > 3 || !isValidHexChar(charAt)) {
                    return false;
                }
                sb.append(charAt);
            } else if ((i2 == i && (str.length() <= i2 || str.charAt(i2 + 1) != ':')) || (i4 = i4 + 1) > 7 || i3 > 0) {
                return false;
            } else {
                if (c == ':') {
                    if (z) {
                        return false;
                    }
                    z = true;
                }
                sb.delete(0, sb.length());
            }
            i2++;
            c = charAt;
        }
        if (i3 > 0) {
            return i3 == 3 && isValidIp4Word(sb.toString()) && i4 < 7;
        } else if (i4 == 7 || z) {
            return (sb.length() == 0 && str.charAt((length + (-1)) - i) == ':' && str.charAt((length - 2) - i) != ':') ? false : true;
        } else {
            return false;
        }
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0183, code lost:
        if (r18.charAt(0) == ':') goto L211;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.Inet6Address getByName(java.lang.CharSequence r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 705
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getByName(java.lang.CharSequence, boolean):java.net.Inet6Address");
    }

    public static String toAddressString(InetAddress inetAddress, boolean z) {
        int i;
        int i2;
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            int[] iArr = new int[8];
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                i = 1;
                if (i3 >= 8) {
                    break;
                }
                int i4 = i3 << 1;
                iArr[i3] = (address[i4 + 1] & UByte.f41242c) | ((address[i4] & UByte.f41242c) << 8);
                i3++;
            }
            int i5 = -1;
            int i6 = 0;
            int i7 = -1;
            int i8 = 0;
            int i9 = -1;
            while (i6 < 8) {
                if (iArr[i6] == 0) {
                    if (i7 < 0) {
                        i7 = i6;
                    }
                } else if (i7 >= 0) {
                    int i10 = i6 - i7;
                    if (i10 > i8) {
                        i8 = i10;
                    } else {
                        i7 = i9;
                    }
                    i9 = i7;
                    i7 = -1;
                }
                i6++;
            }
            if (i7 < 0 || (i2 = i6 - i7) <= i8) {
                i7 = i9;
            } else {
                i8 = i2;
            }
            if (i8 == 1) {
                i8 = 0;
            } else {
                i5 = i7;
            }
            int i11 = i8 + i5;
            StringBuilder sb = new StringBuilder(39);
            if (i11 < 0) {
                sb.append(Integer.toHexString(iArr[0]));
                while (i < 8) {
                    sb.append(':');
                    sb.append(Integer.toHexString(iArr[i]));
                    i++;
                }
            } else {
                if (inRangeEndExclusive(0, i5, i11)) {
                    sb.append("::");
                    if (z && i11 == 5 && iArr[5] == 65535) {
                        z2 = true;
                    }
                } else {
                    sb.append(Integer.toHexString(iArr[0]));
                }
                while (i < 8) {
                    if (!inRangeEndExclusive(i, i5, i11)) {
                        if (!inRangeEndExclusive(i - 1, i5, i11)) {
                            if (z2 && i != 6) {
                                sb.append('.');
                            } else {
                                sb.append(':');
                            }
                        }
                        if (z2 && i > 5) {
                            sb.append(iArr[i] >> 8);
                            sb.append('.');
                            sb.append(iArr[i] & 255);
                        } else {
                            sb.append(Integer.toHexString(iArr[i]));
                        }
                    } else if (!inRangeEndExclusive(i - 1, i5, i11)) {
                        sb.append("::");
                    }
                    i++;
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Unhandled type: " + inetAddress.getClass());
    }
}

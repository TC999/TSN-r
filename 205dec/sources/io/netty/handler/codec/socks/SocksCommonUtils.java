package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class SocksCommonUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FIRST_ADDRESS_OCTET_SHIFT = 24;
    private static final int SECOND_ADDRESS_OCTET_SHIFT = 16;
    private static final int THIRD_ADDRESS_OCTET_SHIFT = 8;
    private static final int XOR_DEFAULT_VALUE = 255;
    private static final char ipv6hextetSeparator = ':';
    public static final SocksRequest UNKNOWN_SOCKS_REQUEST = new UnknownSocksRequest();
    public static final SocksResponse UNKNOWN_SOCKS_RESPONSE = new UnknownSocksResponse();
    private static final char[] ipv6conseqZeroFiller = {':', ':'};

    private SocksCommonUtils() {
    }

    private static void appendHextet(StringBuilder sb, byte[] bArr, int i4) {
        StringUtil.toHexString(sb, bArr, i4 << 1, 2);
    }

    public static String intToIp(int i4) {
        return String.valueOf((i4 >> 24) & 255) + '.' + ((i4 >> 16) & 255) + '.' + ((i4 >> 8) & 255) + '.' + (i4 & 255);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
        r3 = r2;
        r4 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ipv6toCompressedForm(byte[] r8) {
        /*
            r0 = -1
            r1 = 0
            r2 = 0
            r3 = -1
            r4 = 0
        L5:
            r5 = 8
            if (r2 >= r5) goto L27
            int r5 = r2 * 2
            r6 = 0
        Lc:
            int r7 = r8.length
            if (r5 >= r7) goto L1e
            r7 = r8[r5]
            if (r7 != 0) goto L1e
            int r7 = r5 + 1
            r7 = r8[r7]
            if (r7 != 0) goto L1e
            int r5 = r5 + 2
            int r6 = r6 + 1
            goto Lc
        L1e:
            if (r6 <= r4) goto L22
            r3 = r2
            r4 = r6
        L22:
            int r5 = r5 / 2
            int r2 = r5 + 1
            goto L5
        L27:
            if (r3 == r0) goto L45
            r0 = 2
            if (r4 >= r0) goto L2d
            goto L45
        L2d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r2 = 39
            r0.<init>(r2)
            ipv6toStr(r0, r8, r1, r3)
            char[] r1 = io.netty.handler.codec.socks.SocksCommonUtils.ipv6conseqZeroFiller
            r0.append(r1)
            int r3 = r3 + r4
            ipv6toStr(r0, r8, r3, r5)
            java.lang.String r8 = r0.toString()
            return r8
        L45:
            java.lang.String r8 = ipv6toStr(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCommonUtils.ipv6toCompressedForm(byte[]):java.lang.String");
    }

    public static String ipv6toStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        ipv6toStr(sb, bArr, 0, 8);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readUsAscii(ByteBuf byteBuf, int i4) {
        String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), i4, CharsetUtil.US_ASCII);
        byteBuf.skipBytes(i4);
        return byteBuf2;
    }

    private static void ipv6toStr(StringBuilder sb, byte[] bArr, int i4, int i5) {
        int i6 = i5 - 1;
        while (i4 < i6) {
            appendHextet(sb, bArr, i4);
            sb.append(':');
            i4++;
        }
        appendHextet(sb, bArr, i4);
    }
}

package com.kwad.sdk.core.a;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {
        static final b auS = new b(false, null, -1, true);
        static final b auT = new b(true, null, -1, false);
        private static final char[] auU = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] auV = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean auQ;
        private final byte[] auW = null;
        private final int auX = -1;
        private final boolean auY;

        private b(boolean z3, byte[] bArr, int i4, boolean z4) {
            this.auQ = z3;
            this.auY = z4;
        }

        private int b(byte[] bArr, int i4, int i5, byte[] bArr2) {
            char[] cArr = this.auQ ? auV : auU;
            int i6 = ((i5 + 0) / 3) * 3;
            int i7 = i6 + 0;
            int i8 = this.auX;
            if (i8 > 0 && i6 > (i8 / 4) * 3) {
                i6 = (i8 / 4) * 3;
            }
            int i9 = 0;
            int i10 = 0;
            while (i9 < i7) {
                int min = Math.min(i9 + i6, i7);
                int i11 = i9;
                int i12 = i10;
                while (i11 < min) {
                    int i13 = i11 + 1;
                    int i14 = i13 + 1;
                    int i15 = ((bArr[i11] & 255) << 16) | ((bArr[i13] & 255) << 8);
                    int i16 = i14 + 1;
                    int i17 = i15 | (bArr[i14] & 255);
                    int i18 = i12 + 1;
                    bArr2[i12] = (byte) cArr[(i17 >>> 18) & 63];
                    int i19 = i18 + 1;
                    bArr2[i18] = (byte) cArr[(i17 >>> 12) & 63];
                    int i20 = i19 + 1;
                    bArr2[i19] = (byte) cArr[(i17 >>> 6) & 63];
                    i12 = i20 + 1;
                    bArr2[i20] = (byte) cArr[i17 & 63];
                    i11 = i16;
                }
                int i21 = ((min - i9) / 3) * 4;
                i10 += i21;
                if (i21 == this.auX && min < i5) {
                    byte[] bArr3 = this.auW;
                    int length = bArr3.length;
                    int i22 = 0;
                    while (i22 < length) {
                        bArr2[i10] = bArr3[i22];
                        i22++;
                        i10++;
                    }
                }
                i9 = min;
            }
            if (i9 < i5) {
                int i23 = i9 + 1;
                int i24 = bArr[i9] & 255;
                int i25 = i10 + 1;
                bArr2[i10] = (byte) cArr[i24 >> 2];
                if (i23 == i5) {
                    int i26 = i25 + 1;
                    bArr2[i25] = (byte) cArr[(i24 << 4) & 63];
                    if (this.auY) {
                        int i27 = i26 + 1;
                        bArr2[i26] = 61;
                        int i28 = i27 + 1;
                        bArr2[i27] = 61;
                        return i28;
                    }
                    return i26;
                }
                int i29 = bArr[i23] & 255;
                int i30 = i25 + 1;
                bArr2[i25] = (byte) cArr[((i24 << 4) & 63) | (i29 >> 4)];
                int i31 = i30 + 1;
                bArr2[i30] = (byte) cArr[(i29 << 2) & 63];
                if (this.auY) {
                    int i32 = i31 + 1;
                    bArr2[i31] = 61;
                    return i32;
                }
                return i31;
            }
            return i10;
        }

        private final int dd(int i4) {
            int i5;
            if (this.auY) {
                i5 = ((i4 + 2) / 3) * 4;
            } else {
                int i6 = i4 % 3;
                i5 = ((i4 / 3) * 4) + (i6 == 0 ? 0 : i6 + 1);
            }
            int i7 = this.auX;
            return i7 > 0 ? i5 + (((i5 - 1) / i7) * this.auW.length) : i5;
        }

        public final byte[] encode(byte[] bArr) {
            int dd = dd(bArr.length);
            byte[] bArr2 = new byte[dd];
            int b4 = b(bArr, 0, bArr.length, bArr2);
            return b4 != dd ? Arrays.copyOf(bArr2, b4) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static b Ds() {
        return b.auS;
    }

    public static b Dt() {
        return b.auT;
    }

    public static a Du() {
        return a.auM;
    }

    public static a Dv() {
        return a.auN;
    }

    public static String dH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(Ds().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String dI(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(Du().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static boolean dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static final int[] auO;
        private final boolean auQ;
        private final boolean auR = false;
        static final a auM = new a(false, false);
        static final a auN = new a(true, false);
        private static final int[] auP = new int[256];

        static {
            int[] iArr = new int[256];
            auO = iArr;
            Arrays.fill(iArr, -1);
            for (int i4 = 0; i4 < b.auU.length; i4++) {
                auO[b.auU[i4]] = i4;
            }
            auO[61] = -2;
            Arrays.fill(auP, -1);
            for (int i5 = 0; i5 < b.auV.length; i5++) {
                auP[b.auV[i5]] = i5;
            }
            auP[61] = -2;
        }

        private a(boolean z3, boolean z4) {
            this.auQ = z3;
        }

        private int a(byte[] bArr, int i4, int i5) {
            int i6;
            int[] iArr = this.auQ ? auP : auO;
            int i7 = i5 + 0;
            int i8 = 0;
            if (i7 == 0) {
                return 0;
            }
            if (i7 < 2) {
                if (this.auR && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.auR) {
                int i9 = 0;
                while (true) {
                    if (i4 >= i5) {
                        break;
                    }
                    int i10 = i4 + 1;
                    int i11 = bArr[i4] & 255;
                    if (i11 == 61) {
                        i7 -= (i5 - i10) + 1;
                        break;
                    }
                    if (iArr[i11] == -1) {
                        i9++;
                    }
                    i4 = i10;
                }
                i7 -= i9;
            } else if (bArr[i5 - 1] == 61) {
                i8 = bArr[i5 - 2] == 61 ? 2 : 1;
            }
            if (i8 == 0 && (i6 = i7 & 3) != 0) {
                i8 = 4 - i6;
            }
            return (((i7 + 3) / 4) * 3) - i8;
        }

        public final byte[] decode(byte[] bArr) {
            int a4 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a4];
            int a5 = a(bArr, 0, bArr.length, bArr2);
            return a5 != a4 ? Arrays.copyOf(bArr2, a5) : bArr2;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
            if (r11[r8] == 61) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
            if (r4 != 18) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
            if (r4 != 6) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
            r14[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
            if (r4 != 0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
            r1 = r5 + 1;
            r14[r5] = (byte) (r3 >> 16);
            r5 = r1 + 1;
            r14[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
            if (r4 == 12) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
            if (r12 >= r13) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
            if (r10.auR == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
            r14 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
            if (r0[r11[r12]] >= 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ac, code lost:
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c1, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00ca, code lost:
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r11, int r12, int r13, byte[] r14) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.a.c.a.a(byte[], int, int, byte[]):int");
        }
    }
}

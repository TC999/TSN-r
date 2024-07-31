package com.kwad.sdk.core.p385a;

import android.text.TextUtils;
import com.kwad.sdk.crash.utils.C10737a;
import io.netty.handler.codec.http.HttpConstants;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.core.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9886c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* renamed from: com.kwad.sdk.core.a.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9888b {
        static final C9888b auS = new C9888b(false, null, -1, true);
        static final C9888b auT = new C9888b(true, null, -1, false);
        private static final char[] auU = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] auV = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean auQ;
        private final byte[] auW = null;
        private final int auX = -1;
        private final boolean auY;

        private C9888b(boolean z, byte[] bArr, int i, boolean z2) {
            this.auQ = z;
            this.auY = z2;
        }

        /* renamed from: b */
        private int m27432b(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.auQ ? auV : auU;
            int i3 = ((i2 + 0) / 3) * 3;
            int i4 = i3 + 0;
            int i5 = this.auX;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                int min = Math.min(i6 + i3, i4);
                int i8 = i6;
                int i9 = i7;
                while (i8 < min) {
                    int i10 = i8 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((bArr[i8] & UByte.f41242c) << 16) | ((bArr[i10] & UByte.f41242c) << 8);
                    int i13 = i11 + 1;
                    int i14 = i12 | (bArr[i11] & UByte.f41242c);
                    int i15 = i9 + 1;
                    bArr2[i9] = (byte) cArr[(i14 >>> 18) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i14 >>> 12) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) cArr[(i14 >>> 6) & 63];
                    i9 = i17 + 1;
                    bArr2[i17] = (byte) cArr[i14 & 63];
                    i8 = i13;
                }
                int i18 = ((min - i6) / 3) * 4;
                i7 += i18;
                if (i18 == this.auX && min < i2) {
                    byte[] bArr3 = this.auW;
                    int length = bArr3.length;
                    int i19 = 0;
                    while (i19 < length) {
                        bArr2[i7] = bArr3[i19];
                        i19++;
                        i7++;
                    }
                }
                i6 = min;
            }
            if (i6 < i2) {
                int i20 = i6 + 1;
                int i21 = bArr[i6] & UByte.f41242c;
                int i22 = i7 + 1;
                bArr2[i7] = (byte) cArr[i21 >> 2];
                if (i20 == i2) {
                    int i23 = i22 + 1;
                    bArr2[i22] = (byte) cArr[(i21 << 4) & 63];
                    if (this.auY) {
                        int i24 = i23 + 1;
                        bArr2[i23] = HttpConstants.EQUALS;
                        int i25 = i24 + 1;
                        bArr2[i24] = HttpConstants.EQUALS;
                        return i25;
                    }
                    return i23;
                }
                int i26 = bArr[i20] & UByte.f41242c;
                int i27 = i22 + 1;
                bArr2[i22] = (byte) cArr[((i21 << 4) & 63) | (i26 >> 4)];
                int i28 = i27 + 1;
                bArr2[i27] = (byte) cArr[(i26 << 2) & 63];
                if (this.auY) {
                    int i29 = i28 + 1;
                    bArr2[i28] = HttpConstants.EQUALS;
                    return i29;
                }
                return i28;
            }
            return i7;
        }

        /* renamed from: dd */
        private final int m27431dd(int i) {
            int i2;
            if (this.auY) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.auX;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.auW.length) : i2;
        }

        public final byte[] encode(byte[] bArr) {
            int m27431dd = m27431dd(bArr.length);
            byte[] bArr2 = new byte[m27431dd];
            int m27432b = m27432b(bArr, 0, bArr.length, bArr2);
            return m27432b != m27431dd ? Arrays.copyOf(bArr2, m27432b) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    /* renamed from: Ds */
    public static C9888b m27444Ds() {
        return C9888b.auS;
    }

    /* renamed from: Dt */
    public static C9888b m27443Dt() {
        return C9888b.auT;
    }

    /* renamed from: Du */
    public static C9887a m27442Du() {
        return C9887a.auM;
    }

    /* renamed from: Dv */
    public static C9887a m27441Dv() {
        return C9887a.auN;
    }

    /* renamed from: dH */
    public static String m27439dH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(m27444Ds().encode(str.getBytes()), C10737a.UTF_8);
    }

    /* renamed from: dI */
    public static String m27438dI(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(m27442Du().decode(str.substring(8)), C10737a.UTF_8) : str;
    }

    /* renamed from: dJ */
    public static boolean m27437dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    /* renamed from: com.kwad.sdk.core.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9887a {
        private static final int[] auO;
        private final boolean auQ;
        private final boolean auR = false;
        static final C9887a auM = new C9887a(false, false);
        static final C9887a auN = new C9887a(true, false);
        private static final int[] auP = new int[256];

        static {
            int[] iArr = new int[256];
            auO = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < C9888b.auU.length; i++) {
                auO[C9888b.auU[i]] = i;
            }
            auO[61] = -2;
            Arrays.fill(auP, -1);
            for (int i2 = 0; i2 < C9888b.auV.length; i2++) {
                auP[C9888b.auV[i2]] = i2;
            }
            auP[61] = -2;
        }

        private C9887a(boolean z, boolean z2) {
            this.auQ = z;
        }

        /* renamed from: a */
        private int m27436a(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.auQ ? auP : auO;
            int i4 = i2 + 0;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.auR && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.auR) {
                int i6 = 0;
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i7 = i + 1;
                    int i8 = bArr[i] & UByte.f41242c;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        public final byte[] decode(byte[] bArr) {
            int m27436a = m27436a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[m27436a];
            int m27435a = m27435a(bArr, 0, bArr.length, bArr2);
            return m27435a != m27436a ? Arrays.copyOf(bArr2, m27435a) : bArr2;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(C9886c.ISO_8859_1));
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
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int m27435a(byte[] r11, int r12, int r13, byte[] r14) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p385a.C9886c.C9887a.m27435a(byte[], int, int, byte[]):int");
        }
    }
}

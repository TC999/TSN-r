package io.netty.handler.codec.compression;

import io.netty.handler.codec.dns.DnsRecord;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;

    /* renamed from: SA */
    private final int[] f40199SA;

    /* renamed from: T */
    private final byte[] f40200T;

    /* renamed from: n */
    private final int f40201n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class PartitionResult {
        final int first;
        final int last;

        PartitionResult(int i, int i2) {
            this.first = i;
            this.last = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class StackEntry {

        /* renamed from: a */
        final int f40202a;

        /* renamed from: b */
        final int f40203b;

        /* renamed from: c */
        final int f40204c;

        /* renamed from: d */
        final int f40205d;

        StackEntry(int i, int i2, int i3, int i4) {
            this.f40202a = i;
            this.f40203b = i2;
            this.f40204c = i3;
            this.f40205d = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class TRBudget {
        int budget;
        int chance;

        TRBudget(int i, int i2) {
            this.budget = i;
            this.chance = i2;
        }

        boolean update(int i, int i2) {
            int i3 = this.budget - i2;
            this.budget = i3;
            if (i3 <= 0) {
                int i4 = this.chance - 1;
                this.chance = i4;
                if (i4 == 0) {
                    return false;
                }
                this.budget = i3 + i;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2DivSufSort(byte[] bArr, int[] iArr, int i) {
        this.f40200T = bArr;
        this.f40199SA = iArr;
        this.f40201n = i;
    }

    private static int BUCKET_B(int i, int i2) {
        return i | (i2 << 8);
    }

    private static int BUCKET_BSTAR(int i, int i2) {
        return (i << 8) | i2;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.f40200T;
        int[] iArr3 = this.f40199SA;
        int i = this.f40201n;
        int i2 = DnsRecord.CLASS_NONE;
        int i3 = 0;
        int i4 = 0;
        while (i2 >= 0) {
            int i5 = i2 + 1;
            int i6 = iArr2[BUCKET_BSTAR(i2, i5)];
            int i7 = 0;
            int i8 = -1;
            for (int i9 = iArr[i5]; i6 <= i9; i9--) {
                int i10 = iArr3[i9];
                if (i10 >= 0) {
                    int i11 = i10 - 1;
                    if (i11 < 0) {
                        i11 = i - 1;
                    }
                    int i12 = bArr[i11] & UByte.f41242c;
                    if (i12 <= i2) {
                        iArr3[i9] = i10 ^ (-1);
                        if (i11 > 0 && (bArr[i11 - 1] & UByte.f41242c) > i12) {
                            i11 ^= -1;
                        }
                        if (i8 == i12) {
                            i7--;
                            iArr3[i7] = i11;
                        } else {
                            if (i8 >= 0) {
                                iArr2[BUCKET_B(i8, i2)] = i7;
                            }
                            i7 = iArr2[BUCKET_B(i12, i2)] - 1;
                            iArr3[i7] = i11;
                            i8 = i12;
                        }
                    }
                } else {
                    iArr3[i9] = i10 ^ (-1);
                }
            }
            i2--;
            i3 = i7;
            i4 = i8;
        }
        int i13 = -1;
        for (int i14 = 0; i14 < i; i14++) {
            int i15 = iArr3[i14];
            if (i15 >= 0) {
                int i16 = i15 - 1;
                if (i16 < 0) {
                    i16 = i - 1;
                }
                int i17 = bArr[i16] & UByte.f41242c;
                if (i17 >= (bArr[i16 + 1] & UByte.f41242c)) {
                    if (i16 > 0 && (bArr[i16 - 1] & UByte.f41242c) < i17) {
                        i16 ^= -1;
                    }
                    if (i17 == i4) {
                        i3++;
                        iArr3[i3] = i16;
                    } else {
                        if (i4 != -1) {
                            iArr[i4] = i3;
                        }
                        i3 = iArr[i17] + 1;
                        iArr3[i3] = i16;
                        i4 = i17;
                    }
                }
            } else {
                i15 ^= -1;
            }
            if (i15 == 0) {
                iArr3[i14] = bArr[i - 1];
                i13 = i14;
            } else {
                iArr3[i14] = bArr[i15 - 1];
            }
        }
        return i13;
    }

    private static int getIDX(int i) {
        return i >= 0 ? i : i ^ (-1);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0105  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0129 -> B:56:0x00fd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void lsIntroSort(int r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.lsIntroSort(int, int, int, int, int):void");
    }

    private void lsSort(int i, int i2, int i3) {
        int i4;
        int[] iArr = this.f40199SA;
        int i5 = i3 + i;
        while (true) {
            int i6 = 0;
            if ((-i2) >= iArr[0]) {
                return;
            }
            int i7 = 0;
            int i8 = 0;
            do {
                int i9 = iArr[i8];
                if (i9 < 0) {
                    i8 -= i9;
                    i7 += i9;
                    continue;
                } else {
                    if (i7 != 0) {
                        iArr[i8 + i7] = i7;
                        i4 = 0;
                    } else {
                        i4 = i7;
                    }
                    int i10 = iArr[i9 + i] + 1;
                    lsIntroSort(i, i5, i + i2, i8, i10);
                    i7 = i4;
                    i8 = i10;
                    continue;
                }
            } while (i8 < i2);
            if (i7 != 0) {
                iArr[i8 + i7] = i7;
            }
            int i11 = i5 - i;
            if (i2 < i11) {
                do {
                    int i12 = iArr[i6];
                    if (i12 < 0) {
                        i6 -= i12;
                        continue;
                    } else {
                        int i13 = iArr[i12 + i] + 1;
                        while (i6 < i13) {
                            iArr[iArr[i6] + i] = i6;
                            i6++;
                        }
                        i6 = i13;
                        continue;
                    }
                } while (i6 < i2);
                return;
            }
            i5 += i11;
        }
    }

    private void lsUpdateGroup(int i, int i2, int i3) {
        int[] iArr = this.f40199SA;
        while (i2 < i3) {
            if (iArr[i2] >= 0) {
                int i4 = i2;
                do {
                    iArr[iArr[i4] + i] = i4;
                    i4++;
                    if (i4 >= i3) {
                        break;
                    }
                } while (iArr[i4] >= 0);
                iArr[i2] = i2 - i4;
                if (i3 <= i4) {
                    return;
                }
                i2 = i4;
            }
            int i5 = i2;
            do {
                iArr[i5] = iArr[i5] ^ (-1);
                i5++;
            } while (iArr[i5] < 0);
            do {
                iArr[iArr[i2] + i] = i5;
                i2++;
            } while (i2 <= i5);
            i2 = i5 + 1;
        }
    }

    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        byte[] bArr = this.f40200T;
        int[] iArr4 = this.f40199SA;
        int i13 = this.f40201n;
        int[] iArr5 = new int[256];
        int i14 = 1;
        while (true) {
            if (i14 >= i13) {
                break;
            }
            int i15 = i14 - 1;
            if (bArr[i15] == bArr[i14]) {
                i14++;
            } else if ((bArr[i15] & UByte.f41242c) > (bArr[i14] & UByte.f41242c)) {
                z = false;
            }
        }
        z = true;
        int i16 = i13 - 1;
        int i17 = bArr[i16] & UByte.f41242c;
        int i18 = bArr[0] & UByte.f41242c;
        if (i17 < i18 || (bArr[i16] == bArr[0] && z)) {
            if (!z) {
                int BUCKET_BSTAR = BUCKET_BSTAR(i17, i18);
                iArr2[BUCKET_BSTAR] = iArr2[BUCKET_BSTAR] + 1;
                i = i13 - 1;
                iArr4[i] = i16;
            } else {
                int BUCKET_B = BUCKET_B(i17, i18);
                iArr2[BUCKET_B] = iArr2[BUCKET_B] + 1;
                i = i13;
            }
            i2 = i16 - 1;
            while (i2 >= 0) {
                int i19 = bArr[i2] & UByte.f41242c;
                int i20 = bArr[i2 + 1] & UByte.f41242c;
                if (i19 <= i20) {
                    int BUCKET_B2 = BUCKET_B(i19, i20);
                    iArr2[BUCKET_B2] = iArr2[BUCKET_B2] + 1;
                    i2--;
                }
            }
        } else {
            i = i13;
            i2 = i16;
        }
        while (i2 >= 0) {
            do {
                int i21 = bArr[i2] & UByte.f41242c;
                iArr[i21] = iArr[i21] + 1;
                i2--;
                if (i2 < 0) {
                    break;
                }
            } while ((bArr[i2] & UByte.f41242c) >= (bArr[i2 + 1] & UByte.f41242c));
            if (i2 >= 0) {
                int BUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i2] & UByte.f41242c, bArr[i2 + 1] & UByte.f41242c);
                iArr2[BUCKET_BSTAR2] = iArr2[BUCKET_BSTAR2] + 1;
                i--;
                iArr4[i] = i2;
                while (true) {
                    i2--;
                    if (i2 >= 0 && (i11 = bArr[i2] & UByte.f41242c) <= (i12 = bArr[i2 + 1] & UByte.f41242c)) {
                        int BUCKET_B3 = BUCKET_B(i11, i12);
                        iArr2[BUCKET_B3] = iArr2[BUCKET_B3] + 1;
                    }
                }
            }
        }
        int i22 = i13 - i;
        if (i22 == 0) {
            for (int i23 = 0; i23 < i13; i23++) {
                iArr4[i23] = i23;
            }
            return 0;
        }
        int i24 = 0;
        int i25 = -1;
        int i26 = 0;
        while (i24 < 256) {
            int i27 = iArr[i24] + i25;
            iArr[i24] = i25 + i26;
            int i28 = i27 + iArr2[BUCKET_B(i24, i24)];
            int i29 = i24 + 1;
            for (int i30 = i29; i30 < 256; i30++) {
                i26 += iArr2[BUCKET_BSTAR(i24, i30)];
                iArr2[(i24 << 8) | i30] = i26;
                i28 += iArr2[BUCKET_B(i24, i30)];
            }
            i24 = i29;
            i25 = i28;
        }
        int i31 = i13 - i22;
        for (int i32 = i22 - 2; i32 >= 0; i32--) {
            int i33 = iArr4[i31 + i32];
            int BUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i33] & UByte.f41242c, bArr[i33 + 1] & UByte.f41242c);
            int i34 = iArr2[BUCKET_BSTAR3] - 1;
            iArr2[BUCKET_BSTAR3] = i34;
            iArr4[i34] = i32;
        }
        int i35 = iArr4[(i31 + i22) - 1];
        int BUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i35] & UByte.f41242c, bArr[i35 + 1] & UByte.f41242c);
        int i36 = iArr2[BUCKET_BSTAR4] - 1;
        iArr2[BUCKET_BSTAR4] = i36;
        int i37 = i22 - 1;
        iArr4[i36] = i37;
        int i38 = i13 - (i22 * 2);
        if (i38 <= 256) {
            iArr3 = iArr5;
            i3 = 256;
            i4 = 0;
        } else {
            i3 = i38;
            i4 = i22;
            iArr3 = iArr4;
        }
        int i39 = i22;
        int i40 = 255;
        while (i39 > 0) {
            int i41 = i39;
            int i42 = 255;
            while (i40 < i42) {
                int i43 = iArr2[BUCKET_BSTAR(i40, i42)];
                if (1 < i41 - i43) {
                    i7 = i42;
                    i8 = i40;
                    i9 = i37;
                    i10 = i22;
                    subStringSort(i31, i43, i41, iArr3, i4, i3, 2, iArr4[i43] == i37, i13);
                } else {
                    i7 = i42;
                    i8 = i40;
                    i9 = i37;
                    i10 = i22;
                }
                i42 = i7 - 1;
                i22 = i10;
                i41 = i43;
                i40 = i8;
                i37 = i9;
            }
            i40--;
            i39 = i41;
        }
        int i44 = i37;
        int i45 = i22;
        while (i37 >= 0) {
            if (iArr4[i37] >= 0) {
                int i46 = i37;
                do {
                    iArr4[i45 + iArr4[i46]] = i46;
                    i46--;
                    if (i46 < 0) {
                        break;
                    }
                } while (iArr4[i46] >= 0);
                iArr4[i46 + 1] = i46 - i37;
                if (i46 <= 0) {
                    break;
                }
                i37 = i46;
            }
            int i47 = i37;
            do {
                int i48 = iArr4[i47] ^ (-1);
                iArr4[i47] = i48;
                iArr4[i45 + i48] = i37;
                i47--;
            } while (iArr4[i47] < 0);
            iArr4[i45 + iArr4[i47]] = i37;
            i37 = i47 - 1;
        }
        trSort(i45, i45, 1);
        if ((bArr[i16] & UByte.f41242c) < (bArr[0] & UByte.f41242c) || (bArr[i16] == bArr[0] && z)) {
            if (z) {
                i5 = i45;
            } else {
                i5 = i45 - 1;
                iArr4[iArr4[i45 + i5]] = i16;
            }
            i6 = i16 - 1;
            while (i6 >= 0 && (bArr[i6] & UByte.f41242c) <= (bArr[i6 + 1] & UByte.f41242c)) {
                i6--;
            }
        } else {
            i5 = i45;
            i6 = i16;
        }
        while (i6 >= 0) {
            do {
                i6--;
                if (i6 < 0) {
                    break;
                }
            } while ((bArr[i6] & UByte.f41242c) >= (bArr[i6 + 1] & UByte.f41242c));
            if (i6 >= 0) {
                i5--;
                iArr4[iArr4[i45 + i5]] = i6;
                do {
                    i6--;
                    if (i6 >= 0) {
                    }
                } while ((bArr[i6] & UByte.f41242c) <= (bArr[i6 + 1] & UByte.f41242c));
            }
        }
        int i49 = i44;
        for (int i50 = 255; i50 >= 0; i50--) {
            for (int i51 = 255; i50 < i51; i51--) {
                int i52 = i16 - iArr2[BUCKET_B(i50, i51)];
                iArr2[BUCKET_B(i50, i51)] = i16 + 1;
                int i53 = iArr2[BUCKET_BSTAR(i50, i51)];
                i16 = i52;
                while (i53 <= i49) {
                    iArr4[i16] = iArr4[i49];
                    i16--;
                    i49--;
                }
            }
            int i54 = i16 - iArr2[BUCKET_B(i50, i50)];
            iArr2[BUCKET_B(i50, i50)] = i16 + 1;
            if (i50 < 255) {
                iArr2[BUCKET_BSTAR(i50, i50 + 1)] = i54 + 1;
            }
            i16 = iArr[i50];
        }
        return i45;
    }

    private static void ssBlockSwap(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        while (i3 > 0) {
            swapElements(iArr, i, iArr2, i2);
            i3--;
            i++;
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        return (r1[r5] & kotlin.UByte.f41242c) - (r1[r7] & kotlin.UByte.f41242c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r7 >= r3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ssCompare(int r5, int r6, int r7) {
        /*
            r4 = this;
            int[] r0 = r4.f40199SA
            byte[] r1 = r4.f40200T
            int r2 = r5 + 1
            r2 = r0[r2]
            int r2 = r2 + 2
            int r3 = r6 + 1
            r3 = r0[r3]
            int r3 = r3 + 2
            r5 = r0[r5]
            int r5 = r5 + r7
            r6 = r0[r6]
            int r7 = r7 + r6
        L16:
            if (r5 >= r2) goto L25
            if (r7 >= r3) goto L25
            r6 = r1[r5]
            r0 = r1[r7]
            if (r6 != r0) goto L25
            int r5 = r5 + 1
            int r7 = r7 + 1
            goto L16
        L25:
            if (r5 >= r2) goto L35
            if (r7 >= r3) goto L33
            r5 = r1[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r5 = r5 - r6
            goto L3a
        L33:
            r5 = 1
            goto L3a
        L35:
            if (r7 >= r3) goto L39
            r5 = -1
            goto L3a
        L39:
            r5 = 0
        L3a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssCompare(int, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        return (r1[r7] & kotlin.UByte.f41242c) - (r1[r9] & kotlin.UByte.f41242c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r9 >= r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return (r1[r7] & kotlin.UByte.f41242c) - (r1[r9] & kotlin.UByte.f41242c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r9 >= r8) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ssCompareLast(int r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            int[] r0 = r5.f40199SA
            byte[] r1 = r5.f40200T
            r7 = r0[r7]
            int r7 = r7 + r9
            r2 = r0[r8]
            int r9 = r9 + r2
            r2 = 1
            int r8 = r8 + r2
            r8 = r0[r8]
            int r8 = r8 + 2
        L10:
            if (r7 >= r10) goto L1f
            if (r9 >= r8) goto L1f
            r3 = r1[r7]
            r4 = r1[r9]
            if (r3 != r4) goto L1f
            int r7 = r7 + 1
            int r9 = r9 + 1
            goto L10
        L1f:
            if (r7 >= r10) goto L2e
            if (r9 >= r8) goto L2d
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r1[r9]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r2 = r6 - r7
        L2d:
            return r2
        L2e:
            if (r9 != r8) goto L31
            return r2
        L31:
            int r7 = r7 % r10
            r6 = r0[r6]
            int r6 = r6 + 2
        L36:
            if (r7 >= r6) goto L45
            if (r9 >= r8) goto L45
            r10 = r1[r7]
            r0 = r1[r9]
            if (r10 != r0) goto L45
            int r7 = r7 + 1
            int r9 = r9 + 1
            goto L36
        L45:
            if (r7 >= r6) goto L54
            if (r9 >= r8) goto L59
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r1[r9]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r2 = r6 - r7
            goto L59
        L54:
            if (r9 >= r8) goto L58
            r2 = -1
            goto L59
        L58:
            r2 = 0
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssCompareLast(int, int, int, int, int):int");
    }

    private void ssFixdown(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f40199SA;
        byte[] bArr = this.f40200T;
        int i6 = iArr[i3 + i4];
        int i7 = bArr[iArr[i2 + i6] + i] & UByte.f41242c;
        while (true) {
            int i8 = (i4 * 2) + 1;
            if (i8 >= i5) {
                break;
            }
            int i9 = i8 + 1;
            int i10 = bArr[iArr[iArr[i3 + i8] + i2] + i] & UByte.f41242c;
            int i11 = bArr[iArr[iArr[i3 + i9] + i2] + i] & UByte.f41242c;
            if (i10 < i11) {
                i8 = i9;
                i10 = i11;
            }
            if (i10 <= i7) {
                break;
            }
            iArr[i4 + i3] = iArr[i3 + i8];
            i4 = i8;
        }
        iArr[i3 + i4] = i6;
    }

    private void ssHeapSort(int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr = this.f40199SA;
        byte[] bArr = this.f40200T;
        int i6 = i4 % 2;
        if (i6 == 0) {
            int i7 = i4 - 1;
            int i8 = (i7 / 2) + i3;
            int i9 = i3 + i7;
            if ((bArr[iArr[iArr[i8] + i2] + i] & UByte.f41242c) < (bArr[iArr[iArr[i9] + i2] + i] & UByte.f41242c)) {
                swapElements(iArr, i9, iArr, i8);
            }
            i5 = i7;
        } else {
            i5 = i4;
        }
        for (int i10 = (i5 / 2) - 1; i10 >= 0; i10--) {
            ssFixdown(i, i2, i3, i10, i5);
        }
        if (i6 == 0) {
            swapElements(iArr, i3, iArr, i3 + i5);
            ssFixdown(i, i2, i3, 0, i5);
        }
        for (int i11 = i5 - 1; i11 > 0; i11--) {
            int i12 = iArr[i3];
            int i13 = i3 + i11;
            iArr[i3] = iArr[i13];
            ssFixdown(i, i2, i3, 0, i11);
            iArr[i13] = i12;
        }
    }

    private void ssInsertionSort(int i, int i2, int i3, int i4) {
        int ssCompare;
        int[] iArr = this.f40199SA;
        for (int i5 = i3 - 2; i2 <= i5; i5--) {
            int i6 = iArr[i5];
            int i7 = i5 + 1;
            do {
                ssCompare = ssCompare(i + i6, iArr[i7] + i, i4);
                if (ssCompare <= 0) {
                    break;
                }
                do {
                    iArr[i7 - 1] = iArr[i7];
                    i7++;
                    if (i7 < i3) {
                    }
                } while (iArr[i7] < 0);
                continue;
            } while (i3 > i7);
            if (ssCompare == 0) {
                iArr[i7] = iArr[i7] ^ (-1);
            }
            iArr[i7 - 1] = i6;
        }
    }

    private static int ssLog(int i) {
        return (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int ssMedian3(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f40199SA;
        byte[] bArr = this.f40200T;
        int i6 = bArr[iArr[iArr[i3] + i2] + i] & UByte.f41242c;
        int i7 = bArr[iArr[iArr[i4] + i2] + i] & UByte.f41242c;
        int i8 = bArr[i + iArr[i2 + iArr[i5]]] & UByte.f41242c;
        if (i6 <= i7) {
            i4 = i3;
            i3 = i4;
            i7 = i6;
            i6 = i7;
        }
        return i6 > i8 ? i7 > i8 ? i4 : i5 : i3;
    }

    private int ssMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int[] iArr = this.f40199SA;
        byte[] bArr = this.f40200T;
        int i17 = bArr[iArr[iArr[i3] + i2] + i] & UByte.f41242c;
        int i18 = bArr[iArr[iArr[i4] + i2] + i] & UByte.f41242c;
        int i19 = bArr[iArr[iArr[i5] + i2] + i] & UByte.f41242c;
        int i20 = bArr[iArr[iArr[i6] + i2] + i] & UByte.f41242c;
        int i21 = bArr[iArr[iArr[i7] + i2] + i] & UByte.f41242c;
        if (i18 > i19) {
            i8 = i5;
            i9 = i18;
            i10 = i4;
        } else {
            i8 = i4;
            i9 = i19;
            i19 = i18;
            i10 = i5;
        }
        if (i20 > i21) {
            i12 = i21;
            i11 = i20;
            i14 = i6;
            i13 = i7;
        } else {
            i11 = i21;
            i12 = i20;
            i13 = i6;
            i14 = i7;
        }
        if (i19 > i12) {
            int i22 = i10;
            i10 = i14;
            i14 = i22;
            int i23 = i11;
            i11 = i9;
            i9 = i23;
        } else {
            i8 = i13;
            i19 = i12;
        }
        if (i17 > i9) {
            i15 = i17;
            i16 = i3;
        } else {
            i15 = i9;
            i9 = i17;
            i16 = i10;
            i10 = i3;
        }
        if (i9 > i19) {
            i8 = i10;
            i19 = i9;
        } else {
            i14 = i16;
            i11 = i15;
        }
        return i11 > i19 ? i8 : i14;
    }

    private void ssMerge(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr2 = this.f40199SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = i15 - i14;
            if (i18 <= i6) {
                if (i13 >= i14 || i14 >= i15) {
                    i8 = i15;
                } else {
                    i8 = i15;
                    ssMergeBackward(i, iArr, i5, i13, i14, i15, i7);
                }
                if ((i16 & 1) != 0) {
                    ssMergeCheckEqual(i, i7, i13);
                }
                if ((i16 & 2) != 0) {
                    ssMergeCheckEqual(i, i7, i8);
                }
                if (i17 == 0) {
                    return;
                }
                i17--;
                StackEntry stackEntry = stackEntryArr[i17];
                i13 = stackEntry.f40202a;
                i14 = stackEntry.f40203b;
                i15 = stackEntry.f40204c;
                i9 = stackEntry.f40205d;
            } else {
                int i19 = i15;
                int i20 = i14 - i13;
                if (i20 <= i6) {
                    if (i13 < i14) {
                        ssMergeForward(i, iArr, i5, i13, i14, i19, i7);
                    }
                    if ((i16 & 1) != 0) {
                        ssMergeCheckEqual(i, i7, i13);
                    }
                    if ((i16 & 2) != 0) {
                        ssMergeCheckEqual(i, i7, i19);
                    }
                    if (i17 == 0) {
                        return;
                    }
                    i17--;
                    StackEntry stackEntry2 = stackEntryArr[i17];
                    i13 = stackEntry2.f40202a;
                    i14 = stackEntry2.f40203b;
                    i15 = stackEntry2.f40204c;
                    i9 = stackEntry2.f40205d;
                } else {
                    int min = Math.min(i20, i18);
                    int i21 = min >> 1;
                    int i22 = 0;
                    while (min > 0) {
                        if (ssCompare(getIDX(iArr2[i14 + i22 + i21]) + i, getIDX(iArr2[((i14 - i22) - i21) - 1]) + i, i7) < 0) {
                            i22 += i21 + 1;
                            i21 -= (min & 1) ^ 1;
                        }
                        min = i21;
                        i21 = min >> 1;
                    }
                    if (i22 > 0) {
                        int i23 = i14 - i22;
                        ssBlockSwap(iArr2, i23, iArr2, i14, i22);
                        int i24 = i14 + i22;
                        if (i24 < i19) {
                            if (iArr2[i24] < 0) {
                                i12 = i14;
                                while (iArr2[i12 - 1] < 0) {
                                    i12--;
                                }
                                iArr2[i24] = iArr2[i24] ^ (-1);
                            } else {
                                i12 = i14;
                            }
                            i10 = i14;
                            while (iArr2[i10] < 0) {
                                i10++;
                            }
                            i15 = i12;
                            i11 = 1;
                        } else {
                            i10 = i14;
                            i15 = i10;
                            i11 = 0;
                        }
                        if (i15 - i13 <= i19 - i10) {
                            stackEntryArr[i17] = new StackEntry(i10, i24, i19, (i11 & 1) | (i16 & 2));
                            i16 &= 1;
                            i14 = i23;
                            i17++;
                        } else {
                            if (i15 == i14 && i14 == i10) {
                                i11 <<= 1;
                            }
                            stackEntryArr[i17] = new StackEntry(i13, i23, i15, (i16 & 1) | (i11 & 2));
                            i16 = (i16 & 2) | (i11 & 1);
                            i14 = i24;
                            i17++;
                            i13 = i10;
                            i15 = i19;
                        }
                    } else {
                        if ((i16 & 1) != 0) {
                            ssMergeCheckEqual(i, i7, i13);
                        }
                        ssMergeCheckEqual(i, i7, i14);
                        if ((i16 & 2) != 0) {
                            ssMergeCheckEqual(i, i7, i19);
                        }
                        if (i17 == 0) {
                            return;
                        }
                        i17--;
                        StackEntry stackEntry3 = stackEntryArr[i17];
                        i13 = stackEntry3.f40202a;
                        i14 = stackEntry3.f40203b;
                        i15 = stackEntry3.f40204c;
                        i9 = stackEntry3.f40205d;
                    }
                }
            }
            i16 = i9;
        }
    }

    private void ssMergeBackward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int[] iArr2 = this.f40199SA;
        int i21 = i5 - i4;
        ssBlockSwap(iArr, i2, iArr2, i4, i21);
        int i22 = (i2 + i21) - 1;
        if (iArr[i22] < 0) {
            i7 = i + (iArr[i22] ^ (-1));
            z = true;
        } else {
            i7 = i + iArr[i22];
            z = false;
        }
        int i23 = i4 - 1;
        if (iArr2[i23] < 0) {
            z |= true;
            i8 = iArr2[i23] ^ (-1);
        } else {
            i8 = iArr2[i23];
        }
        int i24 = i + i8;
        int i25 = i5 - 1;
        int i26 = iArr2[i25];
        while (true) {
            int ssCompare = ssCompare(i7, i24, i6);
            if (ssCompare > 0) {
                if (z & true) {
                    while (true) {
                        i10 = i25 - 1;
                        iArr2[i25] = iArr[i22];
                        i11 = i22 - 1;
                        iArr[i22] = iArr2[i10];
                        if (iArr[i11] >= 0) {
                            break;
                        }
                        i22 = i11;
                        i25 = i10;
                    }
                    z = !z;
                    i22 = i11;
                    i25 = i10;
                }
                int i27 = i25 - 1;
                iArr2[i25] = iArr[i22];
                if (i22 <= i2) {
                    iArr[i22] = i26;
                    return;
                }
                int i28 = i22 - 1;
                iArr[i22] = iArr2[i27];
                if (iArr[i28] < 0) {
                    z |= true;
                    i9 = iArr[i28] ^ (-1);
                } else {
                    i9 = iArr[i28];
                }
                int i29 = i + i9;
                i22 = i28;
                i25 = i27;
                i7 = i29;
            } else if (ssCompare < 0) {
                if (z & true) {
                    while (true) {
                        i13 = i25 - 1;
                        iArr2[i25] = iArr2[i23];
                        i14 = i23 - 1;
                        iArr2[i23] = iArr2[i13];
                        if (iArr2[i14] >= 0) {
                            break;
                        }
                        i23 = i14;
                        i25 = i13;
                    }
                    z ^= true;
                    i23 = i14;
                    i25 = i13;
                }
                int i30 = i25 - 1;
                iArr2[i25] = iArr2[i23];
                int i31 = i23 - 1;
                iArr2[i23] = iArr2[i30];
                if (i31 < i3) {
                    while (i2 < i22) {
                        int i32 = i30 - 1;
                        iArr2[i30] = iArr[i22];
                        iArr[i22] = iArr2[i32];
                        i30 = i32;
                        i22--;
                    }
                    iArr2[i30] = iArr[i22];
                    iArr[i22] = i26;
                    return;
                }
                if (iArr2[i31] < 0) {
                    z |= true;
                    i12 = iArr2[i31] ^ (-1);
                } else {
                    i12 = iArr2[i31];
                }
                i24 = i + i12;
                i23 = i31;
                i25 = i30;
            } else {
                if (z & true) {
                    while (true) {
                        i19 = i25 - 1;
                        iArr2[i25] = iArr[i22];
                        i20 = i22 - 1;
                        iArr[i22] = iArr2[i19];
                        if (iArr[i20] >= 0) {
                            break;
                        }
                        i22 = i20;
                        i25 = i19;
                    }
                    z = !z;
                    i22 = i20;
                    i25 = i19;
                }
                int i33 = i25 - 1;
                iArr2[i25] = iArr[i22] ^ (-1);
                if (i22 <= i2) {
                    iArr[i22] = i26;
                    return;
                }
                int i34 = i22 - 1;
                iArr[i22] = iArr2[i33];
                if (z & true) {
                    while (true) {
                        i17 = i33 - 1;
                        iArr2[i33] = iArr2[i23];
                        i18 = i23 - 1;
                        iArr2[i23] = iArr2[i17];
                        if (iArr2[i18] >= 0) {
                            break;
                        }
                        i23 = i18;
                        i33 = i17;
                    }
                    z ^= true;
                    i23 = i18;
                    i33 = i17;
                }
                int i35 = i33 - 1;
                iArr2[i33] = iArr2[i23];
                int i36 = i23 - 1;
                iArr2[i23] = iArr2[i35];
                if (i36 < i3) {
                    while (i2 < i34) {
                        int i37 = i35 - 1;
                        iArr2[i35] = iArr[i34];
                        iArr[i34] = iArr2[i37];
                        i35 = i37;
                        i34--;
                    }
                    iArr2[i35] = iArr[i34];
                    iArr[i34] = i26;
                    return;
                }
                if (iArr[i34] < 0) {
                    z2 = z | true;
                    i15 = i + (iArr[i34] ^ (-1));
                } else {
                    boolean z3 = z;
                    i15 = i + iArr[i34];
                    z2 = z3;
                }
                if (iArr2[i36] < 0) {
                    z2 |= true;
                    i16 = iArr2[i36] ^ (-1);
                } else {
                    i16 = iArr2[i36];
                }
                i24 = i + i16;
                int i38 = i15;
                z = z2;
                i23 = i36;
                i7 = i38;
                i22 = i34;
                i25 = i35;
            }
        }
    }

    private void ssMergeCheckEqual(int i, int i2, int i3) {
        int[] iArr = this.f40199SA;
        if (iArr[i3] < 0 || ssCompare(getIDX(iArr[i3 - 1]) + i, i + iArr[i3], i2) != 0) {
            return;
        }
        iArr[i3] = iArr[i3] ^ (-1);
    }

    private void ssMergeForward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int[] iArr2 = this.f40199SA;
        int i8 = i4 - i3;
        int i9 = (i2 + i8) - 1;
        ssBlockSwap(iArr, i2, iArr2, i3, i8);
        int i10 = iArr2[i3];
        while (true) {
            int ssCompare = ssCompare(iArr[i2] + i, iArr2[i4] + i, i6);
            if (ssCompare < 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i11 = i2 + 1;
                    iArr[i2] = iArr2[i7];
                    if (iArr[i11] >= 0) {
                        i2 = i11;
                        break;
                    } else {
                        i2 = i11;
                        i3 = i7;
                    }
                }
            } else if (ssCompare > 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr2[i4];
                    int i12 = i4 + 1;
                    iArr2[i4] = iArr2[i7];
                    if (i5 <= i12) {
                        while (i2 < i9) {
                            int i13 = i7 + 1;
                            iArr2[i7] = iArr[i2];
                            iArr[i2] = iArr2[i13];
                            i7 = i13;
                            i2++;
                        }
                        iArr2[i7] = iArr[i2];
                        iArr[i2] = i10;
                        return;
                    } else if (iArr2[i12] >= 0) {
                        i4 = i12;
                        break;
                    } else {
                        i4 = i12;
                        i3 = i7;
                    }
                }
            } else {
                iArr2[i4] = iArr2[i4] ^ (-1);
                while (true) {
                    int i14 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i15 = i2 + 1;
                    iArr[i2] = iArr2[i14];
                    if (iArr[i15] >= 0) {
                        while (true) {
                            int i16 = i14 + 1;
                            iArr2[i14] = iArr2[i4];
                            int i17 = i4 + 1;
                            iArr2[i4] = iArr2[i16];
                            if (i5 <= i17) {
                                while (i15 < i9) {
                                    int i18 = i16 + 1;
                                    iArr2[i16] = iArr[i15];
                                    iArr[i15] = iArr2[i18];
                                    i15++;
                                    i16 = i18;
                                }
                                iArr2[i16] = iArr[i15];
                                iArr[i15] = i10;
                                return;
                            } else if (iArr2[i17] >= 0) {
                                i4 = i17;
                                i3 = i16;
                                i2 = i15;
                                break;
                            } else {
                                i4 = i17;
                                i14 = i16;
                            }
                        }
                    } else {
                        i2 = i15;
                        i3 = i14;
                    }
                }
            }
            i3 = i7;
        }
    }

    private void ssMultiKeyIntroSort(int i, int i2, int i3, int i4) {
        int ssLog;
        int i5;
        int i6;
        int i7;
        int i8;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.f40199SA;
        byte[] bArr = bzip2DivSufSort.f40200T;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i9 = -1;
        int i10 = i3;
        int i11 = i4;
        int ssLog2 = ssLog(i3 - i2);
        int i12 = 0;
        int i13 = 0;
        int i14 = i2;
        while (true) {
            int i15 = i10 - i14;
            if (i15 <= 8) {
                if (1 < i15) {
                    bzip2DivSufSort.ssInsertionSort(i, i14, i10, i11);
                }
                if (i12 == 0) {
                    return;
                }
                i12--;
                StackEntry stackEntry = stackEntryArr[i12];
                int i16 = stackEntry.f40202a;
                int i17 = stackEntry.f40203b;
                int i18 = stackEntry.f40204c;
                ssLog2 = stackEntry.f40205d;
                i14 = i16;
                i10 = i17;
                i11 = i18;
            } else {
                int i19 = ssLog2 - 1;
                if (ssLog2 == 0) {
                    bzip2DivSufSort.ssHeapSort(i11, i, i14, i15);
                }
                if (i19 < 0) {
                    int i20 = bArr[iArr[iArr[i14] + i] + i11] & UByte.f41242c;
                    int i21 = i14;
                    i14++;
                    while (i14 < i10) {
                        i13 = bArr[iArr[iArr[i14] + i] + i11] & UByte.f41242c;
                        if (i13 != i20) {
                            if (1 < i14 - i21) {
                                break;
                            }
                            i21 = i14;
                            i20 = i13;
                        }
                        i14++;
                    }
                    if ((bArr[(iArr[iArr[i21] + i] + i11) - 1] & UByte.f41242c) < i20) {
                        i21 = bzip2DivSufSort.ssSubstringPartition(i, i21, i14, i11);
                    }
                    int i22 = i14 - i21;
                    int i23 = i10 - i14;
                    if (i22 <= i23) {
                        if (1 < i22) {
                            stackEntryArr[i12] = new StackEntry(i14, i10, i11, i9);
                            i11++;
                            ssLog = ssLog(i22);
                            i12++;
                            int i24 = ssLog;
                            i10 = i14;
                            i14 = i21;
                            ssLog2 = i24;
                        } else {
                            ssLog2 = -1;
                        }
                    } else if (1 < i23) {
                        stackEntryArr[i12] = new StackEntry(i21, i14, i11 + 1, ssLog(i22));
                        i12++;
                        ssLog2 = -1;
                    } else {
                        i11++;
                        ssLog = ssLog(i22);
                        int i242 = ssLog;
                        i10 = i14;
                        i14 = i21;
                        ssLog2 = i242;
                    }
                } else {
                    int ssPivot = bzip2DivSufSort.ssPivot(i11, i, i14, i10);
                    int i25 = bArr[iArr[iArr[ssPivot] + i] + i11] & UByte.f41242c;
                    swapElements(iArr, i14, iArr, ssPivot);
                    int i26 = i14 + 1;
                    while (i26 < i10) {
                        i13 = bArr[iArr[iArr[i26] + i] + i11] & UByte.f41242c;
                        if (i13 != i25) {
                            break;
                        }
                        i26++;
                    }
                    if (i26 < i10 && i13 < i25) {
                        i5 = i13;
                        i6 = i26;
                        while (true) {
                            i26++;
                            if (i26 >= i10 || (i5 = bArr[iArr[iArr[i26] + i] + i11] & UByte.f41242c) > i25) {
                                break;
                            } else if (i5 == i25) {
                                swapElements(iArr, i26, iArr, i6);
                                i6++;
                            }
                        }
                    } else {
                        i5 = i13;
                        i6 = i26;
                    }
                    int i27 = i10 - 1;
                    while (i26 < i27) {
                        i5 = bArr[iArr[iArr[i27] + i] + i11] & UByte.f41242c;
                        if (i5 != i25) {
                            break;
                        }
                        i27--;
                    }
                    if (i26 < i27 && i5 > i25) {
                        int i28 = i5;
                        int i29 = i27;
                        while (true) {
                            i27 += i9;
                            if (i26 >= i27) {
                                i7 = i29;
                                i5 = i28;
                                break;
                            }
                            int i30 = bArr[i11 + iArr[i + iArr[i27]]] & UByte.f41242c;
                            if (i30 < i25) {
                                int i31 = i29;
                                i5 = i30;
                                i7 = i31;
                                break;
                            }
                            if (i30 == i25) {
                                swapElements(iArr, i27, iArr, i29);
                                i29--;
                            }
                            i28 = i30;
                            i9 = -1;
                        }
                    } else {
                        i7 = i27;
                    }
                    while (i26 < i27) {
                        swapElements(iArr, i26, iArr, i27);
                        while (true) {
                            i26++;
                            if (i26 >= i27 || (i5 = bArr[iArr[iArr[i26] + i] + i11] & UByte.f41242c) > i25) {
                                break;
                            } else if (i5 == i25) {
                                swapElements(iArr, i26, iArr, i6);
                                i6++;
                            }
                        }
                        while (true) {
                            i27--;
                            if (i26 < i27 && (i5 = bArr[iArr[iArr[i27] + i] + i11] & UByte.f41242c) >= i25) {
                                if (i5 == i25) {
                                    swapElements(iArr, i27, iArr, i7);
                                    i7--;
                                }
                            }
                        }
                    }
                    if (i6 <= i7) {
                        int i32 = i26 - 1;
                        int i33 = i5;
                        int i34 = i6 - i14;
                        int i35 = i26 - i6;
                        if (i34 > i35) {
                            i34 = i35;
                        }
                        int i36 = i14;
                        int i37 = i26;
                        int i38 = i26 - i34;
                        while (i34 > 0) {
                            swapElements(iArr, i36, iArr, i38);
                            i34--;
                            i36++;
                            i38++;
                        }
                        int i39 = i7 - i32;
                        int i40 = (i10 - i7) - 1;
                        if (i39 <= i40) {
                            i40 = i39;
                        }
                        int i41 = i10 - i40;
                        int i42 = i37;
                        while (i40 > 0) {
                            swapElements(iArr, i42, iArr, i41);
                            i40--;
                            i42++;
                            i41++;
                        }
                        int i43 = i14 + i35;
                        int i44 = i10 - i39;
                        int ssSubstringPartition = i25 <= (bArr[(iArr[iArr[i43] + i] + i11) + (-1)] & UByte.f41242c) ? i43 : bzip2DivSufSort.ssSubstringPartition(i, i43, i44, i11);
                        int i45 = i43 - i14;
                        int i46 = i10 - i44;
                        if (i45 <= i46) {
                            int i47 = i44 - ssSubstringPartition;
                            if (i46 <= i47) {
                                int i48 = i12 + 1;
                                stackEntryArr[i12] = new StackEntry(ssSubstringPartition, i44, i11 + 1, ssLog(i47));
                                i12 = i48 + 1;
                                i8 = i19;
                                stackEntryArr[i48] = new StackEntry(i44, i10, i11, i8);
                            } else {
                                i8 = i19;
                                if (i45 <= i47) {
                                    int i49 = i12 + 1;
                                    stackEntryArr[i12] = new StackEntry(i44, i10, i11, i8);
                                    i12 = i49 + 1;
                                    stackEntryArr[i49] = new StackEntry(ssSubstringPartition, i44, i11 + 1, ssLog(i47));
                                } else {
                                    int i50 = i12 + 1;
                                    stackEntryArr[i12] = new StackEntry(i44, i10, i11, i8);
                                    i12 = i50 + 1;
                                    stackEntryArr[i50] = new StackEntry(i14, i43, i11, i8);
                                    i11++;
                                    i10 = i44;
                                    i9 = -1;
                                    ssLog2 = ssLog(i47);
                                    i14 = ssSubstringPartition;
                                    i13 = i33;
                                }
                            }
                            i13 = i33;
                            i10 = i43;
                            ssLog2 = i8;
                        } else {
                            int i51 = i44 - ssSubstringPartition;
                            if (i45 <= i51) {
                                int i52 = i12 + 1;
                                stackEntryArr[i12] = new StackEntry(ssSubstringPartition, i44, i11 + 1, ssLog(i51));
                                i12 = i52 + 1;
                                stackEntryArr[i52] = new StackEntry(i14, i43, i11, i19);
                            } else if (i46 <= i51) {
                                int i53 = i12 + 1;
                                stackEntryArr[i12] = new StackEntry(i14, i43, i11, i19);
                                i12 = i53 + 1;
                                stackEntryArr[i53] = new StackEntry(ssSubstringPartition, i44, i11 + 1, ssLog(i51));
                            } else {
                                int i54 = i12 + 1;
                                stackEntryArr[i12] = new StackEntry(i14, i43, i11, i19);
                                i12 = i54 + 1;
                                stackEntryArr[i54] = new StackEntry(i44, i10, i11, i19);
                                i11++;
                                i9 = -1;
                                i10 = i44;
                                i14 = ssSubstringPartition;
                                i13 = i33;
                                ssLog2 = ssLog(i51);
                                bzip2DivSufSort = this;
                            }
                            i9 = -1;
                            bzip2DivSufSort = this;
                            i13 = i33;
                            i14 = i44;
                            ssLog2 = i19;
                        }
                    } else {
                        int i55 = i5;
                        int i56 = i19 + 1;
                        if ((bArr[(iArr[iArr[i14] + i] + i11) - 1] & UByte.f41242c) < i25) {
                            bzip2DivSufSort = this;
                            i14 = bzip2DivSufSort.ssSubstringPartition(i, i14, i10, i11);
                            ssLog2 = ssLog(i10 - i14);
                        } else {
                            bzip2DivSufSort = this;
                            ssLog2 = i56;
                        }
                        i11++;
                        i13 = i55;
                    }
                    i9 = -1;
                }
            }
        }
    }

    private int ssPivot(int i, int i2, int i3, int i4) {
        int i5 = i4 - i3;
        int i6 = i3 + (i5 / 2);
        if (i5 <= 512) {
            if (i5 <= 32) {
                return ssMedian3(i, i2, i3, i6, i4 - 1);
            }
            int i7 = i5 >> 2;
            int i8 = i4 - 1;
            return ssMedian5(i, i2, i3, i3 + i7, i6, i8 - i7, i8);
        }
        int i9 = i5 >> 3;
        int i10 = i9 << 1;
        int i11 = i4 - 1;
        return ssMedian3(i, i2, ssMedian3(i, i2, i3, i3 + i9, i3 + i10), ssMedian3(i, i2, i6 - i9, i6, i6 + i9), ssMedian3(i, i2, i11 - i10, i11 - i9, i11));
    }

    private int ssSubstringPartition(int i, int i2, int i3, int i4) {
        int[] iArr = this.f40199SA;
        int i5 = i2 - 1;
        while (true) {
            i5++;
            if (i5 < i3 && iArr[iArr[i5] + i] + i4 >= iArr[iArr[i5] + i + 1] + 1) {
                iArr[i5] = iArr[i5] ^ (-1);
            } else {
                do {
                    i3--;
                    if (i5 >= i3) {
                        break;
                    }
                } while (iArr[iArr[i3] + i] + i4 < iArr[iArr[i3] + i + 1] + 1);
                if (i3 <= i5) {
                    break;
                }
                iArr[i3] = iArr[i5];
                iArr[i5] = iArr[i3] ^ (-1);
            }
        }
        if (i2 < i5) {
            iArr[i2] = iArr[i2] ^ (-1);
        }
        return i5;
    }

    private void subStringSort(int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, boolean z, int i7) {
        int i8;
        int i9;
        int[] iArr2;
        int[] iArr3 = this.f40199SA;
        int i10 = z ? i2 + 1 : i2;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1024;
            if (i13 >= i3) {
                break;
            }
            ssMultiKeyIntroSort(i, i11, i13, i6);
            int i14 = i3 - i13;
            if (i14 <= i5) {
                iArr2 = iArr;
                i9 = i4;
                i8 = i5;
            } else {
                i8 = i14;
                i9 = i13;
                iArr2 = iArr3;
            }
            int i15 = i11;
            int i16 = i12;
            int i17 = 1024;
            while ((i16 & 1) != 0) {
                int i18 = i15 - i17;
                ssMerge(i, i18, i15, i15 + i17, iArr2, i9, i8, i6);
                i17 <<= 1;
                i16 >>>= 1;
                i15 = i18;
                i13 = i13;
            }
            i12++;
            i11 = i13;
        }
        ssMultiKeyIntroSort(i, i11, i3, i6);
        int i19 = i11;
        int i20 = 1024;
        for (int i21 = i12; i21 != 0; i21 >>= 1) {
            if ((i21 & 1) != 0) {
                int i22 = i19 - i20;
                ssMerge(i, i22, i19, i3, iArr, i4, i5, i6);
                i19 = i22;
            }
            i20 <<= 1;
        }
        if (z) {
            int i23 = iArr3[i10 - 1];
            int i24 = 1;
            while (i10 < i3 && (iArr3[i10] < 0 || (i24 = ssCompareLast(i, i + i23, i + iArr3[i10], i6, i7)) > 0)) {
                iArr3[i10 - 1] = iArr3[i10];
                i10++;
            }
            if (i24 == 0) {
                iArr3[i10] = iArr3[i10] ^ (-1);
            }
            iArr3[i10 - 1] = i23;
        }
    }

    private static void swapElements(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr2[i2];
        iArr2[i2] = i3;
    }

    private void trCopy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.f40199SA;
        int i8 = i5 - 1;
        int i9 = i4 - 1;
        while (i3 <= i9) {
            int i10 = iArr[i3] - i7;
            if (i10 < 0) {
                i10 += i2 - i;
            }
            int i11 = i + i10;
            if (iArr[i11] == i8) {
                i9++;
                iArr[i9] = i10;
                iArr[i11] = i9;
            }
            i3++;
        }
        int i12 = i6 - 1;
        int i13 = i9 + 1;
        while (i13 < i5) {
            int i14 = iArr[i12] - i7;
            if (i14 < 0) {
                i14 += i2 - i;
            }
            int i15 = i + i14;
            if (iArr[i15] == i8) {
                i5--;
                iArr[i5] = i14;
                iArr[i15] = i5;
            }
            i12--;
        }
    }

    private void trFixdown(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.f40199SA;
        int i7 = iArr[i4 + i5];
        int trGetC = trGetC(i, i2, i3, i7);
        while (true) {
            int i8 = (i5 * 2) + 1;
            if (i8 >= i6) {
                break;
            }
            int i9 = i8 + 1;
            int trGetC2 = trGetC(i, i2, i3, iArr[i4 + i8]);
            int trGetC3 = trGetC(i, i2, i3, iArr[i4 + i9]);
            if (trGetC2 < trGetC3) {
                i8 = i9;
                trGetC2 = trGetC3;
            }
            if (trGetC2 <= trGetC) {
                break;
            }
            iArr[i5 + i4] = iArr[i4 + i8];
            i5 = i8;
        }
        iArr[i4 + i5] = i7;
    }

    private int trGetC(int i, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        return i5 < i3 ? this.f40199SA[i5] : this.f40199SA[i + (((i2 - i) + i4) % (i3 - i))];
    }

    private void trHeapSort(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int[] iArr = this.f40199SA;
        int i7 = i5 % 2;
        if (i7 == 0) {
            int i8 = i5 - 1;
            int i9 = (i8 / 2) + i4;
            int i10 = i4 + i8;
            if (trGetC(i, i2, i3, iArr[i9]) < trGetC(i, i2, i3, iArr[i10])) {
                swapElements(iArr, i10, iArr, i9);
            }
            i6 = i8;
        } else {
            i6 = i5;
        }
        for (int i11 = (i6 / 2) - 1; i11 >= 0; i11--) {
            trFixdown(i, i2, i3, i4, i11, i6);
        }
        if (i7 == 0) {
            swapElements(iArr, i4, iArr, i4 + i6);
            trFixdown(i, i2, i3, i4, 0, i6);
        }
        for (int i12 = i6 - 1; i12 > 0; i12--) {
            int i13 = iArr[i4];
            int i14 = i4 + i12;
            iArr[i4] = iArr[i14];
            trFixdown(i, i2, i3, i4, 0, i12);
            iArr[i14] = i13;
        }
    }

    private void trInsertionSort(int i, int i2, int i3, int i4, int i5) {
        int trGetC;
        int[] iArr = this.f40199SA;
        for (int i6 = i4 + 1; i6 < i5; i6++) {
            int i7 = iArr[i6];
            int i8 = i6 - 1;
            do {
                trGetC = trGetC(i, i2, i3, i7) - trGetC(i, i2, i3, iArr[i8]);
                if (trGetC >= 0) {
                    break;
                }
                do {
                    iArr[i8 + 1] = iArr[i8];
                    i8--;
                    if (i4 <= i8) {
                    }
                } while (iArr[i8] < 0);
                continue;
            } while (i8 >= i4);
            if (trGetC == 0) {
                iArr[i8] = iArr[i8] ^ (-1);
            }
            iArr[i8 + 1] = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04df A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x02ec -> B:135:0x02bf). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trIntroSort(int r22, int r23, int r24, int r25, int r26, io.netty.handler.codec.compression.Bzip2DivSufSort.TRBudget r27, int r28) {
        /*
            Method dump skipped, instructions count: 1297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.trIntroSort(int, int, int, int, int, io.netty.handler.codec.compression.Bzip2DivSufSort$TRBudget, int):void");
    }

    private static int trLog(int i) {
        return ((-65536) & i) != 0 ? ((-16777216) & i) != 0 ? LOG_2_TABLE[(i >> 24) & 255] + 24 : LOG_2_TABLE[(i >> 16) & 271] : (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int trMedian3(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.f40199SA;
        int trGetC = trGetC(i, i2, i3, iArr[i4]);
        int trGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int trGetC3 = trGetC(i, i2, i3, iArr[i6]);
        if (trGetC <= trGetC2) {
            i5 = i4;
            i4 = i5;
            trGetC2 = trGetC;
            trGetC = trGetC2;
        }
        return trGetC > trGetC3 ? trGetC2 > trGetC3 ? i5 : i6 : i4;
    }

    private int trMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.f40199SA;
        int trGetC = trGetC(i, i2, i3, iArr[i4]);
        int trGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int trGetC3 = trGetC(i, i2, i3, iArr[i6]);
        int trGetC4 = trGetC(i, i2, i3, iArr[i7]);
        int trGetC5 = trGetC(i, i2, i3, iArr[i8]);
        if (trGetC2 > trGetC3) {
            i6 = i5;
            i5 = i6;
            trGetC3 = trGetC2;
            trGetC2 = trGetC3;
        }
        if (trGetC4 > trGetC5) {
            trGetC4 = trGetC5;
            trGetC5 = trGetC4;
        } else {
            i8 = i7;
            i7 = i8;
        }
        if (trGetC2 > trGetC4) {
            int i9 = trGetC3;
            trGetC3 = trGetC5;
            trGetC5 = i9;
            int i10 = i7;
            i7 = i6;
            i6 = i10;
        } else {
            i5 = i8;
            trGetC2 = trGetC4;
        }
        if (trGetC > trGetC3) {
            int i11 = i6;
            i6 = i4;
            i4 = i11;
            int i12 = trGetC3;
            trGetC3 = trGetC;
            trGetC = i12;
        }
        if (trGetC > trGetC2) {
            i5 = i4;
            trGetC2 = trGetC;
        } else {
            i7 = i6;
            trGetC5 = trGetC3;
        }
        return trGetC5 > trGetC2 ? i5 : i7;
    }

    private PartitionResult trPartition(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int trGetC;
        int trGetC2;
        int trGetC3;
        int[] iArr = this.f40199SA;
        int i9 = 0;
        int i10 = i4;
        while (i10 < i5) {
            i9 = trGetC(i, i2, i3, iArr[i10]);
            if (i9 != i6) {
                break;
            }
            i10++;
        }
        if (i10 < i5 && i9 < i6) {
            i7 = i10;
            while (true) {
                i10++;
                if (i10 >= i5 || (i9 = trGetC(i, i2, i3, iArr[i10])) > i6) {
                    break;
                } else if (i9 == i6) {
                    swapElements(iArr, i10, iArr, i7);
                    i7++;
                }
            }
        } else {
            i7 = i10;
        }
        int i11 = i5 - 1;
        while (i10 < i11) {
            i9 = trGetC(i, i2, i3, iArr[i11]);
            if (i9 != i6) {
                break;
            }
            i11--;
        }
        if (i10 < i11 && i9 > i6) {
            i8 = i11;
            while (true) {
                i11--;
                if (i10 >= i11 || (trGetC3 = trGetC(i, i2, i3, iArr[i11])) < i6) {
                    break;
                } else if (trGetC3 == i6) {
                    swapElements(iArr, i11, iArr, i8);
                    i8--;
                }
            }
        } else {
            i8 = i11;
        }
        while (i10 < i11) {
            swapElements(iArr, i10, iArr, i11);
            while (true) {
                i10++;
                if (i10 >= i11 || (trGetC2 = trGetC(i, i2, i3, iArr[i10])) > i6) {
                    break;
                } else if (trGetC2 == i6) {
                    swapElements(iArr, i10, iArr, i7);
                    i7++;
                }
            }
            while (true) {
                i11--;
                if (i10 < i11 && (trGetC = trGetC(i, i2, i3, iArr[i11])) >= i6) {
                    if (trGetC == i6) {
                        swapElements(iArr, i11, iArr, i8);
                        i8--;
                    }
                }
            }
        }
        if (i7 <= i8) {
            int i12 = i10 - 1;
            int i13 = i7 - i4;
            int i14 = i10 - i7;
            if (i13 > i14) {
                i13 = i14;
            }
            int i15 = i10 - i13;
            int i16 = i4;
            while (i13 > 0) {
                swapElements(iArr, i16, iArr, i15);
                i13--;
                i16++;
                i15++;
            }
            int i17 = i8 - i12;
            int i18 = (i5 - i8) - 1;
            if (i17 <= i18) {
                i18 = i17;
            }
            int i19 = i5 - i18;
            while (i18 > 0) {
                swapElements(iArr, i10, iArr, i19);
                i18--;
                i10++;
                i19++;
            }
            i4 += i14;
            i5 -= i17;
        }
        return new PartitionResult(i4, i5);
    }

    private int trPivot(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = i4 + (i6 / 2);
        if (i6 <= 512) {
            if (i6 <= 32) {
                return trMedian3(i, i2, i3, i4, i7, i5 - 1);
            }
            int i8 = i6 >> 2;
            int i9 = i5 - 1;
            return trMedian5(i, i2, i3, i4, i4 + i8, i7, i9 - i8, i9);
        }
        int i10 = i6 >> 3;
        int i11 = i10 << 1;
        int i12 = i5 - 1;
        return trMedian3(i, i2, i3, trMedian3(i, i2, i3, i4, i4 + i10, i4 + i11), trMedian3(i, i2, i3, i7 - i10, i7, i7 + i10), trMedian3(i, i2, i3, i12 - i11, i12 - i10, i12));
    }

    private void trSort(int i, int i2, int i3) {
        int[] iArr = this.f40199SA;
        if ((-i2) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i2, ((trLog(i2) * 2) / 3) + 1);
            int i4 = 0;
            do {
                int i5 = iArr[i4];
                if (i5 < 0) {
                    i4 -= i5;
                    continue;
                } else {
                    int i6 = iArr[i + i5] + 1;
                    if (1 < i6 - i4) {
                        trIntroSort(i, i + i3, i + i2, i4, i6, tRBudget, i2);
                        if (tRBudget.chance == 0) {
                            if (i4 > 0) {
                                iArr[0] = -i4;
                            }
                            lsSort(i, i2, i3);
                            return;
                        }
                    }
                    i4 = i6;
                    continue;
                }
            } while (i4 < i2);
        }
    }

    public int bwt() {
        int[] iArr = this.f40199SA;
        byte[] bArr = this.f40200T;
        int i = this.f40201n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            iArr[0] = bArr[0];
            return 0;
        } else if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        } else {
            return 0;
        }
    }
}

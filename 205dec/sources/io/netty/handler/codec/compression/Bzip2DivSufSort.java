package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;
    private final int[] SA;
    private final byte[] T;

    /* renamed from: n  reason: collision with root package name */
    private final int f54777n;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class PartitionResult {
        final int first;
        final int last;

        PartitionResult(int i4, int i5) {
            this.first = i4;
            this.last = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class StackEntry {

        /* renamed from: a  reason: collision with root package name */
        final int f54778a;

        /* renamed from: b  reason: collision with root package name */
        final int f54779b;

        /* renamed from: c  reason: collision with root package name */
        final int f54780c;

        /* renamed from: d  reason: collision with root package name */
        final int f54781d;

        StackEntry(int i4, int i5, int i6, int i7) {
            this.f54778a = i4;
            this.f54779b = i5;
            this.f54780c = i6;
            this.f54781d = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class TRBudget {
        int budget;
        int chance;

        TRBudget(int i4, int i5) {
            this.budget = i4;
            this.chance = i5;
        }

        boolean update(int i4, int i5) {
            int i6 = this.budget - i5;
            this.budget = i6;
            if (i6 <= 0) {
                int i7 = this.chance - 1;
                this.chance = i7;
                if (i7 == 0) {
                    return false;
                }
                this.budget = i6 + i4;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2DivSufSort(byte[] bArr, int[] iArr, int i4) {
        this.T = bArr;
        this.SA = iArr;
        this.f54777n = i4;
    }

    private static int BUCKET_B(int i4, int i5) {
        return i4 | (i5 << 8);
    }

    private static int BUCKET_BSTAR(int i4, int i5) {
        return (i4 << 8) | i5;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.T;
        int[] iArr3 = this.SA;
        int i4 = this.f54777n;
        int i5 = 254;
        int i6 = 0;
        int i7 = 0;
        while (i5 >= 0) {
            int i8 = i5 + 1;
            int i9 = iArr2[BUCKET_BSTAR(i5, i8)];
            int i10 = 0;
            int i11 = -1;
            for (int i12 = iArr[i8]; i9 <= i12; i12--) {
                int i13 = iArr3[i12];
                if (i13 >= 0) {
                    int i14 = i13 - 1;
                    if (i14 < 0) {
                        i14 = i4 - 1;
                    }
                    int i15 = bArr[i14] & 255;
                    if (i15 <= i5) {
                        iArr3[i12] = i13 ^ (-1);
                        if (i14 > 0 && (bArr[i14 - 1] & 255) > i15) {
                            i14 ^= -1;
                        }
                        if (i11 == i15) {
                            i10--;
                            iArr3[i10] = i14;
                        } else {
                            if (i11 >= 0) {
                                iArr2[BUCKET_B(i11, i5)] = i10;
                            }
                            i10 = iArr2[BUCKET_B(i15, i5)] - 1;
                            iArr3[i10] = i14;
                            i11 = i15;
                        }
                    }
                } else {
                    iArr3[i12] = i13 ^ (-1);
                }
            }
            i5--;
            i6 = i10;
            i7 = i11;
        }
        int i16 = -1;
        for (int i17 = 0; i17 < i4; i17++) {
            int i18 = iArr3[i17];
            if (i18 >= 0) {
                int i19 = i18 - 1;
                if (i19 < 0) {
                    i19 = i4 - 1;
                }
                int i20 = bArr[i19] & 255;
                if (i20 >= (bArr[i19 + 1] & 255)) {
                    if (i19 > 0 && (bArr[i19 - 1] & 255) < i20) {
                        i19 ^= -1;
                    }
                    if (i20 == i7) {
                        i6++;
                        iArr3[i6] = i19;
                    } else {
                        if (i7 != -1) {
                            iArr[i7] = i6;
                        }
                        i6 = iArr[i20] + 1;
                        iArr3[i6] = i19;
                        i7 = i20;
                    }
                }
            } else {
                i18 ^= -1;
            }
            if (i18 == 0) {
                iArr3[i17] = bArr[i4 - 1];
                i16 = i17;
            } else {
                iArr3[i17] = bArr[i18 - 1];
            }
        }
        return i16;
    }

    private static int getIDX(int i4) {
        return i4 >= 0 ? i4 : i4 ^ (-1);
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

    private void lsSort(int i4, int i5, int i6) {
        int i7;
        int[] iArr = this.SA;
        int i8 = i6 + i4;
        while (true) {
            int i9 = 0;
            if ((-i5) >= iArr[0]) {
                return;
            }
            int i10 = 0;
            int i11 = 0;
            do {
                int i12 = iArr[i11];
                if (i12 < 0) {
                    i11 -= i12;
                    i10 += i12;
                    continue;
                } else {
                    if (i10 != 0) {
                        iArr[i11 + i10] = i10;
                        i7 = 0;
                    } else {
                        i7 = i10;
                    }
                    int i13 = iArr[i12 + i4] + 1;
                    lsIntroSort(i4, i8, i4 + i5, i11, i13);
                    i10 = i7;
                    i11 = i13;
                    continue;
                }
            } while (i11 < i5);
            if (i10 != 0) {
                iArr[i11 + i10] = i10;
            }
            int i14 = i8 - i4;
            if (i5 < i14) {
                do {
                    int i15 = iArr[i9];
                    if (i15 < 0) {
                        i9 -= i15;
                        continue;
                    } else {
                        int i16 = iArr[i15 + i4] + 1;
                        while (i9 < i16) {
                            iArr[iArr[i9] + i4] = i9;
                            i9++;
                        }
                        i9 = i16;
                        continue;
                    }
                } while (i9 < i5);
                return;
            }
            i8 += i14;
        }
    }

    private void lsUpdateGroup(int i4, int i5, int i6) {
        int[] iArr = this.SA;
        while (i5 < i6) {
            if (iArr[i5] >= 0) {
                int i7 = i5;
                do {
                    iArr[iArr[i7] + i4] = i7;
                    i7++;
                    if (i7 >= i6) {
                        break;
                    }
                } while (iArr[i7] >= 0);
                iArr[i5] = i5 - i7;
                if (i6 <= i7) {
                    return;
                }
                i5 = i7;
            }
            int i8 = i5;
            do {
                iArr[i8] = iArr[i8] ^ (-1);
                i8++;
            } while (iArr[i8] < 0);
            do {
                iArr[iArr[i5] + i4] = i8;
                i5++;
            } while (i5 <= i8);
            i5 = i8 + 1;
        }
    }

    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        byte[] bArr = this.T;
        int[] iArr4 = this.SA;
        int i16 = this.f54777n;
        int[] iArr5 = new int[256];
        int i17 = 1;
        while (true) {
            if (i17 >= i16) {
                break;
            }
            int i18 = i17 - 1;
            if (bArr[i18] == bArr[i17]) {
                i17++;
            } else if ((bArr[i18] & 255) > (bArr[i17] & 255)) {
                z3 = false;
            }
        }
        z3 = true;
        int i19 = i16 - 1;
        int i20 = bArr[i19] & 255;
        int i21 = bArr[0] & 255;
        if (i20 < i21 || (bArr[i19] == bArr[0] && z3)) {
            if (!z3) {
                int BUCKET_BSTAR = BUCKET_BSTAR(i20, i21);
                iArr2[BUCKET_BSTAR] = iArr2[BUCKET_BSTAR] + 1;
                i4 = i16 - 1;
                iArr4[i4] = i19;
            } else {
                int BUCKET_B = BUCKET_B(i20, i21);
                iArr2[BUCKET_B] = iArr2[BUCKET_B] + 1;
                i4 = i16;
            }
            i5 = i19 - 1;
            while (i5 >= 0) {
                int i22 = bArr[i5] & 255;
                int i23 = bArr[i5 + 1] & 255;
                if (i22 <= i23) {
                    int BUCKET_B2 = BUCKET_B(i22, i23);
                    iArr2[BUCKET_B2] = iArr2[BUCKET_B2] + 1;
                    i5--;
                }
            }
        } else {
            i4 = i16;
            i5 = i19;
        }
        while (i5 >= 0) {
            do {
                int i24 = bArr[i5] & 255;
                iArr[i24] = iArr[i24] + 1;
                i5--;
                if (i5 < 0) {
                    break;
                }
            } while ((bArr[i5] & 255) >= (bArr[i5 + 1] & 255));
            if (i5 >= 0) {
                int BUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i5] & 255, bArr[i5 + 1] & 255);
                iArr2[BUCKET_BSTAR2] = iArr2[BUCKET_BSTAR2] + 1;
                i4--;
                iArr4[i4] = i5;
                while (true) {
                    i5--;
                    if (i5 >= 0 && (i14 = bArr[i5] & 255) <= (i15 = bArr[i5 + 1] & 255)) {
                        int BUCKET_B3 = BUCKET_B(i14, i15);
                        iArr2[BUCKET_B3] = iArr2[BUCKET_B3] + 1;
                    }
                }
            }
        }
        int i25 = i16 - i4;
        if (i25 == 0) {
            for (int i26 = 0; i26 < i16; i26++) {
                iArr4[i26] = i26;
            }
            return 0;
        }
        int i27 = 0;
        int i28 = -1;
        int i29 = 0;
        while (i27 < 256) {
            int i30 = iArr[i27] + i28;
            iArr[i27] = i28 + i29;
            int i31 = i30 + iArr2[BUCKET_B(i27, i27)];
            int i32 = i27 + 1;
            for (int i33 = i32; i33 < 256; i33++) {
                i29 += iArr2[BUCKET_BSTAR(i27, i33)];
                iArr2[(i27 << 8) | i33] = i29;
                i31 += iArr2[BUCKET_B(i27, i33)];
            }
            i27 = i32;
            i28 = i31;
        }
        int i34 = i16 - i25;
        for (int i35 = i25 - 2; i35 >= 0; i35--) {
            int i36 = iArr4[i34 + i35];
            int BUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i36] & 255, bArr[i36 + 1] & 255);
            int i37 = iArr2[BUCKET_BSTAR3] - 1;
            iArr2[BUCKET_BSTAR3] = i37;
            iArr4[i37] = i35;
        }
        int i38 = iArr4[(i34 + i25) - 1];
        int BUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i38] & 255, bArr[i38 + 1] & 255);
        int i39 = iArr2[BUCKET_BSTAR4] - 1;
        iArr2[BUCKET_BSTAR4] = i39;
        int i40 = i25 - 1;
        iArr4[i39] = i40;
        int i41 = i16 - (i25 * 2);
        if (i41 <= 256) {
            iArr3 = iArr5;
            i6 = 256;
            i7 = 0;
        } else {
            i6 = i41;
            i7 = i25;
            iArr3 = iArr4;
        }
        int i42 = i25;
        int i43 = 255;
        while (i42 > 0) {
            int i44 = i42;
            int i45 = 255;
            while (i43 < i45) {
                int i46 = iArr2[BUCKET_BSTAR(i43, i45)];
                if (1 < i44 - i46) {
                    i10 = i45;
                    i11 = i43;
                    i12 = i40;
                    i13 = i25;
                    subStringSort(i34, i46, i44, iArr3, i7, i6, 2, iArr4[i46] == i40, i16);
                } else {
                    i10 = i45;
                    i11 = i43;
                    i12 = i40;
                    i13 = i25;
                }
                i45 = i10 - 1;
                i25 = i13;
                i44 = i46;
                i43 = i11;
                i40 = i12;
            }
            i43--;
            i42 = i44;
        }
        int i47 = i40;
        int i48 = i25;
        while (i40 >= 0) {
            if (iArr4[i40] >= 0) {
                int i49 = i40;
                do {
                    iArr4[i48 + iArr4[i49]] = i49;
                    i49--;
                    if (i49 < 0) {
                        break;
                    }
                } while (iArr4[i49] >= 0);
                iArr4[i49 + 1] = i49 - i40;
                if (i49 <= 0) {
                    break;
                }
                i40 = i49;
            }
            int i50 = i40;
            do {
                int i51 = iArr4[i50] ^ (-1);
                iArr4[i50] = i51;
                iArr4[i48 + i51] = i40;
                i50--;
            } while (iArr4[i50] < 0);
            iArr4[i48 + iArr4[i50]] = i40;
            i40 = i50 - 1;
        }
        trSort(i48, i48, 1);
        if ((bArr[i19] & 255) < (bArr[0] & 255) || (bArr[i19] == bArr[0] && z3)) {
            if (z3) {
                i8 = i48;
            } else {
                i8 = i48 - 1;
                iArr4[iArr4[i48 + i8]] = i19;
            }
            i9 = i19 - 1;
            while (i9 >= 0 && (bArr[i9] & 255) <= (bArr[i9 + 1] & 255)) {
                i9--;
            }
        } else {
            i8 = i48;
            i9 = i19;
        }
        while (i9 >= 0) {
            do {
                i9--;
                if (i9 < 0) {
                    break;
                }
            } while ((bArr[i9] & 255) >= (bArr[i9 + 1] & 255));
            if (i9 >= 0) {
                i8--;
                iArr4[iArr4[i48 + i8]] = i9;
                do {
                    i9--;
                    if (i9 >= 0) {
                    }
                } while ((bArr[i9] & 255) <= (bArr[i9 + 1] & 255));
            }
        }
        int i52 = i47;
        for (int i53 = 255; i53 >= 0; i53--) {
            for (int i54 = 255; i53 < i54; i54--) {
                int i55 = i19 - iArr2[BUCKET_B(i53, i54)];
                iArr2[BUCKET_B(i53, i54)] = i19 + 1;
                int i56 = iArr2[BUCKET_BSTAR(i53, i54)];
                i19 = i55;
                while (i56 <= i52) {
                    iArr4[i19] = iArr4[i52];
                    i19--;
                    i52--;
                }
            }
            int i57 = i19 - iArr2[BUCKET_B(i53, i53)];
            iArr2[BUCKET_B(i53, i53)] = i19 + 1;
            if (i53 < 255) {
                iArr2[BUCKET_BSTAR(i53, i53 + 1)] = i57 + 1;
            }
            i19 = iArr[i53];
        }
        return i48;
    }

    private static void ssBlockSwap(int[] iArr, int i4, int[] iArr2, int i5, int i6) {
        while (i6 > 0) {
            swapElements(iArr, i4, iArr2, i5);
            i6--;
            i4++;
            i5++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        return (r1[r5] & 255) - (r1[r7] & 255);
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
            int[] r0 = r4.SA
            byte[] r1 = r4.T
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
        return (r1[r7] & 255) - (r1[r9] & 255);
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
        return (r1[r7] & 255) - (r1[r9] & 255);
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
            int[] r0 = r5.SA
            byte[] r1 = r5.T
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

    private void ssFixdown(int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i9 = iArr[i6 + i7];
        int i10 = bArr[iArr[i5 + i9] + i4] & 255;
        while (true) {
            int i11 = (i7 * 2) + 1;
            if (i11 >= i8) {
                break;
            }
            int i12 = i11 + 1;
            int i13 = bArr[iArr[iArr[i6 + i11] + i5] + i4] & 255;
            int i14 = bArr[iArr[iArr[i6 + i12] + i5] + i4] & 255;
            if (i13 < i14) {
                i11 = i12;
                i13 = i14;
            }
            if (i13 <= i10) {
                break;
            }
            iArr[i7 + i6] = iArr[i6 + i11];
            i7 = i11;
        }
        iArr[i6 + i7] = i9;
    }

    private void ssHeapSort(int i4, int i5, int i6, int i7) {
        int i8;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i9 = i7 % 2;
        if (i9 == 0) {
            int i10 = i7 - 1;
            int i11 = (i10 / 2) + i6;
            int i12 = i6 + i10;
            if ((bArr[iArr[iArr[i11] + i5] + i4] & 255) < (bArr[iArr[iArr[i12] + i5] + i4] & 255)) {
                swapElements(iArr, i12, iArr, i11);
            }
            i8 = i10;
        } else {
            i8 = i7;
        }
        for (int i13 = (i8 / 2) - 1; i13 >= 0; i13--) {
            ssFixdown(i4, i5, i6, i13, i8);
        }
        if (i9 == 0) {
            swapElements(iArr, i6, iArr, i6 + i8);
            ssFixdown(i4, i5, i6, 0, i8);
        }
        for (int i14 = i8 - 1; i14 > 0; i14--) {
            int i15 = iArr[i6];
            int i16 = i6 + i14;
            iArr[i6] = iArr[i16];
            ssFixdown(i4, i5, i6, 0, i14);
            iArr[i16] = i15;
        }
    }

    private void ssInsertionSort(int i4, int i5, int i6, int i7) {
        int ssCompare;
        int[] iArr = this.SA;
        for (int i8 = i6 - 2; i5 <= i8; i8--) {
            int i9 = iArr[i8];
            int i10 = i8 + 1;
            do {
                ssCompare = ssCompare(i4 + i9, iArr[i10] + i4, i7);
                if (ssCompare <= 0) {
                    break;
                }
                do {
                    iArr[i10 - 1] = iArr[i10];
                    i10++;
                    if (i10 < i6) {
                    }
                } while (iArr[i10] < 0);
                continue;
            } while (i6 > i10);
            if (ssCompare == 0) {
                iArr[i10] = iArr[i10] ^ (-1);
            }
            iArr[i10 - 1] = i9;
        }
    }

    private static int ssLog(int i4) {
        return (65280 & i4) != 0 ? LOG_2_TABLE[(i4 >> 8) & 255] + 8 : LOG_2_TABLE[i4 & 255];
    }

    private int ssMedian3(int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i9 = bArr[iArr[iArr[i6] + i5] + i4] & 255;
        int i10 = bArr[iArr[iArr[i7] + i5] + i4] & 255;
        int i11 = bArr[i4 + iArr[i5 + iArr[i8]]] & 255;
        if (i9 <= i10) {
            i7 = i6;
            i6 = i7;
            i10 = i9;
            i9 = i10;
        }
        return i9 > i11 ? i10 > i11 ? i7 : i8 : i6;
    }

    private int ssMedian5(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i20 = bArr[iArr[iArr[i6] + i5] + i4] & 255;
        int i21 = bArr[iArr[iArr[i7] + i5] + i4] & 255;
        int i22 = bArr[iArr[iArr[i8] + i5] + i4] & 255;
        int i23 = bArr[iArr[iArr[i9] + i5] + i4] & 255;
        int i24 = bArr[iArr[iArr[i10] + i5] + i4] & 255;
        if (i21 > i22) {
            i11 = i8;
            i12 = i21;
            i13 = i7;
        } else {
            i11 = i7;
            i12 = i22;
            i22 = i21;
            i13 = i8;
        }
        if (i23 > i24) {
            i15 = i24;
            i14 = i23;
            i17 = i9;
            i16 = i10;
        } else {
            i14 = i24;
            i15 = i23;
            i16 = i9;
            i17 = i10;
        }
        if (i22 > i15) {
            int i25 = i13;
            i13 = i17;
            i17 = i25;
            int i26 = i14;
            i14 = i12;
            i12 = i26;
        } else {
            i11 = i16;
            i22 = i15;
        }
        if (i20 > i12) {
            i18 = i20;
            i19 = i6;
        } else {
            i18 = i12;
            i12 = i20;
            i19 = i13;
            i13 = i6;
        }
        if (i12 > i22) {
            i11 = i13;
            i22 = i12;
        } else {
            i17 = i19;
            i14 = i18;
        }
        return i14 > i22 ? i11 : i17;
    }

    private void ssMerge(int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            int i21 = i18 - i17;
            if (i21 <= i9) {
                if (i16 >= i17 || i17 >= i18) {
                    i11 = i18;
                } else {
                    i11 = i18;
                    ssMergeBackward(i4, iArr, i8, i16, i17, i18, i10);
                }
                if ((i19 & 1) != 0) {
                    ssMergeCheckEqual(i4, i10, i16);
                }
                if ((i19 & 2) != 0) {
                    ssMergeCheckEqual(i4, i10, i11);
                }
                if (i20 == 0) {
                    return;
                }
                i20--;
                StackEntry stackEntry = stackEntryArr[i20];
                i16 = stackEntry.f54778a;
                i17 = stackEntry.f54779b;
                i18 = stackEntry.f54780c;
                i12 = stackEntry.f54781d;
            } else {
                int i22 = i18;
                int i23 = i17 - i16;
                if (i23 <= i9) {
                    if (i16 < i17) {
                        ssMergeForward(i4, iArr, i8, i16, i17, i22, i10);
                    }
                    if ((i19 & 1) != 0) {
                        ssMergeCheckEqual(i4, i10, i16);
                    }
                    if ((i19 & 2) != 0) {
                        ssMergeCheckEqual(i4, i10, i22);
                    }
                    if (i20 == 0) {
                        return;
                    }
                    i20--;
                    StackEntry stackEntry2 = stackEntryArr[i20];
                    i16 = stackEntry2.f54778a;
                    i17 = stackEntry2.f54779b;
                    i18 = stackEntry2.f54780c;
                    i12 = stackEntry2.f54781d;
                } else {
                    int min = Math.min(i23, i21);
                    int i24 = min >> 1;
                    int i25 = 0;
                    while (min > 0) {
                        if (ssCompare(getIDX(iArr2[i17 + i25 + i24]) + i4, getIDX(iArr2[((i17 - i25) - i24) - 1]) + i4, i10) < 0) {
                            i25 += i24 + 1;
                            i24 -= (min & 1) ^ 1;
                        }
                        min = i24;
                        i24 = min >> 1;
                    }
                    if (i25 > 0) {
                        int i26 = i17 - i25;
                        ssBlockSwap(iArr2, i26, iArr2, i17, i25);
                        int i27 = i17 + i25;
                        if (i27 < i22) {
                            if (iArr2[i27] < 0) {
                                i15 = i17;
                                while (iArr2[i15 - 1] < 0) {
                                    i15--;
                                }
                                iArr2[i27] = iArr2[i27] ^ (-1);
                            } else {
                                i15 = i17;
                            }
                            i13 = i17;
                            while (iArr2[i13] < 0) {
                                i13++;
                            }
                            i18 = i15;
                            i14 = 1;
                        } else {
                            i13 = i17;
                            i18 = i13;
                            i14 = 0;
                        }
                        if (i18 - i16 <= i22 - i13) {
                            stackEntryArr[i20] = new StackEntry(i13, i27, i22, (i14 & 1) | (i19 & 2));
                            i19 &= 1;
                            i17 = i26;
                            i20++;
                        } else {
                            if (i18 == i17 && i17 == i13) {
                                i14 <<= 1;
                            }
                            stackEntryArr[i20] = new StackEntry(i16, i26, i18, (i19 & 1) | (i14 & 2));
                            i19 = (i19 & 2) | (i14 & 1);
                            i17 = i27;
                            i20++;
                            i16 = i13;
                            i18 = i22;
                        }
                    } else {
                        if ((i19 & 1) != 0) {
                            ssMergeCheckEqual(i4, i10, i16);
                        }
                        ssMergeCheckEqual(i4, i10, i17);
                        if ((i19 & 2) != 0) {
                            ssMergeCheckEqual(i4, i10, i22);
                        }
                        if (i20 == 0) {
                            return;
                        }
                        i20--;
                        StackEntry stackEntry3 = stackEntryArr[i20];
                        i16 = stackEntry3.f54778a;
                        i17 = stackEntry3.f54779b;
                        i18 = stackEntry3.f54780c;
                        i12 = stackEntry3.f54781d;
                    }
                }
            }
            i19 = i12;
        }
    }

    private void ssMergeBackward(int i4, int[] iArr, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        boolean z3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z4;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int[] iArr2 = this.SA;
        int i24 = i8 - i7;
        ssBlockSwap(iArr, i5, iArr2, i7, i24);
        int i25 = (i5 + i24) - 1;
        if (iArr[i25] < 0) {
            i10 = i4 + (iArr[i25] ^ (-1));
            z3 = true;
        } else {
            i10 = i4 + iArr[i25];
            z3 = false;
        }
        int i26 = i7 - 1;
        if (iArr2[i26] < 0) {
            z3 |= true;
            i11 = iArr2[i26] ^ (-1);
        } else {
            i11 = iArr2[i26];
        }
        int i27 = i4 + i11;
        int i28 = i8 - 1;
        int i29 = iArr2[i28];
        while (true) {
            int ssCompare = ssCompare(i10, i27, i9);
            if (ssCompare > 0) {
                if (z3 & true) {
                    while (true) {
                        i13 = i28 - 1;
                        iArr2[i28] = iArr[i25];
                        i14 = i25 - 1;
                        iArr[i25] = iArr2[i13];
                        if (iArr[i14] >= 0) {
                            break;
                        }
                        i25 = i14;
                        i28 = i13;
                    }
                    z3 = !z3;
                    i25 = i14;
                    i28 = i13;
                }
                int i30 = i28 - 1;
                iArr2[i28] = iArr[i25];
                if (i25 <= i5) {
                    iArr[i25] = i29;
                    return;
                }
                int i31 = i25 - 1;
                iArr[i25] = iArr2[i30];
                if (iArr[i31] < 0) {
                    z3 |= true;
                    i12 = iArr[i31] ^ (-1);
                } else {
                    i12 = iArr[i31];
                }
                int i32 = i4 + i12;
                i25 = i31;
                i28 = i30;
                i10 = i32;
            } else if (ssCompare < 0) {
                if (z3 & true) {
                    while (true) {
                        i16 = i28 - 1;
                        iArr2[i28] = iArr2[i26];
                        i17 = i26 - 1;
                        iArr2[i26] = iArr2[i16];
                        if (iArr2[i17] >= 0) {
                            break;
                        }
                        i26 = i17;
                        i28 = i16;
                    }
                    z3 ^= true;
                    i26 = i17;
                    i28 = i16;
                }
                int i33 = i28 - 1;
                iArr2[i28] = iArr2[i26];
                int i34 = i26 - 1;
                iArr2[i26] = iArr2[i33];
                if (i34 < i6) {
                    while (i5 < i25) {
                        int i35 = i33 - 1;
                        iArr2[i33] = iArr[i25];
                        iArr[i25] = iArr2[i35];
                        i33 = i35;
                        i25--;
                    }
                    iArr2[i33] = iArr[i25];
                    iArr[i25] = i29;
                    return;
                }
                if (iArr2[i34] < 0) {
                    z3 |= true;
                    i15 = iArr2[i34] ^ (-1);
                } else {
                    i15 = iArr2[i34];
                }
                i27 = i4 + i15;
                i26 = i34;
                i28 = i33;
            } else {
                if (z3 & true) {
                    while (true) {
                        i22 = i28 - 1;
                        iArr2[i28] = iArr[i25];
                        i23 = i25 - 1;
                        iArr[i25] = iArr2[i22];
                        if (iArr[i23] >= 0) {
                            break;
                        }
                        i25 = i23;
                        i28 = i22;
                    }
                    z3 = !z3;
                    i25 = i23;
                    i28 = i22;
                }
                int i36 = i28 - 1;
                iArr2[i28] = iArr[i25] ^ (-1);
                if (i25 <= i5) {
                    iArr[i25] = i29;
                    return;
                }
                int i37 = i25 - 1;
                iArr[i25] = iArr2[i36];
                if (z3 & true) {
                    while (true) {
                        i20 = i36 - 1;
                        iArr2[i36] = iArr2[i26];
                        i21 = i26 - 1;
                        iArr2[i26] = iArr2[i20];
                        if (iArr2[i21] >= 0) {
                            break;
                        }
                        i26 = i21;
                        i36 = i20;
                    }
                    z3 ^= true;
                    i26 = i21;
                    i36 = i20;
                }
                int i38 = i36 - 1;
                iArr2[i36] = iArr2[i26];
                int i39 = i26 - 1;
                iArr2[i26] = iArr2[i38];
                if (i39 < i6) {
                    while (i5 < i37) {
                        int i40 = i38 - 1;
                        iArr2[i38] = iArr[i37];
                        iArr[i37] = iArr2[i40];
                        i38 = i40;
                        i37--;
                    }
                    iArr2[i38] = iArr[i37];
                    iArr[i37] = i29;
                    return;
                }
                if (iArr[i37] < 0) {
                    z4 = z3 | true;
                    i18 = i4 + (iArr[i37] ^ (-1));
                } else {
                    boolean z5 = z3;
                    i18 = i4 + iArr[i37];
                    z4 = z5;
                }
                if (iArr2[i39] < 0) {
                    z4 |= true;
                    i19 = iArr2[i39] ^ (-1);
                } else {
                    i19 = iArr2[i39];
                }
                i27 = i4 + i19;
                int i41 = i18;
                z3 = z4;
                i26 = i39;
                i10 = i41;
                i25 = i37;
                i28 = i38;
            }
        }
    }

    private void ssMergeCheckEqual(int i4, int i5, int i6) {
        int[] iArr = this.SA;
        if (iArr[i6] < 0 || ssCompare(getIDX(iArr[i6 - 1]) + i4, i4 + iArr[i6], i5) != 0) {
            return;
        }
        iArr[i6] = iArr[i6] ^ (-1);
    }

    private void ssMergeForward(int i4, int[] iArr, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int[] iArr2 = this.SA;
        int i11 = i7 - i6;
        int i12 = (i5 + i11) - 1;
        ssBlockSwap(iArr, i5, iArr2, i6, i11);
        int i13 = iArr2[i6];
        while (true) {
            int ssCompare = ssCompare(iArr[i5] + i4, iArr2[i7] + i4, i9);
            if (ssCompare < 0) {
                while (true) {
                    i10 = i6 + 1;
                    iArr2[i6] = iArr[i5];
                    if (i12 <= i5) {
                        iArr[i5] = i13;
                        return;
                    }
                    int i14 = i5 + 1;
                    iArr[i5] = iArr2[i10];
                    if (iArr[i14] >= 0) {
                        i5 = i14;
                        break;
                    } else {
                        i5 = i14;
                        i6 = i10;
                    }
                }
            } else if (ssCompare > 0) {
                while (true) {
                    i10 = i6 + 1;
                    iArr2[i6] = iArr2[i7];
                    int i15 = i7 + 1;
                    iArr2[i7] = iArr2[i10];
                    if (i8 <= i15) {
                        while (i5 < i12) {
                            int i16 = i10 + 1;
                            iArr2[i10] = iArr[i5];
                            iArr[i5] = iArr2[i16];
                            i10 = i16;
                            i5++;
                        }
                        iArr2[i10] = iArr[i5];
                        iArr[i5] = i13;
                        return;
                    } else if (iArr2[i15] >= 0) {
                        i7 = i15;
                        break;
                    } else {
                        i7 = i15;
                        i6 = i10;
                    }
                }
            } else {
                iArr2[i7] = iArr2[i7] ^ (-1);
                while (true) {
                    int i17 = i6 + 1;
                    iArr2[i6] = iArr[i5];
                    if (i12 <= i5) {
                        iArr[i5] = i13;
                        return;
                    }
                    int i18 = i5 + 1;
                    iArr[i5] = iArr2[i17];
                    if (iArr[i18] >= 0) {
                        while (true) {
                            int i19 = i17 + 1;
                            iArr2[i17] = iArr2[i7];
                            int i20 = i7 + 1;
                            iArr2[i7] = iArr2[i19];
                            if (i8 <= i20) {
                                while (i18 < i12) {
                                    int i21 = i19 + 1;
                                    iArr2[i19] = iArr[i18];
                                    iArr[i18] = iArr2[i21];
                                    i18++;
                                    i19 = i21;
                                }
                                iArr2[i19] = iArr[i18];
                                iArr[i18] = i13;
                                return;
                            } else if (iArr2[i20] >= 0) {
                                i7 = i20;
                                i6 = i19;
                                i5 = i18;
                                break;
                            } else {
                                i7 = i20;
                                i17 = i19;
                            }
                        }
                    } else {
                        i5 = i18;
                        i6 = i17;
                    }
                }
            }
            i6 = i10;
        }
    }

    private void ssMultiKeyIntroSort(int i4, int i5, int i6, int i7) {
        int ssLog;
        int i8;
        int i9;
        int i10;
        int i11;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.SA;
        byte[] bArr = bzip2DivSufSort.T;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i12 = -1;
        int i13 = i6;
        int i14 = i7;
        int ssLog2 = ssLog(i6 - i5);
        int i15 = 0;
        int i16 = 0;
        int i17 = i5;
        while (true) {
            int i18 = i13 - i17;
            if (i18 <= 8) {
                if (1 < i18) {
                    bzip2DivSufSort.ssInsertionSort(i4, i17, i13, i14);
                }
                if (i15 == 0) {
                    return;
                }
                i15--;
                StackEntry stackEntry = stackEntryArr[i15];
                int i19 = stackEntry.f54778a;
                int i20 = stackEntry.f54779b;
                int i21 = stackEntry.f54780c;
                ssLog2 = stackEntry.f54781d;
                i17 = i19;
                i13 = i20;
                i14 = i21;
            } else {
                int i22 = ssLog2 - 1;
                if (ssLog2 == 0) {
                    bzip2DivSufSort.ssHeapSort(i14, i4, i17, i18);
                }
                if (i22 < 0) {
                    int i23 = bArr[iArr[iArr[i17] + i4] + i14] & 255;
                    int i24 = i17;
                    i17++;
                    while (i17 < i13) {
                        i16 = bArr[iArr[iArr[i17] + i4] + i14] & 255;
                        if (i16 != i23) {
                            if (1 < i17 - i24) {
                                break;
                            }
                            i24 = i17;
                            i23 = i16;
                        }
                        i17++;
                    }
                    if ((bArr[(iArr[iArr[i24] + i4] + i14) - 1] & 255) < i23) {
                        i24 = bzip2DivSufSort.ssSubstringPartition(i4, i24, i17, i14);
                    }
                    int i25 = i17 - i24;
                    int i26 = i13 - i17;
                    if (i25 <= i26) {
                        if (1 < i25) {
                            stackEntryArr[i15] = new StackEntry(i17, i13, i14, i12);
                            i14++;
                            ssLog = ssLog(i25);
                            i15++;
                            int i27 = ssLog;
                            i13 = i17;
                            i17 = i24;
                            ssLog2 = i27;
                        } else {
                            ssLog2 = -1;
                        }
                    } else if (1 < i26) {
                        stackEntryArr[i15] = new StackEntry(i24, i17, i14 + 1, ssLog(i25));
                        i15++;
                        ssLog2 = -1;
                    } else {
                        i14++;
                        ssLog = ssLog(i25);
                        int i272 = ssLog;
                        i13 = i17;
                        i17 = i24;
                        ssLog2 = i272;
                    }
                } else {
                    int ssPivot = bzip2DivSufSort.ssPivot(i14, i4, i17, i13);
                    int i28 = bArr[iArr[iArr[ssPivot] + i4] + i14] & 255;
                    swapElements(iArr, i17, iArr, ssPivot);
                    int i29 = i17 + 1;
                    while (i29 < i13) {
                        i16 = bArr[iArr[iArr[i29] + i4] + i14] & 255;
                        if (i16 != i28) {
                            break;
                        }
                        i29++;
                    }
                    if (i29 < i13 && i16 < i28) {
                        i8 = i16;
                        i9 = i29;
                        while (true) {
                            i29++;
                            if (i29 >= i13 || (i8 = bArr[iArr[iArr[i29] + i4] + i14] & 255) > i28) {
                                break;
                            } else if (i8 == i28) {
                                swapElements(iArr, i29, iArr, i9);
                                i9++;
                            }
                        }
                    } else {
                        i8 = i16;
                        i9 = i29;
                    }
                    int i30 = i13 - 1;
                    while (i29 < i30) {
                        i8 = bArr[iArr[iArr[i30] + i4] + i14] & 255;
                        if (i8 != i28) {
                            break;
                        }
                        i30--;
                    }
                    if (i29 < i30 && i8 > i28) {
                        int i31 = i8;
                        int i32 = i30;
                        while (true) {
                            i30 += i12;
                            if (i29 >= i30) {
                                i10 = i32;
                                i8 = i31;
                                break;
                            }
                            int i33 = bArr[i14 + iArr[i4 + iArr[i30]]] & 255;
                            if (i33 < i28) {
                                int i34 = i32;
                                i8 = i33;
                                i10 = i34;
                                break;
                            }
                            if (i33 == i28) {
                                swapElements(iArr, i30, iArr, i32);
                                i32--;
                            }
                            i31 = i33;
                            i12 = -1;
                        }
                    } else {
                        i10 = i30;
                    }
                    while (i29 < i30) {
                        swapElements(iArr, i29, iArr, i30);
                        while (true) {
                            i29++;
                            if (i29 >= i30 || (i8 = bArr[iArr[iArr[i29] + i4] + i14] & 255) > i28) {
                                break;
                            } else if (i8 == i28) {
                                swapElements(iArr, i29, iArr, i9);
                                i9++;
                            }
                        }
                        while (true) {
                            i30--;
                            if (i29 < i30 && (i8 = bArr[iArr[iArr[i30] + i4] + i14] & 255) >= i28) {
                                if (i8 == i28) {
                                    swapElements(iArr, i30, iArr, i10);
                                    i10--;
                                }
                            }
                        }
                    }
                    if (i9 <= i10) {
                        int i35 = i29 - 1;
                        int i36 = i8;
                        int i37 = i9 - i17;
                        int i38 = i29 - i9;
                        if (i37 > i38) {
                            i37 = i38;
                        }
                        int i39 = i17;
                        int i40 = i29;
                        int i41 = i29 - i37;
                        while (i37 > 0) {
                            swapElements(iArr, i39, iArr, i41);
                            i37--;
                            i39++;
                            i41++;
                        }
                        int i42 = i10 - i35;
                        int i43 = (i13 - i10) - 1;
                        if (i42 <= i43) {
                            i43 = i42;
                        }
                        int i44 = i13 - i43;
                        int i45 = i40;
                        while (i43 > 0) {
                            swapElements(iArr, i45, iArr, i44);
                            i43--;
                            i45++;
                            i44++;
                        }
                        int i46 = i17 + i38;
                        int i47 = i13 - i42;
                        int ssSubstringPartition = i28 <= (bArr[(iArr[iArr[i46] + i4] + i14) + (-1)] & 255) ? i46 : bzip2DivSufSort.ssSubstringPartition(i4, i46, i47, i14);
                        int i48 = i46 - i17;
                        int i49 = i13 - i47;
                        if (i48 <= i49) {
                            int i50 = i47 - ssSubstringPartition;
                            if (i49 <= i50) {
                                int i51 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(ssSubstringPartition, i47, i14 + 1, ssLog(i50));
                                i15 = i51 + 1;
                                i11 = i22;
                                stackEntryArr[i51] = new StackEntry(i47, i13, i14, i11);
                            } else {
                                i11 = i22;
                                if (i48 <= i50) {
                                    int i52 = i15 + 1;
                                    stackEntryArr[i15] = new StackEntry(i47, i13, i14, i11);
                                    i15 = i52 + 1;
                                    stackEntryArr[i52] = new StackEntry(ssSubstringPartition, i47, i14 + 1, ssLog(i50));
                                } else {
                                    int i53 = i15 + 1;
                                    stackEntryArr[i15] = new StackEntry(i47, i13, i14, i11);
                                    i15 = i53 + 1;
                                    stackEntryArr[i53] = new StackEntry(i17, i46, i14, i11);
                                    i14++;
                                    i13 = i47;
                                    i12 = -1;
                                    ssLog2 = ssLog(i50);
                                    i17 = ssSubstringPartition;
                                    i16 = i36;
                                }
                            }
                            i16 = i36;
                            i13 = i46;
                            ssLog2 = i11;
                        } else {
                            int i54 = i47 - ssSubstringPartition;
                            if (i48 <= i54) {
                                int i55 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(ssSubstringPartition, i47, i14 + 1, ssLog(i54));
                                i15 = i55 + 1;
                                stackEntryArr[i55] = new StackEntry(i17, i46, i14, i22);
                            } else if (i49 <= i54) {
                                int i56 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(i17, i46, i14, i22);
                                i15 = i56 + 1;
                                stackEntryArr[i56] = new StackEntry(ssSubstringPartition, i47, i14 + 1, ssLog(i54));
                            } else {
                                int i57 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(i17, i46, i14, i22);
                                i15 = i57 + 1;
                                stackEntryArr[i57] = new StackEntry(i47, i13, i14, i22);
                                i14++;
                                i12 = -1;
                                i13 = i47;
                                i17 = ssSubstringPartition;
                                i16 = i36;
                                ssLog2 = ssLog(i54);
                                bzip2DivSufSort = this;
                            }
                            i12 = -1;
                            bzip2DivSufSort = this;
                            i16 = i36;
                            i17 = i47;
                            ssLog2 = i22;
                        }
                    } else {
                        int i58 = i8;
                        int i59 = i22 + 1;
                        if ((bArr[(iArr[iArr[i17] + i4] + i14) - 1] & 255) < i28) {
                            bzip2DivSufSort = this;
                            i17 = bzip2DivSufSort.ssSubstringPartition(i4, i17, i13, i14);
                            ssLog2 = ssLog(i13 - i17);
                        } else {
                            bzip2DivSufSort = this;
                            ssLog2 = i59;
                        }
                        i14++;
                        i16 = i58;
                    }
                    i12 = -1;
                }
            }
        }
    }

    private int ssPivot(int i4, int i5, int i6, int i7) {
        int i8 = i7 - i6;
        int i9 = i6 + (i8 / 2);
        if (i8 <= 512) {
            if (i8 <= 32) {
                return ssMedian3(i4, i5, i6, i9, i7 - 1);
            }
            int i10 = i8 >> 2;
            int i11 = i7 - 1;
            return ssMedian5(i4, i5, i6, i6 + i10, i9, i11 - i10, i11);
        }
        int i12 = i8 >> 3;
        int i13 = i12 << 1;
        int i14 = i7 - 1;
        return ssMedian3(i4, i5, ssMedian3(i4, i5, i6, i6 + i12, i6 + i13), ssMedian3(i4, i5, i9 - i12, i9, i9 + i12), ssMedian3(i4, i5, i14 - i13, i14 - i12, i14));
    }

    private int ssSubstringPartition(int i4, int i5, int i6, int i7) {
        int[] iArr = this.SA;
        int i8 = i5 - 1;
        while (true) {
            i8++;
            if (i8 < i6 && iArr[iArr[i8] + i4] + i7 >= iArr[iArr[i8] + i4 + 1] + 1) {
                iArr[i8] = iArr[i8] ^ (-1);
            } else {
                do {
                    i6--;
                    if (i8 >= i6) {
                        break;
                    }
                } while (iArr[iArr[i6] + i4] + i7 < iArr[iArr[i6] + i4 + 1] + 1);
                if (i6 <= i8) {
                    break;
                }
                iArr[i6] = iArr[i8];
                iArr[i8] = iArr[i6] ^ (-1);
            }
        }
        if (i5 < i8) {
            iArr[i5] = iArr[i5] ^ (-1);
        }
        return i8;
    }

    private void subStringSort(int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, boolean z3, int i10) {
        int i11;
        int i12;
        int[] iArr2;
        int[] iArr3 = this.SA;
        int i13 = z3 ? i5 + 1 : i5;
        int i14 = i13;
        int i15 = 0;
        while (true) {
            int i16 = i14 + 1024;
            if (i16 >= i6) {
                break;
            }
            ssMultiKeyIntroSort(i4, i14, i16, i9);
            int i17 = i6 - i16;
            if (i17 <= i8) {
                iArr2 = iArr;
                i12 = i7;
                i11 = i8;
            } else {
                i11 = i17;
                i12 = i16;
                iArr2 = iArr3;
            }
            int i18 = i14;
            int i19 = i15;
            int i20 = 1024;
            while ((i19 & 1) != 0) {
                int i21 = i18 - i20;
                ssMerge(i4, i21, i18, i18 + i20, iArr2, i12, i11, i9);
                i20 <<= 1;
                i19 >>>= 1;
                i18 = i21;
                i16 = i16;
            }
            i15++;
            i14 = i16;
        }
        ssMultiKeyIntroSort(i4, i14, i6, i9);
        int i22 = i14;
        int i23 = 1024;
        for (int i24 = i15; i24 != 0; i24 >>= 1) {
            if ((i24 & 1) != 0) {
                int i25 = i22 - i23;
                ssMerge(i4, i25, i22, i6, iArr, i7, i8, i9);
                i22 = i25;
            }
            i23 <<= 1;
        }
        if (z3) {
            int i26 = iArr3[i13 - 1];
            int i27 = 1;
            while (i13 < i6 && (iArr3[i13] < 0 || (i27 = ssCompareLast(i4, i4 + i26, i4 + iArr3[i13], i9, i10)) > 0)) {
                iArr3[i13 - 1] = iArr3[i13];
                i13++;
            }
            if (i27 == 0) {
                iArr3[i13] = iArr3[i13] ^ (-1);
            }
            iArr3[i13 - 1] = i26;
        }
    }

    private static void swapElements(int[] iArr, int i4, int[] iArr2, int i5) {
        int i6 = iArr[i4];
        iArr[i4] = iArr2[i5];
        iArr2[i5] = i6;
    }

    private void trCopy(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int[] iArr = this.SA;
        int i11 = i8 - 1;
        int i12 = i7 - 1;
        while (i6 <= i12) {
            int i13 = iArr[i6] - i10;
            if (i13 < 0) {
                i13 += i5 - i4;
            }
            int i14 = i4 + i13;
            if (iArr[i14] == i11) {
                i12++;
                iArr[i12] = i13;
                iArr[i14] = i12;
            }
            i6++;
        }
        int i15 = i9 - 1;
        int i16 = i12 + 1;
        while (i16 < i8) {
            int i17 = iArr[i15] - i10;
            if (i17 < 0) {
                i17 += i5 - i4;
            }
            int i18 = i4 + i17;
            if (iArr[i18] == i11) {
                i8--;
                iArr[i8] = i17;
                iArr[i18] = i8;
            }
            i15--;
        }
    }

    private void trFixdown(int i4, int i5, int i6, int i7, int i8, int i9) {
        int[] iArr = this.SA;
        int i10 = iArr[i7 + i8];
        int trGetC = trGetC(i4, i5, i6, i10);
        while (true) {
            int i11 = (i8 * 2) + 1;
            if (i11 >= i9) {
                break;
            }
            int i12 = i11 + 1;
            int trGetC2 = trGetC(i4, i5, i6, iArr[i7 + i11]);
            int trGetC3 = trGetC(i4, i5, i6, iArr[i7 + i12]);
            if (trGetC2 < trGetC3) {
                i11 = i12;
                trGetC2 = trGetC3;
            }
            if (trGetC2 <= trGetC) {
                break;
            }
            iArr[i8 + i7] = iArr[i7 + i11];
            i8 = i11;
        }
        iArr[i7 + i8] = i10;
    }

    private int trGetC(int i4, int i5, int i6, int i7) {
        int i8 = i5 + i7;
        return i8 < i6 ? this.SA[i8] : this.SA[i4 + (((i5 - i4) + i7) % (i6 - i4))];
    }

    private void trHeapSort(int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int[] iArr = this.SA;
        int i10 = i8 % 2;
        if (i10 == 0) {
            int i11 = i8 - 1;
            int i12 = (i11 / 2) + i7;
            int i13 = i7 + i11;
            if (trGetC(i4, i5, i6, iArr[i12]) < trGetC(i4, i5, i6, iArr[i13])) {
                swapElements(iArr, i13, iArr, i12);
            }
            i9 = i11;
        } else {
            i9 = i8;
        }
        for (int i14 = (i9 / 2) - 1; i14 >= 0; i14--) {
            trFixdown(i4, i5, i6, i7, i14, i9);
        }
        if (i10 == 0) {
            swapElements(iArr, i7, iArr, i7 + i9);
            trFixdown(i4, i5, i6, i7, 0, i9);
        }
        for (int i15 = i9 - 1; i15 > 0; i15--) {
            int i16 = iArr[i7];
            int i17 = i7 + i15;
            iArr[i7] = iArr[i17];
            trFixdown(i4, i5, i6, i7, 0, i15);
            iArr[i17] = i16;
        }
    }

    private void trInsertionSort(int i4, int i5, int i6, int i7, int i8) {
        int trGetC;
        int[] iArr = this.SA;
        for (int i9 = i7 + 1; i9 < i8; i9++) {
            int i10 = iArr[i9];
            int i11 = i9 - 1;
            do {
                trGetC = trGetC(i4, i5, i6, i10) - trGetC(i4, i5, i6, iArr[i11]);
                if (trGetC >= 0) {
                    break;
                }
                do {
                    iArr[i11 + 1] = iArr[i11];
                    i11--;
                    if (i7 <= i11) {
                    }
                } while (iArr[i11] < 0);
                continue;
            } while (i11 >= i7);
            if (trGetC == 0) {
                iArr[i11] = iArr[i11] ^ (-1);
            }
            iArr[i11 + 1] = i10;
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

    private static int trLog(int i4) {
        return ((-65536) & i4) != 0 ? ((-16777216) & i4) != 0 ? LOG_2_TABLE[(i4 >> 24) & 255] + 24 : LOG_2_TABLE[(i4 >> 16) & MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME] : (65280 & i4) != 0 ? LOG_2_TABLE[(i4 >> 8) & 255] + 8 : LOG_2_TABLE[i4 & 255];
    }

    private int trMedian3(int i4, int i5, int i6, int i7, int i8, int i9) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i4, i5, i6, iArr[i7]);
        int trGetC2 = trGetC(i4, i5, i6, iArr[i8]);
        int trGetC3 = trGetC(i4, i5, i6, iArr[i9]);
        if (trGetC <= trGetC2) {
            i8 = i7;
            i7 = i8;
            trGetC2 = trGetC;
            trGetC = trGetC2;
        }
        return trGetC > trGetC3 ? trGetC2 > trGetC3 ? i8 : i9 : i7;
    }

    private int trMedian5(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i4, i5, i6, iArr[i7]);
        int trGetC2 = trGetC(i4, i5, i6, iArr[i8]);
        int trGetC3 = trGetC(i4, i5, i6, iArr[i9]);
        int trGetC4 = trGetC(i4, i5, i6, iArr[i10]);
        int trGetC5 = trGetC(i4, i5, i6, iArr[i11]);
        if (trGetC2 > trGetC3) {
            i9 = i8;
            i8 = i9;
            trGetC3 = trGetC2;
            trGetC2 = trGetC3;
        }
        if (trGetC4 > trGetC5) {
            trGetC4 = trGetC5;
            trGetC5 = trGetC4;
        } else {
            i11 = i10;
            i10 = i11;
        }
        if (trGetC2 > trGetC4) {
            int i12 = trGetC3;
            trGetC3 = trGetC5;
            trGetC5 = i12;
            int i13 = i10;
            i10 = i9;
            i9 = i13;
        } else {
            i8 = i11;
            trGetC2 = trGetC4;
        }
        if (trGetC > trGetC3) {
            int i14 = i9;
            i9 = i7;
            i7 = i14;
            int i15 = trGetC3;
            trGetC3 = trGetC;
            trGetC = i15;
        }
        if (trGetC > trGetC2) {
            i8 = i7;
            trGetC2 = trGetC;
        } else {
            i10 = i9;
            trGetC5 = trGetC3;
        }
        return trGetC5 > trGetC2 ? i8 : i10;
    }

    private PartitionResult trPartition(int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int trGetC;
        int trGetC2;
        int trGetC3;
        int[] iArr = this.SA;
        int i12 = 0;
        int i13 = i7;
        while (i13 < i8) {
            i12 = trGetC(i4, i5, i6, iArr[i13]);
            if (i12 != i9) {
                break;
            }
            i13++;
        }
        if (i13 < i8 && i12 < i9) {
            i10 = i13;
            while (true) {
                i13++;
                if (i13 >= i8 || (i12 = trGetC(i4, i5, i6, iArr[i13])) > i9) {
                    break;
                } else if (i12 == i9) {
                    swapElements(iArr, i13, iArr, i10);
                    i10++;
                }
            }
        } else {
            i10 = i13;
        }
        int i14 = i8 - 1;
        while (i13 < i14) {
            i12 = trGetC(i4, i5, i6, iArr[i14]);
            if (i12 != i9) {
                break;
            }
            i14--;
        }
        if (i13 < i14 && i12 > i9) {
            i11 = i14;
            while (true) {
                i14--;
                if (i13 >= i14 || (trGetC3 = trGetC(i4, i5, i6, iArr[i14])) < i9) {
                    break;
                } else if (trGetC3 == i9) {
                    swapElements(iArr, i14, iArr, i11);
                    i11--;
                }
            }
        } else {
            i11 = i14;
        }
        while (i13 < i14) {
            swapElements(iArr, i13, iArr, i14);
            while (true) {
                i13++;
                if (i13 >= i14 || (trGetC2 = trGetC(i4, i5, i6, iArr[i13])) > i9) {
                    break;
                } else if (trGetC2 == i9) {
                    swapElements(iArr, i13, iArr, i10);
                    i10++;
                }
            }
            while (true) {
                i14--;
                if (i13 < i14 && (trGetC = trGetC(i4, i5, i6, iArr[i14])) >= i9) {
                    if (trGetC == i9) {
                        swapElements(iArr, i14, iArr, i11);
                        i11--;
                    }
                }
            }
        }
        if (i10 <= i11) {
            int i15 = i13 - 1;
            int i16 = i10 - i7;
            int i17 = i13 - i10;
            if (i16 > i17) {
                i16 = i17;
            }
            int i18 = i13 - i16;
            int i19 = i7;
            while (i16 > 0) {
                swapElements(iArr, i19, iArr, i18);
                i16--;
                i19++;
                i18++;
            }
            int i20 = i11 - i15;
            int i21 = (i8 - i11) - 1;
            if (i20 <= i21) {
                i21 = i20;
            }
            int i22 = i8 - i21;
            while (i21 > 0) {
                swapElements(iArr, i13, iArr, i22);
                i21--;
                i13++;
                i22++;
            }
            i7 += i17;
            i8 -= i20;
        }
        return new PartitionResult(i7, i8);
    }

    private int trPivot(int i4, int i5, int i6, int i7, int i8) {
        int i9 = i8 - i7;
        int i10 = i7 + (i9 / 2);
        if (i9 <= 512) {
            if (i9 <= 32) {
                return trMedian3(i4, i5, i6, i7, i10, i8 - 1);
            }
            int i11 = i9 >> 2;
            int i12 = i8 - 1;
            return trMedian5(i4, i5, i6, i7, i7 + i11, i10, i12 - i11, i12);
        }
        int i13 = i9 >> 3;
        int i14 = i13 << 1;
        int i15 = i8 - 1;
        return trMedian3(i4, i5, i6, trMedian3(i4, i5, i6, i7, i7 + i13, i7 + i14), trMedian3(i4, i5, i6, i10 - i13, i10, i10 + i13), trMedian3(i4, i5, i6, i15 - i14, i15 - i13, i15));
    }

    private void trSort(int i4, int i5, int i6) {
        int[] iArr = this.SA;
        if ((-i5) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i5, ((trLog(i5) * 2) / 3) + 1);
            int i7 = 0;
            do {
                int i8 = iArr[i7];
                if (i8 < 0) {
                    i7 -= i8;
                    continue;
                } else {
                    int i9 = iArr[i4 + i8] + 1;
                    if (1 < i9 - i7) {
                        trIntroSort(i4, i4 + i6, i4 + i5, i7, i9, tRBudget, i5);
                        if (tRBudget.chance == 0) {
                            if (i7 > 0) {
                                iArr[0] = -i7;
                            }
                            lsSort(i4, i5, i6);
                            return;
                        }
                    }
                    i7 = i9;
                    continue;
                }
            } while (i7 < i5);
        }
    }

    public int bwt() {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i4 = this.f54777n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i4 == 0) {
            return 0;
        }
        if (i4 == 1) {
            iArr[0] = bArr[0];
            return 0;
        } else if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        } else {
            return 0;
        }
    }
}

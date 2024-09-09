package com.hw.videoprocessor.jssrc;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: SplitRadixFft.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f37603a = 512;

    private void A(int i4, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = i4 >> 1;
        int i8 = i5 / i4;
        int i9 = 0;
        for (int i10 = 1; i10 < i7; i10++) {
            int i11 = i4 - i10;
            i9 += i8;
            int i12 = i6 + i9;
            int i13 = (i6 + i5) - i9;
            double d4 = dArr2[i12] - dArr2[i13];
            double d5 = dArr2[i12] + dArr2[i13];
            double d6 = (dArr[i10] * d5) - (dArr[i11] * d4);
            dArr[i10] = (d4 * dArr[i10]) + (d5 * dArr[i11]);
            dArr[i11] = d6;
        }
        dArr[i7] = dArr[i7] * dArr2[i6 + 0];
    }

    private void F(int i4, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = i4 >> 1;
        int i8 = i5 / i4;
        int i9 = 0;
        for (int i10 = 1; i10 < i7; i10++) {
            int i11 = i4 - i10;
            i9 += i8;
            int i12 = i6 + i9;
            int i13 = (i6 + i5) - i9;
            double d4 = dArr2[i12] - dArr2[i13];
            double d5 = dArr2[i12] + dArr2[i13];
            double d6 = (dArr[i11] * d5) - (dArr[i10] * d4);
            dArr[i11] = (d4 * dArr[i11]) + (d5 * dArr[i10]);
            dArr[i10] = d6;
        }
        dArr[i7] = dArr[i7] * dArr2[i6 + 0];
    }

    private void G(int i4, int[] iArr, double[] dArr, int i5) {
        iArr[1] = i4;
        if (i4 > 1) {
            int i6 = i4 >> 1;
            double d4 = i6;
            Double.isNaN(d4);
            double d5 = 0.7853981633974483d / d4;
            int i7 = i5 + 0;
            Double.isNaN(d4);
            dArr[i7] = Math.cos(d4 * d5);
            dArr[i5 + i6] = dArr[i7] * 0.5d;
            for (int i8 = 1; i8 < i6; i8++) {
                double d6 = i8;
                Double.isNaN(d6);
                double d7 = d6 * d5;
                dArr[i5 + i8] = Math.cos(d7) * 0.5d;
                dArr[(i5 + i4) - i8] = Math.sin(d7) * 0.5d;
            }
        }
    }

    private void H(int i4, int[] iArr, double[] dArr) {
        int i5 = 0;
        iArr[0] = i4;
        iArr[1] = 1;
        if (i4 > 2) {
            int i6 = i4 >> 1;
            double d4 = i6;
            Double.isNaN(d4);
            double d5 = 0.7853981633974483d / d4;
            Double.isNaN(d4);
            double cos = Math.cos(d4 * d5);
            dArr[0] = 1.0d;
            dArr[1] = cos;
            if (i6 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d5);
                dArr[3] = 0.5d / Math.cos(6.0d * d5);
            }
            for (int i7 = 4; i7 < i6; i7 += 4) {
                double d6 = i7;
                Double.isNaN(d6);
                double d7 = d5 * d6;
                dArr[i7] = Math.cos(d7);
                dArr[i7 + 1] = Math.sin(d7);
                Double.isNaN(d6);
                double d8 = 3.0d * d5 * d6;
                dArr[i7 + 2] = Math.cos(d8);
                dArr[i7 + 3] = Math.sin(d8);
            }
            while (i6 > 2) {
                int i8 = i5 + i6;
                i6 >>= 1;
                dArr[i8] = 1.0d;
                dArr[i8 + 1] = cos;
                if (i6 >= 4) {
                    double d9 = dArr[i5 + 4];
                    double d10 = dArr[i5 + 6];
                    dArr[i8 + 2] = 0.5d / d9;
                    dArr[i8 + 3] = 0.5d / d10;
                }
                for (int i9 = 4; i9 < i6; i9 += 4) {
                    int i10 = (i9 * 2) + i5;
                    double d11 = dArr[i10];
                    double d12 = dArr[i10 + 1];
                    double d13 = dArr[i10 + 2];
                    double d14 = dArr[i10 + 3];
                    int i11 = i8 + i9;
                    dArr[i11] = d11;
                    dArr[i11 + 1] = d12;
                    dArr[i11 + 2] = d13;
                    dArr[i11 + 3] = d14;
                }
                i5 = i8;
            }
        }
    }

    private void J(int i4, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = i4 >> 1;
        int i8 = (i5 * 2) / i7;
        int i9 = 0;
        for (int i10 = 2; i10 < i7; i10 += 2) {
            int i11 = i4 - i10;
            i9 += i8;
            double d4 = 0.5d - dArr2[(i6 + i5) - i9];
            double d5 = dArr2[i6 + i9];
            double d6 = dArr[i10] - dArr[i11];
            int i12 = i10 + 1;
            int i13 = i11 + 1;
            double d7 = dArr[i12] + dArr[i13];
            double d8 = (d4 * d6) + (d5 * d7);
            double d9 = (d4 * d7) - (d5 * d6);
            dArr[i10] = dArr[i10] - d8;
            dArr[i12] = dArr[i12] - d9;
            dArr[i11] = dArr[i11] + d8;
            dArr[i13] = dArr[i13] - d9;
        }
    }

    private void K(int i4, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = i4 >> 1;
        int i8 = (i5 * 2) / i7;
        int i9 = 0;
        for (int i10 = 2; i10 < i7; i10 += 2) {
            int i11 = i4 - i10;
            i9 += i8;
            double d4 = 0.5d - dArr2[(i6 + i5) - i9];
            double d5 = dArr2[i6 + i9];
            double d6 = dArr[i10] - dArr[i11];
            int i12 = i10 + 1;
            int i13 = i11 + 1;
            double d7 = dArr[i12] + dArr[i13];
            double d8 = (d4 * d6) - (d5 * d7);
            double d9 = (d4 * d7) + (d5 * d6);
            dArr[i10] = dArr[i10] - d8;
            dArr[i12] = dArr[i12] - d9;
            dArr[i11] = dArr[i11] + d8;
            dArr[i13] = dArr[i13] - d9;
        }
    }

    private final void a(int i4, int[] iArr, int i5, double[] dArr) {
        int i6;
        iArr[i5 + 0] = 0;
        int i7 = i4;
        int i8 = 1;
        while (true) {
            i6 = i8 << 3;
            if (i6 >= i7) {
                break;
            }
            i7 >>= 1;
            for (int i9 = 0; i9 < i8; i9++) {
                iArr[i5 + i8 + i9] = iArr[i5 + i9] + i7;
            }
            i8 <<= 1;
        }
        int i10 = i8 * 2;
        if (i6 != i7) {
            for (int i11 = 1; i11 < i8; i11++) {
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = (i12 * 2) + iArr[i5 + i11];
                    int i14 = (i11 * 2) + iArr[i5 + i12];
                    double d4 = dArr[i13];
                    int i15 = i13 + 1;
                    double d5 = dArr[i15];
                    double d6 = dArr[i14];
                    int i16 = i14 + 1;
                    double d7 = dArr[i16];
                    dArr[i13] = d6;
                    dArr[i15] = d7;
                    dArr[i14] = d4;
                    dArr[i16] = d5;
                    int i17 = i13 + i10;
                    int i18 = i14 + i10;
                    double d8 = dArr[i17];
                    int i19 = i17 + 1;
                    double d9 = dArr[i19];
                    double d10 = dArr[i18];
                    int i20 = i18 + 1;
                    double d11 = dArr[i20];
                    dArr[i17] = d10;
                    dArr[i19] = d11;
                    dArr[i18] = d8;
                    dArr[i20] = d9;
                }
            }
            return;
        }
        for (int i21 = 0; i21 < i8; i21++) {
            for (int i22 = 0; i22 < i21; i22++) {
                int i23 = (i22 * 2) + iArr[i5 + i21];
                int i24 = (i21 * 2) + iArr[i5 + i22];
                double d12 = dArr[i23];
                int i25 = i23 + 1;
                double d13 = dArr[i25];
                double d14 = dArr[i24];
                int i26 = i24 + 1;
                double d15 = dArr[i26];
                dArr[i23] = d14;
                dArr[i25] = d15;
                dArr[i24] = d12;
                dArr[i26] = d13;
                int i27 = i23 + i10;
                int i28 = i10 * 2;
                int i29 = i24 + i28;
                double d16 = dArr[i27];
                int i30 = i27 + 1;
                double d17 = dArr[i30];
                double d18 = dArr[i29];
                int i31 = i29 + 1;
                double d19 = dArr[i31];
                dArr[i27] = d18;
                dArr[i30] = d19;
                dArr[i29] = d16;
                dArr[i31] = d17;
                int i32 = i27 + i10;
                int i33 = i29 - i10;
                double d20 = dArr[i32];
                int i34 = i32 + 1;
                double d21 = dArr[i34];
                double d22 = dArr[i33];
                int i35 = i33 + 1;
                double d23 = dArr[i35];
                dArr[i32] = d22;
                dArr[i34] = d23;
                dArr[i33] = d20;
                dArr[i35] = d21;
                int i36 = i32 + i10;
                int i37 = i33 + i28;
                double d24 = dArr[i36];
                int i38 = i36 + 1;
                double d25 = dArr[i38];
                double d26 = dArr[i37];
                int i39 = i37 + 1;
                double d27 = dArr[i39];
                dArr[i36] = d26;
                dArr[i38] = d27;
                dArr[i37] = d24;
                dArr[i39] = d25;
            }
            int i40 = (i21 * 2) + i10 + iArr[i5 + i21];
            int i41 = i40 + i10;
            double d28 = dArr[i40];
            int i42 = i40 + 1;
            double d29 = dArr[i42];
            double d30 = dArr[i41];
            int i43 = i41 + 1;
            double d31 = dArr[i43];
            dArr[i40] = d30;
            dArr[i42] = d31;
            dArr[i41] = d28;
            dArr[i43] = d29;
        }
    }

    private void b(double[] dArr) {
        double d4 = dArr[2];
        double d5 = dArr[3];
        double d6 = dArr[6];
        double d7 = dArr[7];
        double d8 = dArr[8];
        double d9 = dArr[9];
        double d10 = dArr[12];
        double d11 = dArr[13];
        dArr[2] = d8;
        dArr[3] = d9;
        dArr[6] = d10;
        dArr[7] = d11;
        dArr[8] = d4;
        dArr[9] = d5;
        dArr[12] = d6;
        dArr[13] = d7;
    }

    private void c(double[] dArr) {
        double d4 = dArr[2];
        double d5 = dArr[3];
        double d6 = dArr[4];
        double d7 = dArr[5];
        double d8 = dArr[6];
        double d9 = dArr[7];
        double d10 = dArr[8];
        double d11 = dArr[9];
        double d12 = dArr[10];
        double d13 = dArr[11];
        double d14 = dArr[12];
        double d15 = dArr[13];
        double d16 = dArr[14];
        double d17 = dArr[15];
        dArr[2] = d16;
        dArr[3] = d17;
        dArr[4] = d8;
        dArr[5] = d9;
        dArr[6] = d12;
        dArr[7] = d13;
        dArr[8] = d4;
        dArr[9] = d5;
        dArr[10] = d14;
        dArr[11] = d15;
        dArr[12] = d6;
        dArr[13] = d7;
        dArr[14] = d10;
        dArr[15] = d11;
    }

    private void d(double[] dArr) {
        double d4 = dArr[2];
        double d5 = dArr[3];
        double d6 = dArr[4];
        double d7 = dArr[5];
        double d8 = dArr[6];
        double d9 = dArr[7];
        double d10 = dArr[8];
        double d11 = dArr[9];
        double d12 = dArr[10];
        double d13 = dArr[11];
        double d14 = dArr[14];
        double d15 = dArr[15];
        double d16 = dArr[16];
        double d17 = dArr[17];
        double d18 = dArr[20];
        double d19 = dArr[21];
        double d20 = dArr[22];
        double d21 = dArr[23];
        double d22 = dArr[24];
        double d23 = dArr[25];
        double d24 = dArr[26];
        double d25 = dArr[27];
        double d26 = dArr[28];
        double d27 = dArr[29];
        dArr[2] = d16;
        dArr[3] = d17;
        dArr[4] = d10;
        dArr[5] = d11;
        dArr[6] = d22;
        dArr[7] = d23;
        dArr[8] = d6;
        dArr[9] = d7;
        dArr[10] = d18;
        dArr[11] = d19;
        dArr[14] = d26;
        dArr[15] = d27;
        dArr[16] = d4;
        dArr[17] = d5;
        dArr[20] = d12;
        dArr[21] = d13;
        dArr[22] = d24;
        dArr[23] = d25;
        dArr[24] = d8;
        dArr[25] = d9;
        dArr[26] = d20;
        dArr[27] = d21;
        dArr[28] = d14;
        dArr[29] = d15;
    }

    private void e(double[] dArr) {
        double d4 = dArr[2];
        double d5 = dArr[3];
        double d6 = dArr[4];
        double d7 = dArr[5];
        double d8 = dArr[6];
        double d9 = dArr[7];
        double d10 = dArr[8];
        double d11 = dArr[9];
        double d12 = dArr[10];
        double d13 = dArr[11];
        double d14 = dArr[12];
        double d15 = dArr[13];
        double d16 = dArr[14];
        double d17 = dArr[15];
        double d18 = dArr[16];
        double d19 = dArr[17];
        double d20 = dArr[18];
        double d21 = dArr[19];
        double d22 = dArr[20];
        double d23 = dArr[21];
        double d24 = dArr[22];
        double d25 = dArr[23];
        double d26 = dArr[24];
        double d27 = dArr[25];
        double d28 = dArr[26];
        double d29 = dArr[27];
        double d30 = dArr[28];
        double d31 = dArr[29];
        double d32 = dArr[30];
        double d33 = dArr[31];
        dArr[2] = d32;
        dArr[3] = d33;
        dArr[4] = d16;
        dArr[5] = d17;
        dArr[6] = d24;
        dArr[7] = d25;
        dArr[8] = d8;
        dArr[9] = d9;
        dArr[10] = d28;
        dArr[11] = d29;
        dArr[12] = d12;
        dArr[13] = d13;
        dArr[14] = d20;
        dArr[15] = d21;
        dArr[16] = d4;
        dArr[17] = d5;
        dArr[18] = d30;
        dArr[19] = d31;
        dArr[20] = d14;
        dArr[21] = d15;
        dArr[22] = d22;
        dArr[23] = d23;
        dArr[24] = d6;
        dArr[25] = d7;
        dArr[26] = d26;
        dArr[27] = d27;
        dArr[28] = d10;
        dArr[29] = d11;
        dArr[30] = d18;
        dArr[31] = d19;
    }

    private final void f(int i4, int[] iArr, int i5, double[] dArr) {
        int i6;
        iArr[i5 + 0] = 0;
        int i7 = i4;
        int i8 = 1;
        while (true) {
            i6 = i8 << 3;
            if (i6 >= i7) {
                break;
            }
            i7 >>= 1;
            for (int i9 = 0; i9 < i8; i9++) {
                iArr[i5 + i8 + i9] = iArr[i5 + i9] + i7;
            }
            i8 <<= 1;
        }
        int i10 = i8 * 2;
        if (i6 != i7) {
            int i11 = i8;
            dArr[1] = -dArr[1];
            int i12 = i10 + 1;
            dArr[i12] = -dArr[i12];
            for (int i13 = 1; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = (i14 * 2) + iArr[i5 + i13];
                    int i16 = (i13 * 2) + iArr[i5 + i14];
                    double d4 = dArr[i15];
                    int i17 = i15 + 1;
                    int i18 = i16 + 1;
                    dArr[i15] = dArr[i16];
                    dArr[i17] = -dArr[i18];
                    dArr[i16] = d4;
                    dArr[i18] = -dArr[i17];
                    int i19 = i15 + i10;
                    int i20 = i16 + i10;
                    double d5 = dArr[i19];
                    int i21 = i19 + 1;
                    int i22 = i20 + 1;
                    dArr[i19] = dArr[i20];
                    dArr[i21] = -dArr[i22];
                    dArr[i20] = d5;
                    dArr[i22] = -dArr[i21];
                }
                int i23 = (i13 * 2) + iArr[i5 + i13];
                int i24 = i23 + 1;
                dArr[i24] = -dArr[i24];
                int i25 = i23 + i10 + 1;
                dArr[i25] = -dArr[i25];
            }
            return;
        }
        int i26 = 0;
        while (i26 < i8) {
            int i27 = 0;
            while (i27 < i26) {
                int i28 = (i27 * 2) + iArr[i5 + i26];
                int i29 = (i26 * 2) + iArr[i5 + i27];
                double d6 = dArr[i28];
                int i30 = i28 + 1;
                int i31 = i29 + 1;
                dArr[i28] = dArr[i29];
                dArr[i30] = -dArr[i31];
                dArr[i29] = d6;
                dArr[i31] = -dArr[i30];
                int i32 = i28 + i10;
                int i33 = i10 * 2;
                int i34 = i29 + i33;
                double d7 = dArr[i32];
                int i35 = i32 + 1;
                int i36 = i34 + 1;
                int i37 = i26;
                int i38 = i8;
                dArr[i32] = dArr[i34];
                dArr[i35] = -dArr[i36];
                dArr[i34] = d7;
                dArr[i36] = -dArr[i35];
                int i39 = i32 + i10;
                int i40 = i34 - i10;
                double d8 = dArr[i39];
                int i41 = i39 + 1;
                int i42 = i40 + 1;
                dArr[i39] = dArr[i40];
                dArr[i41] = -dArr[i42];
                dArr[i40] = d8;
                dArr[i42] = -dArr[i41];
                int i43 = i39 + i10;
                int i44 = i40 + i33;
                double d9 = dArr[i43];
                int i45 = i43 + 1;
                int i46 = i44 + 1;
                dArr[i43] = dArr[i44];
                dArr[i45] = -dArr[i46];
                dArr[i44] = d9;
                dArr[i46] = -dArr[i45];
                i27++;
                i8 = i38;
                i26 = i37;
            }
            int i47 = i26;
            int i48 = i8;
            int i49 = (i47 * 2) + iArr[i5 + i47];
            int i50 = i49 + 1;
            dArr[i50] = -dArr[i50];
            int i51 = i49 + i10;
            int i52 = i51 + i10;
            double d10 = dArr[i51];
            int i53 = i51 + 1;
            int i54 = i52 + 1;
            dArr[i51] = dArr[i52];
            dArr[i53] = -dArr[i54];
            dArr[i52] = d10;
            dArr[i54] = -dArr[i53];
            int i55 = i52 + i10 + 1;
            dArr[i55] = -dArr[i55];
            i26 = i47 + 1;
            i8 = i48;
        }
    }

    private void h(double[] dArr) {
        double d4 = dArr[0] + dArr[4];
        double d5 = dArr[1] + dArr[5];
        double d6 = dArr[0] - dArr[4];
        double d7 = dArr[1] - dArr[5];
        double d8 = dArr[2] + dArr[6];
        double d9 = dArr[3] + dArr[7];
        double d10 = dArr[2] - dArr[6];
        double d11 = dArr[3] - dArr[7];
        dArr[0] = d4 + d8;
        dArr[1] = d5 + d9;
        dArr[4] = d4 - d8;
        dArr[5] = d5 - d9;
        dArr[2] = d6 + d11;
        dArr[3] = d7 - d10;
        dArr[6] = d6 - d11;
        dArr[7] = d7 + d10;
    }

    private final void i(int i4, double[] dArr, double[] dArr2, int i5) {
        int i6 = i4 >> 3;
        int i7 = i6 * 2;
        int i8 = i7 + i7;
        int i9 = i8 + i7;
        int i10 = 0;
        double d4 = dArr[0] + dArr[i8];
        int i11 = i8 + 1;
        double d5 = (-dArr[1]) - dArr[i11];
        double d6 = dArr[0] - dArr[i8];
        double d7 = (-dArr[1]) + dArr[i11];
        double d8 = dArr[i7] + dArr[i9];
        int i12 = i7 + 1;
        int i13 = i9 + 1;
        double d9 = dArr[i12] + dArr[i13];
        double d10 = dArr[i7] - dArr[i9];
        double d11 = dArr[i12] - dArr[i13];
        dArr[0] = d4 + d8;
        dArr[1] = d5 - d9;
        dArr[i7] = d4 - d8;
        dArr[i12] = d5 + d9;
        dArr[i8] = d6 + d11;
        dArr[i11] = d7 + d10;
        dArr[i9] = d6 - d11;
        dArr[i13] = d7 - d10;
        double d12 = dArr2[i5 + 1];
        double d13 = dArr2[i5 + 2];
        double d14 = dArr2[i5 + 3];
        double d15 = 0.0d;
        double d16 = 1.0d;
        double d17 = 1.0d;
        int i14 = 2;
        double d18 = 0.0d;
        while (true) {
            int i15 = i6 - 2;
            if (i14 < i15) {
                int i16 = i10 + 4;
                int i17 = i5 + i16;
                double d19 = (d16 + dArr2[i17]) * d13;
                int i18 = i17 + 1;
                double d20 = (d15 + dArr2[i18]) * d13;
                int i19 = i17 + 2;
                double d21 = (d17 + dArr2[i19]) * d14;
                int i20 = i17 + 3;
                double d22 = (d18 - dArr2[i20]) * d14;
                double d23 = dArr2[i17];
                double d24 = dArr2[i18];
                double d25 = dArr2[i19];
                double d26 = -dArr2[i20];
                int i21 = i14 + i7;
                int i22 = i21 + i7;
                int i23 = i22 + i7;
                double d27 = dArr[i14] + dArr[i22];
                int i24 = i14 + 1;
                double d28 = d14;
                int i25 = i22 + 1;
                double d29 = (-dArr[i24]) - dArr[i25];
                double d30 = dArr[i14] - dArr[i22];
                double d31 = d13;
                double d32 = (-dArr[i24]) + dArr[i25];
                int i26 = i14 + 2;
                int i27 = i22 + 2;
                double d33 = dArr[i26] + dArr[i27];
                int i28 = i14 + 3;
                int i29 = i6;
                int i30 = i7;
                int i31 = i22 + 3;
                double d34 = (-dArr[i28]) - dArr[i31];
                double d35 = dArr[i26] - dArr[i27];
                double d36 = (-dArr[i28]) + dArr[i31];
                double d37 = dArr[i21] + dArr[i23];
                int i32 = i21 + 1;
                int i33 = i23 + 1;
                double d38 = dArr[i32] + dArr[i33];
                double d39 = dArr[i21] - dArr[i23];
                double d40 = dArr[i32] - dArr[i33];
                int i34 = i21 + 2;
                int i35 = i23 + 2;
                double d41 = dArr[i34] + dArr[i35];
                int i36 = i21 + 3;
                int i37 = i23 + 3;
                double d42 = dArr[i36] + dArr[i37];
                double d43 = dArr[i34] - dArr[i35];
                double d44 = dArr[i36] - dArr[i37];
                dArr[i14] = d27 + d37;
                dArr[i24] = d29 - d38;
                dArr[i26] = d33 + d41;
                dArr[i28] = d34 - d42;
                dArr[i21] = d27 - d37;
                dArr[i32] = d29 + d38;
                dArr[i34] = d33 - d41;
                dArr[i36] = d34 + d42;
                double d45 = d30 + d40;
                double d46 = d32 + d39;
                dArr[i22] = (d19 * d45) - (d20 * d46);
                dArr[i25] = (d46 * d19) + (d45 * d20);
                double d47 = d35 + d44;
                double d48 = d36 + d43;
                dArr[i27] = (d23 * d47) - (d24 * d48);
                dArr[i31] = (d48 * d23) + (d47 * d24);
                double d49 = d30 - d40;
                double d50 = d32 - d39;
                dArr[i23] = (d21 * d49) + (d22 * d50);
                dArr[i33] = (d50 * d21) - (d49 * d22);
                double d51 = d35 - d44;
                double d52 = d36 - d43;
                dArr[i35] = (d25 * d51) + (d26 * d52);
                dArr[i37] = (d52 * d25) - (d26 * d51);
                int i38 = i30 - i14;
                int i39 = i38 + i30;
                int i40 = i39 + i30;
                int i41 = i40 + i30;
                double d53 = dArr[i38] + dArr[i40];
                int i42 = i38 + 1;
                int i43 = i40 + 1;
                double d54 = (-dArr[i42]) - dArr[i43];
                double d55 = dArr[i38] - dArr[i40];
                double d56 = (-dArr[i42]) + dArr[i43];
                int i44 = i38 - 2;
                int i45 = i40 - 2;
                double d57 = dArr[i44] + dArr[i45];
                int i46 = i38 - 1;
                int i47 = i40 - 1;
                double d58 = (-dArr[i46]) - dArr[i47];
                double d59 = dArr[i44] - dArr[i45];
                int i48 = i14;
                double d60 = (-dArr[i46]) + dArr[i47];
                double d61 = dArr[i39] + dArr[i41];
                int i49 = i39 + 1;
                int i50 = i41 + 1;
                double d62 = dArr[i49] + dArr[i50];
                double d63 = dArr[i39] - dArr[i41];
                double d64 = dArr[i49] - dArr[i50];
                int i51 = i39 - 2;
                int i52 = i41 - 2;
                double d65 = dArr[i51] + dArr[i52];
                int i53 = i39 - 1;
                int i54 = i41 - 1;
                double d66 = dArr[i53] + dArr[i54];
                double d67 = dArr[i51] - dArr[i52];
                double d68 = dArr[i53] - dArr[i54];
                dArr[i38] = d53 + d61;
                dArr[i42] = d54 - d62;
                dArr[i44] = d57 + d65;
                dArr[i46] = d58 - d66;
                dArr[i39] = d53 - d61;
                dArr[i49] = d54 + d62;
                dArr[i51] = d57 - d65;
                dArr[i53] = d58 + d66;
                double d69 = d55 + d64;
                double d70 = d56 + d63;
                dArr[i40] = (d20 * d69) - (d19 * d70);
                dArr[i43] = (d70 * d20) + (d69 * d19);
                double d71 = d59 + d68;
                double d72 = d60 + d67;
                dArr[i45] = (d24 * d71) - (d23 * d72);
                dArr[i47] = (d72 * d24) + (d71 * d23);
                double d73 = d55 - d64;
                double d74 = d56 - d63;
                dArr[i41] = (d22 * d73) + (d21 * d74);
                dArr[i50] = (d22 * d74) - (d21 * d73);
                double d75 = d59 - d68;
                double d76 = d60 - d67;
                dArr[i52] = (d26 * d75) + (d25 * d76);
                dArr[i54] = (d26 * d76) - (d75 * d25);
                i14 = i48 + 4;
                i10 = i16;
                d17 = d25;
                d16 = d23;
                d15 = d24;
                d14 = d28;
                d13 = d31;
                i6 = i29;
                i7 = i30;
                d18 = d26;
            } else {
                int i55 = i6;
                int i56 = i7;
                double d77 = d13;
                double d78 = d14;
                double d79 = d77 * (d16 + d12);
                double d80 = d77 * (d15 + d12);
                double d81 = d78 * (d17 - d12);
                double d82 = d78 * (d18 - d12);
                int i57 = i55 + i56;
                int i58 = i57 + i56;
                int i59 = i58 + i56;
                int i60 = i58 - 2;
                double d83 = dArr[i15] + dArr[i60];
                int i61 = i55 - 1;
                int i62 = i58 - 1;
                double d84 = (-dArr[i61]) - dArr[i62];
                double d85 = dArr[i15] - dArr[i60];
                double d86 = (-dArr[i61]) + dArr[i62];
                int i63 = i57 - 2;
                int i64 = i59 - 2;
                double d87 = dArr[i63] + dArr[i64];
                int i65 = i57 - 1;
                int i66 = i59 - 1;
                double d88 = dArr[i65] + dArr[i66];
                double d89 = dArr[i63] - dArr[i64];
                double d90 = dArr[i65] - dArr[i66];
                dArr[i15] = d83 + d87;
                dArr[i61] = d84 - d88;
                dArr[i63] = d83 - d87;
                dArr[i65] = d84 + d88;
                double d91 = d85 + d90;
                double d92 = d86 + d89;
                dArr[i60] = (d79 * d91) - (d80 * d92);
                dArr[i62] = (d92 * d79) + (d91 * d80);
                double d93 = d85 - d90;
                double d94 = d86 - d89;
                dArr[i64] = (d81 * d93) + (d82 * d94);
                dArr[i66] = (d94 * d81) - (d82 * d93);
                double d95 = dArr[i55] + dArr[i58];
                int i67 = i55 + 1;
                int i68 = i58 + 1;
                double d96 = (-dArr[i67]) - dArr[i68];
                double d97 = dArr[i55] - dArr[i58];
                double d98 = (-dArr[i67]) + dArr[i68];
                double d99 = dArr[i57] + dArr[i59];
                int i69 = i57 + 1;
                int i70 = i59 + 1;
                double d100 = dArr[i69] + dArr[i70];
                double d101 = dArr[i57] - dArr[i59];
                double d102 = dArr[i69] - dArr[i70];
                dArr[i55] = d95 + d99;
                dArr[i67] = d96 - d100;
                dArr[i57] = d95 - d99;
                dArr[i69] = d96 + d100;
                double d103 = d97 + d102;
                double d104 = d98 + d101;
                dArr[i58] = (d103 - d104) * d12;
                dArr[i68] = d12 * (d104 + d103);
                double d105 = d97 - d102;
                double d106 = d98 - d101;
                double d107 = -d12;
                dArr[i59] = (d105 + d106) * d107;
                dArr[i70] = d107 * (d106 - d105);
                int i71 = i55 + 2;
                int i72 = i58 + 2;
                double d108 = dArr[i71] + dArr[i72];
                int i73 = i55 + 3;
                int i74 = i58 + 3;
                double d109 = (-dArr[i73]) - dArr[i74];
                double d110 = dArr[i71] - dArr[i72];
                double d111 = (-dArr[i73]) + dArr[i74];
                int i75 = i57 + 2;
                int i76 = i59 + 2;
                double d112 = dArr[i75] + dArr[i76];
                int i77 = i57 + 3;
                int i78 = i59 + 3;
                double d113 = dArr[i77] + dArr[i78];
                double d114 = dArr[i75] - dArr[i76];
                double d115 = dArr[i77] - dArr[i78];
                dArr[i71] = d108 + d112;
                dArr[i73] = d109 - d113;
                dArr[i75] = d108 - d112;
                dArr[i77] = d109 + d113;
                double d116 = d110 + d115;
                double d117 = d111 + d114;
                dArr[i72] = (d80 * d116) - (d79 * d117);
                dArr[i74] = (d80 * d117) + (d116 * d79);
                double d118 = d110 - d115;
                double d119 = d111 - d114;
                dArr[i76] = (d82 * d118) + (d81 * d119);
                dArr[i78] = (d82 * d119) - (d81 * d118);
                return;
            }
        }
    }

    private void j(int i4, double[] dArr, int[] iArr, int i5, int i6, double[] dArr2) {
        if (i4 > 32) {
            int i7 = i4 >> 2;
            i(i4, dArr, dArr2, i6 - i7);
            if (i4 > 512) {
                x(i7, dArr, 0, i6, dArr2);
                y(i7, dArr, i7, i6, dArr2);
                x(i7, dArr, i7 * 2, i6, dArr2);
                x(i7, dArr, i7 * 3, i6, dArr2);
            } else if (i7 > 32) {
                k(i4, dArr, 0, i6, dArr2);
            } else {
                t(i4, dArr, 0, i6, dArr2);
            }
            f(i4, iArr, i5, dArr);
        } else if (i4 > 8) {
            if (i4 == 32) {
                p(dArr, 0, dArr2, i6 - 8);
                e(dArr);
                return;
            }
            n(dArr, 0, dArr2, 0);
            c(dArr);
        } else if (i4 == 8) {
            h(dArr);
        } else if (i4 == 4) {
            z(dArr);
        }
    }

    private void k(int i4, double[] dArr, int i5, int i6, double[] dArr2) {
        int i7 = i4 >> 2;
        while (i7 > 128) {
            for (int i8 = i7; i8 < i4; i8 <<= 2) {
                for (int i9 = i8 - i7; i9 < i4; i9 += i8 * 4) {
                    int i10 = i6 - (i7 >> 1);
                    int i11 = i7;
                    v(i11, dArr, i5 + i9, dArr2, i10);
                    w(i11, dArr, i5 + i8 + i9, dArr2, i6 - i7);
                    v(i11, dArr, i5 + (i8 * 2) + i9, dArr2, i10);
                }
            }
            v(i7, dArr, (i5 + i4) - i7, dArr2, i6 - (i7 >> 1));
            i7 >>= 2;
        }
        for (int i12 = i7; i12 < i4; i12 <<= 2) {
            for (int i13 = i12 - i7; i13 < i4; i13 += i12 * 4) {
                int i14 = i5 + i13;
                int i15 = i6 - (i7 >> 1);
                v(i7, dArr, i14, dArr2, i15);
                t(i7, dArr, i14, i6, dArr2);
                int i16 = i5 + i12 + i13;
                w(i7, dArr, i16, dArr2, i6 - i7);
                u(i7, dArr, i16, i6, dArr2);
                int i17 = i5 + (i12 * 2) + i13;
                v(i7, dArr, i17, dArr2, i15);
                t(i7, dArr, i17, i6, dArr2);
            }
        }
        int i18 = (i5 + i4) - i7;
        v(i7, dArr, i18, dArr2, i6 - (i7 >> 1));
        t(i7, dArr, i18, i6, dArr2);
    }

    private void l(int i4, double[] dArr, int i5, int i6, double[] dArr2) {
        int i7 = i4 >> 1;
        int i8 = i4 >> 2;
        while (i8 > 128) {
            for (int i9 = i8; i9 < i7; i9 <<= 2) {
                for (int i10 = i9 - i8; i10 < i7; i10 += i9 * 2) {
                    int i11 = i6 - (i8 >> 1);
                    int i12 = i8;
                    v(i12, dArr, i5 + i10, dArr2, i11);
                    v(i12, dArr, i5 + i7 + i10, dArr2, i11);
                }
                for (int i13 = (i9 * 2) - i8; i13 < i7; i13 += i9 * 4) {
                    int i14 = i6 - i8;
                    int i15 = i8;
                    w(i15, dArr, i5 + i13, dArr2, i14);
                    w(i15, dArr, i5 + i7 + i13, dArr2, i14);
                }
            }
            i8 >>= 2;
        }
        for (int i16 = i8; i16 < i7; i16 <<= 2) {
            for (int i17 = i16 - i8; i17 < i7; i17 += i16 * 2) {
                int i18 = i5 + i17;
                int i19 = i6 - (i8 >> 1);
                int i20 = i8;
                v(i20, dArr, i18, dArr2, i19);
                int i21 = i8;
                t(i21, dArr, i18, i6, dArr2);
                int i22 = i5 + i7 + i17;
                v(i20, dArr, i22, dArr2, i19);
                t(i21, dArr, i22, i6, dArr2);
            }
            for (int i23 = (i16 * 2) - i8; i23 < i7; i23 += i16 * 4) {
                int i24 = i5 + i23;
                int i25 = i6 - i8;
                int i26 = i8;
                w(i26, dArr, i24, dArr2, i25);
                int i27 = i8;
                u(i27, dArr, i24, i6, dArr2);
                int i28 = i5 + i7 + i23;
                w(i26, dArr, i28, dArr2, i25);
                u(i27, dArr, i28, i6, dArr2);
            }
        }
    }

    private void m(double[] dArr) {
        double d4 = dArr[0] + dArr[4];
        double d5 = dArr[1] + dArr[5];
        double d6 = dArr[0] - dArr[4];
        double d7 = dArr[1] - dArr[5];
        double d8 = dArr[2] + dArr[6];
        double d9 = dArr[3] + dArr[7];
        double d10 = dArr[2] - dArr[6];
        double d11 = dArr[3] - dArr[7];
        dArr[0] = d4 + d8;
        dArr[1] = d5 + d9;
        dArr[4] = d4 - d8;
        dArr[5] = d5 - d9;
        dArr[2] = d6 - d11;
        dArr[3] = d7 + d10;
        dArr[6] = d6 + d11;
        dArr[7] = d7 - d10;
    }

    private void n(double[] dArr, int i4, double[] dArr2, int i5) {
        double d4 = dArr2[i5 + 1];
        int i6 = i4 + 0;
        int i7 = i4 + 8;
        double d5 = dArr[i6] + dArr[i7];
        int i8 = i4 + 1;
        int i9 = i4 + 9;
        double d6 = dArr[i8] + dArr[i9];
        double d7 = dArr[i6] - dArr[i7];
        double d8 = dArr[i8] - dArr[i9];
        int i10 = i4 + 4;
        int i11 = i4 + 12;
        double d9 = dArr[i10] + dArr[i11];
        int i12 = i4 + 5;
        int i13 = i4 + 13;
        double d10 = dArr[i12] + dArr[i13];
        double d11 = dArr[i10] - dArr[i11];
        double d12 = dArr[i12] - dArr[i13];
        double d13 = d5 + d9;
        double d14 = d6 + d10;
        double d15 = d5 - d9;
        double d16 = d6 - d10;
        double d17 = d7 - d12;
        double d18 = d8 + d11;
        double d19 = d7 + d12;
        double d20 = d8 - d11;
        int i14 = i4 + 2;
        int i15 = i4 + 10;
        double d21 = dArr[i14] + dArr[i15];
        int i16 = i4 + 3;
        int i17 = i4 + 11;
        double d22 = dArr[i16] + dArr[i17];
        double d23 = dArr[i14] - dArr[i15];
        double d24 = dArr[i16] - dArr[i17];
        int i18 = i4 + 6;
        int i19 = i4 + 14;
        double d25 = dArr[i18] + dArr[i19];
        int i20 = i4 + 7;
        int i21 = i4 + 15;
        double d26 = dArr[i20] + dArr[i21];
        double d27 = dArr[i18] - dArr[i19];
        double d28 = dArr[i20] - dArr[i21];
        double d29 = d21 + d25;
        double d30 = d22 + d26;
        double d31 = d21 - d25;
        double d32 = d22 - d26;
        double d33 = d23 - d28;
        double d34 = d24 + d27;
        double d35 = d23 + d28;
        double d36 = d24 - d27;
        double d37 = (d33 - d34) * d4;
        double d38 = (d33 + d34) * d4;
        double d39 = (d35 - d36) * d4;
        double d40 = d4 * (d35 + d36);
        dArr[i7] = d17 + d37;
        dArr[i9] = d18 + d38;
        dArr[i15] = d17 - d37;
        dArr[i17] = d18 - d38;
        dArr[i11] = d19 - d40;
        dArr[i13] = d20 + d39;
        dArr[i19] = d19 + d40;
        dArr[i21] = d20 - d39;
        dArr[i6] = d13 + d29;
        dArr[i8] = d14 + d30;
        dArr[i14] = d13 - d29;
        dArr[i16] = d14 - d30;
        dArr[i10] = d15 - d32;
        dArr[i12] = d16 + d31;
        dArr[i18] = d15 + d32;
        dArr[i20] = d16 - d31;
    }

    private void o(double[] dArr, int i4, double[] dArr2, int i5) {
        double d4 = dArr2[i5 + 1];
        double d5 = dArr2[i5 + 4];
        double d6 = dArr2[i5 + 5];
        int i6 = i4 + 0;
        int i7 = i4 + 9;
        double d7 = dArr[i6] - dArr[i7];
        int i8 = i4 + 1;
        int i9 = i4 + 8;
        double d8 = dArr[i8] + dArr[i9];
        double d9 = dArr[i6] + dArr[i7];
        double d10 = dArr[i8] - dArr[i9];
        int i10 = i4 + 4;
        int i11 = i4 + 13;
        double d11 = dArr[i10] - dArr[i11];
        int i12 = i4 + 5;
        int i13 = i4 + 12;
        double d12 = dArr[i12] + dArr[i13];
        double d13 = (d11 - d12) * d4;
        double d14 = (d12 + d11) * d4;
        double d15 = dArr[i10] + dArr[i11];
        double d16 = dArr[i12] - dArr[i13];
        double d17 = (d15 - d16) * d4;
        double d18 = d4 * (d16 + d15);
        int i14 = i4 + 2;
        int i15 = i4 + 11;
        double d19 = dArr[i14] - dArr[i15];
        int i16 = i4 + 3;
        int i17 = i4 + 10;
        double d20 = dArr[i16] + dArr[i17];
        double d21 = (d5 * d19) - (d6 * d20);
        double d22 = (d20 * d5) + (d19 * d6);
        double d23 = dArr[i14] + dArr[i15];
        double d24 = dArr[i16] - dArr[i17];
        double d25 = (d6 * d23) - (d5 * d24);
        double d26 = (d24 * d6) + (d23 * d5);
        int i18 = i4 + 6;
        int i19 = i4 + 15;
        double d27 = dArr[i18] - dArr[i19];
        int i20 = i4 + 7;
        int i21 = i4 + 14;
        double d28 = dArr[i20] + dArr[i21];
        double d29 = (d6 * d27) - (d5 * d28);
        double d30 = (d28 * d6) + (d27 * d5);
        double d31 = dArr[i18] + dArr[i19];
        double d32 = dArr[i20] - dArr[i21];
        double d33 = (d5 * d31) - (d6 * d32);
        double d34 = (d5 * d32) + (d6 * d31);
        double d35 = d7 + d13;
        double d36 = d8 + d14;
        double d37 = d21 + d29;
        double d38 = d22 + d30;
        dArr[i6] = d35 + d37;
        dArr[i8] = d36 + d38;
        dArr[i14] = d35 - d37;
        dArr[i16] = d36 - d38;
        double d39 = d7 - d13;
        double d40 = d8 - d14;
        double d41 = d21 - d29;
        double d42 = d22 - d30;
        dArr[i10] = d39 - d42;
        dArr[i12] = d40 + d41;
        dArr[i18] = d39 + d42;
        dArr[i20] = d40 - d41;
        double d43 = d9 - d18;
        double d44 = d10 + d17;
        double d45 = d25 - d33;
        double d46 = d26 - d34;
        dArr[i9] = d43 + d45;
        dArr[i7] = d44 + d46;
        dArr[i17] = d43 - d45;
        dArr[i15] = d44 - d46;
        double d47 = d9 + d18;
        double d48 = d10 - d17;
        double d49 = d25 + d33;
        double d50 = d26 + d34;
        dArr[i13] = d47 - d50;
        dArr[i11] = d48 + d49;
        dArr[i21] = d47 + d50;
        dArr[i19] = d48 - d49;
    }

    private void p(double[] dArr, int i4, double[] dArr2, int i5) {
        double d4 = dArr2[i5 + 1];
        int i6 = i5 + 2;
        double d5 = dArr2[i6] * d4;
        double d6 = dArr2[i6] + d5;
        int i7 = i4 + 0;
        int i8 = i4 + 16;
        double d7 = dArr[i7] + dArr[i8];
        int i9 = i4 + 1;
        int i10 = i4 + 17;
        double d8 = dArr[i9] + dArr[i10];
        double d9 = dArr[i7] - dArr[i8];
        double d10 = dArr[i9] - dArr[i10];
        int i11 = i4 + 8;
        int i12 = i4 + 24;
        double d11 = dArr[i11] + dArr[i12];
        int i13 = i4 + 9;
        int i14 = i4 + 25;
        double d12 = dArr[i13] + dArr[i14];
        double d13 = dArr[i11] - dArr[i12];
        double d14 = dArr[i13] - dArr[i14];
        double d15 = d7 + d11;
        double d16 = d8 + d12;
        double d17 = d7 - d11;
        double d18 = d8 - d12;
        double d19 = d9 - d14;
        double d20 = d10 + d13;
        double d21 = d9 + d14;
        double d22 = d10 - d13;
        int i15 = i4 + 2;
        int i16 = i4 + 18;
        double d23 = dArr[i15] + dArr[i16];
        int i17 = i4 + 3;
        int i18 = i4 + 19;
        double d24 = dArr[i17] + dArr[i18];
        double d25 = dArr[i15] - dArr[i16];
        double d26 = dArr[i17] - dArr[i18];
        int i19 = i4 + 10;
        int i20 = i4 + 26;
        double d27 = dArr[i19] + dArr[i20];
        int i21 = i4 + 11;
        int i22 = i4 + 27;
        double d28 = dArr[i21] + dArr[i22];
        double d29 = dArr[i19] - dArr[i20];
        double d30 = dArr[i21] - dArr[i22];
        double d31 = d23 + d27;
        double d32 = d24 + d28;
        double d33 = d23 - d27;
        double d34 = d24 - d28;
        double d35 = d25 - d30;
        double d36 = d26 + d29;
        double d37 = (d6 * d35) - (d5 * d36);
        double d38 = (d36 * d6) + (d35 * d5);
        double d39 = d25 + d30;
        double d40 = d26 - d29;
        double d41 = (d5 * d39) - (d6 * d40);
        double d42 = (d40 * d5) + (d39 * d6);
        int i23 = i4 + 4;
        int i24 = i4 + 20;
        double d43 = dArr[i23] + dArr[i24];
        int i25 = i4 + 5;
        int i26 = i4 + 21;
        double d44 = dArr[i25] + dArr[i26];
        double d45 = dArr[i23] - dArr[i24];
        double d46 = dArr[i25] - dArr[i26];
        int i27 = i4 + 12;
        int i28 = i4 + 28;
        double d47 = dArr[i27] + dArr[i28];
        int i29 = i4 + 13;
        int i30 = i4 + 29;
        double d48 = dArr[i29] + dArr[i30];
        double d49 = dArr[i27] - dArr[i28];
        double d50 = dArr[i29] - dArr[i30];
        double d51 = d43 + d47;
        double d52 = d44 + d48;
        double d53 = d43 - d47;
        double d54 = d44 - d48;
        double d55 = d45 - d50;
        double d56 = d46 + d49;
        double d57 = (d55 - d56) * d4;
        double d58 = (d56 + d55) * d4;
        double d59 = d45 + d50;
        double d60 = d46 - d49;
        double d61 = (d59 + d60) * d4;
        double d62 = (d60 - d59) * d4;
        int i31 = i4 + 6;
        int i32 = i4 + 22;
        double d63 = dArr[i31] + dArr[i32];
        int i33 = i4 + 7;
        int i34 = i4 + 23;
        double d64 = dArr[i33] + dArr[i34];
        double d65 = dArr[i31] - dArr[i32];
        double d66 = dArr[i33] - dArr[i34];
        int i35 = i4 + 14;
        int i36 = i4 + 30;
        double d67 = dArr[i35] + dArr[i36];
        int i37 = i4 + 15;
        int i38 = i4 + 31;
        double d68 = dArr[i37] + dArr[i38];
        double d69 = dArr[i35] - dArr[i36];
        double d70 = dArr[i37] - dArr[i38];
        double d71 = d63 + d67;
        double d72 = d64 + d68;
        double d73 = d63 - d67;
        double d74 = d64 - d68;
        double d75 = d65 - d70;
        double d76 = d66 + d69;
        double d77 = (d5 * d75) - (d6 * d76);
        double d78 = (d76 * d5) + (d75 * d6);
        double d79 = d65 + d70;
        double d80 = d66 - d69;
        double d81 = (d6 * d79) - (d5 * d80);
        double d82 = (d6 * d80) + (d5 * d79);
        double d83 = d21 - d61;
        double d84 = d22 - d62;
        double d85 = d21 + d61;
        double d86 = d22 + d62;
        double d87 = d41 - d81;
        double d88 = d42 - d82;
        double d89 = d41 + d81;
        double d90 = d42 + d82;
        dArr[i12] = d83 + d87;
        dArr[i14] = d84 + d88;
        dArr[i20] = d83 - d87;
        dArr[i22] = d84 - d88;
        dArr[i28] = d85 - d90;
        dArr[i30] = d86 + d89;
        dArr[i36] = d85 + d90;
        dArr[i38] = d86 - d89;
        double d91 = d19 + d57;
        double d92 = d20 + d58;
        double d93 = d19 - d57;
        double d94 = d20 - d58;
        double d95 = d37 + d77;
        double d96 = d38 + d78;
        double d97 = d37 - d77;
        double d98 = d38 - d78;
        dArr[i8] = d91 + d95;
        dArr[i10] = d92 + d96;
        dArr[i16] = d91 - d95;
        dArr[i18] = d92 - d96;
        dArr[i24] = d93 - d98;
        dArr[i26] = d94 + d97;
        dArr[i32] = d93 + d98;
        dArr[i34] = d94 - d97;
        double d99 = d33 - d74;
        double d100 = d34 + d73;
        double d101 = (d99 - d100) * d4;
        double d102 = (d100 + d99) * d4;
        double d103 = d33 + d74;
        double d104 = d34 - d73;
        double d105 = (d103 - d104) * d4;
        double d106 = d4 * (d104 + d103);
        double d107 = d17 - d54;
        double d108 = d18 + d53;
        double d109 = d17 + d54;
        double d110 = d18 - d53;
        dArr[i11] = d107 + d101;
        dArr[i13] = d108 + d102;
        dArr[i19] = d107 - d101;
        dArr[i21] = d108 - d102;
        dArr[i27] = d109 - d106;
        dArr[i29] = d110 + d105;
        dArr[i35] = d109 + d106;
        dArr[i37] = d110 - d105;
        double d111 = d15 + d51;
        double d112 = d16 + d52;
        double d113 = d15 - d51;
        double d114 = d16 - d52;
        double d115 = d31 + d71;
        double d116 = d32 + d72;
        double d117 = d31 - d71;
        double d118 = d32 - d72;
        dArr[i7] = d111 + d115;
        dArr[i9] = d112 + d116;
        dArr[i15] = d111 - d115;
        dArr[i17] = d112 - d116;
        dArr[i23] = d113 - d118;
        dArr[i25] = d114 + d117;
        dArr[i31] = d113 + d118;
        dArr[i33] = d114 - d117;
    }

    private void q(double[] dArr, int i4, double[] dArr2, int i5) {
        double d4 = dArr2[i5 + 1];
        double d5 = dArr2[i5 + 4];
        double d6 = dArr2[i5 + 5];
        double d7 = dArr2[i5 + 6];
        double d8 = dArr2[i5 + 7];
        double d9 = dArr2[i5 + 8];
        double d10 = dArr2[i5 + 9];
        int i6 = i4 + 0;
        int i7 = i4 + 17;
        double d11 = dArr[i6] - dArr[i7];
        int i8 = i4 + 1;
        int i9 = i4 + 16;
        double d12 = dArr[i8] + dArr[i9];
        int i10 = i4 + 8;
        int i11 = i4 + 25;
        double d13 = dArr[i10] - dArr[i11];
        int i12 = i4 + 9;
        int i13 = i4 + 24;
        double d14 = dArr[i12] + dArr[i13];
        double d15 = (d13 - d14) * d4;
        double d16 = (d14 + d13) * d4;
        double d17 = d11 + d15;
        double d18 = d12 + d16;
        double d19 = d11 - d15;
        double d20 = d12 - d16;
        double d21 = dArr[i6] + dArr[i7];
        double d22 = dArr[i8] - dArr[i9];
        double d23 = dArr[i10] + dArr[i11];
        double d24 = dArr[i12] - dArr[i13];
        double d25 = (d23 - d24) * d4;
        double d26 = (d24 + d23) * d4;
        double d27 = d21 - d26;
        double d28 = d22 + d25;
        double d29 = d21 + d26;
        double d30 = d22 - d25;
        int i14 = i4 + 2;
        int i15 = i4 + 19;
        double d31 = dArr[i14] - dArr[i15];
        int i16 = i4 + 3;
        int i17 = i4 + 18;
        double d32 = dArr[i16] + dArr[i17];
        double d33 = (d5 * d31) - (d6 * d32);
        double d34 = (d32 * d5) + (d31 * d6);
        int i18 = i4 + 10;
        int i19 = i4 + 27;
        double d35 = dArr[i18] - dArr[i19];
        int i20 = i4 + 11;
        int i21 = i4 + 26;
        double d36 = dArr[i20] + dArr[i21];
        double d37 = (d8 * d35) - (d7 * d36);
        double d38 = (d36 * d8) + (d35 * d7);
        double d39 = d33 + d37;
        double d40 = d34 + d38;
        double d41 = d33 - d37;
        double d42 = d34 - d38;
        double d43 = dArr[i14] + dArr[i15];
        double d44 = dArr[i16] - dArr[i17];
        double d45 = (d7 * d43) - (d8 * d44);
        double d46 = (d44 * d7) + (d43 * d8);
        double d47 = dArr[i18] + dArr[i19];
        double d48 = dArr[i20] - dArr[i21];
        double d49 = (d5 * d47) + (d6 * d48);
        double d50 = (d48 * d5) - (d47 * d6);
        double d51 = d45 - d49;
        double d52 = d46 - d50;
        double d53 = d45 + d49;
        double d54 = d46 + d50;
        int i22 = i4 + 4;
        int i23 = i4 + 21;
        double d55 = dArr[i22] - dArr[i23];
        int i24 = i4 + 5;
        int i25 = i4 + 20;
        double d56 = dArr[i24] + dArr[i25];
        double d57 = (d9 * d55) - (d10 * d56);
        double d58 = (d56 * d9) + (d55 * d10);
        int i26 = i4 + 12;
        int i27 = i4 + 29;
        double d59 = dArr[i26] - dArr[i27];
        int i28 = i4 + 13;
        int i29 = i4 + 28;
        double d60 = dArr[i28] + dArr[i29];
        double d61 = (d10 * d59) - (d9 * d60);
        double d62 = (d60 * d10) + (d59 * d9);
        double d63 = d57 + d61;
        double d64 = d58 + d62;
        double d65 = d57 - d61;
        double d66 = d58 - d62;
        double d67 = dArr[i22] + dArr[i23];
        double d68 = dArr[i24] - dArr[i25];
        double d69 = (d10 * d67) - (d9 * d68);
        double d70 = (d68 * d10) + (d67 * d9);
        double d71 = dArr[i26] + dArr[i27];
        double d72 = dArr[i28] - dArr[i29];
        double d73 = (d9 * d71) - (d10 * d72);
        double d74 = (d9 * d72) + (d10 * d71);
        double d75 = d69 - d73;
        double d76 = d70 - d74;
        double d77 = d69 + d73;
        double d78 = d70 + d74;
        int i30 = i4 + 6;
        int i31 = i4 + 23;
        double d79 = dArr[i30] - dArr[i31];
        int i32 = i4 + 7;
        int i33 = i4 + 22;
        double d80 = dArr[i32] + dArr[i33];
        double d81 = (d7 * d79) - (d8 * d80);
        double d82 = (d80 * d7) + (d79 * d8);
        int i34 = i4 + 14;
        int i35 = i4 + 31;
        double d83 = dArr[i34] - dArr[i35];
        int i36 = i4 + 15;
        int i37 = i4 + 30;
        double d84 = dArr[i36] + dArr[i37];
        double d85 = (d6 * d83) - (d5 * d84);
        double d86 = (d84 * d6) + (d83 * d5);
        double d87 = d81 + d85;
        double d88 = d82 + d86;
        double d89 = d81 - d85;
        double d90 = d82 - d86;
        double d91 = dArr[i30] + dArr[i31];
        double d92 = dArr[i32] - dArr[i33];
        double d93 = (d6 * d91) + (d5 * d92);
        double d94 = (d6 * d92) - (d5 * d91);
        double d95 = dArr[i34] + dArr[i35];
        double d96 = dArr[i36] - dArr[i37];
        double d97 = (d8 * d95) - (d7 * d96);
        double d98 = (d8 * d96) + (d7 * d95);
        double d99 = d93 + d97;
        double d100 = d94 + d98;
        double d101 = d93 - d97;
        double d102 = d94 - d98;
        double d103 = d17 + d63;
        double d104 = d18 + d64;
        double d105 = d39 + d87;
        double d106 = d40 + d88;
        dArr[i6] = d103 + d105;
        dArr[i8] = d104 + d106;
        dArr[i14] = d103 - d105;
        dArr[i16] = d104 - d106;
        double d107 = d17 - d63;
        double d108 = d18 - d64;
        double d109 = d39 - d87;
        double d110 = d40 - d88;
        dArr[i22] = d107 - d110;
        dArr[i24] = d108 + d109;
        dArr[i30] = d107 + d110;
        dArr[i32] = d108 - d109;
        double d111 = d19 - d66;
        double d112 = d20 + d65;
        double d113 = d41 - d90;
        double d114 = d42 + d89;
        double d115 = (d113 - d114) * d4;
        double d116 = (d114 + d113) * d4;
        dArr[i10] = d111 + d115;
        dArr[i12] = d112 + d116;
        dArr[i18] = d111 - d115;
        dArr[i20] = d112 - d116;
        double d117 = d19 + d66;
        double d118 = d20 - d65;
        double d119 = d41 + d90;
        double d120 = d42 - d89;
        double d121 = (d119 - d120) * d4;
        double d122 = (d120 + d119) * d4;
        dArr[i26] = d117 - d122;
        dArr[i28] = d118 + d121;
        dArr[i34] = d117 + d122;
        dArr[i36] = d118 - d121;
        double d123 = d27 + d75;
        double d124 = d28 + d76;
        double d125 = d51 - d99;
        double d126 = d52 - d100;
        dArr[i9] = d123 + d125;
        dArr[i7] = d124 + d126;
        dArr[i17] = d123 - d125;
        dArr[i15] = d124 - d126;
        double d127 = d27 - d75;
        double d128 = d28 - d76;
        double d129 = d51 + d99;
        double d130 = d52 + d100;
        dArr[i25] = d127 - d130;
        dArr[i23] = d128 + d129;
        dArr[i33] = d127 + d130;
        dArr[i31] = d128 - d129;
        double d131 = d29 - d78;
        double d132 = d30 + d77;
        double d133 = d53 + d102;
        double d134 = d54 - d101;
        double d135 = (d133 - d134) * d4;
        double d136 = (d134 + d133) * d4;
        dArr[i13] = d131 + d135;
        dArr[i11] = d132 + d136;
        dArr[i21] = d131 - d135;
        dArr[i19] = d132 - d136;
        double d137 = d29 + d78;
        double d138 = d30 - d77;
        double d139 = d53 - d102;
        double d140 = d54 + d101;
        double d141 = (d139 - d140) * d4;
        double d142 = d4 * (d140 + d139);
        dArr[i29] = d137 - d142;
        dArr[i27] = d138 + d141;
        dArr[i37] = d137 + d142;
        dArr[i35] = d138 - d141;
    }

    private void r(int i4, double[] dArr, double[] dArr2, int i5) {
        int i6 = i4 >> 3;
        int i7 = i6 * 2;
        int i8 = i7 + i7;
        int i9 = i8 + i7;
        int i10 = 0;
        double d4 = dArr[0] + dArr[i8];
        int i11 = i8 + 1;
        double d5 = dArr[1] + dArr[i11];
        double d6 = dArr[0] - dArr[i8];
        double d7 = dArr[1] - dArr[i11];
        double d8 = dArr[i7] + dArr[i9];
        int i12 = i7 + 1;
        int i13 = i9 + 1;
        double d9 = dArr[i12] + dArr[i13];
        double d10 = dArr[i7] - dArr[i9];
        double d11 = dArr[i12] - dArr[i13];
        dArr[0] = d4 + d8;
        dArr[1] = d5 + d9;
        dArr[i7] = d4 - d8;
        dArr[i12] = d5 - d9;
        dArr[i8] = d6 - d11;
        dArr[i11] = d7 + d10;
        dArr[i9] = d6 + d11;
        dArr[i13] = d7 - d10;
        double d12 = dArr2[i5 + 1];
        double d13 = dArr2[i5 + 2];
        double d14 = dArr2[i5 + 3];
        double d15 = 0.0d;
        double d16 = 1.0d;
        double d17 = 1.0d;
        int i14 = 2;
        double d18 = 0.0d;
        while (true) {
            int i15 = i6 - 2;
            if (i14 < i15) {
                int i16 = i10 + 4;
                int i17 = i5 + i16;
                double d19 = (d16 + dArr2[i17]) * d13;
                int i18 = i17 + 1;
                double d20 = (d15 + dArr2[i18]) * d13;
                int i19 = i17 + 2;
                double d21 = (d17 + dArr2[i19]) * d14;
                int i20 = i17 + 3;
                double d22 = (d18 - dArr2[i20]) * d14;
                double d23 = dArr2[i17];
                double d24 = dArr2[i18];
                double d25 = dArr2[i19];
                double d26 = -dArr2[i20];
                int i21 = i14 + i7;
                int i22 = i21 + i7;
                int i23 = i22 + i7;
                double d27 = dArr[i14] + dArr[i22];
                int i24 = i14 + 1;
                int i25 = i22 + 1;
                double d28 = dArr[i24] + dArr[i25];
                double d29 = dArr[i14] - dArr[i22];
                double d30 = dArr[i24] - dArr[i25];
                int i26 = i14 + 2;
                int i27 = i22 + 2;
                double d31 = dArr[i26] + dArr[i27];
                int i28 = i14 + 3;
                int i29 = i22 + 3;
                double d32 = dArr[i28] + dArr[i29];
                double d33 = dArr[i26] - dArr[i27];
                double d34 = dArr[i28] - dArr[i29];
                double d35 = dArr[i21] + dArr[i23];
                int i30 = i21 + 1;
                int i31 = i23 + 1;
                double d36 = dArr[i30] + dArr[i31];
                double d37 = dArr[i21] - dArr[i23];
                double d38 = dArr[i30] - dArr[i31];
                int i32 = i21 + 2;
                int i33 = i23 + 2;
                double d39 = dArr[i32] + dArr[i33];
                int i34 = i21 + 3;
                int i35 = i23 + 3;
                double d40 = dArr[i34] + dArr[i35];
                double d41 = dArr[i32] - dArr[i33];
                double d42 = dArr[i34] - dArr[i35];
                dArr[i14] = d27 + d35;
                dArr[i24] = d28 + d36;
                dArr[i26] = d31 + d39;
                dArr[i28] = d32 + d40;
                dArr[i21] = d27 - d35;
                dArr[i30] = d28 - d36;
                dArr[i32] = d31 - d39;
                dArr[i34] = d32 - d40;
                double d43 = d29 - d38;
                double d44 = d30 + d37;
                dArr[i22] = (d19 * d43) - (d20 * d44);
                dArr[i25] = (d44 * d19) + (d43 * d20);
                double d45 = d33 - d42;
                double d46 = d34 + d41;
                dArr[i27] = (d23 * d45) - (d24 * d46);
                dArr[i29] = (d46 * d23) + (d45 * d24);
                double d47 = d29 + d38;
                double d48 = d30 - d37;
                dArr[i23] = (d21 * d47) + (d22 * d48);
                dArr[i31] = (d48 * d21) - (d47 * d22);
                double d49 = d33 + d42;
                double d50 = d34 - d41;
                dArr[i33] = (d25 * d49) + (d26 * d50);
                dArr[i35] = (d50 * d25) - (d49 * d26);
                int i36 = i7 - i14;
                int i37 = i36 + i7;
                int i38 = i37 + i7;
                int i39 = i38 + i7;
                double d51 = dArr[i36] + dArr[i38];
                int i40 = i36 + 1;
                int i41 = i38 + 1;
                double d52 = dArr[i40] + dArr[i41];
                double d53 = dArr[i36] - dArr[i38];
                double d54 = dArr[i40] - dArr[i41];
                int i42 = i36 - 2;
                int i43 = i38 - 2;
                double d55 = dArr[i42] + dArr[i43];
                int i44 = i36 - 1;
                int i45 = i38 - 1;
                double d56 = dArr[i44] + dArr[i45];
                double d57 = dArr[i42] - dArr[i43];
                double d58 = dArr[i44] - dArr[i45];
                double d59 = dArr[i37] + dArr[i39];
                int i46 = i37 + 1;
                int i47 = i39 + 1;
                double d60 = dArr[i46] + dArr[i47];
                double d61 = dArr[i37] - dArr[i39];
                double d62 = dArr[i46] - dArr[i47];
                int i48 = i37 - 2;
                int i49 = i39 - 2;
                double d63 = dArr[i48] + dArr[i49];
                int i50 = i37 - 1;
                int i51 = i39 - 1;
                double d64 = dArr[i50] + dArr[i51];
                double d65 = dArr[i48] - dArr[i49];
                double d66 = dArr[i50] - dArr[i51];
                dArr[i36] = d51 + d59;
                dArr[i40] = d52 + d60;
                dArr[i42] = d55 + d63;
                dArr[i44] = d56 + d64;
                dArr[i37] = d51 - d59;
                dArr[i46] = d52 - d60;
                dArr[i48] = d55 - d63;
                dArr[i50] = d56 - d64;
                double d67 = d53 - d62;
                double d68 = d54 + d61;
                dArr[i38] = (d20 * d67) - (d19 * d68);
                dArr[i41] = (d20 * d68) + (d19 * d67);
                double d69 = d57 - d66;
                double d70 = d58 + d65;
                dArr[i43] = (d24 * d69) - (d23 * d70);
                dArr[i45] = (d70 * d24) + (d69 * d23);
                double d71 = d53 + d62;
                double d72 = d54 - d61;
                dArr[i39] = (d22 * d71) + (d21 * d72);
                dArr[i47] = (d22 * d72) - (d21 * d71);
                double d73 = d57 + d66;
                double d74 = d58 - d65;
                dArr[i49] = (d26 * d73) + (d25 * d74);
                dArr[i51] = (d74 * d26) - (d73 * d25);
                i14 += 4;
                d18 = d26;
                d17 = d25;
                d16 = d23;
                d15 = d24;
                i10 = i16;
            } else {
                double d75 = (d16 + d12) * d13;
                double d76 = d13 * (d15 + d12);
                double d77 = (d17 - d12) * d14;
                double d78 = d14 * (d18 - d12);
                int i52 = i6 + i7;
                int i53 = i52 + i7;
                int i54 = i7 + i53;
                int i55 = i53 - 2;
                double d79 = dArr[i15] + dArr[i55];
                int i56 = i6 - 1;
                int i57 = i53 - 1;
                double d80 = dArr[i56] + dArr[i57];
                double d81 = dArr[i15] - dArr[i55];
                double d82 = dArr[i56] - dArr[i57];
                int i58 = i52 - 2;
                int i59 = i54 - 2;
                double d83 = dArr[i58] + dArr[i59];
                int i60 = i52 - 1;
                int i61 = i54 - 1;
                double d84 = dArr[i60] + dArr[i61];
                double d85 = dArr[i58] - dArr[i59];
                double d86 = dArr[i60] - dArr[i61];
                dArr[i15] = d79 + d83;
                dArr[i56] = d80 + d84;
                dArr[i58] = d79 - d83;
                dArr[i60] = d80 - d84;
                double d87 = d81 - d86;
                double d88 = d82 + d85;
                dArr[i55] = (d75 * d87) - (d76 * d88);
                dArr[i57] = (d88 * d75) + (d87 * d76);
                double d89 = d81 + d86;
                double d90 = d82 - d85;
                dArr[i59] = (d77 * d89) + (d78 * d90);
                dArr[i61] = (d90 * d77) - (d89 * d78);
                double d91 = dArr[i6] + dArr[i53];
                int i62 = i6 + 1;
                int i63 = i53 + 1;
                double d92 = dArr[i62] + dArr[i63];
                double d93 = dArr[i6] - dArr[i53];
                double d94 = dArr[i62] - dArr[i63];
                double d95 = dArr[i52] + dArr[i54];
                int i64 = i52 + 1;
                int i65 = i54 + 1;
                double d96 = dArr[i64] + dArr[i65];
                double d97 = dArr[i52] - dArr[i54];
                double d98 = dArr[i64] - dArr[i65];
                dArr[i6] = d91 + d95;
                dArr[i62] = d92 + d96;
                dArr[i52] = d91 - d95;
                dArr[i64] = d92 - d96;
                double d99 = d93 - d98;
                double d100 = d94 + d97;
                dArr[i53] = (d99 - d100) * d12;
                dArr[i63] = d12 * (d100 + d99);
                double d101 = d93 + d98;
                double d102 = d94 - d97;
                double d103 = -d12;
                dArr[i54] = (d101 + d102) * d103;
                dArr[i65] = d103 * (d102 - d101);
                int i66 = i6 + 2;
                int i67 = i53 + 2;
                double d104 = dArr[i66] + dArr[i67];
                int i68 = i6 + 3;
                int i69 = i53 + 3;
                double d105 = dArr[i68] + dArr[i69];
                double d106 = dArr[i66] - dArr[i67];
                double d107 = dArr[i68] - dArr[i69];
                int i70 = i52 + 2;
                int i71 = i54 + 2;
                double d108 = dArr[i70] + dArr[i71];
                int i72 = i52 + 3;
                int i73 = i54 + 3;
                double d109 = dArr[i72] + dArr[i73];
                double d110 = dArr[i70] - dArr[i71];
                double d111 = dArr[i72] - dArr[i73];
                dArr[i66] = d104 + d108;
                dArr[i68] = d105 + d109;
                dArr[i70] = d104 - d108;
                dArr[i72] = d105 - d109;
                double d112 = d106 - d111;
                double d113 = d107 + d110;
                dArr[i67] = (d76 * d112) - (d75 * d113);
                dArr[i69] = (d76 * d113) + (d75 * d112);
                double d114 = d106 + d111;
                double d115 = d107 - d110;
                dArr[i71] = (d78 * d114) + (d77 * d115);
                dArr[i73] = (d78 * d115) - (d77 * d114);
                return;
            }
        }
    }

    private void s(int i4, double[] dArr, int[] iArr, int i5, int i6, double[] dArr2) {
        if (i4 > 32) {
            int i7 = i4 >> 2;
            r(i4, dArr, dArr2, i6 - i7);
            if (i4 > 512) {
                x(i7, dArr, 0, i6, dArr2);
                y(i7, dArr, i7, i6, dArr2);
                x(i7, dArr, i7 * 2, i6, dArr2);
                x(i7, dArr, i7 * 3, i6, dArr2);
            } else if (i7 > 32) {
                k(i4, dArr, 0, i6, dArr2);
            } else {
                t(i4, dArr, 0, i6, dArr2);
            }
            a(i4, iArr, i5, dArr);
        } else if (i4 > 8) {
            if (i4 == 32) {
                p(dArr, 0, dArr2, i6 - 8);
                d(dArr);
                return;
            }
            n(dArr, 0, dArr2, 0);
            b(dArr);
        } else if (i4 == 8) {
            m(dArr);
        } else if (i4 == 4) {
            z(dArr);
        }
    }

    private void t(int i4, double[] dArr, int i5, int i6, double[] dArr2) {
        if (i4 == 128) {
            int i7 = i6 - 8;
            p(dArr, i5, dArr2, i7);
            q(dArr, i5 + 32, dArr2, i6 - 32);
            p(dArr, i5 + 64, dArr2, i7);
            p(dArr, i5 + 96, dArr2, i7);
            return;
        }
        int i8 = i6 - 16;
        n(dArr, i5, dArr2, i8);
        o(dArr, i5 + 16, dArr2, i8);
        n(dArr, i5 + 32, dArr2, i8);
        n(dArr, i5 + 48, dArr2, i8);
    }

    private void u(int i4, double[] dArr, int i5, int i6, double[] dArr2) {
        if (i4 == 128) {
            int i7 = i6 - 8;
            p(dArr, i5, dArr2, i7);
            int i8 = i6 - 32;
            q(dArr, i5 + 32, dArr2, i8);
            p(dArr, i5 + 64, dArr2, i7);
            q(dArr, i5 + 96, dArr2, i8);
            return;
        }
        int i9 = i6 - 16;
        n(dArr, i5, dArr2, i9);
        o(dArr, i5 + 16, dArr2, i9);
        n(dArr, i5 + 32, dArr2, i9);
        o(dArr, i5 + 48, dArr2, i9);
    }

    private final void v(int i4, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = i4 >> 3;
        int i8 = i7 * 2;
        int i9 = i8 + i8;
        int i10 = i9 + i8;
        int i11 = i5 + 0;
        int i12 = i5 + i9;
        double d4 = dArr[i11] + dArr[i12];
        int i13 = i5 + 1;
        int i14 = i12 + 1;
        double d5 = dArr[i13] + dArr[i14];
        double d6 = dArr[i11] - dArr[i12];
        double d7 = dArr[i13] - dArr[i14];
        int i15 = i5 + i8;
        int i16 = i5 + i10;
        double d8 = dArr[i15] + dArr[i16];
        int i17 = i15 + 1;
        int i18 = i16 + 1;
        double d9 = dArr[i17] + dArr[i18];
        double d10 = dArr[i15] - dArr[i16];
        double d11 = dArr[i17] - dArr[i18];
        dArr[i11] = d4 + d8;
        dArr[i13] = d5 + d9;
        dArr[i15] = d4 - d8;
        dArr[i17] = d5 - d9;
        dArr[i12] = d6 - d11;
        dArr[i14] = d7 + d10;
        dArr[i16] = d6 + d11;
        dArr[i18] = d7 - d10;
        double d12 = dArr2[i6 + 1];
        int i19 = 0;
        for (int i20 = 2; i20 < i7; i20 += 2) {
            i19 += 4;
            int i21 = i6 + i19;
            double d13 = dArr2[i21];
            double d14 = dArr2[i21 + 1];
            double d15 = dArr2[i21 + 2];
            double d16 = -dArr2[i21 + 3];
            int i22 = i20 + i8;
            int i23 = i22 + i8;
            int i24 = i23 + i8;
            int i25 = i5 + i20;
            int i26 = i5 + i23;
            double d17 = dArr[i25] + dArr[i26];
            int i27 = i25 + 1;
            int i28 = i26 + 1;
            double d18 = dArr[i27] + dArr[i28];
            double d19 = dArr[i25] - dArr[i26];
            double d20 = dArr[i27] - dArr[i28];
            int i29 = i5 + i22;
            int i30 = i5 + i24;
            double d21 = dArr[i29] + dArr[i30];
            int i31 = i29 + 1;
            int i32 = i30 + 1;
            double d22 = dArr[i31] + dArr[i32];
            double d23 = dArr[i29] - dArr[i30];
            double d24 = dArr[i31] - dArr[i32];
            dArr[i25] = d17 + d21;
            dArr[i27] = d18 + d22;
            dArr[i29] = d17 - d21;
            dArr[i31] = d18 - d22;
            double d25 = d19 - d24;
            double d26 = d20 + d23;
            dArr[i26] = (d13 * d25) - (d14 * d26);
            dArr[i28] = (d26 * d13) + (d25 * d14);
            double d27 = d19 + d24;
            double d28 = d20 - d23;
            dArr[i30] = (d15 * d27) + (d16 * d28);
            dArr[i32] = (d28 * d15) - (d27 * d16);
            int i33 = i8 - i20;
            int i34 = i33 + i8;
            int i35 = i34 + i8;
            int i36 = i35 + i8;
            int i37 = i5 + i33;
            int i38 = i5 + i35;
            double d29 = dArr[i37] + dArr[i38];
            int i39 = i37 + 1;
            int i40 = i38 + 1;
            double d30 = dArr[i39] + dArr[i40];
            double d31 = dArr[i37] - dArr[i38];
            double d32 = dArr[i39] - dArr[i40];
            int i41 = i5 + i34;
            int i42 = i5 + i36;
            double d33 = dArr[i41] + dArr[i42];
            int i43 = i41 + 1;
            int i44 = i42 + 1;
            double d34 = dArr[i43] + dArr[i44];
            double d35 = dArr[i41] - dArr[i42];
            double d36 = dArr[i43] - dArr[i44];
            dArr[i37] = d29 + d33;
            dArr[i39] = d30 + d34;
            dArr[i41] = d29 - d33;
            dArr[i43] = d30 - d34;
            double d37 = d31 - d36;
            double d38 = d32 + d35;
            dArr[i38] = (d14 * d37) - (d13 * d38);
            dArr[i40] = (d14 * d38) + (d13 * d37);
            double d39 = d31 + d36;
            double d40 = d32 - d35;
            dArr[i42] = (d16 * d39) + (d15 * d40);
            dArr[i44] = (d16 * d40) - (d15 * d39);
        }
        int i45 = i7 + i8;
        int i46 = i45 + i8;
        int i47 = i8 + i46;
        int i48 = i5 + i7;
        int i49 = i5 + i46;
        double d41 = dArr[i48] + dArr[i49];
        int i50 = i48 + 1;
        int i51 = i49 + 1;
        double d42 = dArr[i50] + dArr[i51];
        double d43 = dArr[i48] - dArr[i49];
        double d44 = dArr[i50] - dArr[i51];
        int i52 = i5 + i45;
        int i53 = i5 + i47;
        double d45 = dArr[i52] + dArr[i53];
        int i54 = i52 + 1;
        int i55 = i53 + 1;
        double d46 = dArr[i54] + dArr[i55];
        double d47 = dArr[i52] - dArr[i53];
        double d48 = dArr[i54] - dArr[i55];
        dArr[i48] = d41 + d45;
        dArr[i50] = d42 + d46;
        dArr[i52] = d41 - d45;
        dArr[i54] = d42 - d46;
        double d49 = d43 - d48;
        double d50 = d44 + d47;
        dArr[i49] = (d49 - d50) * d12;
        dArr[i51] = (d50 + d49) * d12;
        double d51 = d43 + d48;
        double d52 = d44 - d47;
        double d53 = -d12;
        dArr[i53] = (d51 + d52) * d53;
        dArr[i55] = d53 * (d52 - d51);
    }

    private final void w(int i4, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = i4 >> 3;
        int i8 = i7 * 2;
        double d4 = dArr2[i6 + 1];
        int i9 = i8 + i8;
        int i10 = i9 + i8;
        int i11 = i5 + 0;
        int i12 = i5 + i9;
        int i13 = i12 + 1;
        double d5 = dArr[i11] - dArr[i13];
        int i14 = i5 + 1;
        double d6 = dArr[i14] + dArr[i12];
        double d7 = dArr[i11] + dArr[i13];
        double d8 = dArr[i14] - dArr[i12];
        int i15 = i5 + i8;
        int i16 = i5 + i10;
        int i17 = i16 + 1;
        double d9 = dArr[i15] - dArr[i17];
        int i18 = i15 + 1;
        double d10 = dArr[i18] + dArr[i16];
        double d11 = dArr[i15] + dArr[i17];
        double d12 = dArr[i18] - dArr[i16];
        double d13 = (d9 - d10) * d4;
        double d14 = (d10 + d9) * d4;
        dArr[i11] = d5 + d13;
        dArr[i14] = d6 + d14;
        dArr[i15] = d5 - d13;
        dArr[i18] = d6 - d14;
        double d15 = (d11 - d12) * d4;
        double d16 = d4 * (d12 + d11);
        dArr[i12] = d7 - d16;
        dArr[i13] = d8 + d15;
        dArr[i16] = d7 + d16;
        dArr[i17] = d8 - d15;
        int i19 = i8 * 2;
        int i20 = 0;
        int i21 = 2;
        while (i21 < i7) {
            int i22 = i20 + 4;
            int i23 = i6 + i22;
            double d17 = dArr2[i23];
            double d18 = dArr2[i23 + 1];
            double d19 = dArr2[i23 + 2];
            double d20 = -dArr2[i23 + 3];
            int i24 = i19 - 4;
            int i25 = i6 + i24;
            double d21 = dArr2[i25];
            double d22 = dArr2[i25 + 1];
            double d23 = dArr2[i25 + 2];
            double d24 = -dArr2[i25 + 3];
            int i26 = i21 + i8;
            int i27 = i26 + i8;
            int i28 = i27 + i8;
            int i29 = i5 + i21;
            int i30 = i5 + i27;
            int i31 = i30 + 1;
            double d25 = dArr[i29] - dArr[i31];
            int i32 = i29 + 1;
            double d26 = dArr[i32] + dArr[i30];
            double d27 = dArr[i29] + dArr[i31];
            double d28 = dArr[i32] - dArr[i30];
            int i33 = i5 + i26;
            int i34 = i5 + i28;
            int i35 = i34 + 1;
            double d29 = dArr[i33] - dArr[i35];
            int i36 = i33 + 1;
            double d30 = dArr[i36] + dArr[i34];
            double d31 = dArr[i33] + dArr[i35];
            double d32 = dArr[i36] - dArr[i34];
            double d33 = (d17 * d25) - (d18 * d26);
            double d34 = (d26 * d17) + (d25 * d18);
            double d35 = (d22 * d29) - (d21 * d30);
            double d36 = (d30 * d22) + (d29 * d21);
            dArr[i29] = d33 + d35;
            dArr[i32] = d34 + d36;
            dArr[i33] = d33 - d35;
            dArr[i36] = d34 - d36;
            double d37 = (d19 * d27) + (d20 * d28);
            double d38 = (d28 * d19) - (d27 * d20);
            double d39 = (d24 * d31) + (d23 * d32);
            double d40 = (d32 * d24) - (d31 * d23);
            dArr[i30] = d37 + d39;
            dArr[i31] = d38 + d40;
            dArr[i34] = d37 - d39;
            dArr[i35] = d38 - d40;
            int i37 = i8 - i21;
            int i38 = i37 + i8;
            int i39 = i38 + i8;
            int i40 = i39 + i8;
            int i41 = i5 + i37;
            int i42 = i5 + i39;
            int i43 = i42 + 1;
            double d41 = dArr[i41] - dArr[i43];
            int i44 = i41 + 1;
            double d42 = dArr[i44] + dArr[i42];
            double d43 = dArr[i41] + dArr[i43];
            double d44 = dArr[i44] - dArr[i42];
            int i45 = i5 + i38;
            int i46 = i5 + i40;
            int i47 = i46 + 1;
            double d45 = dArr[i45] - dArr[i47];
            int i48 = i45 + 1;
            double d46 = dArr[i48] + dArr[i46];
            double d47 = dArr[i45] + dArr[i47];
            double d48 = dArr[i48] - dArr[i46];
            double d49 = (d21 * d41) - (d22 * d42);
            double d50 = (d21 * d42) + (d22 * d41);
            double d51 = (d18 * d45) - (d17 * d46);
            double d52 = (d18 * d46) + (d17 * d45);
            dArr[i41] = d49 + d51;
            dArr[i44] = d50 + d52;
            dArr[i45] = d49 - d51;
            dArr[i48] = d50 - d52;
            double d53 = (d23 * d43) + (d24 * d44);
            double d54 = (d23 * d44) - (d24 * d43);
            double d55 = (d20 * d47) + (d19 * d48);
            double d56 = (d20 * d48) - (d19 * d47);
            dArr[i42] = d53 + d55;
            dArr[i43] = d54 + d56;
            dArr[i46] = d53 - d55;
            dArr[i47] = d54 - d56;
            i21 += 2;
            i20 = i22;
            i19 = i24;
        }
        int i49 = i6 + i8;
        double d57 = dArr2[i49];
        double d58 = dArr2[i49 + 1];
        int i50 = i7 + i8;
        int i51 = i50 + i8;
        int i52 = i8 + i51;
        int i53 = i5 + i7;
        int i54 = i5 + i51;
        int i55 = i54 + 1;
        double d59 = dArr[i53] - dArr[i55];
        int i56 = i53 + 1;
        double d60 = dArr[i56] + dArr[i54];
        double d61 = dArr[i53] + dArr[i55];
        double d62 = dArr[i56] - dArr[i54];
        int i57 = i5 + i50;
        int i58 = i5 + i52;
        int i59 = i58 + 1;
        double d63 = dArr[i57] - dArr[i59];
        int i60 = i57 + 1;
        double d64 = dArr[i60] + dArr[i58];
        double d65 = dArr[i57] + dArr[i59];
        double d66 = dArr[i60] - dArr[i58];
        double d67 = (d57 * d59) - (d58 * d60);
        double d68 = (d60 * d57) + (d59 * d58);
        double d69 = (d58 * d63) - (d57 * d64);
        double d70 = (d64 * d58) + (d63 * d57);
        dArr[i53] = d67 + d69;
        dArr[i56] = d68 + d70;
        dArr[i57] = d67 - d69;
        dArr[i60] = d68 - d70;
        double d71 = (d58 * d61) - (d57 * d62);
        double d72 = (d62 * d58) + (d61 * d57);
        double d73 = (d57 * d65) - (d58 * d66);
        double d74 = (d57 * d66) + (d58 * d65);
        dArr[i54] = d71 - d73;
        dArr[i55] = d72 - d74;
        dArr[i58] = d71 + d73;
        dArr[i59] = d72 + d74;
    }

    private void x(int i4, double[] dArr, int i5, int i6, double[] dArr2) {
        int i7 = i4 >> 2;
        int i8 = i7 * 2;
        v(i4, dArr, i5, dArr2, i6 - i8);
        if (i4 > 512) {
            x(i7, dArr, i5, i6, dArr2);
            y(i7, dArr, i5 + i7, i6, dArr2);
            x(i7, dArr, i5 + i8, i6, dArr2);
            x(i7, dArr, i5 + (i7 * 3), i6, dArr2);
            return;
        }
        k(i4, dArr, i5, i6, dArr2);
    }

    private void y(int i4, double[] dArr, int i5, int i6, double[] dArr2) {
        int i7 = i4 >> 2;
        w(i4, dArr, i5, dArr2, i6 - i4);
        if (i4 > 512) {
            x(i7, dArr, i5, i6, dArr2);
            y(i7, dArr, i5 + i7, i6, dArr2);
            x(i7, dArr, i5 + (i7 * 2), i6, dArr2);
            y(i7, dArr, i5 + (i7 * 3), i6, dArr2);
            return;
        }
        l(i4, dArr, i5, i6, dArr2);
    }

    private void z(double[] dArr) {
        double d4 = dArr[1] - dArr[3];
        dArr[0] = dArr[0] + dArr[2];
        dArr[1] = dArr[1] + dArr[3];
        dArr[2] = dArr[0] - dArr[2];
        dArr[3] = d4;
    }

    public void B(int i4, int i5, double[] dArr, int[] iArr, double[] dArr2) {
        int i6;
        int i7 = iArr[0];
        if (i4 > (i7 << 2)) {
            i7 = i4 >> 2;
            H(i7, iArr, dArr2);
        }
        int i8 = i7;
        int i9 = iArr[1];
        if (i4 > i9) {
            G(i4, iArr, dArr2, i8);
            i6 = i4;
        } else {
            i6 = i9;
        }
        if (i5 < 0) {
            double d4 = dArr[i4 - 1];
            for (int i10 = i4 - 2; i10 >= 2; i10 -= 2) {
                int i11 = i10 - 1;
                dArr[i10 + 1] = dArr[i10] - dArr[i11];
                dArr[i10] = dArr[i10] + dArr[i11];
            }
            dArr[1] = dArr[0] - d4;
            dArr[0] = dArr[0] + d4;
            if (i4 > 4) {
                J(i4, dArr, i6, dArr2, i8);
                j(i4, dArr, iArr, 2, i8, dArr2);
            } else if (i4 == 4) {
                j(i4, dArr, iArr, 2, i8, dArr2);
            }
        }
        A(i4, dArr, i6, dArr2, i8);
        if (i5 >= 0) {
            if (i4 > 4) {
                s(i4, dArr, iArr, 2, i8, dArr2);
                K(i4, dArr, i6, dArr2, i8);
            } else if (i4 == 4) {
                s(i4, dArr, iArr, 2, i8, dArr2);
            }
            double d5 = dArr[0] - dArr[1];
            dArr[0] = dArr[0] + dArr[1];
            for (int i12 = 2; i12 < i4; i12 += 2) {
                int i13 = i12 + 1;
                dArr[i12 - 1] = dArr[i12] - dArr[i13];
                dArr[i12] = dArr[i12] + dArr[i13];
            }
            dArr[i4 - 1] = d5;
        }
    }

    public void C(int i4, int i5, double[] dArr, int[] iArr, double[] dArr2) {
        int i6;
        int i7 = iArr[0];
        if (i4 > (i7 << 2)) {
            i7 = i4 >> 2;
            H(i7, iArr, dArr2);
        }
        int i8 = i7;
        int i9 = iArr[1];
        if (i4 > i9) {
            G(i4, iArr, dArr2, i8);
            i6 = i4;
        } else {
            i6 = i9;
        }
        if (i5 < 0) {
            double d4 = dArr[i4 - 1];
            for (int i10 = i4 - 2; i10 >= 2; i10 -= 2) {
                int i11 = i10 - 1;
                dArr[i10 + 1] = (-dArr[i10]) - dArr[i11];
                dArr[i10] = dArr[i10] - dArr[i11];
            }
            dArr[1] = dArr[0] + d4;
            dArr[0] = dArr[0] - d4;
            if (i4 > 4) {
                J(i4, dArr, i6, dArr2, i8);
                j(i4, dArr, iArr, 2, i8, dArr2);
            } else if (i4 == 4) {
                j(i4, dArr, iArr, 2, i8, dArr2);
            }
        }
        F(i4, dArr, i6, dArr2, i8);
        if (i5 >= 0) {
            if (i4 > 4) {
                s(i4, dArr, iArr, 2, i8, dArr2);
                K(i4, dArr, i6, dArr2, i8);
            } else if (i4 == 4) {
                s(i4, dArr, iArr, 2, i8, dArr2);
            }
            double d5 = dArr[0] - dArr[1];
            dArr[0] = dArr[0] + dArr[1];
            for (int i12 = 2; i12 < i4; i12 += 2) {
                int i13 = i12 + 1;
                dArr[i12 - 1] = (-dArr[i12]) - dArr[i13];
                dArr[i12] = dArr[i12] - dArr[i13];
            }
            dArr[i4 - 1] = -d5;
        }
    }

    public void D(int i4, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        int i5;
        int i6 = iArr[0];
        if (i4 > (i6 << 3)) {
            i6 = i4 >> 3;
            H(i6, iArr, dArr3);
        }
        int i7 = i6;
        int i8 = iArr[1];
        if (i4 > (i8 << 1)) {
            i8 = i4 >> 1;
            G(i8, iArr, dArr3, i7);
        }
        int i9 = i8;
        int i10 = i4 >> 1;
        double d4 = dArr[i10];
        double d5 = dArr[0] + dArr[i4];
        dArr[0] = dArr[0] - dArr[i4];
        dArr2[0] = d5 - d4;
        dArr2[i10] = d5 + d4;
        if (i4 > 2) {
            int i11 = i10 >> 1;
            for (int i12 = 1; i12 < i11; i12++) {
                int i13 = i10 - i12;
                int i14 = i4 - i12;
                double d6 = dArr[i12] - dArr[i14];
                double d7 = dArr[i12] + dArr[i14];
                int i15 = i4 - i13;
                double d8 = dArr[i13] - dArr[i15];
                double d9 = dArr[i13] + dArr[i15];
                dArr[i12] = d6;
                dArr[i13] = d8;
                dArr2[i12] = d7 - d9;
                dArr2[i13] = d7 + d9;
            }
            int i16 = i4 - i11;
            dArr2[i11] = dArr[i11] + dArr[i16];
            dArr[i11] = dArr[i11] - dArr[i16];
            A(i10, dArr, i9, dArr3, i7);
            if (i10 > 4) {
                i5 = 4;
                s(i10, dArr, iArr, 2, i7, dArr3);
                K(i10, dArr, i9, dArr3, i7);
            } else {
                i5 = 4;
                if (i10 == 4) {
                    s(i10, dArr, iArr, 2, i7, dArr3);
                }
            }
            dArr[i4 - 1] = dArr[0] - dArr[1];
            dArr[1] = dArr[0] + dArr[1];
            for (int i17 = i10 - 2; i17 >= 2; i17 -= 2) {
                int i18 = i17 * 2;
                int i19 = i17 + 1;
                dArr[i18 + 1] = dArr[i17] + dArr[i19];
                dArr[i18 - 1] = dArr[i17] - dArr[i19];
            }
            int i20 = i11;
            int i21 = 2;
            for (int i22 = 2; i20 >= i22; i22 = 2) {
                A(i20, dArr2, i9, dArr3, i7);
                if (i20 > i5) {
                    int i23 = i20;
                    s(i23, dArr2, iArr, 2, i7, dArr3);
                    K(i23, dArr2, i9, dArr3, i7);
                } else if (i20 == i5) {
                    s(i20, dArr2, iArr, 2, i7, dArr3);
                }
                dArr[i4 - i21] = dArr2[0] - dArr2[1];
                dArr[i21] = dArr2[0] + dArr2[1];
                int i24 = 0;
                for (int i25 = 2; i25 < i20; i25 += 2) {
                    i24 += i21 << 2;
                    int i26 = i25 + 1;
                    dArr[i24 - i21] = dArr2[i25] - dArr2[i26];
                    dArr[i24 + i21] = dArr2[i25] + dArr2[i26];
                }
                i21 <<= 1;
                int i27 = i20 >> 1;
                for (int i28 = 0; i28 < i27; i28++) {
                    int i29 = i20 - i28;
                    int i30 = i20 + i29;
                    int i31 = i20 + i28;
                    dArr2[i28] = dArr2[i30] - dArr2[i31];
                    dArr2[i29] = dArr2[i30] + dArr2[i31];
                }
                dArr2[i27] = dArr2[i20 + i27];
                i20 = i27;
            }
            dArr[i21] = dArr2[0];
            dArr[i4] = dArr2[2] - dArr2[1];
            dArr[0] = dArr2[2] + dArr2[1];
            return;
        }
        dArr[1] = dArr[0];
        dArr[2] = dArr2[0];
        dArr[0] = dArr2[1];
    }

    public void E(int i4, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        char c4;
        int i5;
        int i6;
        int i7 = iArr[0];
        if (i4 > (i7 << 3)) {
            i7 = i4 >> 3;
            H(i7, iArr, dArr3);
        }
        int i8 = i7;
        int i9 = iArr[1];
        if (i4 > (i9 << 1)) {
            i9 = i4 >> 1;
            G(i9, iArr, dArr3, i8);
        }
        int i10 = i9;
        if (i4 > 2) {
            int i11 = i4 >> 1;
            int i12 = i11 >> 1;
            for (int i13 = 1; i13 < i12; i13++) {
                int i14 = i11 - i13;
                int i15 = i4 - i13;
                double d4 = dArr[i13] + dArr[i15];
                double d5 = dArr[i13] - dArr[i15];
                int i16 = i4 - i14;
                double d6 = dArr[i14] + dArr[i16];
                double d7 = dArr[i14] - dArr[i16];
                dArr[i13] = d4;
                dArr[i14] = d6;
                dArr2[i13] = d5 + d7;
                dArr2[i14] = d5 - d7;
            }
            int i17 = i4 - i12;
            dArr2[0] = dArr[i12] - dArr[i17];
            dArr[i12] = dArr[i12] + dArr[i17];
            dArr[0] = dArr[i11];
            F(i11, dArr, i10, dArr3, i8);
            if (i11 > 4) {
                i5 = 4;
                i6 = i11;
                s(i11, dArr, iArr, 2, i8, dArr3);
                K(i6, dArr, i10, dArr3, i8);
            } else {
                i5 = 4;
                if (i11 == 4) {
                    i6 = i11;
                    s(i11, dArr, iArr, 2, i8, dArr3);
                } else {
                    i6 = i11;
                }
            }
            dArr[i4 - 1] = dArr[1] - dArr[0];
            dArr[1] = dArr[0] + dArr[1];
            int i18 = i6 - 2;
            for (int i19 = 2; i18 >= i19; i19 = 2) {
                int i20 = i18 * 2;
                int i21 = i18 + 1;
                dArr[i20 + 1] = dArr[i18] - dArr[i21];
                dArr[i20 - 1] = (-dArr[i18]) - dArr[i21];
                i18 -= 2;
            }
            int i22 = i12;
            int i23 = 2;
            for (int i24 = 2; i22 >= i24; i24 = 2) {
                int i25 = i22;
                F(i22, dArr2, i10, dArr3, i8);
                if (i25 > i5) {
                    s(i25, dArr2, iArr, 2, i8, dArr3);
                    K(i25, dArr2, i10, dArr3, i8);
                } else if (i25 == i5) {
                    s(i25, dArr2, iArr, 2, i8, dArr3);
                }
                dArr[i4 - i23] = dArr2[1] - dArr2[0];
                dArr[i23] = dArr2[0] + dArr2[1];
                int i26 = 0;
                for (int i27 = 2; i27 < i25; i27 += 2) {
                    i26 += i23 << 2;
                    int i28 = i27 + 1;
                    dArr[i26 - i23] = (-dArr2[i27]) - dArr2[i28];
                    dArr[i26 + i23] = dArr2[i27] - dArr2[i28];
                }
                i23 <<= 1;
                i22 = i25 >> 1;
                for (int i29 = 1; i29 < i22; i29++) {
                    int i30 = i25 - i29;
                    int i31 = i25 + i30;
                    int i32 = i25 + i29;
                    dArr2[i29] = dArr2[i31] + dArr2[i32];
                    dArr2[i30] = dArr2[i31] - dArr2[i32];
                }
                dArr2[0] = dArr2[i25 + i22];
            }
            c4 = 0;
            dArr[i23] = dArr2[0];
        } else {
            c4 = 0;
        }
        dArr[c4] = 0.0d;
    }

    public void I(int i4, int i5, double[] dArr, int[] iArr, double[] dArr2) {
        int i6 = iArr[0];
        if (i4 > (i6 << 2)) {
            i6 = i4 >> 2;
            H(i6, iArr, dArr2);
        }
        int i7 = i6;
        int i8 = iArr[1];
        if (i4 > (i8 << 2)) {
            i8 = i4 >> 2;
            G(i8, iArr, dArr2, i7);
        }
        int i9 = i8;
        if (i5 >= 0) {
            if (i4 > 4) {
                s(i4, dArr, iArr, 2, i7, dArr2);
                K(i4, dArr, i9, dArr2, i7);
            } else if (i4 == 4) {
                s(i4, dArr, iArr, 2, i7, dArr2);
            }
            double d4 = dArr[0] - dArr[1];
            dArr[0] = dArr[0] + dArr[1];
            dArr[1] = d4;
            return;
        }
        dArr[1] = (dArr[0] - dArr[1]) * 0.5d;
        dArr[0] = dArr[0] - dArr[1];
        if (i4 > 4) {
            J(i4, dArr, i9, dArr2, i7);
            j(i4, dArr, iArr, 2, i7, dArr2);
        } else if (i4 == 4) {
            j(i4, dArr, iArr, 2, i7, dArr2);
        }
    }

    public void g(int i4, int i5, double[] dArr, int[] iArr, double[] dArr2) {
        int i6 = iArr[0];
        if (i4 > (i6 << 2)) {
            i6 = i4 >> 2;
            H(i6, iArr, dArr2);
        }
        int i7 = i6;
        if (i5 >= 0) {
            s(i4, dArr, iArr, 2, i7, dArr2);
        } else {
            j(i4, dArr, iArr, 2, i7, dArr2);
        }
    }
}

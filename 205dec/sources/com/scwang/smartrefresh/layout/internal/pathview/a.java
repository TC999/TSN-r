package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Matrix;
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathParser.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48049a = "PathParser";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: PathParser.java */
    /* renamed from: com.scwang.smartrefresh.layout.internal.pathview.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C0933a {

        /* renamed from: a  reason: collision with root package name */
        int f48050a;

        /* renamed from: b  reason: collision with root package name */
        boolean f48051b;

        C0933a() {
        }
    }

    a() {
    }

    private static void a(ArrayList<b> arrayList, char c4, float[] fArr) {
        arrayList.add(new b(c4, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < bVarArr.length; i4++) {
            if (bVarArr[i4].f48052a != bVarArr2[i4].f48052a || bVarArr[i4].f48053b.length != bVarArr2[i4].f48053b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i4, int i5) {
        if (i4 <= i5) {
            int length = fArr.length;
            if (i4 >= 0 && i4 <= length) {
                int i6 = i5 - i4;
                int min = Math.min(i6, length - i4);
                float[] fArr2 = new float[i6];
                System.arraycopy(fArr, i4, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 1;
        int i5 = 0;
        while (i4 < str.length()) {
            int i6 = i(str, i4);
            String trim = str.substring(i5, i6).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i5 = i6;
            i4 = i6 + 1;
        }
        if (i4 - i5 == 1 && i5 < str.length()) {
            a(arrayList, str.charAt(i5), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d4 = d(str);
        if (d4 != null) {
            try {
                b.e(d4, path);
                return path;
            } catch (RuntimeException e4) {
                throw new RuntimeException("Error in parsing " + str, e4);
            }
        }
        return null;
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i4 = 0; i4 < bVarArr.length; i4++) {
            bVarArr2[i4] = new b(bVarArr[i4]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(java.lang.String r8, int r9, com.scwang.smartrefresh.layout.internal.pathview.a.C0933a r10) {
        /*
            r0 = 0
            r10.f48051b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L37
        L27:
            r10.f48051b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f48051b = r7
            goto L35
        L31:
            r2 = 0
            goto L37
        L33:
            r2 = 1
            goto L37
        L35:
            r2 = 0
            r4 = 1
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.f48050a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.internal.pathview.a.g(java.lang.String, int, com.scwang.smartrefresh.layout.internal.pathview.a$a):void");
    }

    private static float[] h(String str) {
        int i4 = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            C0933a c0933a = new C0933a();
            int length = str.length();
            int i5 = 0;
            while (i4 < length) {
                g(str, i4, c0933a);
                int i6 = c0933a.f48050a;
                if (i4 < i6) {
                    fArr[i5] = Float.parseFloat(str.substring(i4, i6));
                    i5++;
                }
                i4 = c0933a.f48051b ? i6 : i6 + 1;
            }
            return c(fArr, 0, i5);
        } catch (NumberFormatException e4) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e4);
        }
    }

    private static int i(String str, int i4) {
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i4;
            }
            i4++;
        }
        return i4;
    }

    public static List<Path> j(float f4, float f5, List<Path> list, List<String> list2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f5);
        ArrayList arrayList = new ArrayList();
        for (Path path : list) {
            Path path2 = new Path();
            path.transform(matrix, path2);
            arrayList.add(path2);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r20 == 's') goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(float r18, float r19, char r20, float[] r21) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.internal.pathview.a.k(float, float, char, float[]):void");
    }

    private static void l(float f4, float f5, b[] bVarArr) {
        for (int i4 = 0; i4 < bVarArr.length; i4++) {
            k(f4, f5, bVarArr[i4].f48052a, bVarArr[i4].f48053b);
        }
    }

    public static void m(b[] bVarArr, b[] bVarArr2) {
        for (int i4 = 0; i4 < bVarArr2.length; i4++) {
            bVarArr[i4].f48052a = bVarArr2[i4].f48052a;
            for (int i5 = 0; i5 < bVarArr2[i4].f48053b.length; i5++) {
                bVarArr[i4].f48053b[i5] = bVarArr2[i4].f48053b[i5];
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: PathParser.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        char f48052a;

        /* renamed from: b  reason: collision with root package name */
        float[] f48053b;

        b(char c4, float[] fArr) {
            this.f48052a = c4;
            this.f48053b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c4, char c5, float[] fArr2) {
            int i4;
            int i5;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            char c6 = c5;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i4 = 7;
                    break;
                case 'C':
                case 'c':
                    i4 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i4 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i4 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i4 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    i4 = 2;
                    break;
            }
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i6 = 0;
            char c7 = c4;
            while (i6 < fArr2.length) {
                if (c6 != 'A') {
                    if (c6 == 'C') {
                        i5 = i6;
                        int i7 = i5 + 2;
                        int i8 = i5 + 3;
                        int i9 = i5 + 4;
                        int i10 = i5 + 5;
                        path.cubicTo(fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                        f18 = fArr2[i9];
                        float f22 = fArr2[i10];
                        float f23 = fArr2[i7];
                        float f24 = fArr2[i8];
                        f19 = f22;
                        f15 = f24;
                        f14 = f23;
                    } else if (c6 == 'H') {
                        i5 = i6;
                        int i11 = i5 + 0;
                        path.lineTo(fArr2[i11], f19);
                        f18 = fArr2[i11];
                    } else if (c6 == 'Q') {
                        i5 = i6;
                        int i12 = i5 + 0;
                        int i13 = i5 + 1;
                        int i14 = i5 + 2;
                        int i15 = i5 + 3;
                        path.quadTo(fArr2[i12], fArr2[i13], fArr2[i14], fArr2[i15]);
                        float f25 = fArr2[i12];
                        float f26 = fArr2[i13];
                        f18 = fArr2[i14];
                        f19 = fArr2[i15];
                        f14 = f25;
                        f15 = f26;
                    } else if (c6 == 'V') {
                        i5 = i6;
                        int i16 = i5 + 0;
                        path.lineTo(f18, fArr2[i16]);
                        f19 = fArr2[i16];
                    } else if (c6 != 'a') {
                        if (c6 != 'c') {
                            if (c6 == 'h') {
                                int i17 = i6 + 0;
                                path.rLineTo(fArr2[i17], 0.0f);
                                f18 += fArr2[i17];
                            } else if (c6 != 'q') {
                                if (c6 == 'v') {
                                    int i18 = i6 + 0;
                                    path.rLineTo(0.0f, fArr2[i18]);
                                    f7 = fArr2[i18];
                                } else if (c6 == 'L') {
                                    int i19 = i6 + 0;
                                    int i20 = i6 + 1;
                                    path.lineTo(fArr2[i19], fArr2[i20]);
                                    f18 = fArr2[i19];
                                    f19 = fArr2[i20];
                                } else if (c6 == 'M') {
                                    int i21 = i6 + 0;
                                    f18 = fArr2[i21];
                                    int i22 = i6 + 1;
                                    f19 = fArr2[i22];
                                    if (i6 > 0) {
                                        path.lineTo(fArr2[i21], fArr2[i22]);
                                    } else {
                                        path.moveTo(fArr2[i21], fArr2[i22]);
                                        i5 = i6;
                                        f21 = f19;
                                        f20 = f18;
                                    }
                                } else if (c6 == 'S') {
                                    if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                        f18 = (f18 * 2.0f) - f14;
                                        f19 = (f19 * 2.0f) - f15;
                                    }
                                    float f27 = f19;
                                    int i23 = i6 + 0;
                                    int i24 = i6 + 1;
                                    int i25 = i6 + 2;
                                    int i26 = i6 + 3;
                                    path.cubicTo(f18, f27, fArr2[i23], fArr2[i24], fArr2[i25], fArr2[i26]);
                                    f4 = fArr2[i23];
                                    f5 = fArr2[i24];
                                    f18 = fArr2[i25];
                                    f19 = fArr2[i26];
                                    f14 = f4;
                                    f15 = f5;
                                } else if (c6 == 'T') {
                                    if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                        f18 = (f18 * 2.0f) - f14;
                                        f19 = (f19 * 2.0f) - f15;
                                    }
                                    int i27 = i6 + 0;
                                    int i28 = i6 + 1;
                                    path.quadTo(f18, f19, fArr2[i27], fArr2[i28]);
                                    float f28 = fArr2[i27];
                                    float f29 = fArr2[i28];
                                    i5 = i6;
                                    f15 = f19;
                                    f14 = f18;
                                    f18 = f28;
                                    f19 = f29;
                                } else if (c6 == 'l') {
                                    int i29 = i6 + 0;
                                    int i30 = i6 + 1;
                                    path.rLineTo(fArr2[i29], fArr2[i30]);
                                    f18 += fArr2[i29];
                                    f7 = fArr2[i30];
                                } else if (c6 == 'm') {
                                    int i31 = i6 + 0;
                                    f18 += fArr2[i31];
                                    int i32 = i6 + 1;
                                    f19 += fArr2[i32];
                                    if (i6 > 0) {
                                        path.rLineTo(fArr2[i31], fArr2[i32]);
                                    } else {
                                        path.rMoveTo(fArr2[i31], fArr2[i32]);
                                        i5 = i6;
                                        f21 = f19;
                                        f20 = f18;
                                    }
                                } else if (c6 == 's') {
                                    if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                        float f30 = f18 - f14;
                                        f8 = f19 - f15;
                                        f9 = f30;
                                    } else {
                                        f9 = 0.0f;
                                        f8 = 0.0f;
                                    }
                                    int i33 = i6 + 0;
                                    int i34 = i6 + 1;
                                    int i35 = i6 + 2;
                                    int i36 = i6 + 3;
                                    path.rCubicTo(f9, f8, fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                                    f4 = fArr2[i33] + f18;
                                    f5 = fArr2[i34] + f19;
                                    f18 += fArr2[i35];
                                    f6 = fArr2[i36];
                                } else if (c6 == 't') {
                                    if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                        f10 = f18 - f14;
                                        f11 = f19 - f15;
                                    } else {
                                        f11 = 0.0f;
                                        f10 = 0.0f;
                                    }
                                    int i37 = i6 + 0;
                                    int i38 = i6 + 1;
                                    path.rQuadTo(f10, f11, fArr2[i37], fArr2[i38]);
                                    float f31 = f10 + f18;
                                    float f32 = f11 + f19;
                                    f18 += fArr2[i37];
                                    f19 += fArr2[i38];
                                    f15 = f32;
                                    f14 = f31;
                                }
                                f19 += f7;
                            } else {
                                int i39 = i6 + 0;
                                int i40 = i6 + 1;
                                int i41 = i6 + 2;
                                int i42 = i6 + 3;
                                path.rQuadTo(fArr2[i39], fArr2[i40], fArr2[i41], fArr2[i42]);
                                f4 = fArr2[i39] + f18;
                                f5 = fArr2[i40] + f19;
                                f18 += fArr2[i41];
                                f6 = fArr2[i42];
                            }
                            i5 = i6;
                        } else {
                            int i43 = i6 + 2;
                            int i44 = i6 + 3;
                            int i45 = i6 + 4;
                            int i46 = i6 + 5;
                            path.rCubicTo(fArr2[i6 + 0], fArr2[i6 + 1], fArr2[i43], fArr2[i44], fArr2[i45], fArr2[i46]);
                            f4 = fArr2[i43] + f18;
                            f5 = fArr2[i44] + f19;
                            f18 += fArr2[i45];
                            f6 = fArr2[i46];
                        }
                        f19 += f6;
                        f14 = f4;
                        f15 = f5;
                        i5 = i6;
                    } else {
                        int i47 = i6 + 5;
                        int i48 = i6 + 6;
                        i5 = i6;
                        c(path, f18, f19, fArr2[i47] + f18, fArr2[i48] + f19, fArr2[i6 + 0], fArr2[i6 + 1], fArr2[i6 + 2], fArr2[i6 + 3] != 0.0f, fArr2[i6 + 4] != 0.0f);
                        f18 += fArr2[i47];
                        f19 += fArr2[i48];
                    }
                    i6 = i5 + i4;
                    c7 = c5;
                    c6 = c7;
                } else {
                    i5 = i6;
                    int i49 = i5 + 5;
                    int i50 = i5 + 6;
                    c(path, f18, f19, fArr2[i49], fArr2[i50], fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f, fArr2[i5 + 4] != 0.0f);
                    f18 = fArr2[i49];
                    f19 = fArr2[i50];
                }
                f15 = f19;
                f14 = f18;
                i6 = i5 + i4;
                c7 = c5;
                c6 = c7;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        private static void b(Path path, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
            double d13 = d6;
            int ceil = (int) Math.ceil(Math.abs((d12 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d10);
            double sin = Math.sin(d10);
            double cos2 = Math.cos(d11);
            double sin2 = Math.sin(d11);
            double d14 = -d13;
            double d15 = d14 * cos;
            double d16 = d7 * sin;
            double d17 = (d15 * sin2) - (d16 * cos2);
            double d18 = d14 * sin;
            double d19 = d7 * cos;
            double d20 = (sin2 * d18) + (cos2 * d19);
            double d21 = ceil;
            Double.isNaN(d21);
            double d22 = d12 / d21;
            double d23 = d11;
            double d24 = d20;
            double d25 = d17;
            int i4 = 0;
            double d26 = d8;
            double d27 = d9;
            while (i4 < ceil) {
                double d28 = d23 + d22;
                double sin3 = Math.sin(d28);
                double cos3 = Math.cos(d28);
                double d29 = (d4 + ((d13 * cos) * cos3)) - (d16 * sin3);
                double d30 = d5 + (d13 * sin * cos3) + (d19 * sin3);
                double d31 = (d15 * sin3) - (d16 * cos3);
                double d32 = (sin3 * d18) + (cos3 * d19);
                double d33 = d28 - d23;
                double tan = Math.tan(d33 / 2.0d);
                double sin4 = (Math.sin(d33) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d34 = d26 + (d25 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d34, (float) (d27 + (d24 * sin4)), (float) (d29 - (sin4 * d31)), (float) (d30 - (sin4 * d32)), (float) d29, (float) d30);
                i4++;
                d22 = d22;
                sin = sin;
                d26 = d29;
                d18 = d18;
                cos = cos;
                d23 = d28;
                d24 = d32;
                d25 = d31;
                ceil = ceil;
                d27 = d30;
                d13 = d6;
            }
        }

        private static void c(Path path, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z3, boolean z4) {
            double d4;
            double d5;
            double radians = Math.toRadians(f10);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d6 = f4;
            Double.isNaN(d6);
            double d7 = d6 * cos;
            double d8 = f5;
            Double.isNaN(d8);
            double d9 = f8;
            Double.isNaN(d9);
            double d10 = (d7 + (d8 * sin)) / d9;
            double d11 = -f4;
            Double.isNaN(d11);
            Double.isNaN(d8);
            double d12 = f9;
            Double.isNaN(d12);
            double d13 = ((d11 * sin) + (d8 * cos)) / d12;
            double d14 = f6;
            Double.isNaN(d14);
            double d15 = f7;
            Double.isNaN(d15);
            Double.isNaN(d9);
            double d16 = ((d14 * cos) + (d15 * sin)) / d9;
            double d17 = -f6;
            Double.isNaN(d17);
            Double.isNaN(d15);
            Double.isNaN(d12);
            double d18 = ((d17 * sin) + (d15 * cos)) / d12;
            double d19 = d10 - d16;
            double d20 = d13 - d18;
            double d21 = (d10 + d16) / 2.0d;
            double d22 = (d13 + d18) / 2.0d;
            double d23 = (d19 * d19) + (d20 * d20);
            if (d23 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d23);
                float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
                c(path, f4, f5, f6, f7, f8 * sqrt, f9 * sqrt, f10, z3, z4);
                return;
            }
            double sqrt2 = Math.sqrt(d24);
            double d25 = d19 * sqrt2;
            double d26 = sqrt2 * d20;
            if (z3 == z4) {
                d4 = d21 - d26;
                d5 = d22 + d25;
            } else {
                d4 = d21 + d26;
                d5 = d22 - d25;
            }
            double atan2 = Math.atan2(d13 - d5, d10 - d4);
            double atan22 = Math.atan2(d18 - d5, d16 - d4) - atan2;
            if (z4 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d9);
            double d27 = d4 * d9;
            Double.isNaN(d12);
            double d28 = d5 * d12;
            b(path, (d27 * cos) - (d28 * sin), (d27 * sin) + (d28 * cos), d9, d12, d6, d8, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c4 = 'm';
            for (int i4 = 0; i4 < bVarArr.length; i4++) {
                a(path, fArr, c4, bVarArr[i4].f48052a, bVarArr[i4].f48053b);
                c4 = bVarArr[i4].f48052a;
            }
        }

        public void d(b bVar, b bVar2, float f4) {
            int i4 = 0;
            while (true) {
                float[] fArr = bVar.f48053b;
                if (i4 >= fArr.length) {
                    return;
                }
                this.f48053b[i4] = (fArr[i4] * (1.0f - f4)) + (bVar2.f48053b[i4] * f4);
                i4++;
            }
        }

        b(b bVar) {
            this.f48052a = bVar.f48052a;
            float[] fArr = bVar.f48053b;
            this.f48053b = a.c(fArr, 0, fArr.length);
        }
    }
}

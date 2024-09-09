package com.qq.e.dl.l.i;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Shader a(java.lang.Object[] r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.dl.l.i.c.a(java.lang.Object[], int, int):android.graphics.Shader");
    }

    private static float[] a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[4];
        float f4 = fArr[0] % 360.0f;
        int i4 = (int) (f4 / 90.0f);
        float f5 = f4 % 90.0f;
        if (f5 == 0.0f) {
            return a(fArr2, fArr3, i4);
        }
        return a(fArr2, fArr3, f5, i4);
    }

    private static float[] a(float[] fArr) {
        int length;
        if (fArr == null || (length = fArr.length) < 2) {
            return fArr;
        }
        float f4 = fArr[0];
        float f5 = fArr[length - 1];
        if (f4 < 0.0f || f4 > 1.0f || f5 < 0.0f || f5 > 1.0f) {
            float min = Math.min(Math.min(f4, f5), 0.0f);
            float max = Math.max(Math.max(f4, f5), 1.0f) - min;
            if (max <= 0.0f) {
                return fArr;
            }
            float[] fArr2 = new float[length];
            for (int i4 = 0; i4 < length; i4++) {
                fArr2[i4] = (fArr[i4] - min) / max;
            }
            return fArr2;
        }
        return fArr;
    }

    private static float[] a(float[] fArr, float[] fArr2, float f4, int i4) {
        int i5 = i4 % 4;
        double d4 = (i5 == 1 || i5 == 3) ? 90.0f - f4 : f4;
        Double.isNaN(d4);
        double d5 = (float) ((d4 / 180.0d) * 3.141592653589793d);
        double sin = Math.sin(d5);
        double cos = Math.cos(d5);
        double tan = Math.tan(d5);
        double d6 = 0.5f;
        Double.isNaN(d6);
        Double.isNaN(d6);
        float f5 = (float) (d6 / cos);
        double d7 = 0.5f - ((float) (tan * d6));
        Double.isNaN(d7);
        double d8 = f5 + ((float) (d7 * sin));
        Double.isNaN(d8);
        Double.isNaN(d8);
        float f6 = ((float) (d8 * sin)) / 1.0f;
        float f7 = ((float) (d8 * cos)) / 1.0f;
        if (i4 == 0) {
            fArr2[0] = 0.5f - f6;
            fArr2[1] = f7 + 0.5f;
            fArr2[2] = f6 + 0.5f;
            fArr2[3] = 0.5f - f7;
        } else if (i4 == 1) {
            fArr2[0] = 0.5f - f6;
            fArr2[1] = 0.5f - f7;
            fArr2[2] = f6 + 0.5f;
            fArr2[3] = f7 + 0.5f;
        } else if (i4 == 2) {
            fArr2[0] = f6 + 0.5f;
            fArr2[1] = 0.5f - f7;
            fArr2[2] = 0.5f - f6;
            fArr2[3] = f7 + 0.5f;
        } else {
            fArr2[0] = f6 + 0.5f;
            fArr2[1] = f7 + 0.5f;
            fArr2[2] = 0.5f - f6;
            fArr2[3] = 0.5f - f7;
        }
        if (fArr != null && fArr.length >= 2) {
            float f8 = fArr[0];
            float f9 = fArr[fArr.length - 1];
            float min = Math.min(f8, f9);
            float max = Math.max(f8, f9);
            double abs = Math.abs(fArr2[0] - fArr2[2]) * 1.0f;
            Double.isNaN(abs);
            float f10 = (float) (abs / sin);
            if (min < 0.0f) {
                double abs2 = Math.abs(min) * f10;
                Double.isNaN(abs2);
                float f11 = ((float) (abs2 * sin)) / 1.0f;
                Double.isNaN(abs2);
                float f12 = ((float) (abs2 * cos)) / 1.0f;
                if (i4 == 0) {
                    fArr2[0] = fArr2[0] - f11;
                    fArr2[1] = fArr2[1] + f12;
                } else if (i4 == 1) {
                    fArr2[0] = fArr2[0] - f11;
                    fArr2[1] = fArr2[1] - f12;
                } else if (i4 == 2) {
                    fArr2[0] = fArr2[0] + f11;
                    fArr2[1] = fArr2[1] - f12;
                } else if (i4 == 3) {
                    fArr2[0] = fArr2[0] + f11;
                    fArr2[1] = fArr2[1] + f12;
                }
            }
            if (max > 1.0f) {
                double d9 = f10 * (max - 1.0f);
                Double.isNaN(d9);
                float f13 = ((float) (sin * d9)) / 1.0f;
                Double.isNaN(d9);
                float f14 = ((float) (d9 * cos)) / 1.0f;
                if (i4 == 0) {
                    fArr2[2] = fArr2[2] + f13;
                    fArr2[3] = fArr2[3] - f14;
                } else if (i4 == 1) {
                    fArr2[2] = fArr2[2] + f13;
                    fArr2[3] = fArr2[3] + f14;
                } else if (i4 == 2) {
                    fArr2[2] = fArr2[2] - f13;
                    fArr2[3] = fArr2[3] + f14;
                } else if (i4 == 3) {
                    fArr2[2] = fArr2[2] - f13;
                    fArr2[3] = fArr2[3] - f14;
                }
            }
        }
        return fArr2;
    }

    private static float[] a(float[] fArr, float[] fArr2, int i4) {
        int i5 = i4 % 4;
        if (i5 == 0) {
            fArr2[0] = 0.0f;
            fArr2[1] = 1.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
        } else if (i5 == 1) {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 1.0f;
            fArr2[3] = 0.0f;
        } else if (i5 == 2) {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 1.0f;
        } else if (i5 == 3) {
            fArr2[0] = 1.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
        }
        if (fArr != null && fArr.length >= 2) {
            float f4 = fArr[0];
            float f5 = fArr[fArr.length - 1];
            float min = Math.min(f4, f5);
            float max = Math.max(f4, f5);
            if (min < 0.0f) {
                float abs = Math.abs(min);
                if (i5 == 0) {
                    fArr2[1] = abs + 1.0f;
                } else if (i5 == 1) {
                    fArr2[0] = 0.0f - abs;
                } else if (i5 == 2) {
                    fArr2[1] = 0.0f - abs;
                } else if (i5 == 3) {
                    fArr2[0] = abs + 1.0f;
                }
            }
            if (max > 1.0f) {
                float f6 = max - 1.0f;
                if (i5 == 0) {
                    fArr2[3] = 0.0f - f6;
                } else if (i5 == 1) {
                    fArr2[2] = f6 + 1.0f;
                } else if (i5 == 2) {
                    fArr2[3] = f6 + 1.0f;
                } else if (i5 == 3) {
                    fArr2[2] = 0.0f - f6;
                }
            }
        }
        return fArr2;
    }
}

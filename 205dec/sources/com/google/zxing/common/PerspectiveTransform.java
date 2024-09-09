package com.google.zxing.common;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.a11 = f4;
        this.a12 = f7;
        this.a13 = f10;
        this.a21 = f5;
        this.a22 = f8;
        this.a23 = f11;
        this.a31 = f6;
        this.a32 = f9;
        this.a33 = f12;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        return squareToQuadrilateral(f12, f13, f14, f15, f16, f17, f18, f19).times(quadrilateralToSquare(f4, f5, f6, f7, f8, f9, f10, f11));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        return squareToQuadrilateral(f4, f5, f6, f7, f8, f9, f10, f11).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = ((f4 - f6) + f8) - f10;
        float f13 = ((f5 - f7) + f9) - f11;
        if (f12 == 0.0f && f13 == 0.0f) {
            return new PerspectiveTransform(f6 - f4, f8 - f6, f4, f7 - f5, f9 - f7, f5, 0.0f, 0.0f, 1.0f);
        }
        float f14 = f6 - f8;
        float f15 = f10 - f8;
        float f16 = f7 - f9;
        float f17 = f11 - f9;
        float f18 = (f14 * f17) - (f15 * f16);
        float f19 = ((f17 * f12) - (f15 * f13)) / f18;
        float f20 = ((f14 * f13) - (f12 * f16)) / f18;
        return new PerspectiveTransform((f19 * f6) + (f6 - f4), (f20 * f10) + (f10 - f4), f4, (f7 - f5) + (f19 * f7), (f11 - f5) + (f20 * f11), f5, f19, f20, 1.0f);
    }

    PerspectiveTransform buildAdjoint() {
        float f4 = this.a22;
        float f5 = this.a33;
        float f6 = this.a23;
        float f7 = this.a32;
        float f8 = (f4 * f5) - (f6 * f7);
        float f9 = this.a31;
        float f10 = this.a21;
        float f11 = (f6 * f9) - (f10 * f5);
        float f12 = (f10 * f7) - (f4 * f9);
        float f13 = this.a13;
        float f14 = this.a12;
        float f15 = (f13 * f7) - (f14 * f5);
        float f16 = this.a11;
        return new PerspectiveTransform(f8, f11, f12, f15, (f5 * f16) - (f13 * f9), (f9 * f14) - (f7 * f16), (f14 * f6) - (f13 * f4), (f13 * f10) - (f6 * f16), (f16 * f4) - (f14 * f10));
    }

    PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        float f4 = this.a11;
        float f5 = perspectiveTransform.a11;
        float f6 = this.a21;
        float f7 = perspectiveTransform.a12;
        float f8 = this.a31;
        float f9 = perspectiveTransform.a13;
        float f10 = (f4 * f5) + (f6 * f7) + (f8 * f9);
        float f11 = perspectiveTransform.a21;
        float f12 = perspectiveTransform.a22;
        float f13 = perspectiveTransform.a23;
        float f14 = (f4 * f11) + (f6 * f12) + (f8 * f13);
        float f15 = perspectiveTransform.a31;
        float f16 = perspectiveTransform.a32;
        float f17 = perspectiveTransform.a33;
        float f18 = (f4 * f15) + (f6 * f16) + (f8 * f17);
        float f19 = this.a12;
        float f20 = this.a22;
        float f21 = this.a32;
        float f22 = (f21 * f17) + (f19 * f15) + (f20 * f16);
        float f23 = this.a13;
        float f24 = this.a23;
        float f25 = (f5 * f23) + (f7 * f24);
        float f26 = this.a33;
        return new PerspectiveTransform(f10, f14, f18, (f19 * f5) + (f20 * f7) + (f21 * f9), (f19 * f11) + (f20 * f12) + (f21 * f13), f22, (f9 * f26) + f25, (f11 * f23) + (f12 * f24) + (f13 * f26), (f23 * f15) + (f24 * f16) + (f26 * f17));
    }

    public void transformPoints(float[] fArr) {
        int length = fArr.length;
        float f4 = this.a11;
        float f5 = this.a12;
        float f6 = this.a13;
        float f7 = this.a21;
        float f8 = this.a22;
        float f9 = this.a23;
        float f10 = this.a31;
        float f11 = this.a32;
        float f12 = this.a33;
        for (int i4 = 0; i4 < length; i4 += 2) {
            float f13 = fArr[i4];
            int i5 = i4 + 1;
            float f14 = fArr[i5];
            float f15 = (f6 * f13) + (f9 * f14) + f12;
            fArr[i4] = (((f4 * f13) + (f7 * f14)) + f10) / f15;
            fArr[i5] = (((f13 * f5) + (f14 * f8)) + f11) / f15;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            float f4 = fArr[i4];
            float f5 = fArr2[i4];
            float f6 = (this.a13 * f4) + (this.a23 * f5) + this.a33;
            fArr[i4] = (((this.a11 * f4) + (this.a21 * f5)) + this.a31) / f6;
            fArr2[i4] = (((this.a12 * f4) + (this.a22 * f5)) + this.a32) / f6;
        }
    }
}

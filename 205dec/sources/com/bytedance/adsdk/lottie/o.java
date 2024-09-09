package com.bytedance.adsdk.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class o implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f25692a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f25693b;

    o(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i4 = ((int) (length / 0.002f)) + 1;
        this.f25692a = new float[i4];
        this.f25693b = new float[i4];
        float[] fArr = new float[2];
        for (int i5 = 0; i5 < i4; i5++) {
            pathMeasure.getPosTan((i5 * length) / (i4 - 1), fArr, null);
            this.f25692a[i5] = fArr[0];
            this.f25693b[i5] = fArr[1];
        }
    }

    private static Path a(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f4, f5, f6, f7, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        int i4 = 0;
        int length = this.f25692a.length - 1;
        while (length - i4 > 1) {
            int i5 = (i4 + length) / 2;
            if (f4 < this.f25692a[i5]) {
                length = i5;
            } else {
                i4 = i5;
            }
        }
        float[] fArr = this.f25692a;
        float f5 = fArr[length] - fArr[i4];
        if (f5 == 0.0f) {
            return this.f25693b[i4];
        }
        float[] fArr2 = this.f25693b;
        float f6 = fArr2[i4];
        return f6 + (((f4 - fArr[i4]) / f5) * (fArr2[length] - f6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(float f4, float f5, float f6, float f7) {
        this(a(f4, f5, f6, f7));
    }
}

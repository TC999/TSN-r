package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(9)
@TargetApi(9)
/* renamed from: com.scwang.smartrefresh.header.flyrefresh.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class PathInterpolatorGingerbread implements Interpolator {

    /* renamed from: c */
    private static final float f33288c = 0.002f;

    /* renamed from: a */
    private final float[] f33289a;

    /* renamed from: b */
    private final float[] f33290b;

    public PathInterpolatorGingerbread(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / f33288c)) + 1;
        this.f33289a = new float[i];
        this.f33290b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.f33289a[i2] = fArr[0];
            this.f33290b[i2] = fArr[1];
        }
    }

    /* renamed from: a */
    private static Path m20112a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    /* renamed from: b */
    private static Path m20111b(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f33289a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f33289a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f33289a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f33290b[i];
        }
        float[] fArr2 = this.f33290b;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }

    public PathInterpolatorGingerbread(float f, float f2) {
        this(m20111b(f, f2));
    }

    public PathInterpolatorGingerbread(float f, float f2, float f3, float f4) {
        this(m20112a(f, f2, f3, f4));
    }
}

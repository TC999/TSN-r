package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathInterpolatorGingerbread.java */
@RequiresApi(9)
@TargetApi(9)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class d implements Interpolator {

    /* renamed from: c  reason: collision with root package name */
    private static final float f47696c = 0.002f;

    /* renamed from: a  reason: collision with root package name */
    private final float[] f47697a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f47698b;

    public d(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i4 = ((int) (length / 0.002f)) + 1;
        this.f47697a = new float[i4];
        this.f47698b = new float[i4];
        float[] fArr = new float[2];
        for (int i5 = 0; i5 < i4; i5++) {
            pathMeasure.getPosTan((i5 * length) / (i4 - 1), fArr, null);
            this.f47697a[i5] = fArr[0];
            this.f47698b[i5] = fArr[1];
        }
    }

    private static Path a(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f4, f5, f6, f7, 1.0f, 1.0f);
        return path;
    }

    private static Path b(float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f4, f5, 1.0f, 1.0f);
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
        int length = this.f47697a.length - 1;
        while (length - i4 > 1) {
            int i5 = (i4 + length) / 2;
            if (f4 < this.f47697a[i5]) {
                length = i5;
            } else {
                i4 = i5;
            }
        }
        float[] fArr = this.f47697a;
        float f5 = fArr[length] - fArr[i4];
        if (f5 == 0.0f) {
            return this.f47698b[i4];
        }
        float[] fArr2 = this.f47698b;
        float f6 = fArr2[i4];
        return f6 + (((f4 - fArr[i4]) / f5) * (fArr2[length] - f6));
    }

    public d(float f4, float f5) {
        this(b(f4, f5));
    }

    public d(float f4, float f5, float f6, float f7) {
        this(a(f4, f5, f6, f7));
    }
}

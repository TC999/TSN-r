package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i4 = ((int) (length / 0.002f)) + 1;
        this.mX = new float[i4];
        this.mY = new float[i4];
        float[] fArr = new float[2];
        for (int i5 = 0; i5 < i4; i5++) {
            pathMeasure.getPosTan((i5 * length) / (i4 - 1), fArr, null);
            this.mX[i5] = fArr[0];
            this.mY[i5] = fArr[1];
        }
    }

    private static Path createCubic(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f4, f5, f6, f7, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f4, float f5) {
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
        int length = this.mX.length - 1;
        while (length - i4 > 1) {
            int i5 = (i4 + length) / 2;
            if (f4 < this.mX[i5]) {
                length = i5;
            } else {
                i4 = i5;
            }
        }
        float[] fArr = this.mX;
        float f5 = fArr[length] - fArr[i4];
        if (f5 == 0.0f) {
            return this.mY[i4];
        }
        float[] fArr2 = this.mY;
        float f6 = fArr2[i4];
        return f6 + (((f4 - fArr[i4]) / f5) * (fArr2[length] - f6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathInterpolatorApi14(float f4, float f5) {
        this(createQuad(f4, f5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathInterpolatorApi14(float f4, float f5, float f6, float f7) {
        this(createCubic(f4, f5, f6, f7));
    }
}

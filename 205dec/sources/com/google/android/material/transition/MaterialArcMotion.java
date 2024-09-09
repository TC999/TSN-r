package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f4, float f5, float f6, float f7) {
        if (f5 > f7) {
            return new PointF(f6, f5);
        }
        return new PointF(f4, f7);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f4, f5);
        PointF controlPoint = getControlPoint(f4, f5, f6, f7);
        path.quadTo(controlPoint.x, controlPoint.y, f6, f7);
        return path;
    }
}

package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f4) {
        this.radius = f4 - 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        double d4 = this.radius;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d4);
        float f7 = (float) ((d4 * sqrt) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(f7, 2.0d));
        double d5 = this.radius;
        double sqrt3 = Math.sqrt(2.0d);
        Double.isNaN(d5);
        double d6 = d5 * sqrt3;
        double d7 = this.radius;
        Double.isNaN(d7);
        shapePath.reset(f5 - f7, ((float) (-(d6 - d7))) + sqrt2);
        double d8 = this.radius;
        double sqrt4 = Math.sqrt(2.0d);
        Double.isNaN(d8);
        double d9 = d8 * sqrt4;
        double d10 = this.radius;
        Double.isNaN(d10);
        shapePath.lineTo(f5, (float) (-(d9 - d10)));
        double d11 = this.radius;
        double sqrt5 = Math.sqrt(2.0d);
        Double.isNaN(d11);
        double d12 = d11 * sqrt5;
        double d13 = this.radius;
        Double.isNaN(d13);
        shapePath.lineTo(f5 + f7, ((float) (-(d12 - d13))) + sqrt2);
    }
}

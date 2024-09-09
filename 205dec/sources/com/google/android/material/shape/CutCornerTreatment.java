package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f4, float f5, float f6) {
        shapePath.reset(0.0f, f6 * f5, 180.0f, 180.0f - f4);
        double sin = Math.sin(Math.toRadians(f4));
        double d4 = f6;
        Double.isNaN(d4);
        double d5 = f5;
        Double.isNaN(d5);
        double sin2 = Math.sin(Math.toRadians(90.0f - f4));
        Double.isNaN(d4);
        Double.isNaN(d5);
        shapePath.lineTo((float) (sin * d4 * d5), (float) (sin2 * d4 * d5));
    }

    @Deprecated
    public CutCornerTreatment(float f4) {
        this.size = f4;
    }
}

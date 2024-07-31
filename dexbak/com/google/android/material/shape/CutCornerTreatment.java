package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double sin = Math.sin(Math.toRadians(f));
        double d = f3;
        Double.isNaN(d);
        double d2 = f2;
        Double.isNaN(d2);
        double sin2 = Math.sin(Math.toRadians(90.0f - f));
        Double.isNaN(d);
        Double.isNaN(d2);
        shapePath.lineTo((float) (sin * d * d2), (float) (sin2 * d * d2));
    }

    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }
}

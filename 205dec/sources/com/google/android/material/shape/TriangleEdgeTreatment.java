package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f4, boolean z3) {
        this.size = f4;
        this.inside = z3;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f5 - (this.size * f6), 0.0f);
        shapePath.lineTo(f5, (this.inside ? this.size : -this.size) * f6);
        shapePath.lineTo(f5 + (this.size * f6), 0.0f);
        shapePath.lineTo(f4, 0.0f);
    }
}

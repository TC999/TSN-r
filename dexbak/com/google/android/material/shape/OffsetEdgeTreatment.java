package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f) {
        this.other = edgeTreatment;
        this.offset = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        this.other.getEdgePath(f, f2 - this.offset, f3, shapePath);
    }
}

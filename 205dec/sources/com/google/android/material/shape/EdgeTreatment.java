package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class EdgeTreatment {
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f4, float f5, @NonNull ShapePath shapePath) {
        getEdgePath(f4, f4 / 2.0f, f5, shapePath);
    }

    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f4, 0.0f);
    }
}

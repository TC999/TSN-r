package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f4, float f5, float f6) {
        this.fabMargin = f4;
        this.roundedCornerRadius = f5;
        setCradleVerticalOffset(f6);
        this.horizontalOffset = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        float f7 = this.fabDiameter;
        if (f7 == 0.0f) {
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f8 = ((this.fabMargin * 2.0f) + f7) / 2.0f;
        float f9 = f6 * this.roundedCornerRadius;
        float f10 = f5 + this.horizontalOffset;
        float f11 = (this.cradleVerticalOffset * f6) + ((1.0f - f6) * f8);
        if (f11 / f8 >= 1.0f) {
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f12 = f8 + f9;
        float f13 = f11 + f9;
        float sqrt = (float) Math.sqrt((f12 * f12) - (f13 * f13));
        float f14 = f10 - sqrt;
        float f15 = f10 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f13));
        float f16 = 90.0f - degrees;
        shapePath.lineTo(f14, 0.0f);
        float f17 = f9 * 2.0f;
        shapePath.addArc(f14 - f9, 0.0f, f14 + f9, f17, 270.0f, degrees);
        shapePath.addArc(f10 - f8, (-f8) - f11, f10 + f8, f8 - f11, 180.0f - f16, (f16 * 2.0f) - 180.0f);
        shapePath.addArc(f15 - f9, 0.0f, f15 + f9, f17, 270.0f - degrees, degrees);
        shapePath.lineTo(f4, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f4) {
        if (f4 >= 0.0f) {
            this.cradleVerticalOffset = f4;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleMargin(float f4) {
        this.fabMargin = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f4) {
        this.roundedCornerRadius = f4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f4) {
        this.fabDiameter = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalOffset(float f4) {
        this.horizontalOffset = f4;
    }
}

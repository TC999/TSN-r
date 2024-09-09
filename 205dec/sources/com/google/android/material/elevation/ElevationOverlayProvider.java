package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(@NonNull Context context) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(context, R.attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    private boolean isThemeSurfaceColor(@ColorInt int i4) {
        return ColorUtils.setAlphaComponent(i4, 255) == this.colorSurface;
    }

    public int calculateOverlayAlpha(float f4) {
        return Math.round(calculateOverlayAlphaFraction(f4) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f4) {
        float f5 = this.displayDensity;
        if (f5 <= 0.0f || f4 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f4 / f5)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i4, float f4, @NonNull View view) {
        return compositeOverlay(i4, f4 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i4, float f4, @NonNull View view) {
        return compositeOverlayIfNeeded(i4, f4 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f4, @NonNull View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f4 + getParentAbsoluteElevation(view));
    }

    public float getParentAbsoluteElevation(@NonNull View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i4, float f4) {
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f4);
        return ColorUtils.setAlphaComponent(MaterialColors.layer(ColorUtils.setAlphaComponent(i4, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction), Color.alpha(i4));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i4, float f4) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(i4)) ? compositeOverlay(i4, f4) : i4;
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f4) {
        return compositeOverlayIfNeeded(this.colorSurface, f4);
    }
}

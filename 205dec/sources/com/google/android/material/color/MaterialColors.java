package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        return ColorUtils.setAlphaComponent(i4, (Color.alpha(i4) * i5) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i4) {
        return MaterialAttributes.resolveOrThrow(view, i4);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i4, @AttrRes int i5) {
        return layer(view, i4, i5, 1.0f);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i4, String str) {
        return MaterialAttributes.resolveOrThrow(context, i4, str);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i4, @AttrRes int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(getColor(view, i4), getColor(view, i5), f4);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i4, @ColorInt int i5) {
        return getColor(view.getContext(), i4, i5);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i4, @ColorInt int i5) {
        TypedValue resolve = MaterialAttributes.resolve(context, i4);
        return resolve != null ? resolve.data : i5;
    }

    @ColorInt
    public static int layer(@ColorInt int i4, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(i4, ColorUtils.setAlphaComponent(i5, Math.round(Color.alpha(i5) * f4)));
    }

    @ColorInt
    public static int layer(@ColorInt int i4, @ColorInt int i5) {
        return ColorUtils.compositeColors(i5, i4);
    }
}

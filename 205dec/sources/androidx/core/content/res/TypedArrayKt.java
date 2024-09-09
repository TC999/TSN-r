package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import d2.l;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TypedArray.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\f\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a.\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d*\u00020\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\b\u00a2\u0006\u0004\b \u0010!\u00a8\u0006\""}, d2 = {"Landroid/content/res/TypedArray;", "", "index", "Lkotlin/f1;", "checkAttribute", "", "getBooleanOrThrow", "getColorOrThrow", "Landroid/content/res/ColorStateList;", "getColorStateListOrThrow", "", "getDimensionOrThrow", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "Landroid/graphics/drawable/Drawable;", "getDrawableOrThrow", "getFloatOrThrow", "Landroid/graphics/Typeface;", "getFontOrThrow", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "", "getStringOrThrow", "", "getTextOrThrow", "", "getTextArrayOrThrow", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "R", "Lkotlin/Function1;", "block", "use", "(Landroid/content/res/TypedArray;Ld2/l;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(@NotNull TypedArray typedArray, @StyleableRes int i4) {
        if (!typedArray.hasValue(i4)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray getBooleanOrThrow, @StyleableRes int i4) {
        f0.q(getBooleanOrThrow, "$this$getBooleanOrThrow");
        checkAttribute(getBooleanOrThrow, i4);
        return getBooleanOrThrow.getBoolean(i4, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray getColorOrThrow, @StyleableRes int i4) {
        f0.q(getColorOrThrow, "$this$getColorOrThrow");
        checkAttribute(getColorOrThrow, i4);
        return getColorOrThrow.getColor(i4, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray getColorStateListOrThrow, @StyleableRes int i4) {
        f0.q(getColorStateListOrThrow, "$this$getColorStateListOrThrow");
        checkAttribute(getColorStateListOrThrow, i4);
        ColorStateList colorStateList = getColorStateListOrThrow.getColorStateList(i4);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray getDimensionOrThrow, @StyleableRes int i4) {
        f0.q(getDimensionOrThrow, "$this$getDimensionOrThrow");
        checkAttribute(getDimensionOrThrow, i4);
        return getDimensionOrThrow.getDimension(i4, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray getDimensionPixelOffsetOrThrow, @StyleableRes int i4) {
        f0.q(getDimensionPixelOffsetOrThrow, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(getDimensionPixelOffsetOrThrow, i4);
        return getDimensionPixelOffsetOrThrow.getDimensionPixelOffset(i4, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray getDimensionPixelSizeOrThrow, @StyleableRes int i4) {
        f0.q(getDimensionPixelSizeOrThrow, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(getDimensionPixelSizeOrThrow, i4);
        return getDimensionPixelSizeOrThrow.getDimensionPixelSize(i4, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray getDrawableOrThrow, @StyleableRes int i4) {
        f0.q(getDrawableOrThrow, "$this$getDrawableOrThrow");
        checkAttribute(getDrawableOrThrow, i4);
        Drawable drawable = getDrawableOrThrow.getDrawable(i4);
        if (drawable == null) {
            f0.L();
        }
        return drawable;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray getFloatOrThrow, @StyleableRes int i4) {
        f0.q(getFloatOrThrow, "$this$getFloatOrThrow");
        checkAttribute(getFloatOrThrow, i4);
        return getFloatOrThrow.getFloat(i4, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray getFontOrThrow, @StyleableRes int i4) {
        f0.q(getFontOrThrow, "$this$getFontOrThrow");
        checkAttribute(getFontOrThrow, i4);
        Typeface font = getFontOrThrow.getFont(i4);
        if (font == null) {
            f0.L();
        }
        return font;
    }

    public static final int getIntOrThrow(@NotNull TypedArray getIntOrThrow, @StyleableRes int i4) {
        f0.q(getIntOrThrow, "$this$getIntOrThrow");
        checkAttribute(getIntOrThrow, i4);
        return getIntOrThrow.getInt(i4, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray getIntegerOrThrow, @StyleableRes int i4) {
        f0.q(getIntegerOrThrow, "$this$getIntegerOrThrow");
        checkAttribute(getIntegerOrThrow, i4);
        return getIntegerOrThrow.getInteger(i4, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray getResourceIdOrThrow, @StyleableRes int i4) {
        f0.q(getResourceIdOrThrow, "$this$getResourceIdOrThrow");
        checkAttribute(getResourceIdOrThrow, i4);
        return getResourceIdOrThrow.getResourceId(i4, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray getStringOrThrow, @StyleableRes int i4) {
        f0.q(getStringOrThrow, "$this$getStringOrThrow");
        checkAttribute(getStringOrThrow, i4);
        String string = getStringOrThrow.getString(i4);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray getTextArrayOrThrow, @StyleableRes int i4) {
        f0.q(getTextArrayOrThrow, "$this$getTextArrayOrThrow");
        checkAttribute(getTextArrayOrThrow, i4);
        CharSequence[] textArray = getTextArrayOrThrow.getTextArray(i4);
        f0.h(textArray, "getTextArray(index)");
        return textArray;
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray getTextOrThrow, @StyleableRes int i4) {
        f0.q(getTextOrThrow, "$this$getTextOrThrow");
        checkAttribute(getTextOrThrow, i4);
        CharSequence text = getTextOrThrow.getText(i4);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@NotNull TypedArray use, @NotNull l<? super TypedArray, ? extends R> block) {
        f0.q(use, "$this$use");
        f0.q(block, "block");
        R invoke = block.invoke(use);
        use.recycle();
        return invoke;
    }
}

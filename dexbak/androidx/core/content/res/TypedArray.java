package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\f\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a.\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d*\u00020\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\b¢\u0006\u0004\b \u0010!¨\u0006\""}, m12616d2 = {"Landroid/content/res/TypedArray;", "", "index", "Lkotlin/f1;", "checkAttribute", "", "getBooleanOrThrow", "getColorOrThrow", "Landroid/content/res/ColorStateList;", "getColorStateListOrThrow", "", "getDimensionOrThrow", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "Landroid/graphics/drawable/Drawable;", "getDrawableOrThrow", "getFloatOrThrow", "Landroid/graphics/Typeface;", "getFontOrThrow", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "", "getStringOrThrow", "", "getTextOrThrow", "", "getTextArrayOrThrow", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "R", "Lkotlin/Function1;", "block", "use", "(Landroid/content/res/TypedArray;Ll1/l;)Ljava/lang/Object;", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.content.res.TypedArrayKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TypedArray {
    private static final void checkAttribute(@NotNull android.content.res.TypedArray typedArray, @StyleableRes int i) {
        if (!typedArray.hasValue(i)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull android.content.res.TypedArray getBooleanOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getBooleanOrThrow, "$this$getBooleanOrThrow");
        checkAttribute(getBooleanOrThrow, i);
        return getBooleanOrThrow.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull android.content.res.TypedArray getColorOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getColorOrThrow, "$this$getColorOrThrow");
        checkAttribute(getColorOrThrow, i);
        return getColorOrThrow.getColor(i, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull android.content.res.TypedArray getColorStateListOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getColorStateListOrThrow, "$this$getColorStateListOrThrow");
        checkAttribute(getColorStateListOrThrow, i);
        ColorStateList colorStateList = getColorStateListOrThrow.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@NotNull android.content.res.TypedArray getDimensionOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getDimensionOrThrow, "$this$getDimensionOrThrow");
        checkAttribute(getDimensionOrThrow, i);
        return getDimensionOrThrow.getDimension(i, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull android.content.res.TypedArray getDimensionPixelOffsetOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getDimensionPixelOffsetOrThrow, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(getDimensionPixelOffsetOrThrow, i);
        return getDimensionPixelOffsetOrThrow.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull android.content.res.TypedArray getDimensionPixelSizeOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getDimensionPixelSizeOrThrow, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(getDimensionPixelSizeOrThrow, i);
        return getDimensionPixelSizeOrThrow.getDimensionPixelSize(i, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull android.content.res.TypedArray getDrawableOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getDrawableOrThrow, "$this$getDrawableOrThrow");
        checkAttribute(getDrawableOrThrow, i);
        Drawable drawable = getDrawableOrThrow.getDrawable(i);
        if (drawable == null) {
            C14342f0.m8207L();
        }
        return drawable;
    }

    public static final float getFloatOrThrow(@NotNull android.content.res.TypedArray getFloatOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getFloatOrThrow, "$this$getFloatOrThrow");
        checkAttribute(getFloatOrThrow, i);
        return getFloatOrThrow.getFloat(i, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull android.content.res.TypedArray getFontOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getFontOrThrow, "$this$getFontOrThrow");
        checkAttribute(getFontOrThrow, i);
        Typeface font = getFontOrThrow.getFont(i);
        if (font == null) {
            C14342f0.m8207L();
        }
        return font;
    }

    public static final int getIntOrThrow(@NotNull android.content.res.TypedArray getIntOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getIntOrThrow, "$this$getIntOrThrow");
        checkAttribute(getIntOrThrow, i);
        return getIntOrThrow.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(@NotNull android.content.res.TypedArray getIntegerOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getIntegerOrThrow, "$this$getIntegerOrThrow");
        checkAttribute(getIntegerOrThrow, i);
        return getIntegerOrThrow.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull android.content.res.TypedArray getResourceIdOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getResourceIdOrThrow, "$this$getResourceIdOrThrow");
        checkAttribute(getResourceIdOrThrow, i);
        return getResourceIdOrThrow.getResourceId(i, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull android.content.res.TypedArray getStringOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getStringOrThrow, "$this$getStringOrThrow");
        checkAttribute(getStringOrThrow, i);
        String string = getStringOrThrow.getString(i);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull android.content.res.TypedArray getTextArrayOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getTextArrayOrThrow, "$this$getTextArrayOrThrow");
        checkAttribute(getTextArrayOrThrow, i);
        CharSequence[] textArray = getTextArrayOrThrow.getTextArray(i);
        C14342f0.m8192h(textArray, "getTextArray(index)");
        return textArray;
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull android.content.res.TypedArray getTextOrThrow, @StyleableRes int i) {
        C14342f0.m8183q(getTextOrThrow, "$this$getTextOrThrow");
        checkAttribute(getTextOrThrow, i);
        CharSequence text = getTextOrThrow.getText(i);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@NotNull android.content.res.TypedArray use, @NotNull InterfaceC15280l<? super android.content.res.TypedArray, ? extends R> block) {
        C14342f0.m8183q(use, "$this$use");
        C14342f0.m8183q(block, "block");
        R invoke = block.invoke(use);
        use.recycle();
        return invoke;
    }
}

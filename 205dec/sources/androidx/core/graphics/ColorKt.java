package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Color.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006\u00a8\u0006%"}, d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(@NotNull Color component1) {
        f0.q(component1, "$this$component1");
        return component1.getComponent(0);
    }

    public static final int component1(@ColorInt int i4) {
        return (i4 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(@NotNull Color component2) {
        f0.q(component2, "$this$component2");
        return component2.getComponent(1);
    }

    public static final int component2(@ColorInt int i4) {
        return (i4 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(@NotNull Color component3) {
        f0.q(component3, "$this$component3");
        return component3.getComponent(2);
    }

    public static final int component3(@ColorInt int i4) {
        return (i4 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(@NotNull Color component4) {
        f0.q(component4, "$this$component4");
        return component4.getComponent(3);
    }

    public static final int component4(@ColorInt int i4) {
        return i4 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i4, @NotNull ColorSpace.Named colorSpace) {
        f0.q(colorSpace, "colorSpace");
        return Color.convert(i4, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j4) {
        return Color.alpha(j4);
    }

    public static final int getAlpha(@ColorInt int i4) {
        return (i4 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j4) {
        return Color.blue(j4);
    }

    public static final int getBlue(@ColorInt int i4) {
        return i4 & 255;
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorSpace getColorSpace(long j4) {
        ColorSpace colorSpace = Color.colorSpace(j4);
        f0.h(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j4) {
        return Color.green(j4);
    }

    public static final int getGreen(@ColorInt int i4) {
        return (i4 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i4) {
        return Color.luminance(i4);
    }

    @RequiresApi(26)
    public static final float getRed(long j4) {
        return Color.red(j4);
    }

    public static final int getRed(@ColorInt int i4) {
        return (i4 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j4) {
        return Color.isSrgb(j4);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j4) {
        return Color.isWideGamut(j4);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color plus(@NotNull Color plus, @NotNull Color c4) {
        f0.q(plus, "$this$plus");
        f0.q(c4, "c");
        Color compositeColors = ColorUtils.compositeColors(c4, plus);
        f0.h(compositeColors, "ColorUtils.compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(@ColorInt int i4) {
        Color valueOf = Color.valueOf(i4);
        f0.h(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j4) {
        return Color.toArgb(j4);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i4) {
        return Color.pack(i4);
    }

    @RequiresApi(26)
    public static final float component1(long j4) {
        return Color.red(j4);
    }

    @RequiresApi(26)
    public static final float component2(long j4) {
        return Color.green(j4);
    }

    @RequiresApi(26)
    public static final float component3(long j4) {
        return Color.blue(j4);
    }

    @RequiresApi(26)
    public static final float component4(long j4) {
        return Color.alpha(j4);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i4, @NotNull ColorSpace colorSpace) {
        f0.q(colorSpace, "colorSpace");
        return Color.convert(i4, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j4) {
        return Color.luminance(j4);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(long j4) {
        Color valueOf = Color.valueOf(j4);
        f0.h(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String toColorInt) {
        f0.q(toColorInt, "$this$toColorInt");
        return Color.parseColor(toColorInt);
    }

    @RequiresApi(26)
    public static final long convertTo(long j4, @NotNull ColorSpace.Named colorSpace) {
        f0.q(colorSpace, "colorSpace");
        return Color.convert(j4, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final long convertTo(long j4, @NotNull ColorSpace colorSpace) {
        f0.q(colorSpace, "colorSpace");
        return Color.convert(j4, colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color convertTo, @NotNull ColorSpace.Named colorSpace) {
        f0.q(convertTo, "$this$convertTo");
        f0.q(colorSpace, "colorSpace");
        Color convert = convertTo.convert(ColorSpace.get(colorSpace));
        f0.h(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color convertTo, @NotNull ColorSpace colorSpace) {
        f0.q(convertTo, "$this$convertTo");
        f0.q(colorSpace, "colorSpace");
        Color convert = convertTo.convert(colorSpace);
        f0.h(convert, "convert(colorSpace)");
        return convert;
    }
}

package androidx.core.graphics;

import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, m12616d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.ColorKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Color {
    @RequiresApi(26)
    public static final float component1(@NotNull android.graphics.Color component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.getComponent(0);
    }

    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(@NotNull android.graphics.Color component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.getComponent(1);
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(@NotNull android.graphics.Color component3) {
        C14342f0.m8183q(component3, "$this$component3");
        return component3.getComponent(2);
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(@NotNull android.graphics.Color component4) {
        C14342f0.m8183q(component4, "$this$component4");
        return component4.getComponent(3);
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, @NotNull ColorSpace.Named colorSpace) {
        C14342f0.m8183q(colorSpace, "colorSpace");
        return android.graphics.Color.convert(i, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return android.graphics.Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return android.graphics.Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = android.graphics.Color.colorSpace(j);
        C14342f0.m8192h(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return android.graphics.Color.green(j);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return android.graphics.Color.luminance(i);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return android.graphics.Color.red(j);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return android.graphics.Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return android.graphics.Color.isWideGamut(j);
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.Color plus(@NotNull android.graphics.Color plus, @NotNull android.graphics.Color c) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(c, "c");
        android.graphics.Color compositeColors = ColorUtils.compositeColors(c, plus);
        C14342f0.m8192h(compositeColors, "ColorUtils.compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.Color toColor(@ColorInt int i) {
        android.graphics.Color valueOf = android.graphics.Color.valueOf(i);
        C14342f0.m8192h(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return android.graphics.Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return android.graphics.Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return android.graphics.Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return android.graphics.Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return android.graphics.Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return android.graphics.Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, @NotNull ColorSpace colorSpace) {
        C14342f0.m8183q(colorSpace, "colorSpace");
        return android.graphics.Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return android.graphics.Color.luminance(j);
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.Color toColor(long j) {
        android.graphics.Color valueOf = android.graphics.Color.valueOf(j);
        C14342f0.m8192h(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String toColorInt) {
        C14342f0.m8183q(toColorInt, "$this$toColorInt");
        return android.graphics.Color.parseColor(toColorInt);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, @NotNull ColorSpace.Named colorSpace) {
        C14342f0.m8183q(colorSpace, "colorSpace");
        return android.graphics.Color.convert(j, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, @NotNull ColorSpace colorSpace) {
        C14342f0.m8183q(colorSpace, "colorSpace");
        return android.graphics.Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.Color convertTo(@NotNull android.graphics.Color convertTo, @NotNull ColorSpace.Named colorSpace) {
        C14342f0.m8183q(convertTo, "$this$convertTo");
        C14342f0.m8183q(colorSpace, "colorSpace");
        android.graphics.Color convert = convertTo.convert(ColorSpace.get(colorSpace));
        C14342f0.m8192h(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.Color convertTo(@NotNull android.graphics.Color convertTo, @NotNull ColorSpace colorSpace) {
        C14342f0.m8183q(convertTo, "$this$convertTo");
        C14342f0.m8183q(colorSpace, "colorSpace");
        android.graphics.Color convert = convertTo.convert(colorSpace);
        C14342f0.m8192h(convert, "convert(colorSpace)");
        return convert;
    }
}

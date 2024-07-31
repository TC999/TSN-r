package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b\u001a\u001d\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0086\n\u001a'\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u0007H\u0086\n\u001a'\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a#\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0086\b\u001a7\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0087\b\u001a\u0015\u0010\u001a\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\n\u001a\u0015\u0010\u001a\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001bH\u0086\n¨\u0006\u001c"}, m12616d2 = {"Landroid/graphics/Bitmap;", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "applyCanvas", "", "x", "y", "get", "color", "set", "width", "height", "", "filter", "scale", "Landroid/graphics/Bitmap$Config;", "config", "createBitmap", "hasAlpha", "Landroid/graphics/ColorSpace;", "colorSpace", "Landroid/graphics/Point;", "p", "contains", "Landroid/graphics/PointF;", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.BitmapKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Bitmap {
    @NotNull
    public static final android.graphics.Bitmap applyCanvas(@NotNull android.graphics.Bitmap applyCanvas, @NotNull InterfaceC15280l<? super Canvas, Unit> block) {
        C14342f0.m8183q(applyCanvas, "$this$applyCanvas");
        C14342f0.m8183q(block, "block");
        block.invoke(new Canvas(applyCanvas));
        return applyCanvas;
    }

    public static final boolean contains(@NotNull android.graphics.Bitmap contains, @NotNull Point p) {
        int i;
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(p, "p");
        int i2 = p.x;
        return i2 >= 0 && i2 < contains.getWidth() && (i = p.y) >= 0 && i < contains.getHeight();
    }

    @NotNull
    public static final android.graphics.Bitmap createBitmap(int i, int i2, @NotNull Bitmap.Config config) {
        C14342f0.m8183q(config, "config");
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        C14342f0.m8192h(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        C14342f0.m8183q(config, "config");
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        C14342f0.m8192h(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(@NotNull android.graphics.Bitmap get, int i, int i2) {
        C14342f0.m8183q(get, "$this$get");
        return get.getPixel(i, i2);
    }

    @NotNull
    public static final android.graphics.Bitmap scale(@NotNull android.graphics.Bitmap scale, int i, int i2, boolean z) {
        C14342f0.m8183q(scale, "$this$scale");
        android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(scale, i, i2, z);
        C14342f0.m8192h(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap scale$default(android.graphics.Bitmap scale, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        C14342f0.m8183q(scale, "$this$scale");
        android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(scale, i, i2, z);
        C14342f0.m8192h(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@NotNull android.graphics.Bitmap set, int i, int i2, @ColorInt int i3) {
        C14342f0.m8183q(set, "$this$set");
        set.setPixel(i, i2, i3);
    }

    public static final boolean contains(@NotNull android.graphics.Bitmap contains, @NotNull PointF p) {
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(p, "p");
        float f = p.x;
        float f2 = 0;
        if (f < f2 || f >= contains.getWidth()) {
            return false;
        }
        float f3 = p.y;
        return f3 >= f2 && f3 < ((float) contains.getHeight());
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.Bitmap createBitmap(int i, int i2, @NotNull Bitmap.Config config, boolean z, @NotNull ColorSpace colorSpace) {
        C14342f0.m8183q(config, "config");
        C14342f0.m8183q(colorSpace, "colorSpace");
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config, z, colorSpace);
        C14342f0.m8192h(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            C14342f0.m8192h(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        C14342f0.m8183q(config, "config");
        C14342f0.m8183q(colorSpace, "colorSpace");
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config, z, colorSpace);
        C14342f0.m8192h(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}

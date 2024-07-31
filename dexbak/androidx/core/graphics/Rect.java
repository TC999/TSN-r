package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001d"}, m12616d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.RectKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Rect {
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final android.graphics.Rect and(@NotNull android.graphics.Rect and, @NotNull android.graphics.Rect r) {
        C14342f0.m8183q(and, "$this$and");
        C14342f0.m8183q(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect(and);
        rect.intersect(r);
        return rect;
    }

    public static final int component1(@NotNull android.graphics.Rect component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.left;
    }

    public static final int component2(@NotNull android.graphics.Rect component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.top;
    }

    public static final int component3(@NotNull android.graphics.Rect component3) {
        C14342f0.m8183q(component3, "$this$component3");
        return component3.right;
    }

    public static final int component4(@NotNull android.graphics.Rect component4) {
        C14342f0.m8183q(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@NotNull android.graphics.Rect contains, @NotNull Point p) {
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(p, "p");
        return contains.contains(p.x, p.y);
    }

    @NotNull
    public static final Region minus(@NotNull android.graphics.Rect minus, @NotNull android.graphics.Rect r) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(r, "r");
        Region region = new Region(minus);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    /* renamed from: or */
    public static final android.graphics.Rect m60028or(@NotNull android.graphics.Rect or, @NotNull android.graphics.Rect r) {
        C14342f0.m8183q(or, "$this$or");
        C14342f0.m8183q(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect(or);
        rect.union(r);
        return rect;
    }

    @NotNull
    public static final android.graphics.Rect plus(@NotNull android.graphics.Rect plus, @NotNull android.graphics.Rect r) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect(plus);
        rect.union(r);
        return rect;
    }

    @NotNull
    public static final android.graphics.Rect times(@NotNull android.graphics.Rect times, int i) {
        C14342f0.m8183q(times, "$this$times");
        android.graphics.Rect rect = new android.graphics.Rect(times);
        rect.top *= i;
        rect.left *= i;
        rect.right *= i;
        rect.bottom *= i;
        return rect;
    }

    @NotNull
    public static final android.graphics.Rect toRect(@NotNull RectF toRect) {
        C14342f0.m8183q(toRect, "$this$toRect");
        android.graphics.Rect rect = new android.graphics.Rect();
        toRect.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF toRectF(@NotNull android.graphics.Rect toRectF) {
        C14342f0.m8183q(toRectF, "$this$toRectF");
        return new RectF(toRectF);
    }

    @NotNull
    public static final Region toRegion(@NotNull android.graphics.Rect toRegion) {
        C14342f0.m8183q(toRegion, "$this$toRegion");
        return new Region(toRegion);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF transform, @NotNull Matrix m) {
        C14342f0.m8183q(transform, "$this$transform");
        C14342f0.m8183q(m, "m");
        m.mapRect(transform);
        return transform;
    }

    @NotNull
    public static final Region xor(@NotNull android.graphics.Rect xor, @NotNull android.graphics.Rect r) {
        C14342f0.m8183q(xor, "$this$xor");
        C14342f0.m8183q(r, "r");
        Region region = new Region(xor);
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final float component1(@NotNull RectF component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.left;
    }

    public static final float component2(@NotNull RectF component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.top;
    }

    public static final float component3(@NotNull RectF component3) {
        C14342f0.m8183q(component3, "$this$component3");
        return component3.right;
    }

    public static final float component4(@NotNull RectF component4) {
        C14342f0.m8183q(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@NotNull RectF contains, @NotNull PointF p) {
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(p, "p");
        return contains.contains(p.x, p.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF toRegion) {
        C14342f0.m8183q(toRegion, "$this$toRegion");
        android.graphics.Rect rect = new android.graphics.Rect();
        toRegion.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final RectF and(@NotNull RectF and, @NotNull RectF r) {
        C14342f0.m8183q(and, "$this$and");
        C14342f0.m8183q(r, "r");
        RectF rectF = new RectF(and);
        rectF.intersect(r);
        return rectF;
    }

    @NotNull
    public static final android.graphics.Rect minus(@NotNull android.graphics.Rect minus, int i) {
        C14342f0.m8183q(minus, "$this$minus");
        android.graphics.Rect rect = new android.graphics.Rect(minus);
        int i2 = -i;
        rect.offset(i2, i2);
        return rect;
    }

    @NotNull
    /* renamed from: or */
    public static final RectF m60027or(@NotNull RectF or, @NotNull RectF r) {
        C14342f0.m8183q(or, "$this$or");
        C14342f0.m8183q(r, "r");
        RectF rectF = new RectF(or);
        rectF.union(r);
        return rectF;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, @NotNull RectF r) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(r, "r");
        RectF rectF = new RectF(plus);
        rectF.union(r);
        return rectF;
    }

    @NotNull
    public static final Region xor(@NotNull RectF xor, @NotNull RectF r) {
        C14342f0.m8183q(xor, "$this$xor");
        C14342f0.m8183q(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        xor.roundOut(rect);
        Region region = new Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF minus, float f) {
        C14342f0.m8183q(minus, "$this$minus");
        RectF rectF = new RectF(minus);
        float f2 = -f;
        rectF.offset(f2, f2);
        return rectF;
    }

    @NotNull
    public static final android.graphics.Rect plus(@NotNull android.graphics.Rect plus, int i) {
        C14342f0.m8183q(plus, "$this$plus");
        android.graphics.Rect rect = new android.graphics.Rect(plus);
        rect.offset(i, i);
        return rect;
    }

    @NotNull
    public static final RectF times(@NotNull RectF times, float f) {
        C14342f0.m8183q(times, "$this$times");
        RectF rectF = new RectF(times);
        rectF.top *= f;
        rectF.left *= f;
        rectF.right *= f;
        rectF.bottom *= f;
        return rectF;
    }

    @NotNull
    public static final android.graphics.Rect minus(@NotNull android.graphics.Rect minus, @NotNull Point xy) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(xy, "xy");
        android.graphics.Rect rect = new android.graphics.Rect(minus);
        rect.offset(-xy.x, -xy.y);
        return rect;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, float f) {
        C14342f0.m8183q(plus, "$this$plus");
        RectF rectF = new RectF(plus);
        rectF.offset(f, f);
        return rectF;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF minus, @NotNull PointF xy) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(xy, "xy");
        RectF rectF = new RectF(minus);
        rectF.offset(-xy.x, -xy.y);
        return rectF;
    }

    @NotNull
    public static final android.graphics.Rect plus(@NotNull android.graphics.Rect plus, @NotNull Point xy) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(xy, "xy");
        android.graphics.Rect rect = new android.graphics.Rect(plus);
        rect.offset(xy.x, xy.y);
        return rect;
    }

    @NotNull
    public static final Region minus(@NotNull RectF minus, @NotNull RectF r) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        minus.roundOut(rect);
        Region region = new Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, @NotNull PointF xy) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(xy, "xy");
        RectF rectF = new RectF(plus);
        rectF.offset(xy.x, xy.y);
        return rectF;
    }

    @NotNull
    public static final RectF times(@NotNull RectF times, int i) {
        C14342f0.m8183q(times, "$this$times");
        float f = i;
        RectF rectF = new RectF(times);
        rectF.top *= f;
        rectF.left *= f;
        rectF.right *= f;
        rectF.bottom *= f;
        return rectF;
    }
}

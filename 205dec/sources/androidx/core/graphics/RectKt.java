package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Rect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u00a8\u0006\u001d"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final Rect and(@NotNull Rect and, @NotNull Rect r3) {
        f0.q(and, "$this$and");
        f0.q(r3, "r");
        Rect rect = new Rect(and);
        rect.intersect(r3);
        return rect;
    }

    public static final int component1(@NotNull Rect component1) {
        f0.q(component1, "$this$component1");
        return component1.left;
    }

    public static final int component2(@NotNull Rect component2) {
        f0.q(component2, "$this$component2");
        return component2.top;
    }

    public static final int component3(@NotNull Rect component3) {
        f0.q(component3, "$this$component3");
        return component3.right;
    }

    public static final int component4(@NotNull Rect component4) {
        f0.q(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@NotNull Rect contains, @NotNull Point p3) {
        f0.q(contains, "$this$contains");
        f0.q(p3, "p");
        return contains.contains(p3.x, p3.y);
    }

    @NotNull
    public static final Region minus(@NotNull Rect minus, @NotNull Rect r3) {
        f0.q(minus, "$this$minus");
        f0.q(r3, "r");
        Region region = new Region(minus);
        region.op(r3, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Rect or(@NotNull Rect or, @NotNull Rect r3) {
        f0.q(or, "$this$or");
        f0.q(r3, "r");
        Rect rect = new Rect(or);
        rect.union(r3);
        return rect;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect plus, @NotNull Rect r3) {
        f0.q(plus, "$this$plus");
        f0.q(r3, "r");
        Rect rect = new Rect(plus);
        rect.union(r3);
        return rect;
    }

    @NotNull
    public static final Rect times(@NotNull Rect times, int i4) {
        f0.q(times, "$this$times");
        Rect rect = new Rect(times);
        rect.top *= i4;
        rect.left *= i4;
        rect.right *= i4;
        rect.bottom *= i4;
        return rect;
    }

    @NotNull
    public static final Rect toRect(@NotNull RectF toRect) {
        f0.q(toRect, "$this$toRect");
        Rect rect = new Rect();
        toRect.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF toRectF(@NotNull Rect toRectF) {
        f0.q(toRectF, "$this$toRectF");
        return new RectF(toRectF);
    }

    @NotNull
    public static final Region toRegion(@NotNull Rect toRegion) {
        f0.q(toRegion, "$this$toRegion");
        return new Region(toRegion);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF transform, @NotNull Matrix m4) {
        f0.q(transform, "$this$transform");
        f0.q(m4, "m");
        m4.mapRect(transform);
        return transform;
    }

    @NotNull
    public static final Region xor(@NotNull Rect xor, @NotNull Rect r3) {
        f0.q(xor, "$this$xor");
        f0.q(r3, "r");
        Region region = new Region(xor);
        region.op(r3, Region.Op.XOR);
        return region;
    }

    public static final float component1(@NotNull RectF component1) {
        f0.q(component1, "$this$component1");
        return component1.left;
    }

    public static final float component2(@NotNull RectF component2) {
        f0.q(component2, "$this$component2");
        return component2.top;
    }

    public static final float component3(@NotNull RectF component3) {
        f0.q(component3, "$this$component3");
        return component3.right;
    }

    public static final float component4(@NotNull RectF component4) {
        f0.q(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@NotNull RectF contains, @NotNull PointF p3) {
        f0.q(contains, "$this$contains");
        f0.q(p3, "p");
        return contains.contains(p3.x, p3.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF toRegion) {
        f0.q(toRegion, "$this$toRegion");
        Rect rect = new Rect();
        toRegion.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final RectF and(@NotNull RectF and, @NotNull RectF r3) {
        f0.q(and, "$this$and");
        f0.q(r3, "r");
        RectF rectF = new RectF(and);
        rectF.intersect(r3);
        return rectF;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect minus, int i4) {
        f0.q(minus, "$this$minus");
        Rect rect = new Rect(minus);
        int i5 = -i4;
        rect.offset(i5, i5);
        return rect;
    }

    @NotNull
    public static final RectF or(@NotNull RectF or, @NotNull RectF r3) {
        f0.q(or, "$this$or");
        f0.q(r3, "r");
        RectF rectF = new RectF(or);
        rectF.union(r3);
        return rectF;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, @NotNull RectF r3) {
        f0.q(plus, "$this$plus");
        f0.q(r3, "r");
        RectF rectF = new RectF(plus);
        rectF.union(r3);
        return rectF;
    }

    @NotNull
    public static final Region xor(@NotNull RectF xor, @NotNull RectF r3) {
        f0.q(xor, "$this$xor");
        f0.q(r3, "r");
        Rect rect = new Rect();
        xor.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r3.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF minus, float f4) {
        f0.q(minus, "$this$minus");
        RectF rectF = new RectF(minus);
        float f5 = -f4;
        rectF.offset(f5, f5);
        return rectF;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect plus, int i4) {
        f0.q(plus, "$this$plus");
        Rect rect = new Rect(plus);
        rect.offset(i4, i4);
        return rect;
    }

    @NotNull
    public static final RectF times(@NotNull RectF times, float f4) {
        f0.q(times, "$this$times");
        RectF rectF = new RectF(times);
        rectF.top *= f4;
        rectF.left *= f4;
        rectF.right *= f4;
        rectF.bottom *= f4;
        return rectF;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect minus, @NotNull Point xy) {
        f0.q(minus, "$this$minus");
        f0.q(xy, "xy");
        Rect rect = new Rect(minus);
        rect.offset(-xy.x, -xy.y);
        return rect;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, float f4) {
        f0.q(plus, "$this$plus");
        RectF rectF = new RectF(plus);
        rectF.offset(f4, f4);
        return rectF;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF minus, @NotNull PointF xy) {
        f0.q(minus, "$this$minus");
        f0.q(xy, "xy");
        RectF rectF = new RectF(minus);
        rectF.offset(-xy.x, -xy.y);
        return rectF;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect plus, @NotNull Point xy) {
        f0.q(plus, "$this$plus");
        f0.q(xy, "xy");
        Rect rect = new Rect(plus);
        rect.offset(xy.x, xy.y);
        return rect;
    }

    @NotNull
    public static final Region minus(@NotNull RectF minus, @NotNull RectF r3) {
        f0.q(minus, "$this$minus");
        f0.q(r3, "r");
        Rect rect = new Rect();
        minus.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r3.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, @NotNull PointF xy) {
        f0.q(plus, "$this$plus");
        f0.q(xy, "xy");
        RectF rectF = new RectF(plus);
        rectF.offset(xy.x, xy.y);
        return rectF;
    }

    @NotNull
    public static final RectF times(@NotNull RectF times, int i4) {
        f0.q(times, "$this$times");
        float f4 = i4;
        RectF rectF = new RectF(times);
        rectF.top *= f4;
        rectF.left *= f4;
        rectF.right *= f4;
        rectF.bottom *= f4;
        return rectF;
    }
}

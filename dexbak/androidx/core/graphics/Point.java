package androidx.core.graphics;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\r"}, m12616d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", "p", "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.PointKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Point {
    public static final int component1(@NotNull android.graphics.Point component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.x;
    }

    public static final int component2(@NotNull android.graphics.Point component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.y;
    }

    @NotNull
    public static final android.graphics.Point minus(@NotNull android.graphics.Point minus, @NotNull android.graphics.Point p) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(p, "p");
        android.graphics.Point point = new android.graphics.Point(minus.x, minus.y);
        point.offset(-p.x, -p.y);
        return point;
    }

    @NotNull
    public static final android.graphics.Point plus(@NotNull android.graphics.Point plus, @NotNull android.graphics.Point p) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(p, "p");
        android.graphics.Point point = new android.graphics.Point(plus.x, plus.y);
        point.offset(p.x, p.y);
        return point;
    }

    @NotNull
    public static final android.graphics.Point toPoint(@NotNull PointF toPoint) {
        C14342f0.m8183q(toPoint, "$this$toPoint");
        return new android.graphics.Point((int) toPoint.x, (int) toPoint.y);
    }

    @NotNull
    public static final PointF toPointF(@NotNull android.graphics.Point toPointF) {
        C14342f0.m8183q(toPointF, "$this$toPointF");
        return new PointF(toPointF);
    }

    @NotNull
    public static final android.graphics.Point unaryMinus(@NotNull android.graphics.Point unaryMinus) {
        C14342f0.m8183q(unaryMinus, "$this$unaryMinus");
        return new android.graphics.Point(-unaryMinus.x, -unaryMinus.y);
    }

    public static final float component1(@NotNull PointF component1) {
        C14342f0.m8183q(component1, "$this$component1");
        return component1.x;
    }

    public static final float component2(@NotNull PointF component2) {
        C14342f0.m8183q(component2, "$this$component2");
        return component2.y;
    }

    @NotNull
    public static final PointF unaryMinus(@NotNull PointF unaryMinus) {
        C14342f0.m8183q(unaryMinus, "$this$unaryMinus");
        return new PointF(-unaryMinus.x, -unaryMinus.y);
    }

    @NotNull
    public static final PointF minus(@NotNull PointF minus, @NotNull PointF p) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(p, "p");
        PointF pointF = new PointF(minus.x, minus.y);
        pointF.offset(-p.x, -p.y);
        return pointF;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF plus, @NotNull PointF p) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(p, "p");
        PointF pointF = new PointF(plus.x, plus.y);
        pointF.offset(p.x, p.y);
        return pointF;
    }

    @NotNull
    public static final android.graphics.Point minus(@NotNull android.graphics.Point minus, int i) {
        C14342f0.m8183q(minus, "$this$minus");
        android.graphics.Point point = new android.graphics.Point(minus.x, minus.y);
        int i2 = -i;
        point.offset(i2, i2);
        return point;
    }

    @NotNull
    public static final android.graphics.Point plus(@NotNull android.graphics.Point plus, int i) {
        C14342f0.m8183q(plus, "$this$plus");
        android.graphics.Point point = new android.graphics.Point(plus.x, plus.y);
        point.offset(i, i);
        return point;
    }

    @NotNull
    public static final PointF minus(@NotNull PointF minus, float f) {
        C14342f0.m8183q(minus, "$this$minus");
        PointF pointF = new PointF(minus.x, minus.y);
        float f2 = -f;
        pointF.offset(f2, f2);
        return pointF;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF plus, float f) {
        C14342f0.m8183q(plus, "$this$plus");
        PointF pointF = new PointF(plus.x, plus.y);
        pointF.offset(f, f);
        return pointF;
    }
}

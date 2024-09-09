package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import d2.l;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Region.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\f\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\f\u001a0\u0010\u0014\u001a\u00020\u0012*\u00020\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0086\b\u001a\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015*\u00020\u0000H\u0086\u0002\u00a8\u0006\u0017"}, d2 = {"Landroid/graphics/Region;", "Landroid/graphics/Point;", "p", "", "contains", "Landroid/graphics/Rect;", "r", "plus", "minus", "unaryMinus", "not", "or", "and", "xor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/f1;", "action", "forEach", "", "iterator", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class RegionKt {
    @NotNull
    public static final Region and(@NotNull Region and, @NotNull Rect r3) {
        f0.q(and, "$this$and");
        f0.q(r3, "r");
        Region region = new Region(and);
        region.op(r3, Region.Op.INTERSECT);
        return region;
    }

    public static final boolean contains(@NotNull Region contains, @NotNull Point p3) {
        f0.q(contains, "$this$contains");
        f0.q(p3, "p");
        return contains.contains(p3.x, p3.y);
    }

    public static final void forEach(@NotNull Region forEach, @NotNull l<? super Rect, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        RegionIterator regionIterator = new RegionIterator(forEach);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            }
            action.invoke(rect);
        }
    }

    @NotNull
    public static final Iterator<Rect> iterator(@NotNull Region iterator) {
        f0.q(iterator, "$this$iterator");
        return new RegionKt$iterator$1(iterator);
    }

    @NotNull
    public static final Region minus(@NotNull Region minus, @NotNull Rect r3) {
        f0.q(minus, "$this$minus");
        f0.q(r3, "r");
        Region region = new Region(minus);
        region.op(r3, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region not(@NotNull Region not) {
        f0.q(not, "$this$not");
        Region region = new Region(not.getBounds());
        region.op(not, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region or(@NotNull Region or, @NotNull Rect r3) {
        f0.q(or, "$this$or");
        f0.q(r3, "r");
        Region region = new Region(or);
        region.union(r3);
        return region;
    }

    @NotNull
    public static final Region plus(@NotNull Region plus, @NotNull Rect r3) {
        f0.q(plus, "$this$plus");
        f0.q(r3, "r");
        Region region = new Region(plus);
        region.union(r3);
        return region;
    }

    @NotNull
    public static final Region unaryMinus(@NotNull Region unaryMinus) {
        f0.q(unaryMinus, "$this$unaryMinus");
        Region region = new Region(unaryMinus.getBounds());
        region.op(unaryMinus, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region xor(@NotNull Region xor, @NotNull Rect r3) {
        f0.q(xor, "$this$xor");
        f0.q(r3, "r");
        Region region = new Region(xor);
        region.op(r3, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Region and(@NotNull Region and, @NotNull Region r3) {
        f0.q(and, "$this$and");
        f0.q(r3, "r");
        Region region = new Region(and);
        region.op(r3, Region.Op.INTERSECT);
        return region;
    }

    @NotNull
    public static final Region minus(@NotNull Region minus, @NotNull Region r3) {
        f0.q(minus, "$this$minus");
        f0.q(r3, "r");
        Region region = new Region(minus);
        region.op(r3, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region or(@NotNull Region or, @NotNull Region r3) {
        f0.q(or, "$this$or");
        f0.q(r3, "r");
        Region region = new Region(or);
        region.op(r3, Region.Op.UNION);
        return region;
    }

    @NotNull
    public static final Region plus(@NotNull Region plus, @NotNull Region r3) {
        f0.q(plus, "$this$plus");
        f0.q(r3, "r");
        Region region = new Region(plus);
        region.op(r3, Region.Op.UNION);
        return region;
    }

    @NotNull
    public static final Region xor(@NotNull Region xor, @NotNull Region r3) {
        f0.q(xor, "$this$xor");
        f0.q(r3, "r");
        Region region = new Region(xor);
        region.op(r3, Region.Op.XOR);
        return region;
    }
}

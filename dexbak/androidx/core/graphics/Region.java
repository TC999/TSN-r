package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.umeng.ccg.CcgConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\f\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\f\u001a0\u0010\u0014\u001a\u00020\u0012*\u00020\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0086\b\u001a\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015*\u00020\u0000H\u0086\u0002¨\u0006\u0017"}, m12616d2 = {"Landroid/graphics/Region;", "Landroid/graphics/Point;", "p", "", "contains", "Landroid/graphics/Rect;", "r", "plus", "minus", "unaryMinus", "not", "or", "and", "xor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/f1;", CcgConstant.f38549t, "forEach", "", "iterator", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.RegionKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Region {
    @NotNull
    public static final android.graphics.Region and(@NotNull android.graphics.Region and, @NotNull Rect r) {
        C14342f0.m8183q(and, "$this$and");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(and);
        region.op(r, Region.Op.INTERSECT);
        return region;
    }

    public static final boolean contains(@NotNull android.graphics.Region contains, @NotNull Point p) {
        C14342f0.m8183q(contains, "$this$contains");
        C14342f0.m8183q(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final void forEach(@NotNull android.graphics.Region forEach, @NotNull InterfaceC15280l<? super Rect, Unit> action) {
        C14342f0.m8183q(forEach, "$this$forEach");
        C14342f0.m8183q(action, "action");
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
    public static final Iterator<Rect> iterator(@NotNull android.graphics.Region iterator) {
        C14342f0.m8183q(iterator, "$this$iterator");
        return new RegionKt$iterator$1(iterator);
    }

    @NotNull
    public static final android.graphics.Region minus(@NotNull android.graphics.Region minus, @NotNull Rect r) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(minus);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final android.graphics.Region not(@NotNull android.graphics.Region not) {
        C14342f0.m8183q(not, "$this$not");
        android.graphics.Region region = new android.graphics.Region(not.getBounds());
        region.op(not, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    /* renamed from: or */
    public static final android.graphics.Region m60026or(@NotNull android.graphics.Region or, @NotNull Rect r) {
        C14342f0.m8183q(or, "$this$or");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(or);
        region.union(r);
        return region;
    }

    @NotNull
    public static final android.graphics.Region plus(@NotNull android.graphics.Region plus, @NotNull Rect r) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(plus);
        region.union(r);
        return region;
    }

    @NotNull
    public static final android.graphics.Region unaryMinus(@NotNull android.graphics.Region unaryMinus) {
        C14342f0.m8183q(unaryMinus, "$this$unaryMinus");
        android.graphics.Region region = new android.graphics.Region(unaryMinus.getBounds());
        region.op(unaryMinus, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final android.graphics.Region xor(@NotNull android.graphics.Region xor, @NotNull Rect r) {
        C14342f0.m8183q(xor, "$this$xor");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(xor);
        region.op(r, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final android.graphics.Region and(@NotNull android.graphics.Region and, @NotNull android.graphics.Region r) {
        C14342f0.m8183q(and, "$this$and");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(and);
        region.op(r, Region.Op.INTERSECT);
        return region;
    }

    @NotNull
    public static final android.graphics.Region minus(@NotNull android.graphics.Region minus, @NotNull android.graphics.Region r) {
        C14342f0.m8183q(minus, "$this$minus");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(minus);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    /* renamed from: or */
    public static final android.graphics.Region m60025or(@NotNull android.graphics.Region or, @NotNull android.graphics.Region r) {
        C14342f0.m8183q(or, "$this$or");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(or);
        region.op(r, Region.Op.UNION);
        return region;
    }

    @NotNull
    public static final android.graphics.Region plus(@NotNull android.graphics.Region plus, @NotNull android.graphics.Region r) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(plus);
        region.op(r, Region.Op.UNION);
        return region;
    }

    @NotNull
    public static final android.graphics.Region xor(@NotNull android.graphics.Region xor, @NotNull android.graphics.Region r) {
        C14342f0.m8183q(xor, "$this$xor");
        C14342f0.m8183q(r, "r");
        android.graphics.Region region = new android.graphics.Region(xor);
        region.op(r, Region.Op.XOR);
        return region;
    }
}

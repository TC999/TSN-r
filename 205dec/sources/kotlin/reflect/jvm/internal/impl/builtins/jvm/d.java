package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.i1;
import kotlin.collections.j1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaToKotlinClassMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a */
    public static final d f56177a = new d();

    private d() {
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d h(d dVar, kotlin.reflect.jvm.internal.impl.name.c cVar, kotlin.reflect.jvm.internal.impl.builtins.h hVar, Integer num, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            num = null;
        }
        return dVar.g(cVar, hVar, num);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d mutable) {
        f0.p(mutable, "mutable");
        kotlin.reflect.jvm.internal.impl.name.c p3 = c.f56159a.p(kotlin.reflect.jvm.internal.impl.resolve.d.m(mutable));
        if (p3 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d o4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(mutable).o(p3);
            f0.o(o4, "descriptor.builtIns.getB\u2026Name(oppositeClassFqName)");
            return o4;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d readOnly) {
        f0.p(readOnly, "readOnly");
        kotlin.reflect.jvm.internal.impl.name.c q3 = c.f56159a.q(kotlin.reflect.jvm.internal.impl.resolve.d.m(readOnly));
        if (q3 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d o4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(readOnly).o(q3);
            f0.o(o4, "descriptor.builtIns.getB\u2026Name(oppositeClassFqName)");
            return o4;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d mutable) {
        f0.p(mutable, "mutable");
        return c.f56159a.l(kotlin.reflect.jvm.internal.impl.resolve.d.m(mutable));
    }

    public final boolean d(@NotNull e0 type) {
        f0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.descriptors.d g4 = h1.g(type);
        return g4 != null && c(g4);
    }

    public final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d readOnly) {
        f0.p(readOnly, "readOnly");
        return c.f56159a.m(kotlin.reflect.jvm.internal.impl.resolve.d.m(readOnly));
    }

    public final boolean f(@NotNull e0 type) {
        f0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.descriptors.d g4 = h1.g(type);
        return g4 != null && e(g4);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d g(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.builtins.h builtIns, @Nullable Integer num) {
        f0.p(fqName, "fqName");
        f0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.name.b n4 = (num == null || !f0.g(fqName, c.f56159a.i())) ? c.f56159a.n(fqName) : j.a(num.intValue());
        if (n4 != null) {
            return builtIns.o(n4.b());
        }
        return null;
    }

    @NotNull
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> i(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.builtins.h builtIns) {
        List M;
        Set f4;
        Set k4;
        f0.p(fqName, "fqName");
        f0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.d h4 = h(this, fqName, builtIns, null, 4, null);
        if (h4 == null) {
            k4 = j1.k();
            return k4;
        }
        kotlin.reflect.jvm.internal.impl.name.c q3 = c.f56159a.q(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(h4));
        if (q3 == null) {
            f4 = i1.f(h4);
            return f4;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d o4 = builtIns.o(q3);
        f0.o(o4, "builtIns.getBuiltInClass\u2026otlinMutableAnalogFqName)");
        M = CollectionsKt__CollectionsKt.M(h4, o4);
        return M;
    }
}

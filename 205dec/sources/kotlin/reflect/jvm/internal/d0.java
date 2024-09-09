package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;

/* compiled from: typeOfImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000\u00a8\u0006\t"}, d2 = {"Lkotlin/reflect/r;", "lowerBound", "upperBound", "c", "type", "a", "Lkotlin/reflect/jvm/internal/impl/descriptors/d;", "d", "b", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d0 {
    @NotNull
    public static final kotlin.reflect.r a(@NotNull kotlin.reflect.r type) {
        kotlin.jvm.internal.f0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.types.e0 type2 = ((u) type).getType();
        if (type2 instanceof m0) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = type2.H0().b();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
            if (dVar != null) {
                m0 m0Var = (m0) type2;
                y0 j4 = d(dVar).j();
                kotlin.jvm.internal.f0.o(j4, "classifier.readOnlyToMutable().typeConstructor");
                return new u(kotlin.reflect.jvm.internal.impl.types.f0.k(m0Var, null, j4, null, false, 26, null), null, 2, null);
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Non-class type cannot be a mutable collection type: ", type));
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Non-simple type cannot be a mutable collection type: ", type).toString());
    }

    @NotNull
    public static final kotlin.reflect.r b(@NotNull kotlin.reflect.r type) {
        kotlin.jvm.internal.f0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.types.e0 type2 = ((u) type).getType();
        if (type2 instanceof m0) {
            m0 m0Var = (m0) type2;
            y0 j4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(type2).G().j();
            kotlin.jvm.internal.f0.o(j4, "kotlinType.builtIns.nothing.typeConstructor");
            return new u(kotlin.reflect.jvm.internal.impl.types.f0.k(m0Var, null, j4, null, false, 26, null), null, 2, null);
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Non-simple type cannot be a Nothing type: ", type).toString());
    }

    @NotNull
    public static final kotlin.reflect.r c(@NotNull kotlin.reflect.r lowerBound, @NotNull kotlin.reflect.r upperBound) {
        kotlin.jvm.internal.f0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.f0.p(upperBound, "upperBound");
        return new u(kotlin.reflect.jvm.internal.impl.types.f0.d((m0) ((u) lowerBound).getType(), (m0) ((u) upperBound).getType()), null, 2, null);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.d d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.name.c q3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a.q(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(dVar));
        if (q3 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d o4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(dVar).o(q3);
            kotlin.jvm.internal.f0.o(o4, "builtIns.getBuiltInClassByFqName(fqName)");
            return o4;
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Not a readonly collection: ", dVar));
    }
}

package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.k;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: util.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull
    public static final List<d1> a(@NotNull Collection<i> newValueParametersTypes, @NotNull Collection<? extends d1> oldValueParameters, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a newOwner) {
        List<Pair> T5;
        int Z;
        f0.p(newValueParametersTypes, "newValueParametersTypes");
        f0.p(oldValueParameters, "oldValueParameters");
        f0.p(newOwner, "newOwner");
        newValueParametersTypes.size();
        oldValueParameters.size();
        T5 = kotlin.collections.f0.T5(newValueParametersTypes, oldValueParameters);
        Z = y.Z(T5, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (Pair pair : T5) {
            i iVar = (i) pair.component1();
            d1 d1Var = (d1) pair.component2();
            int f4 = d1Var.f();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = d1Var.getAnnotations();
            kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
            f0.o(name, "oldParameter.name");
            e0 type = iVar.getType();
            boolean a4 = iVar.a();
            boolean p02 = d1Var.p0();
            boolean n02 = d1Var.n0();
            e0 k4 = d1Var.t0() != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(newOwner).k().k(iVar.getType()) : null;
            v0 source = d1Var.getSource();
            f0.o(source, "oldParameter.source");
            arrayList.add(new l0(newOwner, null, f4, annotations, name, type, a4, p02, n02, k4, source));
        }
        return arrayList;
    }

    @Nullable
    public static final k b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        f0.p(dVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.d p3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.p(dVar);
        if (p3 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h k02 = p3.k0();
        k kVar = k02 instanceof k ? (k) k02 : null;
        return kVar == null ? b(p3) : kVar;
    }
}

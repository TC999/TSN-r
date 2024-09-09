package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeParameterUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: typeParameterUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<k, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56259a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull k it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return Boolean.valueOf(it instanceof kotlin.reflect.jvm.internal.impl.descriptors.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: typeParameterUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<k, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56260a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull k it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return Boolean.valueOf(!(it instanceof j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: typeParameterUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<k, kotlin.sequences.m<? extends a1>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f56261a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.sequences.m<a1> invoke(@NotNull k it) {
            kotlin.sequences.m<a1> l12;
            kotlin.jvm.internal.f0.p(it, "it");
            List<a1> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.a) it).getTypeParameters();
            kotlin.jvm.internal.f0.o(typeParameters, "it as CallableDescriptor).typeParameters");
            l12 = kotlin.collections.f0.l1(typeParameters);
            return l12;
        }
    }

    @Nullable
    public static final n0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        kotlin.jvm.internal.f0.p(e0Var, "<this>");
        f b4 = e0Var.H0().b();
        return b(e0Var, b4 instanceof g ? (g) b4 : null, 0);
    }

    private static final n0 b(kotlin.reflect.jvm.internal.impl.types.e0 e0Var, g gVar, int i4) {
        if (gVar == null || kotlin.reflect.jvm.internal.impl.types.w.r(gVar)) {
            return null;
        }
        int size = gVar.r().size() + i4;
        if (!gVar.n()) {
            if (size != e0Var.G0().size()) {
                kotlin.reflect.jvm.internal.impl.resolve.d.E(gVar);
            }
            return new n0(gVar, e0Var.G0().subList(i4, e0Var.G0().size()), null);
        }
        List<kotlin.reflect.jvm.internal.impl.types.a1> subList = e0Var.G0().subList(i4, size);
        k b4 = gVar.b();
        return new n0(gVar, subList, b(e0Var, b4 instanceof g ? (g) b4 : null, size));
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.b c(a1 a1Var, k kVar, int i4) {
        return new kotlin.reflect.jvm.internal.impl.descriptors.b(a1Var, kVar, i4);
    }

    @NotNull
    public static final List<a1> d(@NotNull g gVar) {
        kotlin.sequences.m S2;
        kotlin.sequences.m i02;
        kotlin.sequences.m A0;
        List V2;
        k kVar;
        List<a1> o4;
        int Z;
        List<a1> o42;
        kotlin.jvm.internal.f0.p(gVar, "<this>");
        List<a1> declaredTypeParameters = gVar.r();
        kotlin.jvm.internal.f0.o(declaredTypeParameters, "declaredTypeParameters");
        if (gVar.n() || (gVar.b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            S2 = SequencesKt___SequencesKt.S2(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(gVar), a.f56259a);
            i02 = SequencesKt___SequencesKt.i0(S2, b.f56260a);
            A0 = SequencesKt___SequencesKt.A0(i02, c.f56261a);
            V2 = SequencesKt___SequencesKt.V2(A0);
            Iterator<k> it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(gVar).iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = it.next();
                if (kVar instanceof d) {
                    break;
                }
            }
            d dVar = (d) kVar;
            List<a1> parameters = dVar != null ? dVar.j().getParameters() : null;
            if (parameters == null) {
                parameters = CollectionsKt__CollectionsKt.F();
            }
            if (V2.isEmpty() && parameters.isEmpty()) {
                List<a1> declaredTypeParameters2 = gVar.r();
                kotlin.jvm.internal.f0.o(declaredTypeParameters2, "declaredTypeParameters");
                return declaredTypeParameters2;
            }
            o4 = kotlin.collections.f0.o4(V2, parameters);
            Z = kotlin.collections.y.Z(o4, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (a1 it2 : o4) {
                kotlin.jvm.internal.f0.o(it2, "it");
                arrayList.add(c(it2, gVar, declaredTypeParameters.size()));
            }
            o42 = kotlin.collections.f0.o4(declaredTypeParameters, arrayList);
            return o42;
        }
        return declaredTypeParameters;
    }
}

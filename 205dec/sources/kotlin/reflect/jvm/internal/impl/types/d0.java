package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntersectionTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d0 implements y0, r2.f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private e0 f58319a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashSet<e0> f58320b;

    /* renamed from: c  reason: collision with root package name */
    private final int f58321c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> {
        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final m0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return d0.this.a(kotlinTypeRefiner).e();
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.l f58323a;

        public b(d2.l lVar) {
            this.f58323a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            e0 it = (e0) t3;
            d2.l lVar = this.f58323a;
            kotlin.jvm.internal.f0.o(it, "it");
            String obj = lVar.invoke(it).toString();
            e0 it2 = (e0) t4;
            d2.l lVar2 = this.f58323a;
            kotlin.jvm.internal.f0.o(it2, "it");
            g4 = kotlin.comparisons.b.g(obj, lVar2.invoke(it2).toString());
            return g4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<e0, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f58324a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull e0 it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return it.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.l<e0, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.l<e0, Object> f58325a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(d2.l<? super e0, ? extends Object> lVar) {
            super(1);
            this.f58325a = lVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(e0 it) {
            d2.l<e0, Object> lVar = this.f58325a;
            kotlin.jvm.internal.f0.o(it, "it");
            return lVar.invoke(it).toString();
        }
    }

    public d0(@NotNull Collection<? extends e0> typesToIntersect) {
        kotlin.jvm.internal.f0.p(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<e0> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.f58320b = linkedHashSet;
        this.f58321c = linkedHashSet.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String h(d0 d0Var, d2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            lVar = c.f58324a;
        }
        return d0Var.g(lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public boolean c() {
        return false;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h d() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.n.f57941d.a("member scope for intersection type", this.f58320b);
    }

    @NotNull
    public final m0 e() {
        List F;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        F = CollectionsKt__CollectionsKt.F();
        return f0.m(b4, this, F, false, d(), new a());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            return kotlin.jvm.internal.f0.g(this.f58320b, ((d0) obj).f58320b);
        }
        return false;
    }

    @Nullable
    public final e0 f() {
        return this.f58319a;
    }

    @NotNull
    public final String g(@NotNull d2.l<? super e0, ? extends Object> getProperTypeRelatedToStringify) {
        List f5;
        String X2;
        kotlin.jvm.internal.f0.p(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        f5 = kotlin.collections.f0.f5(this.f58320b, new b(getProperTypeRelatedToStringify));
        X2 = kotlin.collections.f0.X2(f5, " & ", "{", "}", 0, null, new d(getProperTypeRelatedToStringify), 24, null);
        return X2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.a1> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    public int hashCode() {
        return this.f58321c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: i */
    public d0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        int Z;
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<e0> j4 = j();
        Z = kotlin.collections.y.Z(j4, 10);
        ArrayList arrayList = new ArrayList(Z);
        boolean z3 = false;
        for (e0 e0Var : j4) {
            arrayList.add(e0Var.J0(kotlinTypeRefiner));
            z3 = true;
        }
        d0 d0Var = null;
        if (z3) {
            e0 f4 = f();
            d0Var = new d0(arrayList).l(f4 != null ? f4.J0(kotlinTypeRefiner) : null);
        }
        return d0Var == null ? this : d0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public Collection<e0> j() {
        return this.f58320b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.h k() {
        kotlin.reflect.jvm.internal.impl.builtins.h k4 = this.f58320b.iterator().next().H0().k();
        kotlin.jvm.internal.f0.o(k4, "intersectedTypes.iterato\u2026xt().constructor.builtIns");
        return k4;
    }

    @NotNull
    public final d0 l(@Nullable e0 e0Var) {
        return new d0(this.f58320b, e0Var);
    }

    @NotNull
    public String toString() {
        return h(this, null, 1, null);
    }

    private d0(Collection<? extends e0> collection, e0 e0Var) {
        this(collection);
        this.f58319a = e0Var;
    }
}

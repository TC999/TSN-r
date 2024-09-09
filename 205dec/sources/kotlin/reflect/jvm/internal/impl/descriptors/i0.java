package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackageFragmentProviderImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i0 implements k0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Collection<g0> f56287a;

    /* compiled from: PackageFragmentProviderImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<g0, kotlin.reflect.jvm.internal.impl.name.c> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56288a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.name.c invoke(@NotNull g0 it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return it.e();
        }
    }

    /* compiled from: PackageFragmentProviderImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.c f56289a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.name.c cVar) {
            super(1);
            this.f56289a = cVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return Boolean.valueOf(!it.d() && kotlin.jvm.internal.f0.g(it.e(), this.f56289a));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i0(@NotNull Collection<? extends g0> packageFragments) {
        kotlin.jvm.internal.f0.p(packageFragments, "packageFragments");
        this.f56287a = packageFragments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public List<g0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        Collection<g0> collection = this.f56287a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.f0.g(((g0) obj).e(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<g0> packageFragments) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(packageFragments, "packageFragments");
        for (Object obj : this.f56287a) {
            if (kotlin.jvm.internal.f0.g(((g0) obj).e(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        Collection<g0> collection = this.f56287a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        for (g0 g0Var : collection) {
            if (kotlin.jvm.internal.f0.g(g0Var.e(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.sequences.m l12;
        kotlin.sequences.m d12;
        kotlin.sequences.m i02;
        List V2;
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(nameFilter, "nameFilter");
        l12 = kotlin.collections.f0.l1(this.f56287a);
        d12 = SequencesKt___SequencesKt.d1(l12, a.f56288a);
        i02 = SequencesKt___SequencesKt.i0(d12, new b(fqName));
        V2 = SequencesKt___SequencesKt.V2(i02);
        return V2;
    }
}

package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.l;
import kotlin.s;
import m2.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g implements k0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h f56919a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.a<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> f56920b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaPackageFragmentProvider.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f56922b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u uVar) {
            super(0);
            this.f56922b = uVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h invoke() {
            return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h(g.this.f56919a, this.f56922b);
        }
    }

    public g(@NotNull c components) {
        p e4;
        f0.p(components, "components");
        l.a aVar = l.a.f56935a;
        e4 = s.e(null);
        h hVar = new h(components, aVar, e4);
        this.f56919a = hVar;
        this.f56920b = hVar.e().b();
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h e(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        u b4 = this.f56919a.a().d().b(cVar);
        if (b4 == null) {
            return null;
        }
        return this.f56920b.a(cVar, new a(b4));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        List<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> N;
        f0.p(fqName, "fqName");
        N = CollectionsKt__CollectionsKt.N(e(fqName));
        return N;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<g0> packageFragments) {
        f0.p(fqName, "fqName");
        f0.p(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.a.a(packageFragments, e(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return this.f56919a.a().d().b(fqName) == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    /* renamed from: f */
    public List<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List<kotlin.reflect.jvm.internal.impl.name.c> F;
        f0.p(fqName, "fqName");
        f0.p(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h e4 = e(fqName);
        List<kotlin.reflect.jvm.internal.impl.name.c> J0 = e4 == null ? null : e4.J0();
        if (J0 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return J0;
    }

    @NotNull
    public String toString() {
        return f0.C("LazyJavaPackageFragmentProvider of module ", this.f56919a.a().m());
    }
}

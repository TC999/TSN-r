package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r extends j implements kotlin.reflect.jvm.internal.impl.descriptors.l0 {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f56477h = {kotlin.jvm.internal.n0.u(new PropertyReference1Impl(kotlin.jvm.internal.n0.d(r.class), "fragments", "getFragments()Ljava/util/List;")), kotlin.jvm.internal.n0.u(new PropertyReference1Impl(kotlin.jvm.internal.n0.d(r.class), "empty", "getEmpty()Z"))};
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final x f56478c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56479d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56480e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56481f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f56482g;

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Boolean> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Boolean invoke() {
            return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.j0.b(r.this.y0().L0(), r.this.e()));
        }
    }

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.g0>> {
        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.g0> invoke() {
            return kotlin.reflect.jvm.internal.impl.descriptors.j0.c(r.this.y0().L0(), r.this.e());
        }
    }

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
            int Z;
            List p4;
            if (r.this.isEmpty()) {
                return h.c.f57931b;
            }
            List<kotlin.reflect.jvm.internal.impl.descriptors.g0> g02 = r.this.g0();
            Z = kotlin.collections.y.Z(g02, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var : g02) {
                arrayList.add(g0Var.p());
            }
            p4 = kotlin.collections.f0.p4(arrayList, new h0(r.this.y0(), r.this.e()));
            b.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f57884d;
            return aVar.a("package view scope for " + r.this.e() + " in " + r.this.y0().getName(), p4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull x module, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), fqName.h());
        kotlin.jvm.internal.f0.p(module, "module");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        this.f56478c = module;
        this.f56479d = fqName;
        this.f56480e = storageManager.g(new b());
        this.f56481f = storageManager.g(new a());
        this.f56482g = new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(storageManager, new c());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d4) {
        kotlin.jvm.internal.f0.p(visitor, "visitor");
        return visitor.b(this, d4);
    }

    protected final boolean C0() {
        return ((Boolean) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56481f, this, f56477h[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    /* renamed from: F0 */
    public x y0() {
        return this.f56478c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return this.f56479d;
    }

    public boolean equals(@Nullable Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var = obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0 ? (kotlin.reflect.jvm.internal.impl.descriptors.l0) obj : null;
        return l0Var != null && kotlin.jvm.internal.f0.g(e(), l0Var.e()) && kotlin.jvm.internal.f0.g(y0(), l0Var.y0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.g0> g0() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56480e, this, f56477h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    /* renamed from: h0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.l0 b() {
        if (e().d()) {
            return null;
        }
        x y02 = y0();
        kotlin.reflect.jvm.internal.impl.name.c e4 = e().e();
        kotlin.jvm.internal.f0.o(e4, "fqName.parent()");
        return y02.j0(e4);
    }

    public int hashCode() {
        return (y0().hashCode() * 31) + e().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public boolean isEmpty() {
        return C0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return this.f56482g;
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotFoundClasses.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f56263a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d0 f56264b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.c, g0> f56265c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<a, kotlin.reflect.jvm.internal.impl.descriptors.d> f56266d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotFoundClasses.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.b f56267a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f56268b;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull List<Integer> typeParametersCount) {
            kotlin.jvm.internal.f0.p(classId, "classId");
            kotlin.jvm.internal.f0.p(typeParametersCount, "typeParametersCount");
            this.f56267a = classId;
            this.f56268b = typeParametersCount;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return this.f56267a;
        }

        @NotNull
        public final List<Integer> b() {
            return this.f56268b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return kotlin.jvm.internal.f0.g(this.f56267a, aVar.f56267a) && kotlin.jvm.internal.f0.g(this.f56268b, aVar.f56268b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f56267a.hashCode() * 31) + this.f56268b.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClassRequest(classId=" + this.f56267a + ", typeParametersCount=" + this.f56268b + ')';
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.g {

        /* renamed from: j  reason: collision with root package name */
        private final boolean f56269j;
        @NotNull

        /* renamed from: k  reason: collision with root package name */
        private final List<a1> f56270k;
        @NotNull

        /* renamed from: l  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.k f56271l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull k container, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, boolean z3, int i4) {
            super(storageManager, container, name, v0.f56634a, false);
            kotlin.ranges.k n12;
            int Z;
            Set f4;
            kotlin.jvm.internal.f0.p(storageManager, "storageManager");
            kotlin.jvm.internal.f0.p(container, "container");
            kotlin.jvm.internal.f0.p(name, "name");
            this.f56269j = z3;
            n12 = kotlin.ranges.q.n1(0, i4);
            Z = kotlin.collections.y.Z(n12, 10);
            ArrayList arrayList = new ArrayList(Z);
            Iterator<Integer> it = n12.iterator();
            while (it.hasNext()) {
                int nextInt = ((kotlin.collections.r0) it).nextInt();
                arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.k0.M0(this, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), false, Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.name.f.f(kotlin.jvm.internal.f0.C("T", Integer.valueOf(nextInt))), nextInt, storageManager));
            }
            this.f56270k = arrayList;
            List<a1> d4 = b1.d(this);
            f4 = kotlin.collections.i1.f(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(this).k().i());
            this.f56271l = new kotlin.reflect.jvm.internal.impl.types.k(this, d4, f4, storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        /* renamed from: F0 */
        public h.c k0() {
            return h.c.f57931b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
        @NotNull
        /* renamed from: G0 */
        public kotlin.reflect.jvm.internal.impl.types.k j() {
            return this.f56271l;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
        @NotNull
        /* renamed from: H0 */
        public h.c f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return h.c.f57931b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
        public boolean X() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        public boolean a0() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
            Set k4;
            k4 = j1.k();
            return k4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
        @NotNull
        public s getVisibility() {
            s PUBLIC = r.f56531e;
            kotlin.jvm.internal.f0.o(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        public ClassKind i() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
        public boolean i0() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g, kotlin.reflect.jvm.internal.impl.descriptors.a0
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m() {
            List F;
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
        public boolean n() {
            return this.f56269j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
        @NotNull
        public List<a1> r() {
            return this.f56270k;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
        @NotNull
        public Modality s() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        public boolean t() {
            return false;
        }

        @NotNull
        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        public boolean v() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        public boolean y() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @Nullable
        public x<kotlin.reflect.jvm.internal.impl.types.m0> z() {
            return null;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<a, kotlin.reflect.jvm.internal.impl.descriptors.d> {
        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke(@NotNull a dstr$classId$typeParametersCount) {
            List<Integer> N1;
            k d4;
            Object r22;
            kotlin.jvm.internal.f0.p(dstr$classId$typeParametersCount, "$dstr$classId$typeParametersCount");
            kotlin.reflect.jvm.internal.impl.name.b a4 = dstr$classId$typeParametersCount.a();
            List<Integer> b4 = dstr$classId$typeParametersCount.b();
            if (!a4.k()) {
                kotlin.reflect.jvm.internal.impl.name.b g4 = a4.g();
                if (g4 == null) {
                    kotlin.reflect.jvm.internal.impl.storage.g gVar = f0.this.f56265c;
                    kotlin.reflect.jvm.internal.impl.name.c h4 = a4.h();
                    kotlin.jvm.internal.f0.o(h4, "classId.packageFqName");
                    d4 = (e) gVar.invoke(h4);
                } else {
                    f0 f0Var = f0.this;
                    N1 = kotlin.collections.f0.N1(b4, 1);
                    d4 = f0Var.d(g4, N1);
                }
                k kVar = d4;
                boolean l4 = a4.l();
                kotlin.reflect.jvm.internal.impl.storage.n nVar = f0.this.f56263a;
                kotlin.reflect.jvm.internal.impl.name.f j4 = a4.j();
                kotlin.jvm.internal.f0.o(j4, "classId.shortClassName");
                r22 = kotlin.collections.f0.r2(b4);
                Integer num = (Integer) r22;
                return new b(nVar, kVar, j4, l4, num == null ? 0 : num.intValue());
            }
            throw new UnsupportedOperationException(kotlin.jvm.internal.f0.C("Unresolved local class: ", a4));
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, g0> {
        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final g0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            kotlin.jvm.internal.f0.p(fqName, "fqName");
            return new kotlin.reflect.jvm.internal.impl.descriptors.impl.m(f0.this.f56264b, fqName);
        }
    }

    public f0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d0 module) {
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(module, "module");
        this.f56263a = storageManager;
        this.f56264b = module;
        this.f56265c = storageManager.c(new d());
        this.f56266d = storageManager.c(new c());
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull List<Integer> typeParametersCount) {
        kotlin.jvm.internal.f0.p(classId, "classId");
        kotlin.jvm.internal.f0.p(typeParametersCount, "typeParametersCount");
        return this.f56266d.invoke(new a(classId, typeParametersCount));
    }
}

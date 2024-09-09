package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.u;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.resolve.constants.q;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.n;
import m2.o;
import m2.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.load.java.descriptors.g {

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56790i = {n0.u(new PropertyReference1Impl(n0.d(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), n0.u(new PropertyReference1Impl(n0.d(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), n0.u(new PropertyReference1Impl(n0.d(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56791a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m2.a f56792b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.j f56793c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56794d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final l2.a f56795e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56796f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f56797g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f56798h;

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> B0;
            Collection<m2.b> arguments = e.this.f56792b.getArguments();
            e eVar = e.this;
            ArrayList arrayList = new ArrayList();
            for (m2.b bVar : arguments) {
                kotlin.reflect.jvm.internal.impl.name.f name = bVar.getName();
                if (name == null) {
                    name = y.f57107c;
                }
                kotlin.reflect.jvm.internal.impl.resolve.constants.g k4 = eVar.k(bVar);
                Pair a4 = k4 == null ? null : l0.a(name, k4);
                if (a4 != null) {
                    arrayList.add(a4);
                }
            }
            B0 = z0.B0(arrayList);
            return B0;
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.name.c> {
        b() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.name.c invoke() {
            kotlin.reflect.jvm.internal.impl.name.b c4 = e.this.f56792b.c();
            if (c4 == null) {
                return null;
            }
            return c4.b();
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<m0> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final m0 invoke() {
            kotlin.reflect.jvm.internal.impl.name.c e4 = e.this.e();
            if (e4 == null) {
                return w.j(f0.C("No fqName: ", e.this.f56792b));
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d h4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.h(kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f56177a, e4, e.this.f56791a.d().k(), null, 4, null);
            if (h4 == null) {
                m2.g t3 = e.this.f56792b.t();
                h4 = t3 == null ? null : e.this.f56791a.a().n().a(t3);
                if (h4 == null) {
                    h4 = e.this.h(e4);
                }
            }
            return h4.q();
        }
    }

    public e(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull m2.a javaAnnotation, boolean z3) {
        f0.p(c4, "c");
        f0.p(javaAnnotation, "javaAnnotation");
        this.f56791a = c4;
        this.f56792b = javaAnnotation;
        this.f56793c = c4.e().i(new b());
        this.f56794d = c4.e().g(new c());
        this.f56795e = c4.a().t().a(javaAnnotation);
        this.f56796f = c4.e().g(new a());
        this.f56797g = javaAnnotation.d();
        this.f56798h = javaAnnotation.D() || z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d h(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        d0 d4 = this.f56791a.d();
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(cVar);
        f0.o(m4, "topLevel(fqName)");
        return v.c(d4, m4, this.f56791a.a().b().e().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> k(m2.b bVar) {
        if (bVar instanceof o) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.h.f57831a.c(((o) bVar).getValue());
        }
        if (bVar instanceof m2.m) {
            m2.m mVar = (m2.m) bVar;
            return n(mVar.d(), mVar.e());
        } else if (!(bVar instanceof m2.e)) {
            if (bVar instanceof m2.c) {
                return l(((m2.c) bVar).a());
            }
            if (bVar instanceof m2.h) {
                return o(((m2.h) bVar).b());
            }
            return null;
        } else {
            m2.e eVar = (m2.e) bVar;
            kotlin.reflect.jvm.internal.impl.name.f name = eVar.getName();
            if (name == null) {
                name = y.f57107c;
            }
            f0.o(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return m(name, eVar.c());
        }
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> l(m2.a aVar) {
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.a(new e(this.f56791a, aVar, false, 4, null));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> m(kotlin.reflect.jvm.internal.impl.name.f fVar, List<? extends m2.b> list) {
        e0 type;
        int Z;
        m0 type2 = getType();
        f0.o(type2, "type");
        if (g0.a(type2)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(this);
        f0.m(f4);
        d1 b4 = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, f4);
        if (b4 == null) {
            type = this.f56791a.a().m().k().l(Variance.INVARIANT, w.j("Unknown array element type"));
        } else {
            type = b4.getType();
        }
        f0.o(type, "DescriptorResolverUtils.\u2026 type\")\n                )");
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (m2.b bVar : list) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> k4 = k(bVar);
            if (k4 == null) {
                k4 = new s();
            }
            arrayList.add(k4);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.h.f57831a.b(arrayList, type);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> n(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.j(bVar, fVar);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> o(x xVar) {
        return q.f57853b.a(this.f56791a.g().o(xVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, false, null, 3, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56796f, this, f56790i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.g
    public boolean d() {
        return this.f56797g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return (kotlin.reflect.jvm.internal.impl.name.c) kotlin.reflect.jvm.internal.impl.storage.m.b(this.f56793c, this, f56790i[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    /* renamed from: i */
    public l2.a getSource() {
        return this.f56795e;
    }

    public final boolean j() {
        return this.f56798h;
    }

    @NotNull
    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.u(kotlin.reflect.jvm.internal.impl.renderer.b.f57729g, this, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public m0 getType() {
        return (m0) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56794d, this, f56790i[1]);
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, m2.a aVar, boolean z3, int i4, u uVar) {
        this(hVar, aVar, (i4 & 4) != 0 ? false : z3);
    }
}

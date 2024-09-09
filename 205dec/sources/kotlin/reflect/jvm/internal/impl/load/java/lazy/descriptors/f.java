package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.p;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.q;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import m2.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaClassDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f extends kotlin.reflect.jvm.internal.impl.descriptors.impl.g implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.c {
    @NotNull
    private static final Set<String> A;
    @NotNull

    /* renamed from: z  reason: collision with root package name */
    public static final a f56802z = new a(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56803j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final m2.g f56804k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f56805l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56806m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final p f56807n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final ClassKind f56808o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final Modality f56809p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final i1 f56810q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f56811r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final b f56812s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final g f56813t;
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    private final t0<g> f56814u;
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.f f56815v;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private final k f56816w;
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f56817x;
    @NotNull

    /* renamed from: y  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<List<a1>> f56818y;

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends kotlin.reflect.jvm.internal.impl.types.b {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<List<a1>> f56819d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f56820e;

        /* compiled from: LazyJavaClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<List<? extends a1>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f56821a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f56821a = fVar;
            }

            @Override // d2.a
            @NotNull
            public final List<? extends a1> invoke() {
                return b1.d(this.f56821a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f this$0) {
            super(this$0.f56806m.e());
            f0.p(this$0, "this$0");
            this.f56820e = this$0;
            this.f56819d = this$0.f56806m.e().g(new a(this$0));
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
            if ((!r0.d() && r0.i(kotlin.reflect.jvm.internal.impl.builtins.j.f56083l)) != false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.types.e0 v() {
            /*
                r8 = this;
                kotlin.reflect.jvm.internal.impl.name.c r0 = r8.w()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto La
            L8:
                r0 = r2
                goto L1d
            La:
                boolean r3 = r0.d()
                if (r3 != 0) goto L1a
                kotlin.reflect.jvm.internal.impl.name.f r3 = kotlin.reflect.jvm.internal.impl.builtins.j.f56083l
                boolean r3 = r0.i(r3)
                if (r3 == 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 == 0) goto L8
            L1d:
                if (r0 != 0) goto L2e
                kotlin.reflect.jvm.internal.impl.load.java.l r3 = kotlin.reflect.jvm.internal.impl.load.java.l.f56743a
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f r4 = r8.f56820e
                kotlin.reflect.jvm.internal.impl.name.c r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(r4)
                kotlin.reflect.jvm.internal.impl.name.c r3 = r3.b(r4)
                if (r3 != 0) goto L2f
                return r2
            L2e:
                r3 = r0
            L2f:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f r4 = r8.f56820e
                kotlin.reflect.jvm.internal.impl.load.java.lazy.h r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f.G0(r4)
                kotlin.reflect.jvm.internal.impl.descriptors.d0 r4 = r4.d()
                kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER
                kotlin.reflect.jvm.internal.impl.descriptors.d r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.r(r4, r3, r5)
                if (r3 != 0) goto L42
                return r2
            L42:
                kotlin.reflect.jvm.internal.impl.types.y0 r4 = r3.j()
                java.util.List r4 = r4.getParameters()
                int r4 = r4.size()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f r5 = r8.f56820e
                kotlin.reflect.jvm.internal.impl.types.y0 r5 = r5.j()
                java.util.List r5 = r5.getParameters()
                java.lang.String r6 = "getTypeConstructor().parameters"
                kotlin.jvm.internal.f0.o(r5, r6)
                int r6 = r5.size()
                r7 = 10
                if (r6 != r4) goto L8d
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = kotlin.collections.w.Z(r5, r7)
                r0.<init>(r1)
                java.util.Iterator r1 = r5.iterator()
            L72:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto Lc7
                java.lang.Object r2 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.a1 r2 = (kotlin.reflect.jvm.internal.impl.descriptors.a1) r2
                kotlin.reflect.jvm.internal.impl.types.c1 r4 = new kotlin.reflect.jvm.internal.impl.types.c1
                kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                kotlin.reflect.jvm.internal.impl.types.m0 r2 = r2.q()
                r4.<init>(r5, r2)
                r0.add(r4)
                goto L72
            L8d:
                if (r6 != r1) goto Ld2
                if (r4 <= r1) goto Ld2
                if (r0 != 0) goto Ld2
                kotlin.reflect.jvm.internal.impl.types.c1 r0 = new kotlin.reflect.jvm.internal.impl.types.c1
                kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                java.lang.Object r5 = kotlin.collections.w.S4(r5)
                kotlin.reflect.jvm.internal.impl.descriptors.a1 r5 = (kotlin.reflect.jvm.internal.impl.descriptors.a1) r5
                kotlin.reflect.jvm.internal.impl.types.m0 r5 = r5.q()
                r0.<init>(r2, r5)
                kotlin.ranges.k r2 = new kotlin.ranges.k
                r2.<init>(r1, r4)
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = kotlin.collections.w.Z(r2, r7)
                r1.<init>(r4)
                java.util.Iterator r2 = r2.iterator()
            Lb6:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto Lc6
                r4 = r2
                kotlin.collections.r0 r4 = (kotlin.collections.r0) r4
                r4.nextInt()
                r1.add(r0)
                goto Lb6
            Lc6:
                r0 = r1
            Lc7:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.f$a r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r1 = r1.b()
                kotlin.reflect.jvm.internal.impl.types.m0 r0 = kotlin.reflect.jvm.internal.impl.types.f0.g(r1, r3, r0)
                return r0
            Ld2:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f.b.v():kotlin.reflect.jvm.internal.impl.types.e0");
        }

        private final kotlin.reflect.jvm.internal.impl.name.c w() {
            Object T4;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = this.f56820e.getAnnotations();
            kotlin.reflect.jvm.internal.impl.name.c PURELY_IMPLEMENTS_ANNOTATION = y.f57121q;
            f0.o(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b4 = annotations.b(PURELY_IMPLEMENTS_ANNOTATION);
            if (b4 == null) {
                return null;
            }
            T4 = kotlin.collections.f0.T4(b4.a().values());
            v vVar = T4 instanceof v ? (v) T4 : null;
            if (vVar == null) {
                return null;
            }
            String a4 = vVar.a();
            if (kotlin.reflect.jvm.internal.impl.name.e.e(a4)) {
                return new kotlin.reflect.jvm.internal.impl.name.c(a4);
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<a1> getParameters() {
            return this.f56819d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected Collection<e0> i() {
            List l4;
            List G5;
            int Z;
            Collection<m2.j> j4 = this.f56820e.K0().j();
            ArrayList arrayList = new ArrayList(j4.size());
            ArrayList<x> arrayList2 = new ArrayList(0);
            e0 v3 = v();
            Iterator<m2.j> it = j4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m2.j next = it.next();
                e0 f4 = this.f56820e.f56806m.a().r().f(this.f56820e.f56806m.g().o(next, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.SUPERTYPE, false, null, 3, null)), this.f56820e.f56806m);
                if (f4.H0().b() instanceof f0.b) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.f0.g(f4.H0(), v3 != null ? v3.H0() : null) && !kotlin.reflect.jvm.internal.impl.builtins.h.b0(f4)) {
                    arrayList.add(f4);
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f56820e.f56805l;
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, dVar != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.i.a(dVar, this.f56820e).c().p(dVar.q(), Variance.INVARIANT) : null);
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, v3);
            if (!arrayList2.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.p c4 = this.f56820e.f56806m.a().c();
                kotlin.reflect.jvm.internal.impl.descriptors.d b4 = b();
                Z = kotlin.collections.y.Z(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(Z);
                for (x xVar : arrayList2) {
                    arrayList3.add(((m2.j) xVar).C());
                }
                c4.b(b4, arrayList3);
            }
            if (!arrayList.isEmpty()) {
                G5 = kotlin.collections.f0.G5(arrayList);
                return G5;
            }
            l4 = kotlin.collections.x.l(this.f56820e.f56806m.d().k().i());
            return l4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected y0 o() {
            return this.f56820e.f56806m.a().v();
        }

        @NotNull
        public String toString() {
            String b4 = this.f56820e.getName().b();
            kotlin.jvm.internal.f0.o(b4, "name.asString()");
            return b4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b, kotlin.reflect.jvm.internal.impl.types.l, kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        /* renamed from: u */
        public kotlin.reflect.jvm.internal.impl.descriptors.d b() {
            return this.f56820e;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<List<? extends a1>> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends a1> invoke() {
            int Z;
            List<m2.y> typeParameters = f.this.K0().getTypeParameters();
            f fVar = f.this;
            Z = kotlin.collections.y.Z(typeParameters, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (m2.y yVar : typeParameters) {
                a1 a4 = fVar.f56806m.f().a(yVar);
                if (a4 == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.K0() + ", so it must be resolved");
                }
                arrayList.add(a4);
            }
            return arrayList;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<List<? extends m2.a>> {
        d() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        public final List<? extends m2.a> invoke() {
            kotlin.reflect.jvm.internal.impl.name.b h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(f.this);
            if (h4 == null) {
                return null;
            }
            return f.this.M0().a().f().a(h4);
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, g> {
        e() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final g invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g it) {
            kotlin.jvm.internal.f0.p(it, "it");
            kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar = f.this.f56806m;
            f fVar = f.this;
            return new g(hVar, fVar, fVar.K0(), f.this.f56805l != null, f.this.f56813t);
        }
    }

    static {
        Set<String> u3;
        u3 = j1.u("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
        A = u3;
    }

    public /* synthetic */ f(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, m2.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, int i4, u uVar) {
        this(hVar, kVar, gVar, (i4 & 8) != 0 ? null : dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return null;
    }

    @NotNull
    public final f I0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.f0.p(javaResolverCache, "javaResolverCache");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar = this.f56806m;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h j4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.j(hVar, hVar.a().x(javaResolverCache));
        kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration = b();
        kotlin.jvm.internal.f0.o(containingDeclaration, "containingDeclaration");
        return new f(j4, containingDeclaration, this.f56804k, dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: J0 */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        return this.f56813t.x0().invoke();
    }

    @NotNull
    public final m2.g K0() {
        return this.f56804k;
    }

    @Nullable
    public final List<m2.a> L0() {
        return (List) this.f56807n.getValue();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.h M0() {
        return this.f56803j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: N0 */
    public g W() {
        return (g) super.W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    /* renamed from: O0 */
    public g f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f56814u.c(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h U() {
        return this.f56815v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean a0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f56817x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public s getVisibility() {
        if (kotlin.jvm.internal.f0.g(this.f56810q, r.f56527a) && this.f56804k.f() == null) {
            s sVar = q.f56977a;
            kotlin.jvm.internal.f0.o(sVar, "{\n            JavaDescri\u2026KAGE_VISIBILITY\n        }");
            return sVar;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.e0.c(this.f56810q);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        return this.f56808o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.y0 j() {
        return this.f56812s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h k0() {
        return this.f56816w;
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
        if (this.f56809p == Modality.SEALED) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a d4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, false, null, 3, null);
            Collection<m2.j> A2 = this.f56804k.A();
            ArrayList arrayList = new ArrayList();
            for (m2.j jVar : A2) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = this.f56806m.g().o(jVar, d4).H0().b();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
                if (dVar != null) {
                    arrayList.add(dVar);
                }
            }
            return arrayList;
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        return this.f56811r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        return this.f56818y.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        return this.f56809p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        return false;
    }

    @NotNull
    public String toString() {
        return kotlin.jvm.internal.f0.C("Lazy Java class ", kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(this));
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
    public kotlin.reflect.jvm.internal.impl.descriptors.x<m0> z() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h outerContext, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull m2.g jClass, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        super(outerContext.e(), containingDeclaration, jClass.getName(), outerContext.a().t().a(jClass), false);
        p a4;
        ClassKind classKind;
        Modality modality;
        kotlin.jvm.internal.f0.p(outerContext, "outerContext");
        kotlin.jvm.internal.f0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.f0.p(jClass, "jClass");
        this.f56803j = outerContext;
        this.f56804k = jClass;
        this.f56805l = dVar;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h d4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.d(outerContext, this, jClass, 0, 4, null);
        this.f56806m = d4;
        d4.a().h().a(jClass, this);
        jClass.I();
        a4 = kotlin.r.a(new d());
        this.f56807n = a4;
        if (jClass.m()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (jClass.H()) {
            classKind = ClassKind.INTERFACE;
        } else {
            classKind = jClass.v() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        }
        this.f56808o = classKind;
        if (!jClass.m() && !jClass.v()) {
            modality = Modality.Companion.a(jClass.p(), jClass.p() || jClass.isAbstract() || jClass.H(), !jClass.isFinal());
        } else {
            modality = Modality.FINAL;
        }
        this.f56809p = modality;
        this.f56810q = jClass.getVisibility();
        this.f56811r = (jClass.f() == null || jClass.O()) ? false : true;
        this.f56812s = new b(this);
        g gVar = new g(d4, this, jClass, dVar != null, null, 16, null);
        this.f56813t = gVar;
        this.f56814u = t0.f56623e.a(this, d4.e(), d4.a().k().c(), new e());
        this.f56815v = new kotlin.reflect.jvm.internal.impl.resolve.scopes.f(gVar);
        this.f56816w = new k(d4, jClass, this);
        this.f56817x = kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(d4, jClass);
        this.f56818y = d4.e().g(new c());
    }
}

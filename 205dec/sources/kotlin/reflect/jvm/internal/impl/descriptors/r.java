package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.util.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorVisibilities.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final s f56527a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final s f56528b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final s f56529c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final s f56530d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final s f56531e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final s f56532f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final s f56533g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final s f56534h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final s f56535i;

    /* renamed from: j  reason: collision with root package name */
    public static final Set<s> f56536j;

    /* renamed from: k  reason: collision with root package name */
    private static final Map<s, Integer> f56537k;

    /* renamed from: l  reason: collision with root package name */
    public static final s f56538l;

    /* renamed from: m  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e f56539m;

    /* renamed from: n  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e f56540n;
    @Deprecated

    /* renamed from: o  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e f56541o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.util.g f56542p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private static final Map<i1, s> f56543q;

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.e0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class b implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e {
        b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.e0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class c implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e {
        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.e0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class d extends p {
        d(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "what";
            } else if (i4 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i4 == 1 || i4 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar == null) {
                g(0);
            }
            return kotlin.reflect.jvm.internal.impl.resolve.d.j(kVar) != w0.f56635a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.o] */
        /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == 0) {
                g(1);
            }
            if (kVar == null) {
                g(2);
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.d.J(oVar) && h(kVar)) {
                return r.f(oVar, kVar);
            }
            if (oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
                kotlin.reflect.jvm.internal.impl.descriptors.g b4 = ((kotlin.reflect.jvm.internal.impl.descriptors.j) oVar).b();
                if (kotlin.reflect.jvm.internal.impl.resolve.d.G(b4) && kotlin.reflect.jvm.internal.impl.resolve.d.J(b4) && (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) && kotlin.reflect.jvm.internal.impl.resolve.d.J(kVar.b()) && r.f(oVar, kVar)) {
                    return true;
                }
            }
            while (oVar != 0) {
                oVar = oVar.b();
                if (oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                    if (!kotlin.reflect.jvm.internal.impl.resolve.d.x(oVar)) {
                        break;
                    }
                }
                if (oVar instanceof g0) {
                    break;
                }
            }
            if (oVar == 0) {
                return false;
            }
            while (kVar != null) {
                if (oVar == kVar) {
                    return true;
                }
                if (kVar instanceof g0) {
                    return (oVar instanceof g0) && oVar.e().equals(((g0) kVar).e()) && kotlin.reflect.jvm.internal.impl.resolve.d.b(kVar, oVar);
                }
                kVar = kVar.b();
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class e extends p {
        e(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.k q3;
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            if (r.f56527a.e(eVar, oVar, kVar)) {
                if (eVar == r.f56540n) {
                    return true;
                }
                if (eVar != r.f56539m && (q3 = kotlin.reflect.jvm.internal.impl.resolve.d.q(oVar, kotlin.reflect.jvm.internal.impl.descriptors.d.class)) != null && (eVar instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.g)) {
                    return ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.g) eVar).w().a().equals(q3.a());
                }
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class f extends p {
        f(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "from";
            } else if (i4 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i4 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i4 == 2 || i4 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            if (oVar == null) {
                g(2);
            }
            if (dVar == null) {
                g(3);
            }
            if (eVar == r.f56541o) {
                return false;
            }
            if (!(oVar instanceof CallableMemberDescriptor) || (oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) || eVar == r.f56540n) {
                return true;
            }
            if (eVar == r.f56539m || eVar == null) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.types.e0 a4 = eVar instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.f ? ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.f) eVar).a() : eVar.getType();
            return kotlin.reflect.jvm.internal.impl.resolve.d.I(a4, dVar) || kotlin.reflect.jvm.internal.impl.types.u.a(a4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.d.q(oVar, kotlin.reflect.jvm.internal.impl.descriptors.d.class);
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.d.r(kVar, kotlin.reflect.jvm.internal.impl.descriptors.d.class, false);
            if (dVar3 == null) {
                return false;
            }
            if (dVar2 == null || !kotlin.reflect.jvm.internal.impl.resolve.d.x(dVar2) || (dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.d.q(dVar2, kotlin.reflect.jvm.internal.impl.descriptors.d.class)) == null || !kotlin.reflect.jvm.internal.impl.resolve.d.H(dVar3, dVar)) {
                o M = kotlin.reflect.jvm.internal.impl.resolve.d.M(oVar);
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar4 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.d.q(M, kotlin.reflect.jvm.internal.impl.descriptors.d.class);
                if (dVar4 == null) {
                    return false;
                }
                if (kotlin.reflect.jvm.internal.impl.resolve.d.H(dVar3, dVar4) && h(eVar, M, dVar3)) {
                    return true;
                }
                return e(eVar, oVar, dVar3.b());
            }
            return true;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class g extends p {
        g(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.d.g(kVar).L(kotlin.reflect.jvm.internal.impl.resolve.d.g(oVar))) {
                return r.f56542p.a(oVar, kVar);
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class h extends p {
        h(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return true;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class i extends p {
        i(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class j extends p {
        j(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class k extends p {
        k(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class l extends p {
        l(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        Set u3;
        d dVar = new d(h1.e.f56282c);
        f56527a = dVar;
        e eVar = new e(h1.f.f56283c);
        f56528b = eVar;
        f fVar = new f(h1.g.f56284c);
        f56529c = fVar;
        g gVar = new g(h1.b.f56279c);
        f56530d = gVar;
        h hVar = new h(h1.h.f56285c);
        f56531e = hVar;
        i iVar = new i(h1.d.f56281c);
        f56532f = iVar;
        j jVar = new j(h1.a.f56278c);
        f56533g = jVar;
        k kVar = new k(h1.c.f56280c);
        f56534h = kVar;
        l lVar = new l(h1.i.f56286c);
        f56535i = lVar;
        u3 = j1.u(dVar, eVar, gVar, iVar);
        f56536j = Collections.unmodifiableSet(u3);
        HashMap e4 = kotlin.reflect.jvm.internal.impl.utils.a.e(4);
        e4.put(eVar, 0);
        e4.put(dVar, 0);
        e4.put(gVar, 1);
        e4.put(fVar, 1);
        e4.put(hVar, 2);
        f56537k = Collections.unmodifiableMap(e4);
        f56538l = hVar;
        f56539m = new a();
        f56540n = new b();
        f56541o = new c();
        Iterator it = ServiceLoader.load(kotlin.reflect.jvm.internal.impl.util.g.class, kotlin.reflect.jvm.internal.impl.util.g.class.getClassLoader()).iterator();
        f56542p = it.hasNext() ? (kotlin.reflect.jvm.internal.impl.util.g) it.next() : g.a.f58480a;
        f56543q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = 3
            goto L10
        Lf:
            r4 = 2
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.r.a(int):void");
    }

    @Nullable
    public static Integer d(@NotNull s sVar, @NotNull s sVar2) {
        if (sVar == null) {
            a(12);
        }
        if (sVar2 == null) {
            a(13);
        }
        Integer a4 = sVar.a(sVar2);
        if (a4 != null) {
            return a4;
        }
        Integer a5 = sVar2.a(sVar);
        if (a5 != null) {
            return Integer.valueOf(-a5.intValue());
        }
        return null;
    }

    @Nullable
    public static o e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        o e4;
        if (oVar == null) {
            a(8);
        }
        if (kVar == null) {
            a(9);
        }
        for (o oVar2 = (o) oVar.a(); oVar2 != null && oVar2.getVisibility() != f56532f; oVar2 = (o) kotlin.reflect.jvm.internal.impl.resolve.d.q(oVar2, o.class)) {
            if (!oVar2.getVisibility().e(eVar, oVar2, kVar)) {
                return oVar2;
            }
        }
        if (!(oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.i0) || (e4 = e(eVar, ((kotlin.reflect.jvm.internal.impl.descriptors.impl.i0) oVar).T(), kVar)) == null) {
            return null;
        }
        return e4;
    }

    public static boolean f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (kVar == null) {
            a(6);
        }
        if (kVar2 == null) {
            a(7);
        }
        w0 j4 = kotlin.reflect.jvm.internal.impl.resolve.d.j(kVar2);
        if (j4 != w0.f56635a) {
            return j4.equals(kotlin.reflect.jvm.internal.impl.resolve.d.j(kVar));
        }
        return false;
    }

    public static boolean g(@NotNull s sVar) {
        if (sVar == null) {
            a(14);
        }
        return sVar == f56527a || sVar == f56528b;
    }

    public static boolean h(@NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (oVar == null) {
            a(2);
        }
        if (kVar == null) {
            a(3);
        }
        return e(f56540n, oVar, kVar) == null;
    }

    private static void i(s sVar) {
        f56543q.put(sVar.b(), sVar);
    }

    @NotNull
    public static s j(@NotNull i1 i1Var) {
        if (i1Var == null) {
            a(15);
        }
        s sVar = f56543q.get(i1Var);
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + i1Var);
    }
}

package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.t;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.load.kotlin.w;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.storage.m;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f implements h2.a, h2.c {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56189h = {n0.u(new PropertyReference1Impl(n0.d(f.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), n0.u(new PropertyReference1Impl(n0.d(f.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), n0.u(new PropertyReference1Impl(n0.d(f.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d0 f56190a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.d f56191b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56192c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final e0 f56193d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56194e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.a<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.d> f56195f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56196g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56202a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.HIDDEN.ordinal()] = 1;
            iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[a.DROP.ordinal()] = 3;
            iArr[a.VISIBLE.ordinal()] = 4;
            f56202a = iArr;
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<m0> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.storage.n f56204b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.storage.n nVar) {
            super(0);
            this.f56204b = nVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final m0 invoke() {
            return v.c(f.this.s().a(), kotlin.reflect.jvm.internal.impl.builtins.jvm.e.f56178d.a(), new f0(this.f56204b, f.this.s().a())).q();
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends z {
        d(d0 d0Var, kotlin.reflect.jvm.internal.impl.name.c cVar) {
            super(d0Var, cVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
        @NotNull
        /* renamed from: C0 */
        public h.c p() {
            return h.c.f57931b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements d2.a<e0> {
        e() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final e0 invoke() {
            m0 i4 = f.this.f56190a.k().i();
            kotlin.jvm.internal.f0.o(i4, "moduleDescriptor.builtIns.anyType");
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1125f extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f f56206a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f56207b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1125f(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            super(0);
            this.f56206a = fVar;
            this.f56207b = dVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke() {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar = this.f56206a;
            kotlin.reflect.jvm.internal.impl.load.java.components.g EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.g.f56702a;
            kotlin.jvm.internal.f0.o(EMPTY, "EMPTY");
            return fVar.I0(EMPTY, this.f56207b);
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class g extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<? extends u0>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f56208a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            super(1);
            this.f56208a = fVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return it.a(this.f56208a, NoLookupLocation.FROM_BUILTINS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h<N> implements b.d {
        h() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        @NotNull
        /* renamed from: b */
        public final Iterable<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            Collection<e0> j4 = dVar.j().j();
            kotlin.jvm.internal.f0.o(j4, "it.typeConstructor.supertypes");
            f fVar = f.this;
            ArrayList arrayList = new ArrayList();
            for (e0 e0Var : j4) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
                kotlin.reflect.jvm.internal.impl.descriptors.f a4 = b4 == null ? null : b4.a();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = a4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) a4 : null;
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f p3 = dVar2 != null ? fVar.p(dVar2) : null;
                if (p3 != null) {
                    arrayList.add(p3);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class i extends b.AbstractC1189b<kotlin.reflect.jvm.internal.impl.descriptors.d, a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f56210a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<a> f56211b;

        i(String str, Ref.ObjectRef<a> objectRef) {
            this.f56210a = str;
            this.f56211b = objectRef;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.f$a] */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.f$a] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.f$a] */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC1189b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d */
        public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d javaClassDescriptor) {
            kotlin.jvm.internal.f0.p(javaClassDescriptor, "javaClassDescriptor");
            String a4 = t.a(w.f57261a, javaClassDescriptor, this.f56210a);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.h hVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.h.f56216a;
            if (hVar.e().contains(a4)) {
                this.f56211b.element = a.HIDDEN;
            } else if (hVar.h().contains(a4)) {
                this.f56211b.element = a.VISIBLE;
            } else if (hVar.c().contains(a4)) {
                this.f56211b.element = a.DROP;
            }
            return this.f56211b.element == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        @NotNull
        /* renamed from: e */
        public a a() {
            a aVar = this.f56211b.element;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class j<N> implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public static final j<N> f56212a = new j<>();

        j() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        @NotNull
        /* renamed from: b */
        public final Iterable<CallableMemberDescriptor> a(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor.a().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class k extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {
        k() {
            super(1);
        }

        @Override // d2.l
        /* renamed from: a */
        public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.DECLARATION && f.this.f56191b.c((kotlin.reflect.jvm.internal.impl.descriptors.d) callableMemberDescriptor.b()));
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class l extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> {
        l() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> l4;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.b(f.this.f56190a.k(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
            f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
            l4 = x.l(b4);
            return aVar.a(l4);
        }
    }

    public f(@NotNull d0 moduleDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d2.a<JvmBuiltIns.a> settingsComputation) {
        kotlin.jvm.internal.f0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(settingsComputation, "settingsComputation");
        this.f56190a = moduleDescriptor;
        this.f56191b = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f56177a;
        this.f56192c = storageManager.g(settingsComputation);
        this.f56193d = k(storageManager);
        this.f56194e = storageManager.g(new c(storageManager));
        this.f56195f = storageManager.b();
        this.f56196g = storageManager.g(new l());
    }

    private final u0 j(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e eVar, u0 u0Var) {
        w.a<? extends u0> x3 = u0Var.x();
        x3.q(eVar);
        x3.h(r.f56531e);
        x3.m(eVar.q());
        x3.c(eVar.E0());
        u0 build = x3.build();
        kotlin.jvm.internal.f0.m(build);
        return build;
    }

    private final e0 k(kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        List l4;
        Set<kotlin.reflect.jvm.internal.impl.descriptors.c> k4;
        d dVar = new d(this.f56190a, new kotlin.reflect.jvm.internal.impl.name.c("java.io"));
        l4 = x.l(new h0(nVar, new e()));
        kotlin.reflect.jvm.internal.impl.descriptors.impl.h hVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.h(dVar, kotlin.reflect.jvm.internal.impl.name.f.f("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, l4, v0.f56634a, false, nVar);
        h.c cVar = h.c.f57931b;
        k4 = j1.k();
        hVar.F0(cVar, k4, null);
        m0 q3 = hVar.q();
        kotlin.jvm.internal.f0.o(q3, "mockSerializableClass.defaultType");
        return q3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e7, code lost:
        if (t(r3, r10) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.u0> l(kotlin.reflect.jvm.internal.impl.descriptors.d r10, d2.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.u0>> r11) {
        /*
            r9 = this;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f r0 = r9.p(r10)
            if (r0 != 0) goto Lb
            java.util.List r10 = kotlin.collections.w.F()
            return r10
        Lb:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.d r1 = r9.f56191b
            kotlin.reflect.jvm.internal.impl.name.c r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.b$a r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f56157i
            kotlin.reflect.jvm.internal.impl.builtins.h r3 = r3.a()
            java.util.Collection r1 = r1.i(r2, r3)
            java.lang.Object r2 = kotlin.collections.w.e3(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.d r2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r2
            if (r2 != 0) goto L28
            java.util.List r10 = kotlin.collections.w.F()
            return r10
        L28:
            kotlin.reflect.jvm.internal.impl.utils.f$b r3 = kotlin.reflect.jvm.internal.impl.utils.f.f58554c
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.w.Z(r1, r5)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.d r5 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r5
            kotlin.reflect.jvm.internal.impl.name.c r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(r5)
            r4.add(r5)
            goto L39
        L4d:
            kotlin.reflect.jvm.internal.impl.utils.f r1 = r3.b(r4)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.d r3 = r9.f56191b
            boolean r10 = r3.c(r10)
            kotlin.reflect.jvm.internal.impl.storage.a<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.d> r3 = r9.f56195f
            kotlin.reflect.jvm.internal.impl.name.c r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.f$f r5 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.f$f
            r5.<init>(r0, r2)
            java.lang.Object r0 = r3.a(r4, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.d r0 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h r0 = r0.W()
            java.lang.String r2 = "fakeJavaClassDescriptor.unsubstitutedMemberScope"
            kotlin.jvm.internal.f0.o(r0, r2)
            java.lang.Object r11 = r11.invoke(r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L80:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto Lef
            java.lang.Object r2 = r11.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.u0 r3 = (kotlin.reflect.jvm.internal.impl.descriptors.u0) r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = r3.i()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r5 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L99
        L97:
            r6 = 0
            goto Le9
        L99:
            kotlin.reflect.jvm.internal.impl.descriptors.s r4 = r3.getVisibility()
            boolean r4 = r4.d()
            if (r4 != 0) goto La4
            goto L97
        La4:
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.h.i0(r3)
            if (r4 == 0) goto Lab
            goto L97
        Lab:
            java.util.Collection r4 = r3.d()
            java.lang.String r5 = "analogueMember.overriddenDescriptors"
            kotlin.jvm.internal.f0.o(r4, r5)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto Lbc
        Lba:
            r4 = 0
            goto Le0
        Lbc:
            java.util.Iterator r4 = r4.iterator()
        Lc0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lba
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.w r5 = (kotlin.reflect.jvm.internal.impl.descriptors.w) r5
            kotlin.reflect.jvm.internal.impl.descriptors.k r5 = r5.b()
            java.lang.String r8 = "it.containingDeclaration"
            kotlin.jvm.internal.f0.o(r5, r8)
            kotlin.reflect.jvm.internal.impl.name.c r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(r5)
            boolean r5 = r1.contains(r5)
            if (r5 == 0) goto Lc0
            r4 = 1
        Le0:
            if (r4 == 0) goto Le3
            goto L97
        Le3:
            boolean r3 = r9.t(r3, r10)
            if (r3 != 0) goto L97
        Le9:
            if (r6 == 0) goto L80
            r0.add(r2)
            goto L80
        Lef:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.f.l(kotlin.reflect.jvm.internal.impl.descriptors.d, d2.l):java.util.Collection");
    }

    private final m0 m() {
        return (m0) m.a(this.f56194e, this, f56189h[1]);
    }

    private static final boolean n(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, f1 f1Var, kotlin.reflect.jvm.internal.impl.descriptors.j jVar2) {
        return OverridingUtil.y(jVar, jVar2.c(f1Var)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f p(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.name.b o4;
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.a0(dVar) && kotlin.reflect.jvm.internal.impl.builtins.h.z0(dVar)) {
            kotlin.reflect.jvm.internal.impl.name.d j4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(dVar);
            if (j4.f() && (o4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a.o(j4)) != null) {
                kotlin.reflect.jvm.internal.impl.name.c b4 = o4.b();
                kotlin.jvm.internal.f0.o(b4, "JavaToKotlinClassMap.map\u2026leFqName() ?: return null");
                kotlin.reflect.jvm.internal.impl.descriptors.d c4 = q.c(s().a(), b4, NoLookupLocation.FROM_BUILTINS);
                if (c4 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) {
                    return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) c4;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private final a q(kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        List l4;
        String c4 = u.c(wVar, false, false, 3, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        l4 = x.l((kotlin.reflect.jvm.internal.impl.descriptors.d) wVar.b());
        Object b4 = kotlin.reflect.jvm.internal.impl.utils.b.b(l4, new h(), new i(c4, objectRef));
        kotlin.jvm.internal.f0.o(b4, "private fun FunctionDesc\u2026ERED\n            })\n    }");
        return (a) b4;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.f) m.a(this.f56196g, this, f56189h[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JvmBuiltIns.a s() {
        return (JvmBuiltIns.a) m.a(this.f56192c, this, f56189h[0]);
    }

    private final boolean t(u0 u0Var, boolean z3) {
        List l4;
        String c4 = u.c(u0Var, false, false, 3, null);
        if (z3 ^ kotlin.reflect.jvm.internal.impl.builtins.jvm.h.f56216a.f().contains(t.a(kotlin.reflect.jvm.internal.impl.load.kotlin.w.f57261a, (kotlin.reflect.jvm.internal.impl.descriptors.d) u0Var.b(), c4))) {
            return true;
        }
        l4 = x.l(u0Var);
        Boolean e4 = kotlin.reflect.jvm.internal.impl.utils.b.e(l4, j.f56212a, new k());
        kotlin.jvm.internal.f0.o(e4, "private fun SimpleFuncti\u2026scriptor)\n        }\n    }");
        return e4.booleanValue();
    }

    private final boolean u(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        Object S4;
        if (jVar.h().size() == 1) {
            List<d1> valueParameters = jVar.h();
            kotlin.jvm.internal.f0.o(valueParameters, "valueParameters");
            S4 = kotlin.collections.f0.S4(valueParameters);
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((d1) S4).getType().H0().b();
            if (kotlin.jvm.internal.f0.g(b4 == null ? null : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(b4), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(dVar))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f4, code lost:
        if (r2 != 3) goto L46;
     */
    @Override // h2.a
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.u0> a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r7, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.d r8) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.f.a(kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d):java.util.Collection");
    }

    @Override // h2.c
    public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull u0 functionDescriptor) {
        kotlin.jvm.internal.f0.p(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.f0.p(functionDescriptor, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f p3 = p(classDescriptor);
        if (p3 != null && functionDescriptor.getAnnotations().i(h2.d.a())) {
            if (s().b()) {
                String c4 = u.c(functionDescriptor, false, false, 3, null);
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g W = p3.W();
                kotlin.reflect.jvm.internal.impl.name.f name = functionDescriptor.getName();
                kotlin.jvm.internal.f0.o(name, "functionDescriptor.name");
                Collection<u0> a4 = W.a(name, NoLookupLocation.FROM_BUILTINS);
                if (!(a4 instanceof Collection) || !a4.isEmpty()) {
                    for (u0 u0Var : a4) {
                        if (kotlin.jvm.internal.f0.g(u.c(u0Var, false, false, 3, null), c4)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // h2.a
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        List F;
        int Z;
        boolean z3;
        List F2;
        List F3;
        kotlin.jvm.internal.f0.p(classDescriptor, "classDescriptor");
        if (classDescriptor.i() == ClassKind.CLASS && s().b()) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f p3 = p(classDescriptor);
            if (p3 == null) {
                F3 = CollectionsKt__CollectionsKt.F();
                return F3;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d h4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.h(this.f56191b, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(p3), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f56157i.a(), null, 4, null);
            if (h4 == null) {
                F2 = CollectionsKt__CollectionsKt.F();
                return F2;
            }
            f1 c4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.i.a(h4, p3).c();
            List<kotlin.reflect.jvm.internal.impl.descriptors.c> g4 = p3.g();
            ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.c> arrayList = new ArrayList();
            Iterator<T> it = g4.iterator();
            while (true) {
                boolean z4 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) next;
                if (cVar.getVisibility().d()) {
                    Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g5 = h4.g();
                    kotlin.jvm.internal.f0.o(g5, "defaultKotlinVersion.constructors");
                    if (!g5.isEmpty()) {
                        for (kotlin.reflect.jvm.internal.impl.descriptors.c it2 : g5) {
                            kotlin.jvm.internal.f0.o(it2, "it");
                            if (n(it2, c4, cVar)) {
                                z3 = false;
                                break;
                            }
                        }
                    }
                    z3 = true;
                    if (z3 && !u(cVar, classDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.h.i0(cVar) && !kotlin.reflect.jvm.internal.impl.builtins.jvm.h.f56216a.d().contains(t.a(kotlin.reflect.jvm.internal.impl.load.kotlin.w.f57261a, p3, u.c(cVar, false, false, 3, null)))) {
                        z4 = true;
                    }
                }
                if (z4) {
                    arrayList.add(next);
                }
            }
            Z = y.Z(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar2 : arrayList) {
                w.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> x3 = cVar2.x();
                x3.q(classDescriptor);
                x3.m(classDescriptor.q());
                x3.l();
                x3.f(c4.j());
                if (!kotlin.reflect.jvm.internal.impl.builtins.jvm.h.f56216a.g().contains(t.a(kotlin.reflect.jvm.internal.impl.load.kotlin.w.f57261a, p3, u.c(cVar2, false, false, 3, null)))) {
                    x3.s(r());
                }
                kotlin.reflect.jvm.internal.impl.descriptors.w build = x3.build();
                if (build == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                }
                arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.c) build);
            }
            return arrayList2;
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // h2.a
    @NotNull
    public Collection<e0> d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        List F;
        List l4;
        List M;
        kotlin.jvm.internal.f0.p(classDescriptor, "classDescriptor");
        kotlin.reflect.jvm.internal.impl.name.d j4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(classDescriptor);
        kotlin.reflect.jvm.internal.impl.builtins.jvm.h hVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.h.f56216a;
        if (hVar.i(j4)) {
            m0 cloneableType = m();
            kotlin.jvm.internal.f0.o(cloneableType, "cloneableType");
            M = CollectionsKt__CollectionsKt.M(cloneableType, this.f56193d);
            return M;
        } else if (hVar.j(j4)) {
            l4 = x.l(this.f56193d);
            return l4;
        } else {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
    }

    @Override // h2.a
    @NotNull
    /* renamed from: o */
    public Set<kotlin.reflect.jvm.internal.impl.name.f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        Set<kotlin.reflect.jvm.internal.impl.name.f> k5;
        kotlin.jvm.internal.f0.p(classDescriptor, "classDescriptor");
        if (!s().b()) {
            k5 = j1.k();
            return k5;
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f p3 = p(classDescriptor);
        if (p3 == null) {
            k4 = j1.k();
            return k4;
        }
        return p3.W().b();
    }
}

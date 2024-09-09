package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import d2.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.g;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.p;
import kotlin.reflect.jvm.internal.impl.types.checker.x;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.m;
import kotlin.sequences.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final f f57859a;

    /* compiled from: DescriptorUtils.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1169a<N> implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1169a<N> f57860a = new C1169a<>();

        C1169a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        @NotNull
        /* renamed from: b */
        public final Iterable<d1> a(d1 d1Var) {
            int Z;
            Collection<d1> d4 = d1Var.d();
            Z = y.Z(d4, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (d1 d1Var2 : d4) {
                arrayList.add(d1Var2.a());
            }
            return arrayList;
        }
    }

    /* compiled from: DescriptorUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class b extends FunctionReference implements l<d1, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57861a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final Boolean invoke(@NotNull d1 p02) {
            f0.p(p02, "p0");
            return Boolean.valueOf(p02.x0());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final h getOwner() {
            return n0.d(d1.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<N> implements b.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f57862a;

        c(boolean z3) {
            this.f57862a = z3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        @NotNull
        /* renamed from: b */
        public final Iterable<CallableMemberDescriptor> a(CallableMemberDescriptor callableMemberDescriptor) {
            List F;
            if (this.f57862a) {
                callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.a();
            }
            if (callableMemberDescriptor == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            Collection<? extends CallableMemberDescriptor> d4 = callableMemberDescriptor.d();
            f0.o(d4, "descriptor?.overriddenDescriptors ?: emptyList()");
            return d4;
        }
    }

    /* compiled from: DescriptorUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends b.AbstractC1189b<CallableMemberDescriptor, CallableMemberDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<CallableMemberDescriptor> f57863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l<CallableMemberDescriptor, Boolean> f57864b;

        /* JADX WARN: Multi-variable type inference failed */
        d(Ref.ObjectRef<CallableMemberDescriptor> objectRef, l<? super CallableMemberDescriptor, Boolean> lVar) {
            this.f57863a = objectRef;
            this.f57864b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC1189b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d */
        public void b(@NotNull CallableMemberDescriptor current) {
            f0.p(current, "current");
            if (this.f57863a.element == null && this.f57864b.invoke(current).booleanValue()) {
                this.f57863a.element = current;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC1189b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: e */
        public boolean c(@NotNull CallableMemberDescriptor current) {
            f0.p(current, "current");
            return this.f57863a.element == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        @Nullable
        /* renamed from: f */
        public CallableMemberDescriptor a() {
            return this.f57863a.element;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements l<k, k> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f57865a = new e();

        e() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final k invoke(@NotNull k it) {
            f0.p(it, "it");
            return it.b();
        }
    }

    static {
        f f4 = f.f("value");
        f0.o(f4, "identifier(\"value\")");
        f57859a = f4;
    }

    public static final boolean a(@NotNull d1 d1Var) {
        List l4;
        f0.p(d1Var, "<this>");
        l4 = x.l(d1Var);
        Boolean e4 = kotlin.reflect.jvm.internal.impl.utils.b.e(l4, C1169a.f57860a, b.f57861a);
        f0.o(e4, "ifAny(\n        listOf(th\u2026eclaresDefaultValue\n    )");
        return e4.booleanValue();
    }

    @Nullable
    public static final g<?> b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        Object p22;
        f0.p(cVar, "<this>");
        p22 = kotlin.collections.f0.p2(cVar.a().values());
        return (g) p22;
    }

    @Nullable
    public static final CallableMemberDescriptor c(@NotNull CallableMemberDescriptor callableMemberDescriptor, boolean z3, @NotNull l<? super CallableMemberDescriptor, Boolean> predicate) {
        List l4;
        f0.p(callableMemberDescriptor, "<this>");
        f0.p(predicate, "predicate");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        l4 = x.l(callableMemberDescriptor);
        return (CallableMemberDescriptor) kotlin.reflect.jvm.internal.impl.utils.b.b(l4, new c(z3), new d(objectRef, predicate));
    }

    public static /* synthetic */ CallableMemberDescriptor d(CallableMemberDescriptor callableMemberDescriptor, boolean z3, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return c(callableMemberDescriptor, z3, lVar);
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.c e(@NotNull k kVar) {
        f0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.d j4 = j(kVar);
        if (!j4.f()) {
            j4 = null;
        }
        if (j4 == null) {
            return null;
        }
        return j4.l();
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        f0.p(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = cVar.getType().H0().b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.builtins.h g(@NotNull k kVar) {
        f0.p(kVar, "<this>");
        return l(kVar).k();
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.b h(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        if (fVar == null) {
            return null;
        }
        k owner = fVar.b();
        if (owner instanceof g0) {
            return new kotlin.reflect.jvm.internal.impl.name.b(((g0) owner).e(), fVar.getName());
        }
        if (owner instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
            f0.o(owner, "owner");
            kotlin.reflect.jvm.internal.impl.name.b h4 = h((kotlin.reflect.jvm.internal.impl.descriptors.f) owner);
            if (h4 == null) {
                return null;
            }
            return h4.d(fVar.getName());
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c i(@NotNull k kVar) {
        f0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.c n4 = kotlin.reflect.jvm.internal.impl.resolve.d.n(kVar);
        f0.o(n4, "getFqNameSafe(this)");
        return n4;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.d j(@NotNull k kVar) {
        f0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.d m4 = kotlin.reflect.jvm.internal.impl.resolve.d.m(kVar);
        f0.o(m4, "getFqName(this)");
        return m4;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.checker.g k(@NotNull d0 d0Var) {
        f0.p(d0Var, "<this>");
        p pVar = (p) d0Var.D0(kotlin.reflect.jvm.internal.impl.types.checker.h.a());
        kotlin.reflect.jvm.internal.impl.types.checker.x xVar = pVar == null ? null : (kotlin.reflect.jvm.internal.impl.types.checker.x) pVar.a();
        return xVar instanceof x.a ? ((x.a) xVar).b() : g.a.f58278a;
    }

    @NotNull
    public static final d0 l(@NotNull k kVar) {
        f0.p(kVar, "<this>");
        d0 g4 = kotlin.reflect.jvm.internal.impl.resolve.d.g(kVar);
        f0.o(g4, "getContainingModule(this)");
        return g4;
    }

    @NotNull
    public static final m<k> m(@NotNull k kVar) {
        m<k> d02;
        f0.p(kVar, "<this>");
        d02 = SequencesKt___SequencesKt.d0(n(kVar), 1);
        return d02;
    }

    @NotNull
    public static final m<k> n(@NotNull k kVar) {
        m<k> q3;
        f0.p(kVar, "<this>");
        q3 = s.q(kVar, e.f57865a);
        return q3;
    }

    @NotNull
    public static final CallableMemberDescriptor o(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        f0.p(callableMemberDescriptor, "<this>");
        if (callableMemberDescriptor instanceof o0) {
            p0 correspondingProperty = ((o0) callableMemberDescriptor).V();
            f0.o(correspondingProperty, "correspondingProperty");
            return correspondingProperty;
        }
        return callableMemberDescriptor;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        f0.p(dVar, "<this>");
        for (e0 e0Var : dVar.q().H0().j()) {
            if (!kotlin.reflect.jvm.internal.impl.builtins.h.b0(e0Var)) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
                if (kotlin.reflect.jvm.internal.impl.resolve.d.w(b4)) {
                    if (b4 != null) {
                        return (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
        }
        return null;
    }

    public static final boolean q(@NotNull d0 d0Var) {
        f0.p(d0Var, "<this>");
        p pVar = (p) d0Var.D0(kotlin.reflect.jvm.internal.impl.types.checker.h.a());
        return pVar != null && ((kotlin.reflect.jvm.internal.impl.types.checker.x) pVar.a()).a();
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d r(@NotNull d0 d0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c topLevelClassFqName, @NotNull k2.b location) {
        f0.p(d0Var, "<this>");
        f0.p(topLevelClassFqName, "topLevelClassFqName");
        f0.p(location, "location");
        topLevelClassFqName.d();
        kotlin.reflect.jvm.internal.impl.name.c e4 = topLevelClassFqName.e();
        f0.o(e4, "topLevelClassFqName.parent()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h p3 = d0Var.j0(e4).p();
        f g4 = topLevelClassFqName.g();
        f0.o(g4, "topLevelClassFqName.shortName()");
        kotlin.reflect.jvm.internal.impl.descriptors.f h4 = p3.h(g4, location);
        if (h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) h4;
        }
        return null;
    }
}

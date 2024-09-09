package kotlin.reflect.jvm.internal.impl.resolve;

import d2.p;
import java.util.Collection;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f57810a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements p<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57811a = new a();

        a() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1165b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f57812a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f57813b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f57814c;

        /* compiled from: DescriptorEquivalenceForOverrides.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.b$b$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements p<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f57815a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f57816b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
                super(2);
                this.f57815a = aVar;
                this.f57816b = aVar2;
            }

            @Override // d2.p
            @NotNull
            /* renamed from: a */
            public final Boolean invoke(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
                return Boolean.valueOf(f0.g(kVar, this.f57815a) && f0.g(kVar2, this.f57816b));
            }
        }

        C1165b(boolean z3, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            this.f57812a = z3;
            this.f57813b = aVar;
            this.f57814c = aVar2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.e.a
        public final boolean a(@NotNull y0 c12, @NotNull y0 c22) {
            f0.p(c12, "c1");
            f0.p(c22, "c2");
            if (f0.g(c12, c22)) {
                return true;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = c12.b();
            kotlin.reflect.jvm.internal.impl.descriptors.f b5 = c22.b();
            if ((b4 instanceof a1) && (b5 instanceof a1)) {
                return b.f57810a.g((a1) b4, (a1) b5, this.f57812a, new a(this.f57813b, this.f57814c));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements p<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57817a = new c();

        c() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
            return Boolean.FALSE;
        }
    }

    private b() {
    }

    public static /* synthetic */ boolean b(b bVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z3, boolean z4, boolean z5, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, int i4, Object obj) {
        return bVar.a(aVar, aVar2, z3, (i4 & 8) != 0 ? true : z4, (i4 & 16) != 0 ? false : z5, gVar);
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar2) {
        return f0.g(dVar.j(), dVar2.j());
    }

    public static /* synthetic */ boolean e(b bVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, boolean z3, boolean z4, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z4 = true;
        }
        return bVar.d(kVar, kVar2, z3, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(b bVar, a1 a1Var, a1 a1Var2, boolean z3, p pVar, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            pVar = c.f57817a;
        }
        return bVar.g(a1Var, a1Var2, z3, pVar);
    }

    private final boolean i(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, p<? super kotlin.reflect.jvm.internal.impl.descriptors.k, ? super kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> pVar, boolean z3) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = kVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.k b5 = kVar2.b();
        if (!(b4 instanceof CallableMemberDescriptor) && !(b5 instanceof CallableMemberDescriptor)) {
            return e(this, b4, b5, z3, false, 8, null);
        }
        return pVar.invoke(b4, b5).booleanValue();
    }

    private final v0 j(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        Object T4;
        while (aVar instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) aVar;
            if (callableMemberDescriptor.i() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.d();
            f0.o(overriddenDescriptors, "overriddenDescriptors");
            T4 = kotlin.collections.f0.T4(overriddenDescriptors);
            aVar = (CallableMemberDescriptor) T4;
            if (aVar == null) {
                return null;
            }
        }
        return aVar.getSource();
    }

    public final boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a a4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a b4, boolean z3, boolean z4, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (f0.g(a4, b4)) {
            return true;
        }
        if (f0.g(a4.getName(), b4.getName())) {
            if (z4 && (a4 instanceof a0) && (b4 instanceof a0) && ((a0) a4).i0() != ((a0) b4).i0()) {
                return false;
            }
            if ((!f0.g(a4.b(), b4.b()) || (z3 && f0.g(j(a4), j(b4)))) && !d.E(a4) && !d.E(b4) && i(a4, b4, a.f57811a, z3)) {
                OverridingUtil i4 = OverridingUtil.i(kotlinTypeRefiner, new C1165b(z3, a4, b4));
                f0.o(i4, "a: CallableDescriptor,\n \u2026= a && y == b }\n        }");
                OverridingUtil.OverrideCompatibilityInfo.Result c4 = i4.F(a4, b4, null, !z5).c();
                OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
                return c4 == result && i4.F(b4, a4, null, z5 ^ true).c() == result;
            }
            return false;
        }
        return false;
    }

    public final boolean d(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, boolean z3, boolean z4) {
        if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            return c((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar, (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar2);
        }
        if ((kVar instanceof a1) && (kVar2 instanceof a1)) {
            return h(this, (a1) kVar, (a1) kVar2, z3, null, 8, null);
        }
        if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return b(this, (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar, (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar2, z3, z4, false, g.a.f58278a, 16, null);
        }
        return ((kVar instanceof g0) && (kVar2 instanceof g0)) ? f0.g(((g0) kVar).e(), ((g0) kVar2).e()) : f0.g(kVar, kVar2);
    }

    @JvmOverloads
    public final boolean f(@NotNull a1 a4, @NotNull a1 b4, boolean z3) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        return h(this, a4, b4, z3, null, 8, null);
    }

    @JvmOverloads
    public final boolean g(@NotNull a1 a4, @NotNull a1 b4, boolean z3, @NotNull p<? super kotlin.reflect.jvm.internal.impl.descriptors.k, ? super kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> equivalentCallables) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        f0.p(equivalentCallables, "equivalentCallables");
        if (f0.g(a4, b4)) {
            return true;
        }
        return !f0.g(a4.b(), b4.b()) && i(a4, b4, equivalentCallables, z3) && a4.f() == b4.f();
    }
}

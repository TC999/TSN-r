package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n extends p implements m, r2.c {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f58394d = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m0 f58395b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f58396c;

    /* compiled from: SpecialTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        private final boolean a(l1 l1Var) {
            return (l1Var.H0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.n) || (l1Var.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) || (l1Var instanceof kotlin.reflect.jvm.internal.impl.types.checker.i) || (l1Var instanceof t0);
        }

        public static /* synthetic */ n c(a aVar, l1 l1Var, boolean z3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                z3 = false;
            }
            return aVar.b(l1Var, z3);
        }

        private final boolean d(l1 l1Var, boolean z3) {
            boolean z4 = false;
            if (a(l1Var)) {
                if (l1Var instanceof t0) {
                    return h1.m(l1Var);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = l1Var.H0().b();
                kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 k0Var = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 ? (kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) b4 : null;
                if (k0Var != null && !k0Var.O0()) {
                    z4 = true;
                }
                if (z4) {
                    return true;
                }
                if (z3 && (l1Var.H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1)) {
                    return h1.m(l1Var);
                }
                return !kotlin.reflect.jvm.internal.impl.types.checker.o.f58302a.a(l1Var);
            }
            return false;
        }

        @Nullable
        public final n b(@NotNull l1 type, boolean z3) {
            kotlin.jvm.internal.f0.p(type, "type");
            if (type instanceof n) {
                return (n) type;
            }
            if (d(type, z3)) {
                if (type instanceof y) {
                    y yVar = (y) type;
                    kotlin.jvm.internal.f0.g(yVar.P0().H0(), yVar.Q0().H0());
                }
                return new n(b0.c(type), z3, null);
            }
            return null;
        }
    }

    private n(m0 m0Var, boolean z3) {
        this.f58395b = m0Var;
        this.f58396c = z3;
    }

    public /* synthetic */ n(m0 m0Var, boolean z3, kotlin.jvm.internal.u uVar) {
        this(m0Var, z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public boolean B() {
        return (Q0().H0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.n) || (Q0().H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p, kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return z3 ? Q0().O0(z3) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    protected m0 Q0() {
        return this.f58395b;
    }

    @NotNull
    public final m0 T0() {
        return this.f58395b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: U0 */
    public n P0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return new n(Q0().P0(newAnnotations), this.f58396c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: V0 */
    public n S0(@NotNull m0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        return new n(delegate, this.f58396c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    @NotNull
    public e0 h0(@NotNull e0 replacement) {
        kotlin.jvm.internal.f0.p(replacement, "replacement");
        return p0.e(replacement.K0(), this.f58396c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    public String toString() {
        return Q0() + " & Any";
    }
}

package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: flexibleTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z extends y implements m {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f58457e = new a(null);
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static boolean f58458f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f58459d;

    /* compiled from: flexibleTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull m0 lowerBound, @NotNull m0 upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.f0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.f0.p(upperBound, "upperBound");
    }

    private final void T0() {
        if (!f58458f || this.f58459d) {
            return;
        }
        this.f58459d = true;
        b0.b(P0());
        b0.b(Q0());
        kotlin.jvm.internal.f0.g(P0(), Q0());
        kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a.d(P0(), Q0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public boolean B() {
        return (P0().H0().b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) && kotlin.jvm.internal.f0.g(P0().H0(), Q0().H0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    public l1 L0(boolean z3) {
        return f0.d(P0().O0(z3), Q0().O0(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    public l1 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return f0.d(P0().P0(newAnnotations), Q0().P0(newAnnotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public m0 O0() {
        T0();
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public String R0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.d options) {
        kotlin.jvm.internal.f0.p(renderer, "renderer");
        kotlin.jvm.internal.f0.p(options, "options");
        if (options.j()) {
            return '(' + renderer.y(P0()) + ".." + renderer.y(Q0()) + ')';
        }
        return renderer.v(renderer.y(P0()), renderer.y(Q0()), kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: S0 */
    public y M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new z((m0) kotlinTypeRefiner.h(P0()), (m0) kotlinTypeRefiner.h(Q0()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    @NotNull
    public e0 h0(@NotNull e0 replacement) {
        l1 d4;
        kotlin.jvm.internal.f0.p(replacement, "replacement");
        l1 K0 = replacement.K0();
        if (K0 instanceof y) {
            d4 = K0;
        } else if (!(K0 instanceof m0)) {
            throw new NoWhenBranchMatchedException();
        } else {
            m0 m0Var = (m0) K0;
            d4 = f0.d(m0Var, m0Var.O0(true));
        }
        return j1.b(d4, K0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public String toString() {
        return '(' + P0() + ".." + Q0() + ')';
    }
}

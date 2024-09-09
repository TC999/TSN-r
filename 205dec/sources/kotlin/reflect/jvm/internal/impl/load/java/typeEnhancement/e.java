package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.j0;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.y;
import org.jetbrains.annotations.NotNull;

/* compiled from: typeEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends kotlin.reflect.jvm.internal.impl.types.p implements j0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m0 f57005b;

    public e(@NotNull m0 delegate) {
        f0.p(delegate, "delegate");
        this.f57005b = delegate;
    }

    private final m0 T0(m0 m0Var) {
        m0 O0 = m0Var.O0(false);
        return !kotlin.reflect.jvm.internal.impl.types.typeUtil.a.o(m0Var) ? O0 : new e(O0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public boolean B() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p, kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return z3 ? Q0().O0(true) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    protected m0 Q0() {
        return this.f57005b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: U0 */
    public e P0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        f0.p(newAnnotations, "newAnnotations");
        return new e(Q0().P0(newAnnotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: V0 */
    public e S0(@NotNull m0 delegate) {
        f0.p(delegate, "delegate");
        return new e(delegate);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    @NotNull
    public e0 h0(@NotNull e0 replacement) {
        f0.p(replacement, "replacement");
        l1 K0 = replacement.K0();
        if (kotlin.reflect.jvm.internal.impl.types.typeUtil.a.o(K0) || h1.m(K0)) {
            if (K0 instanceof m0) {
                return T0((m0) K0);
            }
            if (K0 instanceof y) {
                y yVar = (y) K0;
                return j1.e(kotlin.reflect.jvm.internal.impl.types.f0.d(T0(yVar.P0()), T0(yVar.Q0())), j1.a(K0));
            }
            throw new IllegalStateException(f0.C("Incorrect type: ", K0).toString());
        }
        return K0;
    }
}

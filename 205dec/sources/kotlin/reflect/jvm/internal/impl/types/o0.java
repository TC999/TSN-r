package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: TypeWithEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o0 extends p implements i1 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m0 f58403b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final e0 f58404c;

    public o0(@NotNull m0 delegate, @NotNull e0 enhancement) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        kotlin.jvm.internal.f0.p(enhancement, "enhancement");
        this.f58403b = delegate;
        this.f58404c = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return (m0) j1.e(C0().O0(z3), f0().K0().L0(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: P0 */
    public m0 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return (m0) j1.e(C0().P0(newAnnotations), f0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    protected m0 Q0() {
        return this.f58403b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i1
    @NotNull
    /* renamed from: T0 */
    public m0 C0() {
        return Q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: U0 */
    public o0 R0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new o0((m0) kotlinTypeRefiner.h(Q0()), kotlinTypeRefiner.h(f0()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: V0 */
    public o0 S0(@NotNull m0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        return new o0(delegate, f0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i1
    @NotNull
    public e0 f0() {
        return this.f58404c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    public String toString() {
        return "[@EnhancedForWarnings(" + f0() + ")] " + C0();
    }
}

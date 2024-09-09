package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: SpecialTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends p {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m0 f58264b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final m0 f58265c;

    public a(@NotNull m0 delegate, @NotNull m0 abbreviation) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        kotlin.jvm.internal.f0.p(abbreviation, "abbreviation");
        this.f58264b = delegate;
        this.f58265c = abbreviation;
    }

    @NotNull
    public final m0 I() {
        return Q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    protected m0 Q0() {
        return this.f58264b;
    }

    @NotNull
    public final m0 T0() {
        return this.f58265c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: U0 */
    public a O0(boolean z3) {
        return new a(Q0().O0(z3), this.f58265c.O0(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: V0 */
    public a R0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a((m0) kotlinTypeRefiner.h(Q0()), (m0) kotlinTypeRefiner.h(this.f58265c));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: W0 */
    public a P0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return new a(Q0().P0(newAnnotations), this.f58265c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: X0 */
    public a S0(@NotNull m0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        return new a(delegate, this.f58265c);
    }
}

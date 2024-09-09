package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: TypeWithEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 extends y implements i1 {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final y f58266d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final e0 f58267e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(@NotNull y origin, @NotNull e0 enhancement) {
        super(origin.P0(), origin.Q0());
        kotlin.jvm.internal.f0.p(origin, "origin");
        kotlin.jvm.internal.f0.p(enhancement, "enhancement");
        this.f58266d = origin;
        this.f58267e = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    public l1 L0(boolean z3) {
        return j1.e(C0().L0(z3), f0().K0().L0(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    public l1 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return j1.e(C0().N0(newAnnotations), f0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public m0 O0() {
        return C0().O0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public String R0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.d options) {
        kotlin.jvm.internal.f0.p(renderer, "renderer");
        kotlin.jvm.internal.f0.p(options, "options");
        if (options.d()) {
            return renderer.y(f0());
        }
        return C0().R0(renderer, options);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i1
    @NotNull
    /* renamed from: S0 */
    public y C0() {
        return this.f58266d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: T0 */
    public a0 M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a0((y) kotlinTypeRefiner.h(C0()), kotlinTypeRefiner.h(f0()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i1
    @NotNull
    public e0 f0() {
        return this.f58267e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public String toString() {
        return "[@EnhancedForWarnings(" + f0() + ")] " + C0();
    }
}

package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class q extends p {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m0 f58405b;

    public q(@NotNull m0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f58405b = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return z3 == I0() ? this : Q0().O0(z3).P0(getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    protected m0 Q0() {
        return this.f58405b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: T0 */
    public q P0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return newAnnotations != getAnnotations() ? new j(this, newAnnotations) : this;
    }
}

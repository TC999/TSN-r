package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class k0 extends q {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(@NotNull m0 delegate) {
        super(delegate);
        kotlin.jvm.internal.f0.p(delegate, "delegate");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p, kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: U0 */
    public k0 S0(@NotNull m0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        return new k0(delegate);
    }
}

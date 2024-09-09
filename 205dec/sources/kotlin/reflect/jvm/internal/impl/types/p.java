package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: SpecialTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class p extends m0 {
    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public List<a1> G0() {
        return Q0().G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public y0 H0() {
        return Q0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return Q0().I0();
    }

    @NotNull
    protected abstract m0 Q0();

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: R0 */
    public m0 M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return S0((m0) kotlinTypeRefiner.h(Q0()));
    }

    @NotNull
    public abstract p S0(@NotNull m0 m0Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return Q0().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return Q0().p();
    }
}

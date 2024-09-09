package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: StubTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t0 extends e implements r2.j {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final y0 f58415f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f58416g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(@NotNull y0 originalTypeVariable, boolean z3, @NotNull y0 constructor) {
        super(originalTypeVariable, z3);
        kotlin.jvm.internal.f0.p(originalTypeVariable, "originalTypeVariable");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        this.f58415f = constructor;
        this.f58416g = originalTypeVariable.k().i().p();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public y0 H0() {
        return this.f58415f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e
    @NotNull
    public e R0(boolean z3) {
        return new t0(Q0(), z3, H0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e, kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return this.f58416g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stub (BI): ");
        sb.append(Q0());
        sb.append(I0() ? "?" : "");
        return sb.toString();
    }
}

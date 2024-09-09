package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q0 extends b1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e0 f58406a;

    public q0(@NotNull kotlin.reflect.jvm.internal.impl.builtins.h kotlinBuiltIns) {
        kotlin.jvm.internal.f0.p(kotlinBuiltIns, "kotlinBuiltIns");
        m0 I = kotlinBuiltIns.I();
        kotlin.jvm.internal.f0.o(I, "kotlinBuiltIns.nullableAnyType");
        this.f58406a = I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public a1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    public boolean b() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public e0 getType() {
        return this.f58406a;
    }
}

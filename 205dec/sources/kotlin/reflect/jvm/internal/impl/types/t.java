package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: dynamicTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t extends y implements r2.d {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f58414d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public t(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.builtins.h r3, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r4) {
        /*
            r2 = this;
            java.lang.String r0 = "builtIns"
            kotlin.jvm.internal.f0.p(r3, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.f0.p(r4, r0)
            kotlin.reflect.jvm.internal.impl.types.m0 r0 = r3.H()
            java.lang.String r1 = "builtIns.nothingType"
            kotlin.jvm.internal.f0.o(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.m0 r3 = r3.I()
            java.lang.String r1 = "builtIns.nullableAnyType"
            kotlin.jvm.internal.f0.o(r3, r1)
            r2.<init>(r0, r3)
            r2.f58414d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.t.<init>(kotlin.reflect.jvm.internal.impl.builtins.h, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y, kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public m0 O0() {
        return Q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public String R0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.d options) {
        kotlin.jvm.internal.f0.p(renderer, "renderer");
        kotlin.jvm.internal.f0.p(options, "options");
        return "dynamic";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: S0 */
    public t L0(boolean z3) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: T0 */
    public t M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: U0 */
    public t N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return new t(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(O0()), newAnnotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f58414d;
    }
}

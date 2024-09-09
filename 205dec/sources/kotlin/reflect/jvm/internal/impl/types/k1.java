package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: ErrorType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k1 extends v {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final String f58392g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(@NotNull String presentableName, @NotNull y0 constructor, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, @NotNull List<? extends a1> arguments, boolean z3) {
        super(constructor, memberScope, arguments, z3, null, 16, null);
        kotlin.jvm.internal.f0.p(presentableName, "presentableName");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        this.f58392g = presentableName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v, kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return new k1(Q0(), H0(), p(), G0(), z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v
    @NotNull
    public String Q0() {
        return this.f58392g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v
    @NotNull
    /* renamed from: S0 */
    public k1 R0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}

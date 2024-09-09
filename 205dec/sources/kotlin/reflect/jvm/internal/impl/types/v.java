package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* compiled from: ErrorType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class v extends m0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final y0 f58432b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f58433c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List<a1> f58434d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f58435e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f58436f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public v(@NotNull y0 constructor, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope) {
        this(constructor, memberScope, null, false, null, 28, null);
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public v(@NotNull y0 constructor, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, @NotNull List<? extends a1> arguments, boolean z3) {
        this(constructor, memberScope, arguments, z3, null, 16, null);
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
    }

    public /* synthetic */ v(y0 y0Var, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, List list, boolean z3, String str, int i4, kotlin.jvm.internal.u uVar) {
        this(y0Var, hVar, (i4 & 4) != 0 ? CollectionsKt__CollectionsKt.F() : list, (i4 & 8) != 0 ? false : z3, (i4 & 16) != 0 ? "???" : str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public List<a1> G0() {
        return this.f58434d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public y0 H0() {
        return this.f58432b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return this.f58435e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return new v(H0(), p(), G0(), z3, null, 16, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: P0 */
    public m0 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return this;
    }

    @NotNull
    public String Q0() {
        return this.f58436f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: R0 */
    public v M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return this.f58433c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(H0());
        sb.append(G0().isEmpty() ? "" : kotlin.collections.f0.W2(G0(), ", ", "<", ">", -1, "...", null));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public v(@NotNull y0 constructor, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, @NotNull List<? extends a1> arguments, boolean z3, @NotNull String presentableName) {
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        kotlin.jvm.internal.f0.p(presentableName, "presentableName");
        this.f58432b = constructor;
        this.f58433c = memberScope;
        this.f58434d = arguments;
        this.f58435e = z3;
        this.f58436f = presentableName;
    }
}

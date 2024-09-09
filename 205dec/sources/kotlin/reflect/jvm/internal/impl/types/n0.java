package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.w;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n0 extends m0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final y0 f58397b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<a1> f58398c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f58399d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f58400e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, m0> f58401f;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(@NotNull y0 constructor, @NotNull List<? extends a1> arguments, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends m0> refinedTypeFactory) {
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        kotlin.jvm.internal.f0.p(memberScope, "memberScope");
        kotlin.jvm.internal.f0.p(refinedTypeFactory, "refinedTypeFactory");
        this.f58397b = constructor;
        this.f58398c = arguments;
        this.f58399d = z3;
        this.f58400e = memberScope;
        this.f58401f = refinedTypeFactory;
        if (p() instanceof w.d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + p() + '\n' + H0());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public List<a1> G0() {
        return this.f58398c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public y0 H0() {
        return this.f58397b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return this.f58399d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        if (z3 == I0()) {
            return this;
        }
        if (z3) {
            return new k0(this);
        }
        return new i0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: P0 */
    public m0 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return newAnnotations.isEmpty() ? this : new j(this, newAnnotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: Q0 */
    public m0 M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        m0 invoke = this.f58401f.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return this.f58400e;
    }
}

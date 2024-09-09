package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: StubTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e extends m0 {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f58329e = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final y0 f58330b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f58331c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f58332d;

    /* compiled from: StubTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public e(@NotNull y0 originalTypeVariable, boolean z3) {
        kotlin.jvm.internal.f0.p(originalTypeVariable, "originalTypeVariable");
        this.f58330b = originalTypeVariable;
        this.f58331c = z3;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h h4 = w.h(kotlin.jvm.internal.f0.C("Scope for stub type: ", originalTypeVariable));
        kotlin.jvm.internal.f0.o(h4, "createErrorScope(\"Scope \u2026: $originalTypeVariable\")");
        this.f58332d = h4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public List<a1> G0() {
        List<a1> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return this.f58331c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: O0 */
    public m0 L0(boolean z3) {
        return z3 == I0() ? this : R0(z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: P0 */
    public m0 N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        kotlin.jvm.internal.f0.p(newAnnotations, "newAnnotations");
        return this;
    }

    @NotNull
    public final y0 Q0() {
        return this.f58330b;
    }

    @NotNull
    public abstract e R0(boolean z3);

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: S0 */
    public e M0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
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
        return this.f58332d;
    }
}

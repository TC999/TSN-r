package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends m0 implements r2.b {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final a1 f57818b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final b f57819c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f57820d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final f f57821e;

    public /* synthetic */ a(a1 a1Var, b bVar, boolean z3, f fVar, int i4, u uVar) {
        this(a1Var, (i4 & 2) != 0 ? new c(a1Var) : bVar, (i4 & 4) != 0 ? false : z3, (i4 & 8) != 0 ? f.f56241g0.b() : fVar);
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
        return this.f57820d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    /* renamed from: Q0 */
    public b H0() {
        return this.f57819c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: R0 */
    public a O0(boolean z3) {
        return z3 == I0() ? this : new a(this.f57818b, H0(), z3, getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: S0 */
    public a M0(@NotNull g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        a1 a4 = this.f57818b.a(kotlinTypeRefiner);
        f0.o(a4, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(a4, H0(), I0(), getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: T0 */
    public a P0(@NotNull f newAnnotations) {
        f0.p(newAnnotations, "newAnnotations");
        return new a(this.f57818b, H0(), I0(), newAnnotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public f getAnnotations() {
        return this.f57821e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public h p() {
        h i4 = w.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        f0.o(i4, "createErrorScope(\n      \u2026solution\", true\n        )");
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.f57818b);
        sb.append(')');
        sb.append(I0() ? "?" : "");
        return sb.toString();
    }

    public a(@NotNull a1 typeProjection, @NotNull b constructor, boolean z3, @NotNull f annotations) {
        f0.p(typeProjection, "typeProjection");
        f0.p(constructor, "constructor");
        f0.p(annotations, "annotations");
        this.f57818b = typeProjection;
        this.f57819c = constructor;
        this.f57820d = z3;
        this.f57821e = annotations;
    }
}

package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewCapturedType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i extends m0 implements r2.b {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CaptureStatus f58280b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final j f58281c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final l1 f58282d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f58283e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f58284f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f58285g;

    public /* synthetic */ i(CaptureStatus captureStatus, j jVar, l1 l1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, boolean z4, int i4, kotlin.jvm.internal.u uVar) {
        this(captureStatus, jVar, l1Var, (i4 & 8) != 0 ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b() : fVar, (i4 & 16) != 0 ? false : z3, (i4 & 32) != 0 ? false : z4);
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
        return this.f58284f;
    }

    @NotNull
    public final CaptureStatus Q0() {
        return this.f58280b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    /* renamed from: R0 */
    public j H0() {
        return this.f58281c;
    }

    @Nullable
    public final l1 S0() {
        return this.f58282d;
    }

    public final boolean T0() {
        return this.f58285g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: U0 */
    public i O0(boolean z3) {
        return new i(this.f58280b, H0(), this.f58282d, getAnnotations(), z3, false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: V0 */
    public i M0(@NotNull g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.f58280b;
        j a4 = H0().a(kotlinTypeRefiner);
        l1 l1Var = this.f58282d;
        return new i(captureStatus, a4, l1Var == null ? null : kotlinTypeRefiner.h(l1Var).K0(), getAnnotations(), I0(), false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m0
    @NotNull
    /* renamed from: W0 */
    public i P0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        f0.p(newAnnotations, "newAnnotations");
        return new i(this.f58280b, H0(), this.f58282d, newAnnotations, I0(), false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f58283e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h i4 = kotlin.reflect.jvm.internal.impl.types.w.i("No member resolution should be done on captured type!", true);
        f0.o(i4, "createErrorScope(\"No mem\u2026on captured type!\", true)");
        return i4;
    }

    public i(@NotNull CaptureStatus captureStatus, @NotNull j constructor, @Nullable l1 l1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, boolean z3, boolean z4) {
        f0.p(captureStatus, "captureStatus");
        f0.p(constructor, "constructor");
        f0.p(annotations, "annotations");
        this.f58280b = captureStatus;
        this.f58281c = constructor;
        this.f58282d = l1Var;
        this.f58283e = annotations;
        this.f58284f = z3;
        this.f58285g = z4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@NotNull CaptureStatus captureStatus, @Nullable l1 l1Var, @NotNull a1 projection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 typeParameter) {
        this(captureStatus, new j(projection, null, null, typeParameter, 6, null), l1Var, null, false, false, 56, null);
        f0.p(captureStatus, "captureStatus");
        f0.p(projection, "projection");
        f0.p(typeParameter, "typeParameter");
    }
}

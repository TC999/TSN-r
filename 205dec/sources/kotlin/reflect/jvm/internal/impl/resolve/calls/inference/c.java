package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.j;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c implements b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a1 f57822a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private j f57823b;

    public c(@NotNull a1 projection) {
        f0.p(projection, "projection");
        this.f57822a = projection;
        getProjection().c();
        Variance variance = Variance.INVARIANT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public /* bridge */ /* synthetic */ f b() {
        return (f) d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public boolean c() {
        return false;
    }

    @Nullable
    public Void d() {
        return null;
    }

    @Nullable
    public final j e() {
        return this.f57823b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: f */
    public c a(@NotNull g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        a1 a4 = getProjection().a(kotlinTypeRefiner);
        f0.o(a4, "projection.refine(kotlinTypeRefiner)");
        return new c(a4);
    }

    public final void g(@Nullable j jVar) {
        this.f57823b = jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.a1> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b
    @NotNull
    public a1 getProjection() {
        return this.f57822a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public Collection<e0> j() {
        e0 I;
        List l4;
        if (getProjection().c() == Variance.OUT_VARIANCE) {
            I = getProjection().getType();
        } else {
            I = k().I();
        }
        f0.o(I, "if (projection.projectio\u2026 builtIns.nullableAnyType");
        l4 = x.l(I);
        return l4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public h k() {
        h k4 = getProjection().getType().H0().k();
        f0.o(k4, "projection.type.constructor.builtIns");
        return k4;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + ')';
    }
}

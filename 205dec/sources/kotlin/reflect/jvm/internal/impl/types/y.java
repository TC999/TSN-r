package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class y extends l1 implements r2.e {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m0 f58455b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final m0 f58456c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@NotNull m0 lowerBound, @NotNull m0 upperBound) {
        super(null);
        kotlin.jvm.internal.f0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.f0.p(upperBound, "upperBound");
        this.f58455b = lowerBound;
        this.f58456c = upperBound;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public List<a1> G0() {
        return O0().G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public y0 H0() {
        return O0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return O0().I0();
    }

    @NotNull
    public abstract m0 O0();

    @NotNull
    public final m0 P0() {
        return this.f58455b;
    }

    @NotNull
    public final m0 Q0() {
        return this.f58456c;
    }

    @NotNull
    public abstract String R0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.renderer.d dVar);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return O0().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return O0().p();
    }

    @NotNull
    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.f57732j.y(this);
    }
}

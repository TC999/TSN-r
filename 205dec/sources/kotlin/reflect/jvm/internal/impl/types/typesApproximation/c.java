package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a1 f58425a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final e0 f58426b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final e0 f58427c;

    public c(@NotNull a1 typeParameter, @NotNull e0 inProjection, @NotNull e0 outProjection) {
        f0.p(typeParameter, "typeParameter");
        f0.p(inProjection, "inProjection");
        f0.p(outProjection, "outProjection");
        this.f58425a = typeParameter;
        this.f58426b = inProjection;
        this.f58427c = outProjection;
    }

    @NotNull
    public final e0 a() {
        return this.f58426b;
    }

    @NotNull
    public final e0 b() {
        return this.f58427c;
    }

    @NotNull
    public final a1 c() {
        return this.f58425a;
    }

    public final boolean d() {
        return e.f58276a.d(this.f58426b, this.f58427c);
    }
}

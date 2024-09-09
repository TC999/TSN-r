package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitution.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class o extends d1 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d1 f58402c;

    public o(@NotNull d1 substitution) {
        kotlin.jvm.internal.f0.p(substitution, "substitution");
        this.f58402c = substitution;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean a() {
        return this.f58402c.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean b() {
        return this.f58402c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        return this.f58402c.d(annotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @Nullable
    public a1 e(@NotNull e0 key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return this.f58402c.e(key);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean f() {
        return this.f58402c.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @NotNull
    public e0 g(@NotNull e0 topLevelType, @NotNull Variance position) {
        kotlin.jvm.internal.f0.p(topLevelType, "topLevelType");
        kotlin.jvm.internal.f0.p(position, "position");
        return this.f58402c.g(topLevelType, position);
    }
}

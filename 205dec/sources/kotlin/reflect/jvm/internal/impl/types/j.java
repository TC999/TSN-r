package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j extends q {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f58388c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull m0 delegate, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations) {
        super(delegate);
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        this.f58388c = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p
    @NotNull
    /* renamed from: U0 */
    public j S0(@NotNull m0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        return new j(delegate, getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.p, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f58388c;
    }
}

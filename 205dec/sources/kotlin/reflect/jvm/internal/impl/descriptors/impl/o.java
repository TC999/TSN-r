package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import org.jetbrains.annotations.NotNull;

/* compiled from: FieldDescriptorImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.b implements kotlin.reflect.jvm.internal.impl.descriptors.u {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final p0 f56426b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull p0 correspondingProperty) {
        super(annotations);
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(correspondingProperty, "correspondingProperty");
        this.f56426b = correspondingProperty;
    }
}

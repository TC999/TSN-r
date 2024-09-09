package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import r2.i;

/* compiled from: InlineClassRepresentation.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x<Type extends r2.i> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f56636a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Type f56637b;

    public x(@NotNull kotlin.reflect.jvm.internal.impl.name.f underlyingPropertyName, @NotNull Type underlyingType) {
        kotlin.jvm.internal.f0.p(underlyingPropertyName, "underlyingPropertyName");
        kotlin.jvm.internal.f0.p(underlyingType, "underlyingType");
        this.f56636a = underlyingPropertyName;
        this.f56637b = underlyingType;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f a() {
        return this.f56636a;
    }

    @NotNull
    public final Type b() {
        return this.f56637b;
    }
}

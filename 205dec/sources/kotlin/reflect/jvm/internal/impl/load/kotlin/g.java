package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaClassDataFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final n f57195a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final f f57196b;

    public g(@NotNull n kotlinClassFinder, @NotNull f deserializedDescriptorResolver) {
        f0.p(kotlinClassFinder, "kotlinClassFinder");
        f0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f57195a = kotlinClassFinder;
        this.f57196b = deserializedDescriptorResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    @Nullable
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.e a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        f0.p(classId, "classId");
        p a4 = o.a(this.f57195a, classId);
        if (a4 == null) {
            return null;
        }
        f0.g(a4.c(), classId);
        return this.f57196b.j(a4);
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q extends f implements m2.m {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Enum<?> f56613c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Enum<?> value) {
        super(fVar, null);
        f0.p(value, "value");
        this.f56613c = value;
    }

    @Override // m2.m
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.b d() {
        Class<?> enumClass = this.f56613c.getClass();
        if (!enumClass.isEnum()) {
            enumClass = enumClass.getEnclosingClass();
        }
        f0.o(enumClass, "enumClass");
        return d.a(enumClass);
    }

    @Override // m2.m
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f e() {
        return kotlin.reflect.jvm.internal.impl.name.f.f(this.f56613c.name());
    }
}

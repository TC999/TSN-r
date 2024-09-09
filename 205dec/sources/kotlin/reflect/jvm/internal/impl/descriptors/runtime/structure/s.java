package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s extends f implements m2.o {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Object f56615c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Object value) {
        super(fVar, null);
        f0.p(value, "value");
        this.f56615c = value;
    }

    @Override // m2.o
    @NotNull
    public Object getValue() {
        return this.f56615c;
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m extends f implements m2.h {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f56609c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Class<?> klass) {
        super(fVar, null);
        f0.p(klass, "klass");
        this.f56609c = klass;
    }

    @Override // m2.h
    @NotNull
    public m2.x b() {
        return z.f56622a.a(this.f56609c);
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g extends f implements m2.c {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Annotation f56594c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Annotation annotation) {
        super(fVar, null);
        f0.p(annotation, "annotation");
        this.f56594c = annotation;
    }

    @Override // m2.c
    @NotNull
    public m2.a a() {
        return new e(this.f56594c);
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectAnnotationSource.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b implements v0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Annotation f56547b;

    public b(@NotNull Annotation annotation) {
        f0.p(annotation, "annotation");
        this.f56547b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
    @NotNull
    public w0 b() {
        w0 NO_SOURCE_FILE = w0.f56635a;
        f0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public final Annotation d() {
        return this.f56547b;
    }
}

package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaTypeQualifiersByElementType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap<AnnotationQualifierApplicabilityType, p> f57094a;

    public v(@NotNull EnumMap<AnnotationQualifierApplicabilityType, p> defaultQualifiers) {
        f0.p(defaultQualifiers, "defaultQualifiers");
        this.f57094a = defaultQualifiers;
    }

    @Nullable
    public final p a(@Nullable AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.f57094a.get(annotationQualifierApplicabilityType);
    }

    @NotNull
    public final EnumMap<AnnotationQualifierApplicabilityType, p> b() {
        return this.f57094a;
    }
}

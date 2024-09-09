package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnnotationQualifiersFqNames.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56655a = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.meta.TypeQualifierNickname");
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56656b = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.meta.TypeQualifier");
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56657c = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.meta.TypeQualifierDefault");
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56658d = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.annotations.jvm.UnderMigration");
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final List<AnnotationQualifierApplicabilityType> f56659e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, p> f56660f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, p> f56661g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f56662h;

    static {
        List<AnnotationQualifierApplicabilityType> M;
        Map<kotlin.reflect.jvm.internal.impl.name.c, p> k4;
        List l4;
        List l5;
        Map W;
        Map<kotlin.reflect.jvm.internal.impl.name.c, p> n02;
        Set<kotlin.reflect.jvm.internal.impl.name.c> u3;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        M = CollectionsKt__CollectionsKt.M(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        f56659e = M;
        kotlin.reflect.jvm.internal.impl.name.c i4 = z.i();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        k4 = y0.k(l0.a(i4, new p(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(nullabilityQualifier, false, 2, null), M, false)));
        f56660f = k4;
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.ParametersAreNullableByDefault");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, false, 2, null);
        l4 = kotlin.collections.x.l(annotationQualifierApplicabilityType);
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.ParametersAreNonnullByDefault");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(nullabilityQualifier, false, 2, null);
        l5 = kotlin.collections.x.l(annotationQualifierApplicabilityType);
        W = z0.W(l0.a(cVar, new p(fVar, l4, false, 4, null)), l0.a(cVar2, new p(fVar2, l5, false, 4, null)));
        n02 = z0.n0(W, k4);
        f56661g = n02;
        u3 = j1.u(z.f(), z.e());
        f56662h = u3;
    }

    @NotNull
    public static final Map<kotlin.reflect.jvm.internal.impl.name.c, p> a() {
        return f56661g;
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> b() {
        return f56662h;
    }

    @NotNull
    public static final Map<kotlin.reflect.jvm.internal.impl.name.c, p> c() {
        return f56660f;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c d() {
        return f56658d;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c e() {
        return f56657c;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f() {
        return f56656b;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c g() {
        return f56655a;
    }
}

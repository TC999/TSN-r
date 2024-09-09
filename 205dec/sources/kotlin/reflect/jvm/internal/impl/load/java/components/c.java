package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.z0;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f56688a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56689b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56690c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56691d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> f56692e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> f56693f;

    static {
        Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> W;
        Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> W2;
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f("message");
        f0.o(f4, "identifier(\"message\")");
        f56689b = f4;
        kotlin.reflect.jvm.internal.impl.name.f f5 = kotlin.reflect.jvm.internal.impl.name.f.f("allowedTargets");
        f0.o(f5, "identifier(\"allowedTargets\")");
        f56690c = f5;
        kotlin.reflect.jvm.internal.impl.name.f f6 = kotlin.reflect.jvm.internal.impl.name.f.f("value");
        f0.o(f6, "identifier(\"value\")");
        f56691d = f6;
        kotlin.reflect.jvm.internal.impl.name.c cVar = j.a.F;
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = y.f57108d;
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = j.a.I;
        kotlin.reflect.jvm.internal.impl.name.c cVar4 = y.f57110f;
        kotlin.reflect.jvm.internal.impl.name.c cVar5 = j.a.K;
        kotlin.reflect.jvm.internal.impl.name.c cVar6 = y.f57113i;
        W = z0.W(l0.a(cVar, cVar2), l0.a(cVar3, cVar4), l0.a(cVar5, cVar6));
        f56692e = W;
        W2 = z0.W(l0.a(cVar2, cVar), l0.a(cVar4, cVar3), l0.a(y.f57112h, j.a.f56139y), l0.a(cVar6, cVar5));
        f56693f = W2;
    }

    private c() {
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.c f(c cVar, m2.a aVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return cVar.e(aVar, hVar, z3);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(@NotNull kotlin.reflect.jvm.internal.impl.name.c kotlinName, @NotNull m2.d annotationOwner, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4) {
        m2.a b4;
        f0.p(kotlinName, "kotlinName");
        f0.p(annotationOwner, "annotationOwner");
        f0.p(c4, "c");
        if (f0.g(kotlinName, j.a.f56139y)) {
            kotlin.reflect.jvm.internal.impl.name.c DEPRECATED_ANNOTATION = y.f57112h;
            f0.o(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            m2.a b5 = annotationOwner.b(DEPRECATED_ANNOTATION);
            if (b5 != null || annotationOwner.B()) {
                return new e(b5, c4);
            }
        }
        kotlin.reflect.jvm.internal.impl.name.c cVar = f56692e.get(kotlinName);
        if (cVar == null || (b4 = annotationOwner.b(cVar)) == null) {
            return null;
        }
        return f(f56688a, b4, c4, false, 4, null);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f b() {
        return f56689b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f c() {
        return f56691d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f d() {
        return f56690c;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e(@NotNull m2.a annotation, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, boolean z3) {
        f0.p(annotation, "annotation");
        f0.p(c4, "c");
        kotlin.reflect.jvm.internal.impl.name.b c5 = annotation.c();
        if (f0.g(c5, kotlin.reflect.jvm.internal.impl.name.b.m(y.f57108d))) {
            return new i(annotation, c4);
        }
        if (f0.g(c5, kotlin.reflect.jvm.internal.impl.name.b.m(y.f57110f))) {
            return new h(annotation, c4);
        }
        if (f0.g(c5, kotlin.reflect.jvm.internal.impl.name.b.m(y.f57113i))) {
            return new b(c4, annotation, j.a.K);
        }
        if (f0.g(c5, kotlin.reflect.jvm.internal.impl.name.b.m(y.f57112h))) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e(c4, annotation, z3);
    }
}

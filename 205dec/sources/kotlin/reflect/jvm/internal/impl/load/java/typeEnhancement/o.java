package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.types.checker.q;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: typeEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final b f57085a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final b f57086b;

    /* compiled from: typeEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57087a;

        static {
            int[] iArr = new int[NullabilityQualifier.values().length];
            iArr[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            f57087a = iArr;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.c ENHANCED_NULLABILITY_ANNOTATION = y.f57123s;
        f0.o(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        f57085a = new b(ENHANCED_NULLABILITY_ANNOTATION);
        kotlin.reflect.jvm.internal.impl.name.c ENHANCED_MUTABILITY_ANNOTATION = y.f57124t;
        f0.o(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        f57086b = new b(ENHANCED_MUTABILITY_ANNOTATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> list) {
        Object S4;
        List G5;
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                G5 = kotlin.collections.f0.G5(list);
                return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(G5);
            }
            S4 = kotlin.collections.f0.S4(list);
            return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.f) S4;
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.f g(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, d dVar, TypeComponentPosition typeComponentPosition) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f56177a;
        if (m.a(typeComponentPosition) && (fVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            if (dVar.c() == MutabilityQualifier.READ_ONLY && typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) fVar;
                if (dVar2.c(dVar3)) {
                    return dVar2.a(dVar3);
                }
            }
            if (dVar.c() == MutabilityQualifier.MUTABLE && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar4 = (kotlin.reflect.jvm.internal.impl.descriptors.d) fVar;
                if (dVar2.e(dVar4)) {
                    return dVar2.b(dVar4);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean h(d dVar, TypeComponentPosition typeComponentPosition) {
        if (m.a(typeComponentPosition)) {
            NullabilityQualifier d4 = dVar.d();
            int i4 = d4 == null ? -1 : a.f57087a[d4.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return null;
                }
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return null;
    }

    public static final boolean i(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return p.b(q.f58304a, e0Var);
    }
}

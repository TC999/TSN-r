package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface h extends m2.d {

    /* compiled from: ReflectJavaAnnotationOwner.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static e a(@NotNull h hVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            Annotation[] declaredAnnotations;
            f0.p(hVar, "this");
            f0.p(fqName, "fqName");
            AnnotatedElement r3 = hVar.r();
            if (r3 == null || (declaredAnnotations = r3.getDeclaredAnnotations()) == null) {
                return null;
            }
            return i.a(declaredAnnotations, fqName);
        }

        @NotNull
        public static List<e> b(@NotNull h hVar) {
            List<e> F;
            f0.p(hVar, "this");
            AnnotatedElement r3 = hVar.r();
            Annotation[] declaredAnnotations = r3 == null ? null : r3.getDeclaredAnnotations();
            if (declaredAnnotations == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return i.b(declaredAnnotations);
        }

        public static boolean c(@NotNull h hVar) {
            f0.p(hVar, "this");
            return false;
        }
    }

    @Nullable
    AnnotatedElement r();
}

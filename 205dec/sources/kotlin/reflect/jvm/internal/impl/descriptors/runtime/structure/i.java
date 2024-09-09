package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @Nullable
    public static final e a(@NotNull Annotation[] annotationArr, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        Annotation annotation;
        f0.p(annotationArr, "<this>");
        f0.p(fqName, "fqName");
        int length = annotationArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i4];
            i4++;
            if (f0.g(d.a(c2.a.c(c2.a.a(annotation))).b(), fqName)) {
                break;
            }
        }
        if (annotation == null) {
            return null;
        }
        return new e(annotation);
    }

    @NotNull
    public static final List<e> b(@NotNull Annotation[] annotationArr) {
        f0.p(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        int length = annotationArr.length;
        int i4 = 0;
        while (i4 < length) {
            Annotation annotation = annotationArr[i4];
            i4++;
            arrayList.add(new e(annotation));
        }
        return arrayList;
    }
}

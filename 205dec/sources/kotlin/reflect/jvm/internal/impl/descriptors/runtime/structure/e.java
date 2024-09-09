package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f;
import m2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotation.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends p implements m2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Annotation f56591a;

    public e(@NotNull Annotation annotation) {
        f0.p(annotation, "annotation");
        this.f56591a = annotation;
    }

    @Override // m2.a
    public boolean D() {
        return a.C1230a.a(this);
    }

    @NotNull
    public final Annotation P() {
        return this.f56591a;
    }

    @Override // m2.a
    @NotNull
    /* renamed from: Q */
    public l t() {
        return new l(c2.a.c(c2.a.a(this.f56591a)));
    }

    @Override // m2.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.b c() {
        return d.a(c2.a.c(c2.a.a(this.f56591a)));
    }

    @Override // m2.a
    public boolean d() {
        return a.C1230a.b(this);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof e) && f0.g(this.f56591a, ((e) obj).f56591a);
    }

    @Override // m2.a
    @NotNull
    public Collection<m2.b> getArguments() {
        Method[] declaredMethods = c2.a.c(c2.a.a(this.f56591a)).getDeclaredMethods();
        f0.o(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        int length = declaredMethods.length;
        int i4 = 0;
        while (i4 < length) {
            Method method = declaredMethods[i4];
            i4++;
            f.a aVar = f.f56592b;
            Object invoke = method.invoke(P(), new Object[0]);
            f0.o(invoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(invoke, kotlin.reflect.jvm.internal.impl.name.f.f(method.getName())));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f56591a.hashCode();
    }

    @NotNull
    public String toString() {
        return e.class.getName() + ": " + this.f56591a;
    }
}

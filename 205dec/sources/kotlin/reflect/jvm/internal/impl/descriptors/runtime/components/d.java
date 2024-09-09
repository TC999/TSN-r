package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.java.n;
import kotlin.text.w;
import m2.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d implements n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ClassLoader f56549a;

    public d(@NotNull ClassLoader classLoader) {
        f0.p(classLoader, "classLoader");
        this.f56549a = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.n
    @Nullable
    public m2.g a(@NotNull n.a request) {
        String j22;
        f0.p(request, "request");
        kotlin.reflect.jvm.internal.impl.name.b a4 = request.a();
        kotlin.reflect.jvm.internal.impl.name.c h4 = a4.h();
        f0.o(h4, "classId.packageFqName");
        String b4 = a4.i().b();
        f0.o(b4, "classId.relativeClassName.asString()");
        j22 = w.j2(b4, '.', '$', false, 4, null);
        if (!h4.d()) {
            j22 = h4.b() + '.' + j22;
        }
        Class<?> a5 = e.a(this.f56549a, j22);
        if (a5 != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l(a5);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.n
    @Nullable
    public u b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.w(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.n
    @Nullable
    public Set<String> c(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        f0.p(packageFqName, "packageFqName");
        return null;
    }
}

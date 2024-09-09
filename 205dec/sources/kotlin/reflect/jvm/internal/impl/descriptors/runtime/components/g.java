package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g implements n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ClassLoader f56553a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.d f56554b;

    public g(@NotNull ClassLoader classLoader) {
        f0.p(classLoader, "classLoader");
        this.f56553a = classLoader;
        this.f56554b = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.d();
    }

    private final n.a d(String str) {
        f a4;
        Class<?> a5 = e.a(this.f56553a, str);
        if (a5 == null || (a4 = f.f56550c.a(a5)) == null) {
            return null;
        }
        return new n.a.b(a4, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.s
    @Nullable
    public InputStream a(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        f0.p(packageFqName, "packageFqName");
        if (packageFqName.i(kotlin.reflect.jvm.internal.impl.builtins.j.f56083l)) {
            return this.f56554b.a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f57975n.n(packageFqName));
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.n
    @Nullable
    public n.a b(@NotNull m2.g javaClass) {
        f0.p(javaClass, "javaClass");
        kotlin.reflect.jvm.internal.impl.name.c e4 = javaClass.e();
        if (e4 == null) {
            return null;
        }
        String b4 = e4.b();
        f0.o(b4, "javaClass.fqName?.asString() ?: return null");
        return d(b4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.n
    @Nullable
    public n.a c(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        String b4;
        f0.p(classId, "classId");
        b4 = h.b(classId);
        return d(b4);
    }
}

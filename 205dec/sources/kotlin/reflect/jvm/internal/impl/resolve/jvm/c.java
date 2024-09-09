package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.g;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaDescriptorResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final g f57876a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.g f57877b;

    public c(@NotNull g packageFragmentProvider, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache) {
        f0.p(packageFragmentProvider, "packageFragmentProvider");
        f0.p(javaResolverCache, "javaResolverCache");
        this.f57876a = packageFragmentProvider;
        this.f57877b = javaResolverCache;
    }

    @NotNull
    public final g a() {
        return this.f57876a;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull m2.g javaClass) {
        Object r22;
        f0.p(javaClass, "javaClass");
        kotlin.reflect.jvm.internal.impl.name.c e4 = javaClass.e();
        if (e4 != null && javaClass.I() == LightClassOriginKind.SOURCE) {
            return this.f57877b.d(e4);
        }
        m2.g f4 = javaClass.f();
        if (f4 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d b4 = b(f4);
            h U = b4 == null ? null : b4.U();
            f h4 = U == null ? null : U.h(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER);
            if (h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.d) h4;
            }
            return null;
        } else if (e4 == null) {
            return null;
        } else {
            g gVar = this.f57876a;
            kotlin.reflect.jvm.internal.impl.name.c e5 = e4.e();
            f0.o(e5, "fqName.parent()");
            r22 = kotlin.collections.f0.r2(gVar.a(e5));
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h hVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h) r22;
            if (hVar == null) {
                return null;
            }
            return hVar.G0(javaClass);
        }
    }
}

package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import k2.c;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.load.java.components.f;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.d;
import kotlin.reflect.jvm.internal.impl.load.java.o;
import kotlin.reflect.jvm.internal.impl.load.java.u;
import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializationComponentsForJava.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* compiled from: DeserializationComponentsForJava.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements kotlin.reflect.jvm.internal.impl.load.java.lazy.b {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.b
        @Nullable
        public List<m2.a> a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
            f0.p(classId, "classId");
            return null;
        }
    }

    @NotNull
    public static final d a(@NotNull d0 module, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.g lazyJavaPackageFragmentProvider, @NotNull n reflectKotlinClassFinder, @NotNull f deserializedDescriptorResolver, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.p errorReporter) {
        f0.p(module, "module");
        f0.p(storageManager, "storageManager");
        f0.p(notFoundClasses, "notFoundClasses");
        f0.p(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        f0.p(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        f0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        f0.p(errorReporter, "errorReporter");
        return new d(storageManager, module, j.a.f58137a, new g(reflectKotlinClassFinder, deserializedDescriptorResolver), new b(module, notFoundClasses, storageManager, reflectKotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter, c.a.f55236a, kotlin.reflect.jvm.internal.impl.serialization.deserialization.h.f58114a.a(), kotlin.reflect.jvm.internal.impl.types.checker.l.f58296b.a());
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.g b(@NotNull kotlin.reflect.jvm.internal.impl.load.java.n javaClassFinder, @NotNull d0 module, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 notFoundClasses, @NotNull n reflectKotlinClassFinder, @NotNull f deserializedDescriptorResolver, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.p errorReporter, @NotNull l2.b javaSourceElementFactory, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.j singleModuleClassResolver, @NotNull v packagePartProvider) {
        List F;
        f0.p(javaClassFinder, "javaClassFinder");
        f0.p(module, "module");
        f0.p(storageManager, "storageManager");
        f0.p(notFoundClasses, "notFoundClasses");
        f0.p(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        f0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        f0.p(errorReporter, "errorReporter");
        f0.p(javaSourceElementFactory, "javaSourceElementFactory");
        f0.p(singleModuleClassResolver, "singleModuleClassResolver");
        f0.p(packagePartProvider, "packagePartProvider");
        u.b bVar = kotlin.reflect.jvm.internal.impl.load.java.u.f57088d;
        kotlin.reflect.jvm.internal.impl.load.java.b bVar2 = new kotlin.reflect.jvm.internal.impl.load.java.b(storageManager, bVar.a());
        kotlin.reflect.jvm.internal.impl.load.java.u a4 = bVar.a();
        kotlin.reflect.jvm.internal.impl.load.java.components.j DO_NOTHING = kotlin.reflect.jvm.internal.impl.load.java.components.j.f56709a;
        f0.o(DO_NOTHING, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.load.java.components.g EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.g.f56702a;
        f0.o(EMPTY, "EMPTY");
        f.a aVar = f.a.f56701a;
        F = CollectionsKt__CollectionsKt.F();
        p2.b bVar3 = new p2.b(storageManager, F);
        y0.a aVar2 = y0.a.f56639a;
        c.a aVar3 = c.a.f55236a;
        kotlin.reflect.jvm.internal.impl.builtins.i iVar = new kotlin.reflect.jvm.internal.impl.builtins.i(module, notFoundClasses);
        kotlin.reflect.jvm.internal.impl.load.java.u a5 = bVar.a();
        d.b bVar4 = d.b.f56775b;
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.g(new kotlin.reflect.jvm.internal.impl.load.java.lazy.c(storageManager, javaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, errorReporter, EMPTY, aVar, bVar3, javaSourceElementFactory, singleModuleClassResolver, packagePartProvider, aVar2, aVar3, module, iVar, bVar2, new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i(bVar2, a5, new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c(bVar4)), o.a.f56973a, bVar4, kotlin.reflect.jvm.internal.impl.types.checker.l.f58296b.a(), a4, new a(), null, 8388608, null));
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g c(kotlin.reflect.jvm.internal.impl.load.java.n nVar, d0 d0Var, kotlin.reflect.jvm.internal.impl.storage.n nVar2, kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, n nVar3, f fVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.p pVar, l2.b bVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.j jVar, v vVar, int i4, Object obj) {
        return b(nVar, d0Var, nVar2, f0Var, nVar3, fVar, pVar, bVar, jVar, (i4 & 512) != 0 ? v.a.f57260a : vVar);
    }
}

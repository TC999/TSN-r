package kotlin.reflect.jvm.internal.impl.load.kotlin;

import h2.a;
import h2.c;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeserializationComponentsForJava.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f57183b = new a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.i f57184a;

    /* compiled from: DeserializationComponentsForJava.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: DeserializationComponentsForJava.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1149a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final d f57185a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final f f57186b;

            public C1149a(@NotNull d deserializationComponentsForJava, @NotNull f deserializedDescriptorResolver) {
                f0.p(deserializationComponentsForJava, "deserializationComponentsForJava");
                f0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
                this.f57185a = deserializationComponentsForJava;
                this.f57186b = deserializedDescriptorResolver;
            }

            @NotNull
            public final d a() {
                return this.f57185a;
            }

            @NotNull
            public final f b() {
                return this.f57186b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final C1149a a(@NotNull n kotlinClassFinder, @NotNull n jvmBuiltInsKotlinClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.load.java.n javaClassFinder, @NotNull String moduleName, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.p errorReporter, @NotNull l2.b javaSourceElementFactory) {
            List F;
            List M;
            f0.p(kotlinClassFinder, "kotlinClassFinder");
            f0.p(jvmBuiltInsKotlinClassFinder, "jvmBuiltInsKotlinClassFinder");
            f0.p(javaClassFinder, "javaClassFinder");
            f0.p(moduleName, "moduleName");
            f0.p(errorReporter, "errorReporter");
            f0.p(javaSourceElementFactory, "javaSourceElementFactory");
            kotlin.reflect.jvm.internal.impl.storage.f fVar = new kotlin.reflect.jvm.internal.impl.storage.f("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(fVar, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            kotlin.reflect.jvm.internal.impl.name.f i4 = kotlin.reflect.jvm.internal.impl.name.f.i('<' + moduleName + '>');
            f0.o(i4, "special(\"<$moduleName>\")");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.x xVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.x(i4, fVar, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.C0(xVar);
            jvmBuiltIns.H0(xVar, true);
            f fVar2 = new f();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.k();
            kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var = new kotlin.reflect.jvm.internal.impl.descriptors.f0(fVar, xVar);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g c4 = e.c(javaClassFinder, xVar, fVar, f0Var, kotlinClassFinder, fVar2, errorReporter, javaSourceElementFactory, kVar, null, 512, null);
            d a4 = e.a(xVar, fVar, f0Var, c4, kotlinClassFinder, fVar2, errorReporter);
            fVar2.m(a4);
            kotlin.reflect.jvm.internal.impl.load.java.components.g EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.g.f56702a;
            f0.o(EMPTY, "EMPTY");
            kotlin.reflect.jvm.internal.impl.resolve.jvm.c cVar = new kotlin.reflect.jvm.internal.impl.resolve.jvm.c(c4, EMPTY);
            kVar.c(cVar);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.f G0 = jvmBuiltIns.G0();
            kotlin.reflect.jvm.internal.impl.builtins.jvm.f G02 = jvmBuiltIns.G0();
            j.a aVar = j.a.f58137a;
            kotlin.reflect.jvm.internal.impl.types.checker.m a5 = kotlin.reflect.jvm.internal.impl.types.checker.l.f58296b.a();
            F = CollectionsKt__CollectionsKt.F();
            kotlin.reflect.jvm.internal.impl.builtins.jvm.g gVar = new kotlin.reflect.jvm.internal.impl.builtins.jvm.g(fVar, jvmBuiltInsKotlinClassFinder, xVar, f0Var, G0, G02, aVar, a5, new p2.b(fVar, F));
            xVar.T0(xVar);
            M = CollectionsKt__CollectionsKt.M(cVar.a(), gVar);
            xVar.N0(new kotlin.reflect.jvm.internal.impl.descriptors.impl.i(M, f0.C("CompositeProvider@RuntimeModuleData for ", xVar)));
            return new C1149a(a4, fVar2);
        }
    }

    public d(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d0 moduleDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.j configuration, @NotNull g classDataFinder, @NotNull b annotationAndConstantLoader, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.g packageFragmentProvider, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.p errorReporter, @NotNull k2.c lookupTracker, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.h contractDeserializer, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker) {
        List F;
        List F2;
        f0.p(storageManager, "storageManager");
        f0.p(moduleDescriptor, "moduleDescriptor");
        f0.p(configuration, "configuration");
        f0.p(classDataFinder, "classDataFinder");
        f0.p(annotationAndConstantLoader, "annotationAndConstantLoader");
        f0.p(packageFragmentProvider, "packageFragmentProvider");
        f0.p(notFoundClasses, "notFoundClasses");
        f0.p(errorReporter, "errorReporter");
        f0.p(lookupTracker, "lookupTracker");
        f0.p(contractDeserializer, "contractDeserializer");
        f0.p(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.reflect.jvm.internal.impl.builtins.h k4 = moduleDescriptor.k();
        JvmBuiltIns jvmBuiltIns = k4 instanceof JvmBuiltIns ? (JvmBuiltIns) k4 : null;
        t.a aVar = t.a.f58165a;
        h hVar = h.f57197a;
        F = CollectionsKt__CollectionsKt.F();
        h2.a G0 = jvmBuiltIns == null ? a.C1078a.f54734a : jvmBuiltIns.G0();
        h2.c G02 = jvmBuiltIns == null ? c.b.f54736a : jvmBuiltIns.G0();
        kotlin.reflect.jvm.internal.impl.protobuf.f a4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a.a();
        F2 = CollectionsKt__CollectionsKt.F();
        this.f57184a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.i(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, aVar, errorReporter, lookupTracker, hVar, F, notFoundClasses, contractDeserializer, G0, G02, a4, kotlinTypeChecker, new p2.b(storageManager, F2), null, 262144, null);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.i a() {
        return this.f57184a;
    }
}

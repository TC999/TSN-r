package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h2.a;
import h2.c;
import h2.e;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: context.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f58117a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d0 f58118b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final j f58119c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final f f58120d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final b<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f58121e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final h0 f58122f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final t f58123g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final p f58124h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final k2.c f58125i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final q f58126j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final Iterable<h2.b> f58127k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final f0 f58128l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final h f58129m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final h2.a f58130n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final h2.c f58131o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.f f58132p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.l f58133q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final p2.a f58134r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final h2.e f58135s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final g f58136t;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d0 moduleDescriptor, @NotNull j configuration, @NotNull f classDataFinder, @NotNull b<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> annotationAndConstantLoader, @NotNull h0 packageFragmentProvider, @NotNull t localClassifierTypeSettings, @NotNull p errorReporter, @NotNull k2.c lookupTracker, @NotNull q flexibleTypeDeserializer, @NotNull Iterable<? extends h2.b> fictitiousClassDescriptorFactories, @NotNull f0 notFoundClasses, @NotNull h contractDeserializer, @NotNull h2.a additionalClassPartsProvider, @NotNull h2.c platformDependentDeclarationFilter, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.f extensionRegistryLite, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker, @NotNull p2.a samConversionResolver, @NotNull h2.e platformDependentTypeTransformer) {
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.f0.p(configuration, "configuration");
        kotlin.jvm.internal.f0.p(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.f0.p(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.f0.p(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.f0.p(localClassifierTypeSettings, "localClassifierTypeSettings");
        kotlin.jvm.internal.f0.p(errorReporter, "errorReporter");
        kotlin.jvm.internal.f0.p(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.f0.p(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        kotlin.jvm.internal.f0.p(fictitiousClassDescriptorFactories, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.f0.p(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.f0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.f0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.f0.p(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.f0.p(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.f0.p(samConversionResolver, "samConversionResolver");
        kotlin.jvm.internal.f0.p(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        this.f58117a = storageManager;
        this.f58118b = moduleDescriptor;
        this.f58119c = configuration;
        this.f58120d = classDataFinder;
        this.f58121e = annotationAndConstantLoader;
        this.f58122f = packageFragmentProvider;
        this.f58123g = localClassifierTypeSettings;
        this.f58124h = errorReporter;
        this.f58125i = lookupTracker;
        this.f58126j = flexibleTypeDeserializer;
        this.f58127k = fictitiousClassDescriptorFactories;
        this.f58128l = notFoundClasses;
        this.f58129m = contractDeserializer;
        this.f58130n = additionalClassPartsProvider;
        this.f58131o = platformDependentDeclarationFilter;
        this.f58132p = extensionRegistryLite;
        this.f58133q = kotlinTypeChecker;
        this.f58134r = samConversionResolver;
        this.f58135s = platformDependentTypeTransformer;
        this.f58136t = new g(this);
    }

    @NotNull
    public final k a(@NotNull g0 descriptor, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h versionRequirementTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar) {
        List F;
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.f0.p(typeTable, "typeTable");
        kotlin.jvm.internal.f0.p(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.f0.p(metadataVersion, "metadataVersion");
        F = CollectionsKt__CollectionsKt.F();
        return new k(this, nameResolver, descriptor, typeTable, versionRequirementTable, metadataVersion, fVar, null, F);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.f0.p(classId, "classId");
        return g.e(this.f58136t, classId, null, 2, null);
    }

    @NotNull
    public final h2.a c() {
        return this.f58130n;
    }

    @NotNull
    public final b<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d() {
        return this.f58121e;
    }

    @NotNull
    public final f e() {
        return this.f58120d;
    }

    @NotNull
    public final g f() {
        return this.f58136t;
    }

    @NotNull
    public final j g() {
        return this.f58119c;
    }

    @NotNull
    public final h h() {
        return this.f58129m;
    }

    @NotNull
    public final p i() {
        return this.f58124h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.protobuf.f j() {
        return this.f58132p;
    }

    @NotNull
    public final Iterable<h2.b> k() {
        return this.f58127k;
    }

    @NotNull
    public final q l() {
        return this.f58126j;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.checker.l m() {
        return this.f58133q;
    }

    @NotNull
    public final t n() {
        return this.f58123g;
    }

    @NotNull
    public final k2.c o() {
        return this.f58125i;
    }

    @NotNull
    public final d0 p() {
        return this.f58118b;
    }

    @NotNull
    public final f0 q() {
        return this.f58128l;
    }

    @NotNull
    public final h0 r() {
        return this.f58122f;
    }

    @NotNull
    public final h2.c s() {
        return this.f58131o;
    }

    @NotNull
    public final h2.e t() {
        return this.f58135s;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n u() {
        return this.f58117a;
    }

    public /* synthetic */ i(kotlin.reflect.jvm.internal.impl.storage.n nVar, d0 d0Var, j jVar, f fVar, b bVar, h0 h0Var, t tVar, p pVar, k2.c cVar, q qVar, Iterable iterable, f0 f0Var, h hVar, h2.a aVar, h2.c cVar2, kotlin.reflect.jvm.internal.impl.protobuf.f fVar2, kotlin.reflect.jvm.internal.impl.types.checker.l lVar, p2.a aVar2, h2.e eVar, int i4, kotlin.jvm.internal.u uVar) {
        this(nVar, d0Var, jVar, fVar, bVar, h0Var, tVar, pVar, cVar, qVar, iterable, f0Var, hVar, (i4 & 8192) != 0 ? a.C1078a.f54734a : aVar, (i4 & 16384) != 0 ? c.a.f54735a : cVar2, fVar2, (65536 & i4) != 0 ? kotlin.reflect.jvm.internal.impl.types.checker.l.f58296b.a() : lVar, aVar2, (i4 & 262144) != 0 ? e.a.f54738a : eVar);
    }
}

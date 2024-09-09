package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.load.java.o;
import kotlin.reflect.jvm.internal.impl.load.java.u;
import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: context.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final n f56749a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.n f56750b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.n f56751c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.f f56752d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.j f56753e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final p f56754f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.g f56755g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.f f56756h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final p2.a f56757i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final l2.b f56758j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final j f56759k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final v f56760l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final y0 f56761m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final k2.c f56762n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final d0 f56763o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.i f56764p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.b f56765q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i f56766r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final o f56767s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final d f56768t;
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.l f56769u;
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    private final u f56770v;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private final b f56771w;
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.e f56772x;

    public c(@NotNull n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.load.java.n finder, @NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.n kotlinClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.f deserializedDescriptorResolver, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.j signaturePropagator, @NotNull p errorReporter, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.f javaPropertyInitializerEvaluator, @NotNull p2.a samConversionResolver, @NotNull l2.b sourceElementFactory, @NotNull j moduleClassResolver, @NotNull v packagePartProvider, @NotNull y0 supertypeLoopChecker, @NotNull k2.c lookupTracker, @NotNull d0 module, @NotNull kotlin.reflect.jvm.internal.impl.builtins.i reflectionTypes, @NotNull kotlin.reflect.jvm.internal.impl.load.java.b annotationTypeQualifierResolver, @NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i signatureEnhancement, @NotNull o javaClassesTracker, @NotNull d settings, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker, @NotNull u javaTypeEnhancementState, @NotNull b javaModuleResolver, @NotNull kotlin.reflect.jvm.internal.impl.resolve.jvm.e syntheticPartsProvider) {
        f0.p(storageManager, "storageManager");
        f0.p(finder, "finder");
        f0.p(kotlinClassFinder, "kotlinClassFinder");
        f0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        f0.p(signaturePropagator, "signaturePropagator");
        f0.p(errorReporter, "errorReporter");
        f0.p(javaResolverCache, "javaResolverCache");
        f0.p(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        f0.p(samConversionResolver, "samConversionResolver");
        f0.p(sourceElementFactory, "sourceElementFactory");
        f0.p(moduleClassResolver, "moduleClassResolver");
        f0.p(packagePartProvider, "packagePartProvider");
        f0.p(supertypeLoopChecker, "supertypeLoopChecker");
        f0.p(lookupTracker, "lookupTracker");
        f0.p(module, "module");
        f0.p(reflectionTypes, "reflectionTypes");
        f0.p(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        f0.p(signatureEnhancement, "signatureEnhancement");
        f0.p(javaClassesTracker, "javaClassesTracker");
        f0.p(settings, "settings");
        f0.p(kotlinTypeChecker, "kotlinTypeChecker");
        f0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        f0.p(javaModuleResolver, "javaModuleResolver");
        f0.p(syntheticPartsProvider, "syntheticPartsProvider");
        this.f56749a = storageManager;
        this.f56750b = finder;
        this.f56751c = kotlinClassFinder;
        this.f56752d = deserializedDescriptorResolver;
        this.f56753e = signaturePropagator;
        this.f56754f = errorReporter;
        this.f56755g = javaResolverCache;
        this.f56756h = javaPropertyInitializerEvaluator;
        this.f56757i = samConversionResolver;
        this.f56758j = sourceElementFactory;
        this.f56759k = moduleClassResolver;
        this.f56760l = packagePartProvider;
        this.f56761m = supertypeLoopChecker;
        this.f56762n = lookupTracker;
        this.f56763o = module;
        this.f56764p = reflectionTypes;
        this.f56765q = annotationTypeQualifierResolver;
        this.f56766r = signatureEnhancement;
        this.f56767s = javaClassesTracker;
        this.f56768t = settings;
        this.f56769u = kotlinTypeChecker;
        this.f56770v = javaTypeEnhancementState;
        this.f56771w = javaModuleResolver;
        this.f56772x = syntheticPartsProvider;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.b a() {
        return this.f56765q;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.f b() {
        return this.f56752d;
    }

    @NotNull
    public final p c() {
        return this.f56754f;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.n d() {
        return this.f56750b;
    }

    @NotNull
    public final o e() {
        return this.f56767s;
    }

    @NotNull
    public final b f() {
        return this.f56771w;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.components.f g() {
        return this.f56756h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.components.g h() {
        return this.f56755g;
    }

    @NotNull
    public final u i() {
        return this.f56770v;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.n j() {
        return this.f56751c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.checker.l k() {
        return this.f56769u;
    }

    @NotNull
    public final k2.c l() {
        return this.f56762n;
    }

    @NotNull
    public final d0 m() {
        return this.f56763o;
    }

    @NotNull
    public final j n() {
        return this.f56759k;
    }

    @NotNull
    public final v o() {
        return this.f56760l;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.builtins.i p() {
        return this.f56764p;
    }

    @NotNull
    public final d q() {
        return this.f56768t;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i r() {
        return this.f56766r;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.components.j s() {
        return this.f56753e;
    }

    @NotNull
    public final l2.b t() {
        return this.f56758j;
    }

    @NotNull
    public final n u() {
        return this.f56749a;
    }

    @NotNull
    public final y0 v() {
        return this.f56761m;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.e w() {
        return this.f56772x;
    }

    @NotNull
    public final c x(@NotNull kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache) {
        f0.p(javaResolverCache, "javaResolverCache");
        return new c(this.f56749a, this.f56750b, this.f56751c, this.f56752d, this.f56753e, this.f56754f, javaResolverCache, this.f56756h, this.f56757i, this.f56758j, this.f56759k, this.f56760l, this.f56761m, this.f56762n, this.f56763o, this.f56764p, this.f56765q, this.f56766r, this.f56767s, this.f56768t, this.f56769u, this.f56770v, this.f56771w, null, 8388608, null);
    }

    public /* synthetic */ c(n nVar, kotlin.reflect.jvm.internal.impl.load.java.n nVar2, kotlin.reflect.jvm.internal.impl.load.kotlin.n nVar3, kotlin.reflect.jvm.internal.impl.load.kotlin.f fVar, kotlin.reflect.jvm.internal.impl.load.java.components.j jVar, p pVar, kotlin.reflect.jvm.internal.impl.load.java.components.g gVar, kotlin.reflect.jvm.internal.impl.load.java.components.f fVar2, p2.a aVar, l2.b bVar, j jVar2, v vVar, y0 y0Var, k2.c cVar, d0 d0Var, kotlin.reflect.jvm.internal.impl.builtins.i iVar, kotlin.reflect.jvm.internal.impl.load.java.b bVar2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVar2, o oVar, d dVar, kotlin.reflect.jvm.internal.impl.types.checker.l lVar, u uVar, b bVar3, kotlin.reflect.jvm.internal.impl.resolve.jvm.e eVar, int i4, kotlin.jvm.internal.u uVar2) {
        this(nVar, nVar2, nVar3, fVar, jVar, pVar, gVar, fVar2, aVar, bVar, jVar2, vVar, y0Var, cVar, d0Var, iVar, bVar2, iVar2, oVar, dVar, lVar, uVar, bVar3, (i4 & 8388608) != 0 ? kotlin.reflect.jvm.internal.impl.resolve.jvm.e.f57880a.a() : eVar);
    }
}

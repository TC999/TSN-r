package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScopesHolderForClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t0<T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d f56625a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, T> f56626b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f56627c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56628d;

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f56624f = {kotlin.jvm.internal.n0.u(new PropertyReference1Impl(kotlin.jvm.internal.n0.d(t0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f56623e = new a(null);

    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final <T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> t0<T> a(@NotNull d classDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefinerForOwnerModule, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> scopeFactory) {
            kotlin.jvm.internal.f0.p(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.f0.p(storageManager, "storageManager");
            kotlin.jvm.internal.f0.p(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.f0.p(scopeFactory, "scopeFactory");
            return new t0<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t0<T> f56629a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.g f56630b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(t0<T> t0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            super(0);
            this.f56629a = t0Var;
            this.f56630b = gVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final T invoke() {
            return (T) ((t0) this.f56629a).f56626b.invoke(this.f56630b);
        }
    }

    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t0<T> f56631a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(t0<T> t0Var) {
            super(0);
            this.f56631a = t0Var;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final T invoke() {
            return (T) ((t0) this.f56631a).f56626b.invoke(((t0) this.f56631a).f56627c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private t0(d dVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, d2.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> lVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        this.f56625a = dVar;
        this.f56626b = lVar;
        this.f56627c = gVar;
        this.f56628d = nVar.g(new c(this));
    }

    public /* synthetic */ t0(d dVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, d2.l lVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, kotlin.jvm.internal.u uVar) {
        this(dVar, nVar, lVar, gVar);
    }

    private final T d() {
        return (T) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56628d, this, f56624f[0]);
    }

    @NotNull
    public final T c(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (kotlinTypeRefiner.d(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(this.f56625a))) {
            kotlin.reflect.jvm.internal.impl.types.y0 j4 = this.f56625a.j();
            kotlin.jvm.internal.f0.o(j4, "classDescriptor.typeConstructor");
            return !kotlinTypeRefiner.e(j4) ? d() : (T) kotlinTypeRefiner.c(this.f56625a, new b(this, kotlinTypeRefiner));
        }
        return d();
    }
}

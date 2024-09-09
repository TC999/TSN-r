package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import d2.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.j1;
import kotlin.collections.x;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.storage.m;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e implements h2.b {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56181g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56182h;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d0 f56183a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final l<d0, k> f56184b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56185c;

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56179e = {n0.u(new PropertyReference1Impl(n0.d(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final b f56178d = new b(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56180f = j.f56084m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements l<d0, kotlin.reflect.jvm.internal.impl.builtins.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56186a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.builtins.b invoke(@NotNull d0 module) {
            Object m22;
            f0.p(module, "module");
            List<g0> g02 = module.j0(e.f56180f).g0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : g02) {
                if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.b) {
                    arrayList.add(obj);
                }
            }
            m22 = kotlin.collections.f0.m2(arrayList);
            return (kotlin.reflect.jvm.internal.impl.builtins.b) m22;
        }
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return e.f56182h;
        }
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.impl.h> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.storage.n f56188b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.storage.n nVar) {
            super(0);
            this.f56188b = nVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.impl.h invoke() {
            List l4;
            Set<kotlin.reflect.jvm.internal.impl.descriptors.c> k4;
            k kVar = (k) e.this.f56184b.invoke(e.this.f56183a);
            kotlin.reflect.jvm.internal.impl.name.f fVar = e.f56181g;
            Modality modality = Modality.ABSTRACT;
            ClassKind classKind = ClassKind.INTERFACE;
            l4 = x.l(e.this.f56183a.k().i());
            kotlin.reflect.jvm.internal.impl.descriptors.impl.h hVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.h(kVar, fVar, modality, classKind, l4, v0.f56634a, false, this.f56188b);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.a aVar = new kotlin.reflect.jvm.internal.impl.builtins.jvm.a(this.f56188b, hVar);
            k4 = j1.k();
            hVar.F0(aVar, k4, null);
            return hVar;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.d dVar = j.a.f56097d;
        kotlin.reflect.jvm.internal.impl.name.f i4 = dVar.i();
        f0.o(i4, "cloneable.shortName()");
        f56181g = i4;
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(dVar.l());
        f0.o(m4, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f56182h = m4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d0 moduleDescriptor, @NotNull l<? super d0, ? extends k> computeContainingDeclaration) {
        f0.p(storageManager, "storageManager");
        f0.p(moduleDescriptor, "moduleDescriptor");
        f0.p(computeContainingDeclaration, "computeContainingDeclaration");
        this.f56183a = moduleDescriptor;
        this.f56184b = computeContainingDeclaration;
        this.f56185c = storageManager.g(new c(storageManager));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.h i() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.h) m.a(this.f56185c, this, f56179e[0]);
    }

    @Override // h2.b
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        Set k4;
        Set f4;
        f0.p(packageFqName, "packageFqName");
        if (f0.g(packageFqName, f56180f)) {
            f4 = i1.f(i());
            return f4;
        }
        k4 = j1.k();
        return k4;
    }

    @Override // h2.b
    public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(packageFqName, "packageFqName");
        f0.p(name, "name");
        return f0.g(name, f56181g) && f0.g(packageFqName, f56180f);
    }

    @Override // h2.b
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        f0.p(classId, "classId");
        if (f0.g(classId, f56182h)) {
            return i();
        }
        return null;
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.storage.n nVar, d0 d0Var, l lVar, int i4, u uVar) {
        this(nVar, d0Var, (i4 & 4) != 0 ? a.f56186a : lVar);
    }
}

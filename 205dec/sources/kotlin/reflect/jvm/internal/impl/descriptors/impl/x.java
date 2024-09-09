package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x extends j implements kotlin.reflect.jvm.internal.impl.descriptors.d0 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f56499c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.h f56500d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final o2.c f56501e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f56502f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.c0<?>, Object> f56503g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final a0 f56504h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private v f56505i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.h0 f56506j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f56507k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.l0> f56508l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final kotlin.p f56509m;

    /* compiled from: ModuleDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<i> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final i invoke() {
            int Z;
            v vVar = x.this.f56505i;
            x xVar = x.this;
            if (vVar != null) {
                List<x> a4 = vVar.a();
                x.this.J0();
                a4.contains(x.this);
                for (x xVar2 : a4) {
                    xVar2.O0();
                }
                Z = kotlin.collections.y.Z(a4, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (x xVar3 : a4) {
                    kotlin.reflect.jvm.internal.impl.descriptors.h0 h0Var = xVar3.f56506j;
                    kotlin.jvm.internal.f0.m(h0Var);
                    arrayList.add(h0Var);
                }
                return new i(arrayList, kotlin.jvm.internal.f0.C("CompositeProvider@ModuleDescriptor for ", x.this.getName()));
            }
            throw new AssertionError("Dependencies of module " + xVar.K0() + " were not set before querying module content");
        }
    }

    /* compiled from: ModuleDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.l0> {
        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.l0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            kotlin.jvm.internal.f0.p(fqName, "fqName");
            a0 a0Var = x.this.f56504h;
            x xVar = x.this;
            return a0Var.a(xVar, fqName, xVar.f56499c);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public x(@NotNull kotlin.reflect.jvm.internal.impl.name.f moduleName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.builtins.h builtIns, @Nullable o2.c cVar) {
        this(moduleName, storageManager, builtIns, cVar, null, null, 48, null);
        kotlin.jvm.internal.f0.p(moduleName, "moduleName");
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(builtIns, "builtIns");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ x(kotlin.reflect.jvm.internal.impl.name.f r10, kotlin.reflect.jvm.internal.impl.storage.n r11, kotlin.reflect.jvm.internal.impl.builtins.h r12, o2.c r13, java.util.Map r14, kotlin.reflect.jvm.internal.impl.name.f r15, int r16, kotlin.jvm.internal.u r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L7
            r6 = r1
            goto L8
        L7:
            r6 = r13
        L8:
            r0 = r16 & 16
            if (r0 == 0) goto L12
            java.util.Map r0 = kotlin.collections.w0.z()
            r7 = r0
            goto L13
        L12:
            r7 = r14
        L13:
            r0 = r16 & 32
            if (r0 == 0) goto L19
            r8 = r1
            goto L1a
        L19:
            r8 = r15
        L1a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.x.<init>(kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.storage.n, kotlin.reflect.jvm.internal.impl.builtins.h, o2.c, java.util.Map, kotlin.reflect.jvm.internal.impl.name.f, int, kotlin.jvm.internal.u):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K0() {
        String fVar = getName().toString();
        kotlin.jvm.internal.f0.o(fVar, "name.toString()");
        return fVar;
    }

    private final i M0() {
        return (i) this.f56509m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O0() {
        return this.f56506j != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return (R) d0.a.a(this, mVar, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    @Nullable
    public <T> T D0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.c0<T> capability) {
        kotlin.jvm.internal.f0.p(capability, "capability");
        return (T) this.f56503g.get(capability);
    }

    public void J0() {
        if (P0()) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.y.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean L(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d0 targetModule) {
        boolean H1;
        kotlin.jvm.internal.f0.p(targetModule, "targetModule");
        if (kotlin.jvm.internal.f0.g(this, targetModule)) {
            return true;
        }
        v vVar = this.f56505i;
        kotlin.jvm.internal.f0.m(vVar);
        H1 = kotlin.collections.f0.H1(vVar.c(), targetModule);
        return H1 || w0().contains(targetModule) || targetModule.w0().contains(this);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.h0 L0() {
        J0();
        return M0();
    }

    public final void N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.h0 providerForModuleContent) {
        kotlin.jvm.internal.f0.p(providerForModuleContent, "providerForModuleContent");
        O0();
        this.f56506j = providerForModuleContent;
    }

    public boolean P0() {
        return this.f56507k;
    }

    public final void Q0(@NotNull List<x> descriptors) {
        Set<x> k4;
        kotlin.jvm.internal.f0.p(descriptors, "descriptors");
        k4 = j1.k();
        R0(descriptors, k4);
    }

    public final void R0(@NotNull List<x> descriptors, @NotNull Set<x> friends) {
        List F;
        Set k4;
        kotlin.jvm.internal.f0.p(descriptors, "descriptors");
        kotlin.jvm.internal.f0.p(friends, "friends");
        F = CollectionsKt__CollectionsKt.F();
        k4 = j1.k();
        S0(new w(descriptors, friends, F, k4));
    }

    public final void S0(@NotNull v dependencies) {
        kotlin.jvm.internal.f0.p(dependencies, "dependencies");
        this.f56505i = dependencies;
    }

    public final void T0(@NotNull x... descriptors) {
        List<x> ey;
        kotlin.jvm.internal.f0.p(descriptors, "descriptors");
        ey = kotlin.collections.p.ey(descriptors);
        Q0(ey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        return d0.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.l0 j0(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        J0();
        return this.f56508l.invoke(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.h k() {
        return this.f56500d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        kotlin.jvm.internal.f0.p(nameFilter, "nameFilter");
        J0();
        return L0().u(fqName, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.d0> w0() {
        v vVar = this.f56505i;
        if (vVar != null) {
            return vVar.b();
        }
        throw new AssertionError("Dependencies of module " + K0() + " were not set");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public x(@NotNull kotlin.reflect.jvm.internal.impl.name.f moduleName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.builtins.h builtIns, @Nullable o2.c cVar, @NotNull Map<kotlin.reflect.jvm.internal.impl.descriptors.c0<?>, ? extends Object> capabilities, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), moduleName);
        kotlin.p a4;
        kotlin.jvm.internal.f0.p(moduleName, "moduleName");
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(builtIns, "builtIns");
        kotlin.jvm.internal.f0.p(capabilities, "capabilities");
        this.f56499c = storageManager;
        this.f56500d = builtIns;
        this.f56501e = cVar;
        this.f56502f = fVar;
        if (moduleName.g()) {
            this.f56503g = capabilities;
            a0 a0Var = (a0) D0(a0.f56301a.a());
            this.f56504h = a0Var == null ? a0.b.f56304b : a0Var;
            this.f56507k = true;
            this.f56508l = storageManager.c(new b());
            a4 = kotlin.r.a(new a());
            this.f56509m = a4;
            return;
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Module name must be special: ", moduleName));
    }
}

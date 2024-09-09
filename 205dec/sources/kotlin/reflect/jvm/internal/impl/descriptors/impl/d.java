package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractTypeAliasDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d extends k implements z0 {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.s f56344e;

    /* renamed from: f  reason: collision with root package name */
    private List<? extends a1> f56345f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final c f56346g;

    /* compiled from: AbstractTypeAliasDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, kotlin.reflect.jvm.internal.impl.types.m0> {
        a() {
            super(1);
        }

        @Override // d2.l
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.types.m0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.f f4 = gVar.f(d.this);
            if (f4 == null) {
                return null;
            }
            return f4.q();
        }
    }

    /* compiled from: AbstractTypeAliasDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<l1, Boolean> {
        b() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
            if (((r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) && !kotlin.jvm.internal.f0.g(((kotlin.reflect.jvm.internal.impl.descriptors.a1) r5).b(), r0)) != false) goto L9;
         */
        @Override // d2.l
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(kotlin.reflect.jvm.internal.impl.types.l1 r5) {
            /*
                r4 = this;
                java.lang.String r0 = "type"
                kotlin.jvm.internal.f0.o(r5, r0)
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.g0.a(r5)
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L2d
                kotlin.reflect.jvm.internal.impl.descriptors.impl.d r0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.d.this
                kotlin.reflect.jvm.internal.impl.types.y0 r5 = r5.H0()
                kotlin.reflect.jvm.internal.impl.descriptors.f r5 = r5.b()
                boolean r3 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1
                if (r3 == 0) goto L29
                kotlin.reflect.jvm.internal.impl.descriptors.a1 r5 = (kotlin.reflect.jvm.internal.impl.descriptors.a1) r5
                kotlin.reflect.jvm.internal.impl.descriptors.k r5 = r5.b()
                boolean r5 = kotlin.jvm.internal.f0.g(r5, r0)
                if (r5 != 0) goto L29
                r5 = 1
                goto L2a
            L29:
                r5 = 0
            L2a:
                if (r5 == 0) goto L2d
                goto L2e
            L2d:
                r1 = 0
            L2e:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.d.b.invoke(kotlin.reflect.jvm.internal.impl.types.l1):java.lang.Boolean");
        }
    }

    /* compiled from: AbstractTypeAliasDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c implements y0 {
        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        /* renamed from: d */
        public z0 b() {
            return d.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<a1> getParameters() {
            return d.this.H0();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.types.e0> j() {
            Collection<kotlin.reflect.jvm.internal.impl.types.e0> j4 = b().r0().H0().j();
            kotlin.jvm.internal.f0.o(j4, "declarationDescriptor.un\u2026pe.constructor.supertypes");
            return j4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.h k() {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(b());
        }

        @NotNull
        public String toString() {
            return "[typealias " + b().getName().b() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull v0 sourceElement, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        kotlin.jvm.internal.f0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(sourceElement, "sourceElement");
        kotlin.jvm.internal.f0.p(visibilityImpl, "visibilityImpl");
        this.f56344e = visibilityImpl;
        this.f56346g = new c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d4) {
        kotlin.jvm.internal.f0.p(visitor, "visitor");
        return visitor.d(this, d4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.m0 C0() {
        kotlin.reflect.jvm.internal.impl.descriptors.d w3 = w();
        kotlin.reflect.jvm.internal.impl.types.m0 u3 = h1.u(this, w3 == null ? h.c.f57931b : w3.W(), new a());
        kotlin.jvm.internal.f0.o(u3, "@OptIn(TypeRefinement::c\u2026s)?.defaultType\n        }");
        return u3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: F0 */
    public z0 h0() {
        return (z0) super.a();
    }

    @NotNull
    public final Collection<i0> G0() {
        List F;
        kotlin.reflect.jvm.internal.impl.descriptors.d w3 = w();
        if (w3 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g4 = w3.g();
        kotlin.jvm.internal.f0.o(g4, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.c it : g4) {
            j0.a aVar = j0.H;
            kotlin.reflect.jvm.internal.impl.storage.n N = N();
            kotlin.jvm.internal.f0.o(it, "it");
            i0 b4 = aVar.b(N, this, it);
            if (b4 != null) {
                arrayList.add(b4);
            }
        }
        return arrayList;
    }

    @NotNull
    protected abstract List<a1> H0();

    public final void I0(@NotNull List<? extends a1> declaredTypeParameters) {
        kotlin.jvm.internal.f0.p(declaredTypeParameters, "declaredTypeParameters");
        this.f56345f = declaredTypeParameters;
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.storage.n N();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        return this.f56344e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public y0 j() {
        return this.f56346g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        return h1.c(r0(), new b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        List list = this.f56345f;
        if (list == null) {
            kotlin.jvm.internal.f0.S("declaredTypeParametersImpl");
            return null;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        return Modality.FINAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    @NotNull
    public String toString() {
        return kotlin.jvm.internal.f0.C("typealias ", getName().b());
    }
}

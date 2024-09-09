package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazySubstitutingClassDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s extends t {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f56486h = false;

    /* renamed from: b  reason: collision with root package name */
    private final t f56487b;

    /* renamed from: c  reason: collision with root package name */
    private final f1 f56488c;

    /* renamed from: d  reason: collision with root package name */
    private f1 f56489d;

    /* renamed from: e  reason: collision with root package name */
    private List<a1> f56490e;

    /* renamed from: f  reason: collision with root package name */
    private List<a1> f56491f;

    /* renamed from: g  reason: collision with root package name */
    private y0 f56492g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazySubstitutingClassDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements d2.l<a1, Boolean> {
        a() {
        }

        @Override // d2.l
        /* renamed from: a */
        public Boolean invoke(a1 a1Var) {
            return Boolean.valueOf(!a1Var.S());
        }
    }

    public s(t tVar, f1 f1Var) {
        this.f56487b = tVar;
        this.f56488c = f1Var;
    }

    private f1 C0() {
        List<a1> X1;
        if (this.f56489d == null) {
            if (this.f56488c.k()) {
                this.f56489d = this.f56488c;
            } else {
                List<a1> parameters = this.f56487b.j().getParameters();
                this.f56490e = new ArrayList(parameters.size());
                this.f56489d = kotlin.reflect.jvm.internal.impl.types.r.b(parameters, this.f56488c.j(), this, this.f56490e);
                X1 = kotlin.collections.f0.X1(this.f56490e, new a());
                this.f56491f = X1;
            }
        }
        return this.f56489d;
    }

    @Nullable
    private kotlin.reflect.jvm.internal.impl.types.m0 G0(@Nullable kotlin.reflect.jvm.internal.impl.types.m0 m0Var) {
        return (m0Var == null || this.f56488c.k()) ? m0Var : (kotlin.reflect.jvm.internal.impl.types.m0) C0().p(m0Var, Variance.INVARIANT);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void h0(int r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.s.h0(int):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h B(@NotNull d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (d1Var == null) {
            h0(5);
        }
        if (gVar == null) {
            h0(6);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h B = this.f56487b.B(d1Var, gVar);
        if (this.f56488c.k()) {
            if (B == null) {
                h0(7);
            }
            return B;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.scopes.m(B, C0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.a(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public s0 E0() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return this.f56487b.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    @NotNull
    /* renamed from: F0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull f1 f1Var) {
        if (f1Var == null) {
            h0(22);
        }
        return f1Var.k() ? this : new s(this, f1.h(f1Var.j(), C0().j()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h U() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h U = this.f56487b.U();
        if (U == null) {
            h0(27);
        }
        return U;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h W() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h f02 = f0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(kotlin.reflect.jvm.internal.impl.resolve.d.g(this.f56487b)));
        if (f02 == null) {
            h0(12);
        }
        return f02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return this.f56487b.X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean a0() {
        return this.f56487b.a0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = this.f56487b.b();
        if (b4 == null) {
            h0(21);
        }
        return b4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            h0(13);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h f02 = this.f56487b.f0(gVar);
        if (this.f56488c.k()) {
            if (f02 == null) {
                h0(14);
            }
            return f02;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.scopes.m(f02, C0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g4 = this.f56487b.g();
        ArrayList arrayList = new ArrayList(g4.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar : g4) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.c) cVar.x().n(cVar.a()).k(cVar.s()).h(cVar.getVisibility()).r(cVar.i()).o(false).build()).c(C0()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = this.f56487b.getAnnotations();
        if (annotations == null) {
            h0(18);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f name = this.f56487b.getName();
        if (name == null) {
            h0(19);
        }
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        v0 v0Var = v0.f56634a;
        if (v0Var == null) {
            h0(28);
        }
        return v0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = this.f56487b.getVisibility();
        if (visibility == null) {
            h0(26);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        ClassKind i4 = this.f56487b.i();
        if (i4 == null) {
            h0(24);
        }
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return this.f56487b.i0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return this.f56487b.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return this.f56487b.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public y0 j() {
        y0 j4 = this.f56487b.j();
        if (this.f56488c.k()) {
            if (j4 == null) {
                h0(0);
            }
            return j4;
        }
        if (this.f56492g == null) {
            f1 C0 = C0();
            Collection<kotlin.reflect.jvm.internal.impl.types.e0> j5 = j4.j();
            ArrayList arrayList = new ArrayList(j5.size());
            for (kotlin.reflect.jvm.internal.impl.types.e0 e0Var : j5) {
                arrayList.add(C0.p(e0Var, Variance.INVARIANT));
            }
            this.f56492g = new kotlin.reflect.jvm.internal.impl.types.k(this, this.f56490e, arrayList, kotlin.reflect.jvm.internal.impl.storage.f.f58216e);
        }
        y0 y0Var = this.f56492g;
        if (y0Var == null) {
            h0(1);
        }
        return y0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h k0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h k02 = this.f56487b.k0();
        if (k02 == null) {
            h0(15);
        }
        return k02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
        return this.f56487b.l0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m4 = this.f56487b.m();
        if (m4 == null) {
            h0(30);
        }
        return m4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        return this.f56487b.n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h o0(@NotNull d1 d1Var) {
        if (d1Var == null) {
            h0(10);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h B = B(d1Var, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(kotlin.reflect.jvm.internal.impl.resolve.d.g(this)));
        if (B == null) {
            h0(11);
        }
        return B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.m0 q() {
        kotlin.reflect.jvm.internal.impl.types.m0 l4 = kotlin.reflect.jvm.internal.impl.types.f0.l(getAnnotations(), j(), h1.h(j().getParameters()), false, W());
        if (l4 == null) {
            h0(16);
        }
        return l4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        C0();
        List<a1> list = this.f56491f;
        if (list == null) {
            h0(29);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality s3 = this.f56487b.s();
        if (s3 == null) {
            h0(25);
        }
        return s3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        return this.f56487b.t();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return this.f56487b.v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean y() {
        return this.f56487b.y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.x<kotlin.reflect.jvm.internal.impl.types.m0> z() {
        kotlin.reflect.jvm.internal.impl.descriptors.x<kotlin.reflect.jvm.internal.impl.types.m0> z3 = this.f56487b.z();
        if (z3 == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.x<>(z3.a(), G0(z().b()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d a() {
        kotlin.reflect.jvm.internal.impl.descriptors.d a4 = this.f56487b.a();
        if (a4 == null) {
            h0(20);
        }
        return a4;
    }
}

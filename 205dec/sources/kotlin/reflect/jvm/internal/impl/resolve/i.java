package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.t;

/* compiled from: OverridingUtilTypeSystemContext.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i implements kotlin.reflect.jvm.internal.impl.types.checker.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Map<y0, y0> f57871a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final e.a f57872b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f57873c;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@Nullable Map<y0, ? extends y0> map, @NotNull e.a equalityAxioms, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        f0.p(equalityAxioms, "equalityAxioms");
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f57871a = map;
        this.f57872b = equalityAxioms;
        this.f57873c = kotlinTypeRefiner;
    }

    private final boolean z0(y0 y0Var, y0 y0Var2) {
        if (this.f57872b.a(y0Var, y0Var2)) {
            return true;
        }
        Map<y0, y0> map = this.f57871a;
        if (map == null) {
            return false;
        }
        y0 y0Var3 = map.get(y0Var);
        y0 y0Var4 = this.f57871a.get(y0Var2);
        if (y0Var3 == null || !f0.g(y0Var3, y0Var2)) {
            return y0Var4 != null && f0.g(y0Var4, y0Var);
        }
        return true;
    }

    @Override // r2.p
    public boolean A(@NotNull r2.i iVar) {
        return b.a.H(this, iVar);
    }

    @NotNull
    public TypeCheckerState A0(boolean z3, boolean z4) {
        return kotlin.reflect.jvm.internal.impl.types.checker.a.b(z3, z4, this, null, this.f57873c, 8, null);
    }

    @Override // r2.p
    @Nullable
    public r2.n B(@NotNull t tVar) {
        return b.a.w(this, tVar);
    }

    @Override // r2.p
    @NotNull
    public Collection<r2.g> C(@NotNull r2.m mVar) {
        return b.a.t0(this, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    @Nullable
    public PrimitiveType D(@NotNull r2.m mVar) {
        return b.a.s(this, mVar);
    }

    @Override // r2.p
    public boolean E(@NotNull r2.b bVar) {
        return b.a.X(this, bVar);
    }

    @Override // r2.p
    public boolean F(@NotNull r2.m mVar) {
        return b.a.F(this, mVar);
    }

    @Override // r2.p
    public boolean G(@NotNull r2.g gVar) {
        return b.a.K(this, gVar);
    }

    @Override // r2.p
    public boolean H(@NotNull r2.m mVar) {
        return b.a.L(this, mVar);
    }

    @Override // r2.p
    public boolean I(@NotNull r2.b bVar) {
        return b.a.Z(this, bVar);
    }

    @Override // r2.p
    public boolean J(@NotNull r2.i iVar) {
        return b.a.P(this, iVar);
    }

    @Override // r2.p
    public boolean K(@NotNull r2.m mVar) {
        return b.a.Q(this, mVar);
    }

    @Override // r2.p
    @NotNull
    public r2.i L(@NotNull r2.c cVar) {
        return b.a.n0(this, cVar);
    }

    @Override // r2.p
    @Nullable
    public r2.g M(@NotNull r2.b bVar) {
        return b.a.j0(this, bVar);
    }

    @Override // r2.p
    @NotNull
    public r2.a N(@NotNull r2.b bVar) {
        return b.a.u0(this, bVar);
    }

    @Override // r2.p
    public boolean O(@NotNull r2.m c12, @NotNull r2.m c22) {
        f0.p(c12, "c1");
        f0.p(c22, "c2");
        if (c12 instanceof y0) {
            if (c22 instanceof y0) {
                return b.a.a(this, c12, c22) || z0((y0) c12, (y0) c22);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // r2.p
    @Nullable
    public r2.e P(@NotNull r2.g gVar) {
        return b.a.g(this, gVar);
    }

    @Override // r2.p
    @NotNull
    public CaptureStatus Q(@NotNull r2.b bVar) {
        return b.a.k(this, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b
    @NotNull
    public r2.g R(@NotNull r2.i iVar, @NotNull r2.i iVar2) {
        return b.a.l(this, iVar, iVar2);
    }

    @Override // r2.p
    @NotNull
    public r2.l S(@NotNull r2.k kVar, int i4) {
        return b.a.n(this, kVar, i4);
    }

    @Override // r2.p
    public boolean T(@NotNull r2.g gVar) {
        return b.a.S(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    @Nullable
    public PrimitiveType U(@NotNull r2.m mVar) {
        return b.a.t(this, mVar);
    }

    @Override // r2.p
    @NotNull
    public r2.m V(@NotNull r2.g gVar) {
        return b.a.v0(this, gVar);
    }

    @Override // r2.p
    public boolean W(@NotNull r2.g gVar) {
        return b.a.N(this, gVar);
    }

    @Override // r2.p
    @NotNull
    public TypeCheckerState.a X(@NotNull r2.i iVar) {
        return b.a.s0(this, iVar);
    }

    @Override // r2.p
    public boolean Y(@NotNull r2.g gVar) {
        return b.a.M(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean Z(@NotNull r2.m mVar) {
        return b.a.g0(this, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    @NotNull
    public r2.i a(@NotNull r2.i iVar, boolean z3) {
        return b.a.A0(this, iVar, z3);
    }

    @Override // r2.p
    public boolean a0(@NotNull r2.i iVar) {
        return b.a.Y(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    @Nullable
    public r2.b b(@NotNull r2.i iVar) {
        return b.a.d(this, iVar);
    }

    @Override // r2.p
    @NotNull
    public r2.l b0(@NotNull r2.g gVar) {
        return b.a.i(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    @NotNull
    public r2.i c(@NotNull r2.e eVar) {
        return b.a.x0(this, eVar);
    }

    @Override // r2.p
    public int c0(@NotNull r2.k kVar) {
        return b.a.r0(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    @NotNull
    public r2.i d(@NotNull r2.e eVar) {
        return b.a.h0(this, eVar);
    }

    @Override // r2.p
    @NotNull
    public r2.n d0(@NotNull r2.m mVar, int i4) {
        return b.a.r(this, mVar, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    public boolean e(@NotNull r2.i iVar) {
        return b.a.a0(this, iVar);
    }

    @Override // r2.p
    @NotNull
    public r2.g e0(@NotNull List<? extends r2.g> list) {
        return b.a.E(this, list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    @NotNull
    public r2.m f(@NotNull r2.i iVar) {
        return b.a.w0(this, iVar);
    }

    @Override // r2.p
    @Nullable
    public List<r2.i> f0(@NotNull r2.i iVar, @NotNull r2.m mVar) {
        return b.a.m(this, iVar, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, r2.p
    @Nullable
    public r2.i g(@NotNull r2.g gVar) {
        return b.a.h(this, gVar);
    }

    @Override // r2.p
    @Nullable
    public r2.n g0(@NotNull r2.m mVar) {
        return b.a.x(this, mVar);
    }

    @Override // r2.p
    @NotNull
    public r2.g getType(@NotNull r2.l lVar) {
        return b.a.getType(this, lVar);
    }

    @Override // r2.p
    public boolean h(@NotNull r2.i iVar) {
        return b.a.d0(this, iVar);
    }

    @Override // r2.p
    public boolean h0(@NotNull r2.l lVar) {
        return b.a.c0(this, lVar);
    }

    @Override // r2.p
    public boolean i(@NotNull r2.g gVar) {
        return b.a.U(this, gVar);
    }

    @Override // r2.p
    public boolean i0(@NotNull r2.g gVar) {
        return b.a.B(this, gVar);
    }

    @Override // r2.p
    @Nullable
    public r2.d j(@NotNull r2.e eVar) {
        return b.a.f(this, eVar);
    }

    @Override // r2.p
    @NotNull
    public r2.g j0(@NotNull r2.g gVar, boolean z3) {
        return b.a.z0(this, gVar, z3);
    }

    @Override // r2.p
    @Nullable
    public r2.l k(@NotNull r2.i iVar, int i4) {
        return b.a.p(this, iVar, i4);
    }

    @Override // r2.p
    @NotNull
    public Collection<r2.g> k0(@NotNull r2.i iVar) {
        return b.a.p0(this, iVar);
    }

    @Override // r2.p
    @NotNull
    public r2.i l(@NotNull r2.g gVar) {
        return b.a.i0(this, gVar);
    }

    @Override // r2.p
    public boolean l0(@NotNull r2.g gVar) {
        return b.a.W(this, gVar);
    }

    @Override // r2.p
    @NotNull
    public r2.l m(@NotNull r2.g gVar, int i4) {
        return b.a.o(this, gVar, i4);
    }

    @Override // r2.p
    public boolean m0(@NotNull r2.m mVar) {
        return b.a.R(this, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    @NotNull
    public r2.g n(@NotNull r2.n nVar) {
        return b.a.u(this, nVar);
    }

    @Override // r2.p
    @NotNull
    public TypeVariance n0(@NotNull r2.n nVar) {
        return b.a.z(this, nVar);
    }

    @Override // r2.p
    @Nullable
    public r2.c o(@NotNull r2.i iVar) {
        return b.a.e(this, iVar);
    }

    @Override // r2.p
    public int o0(@NotNull r2.g gVar) {
        return b.a.b(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean p(@NotNull r2.m mVar) {
        return b.a.O(this, mVar);
    }

    @Override // r2.p
    public boolean p0(@NotNull r2.m mVar) {
        return b.a.V(this, mVar);
    }

    @Override // r2.p
    @NotNull
    public r2.g q(@NotNull r2.g gVar) {
        return b.a.k0(this, gVar);
    }

    @Override // r2.s
    public boolean q0(@NotNull r2.i iVar, @NotNull r2.i iVar2) {
        return b.a.D(this, iVar, iVar2);
    }

    @Override // r2.p
    public boolean r(@NotNull r2.g gVar) {
        return b.a.G(this, gVar);
    }

    @Override // r2.p
    public boolean r0(@NotNull r2.m mVar) {
        return b.a.J(this, mVar);
    }

    @Override // r2.p
    public boolean s(@NotNull r2.g gVar) {
        return b.a.f0(this, gVar);
    }

    @Override // r2.p
    @NotNull
    public r2.l s0(@NotNull r2.a aVar) {
        return b.a.q0(this, aVar);
    }

    @Override // r2.p
    @NotNull
    public r2.i t(@NotNull r2.g gVar) {
        return b.a.y0(this, gVar);
    }

    @Override // r2.p
    public boolean t0(@NotNull r2.n nVar, @Nullable r2.m mVar) {
        return b.a.C(this, nVar, mVar);
    }

    @Override // r2.p
    public int u(@NotNull r2.m mVar) {
        return b.a.o0(this, mVar);
    }

    @Override // r2.p
    @NotNull
    public r2.k u0(@NotNull r2.i iVar) {
        return b.a.c(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    @NotNull
    public r2.g v(@NotNull r2.g gVar) {
        return b.a.l0(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean v0(@NotNull r2.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return b.a.A(this, gVar, cVar);
    }

    @Override // r2.p
    @NotNull
    public TypeVariance w(@NotNull r2.l lVar) {
        return b.a.y(this, lVar);
    }

    @Override // r2.p
    public boolean w0(@NotNull r2.m mVar) {
        return b.a.I(this, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.d x(@NotNull r2.m mVar) {
        return b.a.q(this, mVar);
    }

    @Override // r2.p
    @Nullable
    public r2.i x0(@NotNull r2.i iVar, @NotNull CaptureStatus captureStatus) {
        return b.a.j(this, iVar, captureStatus);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    @Nullable
    public r2.g y(@NotNull r2.g gVar) {
        return b.a.v(this, gVar);
    }

    @Override // r2.p
    public boolean y0(@NotNull r2.i iVar) {
        return b.a.T(this, iVar);
    }

    @Override // r2.p
    public boolean z(@NotNull r2.i iVar) {
        return b.a.e0(this, iVar);
    }
}

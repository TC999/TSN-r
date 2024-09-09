package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a */
    public static final f f58335a = new f();
    @JvmField

    /* renamed from: b */
    public static boolean f58336b;

    /* compiled from: AbstractTypeChecker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58337a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f58338b;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            f58337a = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            f58338b = iArr2;
        }
    }

    private f() {
    }

    private final Boolean a(TypeCheckerState typeCheckerState, r2.i iVar, r2.i iVar2) {
        r2.p j4 = typeCheckerState.j();
        if (j4.J(iVar) || j4.J(iVar2)) {
            if (j4.J(iVar) && j4.J(iVar2)) {
                return Boolean.TRUE;
            }
            if (j4.J(iVar)) {
                if (c(j4, typeCheckerState, iVar, iVar2, false)) {
                    return Boolean.TRUE;
                }
            } else if (j4.J(iVar2) && (b(j4, iVar) || c(j4, typeCheckerState, iVar2, iVar, true))) {
                return Boolean.TRUE;
            }
            return null;
        }
        return null;
    }

    private static final boolean b(r2.p pVar, r2.i iVar) {
        boolean z3;
        boolean z4;
        r2.m f4 = pVar.f(iVar);
        if (f4 instanceof r2.f) {
            Collection<r2.g> C = pVar.C(f4);
            if (!(C instanceof Collection) || !C.isEmpty()) {
                for (r2.g gVar : C) {
                    r2.i g4 = pVar.g(gVar);
                    if (g4 != null && pVar.J(g4)) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
            if (z4) {
                return true;
            }
        }
        return false;
    }

    private static final boolean c(r2.p pVar, TypeCheckerState typeCheckerState, r2.i iVar, r2.i iVar2, boolean z3) {
        boolean z4;
        Collection<r2.g> k02 = pVar.k0(iVar);
        if (!(k02 instanceof Collection) || !k02.isEmpty()) {
            for (r2.g gVar : k02) {
                if (kotlin.jvm.internal.f0.g(pVar.V(gVar), pVar.f(iVar2)) || (z3 && q(f58335a, typeCheckerState, iVar2, gVar, false, 8, null))) {
                    z4 = true;
                    continue;
                } else {
                    z4 = false;
                    continue;
                }
                if (z4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x0126, code lost:
        if (r10 != false) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Boolean d(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r15, r2.i r16, r2.i r17) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.f.d(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, r2.i, r2.i):java.lang.Boolean");
    }

    private final List<r2.i> e(TypeCheckerState typeCheckerState, r2.i iVar, r2.m mVar) {
        String X2;
        TypeCheckerState.a X;
        List<r2.i> F;
        List<r2.i> l4;
        List<r2.i> F2;
        r2.p j4 = typeCheckerState.j();
        List<r2.i> f02 = j4.f0(iVar, mVar);
        if (f02 == null) {
            if (!j4.w0(mVar) && j4.A(iVar)) {
                F2 = CollectionsKt__CollectionsKt.F();
                return F2;
            } else if (j4.r0(mVar)) {
                if (j4.O(j4.f(iVar), mVar)) {
                    r2.i x02 = j4.x0(iVar, CaptureStatus.FOR_SUBTYPING);
                    if (x02 != null) {
                        iVar = x02;
                    }
                    l4 = kotlin.collections.x.l(iVar);
                    return l4;
                }
                F = CollectionsKt__CollectionsKt.F();
                return F;
            } else {
                f02 = new kotlin.reflect.jvm.internal.impl.utils.e<>();
                typeCheckerState.k();
                ArrayDeque<r2.i> h4 = typeCheckerState.h();
                kotlin.jvm.internal.f0.m(h4);
                Set<r2.i> i4 = typeCheckerState.i();
                kotlin.jvm.internal.f0.m(i4);
                h4.push(iVar);
                while (!h4.isEmpty()) {
                    if (i4.size() <= 1000) {
                        r2.i current = h4.pop();
                        kotlin.jvm.internal.f0.o(current, "current");
                        if (i4.add(current)) {
                            r2.i x03 = j4.x0(current, CaptureStatus.FOR_SUBTYPING);
                            if (x03 == null) {
                                x03 = current;
                            }
                            if (j4.O(j4.f(x03), mVar)) {
                                f02.add(x03);
                                X = TypeCheckerState.a.c.f58262a;
                            } else if (j4.o0(x03) == 0) {
                                X = TypeCheckerState.a.b.f58261a;
                            } else {
                                X = typeCheckerState.j().X(x03);
                            }
                            if (!(!kotlin.jvm.internal.f0.g(X, TypeCheckerState.a.c.f58262a))) {
                                X = null;
                            }
                            if (X != null) {
                                r2.p j5 = typeCheckerState.j();
                                for (r2.g gVar : j5.C(j5.f(current))) {
                                    h4.add(X.a(typeCheckerState, gVar));
                                }
                            }
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Too many supertypes for type: ");
                        sb.append(iVar);
                        sb.append(". Supertypes = ");
                        X2 = kotlin.collections.f0.X2(i4, null, null, null, 0, null, null, 63, null);
                        sb.append(X2);
                        throw new IllegalStateException(sb.toString().toString());
                    }
                }
                typeCheckerState.e();
            }
        }
        return f02;
    }

    private final List<r2.i> f(TypeCheckerState typeCheckerState, r2.i iVar, r2.m mVar) {
        return t(typeCheckerState, e(typeCheckerState, iVar, mVar));
    }

    private final boolean g(TypeCheckerState typeCheckerState, r2.g gVar, r2.g gVar2, boolean z3) {
        r2.p j4 = typeCheckerState.j();
        r2.g o4 = typeCheckerState.o(typeCheckerState.p(gVar));
        r2.g o5 = typeCheckerState.o(typeCheckerState.p(gVar2));
        f fVar = f58335a;
        Boolean d4 = fVar.d(typeCheckerState, j4.l(o4), j4.t(o5));
        if (d4 == null) {
            Boolean c4 = typeCheckerState.c(o4, o5, z3);
            if (c4 == null) {
                return fVar.r(typeCheckerState, j4.l(o4), j4.t(o5));
            }
            return c4.booleanValue();
        }
        boolean booleanValue = d4.booleanValue();
        typeCheckerState.c(o4, o5, z3);
        return booleanValue;
    }

    private final r2.n k(r2.p pVar, r2.g gVar, r2.g gVar2) {
        int o02 = pVar.o0(gVar);
        int i4 = 0;
        while (true) {
            if (i4 >= o02) {
                return null;
            }
            int i5 = i4 + 1;
            r2.l m4 = pVar.m(gVar, i4);
            boolean z3 = true;
            r2.l lVar = pVar.h0(m4) ^ true ? m4 : null;
            if (lVar != null) {
                r2.g type = pVar.getType(lVar);
                z3 = (pVar.r(pVar.l(type)) && pVar.r(pVar.l(gVar2))) ? false : false;
                if (kotlin.jvm.internal.f0.g(type, gVar2) || (z3 && kotlin.jvm.internal.f0.g(pVar.V(type), pVar.V(gVar2)))) {
                    break;
                }
                r2.n k4 = k(pVar, type, gVar2);
                if (k4 != null) {
                    return k4;
                }
            }
            i4 = i5;
        }
        return pVar.d0(pVar.V(gVar), i4);
    }

    private final boolean l(TypeCheckerState typeCheckerState, r2.i iVar) {
        String X2;
        TypeCheckerState.a aVar;
        r2.p j4 = typeCheckerState.j();
        r2.m f4 = j4.f(iVar);
        if (j4.w0(f4)) {
            return j4.p0(f4);
        }
        if (j4.p0(j4.f(iVar))) {
            return true;
        }
        typeCheckerState.k();
        ArrayDeque<r2.i> h4 = typeCheckerState.h();
        kotlin.jvm.internal.f0.m(h4);
        Set<r2.i> i4 = typeCheckerState.i();
        kotlin.jvm.internal.f0.m(i4);
        h4.push(iVar);
        while (!h4.isEmpty()) {
            if (i4.size() <= 1000) {
                r2.i current = h4.pop();
                kotlin.jvm.internal.f0.o(current, "current");
                if (i4.add(current)) {
                    if (j4.A(current)) {
                        aVar = TypeCheckerState.a.c.f58262a;
                    } else {
                        aVar = TypeCheckerState.a.b.f58261a;
                    }
                    if (!(!kotlin.jvm.internal.f0.g(aVar, TypeCheckerState.a.c.f58262a))) {
                        aVar = null;
                    }
                    if (aVar == null) {
                        continue;
                    } else {
                        r2.p j5 = typeCheckerState.j();
                        for (r2.g gVar : j5.C(j5.f(current))) {
                            r2.i a4 = aVar.a(typeCheckerState, gVar);
                            if (j4.p0(j4.f(a4))) {
                                typeCheckerState.e();
                                return true;
                            }
                            h4.add(a4);
                        }
                        continue;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(iVar);
                sb.append(". Supertypes = ");
                X2 = kotlin.collections.f0.X2(i4, null, null, null, 0, null, null, 63, null);
                sb.append(X2);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        typeCheckerState.e();
        return false;
    }

    private final boolean m(r2.p pVar, r2.g gVar) {
        return pVar.H(pVar.V(gVar)) && !pVar.Y(gVar) && !pVar.G(gVar) && kotlin.jvm.internal.f0.g(pVar.f(pVar.l(gVar)), pVar.f(pVar.t(gVar)));
    }

    private final boolean n(r2.p pVar, r2.i iVar, r2.i iVar2) {
        r2.c o4 = pVar.o(iVar);
        r2.i L2 = o4 == null ? iVar : pVar.L(o4);
        r2.c o5 = pVar.o(iVar2);
        if (pVar.f(L2) != pVar.f(o5 == null ? iVar2 : pVar.L(o5))) {
            return false;
        }
        if (pVar.G(iVar) || !pVar.G(iVar2)) {
            return !pVar.y0(iVar) || pVar.y0(iVar2);
        }
        return false;
    }

    public static /* synthetic */ boolean q(f fVar, TypeCheckerState typeCheckerState, r2.g gVar, r2.g gVar2, boolean z3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z3 = false;
        }
        return fVar.p(typeCheckerState, gVar, gVar2, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x00fe, code lost:
        if ((r3.w(r9) == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean r(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r20, r2.i r21, r2.i r22) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.f.r(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, r2.i, r2.i):boolean");
    }

    private final boolean s(r2.p pVar, r2.g gVar, r2.g gVar2, r2.m mVar) {
        r2.n B;
        r2.i g4 = pVar.g(gVar);
        if (g4 instanceof r2.b) {
            r2.b bVar = (r2.b) g4;
            if (!pVar.E(bVar) && pVar.h0(pVar.s0(pVar.N(bVar))) && pVar.Q(bVar) == CaptureStatus.FOR_SUBTYPING) {
                r2.m V = pVar.V(gVar2);
                r2.t tVar = V instanceof r2.t ? (r2.t) V : null;
                return (tVar == null || (B = pVar.B(tVar)) == null || !pVar.t0(B, mVar)) ? false : true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<r2.i> t(TypeCheckerState typeCheckerState, List<? extends r2.i> list) {
        r2.p j4 = typeCheckerState.j();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            r2.k u02 = j4.u0((r2.i) next);
            int c02 = j4.c0(u02);
            int i4 = 0;
            while (true) {
                if (i4 >= c02) {
                    break;
                }
                int i5 = i4 + 1;
                if (!(j4.P(j4.getType(j4.S(u02, i4))) == null)) {
                    z3 = false;
                    break;
                }
                i4 = i5;
            }
            if (z3) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    @Nullable
    public final TypeVariance h(@NotNull TypeVariance declared, @NotNull TypeVariance useSite) {
        kotlin.jvm.internal.f0.p(declared, "declared");
        kotlin.jvm.internal.f0.p(useSite, "useSite");
        TypeVariance typeVariance = TypeVariance.INV;
        if (declared == typeVariance) {
            return useSite;
        }
        if (useSite == typeVariance || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean i(@NotNull TypeCheckerState state, @NotNull r2.g a4, @NotNull r2.g b4) {
        kotlin.jvm.internal.f0.p(state, "state");
        kotlin.jvm.internal.f0.p(a4, "a");
        kotlin.jvm.internal.f0.p(b4, "b");
        r2.p j4 = state.j();
        if (a4 == b4) {
            return true;
        }
        f fVar = f58335a;
        if (fVar.m(j4, a4) && fVar.m(j4, b4)) {
            r2.g o4 = state.o(state.p(a4));
            r2.g o5 = state.o(state.p(b4));
            r2.i l4 = j4.l(o4);
            if (!j4.O(j4.V(o4), j4.V(o5))) {
                return false;
            }
            if (j4.o0(l4) == 0) {
                return j4.i0(o4) || j4.i0(o5) || j4.y0(l4) == j4.y0(j4.l(o5));
            }
        }
        return q(fVar, state, a4, b4, false, 8, null) && q(fVar, state, b4, a4, false, 8, null);
    }

    @NotNull
    public final List<r2.i> j(@NotNull TypeCheckerState state, @NotNull r2.i subType, @NotNull r2.m superConstructor) {
        String X2;
        TypeCheckerState.a aVar;
        kotlin.jvm.internal.f0.p(state, "state");
        kotlin.jvm.internal.f0.p(subType, "subType");
        kotlin.jvm.internal.f0.p(superConstructor, "superConstructor");
        r2.p j4 = state.j();
        if (j4.A(subType)) {
            return f58335a.f(state, subType, superConstructor);
        }
        if (!j4.w0(superConstructor) && !j4.K(superConstructor)) {
            return f58335a.e(state, subType, superConstructor);
        }
        kotlin.reflect.jvm.internal.impl.utils.e<r2.i> eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        state.k();
        ArrayDeque<r2.i> h4 = state.h();
        kotlin.jvm.internal.f0.m(h4);
        Set<r2.i> i4 = state.i();
        kotlin.jvm.internal.f0.m(i4);
        h4.push(subType);
        while (!h4.isEmpty()) {
            if (i4.size() <= 1000) {
                r2.i current = h4.pop();
                kotlin.jvm.internal.f0.o(current, "current");
                if (i4.add(current)) {
                    if (j4.A(current)) {
                        eVar.add(current);
                        aVar = TypeCheckerState.a.c.f58262a;
                    } else {
                        aVar = TypeCheckerState.a.b.f58261a;
                    }
                    if (!(!kotlin.jvm.internal.f0.g(aVar, TypeCheckerState.a.c.f58262a))) {
                        aVar = null;
                    }
                    if (aVar != null) {
                        r2.p j5 = state.j();
                        for (r2.g gVar : j5.C(j5.f(current))) {
                            h4.add(aVar.a(state, gVar));
                        }
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(subType);
                sb.append(". Supertypes = ");
                X2 = kotlin.collections.f0.X2(i4, null, null, null, 0, null, null, 63, null);
                sb.append(X2);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        state.e();
        ArrayList arrayList = new ArrayList();
        for (r2.i it : eVar) {
            f fVar = f58335a;
            kotlin.jvm.internal.f0.o(it, "it");
            kotlin.collections.c0.o0(arrayList, fVar.f(state, it, superConstructor));
        }
        return arrayList;
    }

    public final boolean o(@NotNull TypeCheckerState typeCheckerState, @NotNull r2.k capturedSubArguments, @NotNull r2.i superType) {
        int i4;
        int i5;
        boolean i6;
        int i7;
        kotlin.jvm.internal.f0.p(typeCheckerState, "<this>");
        kotlin.jvm.internal.f0.p(capturedSubArguments, "capturedSubArguments");
        kotlin.jvm.internal.f0.p(superType, "superType");
        r2.p j4 = typeCheckerState.j();
        r2.m f4 = j4.f(superType);
        int c02 = j4.c0(capturedSubArguments);
        int u3 = j4.u(f4);
        if (c02 == u3 && c02 == j4.o0(superType)) {
            int i8 = 0;
            while (i8 < u3) {
                int i9 = i8 + 1;
                r2.l m4 = j4.m(superType, i8);
                if (!j4.h0(m4)) {
                    r2.g type = j4.getType(m4);
                    r2.l S = j4.S(capturedSubArguments, i8);
                    j4.w(S);
                    TypeVariance typeVariance = TypeVariance.INV;
                    r2.g type2 = j4.getType(S);
                    f fVar = f58335a;
                    TypeVariance h4 = fVar.h(j4.n0(j4.d0(f4, i8)), j4.w(m4));
                    if (h4 == null) {
                        return typeCheckerState.m();
                    }
                    if (h4 == typeVariance && (fVar.s(j4, type2, type, f4) || fVar.s(j4, type, type2, f4))) {
                        continue;
                    } else {
                        i4 = typeCheckerState.f58257g;
                        if (i4 <= 100) {
                            i5 = typeCheckerState.f58257g;
                            typeCheckerState.f58257g = i5 + 1;
                            int i10 = a.f58337a[h4.ordinal()];
                            if (i10 == 1) {
                                i6 = fVar.i(typeCheckerState, type2, type);
                            } else if (i10 == 2) {
                                i6 = q(fVar, typeCheckerState, type2, type, false, 8, null);
                            } else if (i10 != 3) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                i6 = q(fVar, typeCheckerState, type, type2, false, 8, null);
                            }
                            i7 = typeCheckerState.f58257g;
                            typeCheckerState.f58257g = i7 - 1;
                            if (!i6) {
                                return false;
                            }
                        } else {
                            throw new IllegalStateException(kotlin.jvm.internal.f0.C("Arguments depth is too high. Some related argument: ", type2).toString());
                        }
                    }
                }
                i8 = i9;
            }
            return true;
        }
        return false;
    }

    public final boolean p(@NotNull TypeCheckerState state, @NotNull r2.g subType, @NotNull r2.g superType, boolean z3) {
        kotlin.jvm.internal.f0.p(state, "state");
        kotlin.jvm.internal.f0.p(subType, "subType");
        kotlin.jvm.internal.f0.p(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.f(subType, superType)) {
            return g(state, subType, superType, z3);
        }
        return false;
    }
}

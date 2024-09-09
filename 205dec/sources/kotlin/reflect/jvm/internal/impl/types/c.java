package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f58268a = new c();

    private c() {
    }

    private final boolean c(TypeCheckerState typeCheckerState, r2.i iVar, r2.m mVar) {
        r2.p j4 = typeCheckerState.j();
        if (j4.i(iVar)) {
            return true;
        }
        if (j4.y0(iVar)) {
            return false;
        }
        if (typeCheckerState.n() && j4.h(iVar)) {
            return true;
        }
        return j4.O(j4.f(iVar), mVar);
    }

    private final boolean e(TypeCheckerState typeCheckerState, r2.i iVar, r2.i iVar2) {
        r2.p j4 = typeCheckerState.j();
        if (f.f58336b) {
            if (!j4.e(iVar) && !j4.m0(j4.f(iVar))) {
                typeCheckerState.l(iVar);
            }
            if (!j4.e(iVar2)) {
                typeCheckerState.l(iVar2);
            }
        }
        if (j4.y0(iVar2) || j4.G(iVar)) {
            return true;
        }
        if ((iVar instanceof r2.b) && j4.I((r2.b) iVar)) {
            return true;
        }
        c cVar = f58268a;
        if (cVar.a(typeCheckerState, iVar, TypeCheckerState.a.b.f58261a)) {
            return true;
        }
        if (j4.G(iVar2) || cVar.a(typeCheckerState, iVar2, TypeCheckerState.a.d.f58263a) || j4.A(iVar)) {
            return false;
        }
        return cVar.b(typeCheckerState, iVar, j4.f(iVar2));
    }

    public final boolean a(@NotNull TypeCheckerState typeCheckerState, @NotNull r2.i type, @NotNull TypeCheckerState.a supertypesPolicy) {
        String X2;
        kotlin.jvm.internal.f0.p(typeCheckerState, "<this>");
        kotlin.jvm.internal.f0.p(type, "type");
        kotlin.jvm.internal.f0.p(supertypesPolicy, "supertypesPolicy");
        r2.p j4 = typeCheckerState.j();
        if (!((j4.A(type) && !j4.y0(type)) || j4.G(type))) {
            typeCheckerState.k();
            ArrayDeque<r2.i> h4 = typeCheckerState.h();
            kotlin.jvm.internal.f0.m(h4);
            Set<r2.i> i4 = typeCheckerState.i();
            kotlin.jvm.internal.f0.m(i4);
            h4.push(type);
            while (!h4.isEmpty()) {
                if (i4.size() <= 1000) {
                    r2.i current = h4.pop();
                    kotlin.jvm.internal.f0.o(current, "current");
                    if (i4.add(current)) {
                        TypeCheckerState.a aVar = j4.y0(current) ? TypeCheckerState.a.c.f58262a : supertypesPolicy;
                        if (!(!kotlin.jvm.internal.f0.g(aVar, TypeCheckerState.a.c.f58262a))) {
                            aVar = null;
                        }
                        if (aVar == null) {
                            continue;
                        } else {
                            r2.p j5 = typeCheckerState.j();
                            for (r2.g gVar : j5.C(j5.f(current))) {
                                r2.i a4 = aVar.a(typeCheckerState, gVar);
                                if ((j4.A(a4) && !j4.y0(a4)) || j4.G(a4)) {
                                    typeCheckerState.e();
                                } else {
                                    h4.add(a4);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Too many supertypes for type: ");
                    sb.append(type);
                    sb.append(". Supertypes = ");
                    X2 = kotlin.collections.f0.X2(i4, null, null, null, 0, null, null, 63, null);
                    sb.append(X2);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
            typeCheckerState.e();
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull TypeCheckerState state, @NotNull r2.i start, @NotNull r2.m end) {
        String X2;
        kotlin.jvm.internal.f0.p(state, "state");
        kotlin.jvm.internal.f0.p(start, "start");
        kotlin.jvm.internal.f0.p(end, "end");
        r2.p j4 = state.j();
        if (f58268a.c(state, start, end)) {
            return true;
        }
        state.k();
        ArrayDeque<r2.i> h4 = state.h();
        kotlin.jvm.internal.f0.m(h4);
        Set<r2.i> i4 = state.i();
        kotlin.jvm.internal.f0.m(i4);
        h4.push(start);
        while (!h4.isEmpty()) {
            if (i4.size() <= 1000) {
                r2.i current = h4.pop();
                kotlin.jvm.internal.f0.o(current, "current");
                if (i4.add(current)) {
                    TypeCheckerState.a aVar = j4.y0(current) ? TypeCheckerState.a.c.f58262a : TypeCheckerState.a.b.f58261a;
                    if (!(!kotlin.jvm.internal.f0.g(aVar, TypeCheckerState.a.c.f58262a))) {
                        aVar = null;
                    }
                    if (aVar == null) {
                        continue;
                    } else {
                        r2.p j5 = state.j();
                        for (r2.g gVar : j5.C(j5.f(current))) {
                            r2.i a4 = aVar.a(state, gVar);
                            if (f58268a.c(state, a4, end)) {
                                state.e();
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
                sb.append(start);
                sb.append(". Supertypes = ");
                X2 = kotlin.collections.f0.X2(i4, null, null, null, 0, null, null, 63, null);
                sb.append(X2);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        state.e();
        return false;
    }

    public final boolean d(@NotNull TypeCheckerState state, @NotNull r2.i subType, @NotNull r2.i superType) {
        kotlin.jvm.internal.f0.p(state, "state");
        kotlin.jvm.internal.f0.p(subType, "subType");
        kotlin.jvm.internal.f0.p(superType, "superType");
        return e(state, subType, superType);
    }
}

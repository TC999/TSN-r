package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractStrictEqualityTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f58318a = new d();

    private d() {
    }

    private final boolean a(r2.p pVar, r2.i iVar, r2.i iVar2) {
        if (pVar.o0(iVar) == pVar.o0(iVar2) && pVar.y0(iVar) == pVar.y0(iVar2)) {
            if ((pVar.o(iVar) == null) == (pVar.o(iVar2) == null) && pVar.O(pVar.f(iVar), pVar.f(iVar2))) {
                if (pVar.q0(iVar, iVar2)) {
                    return true;
                }
                int o02 = pVar.o0(iVar);
                int i4 = 0;
                while (i4 < o02) {
                    int i5 = i4 + 1;
                    r2.l m4 = pVar.m(iVar, i4);
                    r2.l m5 = pVar.m(iVar2, i4);
                    if (pVar.h0(m4) != pVar.h0(m5)) {
                        return false;
                    }
                    if (!pVar.h0(m4) && (pVar.w(m4) != pVar.w(m5) || !c(pVar, pVar.getType(m4), pVar.getType(m5)))) {
                        return false;
                    }
                    i4 = i5;
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(r2.p pVar, r2.g gVar, r2.g gVar2) {
        if (gVar == gVar2) {
            return true;
        }
        r2.i g4 = pVar.g(gVar);
        r2.i g5 = pVar.g(gVar2);
        if (g4 != null && g5 != null) {
            return a(pVar, g4, g5);
        }
        r2.e P = pVar.P(gVar);
        r2.e P2 = pVar.P(gVar2);
        return P != null && P2 != null && a(pVar, pVar.d(P), pVar.d(P2)) && a(pVar, pVar.c(P), pVar.c(P2));
    }

    public final boolean b(@NotNull r2.p context, @NotNull r2.g a4, @NotNull r2.g b4) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(a4, "a");
        kotlin.jvm.internal.f0.p(b4, "b");
        return c(context, a4, b4);
    }
}

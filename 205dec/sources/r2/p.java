package r2;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSystemContext.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface p extends s {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static List<i> a(@NotNull p pVar, @NotNull i receiver, @NotNull m constructor) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            f0.p(constructor, "constructor");
            return null;
        }

        @NotNull
        public static l b(@NotNull p pVar, @NotNull k receiver, int i4) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof i) {
                return pVar.m((g) receiver, i4);
            }
            if (receiver instanceof ArgumentList) {
                l lVar = ((ArgumentList) receiver).get(i4);
                f0.o(lVar, "get(index)");
                return lVar;
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static l c(@NotNull p pVar, @NotNull i receiver, int i4) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            boolean z3 = false;
            if (i4 >= 0 && i4 < pVar.o0(receiver)) {
                z3 = true;
            }
            if (z3) {
                return pVar.m(receiver, i4);
            }
            return null;
        }

        public static boolean d(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            return pVar.y0(pVar.l(receiver)) != pVar.y0(pVar.t(receiver));
        }

        public static boolean e(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            i g4 = pVar.g(receiver);
            return (g4 == null ? null : pVar.b(g4)) != null;
        }

        public static boolean f(@NotNull p pVar, @NotNull i receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            return pVar.w0(pVar.f(receiver));
        }

        public static boolean g(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            i g4 = pVar.g(receiver);
            return (g4 == null ? null : pVar.o(g4)) != null;
        }

        public static boolean h(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            e P = pVar.P(receiver);
            return (P == null ? null : pVar.j(P)) != null;
        }

        public static boolean i(@NotNull p pVar, @NotNull i receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            return pVar.K(pVar.f(receiver));
        }

        public static boolean j(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            return (receiver instanceof i) && pVar.y0((i) receiver);
        }

        public static boolean k(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            return pVar.p0(pVar.V(receiver)) && !pVar.l0(receiver);
        }

        @NotNull
        public static i l(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            e P = pVar.P(receiver);
            if (P == null) {
                i g4 = pVar.g(receiver);
                f0.m(g4);
                return g4;
            }
            return pVar.d(P);
        }

        public static int m(@NotNull p pVar, @NotNull k receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof i) {
                return pVar.o0((g) receiver);
            }
            if (receiver instanceof ArgumentList) {
                return ((ArgumentList) receiver).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static m n(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            i g4 = pVar.g(receiver);
            if (g4 == null) {
                g4 = pVar.l(receiver);
            }
            return pVar.f(g4);
        }

        @NotNull
        public static i o(@NotNull p pVar, @NotNull g receiver) {
            f0.p(pVar, "this");
            f0.p(receiver, "receiver");
            e P = pVar.P(receiver);
            if (P == null) {
                i g4 = pVar.g(receiver);
                f0.m(g4);
                return g4;
            }
            return pVar.c(P);
        }
    }

    boolean A(@NotNull i iVar);

    @Nullable
    n B(@NotNull t tVar);

    @NotNull
    Collection<g> C(@NotNull m mVar);

    boolean E(@NotNull b bVar);

    boolean F(@NotNull m mVar);

    boolean G(@NotNull g gVar);

    boolean H(@NotNull m mVar);

    boolean I(@NotNull b bVar);

    boolean J(@NotNull i iVar);

    boolean K(@NotNull m mVar);

    @NotNull
    i L(@NotNull c cVar);

    @Nullable
    g M(@NotNull b bVar);

    @NotNull
    r2.a N(@NotNull b bVar);

    boolean O(@NotNull m mVar, @NotNull m mVar2);

    @Nullable
    e P(@NotNull g gVar);

    @NotNull
    CaptureStatus Q(@NotNull b bVar);

    @NotNull
    l S(@NotNull k kVar, int i4);

    boolean T(@NotNull g gVar);

    @NotNull
    m V(@NotNull g gVar);

    boolean W(@NotNull g gVar);

    @NotNull
    TypeCheckerState.a X(@NotNull i iVar);

    boolean Y(@NotNull g gVar);

    @NotNull
    i a(@NotNull i iVar, boolean z3);

    boolean a0(@NotNull i iVar);

    @Nullable
    b b(@NotNull i iVar);

    @NotNull
    l b0(@NotNull g gVar);

    @NotNull
    i c(@NotNull e eVar);

    int c0(@NotNull k kVar);

    @NotNull
    i d(@NotNull e eVar);

    @NotNull
    n d0(@NotNull m mVar, int i4);

    boolean e(@NotNull i iVar);

    @NotNull
    g e0(@NotNull List<? extends g> list);

    @NotNull
    m f(@NotNull i iVar);

    @Nullable
    List<i> f0(@NotNull i iVar, @NotNull m mVar);

    @Nullable
    i g(@NotNull g gVar);

    @Nullable
    n g0(@NotNull m mVar);

    @NotNull
    g getType(@NotNull l lVar);

    boolean h(@NotNull i iVar);

    boolean h0(@NotNull l lVar);

    boolean i(@NotNull g gVar);

    boolean i0(@NotNull g gVar);

    @Nullable
    d j(@NotNull e eVar);

    @NotNull
    g j0(@NotNull g gVar, boolean z3);

    @Nullable
    l k(@NotNull i iVar, int i4);

    @NotNull
    Collection<g> k0(@NotNull i iVar);

    @NotNull
    i l(@NotNull g gVar);

    boolean l0(@NotNull g gVar);

    @NotNull
    l m(@NotNull g gVar, int i4);

    boolean m0(@NotNull m mVar);

    @NotNull
    TypeVariance n0(@NotNull n nVar);

    @Nullable
    c o(@NotNull i iVar);

    int o0(@NotNull g gVar);

    boolean p0(@NotNull m mVar);

    @NotNull
    g q(@NotNull g gVar);

    boolean r(@NotNull g gVar);

    boolean r0(@NotNull m mVar);

    boolean s(@NotNull g gVar);

    @NotNull
    l s0(@NotNull r2.a aVar);

    @NotNull
    i t(@NotNull g gVar);

    boolean t0(@NotNull n nVar, @Nullable m mVar);

    int u(@NotNull m mVar);

    @NotNull
    k u0(@NotNull i iVar);

    @NotNull
    TypeVariance w(@NotNull l lVar);

    boolean w0(@NotNull m mVar);

    @Nullable
    i x0(@NotNull i iVar, @NotNull CaptureStatus captureStatus);

    boolean y0(@NotNull i iVar);

    boolean z(@NotNull i iVar);
}

package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import d2.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.l0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.y;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* compiled from: RawType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends y implements l0 {

    /* compiled from: RawType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements l<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56960a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull String it) {
            f0.p(it, "it");
            return f0.C("(raw) ", it);
        }
    }

    private e(m0 m0Var, m0 m0Var2, boolean z3) {
        super(m0Var, m0Var2);
        if (z3) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a.d(m0Var, m0Var2);
    }

    private static final boolean U0(String str, String str2) {
        String c4;
        c4 = x.c4(str2, "out ");
        return f0.g(str, c4) || f0.g(str2, "*");
    }

    private static final List<String> V0(kotlin.reflect.jvm.internal.impl.renderer.b bVar, e0 e0Var) {
        int Z;
        List<a1> G0 = e0Var.G0();
        Z = kotlin.collections.y.Z(G0, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (a1 a1Var : G0) {
            arrayList.add(bVar.z(a1Var));
        }
        return arrayList;
    }

    private static final String W0(String str, String str2) {
        boolean U2;
        String w5;
        String s5;
        U2 = x.U2(str, '<', false, 2, null);
        if (U2) {
            StringBuilder sb = new StringBuilder();
            w5 = x.w5(str, '<', null, 2, null);
            sb.append(w5);
            sb.append('<');
            sb.append(str2);
            sb.append('>');
            s5 = x.s5(str, '>', null, 2, null);
            sb.append(s5);
            return sb.toString();
        }
        return str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public m0 O0() {
        return P0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    @NotNull
    public String R0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.d options) {
        String X2;
        List T5;
        f0.p(renderer, "renderer");
        f0.p(options, "options");
        String y3 = renderer.y(P0());
        String y4 = renderer.y(Q0());
        if (options.j()) {
            return "raw (" + y3 + ".." + y4 + ')';
        } else if (Q0().G0().isEmpty()) {
            return renderer.v(y3, y4, kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(this));
        } else {
            List<String> V0 = V0(renderer, P0());
            List<String> V02 = V0(renderer, Q0());
            X2 = kotlin.collections.f0.X2(V0, ", ", null, null, 0, null, a.f56960a, 30, null);
            T5 = kotlin.collections.f0.T5(V0, V02);
            boolean z3 = true;
            if (!(T5 instanceof Collection) || !T5.isEmpty()) {
                Iterator it = T5.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!U0((String) pair.getFirst(), (String) pair.getSecond())) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3) {
                y4 = W0(y4, X2);
            }
            String W0 = W0(y3, X2);
            return f0.g(W0, y4) ? W0 : renderer.v(W0, y4, kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(this));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: S0 */
    public e L0(boolean z3) {
        return new e(P0().O0(z3), Q0().O0(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: T0 */
    public y M0(@NotNull g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new e((m0) kotlinTypeRefiner.h(P0()), (m0) kotlinTypeRefiner.h(Q0()), true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l1
    @NotNull
    /* renamed from: X0 */
    public e N0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f newAnnotations) {
        f0.p(newAnnotations, "newAnnotations");
        return new e(P0().P0(newAnnotations), Q0().P0(newAnnotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y, kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public h p() {
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = H0().b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
        if (dVar != null) {
            h o02 = dVar.o0(new d(null, 1, null));
            f0.o(o02, "classDescriptor.getMemberScope(RawSubstitution())");
            return o02;
        }
        throw new IllegalStateException(f0.C("Incorrect classifier: ", H0().b()).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NotNull m0 lowerBound, @NotNull m0 upperBound) {
        this(lowerBound, upperBound, false);
        f0.p(lowerBound, "lowerBound");
        f0.p(upperBound, "upperBound");
    }
}

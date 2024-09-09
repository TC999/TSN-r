package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewCapturedType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k {
    private static final List<a1> a(l1 l1Var, CaptureStatus captureStatus) {
        boolean z3;
        List<Pair> T5;
        int Z;
        if (l1Var.G0().size() != l1Var.H0().getParameters().size()) {
            return null;
        }
        List<a1> G0 = l1Var.G0();
        int i4 = 0;
        boolean z4 = true;
        if (!(G0 instanceof Collection) || !G0.isEmpty()) {
            Iterator<T> it = G0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((a1) it.next()).c() == Variance.INVARIANT) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    z4 = false;
                    break;
                }
            }
        }
        if (z4) {
            return null;
        }
        List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = l1Var.H0().getParameters();
        f0.o(parameters, "type.constructor.parameters");
        T5 = kotlin.collections.f0.T5(G0, parameters);
        Z = kotlin.collections.y.Z(T5, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (Pair pair : T5) {
            a1 a1Var = (a1) pair.component1();
            kotlin.reflect.jvm.internal.impl.descriptors.a1 parameter = (kotlin.reflect.jvm.internal.impl.descriptors.a1) pair.component2();
            if (a1Var.c() != Variance.INVARIANT) {
                l1 K0 = (a1Var.b() || a1Var.c() != Variance.IN_VARIANCE) ? null : a1Var.getType().K0();
                f0.o(parameter, "parameter");
                a1Var = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a(new i(captureStatus, K0, a1Var, parameter));
            }
            arrayList.add(a1Var);
        }
        f1 c4 = z0.f58460c.b(l1Var.H0(), arrayList).c();
        int size = G0.size();
        while (i4 < size) {
            int i5 = i4 + 1;
            a1 a1Var2 = G0.get(i4);
            a1 a1Var3 = (a1) arrayList.get(i4);
            if (a1Var2.c() != Variance.INVARIANT) {
                List<e0> upperBounds = l1Var.H0().getParameters().get(i4).getUpperBounds();
                f0.o(upperBounds, "type.constructor.parameters[index].upperBounds");
                ArrayList arrayList2 = new ArrayList();
                for (e0 e0Var : upperBounds) {
                    arrayList2.add(f.a.f58277a.a(c4.n(e0Var, Variance.INVARIANT).K0()));
                }
                if (!a1Var2.b() && a1Var2.c() == Variance.OUT_VARIANCE) {
                    arrayList2.add(f.a.f58277a.a(a1Var2.getType().K0()));
                }
                ((i) a1Var3.getType()).H0().g(arrayList2);
            }
            i4 = i5;
        }
        return arrayList;
    }

    @Nullable
    public static final m0 b(@NotNull m0 type, @NotNull CaptureStatus status) {
        f0.p(type, "type");
        f0.p(status, "status");
        List<a1> a4 = a(type, status);
        if (a4 == null) {
            return null;
        }
        return c(type, a4);
    }

    private static final m0 c(l1 l1Var, List<? extends a1> list) {
        return kotlin.reflect.jvm.internal.impl.types.f0.j(l1Var.getAnnotations(), l1Var.H0(), list, l1Var.I0(), null, 16, null);
    }
}

package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.b0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: IntersectionType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull
    public static final l1 a(@NotNull List<? extends l1> types) {
        Object S4;
        int Z;
        int Z2;
        m0 P0;
        f0.p(types, "types");
        int size = types.size();
        if (size != 0) {
            if (size != 1) {
                Z = kotlin.collections.y.Z(types, 10);
                ArrayList arrayList = new ArrayList(Z);
                boolean z3 = false;
                boolean z4 = false;
                for (l1 l1Var : types) {
                    z3 = z3 || g0.a(l1Var);
                    if (l1Var instanceof m0) {
                        P0 = (m0) l1Var;
                    } else if (l1Var instanceof kotlin.reflect.jvm.internal.impl.types.y) {
                        if (kotlin.reflect.jvm.internal.impl.types.u.a(l1Var)) {
                            return l1Var;
                        }
                        P0 = ((kotlin.reflect.jvm.internal.impl.types.y) l1Var).P0();
                        z4 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.add(P0);
                }
                if (z3) {
                    m0 j4 = kotlin.reflect.jvm.internal.impl.types.w.j(f0.C("Intersection of error types: ", types));
                    f0.o(j4, "createErrorType(\"Interse\u2026 of error types: $types\")");
                    return j4;
                } else if (!z4) {
                    return w.f58309a.c(arrayList);
                } else {
                    Z2 = kotlin.collections.y.Z(types, 10);
                    ArrayList arrayList2 = new ArrayList(Z2);
                    for (l1 l1Var2 : types) {
                        arrayList2.add(b0.d(l1Var2));
                    }
                    w wVar = w.f58309a;
                    return kotlin.reflect.jvm.internal.impl.types.f0.d(wVar.c(arrayList), wVar.c(arrayList2));
                }
            }
            S4 = kotlin.collections.f0.S4(types);
            return (l1) S4;
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}

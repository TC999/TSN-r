package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;

/* compiled from: mappingUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @NotNull
    public static final z0 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d from, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d to) {
        int Z;
        int Z2;
        List T5;
        Map B0;
        f0.p(from, "from");
        f0.p(to, "to");
        from.r().size();
        to.r().size();
        z0.a aVar = z0.f58460c;
        List<a1> r3 = from.r();
        f0.o(r3, "from.declaredTypeParameters");
        Z = y.Z(r3, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (a1 a1Var : r3) {
            arrayList.add(a1Var.j());
        }
        List<a1> r4 = to.r();
        f0.o(r4, "to.declaredTypeParameters");
        Z2 = y.Z(r4, 10);
        ArrayList arrayList2 = new ArrayList(Z2);
        for (a1 a1Var2 : r4) {
            m0 q3 = a1Var2.q();
            f0.o(q3, "it.defaultType");
            arrayList2.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a(q3));
        }
        T5 = kotlin.collections.f0.T5(arrayList, arrayList2);
        B0 = kotlin.collections.z0.B0(T5);
        return z0.a.e(aVar, B0, false, 2, null);
    }
}

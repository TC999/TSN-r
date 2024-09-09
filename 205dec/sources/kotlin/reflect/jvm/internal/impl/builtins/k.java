package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.m;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;

/* compiled from: suspendFunctionTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final y f56223a;

    static {
        List<a1> l4;
        d0 q3 = w.q();
        f0.o(q3, "getErrorModule()");
        m mVar = new m(q3, j.f56076e);
        ClassKind classKind = ClassKind.INTERFACE;
        kotlin.reflect.jvm.internal.impl.name.f g4 = j.f56079h.g();
        v0 v0Var = v0.f56634a;
        n nVar = kotlin.reflect.jvm.internal.impl.storage.f.f58216e;
        y yVar = new y(mVar, classKind, false, false, g4, v0Var, nVar);
        yVar.H0(Modality.ABSTRACT);
        yVar.J0(r.f56531e);
        l4 = x.l(k0.M0(yVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), false, Variance.IN_VARIANCE, kotlin.reflect.jvm.internal.impl.name.f.f("T"), 0, nVar));
        yVar.I0(l4);
        yVar.F0();
        f56223a = yVar;
    }

    @NotNull
    public static final m0 a(@NotNull e0 suspendFunType) {
        int Z;
        List l4;
        List p4;
        m0 a4;
        f0.p(suspendFunType, "suspendFunType");
        g.o(suspendFunType);
        h h4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(suspendFunType);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = suspendFunType.getAnnotations();
        e0 h5 = g.h(suspendFunType);
        List<kotlin.reflect.jvm.internal.impl.types.a1> j4 = g.j(suspendFunType);
        Z = kotlin.collections.y.Z(j4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (kotlin.reflect.jvm.internal.impl.types.a1 a1Var : j4) {
            arrayList.add(a1Var.getType());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        y0 j5 = f56223a.j();
        f0.o(j5, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        l4 = x.l(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a(g.i(suspendFunType)));
        p4 = kotlin.collections.f0.p4(arrayList, kotlin.reflect.jvm.internal.impl.types.f0.j(b4, j5, l4, false, null, 16, null));
        m0 I = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(suspendFunType).I();
        f0.o(I, "suspendFunType.builtIns.nullableAnyType");
        a4 = g.a(h4, annotations, h5, p4, null, I, (r14 & 64) != 0 ? false : false);
        return a4.O0(suspendFunType.I0());
    }
}

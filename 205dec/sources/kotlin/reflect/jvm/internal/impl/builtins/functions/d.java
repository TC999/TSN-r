package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o0;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.p;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.util.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionInvokeDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d extends g0 {
    @NotNull
    public static final a D = new a(null);

    /* compiled from: FunctionInvokeDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final d1 b(d dVar, int i4, a1 a1Var) {
            String lowerCase;
            String b4 = a1Var.getName().b();
            f0.o(b4, "typeParameter.name.asString()");
            if (f0.g(b4, "T")) {
                lowerCase = "instance";
            } else if (f0.g(b4, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = b4.toLowerCase(Locale.ROOT);
                f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            f b5 = f.f56241g0.b();
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(lowerCase);
            f0.o(f4, "identifier(name)");
            m0 q3 = a1Var.q();
            f0.o(q3, "typeParameter.defaultType");
            v0 NO_SOURCE = v0.f56634a;
            f0.o(NO_SOURCE, "NO_SOURCE");
            return new l0(dVar, null, i4, b5, f4, q3, false, false, false, null, NO_SOURCE);
        }

        @NotNull
        public final d a(@NotNull b functionClass, boolean z3) {
            List<? extends a1> F;
            Iterable<o0> S5;
            int Z;
            Object a32;
            f0.p(functionClass, "functionClass");
            List<a1> r3 = functionClass.r();
            d dVar = new d(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, z3, null);
            s0 E0 = functionClass.E0();
            F = CollectionsKt__CollectionsKt.F();
            ArrayList arrayList = new ArrayList();
            for (Object obj : r3) {
                if (!(((a1) obj).o() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            S5 = kotlin.collections.f0.S5(arrayList);
            Z = y.Z(S5, 10);
            ArrayList arrayList2 = new ArrayList(Z);
            for (o0 o0Var : S5) {
                arrayList2.add(d.D.b(dVar, o0Var.e(), (a1) o0Var.f()));
            }
            a32 = kotlin.collections.f0.a3(r3);
            dVar.M0(null, E0, F, arrayList2, ((a1) a32).q(), Modality.ABSTRACT, r.f56531e);
            dVar.U0(true);
            return dVar;
        }
    }

    private d(k kVar, d dVar, CallableMemberDescriptor.Kind kind, boolean z3) {
        super(kVar, dVar, f.f56241g0.b(), j.f58496h, kind, v0.f56634a);
        a1(true);
        c1(z3);
        T0(false);
    }

    public /* synthetic */ d(k kVar, d dVar, CallableMemberDescriptor.Kind kind, boolean z3, u uVar) {
        this(kVar, dVar, kind, z3);
    }

    private final w k1(List<kotlin.reflect.jvm.internal.impl.name.f> list) {
        int Z;
        boolean z3;
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        int size = h().size() - list.size();
        boolean z4 = true;
        List<d1> valueParameters = h();
        f0.o(valueParameters, "valueParameters");
        Z = y.Z(valueParameters, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (d1 d1Var : valueParameters) {
            kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
            f0.o(name, "it.name");
            int f4 = d1Var.f();
            int i4 = f4 - size;
            if (i4 >= 0 && (fVar = list.get(i4)) != null) {
                name = fVar;
            }
            arrayList.add(d1Var.Y(this, name, f4));
        }
        p.c N0 = N0(f1.f58353b);
        if (!list.isEmpty()) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : list) {
                if (fVar2 == null) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
        }
        z4 = false;
        p.c n4 = N0.G(z4).b(arrayList).n(h0());
        f0.o(n4, "newCopyBuilder(TypeSubst\u2026   .setOriginal(original)");
        w H0 = super.H0(n4);
        f0.m(H0);
        f0.o(H0, "super.doSubstitute(copyConfiguration)!!");
        return H0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean E() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0, kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    protected p G0(@NotNull k newOwner, @Nullable w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull f annotations, @NotNull v0 source) {
        f0.p(newOwner, "newOwner");
        f0.p(kind, "kind");
        f0.p(annotations, "annotations");
        f0.p(source, "source");
        return new d(newOwner, (d) wVar, kind, isSuspend());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @Nullable
    public w H0(@NotNull p.c configuration) {
        boolean z3;
        int Z;
        f0.p(configuration, "configuration");
        d dVar = (d) super.H0(configuration);
        if (dVar == null) {
            return null;
        }
        List<d1> h4 = dVar.h();
        f0.o(h4, "substituted.valueParameters");
        boolean z4 = false;
        if (!(h4 instanceof Collection) || !h4.isEmpty()) {
            for (d1 d1Var : h4) {
                e0 type = d1Var.getType();
                f0.o(type, "it.type");
                if (g.c(type) != null) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
        }
        z4 = true;
        if (z4) {
            return dVar;
        }
        List<d1> h5 = dVar.h();
        f0.o(h5, "substituted.valueParameters");
        Z = y.Z(h5, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (d1 d1Var2 : h5) {
            e0 type2 = d1Var2.getType();
            f0.o(type2, "it.type");
            arrayList.add(g.c(type2));
        }
        return dVar.k1(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isInline() {
        return false;
    }
}

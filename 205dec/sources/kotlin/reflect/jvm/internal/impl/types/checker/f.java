package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypePreparator.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class f extends kotlin.reflect.jvm.internal.impl.types.h {

    /* compiled from: KotlinTypePreparator.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends f {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f58277a = new a();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KotlinTypePreparator.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b extends FunctionReference implements d2.l<r2.g, l1> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final l1 invoke(@NotNull r2.g p02) {
            f0.p(p02, "p0");
            return ((f) this.receiver).a(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "prepareType";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(f.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }
    }

    private final m0 c(m0 m0Var) {
        int Z;
        int Z2;
        List F;
        int Z3;
        y0 H0 = m0Var.H0();
        boolean z3 = false;
        d0 d0Var = null;
        if (H0 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c) {
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c cVar = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c) H0;
            a1 projection = cVar.getProjection();
            if (!(projection.c() == Variance.IN_VARIANCE)) {
                projection = null;
            }
            l1 K0 = projection != null ? projection.getType().K0() : null;
            if (cVar.e() == null) {
                a1 projection2 = cVar.getProjection();
                Collection<e0> j4 = cVar.j();
                Z3 = kotlin.collections.y.Z(j4, 10);
                ArrayList arrayList = new ArrayList(Z3);
                for (e0 e0Var : j4) {
                    arrayList.add(e0Var.K0());
                }
                cVar.g(new j(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            j e4 = cVar.e();
            f0.m(e4);
            return new i(captureStatus, e4, K0, m0Var.getAnnotations(), m0Var.I0(), false, 32, null);
        } else if (H0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.p) {
            Collection<e0> j5 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.p) H0).j();
            Z2 = kotlin.collections.y.Z(j5, 10);
            ArrayList arrayList2 = new ArrayList(Z2);
            for (e0 e0Var2 : j5) {
                e0 q3 = h1.q(e0Var2, m0Var.I0());
                f0.o(q3, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(q3);
            }
            d0 d0Var2 = new d0(arrayList2);
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = m0Var.getAnnotations();
            F = CollectionsKt__CollectionsKt.F();
            return kotlin.reflect.jvm.internal.impl.types.f0.l(annotations, d0Var2, F, false, m0Var.p());
        } else if ((H0 instanceof d0) && m0Var.I0()) {
            d0 d0Var3 = (d0) H0;
            Collection<e0> j6 = d0Var3.j();
            Z = kotlin.collections.y.Z(j6, 10);
            ArrayList arrayList3 = new ArrayList(Z);
            for (e0 e0Var3 : j6) {
                arrayList3.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.q(e0Var3));
                z3 = true;
            }
            if (z3) {
                e0 f4 = d0Var3.f();
                d0Var = new d0(arrayList3).l(f4 != null ? kotlin.reflect.jvm.internal.impl.types.typeUtil.a.q(f4) : null);
            }
            if (d0Var != null) {
                d0Var3 = d0Var;
            }
            return d0Var3.e();
        } else {
            return m0Var;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.h
    @NotNull
    /* renamed from: b */
    public l1 a(@NotNull r2.g type) {
        l1 d4;
        f0.p(type, "type");
        if (type instanceof e0) {
            l1 K0 = ((e0) type).K0();
            if (K0 instanceof m0) {
                d4 = c((m0) K0);
            } else if (K0 instanceof kotlin.reflect.jvm.internal.impl.types.y) {
                kotlin.reflect.jvm.internal.impl.types.y yVar = (kotlin.reflect.jvm.internal.impl.types.y) K0;
                m0 c4 = c(yVar.P0());
                m0 c5 = c(yVar.Q0());
                d4 = (c4 == yVar.P0() && c5 == yVar.Q0()) ? K0 : kotlin.reflect.jvm.internal.impl.types.f0.d(c4, c5);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return j1.c(d4, K0, new b(this));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.i;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.b1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.r0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.r;
import kotlin.reflect.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: KClassifiers.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a6\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0007\u001a.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\"\u001e\u0010\u0014\u001a\u00020\b*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lkotlin/reflect/g;", "", "Lkotlin/reflect/t;", "arguments", "", "nullable", "", "annotations", "Lkotlin/reflect/r;", "b", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/f;", "typeAnnotations", "Lkotlin/reflect/jvm/internal/impl/types/y0;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/m0;", "a", "d", "(Lkotlin/reflect/g;)Lkotlin/reflect/r;", "getStarProjectedType$annotations", "(Lkotlin/reflect/g;)V", "starProjectedType", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KClassifiers")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* compiled from: KClassifiers.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55856a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f55856a = iArr;
        }
    }

    private static final m0 a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, y0 y0Var, List<t> list, boolean z3) {
        int Z;
        b1 r0Var;
        List<a1> parameters = y0Var.getParameters();
        f0.o(parameters, "typeConstructor.parameters");
        Z = y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        int i4 = 0;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            t tVar = (t) obj;
            u uVar = (u) tVar.getType();
            e0 type = uVar == null ? null : uVar.getType();
            KVariance g4 = tVar.g();
            int i6 = g4 == null ? -1 : a.f55856a[g4.ordinal()];
            if (i6 == -1) {
                a1 a1Var = parameters.get(i4);
                f0.o(a1Var, "parameters[index]");
                r0Var = new r0(a1Var);
            } else if (i6 == 1) {
                Variance variance = Variance.INVARIANT;
                f0.m(type);
                r0Var = new c1(variance, type);
            } else if (i6 == 2) {
                Variance variance2 = Variance.IN_VARIANCE;
                f0.m(type);
                r0Var = new c1(variance2, type);
            } else if (i6 == 3) {
                Variance variance3 = Variance.OUT_VARIANCE;
                f0.m(type);
                r0Var = new c1(variance3, type);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(r0Var);
            i4 = i5;
        }
        return kotlin.reflect.jvm.internal.impl.types.f0.j(fVar, y0Var, arrayList, z3, null, 16, null);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final r b(@NotNull kotlin.reflect.g gVar, @NotNull List<t> arguments, boolean z3, @NotNull List<? extends Annotation> annotations) {
        f0.p(gVar, "<this>");
        f0.p(arguments, "arguments");
        f0.p(annotations, "annotations");
        i iVar = gVar instanceof i ? (i) gVar : null;
        if (iVar != null) {
            y0 j4 = iVar.e().j();
            f0.o(j4, "descriptor.typeConstructor");
            List<a1> parameters = j4.getParameters();
            f0.o(parameters, "typeConstructor.parameters");
            if (parameters.size() == arguments.size()) {
                return new u(a(annotations.isEmpty() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b() : kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), j4, arguments, z3), null, 2, null);
            }
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
        }
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + gVar + " (" + gVar.getClass() + ')');
    }

    public static /* synthetic */ r c(kotlin.reflect.g gVar, List list, boolean z3, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = CollectionsKt__CollectionsKt.F();
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.F();
        }
        return b(gVar, list, z3, list2);
    }

    @NotNull
    public static final r d(@NotNull kotlin.reflect.g gVar) {
        int Z;
        f0.p(gVar, "<this>");
        i iVar = gVar instanceof i ? (i) gVar : null;
        if (iVar == null) {
            return c(gVar, null, false, null, 7, null);
        }
        List<a1> parameters = iVar.e().j().getParameters();
        f0.o(parameters, "descriptor.typeConstructor.parameters");
        if (parameters.isEmpty()) {
            return c(gVar, null, false, null, 7, null);
        }
        Z = y.Z(parameters, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (a1 a1Var : parameters) {
            arrayList.add(t.f58685c.c());
        }
        return c(gVar, arrayList, false, null, 6, null);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void e(kotlin.reflect.g gVar) {
    }
}

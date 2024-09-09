package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import java.util.Map;
import kotlin.collections.z0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: functionTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @JvmOverloads
    @NotNull
    public static final m0 a(@NotNull h builtIns, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @Nullable e0 e0Var, @NotNull List<? extends e0> parameterTypes, @Nullable List<kotlin.reflect.jvm.internal.impl.name.f> list, @NotNull e0 returnType, boolean z3) {
        f0.p(builtIns, "builtIns");
        f0.p(annotations, "annotations");
        f0.p(parameterTypes, "parameterTypes");
        f0.p(returnType, "returnType");
        List<a1> e4 = e(e0Var, parameterTypes, list, returnType, builtIns);
        int size = parameterTypes.size();
        if (e0Var != null) {
            size++;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d d4 = d(builtIns, size, z3);
        if (e0Var != null) {
            annotations = q(annotations, builtIns);
        }
        return kotlin.reflect.jvm.internal.impl.types.f0.g(annotations, d4, e4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (kotlin.reflect.jvm.internal.impl.name.f.h(r2) != false) goto L10;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.impl.name.f c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.e0 r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.f0.p(r2, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r2 = r2.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.c r0 = kotlin.reflect.jvm.internal.impl.builtins.j.a.D
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c r2 = r2.b(r0)
            r0 = 0
            if (r2 != 0) goto L13
            return r0
        L13:
            java.util.Map r2 = r2.a()
            java.util.Collection r2 = r2.values()
            java.lang.Object r2 = kotlin.collections.w.T4(r2)
            boolean r1 = r2 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.v
            if (r1 == 0) goto L26
            kotlin.reflect.jvm.internal.impl.resolve.constants.v r2 = (kotlin.reflect.jvm.internal.impl.resolve.constants.v) r2
            goto L27
        L26:
            r2 = r0
        L27:
            if (r2 != 0) goto L2b
        L29:
            r2 = r0
            goto L37
        L2b:
            java.lang.Object r2 = r2.a()
            java.lang.String r2 = (java.lang.String) r2
            boolean r1 = kotlin.reflect.jvm.internal.impl.name.f.h(r2)
            if (r1 == 0) goto L29
        L37:
            if (r2 != 0) goto L3a
            return r0
        L3a:
            kotlin.reflect.jvm.internal.impl.name.f r2 = kotlin.reflect.jvm.internal.impl.name.f.f(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.g.c(kotlin.reflect.jvm.internal.impl.types.e0):kotlin.reflect.jvm.internal.impl.name.f");
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull h builtIns, int i4, boolean z3) {
        f0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.d X = z3 ? builtIns.X(i4) : builtIns.C(i4);
        f0.o(X, "if (isSuspendFunction) b\u2026tFunction(parameterCount)");
        return X;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r2.g() == false) goto L16;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.a1> e(@org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.types.e0 r9, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.e0> r10, @org.jetbrains.annotations.Nullable java.util.List<kotlin.reflect.jvm.internal.impl.name.f> r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.e0 r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.builtins.h r13) {
        /*
            java.lang.String r0 = "parameterTypes"
            kotlin.jvm.internal.f0.p(r10, r0)
            java.lang.String r0 = "returnType"
            kotlin.jvm.internal.f0.p(r12, r0)
            java.lang.String r0 = "builtIns"
            kotlin.jvm.internal.f0.p(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.size()
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L1b
            r4 = 1
            goto L1c
        L1b:
            r4 = 0
        L1c:
            int r1 = r1 + r4
            int r1 = r1 + r3
            r0.<init>(r1)
            r1 = 0
            if (r9 != 0) goto L26
            r9 = r1
            goto L2a
        L26:
            kotlin.reflect.jvm.internal.impl.types.a1 r9 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a(r9)
        L2a:
            kotlin.reflect.jvm.internal.impl.utils.a.a(r0, r9)
            java.util.Iterator r9 = r10.iterator()
        L31:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L94
            java.lang.Object r10 = r9.next()
            int r3 = r2 + 1
            if (r2 >= 0) goto L42
            kotlin.collections.w.X()
        L42:
            kotlin.reflect.jvm.internal.impl.types.e0 r10 = (kotlin.reflect.jvm.internal.impl.types.e0) r10
            if (r11 != 0) goto L48
        L46:
            r2 = r1
            goto L54
        L48:
            java.lang.Object r2 = r11.get(r2)
            kotlin.reflect.jvm.internal.impl.name.f r2 = (kotlin.reflect.jvm.internal.impl.name.f) r2
            boolean r4 = r2.g()
            if (r4 != 0) goto L46
        L54:
            if (r2 == 0) goto L8b
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.i r4 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.i
            kotlin.reflect.jvm.internal.impl.name.c r5 = kotlin.reflect.jvm.internal.impl.builtins.j.a.D
            java.lang.String r6 = "name"
            kotlin.reflect.jvm.internal.impl.name.f r6 = kotlin.reflect.jvm.internal.impl.name.f.f(r6)
            kotlin.reflect.jvm.internal.impl.resolve.constants.v r7 = new kotlin.reflect.jvm.internal.impl.resolve.constants.v
            java.lang.String r2 = r2.b()
            java.lang.String r8 = "name.asString()"
            kotlin.jvm.internal.f0.o(r2, r8)
            r7.<init>(r2)
            kotlin.Pair r2 = kotlin.l0.a(r6, r7)
            java.util.Map r2 = kotlin.collections.w0.k(r2)
            r4.<init>(r13, r5, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f$a r2 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r5 = r10.getAnnotations()
            java.util.List r4 = kotlin.collections.w.l4(r5, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r2 = r2.a(r4)
            kotlin.reflect.jvm.internal.impl.types.e0 r10 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.r(r10, r2)
        L8b:
            kotlin.reflect.jvm.internal.impl.types.a1 r10 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a(r10)
            r0.add(r10)
            r2 = r3
            goto L31
        L94:
            kotlin.reflect.jvm.internal.impl.types.a1 r9 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a(r12)
            r0.add(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.g.e(kotlin.reflect.jvm.internal.impl.types.e0, java.util.List, java.util.List, kotlin.reflect.jvm.internal.impl.types.e0, kotlin.reflect.jvm.internal.impl.builtins.h):java.util.List");
    }

    @Nullable
    public static final FunctionClassKind f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        f0.p(kVar, "<this>");
        if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && h.z0(kVar)) {
            return g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(kVar));
        }
        return null;
    }

    private static final FunctionClassKind g(kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (!dVar.f() || dVar.e()) {
            return null;
        }
        FunctionClassKind.a aVar = FunctionClassKind.Companion;
        String b4 = dVar.i().b();
        f0.o(b4, "shortName().asString()");
        kotlin.reflect.jvm.internal.impl.name.c e4 = dVar.l().e();
        f0.o(e4, "toSafe().parent()");
        return aVar.b(b4, e4);
    }

    @Nullable
    public static final e0 h(@NotNull e0 e0Var) {
        Object m22;
        f0.p(e0Var, "<this>");
        m(e0Var);
        if (p(e0Var)) {
            m22 = kotlin.collections.f0.m2(e0Var.G0());
            return ((a1) m22).getType();
        }
        return null;
    }

    @NotNull
    public static final e0 i(@NotNull e0 e0Var) {
        Object a32;
        f0.p(e0Var, "<this>");
        m(e0Var);
        a32 = kotlin.collections.f0.a3(e0Var.G0());
        e0 type = ((a1) a32).getType();
        f0.o(type, "arguments.last().type");
        return type;
    }

    @NotNull
    public static final List<a1> j(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        m(e0Var);
        List<a1> G0 = e0Var.G0();
        return G0.subList(k(e0Var) ? 1 : 0, G0.size() - 1);
    }

    public static final boolean k(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return m(e0Var) && p(e0Var);
    }

    public static final boolean l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        f0.p(kVar, "<this>");
        FunctionClassKind f4 = f(kVar);
        return f4 == FunctionClassKind.Function || f4 == FunctionClassKind.SuspendFunction;
    }

    public static final boolean m(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        return b4 != null && l(b4);
    }

    public static final boolean n(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        return (b4 == null ? null : f(b4)) == FunctionClassKind.Function;
    }

    public static final boolean o(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        return (b4 == null ? null : f(b4)) == FunctionClassKind.SuspendFunction;
    }

    private static final boolean p(e0 e0Var) {
        return e0Var.getAnnotations().b(j.a.C) != null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f q(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull h builtIns) {
        Map z3;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> l4;
        f0.p(fVar, "<this>");
        f0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.name.c cVar = j.a.C;
        if (fVar.i(cVar)) {
            return fVar;
        }
        f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
        z3 = z0.z();
        l4 = kotlin.collections.f0.l4(fVar, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.i(builtIns, cVar, z3));
        return aVar.a(l4);
    }
}

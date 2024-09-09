package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.SinceKotlin;
import kotlin.reflect.KVariance;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Reflection.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final o0 f55649a;

    /* renamed from: b  reason: collision with root package name */
    static final String f55650b = " (Kotlin reflection is not available)";

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.reflect.d[] f55651c;

    static {
        o0 o0Var = null;
        try {
            o0Var = (o0) kotlin.reflect.jvm.internal.z.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (o0Var == null) {
            o0Var = new o0();
        }
        f55649a = o0Var;
        f55651c = new kotlin.reflect.d[0];
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r A(Class cls) {
        return f55649a.s(d(cls), Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r B(Class cls, kotlin.reflect.t tVar) {
        return f55649a.s(d(cls), Collections.singletonList(tVar), false);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r C(Class cls, kotlin.reflect.t tVar, kotlin.reflect.t tVar2) {
        return f55649a.s(d(cls), Arrays.asList(tVar, tVar2), false);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r D(Class cls, kotlin.reflect.t... tVarArr) {
        return f55649a.s(d(cls), kotlin.collections.l.ey(tVarArr), false);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r E(kotlin.reflect.g gVar) {
        return f55649a.s(gVar, Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.s F(Object obj, String str, KVariance kVariance, boolean z3) {
        return f55649a.t(obj, str, kVariance, z3);
    }

    public static kotlin.reflect.d a(Class cls) {
        return f55649a.a(cls);
    }

    public static kotlin.reflect.d b(Class cls, String str) {
        return f55649a.b(cls, str);
    }

    public static kotlin.reflect.i c(FunctionReference functionReference) {
        return f55649a.c(functionReference);
    }

    public static kotlin.reflect.d d(Class cls) {
        return f55649a.d(cls);
    }

    public static kotlin.reflect.d e(Class cls, String str) {
        return f55649a.e(cls, str);
    }

    public static kotlin.reflect.d[] f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f55651c;
        }
        kotlin.reflect.d[] dVarArr = new kotlin.reflect.d[length];
        for (int i4 = 0; i4 < length; i4++) {
            dVarArr[i4] = d(clsArr[i4]);
        }
        return dVarArr;
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.h g(Class cls) {
        return f55649a.f(cls, "");
    }

    public static kotlin.reflect.h h(Class cls, String str) {
        return f55649a.f(cls, str);
    }

    @SinceKotlin(version = "1.6")
    public static kotlin.reflect.r i(kotlin.reflect.r rVar) {
        return f55649a.g(rVar);
    }

    public static kotlin.reflect.k j(MutablePropertyReference0 mutablePropertyReference0) {
        return f55649a.h(mutablePropertyReference0);
    }

    public static kotlin.reflect.l k(MutablePropertyReference1 mutablePropertyReference1) {
        return f55649a.i(mutablePropertyReference1);
    }

    public static kotlin.reflect.m l(MutablePropertyReference2 mutablePropertyReference2) {
        return f55649a.j(mutablePropertyReference2);
    }

    @SinceKotlin(version = "1.6")
    public static kotlin.reflect.r m(kotlin.reflect.r rVar) {
        return f55649a.k(rVar);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r n(Class cls) {
        return f55649a.s(d(cls), Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r o(Class cls, kotlin.reflect.t tVar) {
        return f55649a.s(d(cls), Collections.singletonList(tVar), true);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r p(Class cls, kotlin.reflect.t tVar, kotlin.reflect.t tVar2) {
        return f55649a.s(d(cls), Arrays.asList(tVar, tVar2), true);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r q(Class cls, kotlin.reflect.t... tVarArr) {
        return f55649a.s(d(cls), kotlin.collections.l.ey(tVarArr), true);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.r r(kotlin.reflect.g gVar) {
        return f55649a.s(gVar, Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.6")
    public static kotlin.reflect.r s(kotlin.reflect.r rVar, kotlin.reflect.r rVar2) {
        return f55649a.l(rVar, rVar2);
    }

    public static kotlin.reflect.o t(PropertyReference0 propertyReference0) {
        return f55649a.m(propertyReference0);
    }

    public static kotlin.reflect.p u(PropertyReference1 propertyReference1) {
        return f55649a.n(propertyReference1);
    }

    public static kotlin.reflect.q v(PropertyReference2 propertyReference2) {
        return f55649a.o(propertyReference2);
    }

    @SinceKotlin(version = "1.3")
    public static String w(b0 b0Var) {
        return f55649a.p(b0Var);
    }

    @SinceKotlin(version = "1.1")
    public static String x(Lambda lambda) {
        return f55649a.q(lambda);
    }

    @SinceKotlin(version = "1.4")
    public static void y(kotlin.reflect.s sVar, kotlin.reflect.r rVar) {
        f55649a.r(sVar, Collections.singletonList(rVar));
    }

    @SinceKotlin(version = "1.4")
    public static void z(kotlin.reflect.s sVar, kotlin.reflect.r... rVarArr) {
        f55649a.r(sVar, kotlin.collections.l.ey(rVarArr));
    }
}

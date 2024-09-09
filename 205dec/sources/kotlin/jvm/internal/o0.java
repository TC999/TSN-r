package kotlin.jvm.internal;

import java.util.List;
import kotlin.SinceKotlin;
import kotlin.reflect.KVariance;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ReflectionFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class o0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f55653a = "kotlin.jvm.functions.";

    public kotlin.reflect.d a(Class cls) {
        return new s(cls);
    }

    public kotlin.reflect.d b(Class cls, String str) {
        return new s(cls);
    }

    public kotlin.reflect.i c(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.d d(Class cls) {
        return new s(cls);
    }

    public kotlin.reflect.d e(Class cls, String str) {
        return new s(cls);
    }

    public kotlin.reflect.h f(Class cls, String str) {
        return new l0(cls, str);
    }

    @SinceKotlin(version = "1.6")
    public kotlin.reflect.r g(kotlin.reflect.r rVar) {
        v0 v0Var = (v0) rVar;
        return new v0(rVar.a(), rVar.getArguments(), v0Var.s(), v0Var.o() | 2);
    }

    public kotlin.reflect.k h(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.l i(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.m j(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    @SinceKotlin(version = "1.6")
    public kotlin.reflect.r k(kotlin.reflect.r rVar) {
        v0 v0Var = (v0) rVar;
        return new v0(rVar.a(), rVar.getArguments(), v0Var.s(), v0Var.o() | 4);
    }

    @SinceKotlin(version = "1.6")
    public kotlin.reflect.r l(kotlin.reflect.r rVar, kotlin.reflect.r rVar2) {
        return new v0(rVar.a(), rVar.getArguments(), rVar2, ((v0) rVar).o());
    }

    public kotlin.reflect.o m(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.p n(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.q o(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @SinceKotlin(version = "1.3")
    public String p(b0 b0Var) {
        String obj = b0Var.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    @SinceKotlin(version = "1.1")
    public String q(Lambda lambda) {
        return p(lambda);
    }

    @SinceKotlin(version = "1.4")
    public void r(kotlin.reflect.s sVar, List<kotlin.reflect.r> list) {
        ((u0) sVar).b(list);
    }

    @SinceKotlin(version = "1.4")
    public kotlin.reflect.r s(kotlin.reflect.g gVar, List<kotlin.reflect.t> list, boolean z3) {
        return new v0(gVar, list, z3);
    }

    @SinceKotlin(version = "1.4")
    public kotlin.reflect.s t(Object obj, String str, KVariance kVariance, boolean z3) {
        return new u0(obj, str, kVariance, z3);
    }
}

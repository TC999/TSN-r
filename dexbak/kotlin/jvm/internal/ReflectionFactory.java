package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.reflect.InterfaceC14440k;
import kotlin.reflect.InterfaceC14442l;
import kotlin.reflect.InterfaceC14444m;
import kotlin.reflect.InterfaceC14450o;
import kotlin.reflect.InterfaceC14452p;
import kotlin.reflect.InterfaceC14454q;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* renamed from: kotlin.jvm.internal.o0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ReflectionFactory {

    /* renamed from: a */
    private static final String f41163a = "kotlin.jvm.functions.";

    /* renamed from: a */
    public KClass m8097a(Class cls) {
        return new ClassReference(cls);
    }

    /* renamed from: b */
    public KClass m8096b(Class cls, String str) {
        return new ClassReference(cls);
    }

    /* renamed from: c */
    public KFunction m8095c(FunctionReference functionReference) {
        return functionReference;
    }

    /* renamed from: d */
    public KClass m8094d(Class cls) {
        return new ClassReference(cls);
    }

    /* renamed from: e */
    public KClass m8093e(Class cls, String str) {
        return new ClassReference(cls);
    }

    /* renamed from: f */
    public KDeclarationContainer m8092f(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    /* renamed from: g */
    public InterfaceC14440k m8091g(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    /* renamed from: h */
    public InterfaceC14442l m8090h(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    /* renamed from: i */
    public InterfaceC14444m m8089i(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    /* renamed from: j */
    public InterfaceC14450o m8088j(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    /* renamed from: k */
    public InterfaceC14452p m8087k(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    /* renamed from: l */
    public InterfaceC14454q m8086l(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: m */
    public String m8085m(FunctionBase functionBase) {
        String obj = functionBase.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith(f41163a) ? obj.substring(21) : obj;
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: n */
    public String m8084n(Lambda lambda) {
        return m8085m(lambda);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: o */
    public void m8083o(KTypeParameter kTypeParameter, List<KType> list) {
        ((TypeParameterReference) kTypeParameter).m7987f(list);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: p */
    public KType m8082p(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return new TypeReference(kClassifier, list, z);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: q */
    public KTypeParameter m8081q(Object obj, String str, KVariance kVariance, boolean z) {
        return new TypeParameterReference(obj, str, kVariance, z);
    }
}

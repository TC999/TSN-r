package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Arrays;
import java.util.Collections;
import kotlin.SinceKotlin;
import kotlin.collections.C14173m;
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

/* renamed from: kotlin.jvm.internal.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Reflection {

    /* renamed from: a */
    private static final ReflectionFactory f41159a;

    /* renamed from: b */
    static final String f41160b = " (Kotlin reflection is not available)";

    /* renamed from: c */
    private static final KClass[] f41161c;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f41159a = reflectionFactory;
        f41161c = new KClass[0];
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: A */
    public static KType m8129A(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f41159a.m8082p(m8123d(cls), C14173m.m11852ey(kTypeProjectionArr), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: B */
    public static KType m8128B(KClassifier kClassifier) {
        return f41159a.m8082p(kClassifier, Collections.emptyList(), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: C */
    public static KTypeParameter m8127C(Object obj, String str, KVariance kVariance, boolean z) {
        return f41159a.m8081q(obj, str, kVariance, z);
    }

    /* renamed from: a */
    public static KClass m8126a(Class cls) {
        return f41159a.m8097a(cls);
    }

    /* renamed from: b */
    public static KClass m8125b(Class cls, String str) {
        return f41159a.m8096b(cls, str);
    }

    /* renamed from: c */
    public static KFunction m8124c(FunctionReference functionReference) {
        return f41159a.m8095c(functionReference);
    }

    /* renamed from: d */
    public static KClass m8123d(Class cls) {
        return f41159a.m8094d(cls);
    }

    /* renamed from: e */
    public static KClass m8122e(Class cls, String str) {
        return f41159a.m8093e(cls, str);
    }

    /* renamed from: f */
    public static KClass[] m8121f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f41161c;
        }
        KClass[] kClassArr = new KClass[length];
        for (int i = 0; i < length; i++) {
            kClassArr[i] = m8123d(clsArr[i]);
        }
        return kClassArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: g */
    public static KDeclarationContainer m8120g(Class cls) {
        return f41159a.m8092f(cls, "");
    }

    /* renamed from: h */
    public static KDeclarationContainer m8119h(Class cls, String str) {
        return f41159a.m8092f(cls, str);
    }

    /* renamed from: i */
    public static InterfaceC14440k m8118i(MutablePropertyReference0 mutablePropertyReference0) {
        return f41159a.m8091g(mutablePropertyReference0);
    }

    /* renamed from: j */
    public static InterfaceC14442l m8117j(MutablePropertyReference1 mutablePropertyReference1) {
        return f41159a.m8090h(mutablePropertyReference1);
    }

    /* renamed from: k */
    public static InterfaceC14444m m8116k(MutablePropertyReference2 mutablePropertyReference2) {
        return f41159a.m8089i(mutablePropertyReference2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: l */
    public static KType m8115l(Class cls) {
        return f41159a.m8082p(m8123d(cls), Collections.emptyList(), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: m */
    public static KType m8114m(Class cls, KTypeProjection kTypeProjection) {
        return f41159a.m8082p(m8123d(cls), Collections.singletonList(kTypeProjection), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: n */
    public static KType m8113n(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f41159a.m8082p(m8123d(cls), Arrays.asList(kTypeProjection, kTypeProjection2), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: o */
    public static KType m8112o(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f41159a.m8082p(m8123d(cls), C14173m.m11852ey(kTypeProjectionArr), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: p */
    public static KType m8111p(KClassifier kClassifier) {
        return f41159a.m8082p(kClassifier, Collections.emptyList(), true);
    }

    /* renamed from: q */
    public static InterfaceC14450o m8110q(PropertyReference0 propertyReference0) {
        return f41159a.m8088j(propertyReference0);
    }

    /* renamed from: r */
    public static InterfaceC14452p m8109r(PropertyReference1 propertyReference1) {
        return f41159a.m8087k(propertyReference1);
    }

    /* renamed from: s */
    public static InterfaceC14454q m8108s(PropertyReference2 propertyReference2) {
        return f41159a.m8086l(propertyReference2);
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: t */
    public static String m8107t(FunctionBase functionBase) {
        return f41159a.m8085m(functionBase);
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: u */
    public static String m8106u(Lambda lambda) {
        return f41159a.m8084n(lambda);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: v */
    public static void m8105v(KTypeParameter kTypeParameter, KType kType) {
        f41159a.m8083o(kTypeParameter, Collections.singletonList(kType));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: w */
    public static void m8104w(KTypeParameter kTypeParameter, KType... kTypeArr) {
        f41159a.m8083o(kTypeParameter, C14173m.m11852ey(kTypeArr));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: x */
    public static KType m8103x(Class cls) {
        return f41159a.m8082p(m8123d(cls), Collections.emptyList(), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: y */
    public static KType m8102y(Class cls, KTypeProjection kTypeProjection) {
        return f41159a.m8082p(m8123d(cls), Collections.singletonList(kTypeProjection), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: z */
    public static KType m8101z(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f41159a.m8082p(m8123d(cls), Arrays.asList(kTypeProjection, kTypeProjection2), false);
    }
}

package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics.java */
/* renamed from: kotlin.jvm.internal.f0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14342f0 {

    /* compiled from: Intrinsics.java */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: kotlin.jvm.internal.f0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C14343a {
        private C14343a() {
        }
    }

    private C14342f0() {
    }

    /* renamed from: A */
    private static <T extends Throwable> T m8218A(T t) {
        return (T) m8217B(t, C14342f0.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public static <T extends Throwable> T m8217B(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* renamed from: C */
    public static String m8216C(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: D */
    public static void m8215D() {
        throw ((AssertionError) m8218A(new AssertionError()));
    }

    /* renamed from: E */
    public static void m8214E(String str) {
        throw ((AssertionError) m8218A(new AssertionError(str)));
    }

    /* renamed from: F */
    public static void m8213F() {
        throw ((IllegalArgumentException) m8218A(new IllegalArgumentException()));
    }

    /* renamed from: G */
    public static void m8212G(String str) {
        throw ((IllegalArgumentException) m8218A(new IllegalArgumentException(str)));
    }

    /* renamed from: H */
    public static void m8211H() {
        throw ((IllegalStateException) m8218A(new IllegalStateException()));
    }

    /* renamed from: I */
    public static void m8210I(String str) {
        throw ((IllegalStateException) m8218A(new IllegalStateException(str)));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: J */
    public static void m8209J() {
        throw ((NullPointerException) m8218A(new NullPointerException()));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: K */
    public static void m8208K(String str) {
        throw ((NullPointerException) m8218A(new NullPointerException(str)));
    }

    /* renamed from: L */
    public static void m8207L() {
        throw ((KotlinNullPointerException) m8218A(new KotlinNullPointerException()));
    }

    /* renamed from: M */
    public static void m8206M(String str) {
        throw ((KotlinNullPointerException) m8218A(new KotlinNullPointerException(str)));
    }

    /* renamed from: N */
    private static void m8205N(String str) {
        throw ((IllegalArgumentException) m8218A(new IllegalArgumentException(m8178v(str))));
    }

    /* renamed from: O */
    private static void m8204O(String str) {
        throw ((NullPointerException) m8218A(new NullPointerException(m8178v(str))));
    }

    /* renamed from: P */
    public static void m8203P() {
        m8202Q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* renamed from: Q */
    public static void m8202Q(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* renamed from: R */
    public static void m8201R(String str) {
        throw ((UninitializedPropertyAccessException) m8218A(new UninitializedPropertyAccessException(str)));
    }

    /* renamed from: S */
    public static void m8200S(String str) {
        m8201R("lateinit property " + str + " has not been initialized");
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: a */
    public static boolean m8199a(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: b */
    public static boolean m8198b(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: c */
    public static boolean m8197c(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: d */
    public static boolean m8196d(Double d, Double d2) {
        if (d == null) {
            if (d2 == null) {
                return true;
            }
        } else if (d2 != null && d.doubleValue() == d2.doubleValue()) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: e */
    public static boolean m8195e(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: f */
    public static boolean m8194f(Float f, Float f2) {
        if (f == null) {
            if (f2 == null) {
                return true;
            }
        } else if (f2 != null && f.floatValue() == f2.floatValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m8193g(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: h */
    public static void m8192h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m8218A(new IllegalStateException(str + " must not be null")));
    }

    /* renamed from: i */
    public static void m8191i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m8218A(new IllegalStateException(str)));
        }
    }

    /* renamed from: j */
    public static void m8190j(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m8218A(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
    }

    /* renamed from: k */
    public static void m8189k(String str) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) m8218A(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e)));
        }
    }

    /* renamed from: l */
    public static void m8188l(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) m8218A(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e)));
        }
    }

    /* renamed from: m */
    public static void m8187m(Object obj) {
        if (obj == null) {
            m8209J();
        }
    }

    /* renamed from: n */
    public static void m8186n(Object obj, String str) {
        if (obj == null) {
            m8208K(str);
        }
    }

    /* renamed from: o */
    public static void m8185o(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m8218A(new NullPointerException(str + " must not be null")));
    }

    /* renamed from: p */
    public static void m8184p(Object obj, String str) {
        if (obj == null) {
            m8204O(str);
        }
    }

    /* renamed from: q */
    public static void m8183q(Object obj, String str) {
        if (obj == null) {
            m8205N(str);
        }
    }

    /* renamed from: r */
    public static void m8182r(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m8218A(new IllegalStateException(str)));
        }
    }

    /* renamed from: s */
    public static void m8181s(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m8218A(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
    }

    /* renamed from: t */
    public static int m8180t(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: u */
    public static int m8179u(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    /* renamed from: v */
    private static String m8178v(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    /* renamed from: w */
    public static void m8177w() {
        m8203P();
    }

    /* renamed from: x */
    public static void m8176x(String str) {
        m8202Q(str);
    }

    /* renamed from: y */
    public static void m8175y(int i, String str) {
        m8203P();
    }

    /* renamed from: z */
    public static void m8174z(int i, String str, String str2) {
        m8202Q(str2);
    }
}

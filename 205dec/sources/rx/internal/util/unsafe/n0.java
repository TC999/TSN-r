package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: UnsafeAccess.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f64070a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f64071b;

    static {
        f64071b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f64070a = unsafe;
    }

    private n0() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f64070a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e4) {
            InternalError internalError = new InternalError();
            internalError.initCause(e4);
            throw internalError;
        }
    }

    public static boolean b(Object obj, long j4, int i4, int i5) {
        return f64070a.compareAndSwapInt(obj, j4, i4, i5);
    }

    public static int c(Object obj, long j4, int i4) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f64070a;
            intVolatile = unsafe.getIntVolatile(obj, j4);
        } while (!unsafe.compareAndSwapInt(obj, j4, intVolatile, intVolatile + i4));
        return intVolatile;
    }

    public static int d(Object obj, long j4) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f64070a;
            intVolatile = unsafe.getIntVolatile(obj, j4);
        } while (!unsafe.compareAndSwapInt(obj, j4, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    public static int e(Object obj, long j4, int i4) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f64070a;
            intVolatile = unsafe.getIntVolatile(obj, j4);
        } while (!unsafe.compareAndSwapInt(obj, j4, intVolatile, i4));
        return intVolatile;
    }

    public static boolean f() {
        return (f64070a == null || f64071b) ? false : true;
    }
}

package p640rx.internal.util.unsafe;

import java.lang.reflect.Field;
import p640rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UnsafeAccess {

    /* renamed from: a */
    public static final Unsafe f46750a;

    /* renamed from: b */
    private static final boolean f46751b;

    static {
        f46751b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f46750a = unsafe;
    }

    private UnsafeAccess() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static long m764a(Class<?> cls, String str) {
        try {
            return f46750a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    /* renamed from: b */
    public static boolean m763b(Object obj, long j, int i, int i2) {
        return f46750a.compareAndSwapInt(obj, j, i, i2);
    }

    /* renamed from: c */
    public static int m762c(Object obj, long j, int i) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f46750a;
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, intVolatile + i));
        return intVolatile;
    }

    /* renamed from: d */
    public static int m761d(Object obj, long j) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f46750a;
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    /* renamed from: e */
    public static int m760e(Object obj, long j, int i) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f46750a;
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, i));
        return intVolatile;
    }

    /* renamed from: f */
    public static boolean m759f() {
        return (f46750a == null || f46751b) ? false : true;
    }
}

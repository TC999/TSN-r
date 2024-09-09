package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class PlatformDependent0 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final Object INTERNAL_UNSAFE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    private static final int JAVA_VERSION;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static {
        final ByteBuffer allocateDirect;
        final Unsafe unsafe;
        Field field;
        long j4;
        Constructor<?> constructor;
        boolean z3;
        Method method;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(PlatformDependent0.class);
        logger = internalLoggerFactory;
        Throwable explicitNoUnsafeCause0 = explicitNoUnsafeCause0();
        EXPLICIT_NO_UNSAFE_CAUSE = explicitNoUnsafeCause0;
        JAVA_VERSION = javaVersion0();
        IS_ANDROID = isAndroid0();
        IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = explicitTryReflectionSetAccessible0();
        Method method2 = null;
        if (explicitNoUnsafeCause0 != null) {
            allocateDirect = null;
            unsafe = null;
            field = null;
        } else {
            allocateDirect = ByteBuffer.allocateDirect(1);
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField, false);
                        return trySetAccessible != null ? trySetAccessible : declaredField.get(null);
                    } catch (IllegalAccessException e4) {
                        return e4;
                    } catch (NoClassDefFoundError e5) {
                        return e5;
                    } catch (NoSuchFieldException e6) {
                        return e6;
                    } catch (SecurityException e7) {
                        return e7;
                    }
                }
            });
            if (doPrivileged instanceof Throwable) {
                explicitNoUnsafeCause0 = (Throwable) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: unavailable", explicitNoUnsafeCause0);
                unsafe = null;
            } else {
                unsafe = (Unsafe) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: available");
            }
            if (unsafe != null) {
                Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = unsafe.getClass();
                            Class<?> cls2 = Long.TYPE;
                            cls.getDeclaredMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                            return null;
                        } catch (NoSuchMethodException e4) {
                            return e4;
                        } catch (SecurityException e5) {
                            return e5;
                        }
                    }
                });
                if (doPrivileged2 == null) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: available");
                } else {
                    explicitNoUnsafeCause0 = (Throwable) doPrivileged2;
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: unavailable", explicitNoUnsafeCause0);
                    unsafe = null;
                }
            }
            if (unsafe != null) {
                Object doPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Field declaredField = Buffer.class.getDeclaredField("address");
                            if (unsafe.getLong(allocateDirect, unsafe.objectFieldOffset(declaredField)) == 0) {
                                return null;
                            }
                            return declaredField;
                        } catch (NoSuchFieldException e4) {
                            return e4;
                        } catch (SecurityException e5) {
                            return e5;
                        }
                    }
                });
                if (doPrivileged3 instanceof Field) {
                    field = (Field) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: available");
                } else {
                    Throwable th = (Throwable) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: unavailable", th);
                    unsafe = null;
                    explicitNoUnsafeCause0 = th;
                    field = null;
                }
            } else {
                field = null;
            }
            if (unsafe != null) {
                long arrayIndexScale = unsafe.arrayIndexScale(byte[].class);
                if (arrayIndexScale != 1) {
                    internalLoggerFactory.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", Long.valueOf(arrayIndexScale));
                    explicitNoUnsafeCause0 = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                    unsafe = null;
                }
            }
        }
        UNSAFE_UNAVAILABILITY_CAUSE = explicitNoUnsafeCause0;
        UNSAFE = unsafe;
        if (unsafe == null) {
            ADDRESS_FIELD_OFFSET = -1L;
            BYTE_ARRAY_BASE_OFFSET = -1L;
            UNALIGNED = false;
            DIRECT_BUFFER_CONSTRUCTOR = null;
            ALLOCATE_ARRAY_METHOD = null;
        } else {
            try {
                Object doPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.4
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Constructor<?> declaredConstructor = allocateDirect.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredConstructor, true);
                            return trySetAccessible != null ? trySetAccessible : declaredConstructor;
                        } catch (NoSuchMethodException e4) {
                            return e4;
                        } catch (SecurityException e5) {
                            return e5;
                        }
                    }
                });
                if (doPrivileged4 instanceof Constructor) {
                    j4 = unsafe.allocateMemory(1L);
                    try {
                        ((Constructor) doPrivileged4).newInstance(Long.valueOf(j4), 1);
                        constructor = (Constructor) doPrivileged4;
                        internalLoggerFactory.debug("direct buffer constructor: available");
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        constructor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (j4 != -1) {
                            UNSAFE.freeMemory(j4);
                        }
                        throw th;
                    }
                } else {
                    internalLoggerFactory.debug("direct buffer constructor: unavailable", (Throwable) doPrivileged4);
                    constructor = null;
                    j4 = -1;
                }
                if (j4 != -1) {
                    UNSAFE.freeMemory(j4);
                }
                DIRECT_BUFFER_CONSTRUCTOR = constructor;
                ADDRESS_FIELD_OFFSET = objectFieldOffset(field);
                BYTE_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
                Object doPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.5
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader());
                            int javaVersion = PlatformDependent0.javaVersion();
                            if (javaVersion >= 9) {
                                try {
                                    Field declaredField = cls.getDeclaredField(javaVersion >= 11 ? "UNALIGNED" : "unaligned");
                                    if (declaredField.getType() == Boolean.TYPE) {
                                        Unsafe unsafe2 = PlatformDependent0.UNSAFE;
                                        return Boolean.valueOf(unsafe2.getBoolean(unsafe2.staticFieldBase(declaredField), unsafe2.staticFieldOffset(declaredField)));
                                    }
                                } catch (NoSuchFieldException unused2) {
                                }
                            }
                            Method declaredMethod = cls.getDeclaredMethod("unaligned", new Class[0]);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredMethod, true);
                            return trySetAccessible != null ? trySetAccessible : declaredMethod.invoke(null, new Object[0]);
                        } catch (ClassNotFoundException e4) {
                            return e4;
                        } catch (IllegalAccessException e5) {
                            return e5;
                        } catch (NoSuchMethodException e6) {
                            return e6;
                        } catch (SecurityException e7) {
                            return e7;
                        } catch (InvocationTargetException e8) {
                            return e8;
                        }
                    }
                });
                if (doPrivileged5 instanceof Boolean) {
                    z3 = ((Boolean) doPrivileged5).booleanValue();
                    logger.debug("java.nio.Bits.unaligned: available, {}", Boolean.valueOf(z3));
                } else {
                    boolean matches = SystemPropertyUtil.get("os.arch", "").matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                    logger.debug("java.nio.Bits.unaligned: unavailable {}", Boolean.valueOf(matches), (Throwable) doPrivileged5);
                    z3 = matches;
                }
                UNALIGNED = z3;
                if (javaVersion() >= 9) {
                    final Object doPrivileged6 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.6
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                return PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe").getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
                            } catch (Throwable th3) {
                                return th3;
                            }
                        }
                    });
                    if (doPrivileged6 instanceof Throwable) {
                        method = null;
                    } else {
                        Object e4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.7
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                try {
                                    return doPrivileged6.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, Integer.TYPE);
                                } catch (NoSuchMethodException e5) {
                                    return e5;
                                } catch (SecurityException e6) {
                                    return e6;
                                }
                            }
                        });
                        if (e4 instanceof Method) {
                            try {
                                Method method3 = (Method) e4;
                                byte[] bArr = (byte[]) method3.invoke(doPrivileged6, Byte.TYPE, 8);
                                method2 = method3;
                            } catch (IllegalAccessException e5) {
                                e4 = e5;
                            } catch (InvocationTargetException e6) {
                                e4 = e6;
                            }
                        }
                        Object obj = e4;
                        method = doPrivileged6;
                        doPrivileged6 = obj;
                    }
                    if (doPrivileged6 instanceof Throwable) {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable", (Throwable) doPrivileged6);
                    } else {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available");
                    }
                } else {
                    logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
                    method = null;
                }
                ALLOCATE_ARRAY_METHOD = method2;
                method2 = method;
            } catch (Throwable th3) {
                th = th3;
                j4 = -1;
            }
        }
        INTERNAL_UNSAFE = method2;
        logger.debug("java.nio.DirectByteBuffer.<init>(long, int): {}", DIRECT_BUFFER_CONSTRUCTOR != null ? "available" : "unavailable");
    }

    private PlatformDependent0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addressSize() {
        return UNSAFE.addressSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer allocateDirectNoCleaner(int i4) {
        return newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, i4)), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long allocateMemory(long j4) {
        return UNSAFE.allocateMemory(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] allocateUninitializedArray(int i4) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(i4));
        } catch (IllegalAccessException e4) {
            throw new Error(e4);
        } catch (InvocationTargetException e5) {
            throw new Error(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMemory(long j4, long j5, long j6) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(j4, j5, j6);
        } else {
            UNSAFE.copyMemory(j4, j5, j6);
        }
    }

    private static void copyMemoryWithSafePointPolling(long j4, long j5, long j6) {
        while (j6 > 0) {
            long min = Math.min(j6, 1048576L);
            UNSAFE.copyMemory(j4, j5, min);
            j6 -= min;
            j4 += min;
            j5 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        int i7 = i6 & 7;
        long j4 = BYTE_ARRAY_BASE_OFFSET + i4;
        long j5 = i5 - i4;
        if (i6 >= 8) {
            long j6 = i7 + j4;
            long j7 = (j4 - 8) + i6;
            while (j7 >= j6) {
                Unsafe unsafe = UNSAFE;
                long j8 = j6;
                if (unsafe.getLong(bArr, j7) != unsafe.getLong(bArr2, j7 + j5)) {
                    return false;
                }
                j7 -= 8;
                j6 = j8;
            }
        }
        if (i7 >= 4) {
            i7 -= 4;
            long j9 = i7 + j4;
            Unsafe unsafe2 = UNSAFE;
            if (unsafe2.getInt(bArr, j9) != unsafe2.getInt(bArr2, j9 + j5)) {
                return false;
            }
        }
        long j10 = j5 + j4;
        if (i7 >= 2) {
            Unsafe unsafe3 = UNSAFE;
            if (unsafe3.getChar(bArr, j4) == unsafe3.getChar(bArr2, j10)) {
                return i7 == 2 || unsafe3.getByte(bArr, j4 + 2) == unsafe3.getByte(bArr2, j10 + 2);
            }
            return false;
        }
        if (i7 != 0) {
            Unsafe unsafe4 = UNSAFE;
            if (unsafe4.getByte(bArr, j4) != unsafe4.getByte(bArr2, j10)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int equalsConstantTime(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        long j4 = i6 & 7;
        long j5 = BYTE_ARRAY_BASE_OFFSET + i4;
        long j6 = j5 + j4;
        long j7 = i5 - i4;
        long j8 = 0;
        for (long j9 = (j5 - 8) + i6; j9 >= j6; j9 -= 8) {
            Unsafe unsafe = UNSAFE;
            j8 |= unsafe.getLong(bArr, j9) ^ unsafe.getLong(bArr2, j9 + j7);
        }
        if (j4 >= 4) {
            Unsafe unsafe2 = UNSAFE;
            j8 |= unsafe2.getInt(bArr2, j5 + j7) ^ unsafe2.getInt(bArr, j5);
            j4 -= 4;
        }
        if (j4 >= 2) {
            long j10 = j6 - j4;
            Unsafe unsafe3 = UNSAFE;
            j8 |= unsafe3.getChar(bArr2, j10 + j7) ^ unsafe3.getChar(bArr, j10);
            j4 -= 2;
        }
        if (j4 == 1) {
            long j11 = j6 - 1;
            Unsafe unsafe4 = UNSAFE;
            j8 |= unsafe4.getByte(bArr, j11) ^ unsafe4.getByte(bArr2, j11 + j7);
        }
        return ConstantTimeUtils.equalsConstantTime(j8, 0L);
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean z3 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z3));
        if (z3) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        String str = SystemPropertyUtil.contains("io.netty.tryUnsafe") ? "io.netty.tryUnsafe" : "org.jboss.netty.tryUnsafe";
        if (SystemPropertyUtil.getBoolean(str, true)) {
            return null;
        }
        String str2 = "sun.misc.Unsafe: unavailable (" + str + ")";
        internalLogger.debug(str2);
        return new UnsupportedOperationException(str2);
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", javaVersion() < 9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeMemory(long j4) {
        UNSAFE.freeMemory(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j4) {
        return UNSAFE.getByte(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(Object obj, long j4) {
        return UNSAFE.getInt(obj, j4);
    }

    private static long getLong(Object obj, long j4) {
        return UNSAFE.getLong(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getObject(Object obj, long j4) {
        return UNSAFE.getObject(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(long j4) {
        return UNSAFE.getShort(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAscii(byte[] bArr, int i4, int i5) {
        int i6;
        long j4 = BYTE_ARRAY_BASE_OFFSET + i4;
        int i7 = i5 & 7;
        long j5 = i7 + j4;
        int i8 = -1028477387;
        for (long j6 = (j4 - 8) + i5; j6 >= j5; j6 -= 8) {
            i8 = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j6), i8);
        }
        if (i7 == 0) {
            return i8;
        }
        if (((i7 != 2) && (i7 != 4)) && (i7 != 6)) {
            i8 = (i8 * HASH_CODE_C1) + hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j4));
            j4++;
            i6 = 461845907;
        } else {
            i6 = HASH_CODE_C1;
        }
        if ((i7 != 5) & (i7 != 1) & (i7 != 4)) {
            i8 = (i8 * i6) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j4));
            j4 += 2;
            i6 = i6 != HASH_CODE_C1 ? HASH_CODE_C1 : 461845907;
        }
        return i7 >= 4 ? (i8 * i6) + hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j4)) : i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiCompute(long j4, int i4) {
        return (i4 * HASH_CODE_C1) + (hashCodeAsciiSanitize((int) j4) * 461845907) + ((int) ((j4 & 2242545357458243584L) >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(byte b4) {
        return b4 & 31;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(int i4) {
        return i4 & 522133279;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(short s3) {
        return s3 & 7967;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean equals = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (equals) {
            logger.debug("Platform: Android");
        }
        return equals;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUnaligned() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isZero(byte[] bArr, int i4, int i5) {
        if (i5 <= 0) {
            return true;
        }
        long j4 = BYTE_ARRAY_BASE_OFFSET + i4;
        int i6 = i5 & 7;
        long j5 = i6 + j4;
        for (long j6 = (j4 - 8) + i5; j6 >= j5; j6 -= 8) {
            if (UNSAFE.getLong(bArr, j6) != 0) {
                return false;
            }
        }
        if (i6 >= 4) {
            i6 -= 4;
            if (UNSAFE.getInt(bArr, i6 + j4) != 0) {
                return false;
            }
        }
        return i6 >= 2 ? UNSAFE.getChar(bArr, j4) == 0 && (i6 == 2 || bArr[i4 + 2] == 0) : bArr[i4] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersionFromJavaSpecificationVersion = isAndroid0() ? 6 : majorVersionFromJavaSpecificationVersion();
        logger.debug("Java version: {}", Integer.valueOf(majorVersionFromJavaSpecificationVersion));
        return majorVersionFromJavaSpecificationVersion;
    }

    static int majorVersion(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i4 = 0; i4 < split.length; i4++) {
            iArr[i4] = Integer.parseInt(split[i4]);
        }
        if (iArr[0] == 1) {
            return iArr[1];
        }
        return iArr[0];
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer newDirectBuffer(long j4, int i4) {
        ObjectUtil.checkPositiveOrZero(i4, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j4), Integer.valueOf(i4));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(long j4, byte b4) {
        UNSAFE.putByte(j4, b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(long j4, int i4) {
        UNSAFE.putInt(j4, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(long j4, long j5) {
        UNSAFE.putLong(j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putObject(Object obj, long j4, Object obj2) {
        UNSAFE.putObject(obj, j4, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(long j4, short s3) {
        UNSAFE.putShort(j4, s3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i4) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i4), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long reallocateMemory(long j4, long j5) {
        return UNSAFE.reallocateMemory(j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMemory(long j4, long j5, byte b4) {
        UNSAFE.setMemory(j4, j5, b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean unalignedAccess() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i4) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(long j4) {
        return UNSAFE.getInt(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j4) {
        return UNSAFE.getLong(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i4) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(byte[] bArr, int i4, byte b4) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + i4, b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(byte[] bArr, int i4, int i5) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(byte[] bArr, int i4, long j4) {
        UNSAFE.putLong(bArr, i4 + BYTE_ARRAY_BASE_OFFSET, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(byte[] bArr, int i4, short s3) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + i4, s3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMemory(Object obj, long j4, long j5, byte b4) {
        UNSAFE.setMemory(obj, j4, j5, b4);
    }

    private static void copyMemoryWithSafePointPolling(Object obj, long j4, Object obj2, long j5, long j6) {
        long j7 = j4;
        long j8 = j5;
        long j9 = j6;
        while (j9 > 0) {
            long min = Math.min(j9, 1048576L);
            UNSAFE.copyMemory(obj, j7, obj2, j8, min);
            j9 -= min;
            j7 += min;
            j8 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i4) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i4) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMemory(Object obj, long j4, Object obj2, long j5, long j6) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(obj, j4, obj2, j5, j6);
        } else {
            UNSAFE.copyMemory(obj, j4, obj2, j5, j6);
        }
    }
}

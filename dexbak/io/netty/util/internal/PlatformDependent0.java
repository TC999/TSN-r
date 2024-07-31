package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PlatformDependent0 {
    private static final long ADDRESS_FIELD_OFFSET;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = 461845907;
    static final int HASH_CODE_C2 = 461845907;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final InternalLogger logger;

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent0.<clinit>():void");
    }

    private PlatformDependent0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addressSize() {
        return UNSAFE.addressSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer allocateDirectNoCleaner(int i) {
        return newDirectBuffer(UNSAFE.allocateMemory(i), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long allocateMemory(long j) {
        return UNSAFE.allocateMemory(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMemory(long j, long j2, long j3) {
        while (j3 > 0) {
            long min = Math.min(j3, 1048576L);
            UNSAFE.copyMemory(j, j2, min);
            j3 -= min;
            j += min;
            j2 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        long j = BYTE_ARRAY_BASE_OFFSET;
        long j2 = i + j;
        long j3 = j + i2;
        int i4 = i3 & 7;
        long j4 = i4 + j2;
        long j5 = i3;
        long j6 = (j2 - 8) + j5;
        long j7 = (j3 - 8) + j5;
        while (j6 >= j4) {
            Unsafe unsafe = UNSAFE;
            if (unsafe.getLong(bArr, j6) != unsafe.getLong(bArr2, j7)) {
                return false;
            }
            j6 -= 8;
            j7 -= 8;
        }
        switch (i4) {
            case 1:
                Unsafe unsafe2 = UNSAFE;
                return unsafe2.getByte(bArr, j2) == unsafe2.getByte(bArr2, j3);
            case 2:
                Unsafe unsafe3 = UNSAFE;
                return unsafe3.getChar(bArr, j2) == unsafe3.getChar(bArr2, j3);
            case 3:
                Unsafe unsafe4 = UNSAFE;
                return unsafe4.getChar(bArr, j2 + 1) == unsafe4.getChar(bArr2, 1 + j3) && unsafe4.getByte(bArr, j2) == unsafe4.getByte(bArr2, j3);
            case 4:
                Unsafe unsafe5 = UNSAFE;
                return unsafe5.getInt(bArr, j2) == unsafe5.getInt(bArr2, j3);
            case 5:
                Unsafe unsafe6 = UNSAFE;
                return unsafe6.getInt(bArr, j2 + 1) == unsafe6.getInt(bArr2, 1 + j3) && unsafe6.getByte(bArr, j2) == unsafe6.getByte(bArr2, j3);
            case 6:
                Unsafe unsafe7 = UNSAFE;
                return unsafe7.getInt(bArr, j2 + 2) == unsafe7.getInt(bArr2, 2 + j3) && unsafe7.getChar(bArr, j2) == unsafe7.getChar(bArr2, j3);
            case 7:
                Unsafe unsafe8 = UNSAFE;
                return unsafe8.getInt(bArr, j2 + 3) == unsafe8.getInt(bArr2, 3 + j3) && unsafe8.getChar(bArr, j2 + 1) == unsafe8.getChar(bArr2, 1 + j3) && unsafe8.getByte(bArr, j2) == unsafe8.getByte(bArr2, j3);
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        long j;
        Unsafe unsafe;
        long j2 = BYTE_ARRAY_BASE_OFFSET;
        long j3 = i + j2;
        int i4 = i3 & 7;
        long j4 = i4 + j3;
        long j5 = i3;
        long j6 = (j3 - 8) + j5;
        long j7 = ((j2 + i2) - 8) + j5;
        long j8 = 0;
        while (j6 >= j4) {
            Unsafe unsafe2 = UNSAFE;
            j8 |= unsafe2.getLong(bArr, j6) ^ unsafe2.getLong(bArr2, j7);
            j6 -= 8;
            j7 -= 8;
        }
        switch (i4) {
            case 1:
                Unsafe unsafe3 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe3.getByte(bArr, j3) ^ unsafe3.getByte(bArr2, j)) | j8, 0L);
            case 2:
                Unsafe unsafe4 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe4.getChar(bArr, j3) ^ unsafe4.getChar(bArr2, j)) | j8, 0L);
            case 3:
                Unsafe unsafe5 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe5.getByte(bArr, j3) ^ unsafe5.getByte(bArr2, j)) | (unsafe5.getChar(bArr, j3 + 1) ^ unsafe5.getChar(bArr2, 1 + j)) | j8, 0L);
            case 4:
                Unsafe unsafe6 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe6.getInt(bArr, j3) ^ unsafe6.getInt(bArr2, j)) | j8, 0L);
            case 5:
                Unsafe unsafe7 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe7.getByte(bArr, j3) ^ unsafe7.getByte(bArr2, j)) | (unsafe7.getInt(bArr, j3 + 1) ^ unsafe7.getInt(bArr2, 1 + j)) | j8, 0L);
            case 6:
                int i5 = UNSAFE.getInt(bArr, j3 + 2);
                return ConstantTimeUtils.equalsConstantTime((unsafe.getChar(bArr, j3) ^ unsafe.getChar(bArr2, j)) | (unsafe.getInt(bArr2, 2 + j) ^ i5) | j8, 0L);
            case 7:
                Unsafe unsafe8 = UNSAFE;
                return ConstantTimeUtils.equalsConstantTime((unsafe8.getByte(bArr, j3) ^ unsafe8.getByte(bArr2, j)) | (unsafe8.getChar(bArr, j3 + 1) ^ unsafe8.getChar(bArr2, 1 + j)) | j8 | (unsafe8.getInt(bArr, j3 + 3) ^ unsafe8.getInt(bArr2, 3 + j)), 0L);
            default:
                return ConstantTimeUtils.equalsConstantTime(j8, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        Cleaner0.freeDirectBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeMemory(long j) {
        UNSAFE.freeMemory(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.6
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
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    private static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getObjectVolatile(Object obj, long j) {
        return UNSAFE.getObjectVolatile(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(long j) {
        return UNSAFE.getShort(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
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
    public static int hashCodeAscii(byte[] bArr, int i, int i2) {
        int i3;
        int hashCodeAsciiSanitize;
        long j = BYTE_ARRAY_BASE_OFFSET + i;
        int i4 = i2 & 7;
        long j2 = i4 + j;
        int i5 = HASH_CODE_ASCII_SEED;
        for (long j3 = (j - 8) + i2; j3 >= j2; j3 -= 8) {
            i5 = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j3), i5);
        }
        switch (i4) {
            case 1:
                i3 = i5 * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
                break;
            case 2:
                i3 = i5 * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j));
                break;
            case 3:
                Unsafe unsafe = UNSAFE;
                i3 = ((i5 * 461845907) + hashCodeAsciiSanitize(unsafe.getByte(bArr, j))) * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe.getShort(bArr, j + 1));
                break;
            case 4:
                i3 = i5 * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j));
                break;
            case 5:
                Unsafe unsafe2 = UNSAFE;
                i3 = ((i5 * 461845907) + hashCodeAsciiSanitize(unsafe2.getByte(bArr, j))) * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe2.getInt(bArr, j + 1));
                break;
            case 6:
                Unsafe unsafe3 = UNSAFE;
                i3 = ((i5 * 461845907) + hashCodeAsciiSanitize(unsafe3.getShort(bArr, j))) * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe3.getInt(bArr, j + 2));
                break;
            case 7:
                Unsafe unsafe4 = UNSAFE;
                i3 = ((((i5 * 461845907) + hashCodeAsciiSanitize(unsafe4.getByte(bArr, j))) * 461845907) + hashCodeAsciiSanitize(unsafe4.getShort(bArr, 1 + j))) * 461845907;
                hashCodeAsciiSanitize = hashCodeAsciiSanitize(unsafe4.getInt(bArr, j + 3));
                break;
            default:
                return i5;
        }
        return i3 + hashCodeAsciiSanitize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiCompute(long j, int i) {
        return (i * 461845907) + (hashCodeAsciiSanitize((int) j) * 461845907) + ((int) ((j & 2242545357458243584L) >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(byte b) {
        return b & 31;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(int i) {
        return i & 522133279;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(short s) {
        return s & 7967;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUnaligned() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> AtomicIntegerFieldUpdater<T> newAtomicIntegerFieldUpdater(Class<? super T> cls, String str) throws Exception {
        return new UnsafeAtomicIntegerFieldUpdater(UNSAFE, cls, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> AtomicLongFieldUpdater<T> newAtomicLongFieldUpdater(Class<? super T> cls, String str) throws Exception {
        return new UnsafeAtomicLongFieldUpdater(UNSAFE, cls, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <U, W> AtomicReferenceFieldUpdater<U, W> newAtomicReferenceFieldUpdater(Class<? super U> cls, String str) throws Exception {
        return new UnsafeAtomicReferenceFieldUpdater(UNSAFE, cls, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer newDirectBuffer(long j, int i) {
        ObjectUtil.checkPositiveOrZero(j, "address");
        ObjectUtil.checkPositiveOrZero(i, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j), Integer.valueOf(i));
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
    public static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(long j, int i) {
        UNSAFE.putInt(j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putOrderedObject(Object obj, long j, Object obj2) {
        UNSAFE.putOrderedObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(long j, short s) {
        UNSAFE.putShort(j, s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMemory(long j, long j2, byte b) {
        UNSAFE.setMemory(j, j2, b);
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
    public static byte getByte(byte[] bArr, int i) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(byte[] bArr, int i, byte b) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + i, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(byte[] bArr, int i, int i2) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(byte[] bArr, int i, long j) {
        UNSAFE.putLong(bArr, i + BYTE_ARRAY_BASE_OFFSET, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(byte[] bArr, int i, short s) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + i, s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMemory(Object obj, long j, long j2, byte b) {
        UNSAFE.setMemory(obj, j, j2, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        while (j6 > 0) {
            long min = Math.min(j6, 1048576L);
            UNSAFE.copyMemory(obj, j4, obj2, j5, min);
            j6 -= min;
            j4 += min;
            j5 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }
}

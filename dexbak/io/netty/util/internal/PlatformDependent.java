package io.netty.util.internal;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.util.internal.chmv8.ConcurrentHashMapV8;
import io.netty.util.internal.chmv8.LongAdderV8;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.SpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Deque;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PlatformDependent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    public static final boolean BIG_ENDIAN_NATIVE_ORDER;
    private static final int BIT_MODE;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    private static final boolean CAN_USE_CHM_V8;
    private static final int DEFAULT_MAX_MPSC_CAPACITY = 1048576;
    private static final boolean DIRECT_BUFFER_PREFERRED;
    private static final AtomicLong DIRECT_MEMORY_COUNTER;
    private static final long DIRECT_MEMORY_LIMIT;
    private static final boolean HAS_JAVASSIST;
    private static final boolean HAS_UNSAFE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_NO_UNSAFE;
    private static volatile Boolean IS_ROOT = null;
    private static final boolean IS_WINDOWS;
    private static final int JAVA_VERSION;
    private static final int MAX_ALLOWED_MPSC_CAPACITY = 1073741824;
    private static final long MAX_DIRECT_MEMORY;
    private static final Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN;
    private static final int MIN_MAX_MPSC_CAPACITY = 2048;
    private static final int MPSC_CHUNK_SIZE = 1024;
    private static final File TMPDIR;
    private static final boolean USE_DIRECT_BUFFER_NO_CLEANER;
    private static final InternalLogger logger;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class AtomicLongCounter extends AtomicLong implements LongCounter {
        private static final long serialVersionUID = 4074772784610639305L;

        private AtomicLongCounter() {
        }

        @Override // io.netty.util.internal.LongCounter
        public void add(long j) {
            addAndGet(j);
        }

        @Override // io.netty.util.internal.LongCounter
        public void decrement() {
            decrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public void increment() {
            incrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public long value() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class Mpsc {
        private static final boolean USE_MPSC_CHUNKED_ARRAY_QUEUE;

        static {
            if ((PlatformDependent.hasUnsafe() ? AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent.Mpsc.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return UnsafeAccess.UNSAFE;
                }
            }) : null) == null) {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                USE_MPSC_CHUNKED_ARRAY_QUEUE = false;
                return;
            }
            PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: available");
            USE_MPSC_CHUNKED_ARRAY_QUEUE = true;
        }

        private Mpsc() {
        }

        static <T> Queue<T> newMpscQueue(int i) {
            if (USE_MPSC_CHUNKED_ARRAY_QUEUE) {
                return new MpscChunkedArrayQueue(1024, Math.max(Math.min(i, 1073741824), 2048), true);
            }
            return new MpscLinkedAtomicQueue();
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(PlatformDependent.class);
        logger = internalLoggerFactory;
        MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
        IS_ANDROID = isAndroid0();
        IS_WINDOWS = isWindows0();
        int javaVersion0 = javaVersion0();
        JAVA_VERSION = javaVersion0;
        CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = !isAndroid();
        boolean explicitNoUnsafe0 = explicitNoUnsafe0();
        IS_EXPLICIT_NO_UNSAFE = explicitNoUnsafe0;
        boolean hasUnsafe0 = hasUnsafe0();
        HAS_UNSAFE = hasUnsafe0;
        CAN_USE_CHM_V8 = hasUnsafe0 && javaVersion0 < 8;
        boolean z = hasUnsafe0 && !SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false);
        DIRECT_BUFFER_PREFERRED = z;
        MAX_DIRECT_MEMORY = maxDirectMemory0();
        BYTE_ARRAY_BASE_OFFSET = PlatformDependent0.byteArrayBaseOffset();
        HAS_JAVASSIST = hasJavassist0();
        TMPDIR = tmpdir0();
        BIT_MODE = bitMode0();
        ADDRESS_SIZE = addressSize0();
        BIG_ENDIAN_NATIVE_ORDER = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(!z));
        }
        if (!hasUnsafe() && !isAndroid() && !explicitNoUnsafe0) {
            internalLoggerFactory.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system unstability.");
        }
        long j = SystemPropertyUtil.getLong("io.netty.maxDirectMemory", -1L);
        if (j != 0 && hasUnsafe() && PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            USE_DIRECT_BUFFER_NO_CLEANER = true;
            if (j < 0) {
                j = maxDirectMemory0();
                if (j <= 0) {
                    DIRECT_MEMORY_COUNTER = null;
                } else {
                    DIRECT_MEMORY_COUNTER = new AtomicLong();
                }
            } else {
                DIRECT_MEMORY_COUNTER = new AtomicLong();
            }
        } else {
            USE_DIRECT_BUFFER_NO_CLEANER = false;
            DIRECT_MEMORY_COUNTER = null;
        }
        DIRECT_MEMORY_LIMIT = j;
        internalLoggerFactory.debug("io.netty.maxDirectMemory: {} bytes", Long.valueOf(j));
    }

    private PlatformDependent() {
    }

    public static int addressSize() {
        return ADDRESS_SIZE;
    }

    private static int addressSize0() {
        if (hasUnsafe()) {
            return PlatformDependent0.addressSize();
        }
        return -1;
    }

    public static ByteBuffer allocateDirectNoCleaner(int i) {
        incrementMemoryCounter(i);
        try {
            return PlatformDependent0.allocateDirectNoCleaner(i);
        } catch (Throwable th) {
            decrementMemoryCounter(i);
            throwException(th);
            return null;
        }
    }

    public static long allocateMemory(long j) {
        return PlatformDependent0.allocateMemory(j);
    }

    public static int bitMode() {
        return BIT_MODE;
    }

    private static int bitMode0() {
        int i = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
        if (i > 0) {
            logger.debug("-Dio.netty.bitMode: {}", Integer.valueOf(i));
            return i;
        }
        int i2 = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
        if (i2 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", Integer.valueOf(i2));
            return i2;
        }
        int i3 = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
        if (i3 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", Integer.valueOf(i3));
            return i3;
        }
        String str = SystemPropertyUtil.get("os.arch", "");
        Locale locale = Locale.US;
        String trim = str.toLowerCase(locale).trim();
        if ("amd64".equals(trim) || "x86_64".equals(trim)) {
            i3 = 64;
        } else if ("i386".equals(trim) || "i486".equals(trim) || "i586".equals(trim) || "i686".equals(trim)) {
            i3 = 32;
        }
        if (i3 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(i3), trim);
        }
        Matcher matcher = Pattern.compile("([1-9][0-9]+)-?bit").matcher(SystemPropertyUtil.get("java.vm.name", "").toLowerCase(locale));
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 64;
    }

    public static boolean canEnableTcpNoDelayByDefault() {
        return CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    }

    public static void copyMemory(long j, long j2, long j3) {
        PlatformDependent0.copyMemory(j, j2, j3);
    }

    private static void decrementMemoryCounter(int i) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            atomicLong.addAndGet(-i);
        }
    }

    public static ByteBuffer directBuffer(long j, int i) {
        if (PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            return PlatformDependent0.newDirectBuffer(j, i);
        }
        throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent0.directBufferAddress(byteBuffer);
    }

    public static boolean directBufferPreferred() {
        return DIRECT_BUFFER_PREFERRED;
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.equals(bArr, i, bArr2, i2, i3) : equalsSafe(bArr, i, bArr2, i2, i3);
    }

    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.equalsConstantTime(bArr, i, bArr2, i2, i3) : ConstantTimeUtils.equalsConstantTime(bArr, i, bArr2, i2, i3);
    }

    private static boolean equalsSafe(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    private static boolean explicitNoUnsafe0() {
        boolean z;
        boolean z2 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z2));
        if (z2) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return true;
        }
        if (SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            z = SystemPropertyUtil.getBoolean("io.netty.tryUnsafe", true);
        } else {
            z = SystemPropertyUtil.getBoolean("org.jboss.netty.tryUnsafe", true);
        }
        if (z) {
            return false;
        }
        internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.tryUnsafe/org.jboss.netty.tryUnsafe)");
        return true;
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (!hasUnsafe() || isAndroid()) {
            return;
        }
        PlatformDependent0.freeDirectBuffer(byteBuffer);
    }

    public static void freeDirectNoCleaner(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        PlatformDependent0.freeMemory(PlatformDependent0.directBufferAddress(byteBuffer));
        decrementMemoryCounter(capacity);
    }

    public static void freeMemory(long j) {
        PlatformDependent0.freeMemory(j);
    }

    public static byte getByte(long j) {
        return PlatformDependent0.getByte(j);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return PlatformDependent0.getClassLoader(cls);
    }

    public static ClassLoader getContextClassLoader() {
        return PlatformDependent0.getContextClassLoader();
    }

    public static int getInt(Object obj, long j) {
        return PlatformDependent0.getInt(obj, j);
    }

    private static int getIntSafe(byte[] bArr, int i) {
        int i2;
        int i3;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i2 = (bArr[i] << BinaryMemcacheOpcodes.FLUSHQ) | ((bArr[i + 1] & UByte.f41242c) << 16) | ((bArr[i + 2] & UByte.f41242c) << 8);
            i3 = bArr[i + 3] & UByte.f41242c;
        } else {
            i2 = (bArr[i] & UByte.f41242c) | ((bArr[i + 1] & UByte.f41242c) << 8) | ((bArr[i + 2] & UByte.f41242c) << 16);
            i3 = bArr[i + 3] << BinaryMemcacheOpcodes.FLUSHQ;
        }
        return i3 | i2;
    }

    public static long getLong(long j) {
        return PlatformDependent0.getLong(j);
    }

    private static long getLongSafe(byte[] bArr, int i) {
        if (BIG_ENDIAN_NATIVE_ORDER) {
            return (bArr[i + 7] & 255) | (bArr[i] << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        }
        long j = ((bArr[i + 4] & 255) << 32) | ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 5] & 255) << 40);
        return ((bArr[i + 7] & 255) << 56) | ((bArr[i + 6] & 255) << 48) | j;
    }

    public static Object getObject(Object obj, long j) {
        return PlatformDependent0.getObject(obj, j);
    }

    public static Object getObjectVolatile(Object obj, long j) {
        return PlatformDependent0.getObjectVolatile(obj, j);
    }

    public static short getShort(long j) {
        return PlatformDependent0.getShort(j);
    }

    private static short getShortSafe(byte[] bArr, int i) {
        int i2;
        int i3;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i2 = bArr[i] << 8;
            i3 = bArr[i + 1] & UByte.f41242c;
        } else {
            i2 = bArr[i] & UByte.f41242c;
            i3 = bArr[i + 1] << 8;
        }
        return (short) (i3 | i2);
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static boolean hasJavassist() {
        return HAS_JAVASSIST;
    }

    private static boolean hasJavassist0() {
        if (isAndroid()) {
            return false;
        }
        boolean z = SystemPropertyUtil.getBoolean("io.netty.noJavassist", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noJavassist: {}", Boolean.valueOf(z));
        if (z) {
            internalLogger.debug("Javassist: unavailable (io.netty.noJavassist)");
            return false;
        }
        try {
            JavassistTypeParameterMatcherGenerator.generate(Object.class, getClassLoader(PlatformDependent.class));
            internalLogger.debug("Javassist: available");
            return true;
        } catch (Throwable unused) {
            InternalLogger internalLogger2 = logger;
            internalLogger2.debug("Javassist: unavailable");
            internalLogger2.debug("You don't have Javassist in your class path or you don't have enough permission to load dynamically generated classes.  Please check the configuration for better performance.");
            return false;
        }
    }

    public static boolean hasUnsafe() {
        return HAS_UNSAFE;
    }

    private static boolean hasUnsafe0() {
        if (isAndroid()) {
            logger.debug("sun.misc.Unsafe: unavailable (Android)");
            return false;
        } else if (IS_EXPLICIT_NO_UNSAFE) {
            return false;
        } else {
            try {
                boolean hasUnsafe = PlatformDependent0.hasUnsafe();
                logger.debug("sun.misc.Unsafe: {}", hasUnsafe ? "available" : "unavailable");
                return hasUnsafe;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static int hashCodeAscii(byte[] bArr, int i, int i2) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.hashCodeAscii(bArr, i, i2) : hashCodeAsciiSafe(bArr, i, i2);
    }

    private static int hashCodeAsciiCompute(CharSequence charSequence, int i, int i2) {
        return (i2 * 461845907) + (hashCodeAsciiSanitizeInt(charSequence, i) * 461845907) + hashCodeAsciiSanitizeInt(charSequence, i + 4);
    }

    static int hashCodeAsciiSafe(byte[] bArr, int i, int i2) {
        int i3;
        int hashCodeAsciiSanitize;
        int i4 = i2 & 7;
        int i5 = i + i4;
        int i6 = -1028477387;
        for (int i7 = (i - 8) + i2; i7 >= i5; i7 -= 8) {
            i6 = PlatformDependent0.hashCodeAsciiCompute(getLongSafe(bArr, i7), i6);
        }
        switch (i4) {
            case 1:
                i3 = i6 * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(bArr[i]);
                break;
            case 2:
                i3 = i6 * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i));
                break;
            case 3:
                i3 = ((i6 * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i])) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i + 1));
                break;
            case 4:
                i3 = i6 * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i));
                break;
            case 5:
                i3 = ((i6 * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i])) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 1));
                break;
            case 6:
                i3 = ((i6 * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i))) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 2));
                break;
            case 7:
                i3 = ((((i6 * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i])) * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i + 1))) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 3));
                break;
            default:
                return i6;
        }
        return i3 + hashCodeAsciiSanitize;
    }

    private static int hashCodeAsciiSanitizeInt(CharSequence charSequence, int i) {
        int charAt;
        int charAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            charAt = (charSequence.charAt(i) & 31) | ((charSequence.charAt(i + 2) & 31) << 8) | ((charSequence.charAt(i + 1) & 31) << 16);
            charAt2 = (charSequence.charAt(i) & 31) << 24;
        } else {
            charAt = ((charSequence.charAt(i + 3) & 31) << 24) | ((charSequence.charAt(i + 2) & 31) << 16) | ((charSequence.charAt(i + 1) & 31) << 8);
            charAt2 = charSequence.charAt(i) & 31;
        }
        return charAt2 | charAt;
    }

    private static int hashCodeAsciiSanitizeShort(CharSequence charSequence, int i) {
        int charAt;
        int charAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            charAt = charSequence.charAt(i + 1) & 31;
            charAt2 = (charSequence.charAt(i) & 31) << 8;
        } else {
            charAt = (charSequence.charAt(i + 1) & 31) << 8;
            charAt2 = charSequence.charAt(i) & 31;
        }
        return charAt2 | charAt;
    }

    private static int hashCodeAsciiSanitizsByte(char c) {
        return c & 31;
    }

    private static void incrementMemoryCounter(int i) {
        AtomicLong atomicLong;
        long j;
        long j2;
        if (DIRECT_MEMORY_COUNTER != null) {
            do {
                atomicLong = DIRECT_MEMORY_COUNTER;
                j = atomicLong.get();
                j2 = i + j;
                long j3 = DIRECT_MEMORY_LIMIT;
                if (j2 > j3) {
                    throw new OutOfDirectMemoryError("failed to allocate " + i + " byte(s) of direct memory (used: " + j + ", max: " + j3 + ')');
                }
            } while (!atomicLong.compareAndSet(j, j2));
        }
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean z = false;
        try {
            Class.forName("android.app.Application", false, getSystemClassLoader());
            z = true;
        } catch (Throwable unused) {
        }
        if (z) {
            logger.debug("Platform: Android");
        }
        return z;
    }

    public static boolean isRoot() {
        if (IS_ROOT == null) {
            synchronized (PlatformDependent.class) {
                if (IS_ROOT == null) {
                    IS_ROOT = Boolean.valueOf(isRoot0());
                }
            }
        }
        return IS_ROOT.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (r8 == null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRoot0() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.isRoot0():boolean");
    }

    public static boolean isUnaligned() {
        return PlatformDependent0.isUnaligned();
    }

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    private static boolean isWindows0() {
        boolean contains = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).contains("win");
        if (contains) {
            logger.debug("Platform: Windows");
        }
        return contains;
    }

    public static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersionFromJavaSpecificationVersion = isAndroid() ? 6 : majorVersionFromJavaSpecificationVersion();
        logger.debug("Java version: {}", Integer.valueOf(majorVersionFromJavaSpecificationVersion));
        return majorVersionFromJavaSpecificationVersion;
    }

    static int majorVersion(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        if (iArr[0] == 1) {
            return iArr[1];
        }
        return iArr[0];
    }

    static int majorVersionFromJavaSpecificationVersion() {
        try {
            return majorVersion((String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.PlatformDependent.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty("java.specification.version");
                }
            }));
        } catch (SecurityException e) {
            logger.debug("security exception while reading java.specification.version", (Throwable) e);
            return 6;
        }
    }

    public static long maxDirectMemory() {
        return MAX_DIRECT_MEMORY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
        r5 = java.lang.Long.parseLong(r8.group(1));
        r0 = r8.group(2).charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
        if (r0 == 'G') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008f, code lost:
        if (r0 == 'K') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
        if (r0 == 'M') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
        if (r0 == 'g') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (r0 == 'k') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
        if (r0 == 'm') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
        r3 = 1048576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        r3 = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
        r3 = tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_STEREO_RIGHT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
        r5 = r5 * r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long maxDirectMemory0() {
        /*
            r0 = 0
            r1 = 0
            r3 = 1
            r4 = 0
            java.lang.String r5 = "sun.misc.VM"
            java.lang.ClassLoader r6 = getSystemClassLoader()     // Catch: java.lang.Throwable -> L24
            java.lang.Class r5 = java.lang.Class.forName(r5, r3, r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = "maxDirectMemory"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L24
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch: java.lang.Throwable -> L24
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L24
            java.lang.Object r5 = r5.invoke(r0, r6)     // Catch: java.lang.Throwable -> L24
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L24
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L24
            goto L25
        L24:
            r5 = r1
        L25:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L2a
            return r5
        L2a:
            java.lang.String r7 = "java.lang.management.ManagementFactory"
            java.lang.ClassLoader r8 = getSystemClassLoader()     // Catch: java.lang.Throwable -> Laf
            java.lang.Class r7 = java.lang.Class.forName(r7, r3, r8)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r8 = "java.lang.management.RuntimeMXBean"
            java.lang.ClassLoader r9 = getSystemClassLoader()     // Catch: java.lang.Throwable -> Laf
            java.lang.Class r8 = java.lang.Class.forName(r8, r3, r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r9 = "getRuntimeMXBean"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Laf
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r9, r10)     // Catch: java.lang.Throwable -> Laf
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r0 = r7.invoke(r0, r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r7 = "getInputArguments"
            java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Laf
            java.lang.reflect.Method r7 = r8.getDeclaredMethod(r7, r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r0 = r7.invoke(r0, r8)     // Catch: java.lang.Throwable -> Laf
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> Laf
            int r7 = r0.size()     // Catch: java.lang.Throwable -> Laf
            int r7 = r7 - r3
        L61:
            if (r7 < 0) goto Lb0
            java.util.regex.Pattern r8 = io.netty.util.internal.PlatformDependent.MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r9 = r0.get(r7)     // Catch: java.lang.Throwable -> Laf
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch: java.lang.Throwable -> Laf
            java.util.regex.Matcher r8 = r8.matcher(r9)     // Catch: java.lang.Throwable -> Laf
            boolean r9 = r8.matches()     // Catch: java.lang.Throwable -> Laf
            if (r9 != 0) goto L78
            int r7 = r7 + (-1)
            goto L61
        L78:
            java.lang.String r0 = r8.group(r3)     // Catch: java.lang.Throwable -> Laf
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Laf
            r0 = 2
            java.lang.String r0 = r8.group(r0)     // Catch: java.lang.Throwable -> Laf
            char r0 = r0.charAt(r4)     // Catch: java.lang.Throwable -> Laf
            r3 = 71
            if (r0 == r3) goto La9
            r3 = 75
            if (r0 == r3) goto La6
            r3 = 77
            if (r0 == r3) goto La2
            r3 = 103(0x67, float:1.44E-43)
            if (r0 == r3) goto La9
            r3 = 107(0x6b, float:1.5E-43)
            if (r0 == r3) goto La6
            r3 = 109(0x6d, float:1.53E-43)
            if (r0 == r3) goto La2
            goto Lb0
        La2:
            r3 = 1048576(0x100000, double:5.180654E-318)
            goto Lac
        La6:
            r3 = 1024(0x400, double:5.06E-321)
            goto Lac
        La9:
            r3 = 1073741824(0x40000000, double:5.304989477E-315)
        Lac:
            long r5 = r5 * r3
            goto Lb0
        Laf:
        Lb0:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 > 0) goto Lc8
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            long r5 = r0.maxMemory()
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.PlatformDependent.logger
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "maxDirectMemory: {} bytes (maybe)"
            r0.debug(r2, r1)
            goto Ld3
        Lc8:
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.PlatformDependent.logger
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "maxDirectMemory: {} bytes"
            r0.debug(r2, r1)
        Ld3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.maxDirectMemory0():long");
    }

    public static <T> AtomicIntegerFieldUpdater<T> newAtomicIntegerFieldUpdater(Class<? super T> cls, String str) {
        if (hasUnsafe()) {
            try {
                return PlatformDependent0.newAtomicIntegerFieldUpdater(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static <T> AtomicLongFieldUpdater<T> newAtomicLongFieldUpdater(Class<? super T> cls, String str) {
        if (hasUnsafe()) {
            try {
                return PlatformDependent0.newAtomicLongFieldUpdater(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static <U, W> AtomicReferenceFieldUpdater<U, W> newAtomicReferenceFieldUpdater(Class<? super U> cls, String str) {
        if (hasUnsafe()) {
            try {
                return PlatformDependent0.newAtomicReferenceFieldUpdater(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static <C> Deque<C> newConcurrentDeque() {
        if (javaVersion() < 7) {
            return new LinkedBlockingDeque();
        }
        return new ConcurrentLinkedDeque();
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8();
        }
        return new ConcurrentHashMap();
    }

    public static <T> Queue<T> newFixedMpscQueue(int i) {
        return hasUnsafe() ? new MpscArrayQueue(i) : new MpscAtomicArrayQueue(i);
    }

    public static LongCounter newLongCounter() {
        if (HAS_UNSAFE) {
            return new LongAdderV8();
        }
        return new AtomicLongCounter();
    }

    public static <T> Queue<T> newMpscQueue() {
        return newMpscQueue(1048576);
    }

    public static <T> Queue<T> newSpscQueue() {
        return hasUnsafe() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue();
    }

    public static long objectFieldOffset(Field field) {
        return PlatformDependent0.objectFieldOffset(field);
    }

    public static void putByte(long j, byte b) {
        PlatformDependent0.putByte(j, b);
    }

    public static void putInt(long j, int i) {
        PlatformDependent0.putInt(j, i);
    }

    public static void putLong(long j, long j2) {
        PlatformDependent0.putLong(j, j2);
    }

    public static void putOrderedObject(Object obj, long j, Object obj2) {
        PlatformDependent0.putOrderedObject(obj, j, obj2);
    }

    public static void putShort(long j, short s) {
        PlatformDependent0.putShort(j, s);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i) {
        int capacity = i - byteBuffer.capacity();
        incrementMemoryCounter(capacity);
        try {
            return PlatformDependent0.reallocateDirectNoCleaner(byteBuffer, i);
        } catch (Throwable th) {
            decrementMemoryCounter(capacity);
            throwException(th);
            return null;
        }
    }

    public static void setMemory(byte[] bArr, int i, long j, byte b) {
        PlatformDependent0.setMemory(bArr, BYTE_ARRAY_BASE_OFFSET + i, j, b);
    }

    public static void throwException(Throwable th) {
        if (hasUnsafe()) {
            PlatformDependent0.throwException(th);
        } else {
            throwException0(th);
        }
    }

    private static <E extends Throwable> void throwException0(Throwable th) throws Throwable {
        throw th;
    }

    public static File tmpdir() {
        return TMPDIR;
    }

    private static File tmpdir0() {
        File file;
        File directory;
        try {
            directory = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
        } catch (Throwable unused) {
        }
        if (directory != null) {
            logger.debug("-Dio.netty.tmpdir: {}", directory);
            return directory;
        }
        File directory2 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
        if (directory2 != null) {
            logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", directory2);
            return directory2;
        }
        if (isWindows()) {
            File directory3 = toDirectory(System.getenv("TEMP"));
            if (directory3 != null) {
                logger.debug("-Dio.netty.tmpdir: {} (%TEMP%)", directory3);
                return directory3;
            }
            String str = System.getenv("USERPROFILE");
            if (str != null) {
                File directory4 = toDirectory(str + "\\AppData\\Local\\Temp");
                if (directory4 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", directory4);
                    return directory4;
                }
                File directory5 = toDirectory(str + "\\Local Settings\\Temp");
                if (directory5 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", directory5);
                    return directory5;
                }
            }
        } else {
            File directory6 = toDirectory(System.getenv("TMPDIR"));
            if (directory6 != null) {
                logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", directory6);
                return directory6;
            }
        }
        if (isWindows()) {
            file = new File("C:\\Windows\\Temp");
        } else {
            file = new File("/tmp");
        }
        logger.warn("Failed to get the temporary directory; falling back to: {}", file);
        return file;
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (file.isDirectory()) {
            try {
                return file.getAbsoluteFile();
            } catch (Exception unused) {
                return file;
            }
        }
        return null;
    }

    public static boolean useDirectBufferNoCleaner() {
        return USE_DIRECT_BUFFER_NO_CLEANER;
    }

    public static void copyMemory(byte[] bArr, int i, long j, long j2) {
        PlatformDependent0.copyMemory(bArr, BYTE_ARRAY_BASE_OFFSET + i, null, j, j2);
    }

    public static byte getByte(byte[] bArr, int i) {
        return PlatformDependent0.getByte(bArr, i);
    }

    public static int getInt(long j) {
        return PlatformDependent0.getInt(j);
    }

    public static long getLong(byte[] bArr, int i) {
        return PlatformDependent0.getLong(bArr, i);
    }

    public static short getShort(byte[] bArr, int i) {
        return PlatformDependent0.getShort(bArr, i);
    }

    public static int hashCodeAscii(CharSequence charSequence) {
        int i;
        int hashCodeAsciiSanitizsByte;
        int length = charSequence.length() & 7;
        int i2 = -1028477387;
        switch (charSequence.length()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = hashCodeAsciiCompute(charSequence, charSequence.length() - 8, -1028477387);
                break;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = hashCodeAsciiCompute(charSequence, charSequence.length() - 16, hashCodeAsciiCompute(charSequence, charSequence.length() - 8, -1028477387));
                break;
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                i2 = hashCodeAsciiCompute(charSequence, charSequence.length() - 24, hashCodeAsciiCompute(charSequence, charSequence.length() - 16, hashCodeAsciiCompute(charSequence, charSequence.length() - 8, -1028477387)));
                break;
            default:
                for (int length2 = charSequence.length() - 8; length2 >= length; length2 -= 8) {
                    i2 = hashCodeAsciiCompute(charSequence, length2, i2);
                }
                break;
        }
        switch (length) {
            case 1:
                i = i2 * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizsByte(charSequence.charAt(0));
                break;
            case 2:
                i = i2 * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizeShort(charSequence, 0);
                break;
            case 3:
                i = ((i2 * 461845907) + hashCodeAsciiSanitizsByte(charSequence.charAt(0))) * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizeShort(charSequence, 1);
                break;
            case 4:
                i = i2 * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizeInt(charSequence, 0);
                break;
            case 5:
                i = ((i2 * 461845907) + hashCodeAsciiSanitizsByte(charSequence.charAt(0))) * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizeInt(charSequence, 1);
                break;
            case 6:
                i = ((i2 * 461845907) + hashCodeAsciiSanitizeShort(charSequence, 0)) * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizeInt(charSequence, 2);
                break;
            case 7:
                i = ((((i2 * 461845907) + hashCodeAsciiSanitizsByte(charSequence.charAt(0))) * 461845907) + hashCodeAsciiSanitizeShort(charSequence, 1)) * 461845907;
                hashCodeAsciiSanitizsByte = hashCodeAsciiSanitizeInt(charSequence, 3);
                break;
            default:
                return i2;
        }
        return i + hashCodeAsciiSanitizsByte;
    }

    public static <T> Queue<T> newMpscQueue(int i) {
        return Mpsc.newMpscQueue(i);
    }

    public static void putByte(byte[] bArr, int i, byte b) {
        PlatformDependent0.putByte(bArr, i, b);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        PlatformDependent0.putInt(bArr, i, i2);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        PlatformDependent0.putLong(bArr, i, j);
    }

    public static void putShort(byte[] bArr, int i, short s) {
        PlatformDependent0.putShort(bArr, i, s);
    }

    public static void setMemory(long j, long j2, byte b) {
        PlatformDependent0.setMemory(j, j2, b);
    }

    public static void copyMemory(long j, byte[] bArr, int i, long j2) {
        PlatformDependent0.copyMemory(null, j, bArr, BYTE_ARRAY_BASE_OFFSET + i, j2);
    }

    public static int getInt(byte[] bArr, int i) {
        return PlatformDependent0.getInt(bArr, i);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(i);
        }
        return new ConcurrentHashMap(i);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i, float f) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(i, f);
        }
        return new ConcurrentHashMap(i, f);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i, float f, int i2) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(i, f, i2);
        }
        return new ConcurrentHashMap(i, f, i2);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(Map<? extends K, ? extends V> map) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(map);
        }
        return new ConcurrentHashMap(map);
    }
}

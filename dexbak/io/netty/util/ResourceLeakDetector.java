package io.netty.util;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ResourceLeakDetector<T> {
    private static final Level DEFAULT_LEVEL;
    private static final int DEFAULT_MAX_RECORDS = 4;
    static final int DEFAULT_SAMPLING_INTERVAL = 128;
    private static final int MAX_RECORDS;
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_MAX_RECORDS = "io.netty.leakDetection.maxRecords";
    private static final String[] STACK_TRACE_ELEMENT_EXCLUSIONS;
    private static Level level;
    private static final InternalLogger logger;
    private long active;
    private final ResourceLeakDetector<T>.DefaultResourceLeak head;
    private long leakCheckCnt;
    private final AtomicBoolean loggedTooManyActive;
    private final int mask;
    private final long maxActive;
    private final ReferenceQueue<Object> refQueue;
    private final ConcurrentMap<String, Boolean> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;
    private final ResourceLeakDetector<T>.DefaultResourceLeak tail;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class DefaultResourceLeak extends PhantomReference<Object> implements ResourceLeak {
        private final String creationRecord;
        private final AtomicBoolean freed;
        private final Deque<String> lastRecords;
        private ResourceLeakDetector<T>.DefaultResourceLeak next;
        private ResourceLeakDetector<T>.DefaultResourceLeak prev;
        private int removedRecords;

        DefaultResourceLeak(Object obj) {
            super(obj, obj != null ? ResourceLeakDetector.this.refQueue : null);
            this.lastRecords = new ArrayDeque();
            if (obj != null) {
                if (ResourceLeakDetector.getLevel().ordinal() >= Level.ADVANCED.ordinal()) {
                    this.creationRecord = ResourceLeakDetector.newRecord(null, 3);
                } else {
                    this.creationRecord = null;
                }
                synchronized (ResourceLeakDetector.this.head) {
                    this.prev = ResourceLeakDetector.this.head;
                    this.next = ResourceLeakDetector.this.head.next;
                    ResourceLeakDetector.this.head.next.prev = this;
                    ResourceLeakDetector.this.head.next = this;
                    ResourceLeakDetector.access$408(ResourceLeakDetector.this);
                }
                this.freed = new AtomicBoolean();
                return;
            }
            this.creationRecord = null;
            this.freed = new AtomicBoolean(true);
        }

        private void record0(Object obj, int i) {
            if (this.creationRecord != null) {
                String newRecord = ResourceLeakDetector.newRecord(obj, i);
                synchronized (this.lastRecords) {
                    int size = this.lastRecords.size();
                    if (size == 0 || !this.lastRecords.getLast().equals(newRecord)) {
                        this.lastRecords.add(newRecord);
                    }
                    if (size > ResourceLeakDetector.MAX_RECORDS) {
                        this.lastRecords.removeFirst();
                        this.removedRecords++;
                    }
                }
            }
        }

        @Override // io.netty.util.ResourceLeak
        public boolean close() {
            if (this.freed.compareAndSet(false, true)) {
                synchronized (ResourceLeakDetector.this.head) {
                    ResourceLeakDetector.access$410(ResourceLeakDetector.this);
                    ResourceLeakDetector<T>.DefaultResourceLeak defaultResourceLeak = this.prev;
                    defaultResourceLeak.next = this.next;
                    this.next.prev = defaultResourceLeak;
                    this.prev = null;
                    this.next = null;
                }
                return true;
            }
            return false;
        }

        @Override // io.netty.util.ResourceLeak
        public void record() {
            record0(null, 3);
        }

        public String toString() {
            Object[] array;
            int i;
            if (this.creationRecord == null) {
                return "";
            }
            synchronized (this.lastRecords) {
                array = this.lastRecords.toArray();
                i = this.removedRecords;
            }
            StringBuilder sb = new StringBuilder(16384);
            String str = StringUtil.NEWLINE;
            sb.append(str);
            if (i > 0) {
                sb.append("WARNING: ");
                sb.append(i);
                sb.append(" leak records were discarded because the leak record count is limited to ");
                sb.append(ResourceLeakDetector.MAX_RECORDS);
                sb.append(". Use system property ");
                sb.append(ResourceLeakDetector.PROP_MAX_RECORDS);
                sb.append(" to increase the limit.");
                sb.append(str);
            }
            sb.append("Recent access records: ");
            sb.append(array.length);
            sb.append(str);
            if (array.length > 0) {
                for (int length = array.length - 1; length >= 0; length--) {
                    sb.append('#');
                    sb.append(length + 1);
                    sb.append(':');
                    sb.append(StringUtil.NEWLINE);
                    sb.append(array[length]);
                }
            }
            sb.append("Created at:");
            String str2 = StringUtil.NEWLINE;
            sb.append(str2);
            sb.append(this.creationRecord);
            sb.setLength(sb.length() - str2.length());
            return sb.toString();
        }

        @Override // io.netty.util.ResourceLeak
        public void record(Object obj) {
            record0(obj, 3);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID
    }

    static {
        boolean z;
        Level level2 = Level.SIMPLE;
        DEFAULT_LEVEL = level2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ResourceLeakDetector.class);
        logger = internalLoggerFactory;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLoggerFactory.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z));
            internalLoggerFactory.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", PROP_LEVEL, level2.name().toLowerCase());
        } else {
            z = false;
        }
        String upperCase = SystemPropertyUtil.get(PROP_LEVEL, SystemPropertyUtil.get(PROP_LEVEL_OLD, (z ? Level.DISABLED : level2).name()).trim().toUpperCase()).trim().toUpperCase();
        Iterator it = EnumSet.allOf(Level.class).iterator();
        while (it.hasNext()) {
            Level level3 = (Level) it.next();
            if (upperCase.equals(level3.name()) || upperCase.equals(String.valueOf(level3.ordinal()))) {
                level2 = level3;
            }
        }
        int i = SystemPropertyUtil.getInt(PROP_MAX_RECORDS, 4);
        MAX_RECORDS = i;
        level = level2;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-D{}: {}", PROP_LEVEL, level2.name().toLowerCase());
            internalLogger.debug("-D{}: {}", PROP_MAX_RECORDS, Integer.valueOf(i));
        }
        STACK_TRACE_ELEMENT_EXCLUSIONS = new String[]{"io.netty.util.ReferenceCountUtil.touch(", "io.netty.buffer.AdvancedLeakAwareByteBuf.touch(", "io.netty.buffer.AbstractByteBufAllocator.toLeakAwareBuffer(", "io.netty.buffer.AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation("};
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls) {
        this(StringUtil.simpleClassName(cls));
    }

    static /* synthetic */ long access$408(ResourceLeakDetector resourceLeakDetector) {
        long j = resourceLeakDetector.active;
        resourceLeakDetector.active = 1 + j;
        return j;
    }

    static /* synthetic */ long access$410(ResourceLeakDetector resourceLeakDetector) {
        long j = resourceLeakDetector.active;
        resourceLeakDetector.active = j - 1;
        return j;
    }

    public static Level getLevel() {
        return level;
    }

    public static boolean isEnabled() {
        return getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    static String newRecord(Object obj, int i) {
        StackTraceElement[] stackTrace;
        boolean z;
        StringBuilder sb = new StringBuilder(4096);
        if (obj != null) {
            sb.append("\tHint: ");
            if (obj instanceof ResourceLeakHint) {
                sb.append(((ResourceLeakHint) obj).toHintString());
            } else {
                sb.append(obj);
            }
            sb.append(StringUtil.NEWLINE);
        }
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (i > 0) {
                i--;
            } else {
                String stackTraceElement2 = stackTraceElement.toString();
                String[] strArr = STACK_TRACE_ELEMENT_EXCLUSIONS;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if (stackTraceElement2.startsWith(strArr[i2])) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    sb.append('\t');
                    sb.append(stackTraceElement2);
                    sb.append(StringUtil.NEWLINE);
                }
            }
        }
        return sb.toString();
    }

    private void reportLeak(Level level2) {
        if (logger.isErrorEnabled()) {
            if (this.active * (level2 == Level.PARANOID ? 1 : this.samplingInterval) > this.maxActive && this.loggedTooManyActive.compareAndSet(false, true)) {
                reportInstancesLeak(this.resourceType);
            }
            while (true) {
                DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
                if (defaultResourceLeak == null) {
                    return;
                }
                defaultResourceLeak.clear();
                if (defaultResourceLeak.close()) {
                    String defaultResourceLeak2 = defaultResourceLeak.toString();
                    if (this.reportedLeaks.putIfAbsent(defaultResourceLeak2, Boolean.TRUE) == null) {
                        if (defaultResourceLeak2.isEmpty()) {
                            reportUntracedLeak(this.resourceType);
                        } else {
                            reportTracedLeak(this.resourceType, defaultResourceLeak2);
                        }
                    }
                }
            }
        } else {
            while (true) {
                DefaultResourceLeak defaultResourceLeak3 = (DefaultResourceLeak) this.refQueue.poll();
                if (defaultResourceLeak3 == null) {
                    return;
                }
                defaultResourceLeak3.close();
            }
        }
    }

    @Deprecated
    public static void setEnabled(boolean z) {
        setLevel(z ? Level.SIMPLE : Level.DISABLED);
    }

    public static void setLevel(Level level2) {
        if (level2 != null) {
            level = level2;
            return;
        }
        throw new NullPointerException("level");
    }

    public final ResourceLeak open(T t) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() < Level.PARANOID.ordinal()) {
            long j = this.leakCheckCnt;
            this.leakCheckCnt = 1 + j;
            if ((j & this.mask) == 0) {
                reportLeak(level2);
                return new DefaultResourceLeak(t);
            }
            return null;
        }
        reportLeak(level2);
        return new DefaultResourceLeak(t);
    }

    protected void reportInstancesLeak(String str) {
        InternalLogger internalLogger = logger;
        internalLogger.error("LEAK: You are creating too many " + str + " instances.  " + str + " is a shared resource that must be reused across the JVM,so that only a few instances are created.");
    }

    protected void reportTracedLeak(String str, String str2) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See http://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    protected void reportUntracedLeak(String str) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See http://netty.io/wiki/reference-counted-objects.html for more information.", str, PROP_LEVEL, Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    @Deprecated
    public ResourceLeakDetector(String str) {
        this(str, 128, Long.MAX_VALUE);
    }

    public ResourceLeakDetector(Class<?> cls, int i, long j) {
        this(StringUtil.simpleClassName(cls), i, j);
    }

    @Deprecated
    public ResourceLeakDetector(String str, int i, long j) {
        ResourceLeakDetector<T>.DefaultResourceLeak defaultResourceLeak = new DefaultResourceLeak(null);
        this.head = defaultResourceLeak;
        ResourceLeakDetector<T>.DefaultResourceLeak defaultResourceLeak2 = new DefaultResourceLeak(null);
        this.tail = defaultResourceLeak2;
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = PlatformDependent.newConcurrentHashMap();
        this.loggedTooManyActive = new AtomicBoolean();
        if (str == null) {
            throw new NullPointerException("resourceType");
        }
        if (j > 0) {
            this.resourceType = str;
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i);
            this.samplingInterval = safeFindNextPositivePowerOfTwo;
            this.mask = safeFindNextPositivePowerOfTwo - 1;
            this.maxActive = j;
            ((DefaultResourceLeak) defaultResourceLeak).next = defaultResourceLeak2;
            ((DefaultResourceLeak) defaultResourceLeak2).prev = defaultResourceLeak;
            return;
        }
        throw new IllegalArgumentException("maxActive: " + j + " (expected: 1+)");
    }
}

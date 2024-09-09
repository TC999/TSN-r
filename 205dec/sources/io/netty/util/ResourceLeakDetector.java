package io.netty.util;

import io.netty.channel.a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ResourceLeakDetector<T> {
    private static final Level DEFAULT_LEVEL;
    private static final int DEFAULT_SAMPLING_INTERVAL = 128;
    private static final int DEFAULT_TARGET_RECORDS = 4;
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_SAMPLING_INTERVAL = "io.netty.leakDetection.samplingInterval";
    private static final String PROP_TARGET_RECORDS = "io.netty.leakDetection.targetRecords";
    static final int SAMPLING_INTERVAL;
    private static final int TARGET_RECORDS;
    private static final AtomicReference<String[]> excludedMethods;
    private static Level level;
    private static final InternalLogger logger;
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private final ReferenceQueue<Object> refQueue;
    private final ConcurrentMap<String, Boolean> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T>, ResourceLeak {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Set<DefaultResourceLeak<?>> allLeaks;
        private volatile int droppedRecords;
        private volatile Record head;
        private final int trackedHash;
        private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, Record> headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, Record.class, "head");
        private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");

        DefaultResourceLeak(Object obj, ReferenceQueue<Object> referenceQueue, Set<DefaultResourceLeak<?>> set) {
            super(obj, referenceQueue);
            this.trackedHash = System.identityHashCode(obj);
            set.add(this);
            headUpdater.set(this, new Record(Record.BOTTOM));
            this.allLeaks = set;
        }

        private static void reachabilityFence0(Object obj) {
            if (obj != null) {
                synchronized (obj) {
                }
            }
        }

        private void record0(Object obj) {
            AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, Record> atomicReferenceFieldUpdater;
            Record record;
            boolean z3;
            Record record2;
            if (ResourceLeakDetector.TARGET_RECORDS > 0) {
                do {
                    atomicReferenceFieldUpdater = headUpdater;
                    record = atomicReferenceFieldUpdater.get(this);
                    if (record == null) {
                        return;
                    }
                    int i4 = record.pos + 1;
                    z3 = false;
                    if (i4 >= ResourceLeakDetector.TARGET_RECORDS) {
                        boolean z4 = PlatformDependent.threadLocalRandom().nextInt(1 << Math.min(i4 - ResourceLeakDetector.TARGET_RECORDS, 30)) != 0;
                        record2 = z4 ? record.next : record;
                        z3 = z4;
                    } else {
                        record2 = record;
                    }
                } while (!a.a(atomicReferenceFieldUpdater, this, record, obj != null ? new Record(record2, obj) : new Record(record2)));
                if (z3) {
                    droppedRecordsUpdater.incrementAndGet(this);
                }
            }
        }

        @Override // io.netty.util.ResourceLeak
        public boolean close() {
            if (this.allLeaks.remove(this)) {
                clear();
                headUpdater.set(this, null);
                return true;
            }
            return false;
        }

        boolean dispose() {
            clear();
            return this.allLeaks.remove(this);
        }

        @Override // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record() {
            record0(null);
        }

        public String toString() {
            Record andSet = headUpdater.getAndSet(this, null);
            if (andSet == null) {
                return "";
            }
            int i4 = droppedRecordsUpdater.get(this);
            int i5 = 0;
            int i6 = 1;
            int i7 = andSet.pos + 1;
            StringBuilder sb = new StringBuilder(i7 * 2048);
            String str = StringUtil.NEWLINE;
            sb.append(str);
            sb.append("Recent access records: ");
            sb.append(str);
            HashSet hashSet = new HashSet(i7);
            while (andSet != Record.BOTTOM) {
                String record = andSet.toString();
                if (!hashSet.add(record)) {
                    i5++;
                } else if (andSet.next == Record.BOTTOM) {
                    sb.append("Created at:");
                    sb.append(StringUtil.NEWLINE);
                    sb.append(record);
                } else {
                    sb.append('#');
                    sb.append(i6);
                    sb.append(':');
                    sb.append(StringUtil.NEWLINE);
                    sb.append(record);
                    i6++;
                }
                andSet = andSet.next;
            }
            if (i5 > 0) {
                sb.append(": ");
                sb.append(i5);
                sb.append(" leak records were discarded because they were duplicates");
                sb.append(StringUtil.NEWLINE);
            }
            if (i4 > 0) {
                sb.append(": ");
                sb.append(i4);
                sb.append(" leak records were discarded because the leak record count is targeted to ");
                sb.append(ResourceLeakDetector.TARGET_RECORDS);
                sb.append(". Use system property ");
                sb.append(ResourceLeakDetector.PROP_TARGET_RECORDS);
                sb.append(" to increase the limit.");
                sb.append(StringUtil.NEWLINE);
            }
            sb.setLength(sb.length() - StringUtil.NEWLINE.length());
            return sb.toString();
        }

        @Override // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record(Object obj) {
            record0(obj);
        }

        @Override // io.netty.util.ResourceLeakTracker
        public boolean close(T t3) {
            try {
                return close();
            } finally {
                reachabilityFence0(t3);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        static Level parseLevel(String str) {
            Level[] values;
            String trim = str.trim();
            for (Level level : values()) {
                if (trim.equalsIgnoreCase(level.name()) || trim.equals(String.valueOf(level.ordinal()))) {
                    return level;
                }
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    static {
        Level level2 = Level.SIMPLE;
        DEFAULT_LEVEL = level2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ResourceLeakDetector.class);
        logger = internalLoggerFactory;
        boolean z3 = false;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z3 = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLoggerFactory.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z3));
            internalLoggerFactory.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", "io.netty.leakDetection.level", level2.name().toLowerCase());
        }
        if (z3) {
            level2 = Level.DISABLED;
        }
        Level parseLevel = Level.parseLevel(SystemPropertyUtil.get("io.netty.leakDetection.level", SystemPropertyUtil.get("io.netty.leakDetectionLevel", level2.name())));
        int i4 = SystemPropertyUtil.getInt(PROP_TARGET_RECORDS, 4);
        TARGET_RECORDS = i4;
        SAMPLING_INTERVAL = SystemPropertyUtil.getInt(PROP_SAMPLING_INTERVAL, 128);
        level = parseLevel;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.level", parseLevel.name().toLowerCase());
            internalLoggerFactory.debug("-D{}: {}", PROP_TARGET_RECORDS, Integer.valueOf(i4));
        }
        excludedMethods = new AtomicReference<>(EmptyArrays.EMPTY_STRINGS);
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls) {
        this(StringUtil.simpleClassName(cls));
    }

    public static void addExclusions(Class cls, String... strArr) {
        String[] strArr2;
        String[] strArr3;
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        for (int i4 = 0; i4 < length && (!hashSet.remove(declaredMethods[i4].getName()) || !hashSet.isEmpty()); i4++) {
        }
        if (hashSet.isEmpty()) {
            do {
                strArr2 = excludedMethods.get();
                strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length + (strArr.length * 2));
                for (int i5 = 0; i5 < strArr.length; i5++) {
                    int i6 = i5 * 2;
                    strArr3[strArr2.length + i6] = cls.getName();
                    strArr3[strArr2.length + i6 + 1] = strArr[i5];
                }
            } while (!excludedMethods.compareAndSet(strArr2, strArr3));
            return;
        }
        throw new IllegalArgumentException("Can't find '" + hashSet + "' in " + cls.getName());
    }

    private void clearRefQueue() {
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            defaultResourceLeak.dispose();
        }
    }

    public static Level getLevel() {
        return level;
    }

    public static boolean isEnabled() {
        return getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    private void reportLeak() {
        if (!logger.isErrorEnabled()) {
            clearRefQueue();
            return;
        }
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            if (defaultResourceLeak.dispose()) {
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
    }

    @Deprecated
    public static void setEnabled(boolean z3) {
        setLevel(z3 ? Level.SIMPLE : Level.DISABLED);
    }

    public static void setLevel(Level level2) {
        if (level2 != null) {
            level = level2;
            return;
        }
        throw new NullPointerException("level");
    }

    private DefaultResourceLeak track0(T t3) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() < Level.PARANOID.ordinal()) {
            if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) == 0) {
                reportLeak();
                return new DefaultResourceLeak(t3, this.refQueue, this.allLeaks);
            }
            return null;
        }
        reportLeak();
        return new DefaultResourceLeak(t3, this.refQueue, this.allLeaks);
    }

    @Deprecated
    public final ResourceLeak open(T t3) {
        return track0(t3);
    }

    @Deprecated
    protected void reportInstancesLeak(String str) {
    }

    protected void reportTracedLeak(String str, String str2) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    protected void reportUntracedLeak(String str) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", str, "io.netty.leakDetection.level", Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    public final ResourceLeakTracker<T> track(T t3) {
        return track0(t3);
    }

    @Deprecated
    public ResourceLeakDetector(String str) {
        this(str, 128, Long.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls, int i4, long j4) {
        this(cls, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Record extends Throwable {
        private static final Record BOTTOM = new Record();
        private static final long serialVersionUID = 6065153674892850720L;
        private final String hintString;
        private final Record next;
        private final int pos;

        Record(Record record, Object obj) {
            this.hintString = obj instanceof ResourceLeakHint ? ((ResourceLeakHint) obj).toHintString() : obj.toString();
            this.next = record;
            this.pos = record.pos + 1;
        }

        @Override // java.lang.Throwable
        public String toString() {
            int i4;
            StringBuilder sb = new StringBuilder(2048);
            if (this.hintString != null) {
                sb.append("\tHint: ");
                sb.append(this.hintString);
                sb.append(StringUtil.NEWLINE);
            }
            StackTraceElement[] stackTrace = getStackTrace();
            for (int i5 = 3; i5 < stackTrace.length; i5++) {
                StackTraceElement stackTraceElement = stackTrace[i5];
                String[] strArr = (String[]) ResourceLeakDetector.excludedMethods.get();
                while (true) {
                    if (i4 < strArr.length) {
                        i4 = (strArr[i4].equals(stackTraceElement.getClassName()) && strArr[i4 + 1].equals(stackTraceElement.getMethodName())) ? 0 : i4 + 2;
                    } else {
                        sb.append('\t');
                        sb.append(stackTraceElement.toString());
                        sb.append(StringUtil.NEWLINE);
                        break;
                    }
                }
            }
            return sb.toString();
        }

        Record(Record record) {
            this.hintString = null;
            this.next = record;
            this.pos = record.pos + 1;
        }

        private Record() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }
    }

    public ResourceLeakDetector(Class<?> cls, int i4) {
        this(StringUtil.simpleClassName(cls), i4, Long.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(String str, int i4, long j4) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = PlatformDependent.newConcurrentHashMap();
        if (str != null) {
            this.resourceType = str;
            this.samplingInterval = i4;
            return;
        }
        throw new NullPointerException("resourceType");
    }
}

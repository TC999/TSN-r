package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class Recycler<T> {
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 32768;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED;
    private static final AtomicInteger ID_GENERATOR;
    private static final int INITIAL_CAPACITY;
    private static final int LINK_CAPACITY;
    private static final int MAX_DELAYED_QUEUES_PER_THREAD;
    private static final int MAX_SHARED_CAPACITY_FACTOR;
    private static final Handle NOOP_HANDLE;
    private static final int OWN_THREAD_ID;
    private static final int RATIO;
    private static final InternalLogger logger;
    private final int maxCapacityPerThread;
    private final int maxDelayedQueuesPerThread;
    private final int maxSharedCapacityFactor;
    private final int ratioMask;
    private final FastThreadLocal<Stack<T>> threadLocal;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class DefaultHandle<T> implements Handle<T> {
        boolean hasBeenRecycled;
        private int lastRecycledId;
        private int recycleId;
        private Stack<?> stack;
        private Object value;

        DefaultHandle(Stack<?> stack) {
            this.stack = stack;
        }

        @Override // io.netty.util.Recycler.Handle
        public void recycle(Object obj) {
            if (obj == this.value) {
                this.stack.push(this);
                return;
            }
            throw new IllegalArgumentException("object does not belong to handle");
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface Handle<T> {
        void recycle(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Stack<T> {
        final AtomicInteger availableSharedCapacity;
        private WeakOrderQueue cursor;
        private DefaultHandle<?>[] elements;
        private int handleRecycleCount = -1;
        private volatile WeakOrderQueue head;
        private final int maxCapacity;
        final int maxDelayedQueues;
        final Recycler<T> parent;
        private WeakOrderQueue prev;
        private final int ratioMask;
        private int size;
        final Thread thread;

        Stack(Recycler<T> recycler, Thread thread, int i, int i2, int i3, int i4) {
            this.parent = recycler;
            this.thread = thread;
            this.maxCapacity = i;
            this.availableSharedCapacity = new AtomicInteger(Math.max(i / i2, Recycler.LINK_CAPACITY));
            this.elements = new DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, i)];
            this.ratioMask = i3;
            this.maxDelayedQueues = i4;
        }

        private void pushLater(DefaultHandle<?> defaultHandle, Thread thread) {
            Map map = (Map) Recycler.DELAYED_RECYCLED.get();
            WeakOrderQueue weakOrderQueue = (WeakOrderQueue) map.get(this);
            if (weakOrderQueue == null) {
                if (map.size() >= this.maxDelayedQueues) {
                    map.put(this, WeakOrderQueue.DUMMY);
                    return;
                }
                weakOrderQueue = WeakOrderQueue.allocate(this, thread);
                if (weakOrderQueue == null) {
                    return;
                }
                map.put(this, weakOrderQueue);
            } else if (weakOrderQueue == WeakOrderQueue.DUMMY) {
                return;
            }
            weakOrderQueue.add(defaultHandle);
        }

        private void pushNow(DefaultHandle<?> defaultHandle) {
            if ((((DefaultHandle) defaultHandle).recycleId | ((DefaultHandle) defaultHandle).lastRecycledId) == 0) {
                ((DefaultHandle) defaultHandle).recycleId = ((DefaultHandle) defaultHandle).lastRecycledId = Recycler.OWN_THREAD_ID;
                int i = this.size;
                if (i >= this.maxCapacity || dropHandle(defaultHandle)) {
                    return;
                }
                DefaultHandle<?>[] defaultHandleArr = this.elements;
                if (i == defaultHandleArr.length) {
                    this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, Math.min(i << 1, this.maxCapacity));
                }
                this.elements[i] = defaultHandle;
                this.size = i + 1;
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        boolean dropHandle(DefaultHandle<?> defaultHandle) {
            if (defaultHandle.hasBeenRecycled) {
                return false;
            }
            int i = this.handleRecycleCount + 1;
            this.handleRecycleCount = i;
            if ((i & this.ratioMask) != 0) {
                return true;
            }
            defaultHandle.hasBeenRecycled = true;
            return false;
        }

        int increaseCapacity(int i) {
            int length = this.elements.length;
            int i2 = this.maxCapacity;
            do {
                length <<= 1;
                if (length >= i) {
                    break;
                }
            } while (length < i2);
            int min = Math.min(length, i2);
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            if (min != defaultHandleArr.length) {
                this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, min);
            }
            return min;
        }

        DefaultHandle<T> newHandle() {
            return new DefaultHandle<>(this);
        }

        DefaultHandle<T> pop() {
            int i = this.size;
            if (i == 0) {
                if (!scavenge()) {
                    return null;
                }
                i = this.size;
            }
            int i2 = i - 1;
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            DefaultHandle<T> defaultHandle = (DefaultHandle<T>) defaultHandleArr[i2];
            defaultHandleArr[i2] = null;
            if (((DefaultHandle) defaultHandle).lastRecycledId == ((DefaultHandle) defaultHandle).recycleId) {
                ((DefaultHandle) defaultHandle).recycleId = 0;
                ((DefaultHandle) defaultHandle).lastRecycledId = 0;
                this.size = i2;
                return defaultHandle;
            }
            throw new IllegalStateException("recycled multiple times");
        }

        void push(DefaultHandle<?> defaultHandle) {
            Thread currentThread = Thread.currentThread();
            if (this.thread == currentThread) {
                pushNow(defaultHandle);
            } else {
                pushLater(defaultHandle, currentThread);
            }
        }

        boolean scavenge() {
            if (scavengeSome()) {
                return true;
            }
            this.prev = null;
            this.cursor = this.head;
            return false;
        }

        boolean scavengeSome() {
            boolean z;
            WeakOrderQueue weakOrderQueue;
            WeakOrderQueue weakOrderQueue2 = this.cursor;
            boolean z2 = false;
            if (weakOrderQueue2 == null && (weakOrderQueue2 = this.head) == null) {
                return false;
            }
            WeakOrderQueue weakOrderQueue3 = this.prev;
            while (true) {
                z = true;
                if (weakOrderQueue2.transfer(this)) {
                    break;
                }
                weakOrderQueue = weakOrderQueue2.next;
                if (weakOrderQueue2.owner.get() == null) {
                    if (weakOrderQueue2.hasFinalData()) {
                        while (weakOrderQueue2.transfer(this)) {
                            z2 = true;
                        }
                    }
                    if (weakOrderQueue3 != null) {
                        weakOrderQueue3.next = weakOrderQueue;
                    }
                } else {
                    weakOrderQueue3 = weakOrderQueue2;
                }
                if (weakOrderQueue == null || z2) {
                    break;
                }
                weakOrderQueue2 = weakOrderQueue;
            }
            z = z2;
            weakOrderQueue2 = weakOrderQueue;
            this.prev = weakOrderQueue3;
            this.cursor = weakOrderQueue2;
            return z;
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(Recycler.class);
        logger = internalLoggerFactory;
        NOOP_HANDLE = new Handle() { // from class: io.netty.util.Recycler.1
            @Override // io.netty.util.Recycler.Handle
            public void recycle(Object obj) {
            }
        };
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        ID_GENERATOR = atomicInteger;
        OWN_THREAD_ID = atomicInteger.getAndIncrement();
        int i = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 32768));
        int i2 = i >= 0 ? i : 32768;
        DEFAULT_MAX_CAPACITY_PER_THREAD = i2;
        int max = Math.max(2, SystemPropertyUtil.getInt("io.netty.recycler.maxSharedCapacityFactor", 2));
        MAX_SHARED_CAPACITY_FACTOR = max;
        MAX_DELAYED_QUEUES_PER_THREAD = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.maxDelayedQueuesPerThread", Runtime.getRuntime().availableProcessors() * 2));
        int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(Math.max(SystemPropertyUtil.getInt("io.netty.recycler.linkCapacity", 16), 16));
        LINK_CAPACITY = safeFindNextPositivePowerOfTwo;
        int safeFindNextPositivePowerOfTwo2 = MathUtil.safeFindNextPositivePowerOfTwo(SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = safeFindNextPositivePowerOfTwo2;
        if (internalLoggerFactory.isDebugEnabled()) {
            if (i2 == 0) {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: disabled");
            } else {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i2));
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(max));
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo));
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo2));
            }
        }
        INITIAL_CAPACITY = Math.min(i2, 256);
        DELAYED_RECYCLED = new FastThreadLocal<Map<Stack<?>, WeakOrderQueue>>() { // from class: io.netty.util.Recycler.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Map<Stack<?>, WeakOrderQueue> initialValue() {
                return new WeakHashMap();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        Stack<T> stack = this.threadLocal.get();
        DefaultHandle<T> pop = stack.pop();
        if (pop == null) {
            pop = stack.newHandle();
            ((DefaultHandle) pop).value = newObject(pop);
        }
        return (T) ((DefaultHandle) pop).value;
    }

    protected abstract T newObject(Handle<T> handle);

    @Deprecated
    public final boolean recycle(T t, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        DefaultHandle defaultHandle = (DefaultHandle) handle;
        if (defaultHandle.stack.parent != this) {
            return false;
        }
        defaultHandle.recycle(t);
        return true;
    }

    final int threadLocalCapacity() {
        return ((Stack) this.threadLocal.get()).elements.length;
    }

    final int threadLocalSize() {
        return ((Stack) this.threadLocal.get()).size;
    }

    protected Recycler(int i) {
        this(i, MAX_SHARED_CAPACITY_FACTOR);
    }

    protected Recycler(int i, int i2) {
        this(i, i2, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class WeakOrderQueue {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final WeakOrderQueue DUMMY = new WeakOrderQueue();
        private final AtomicInteger availableSharedCapacity;
        private Link head;

        /* renamed from: id */
        private final int f40293id;
        private WeakOrderQueue next;
        private final WeakReference<Thread> owner;
        private Link tail;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static final class Link extends AtomicInteger {
            private final DefaultHandle<?>[] elements;
            private Link next;
            private int readIndex;

            private Link() {
                this.elements = new DefaultHandle[Recycler.LINK_CAPACITY];
            }
        }

        private WeakOrderQueue() {
            this.f40293id = Recycler.ID_GENERATOR.getAndIncrement();
            this.owner = null;
            this.availableSharedCapacity = null;
        }

        static WeakOrderQueue allocate(Stack<?> stack, Thread thread) {
            if (reserveSpace(stack.availableSharedCapacity, Recycler.LINK_CAPACITY)) {
                return new WeakOrderQueue(stack, thread);
            }
            return null;
        }

        private void reclaimSpace(int i) {
            this.availableSharedCapacity.addAndGet(i);
        }

        private static boolean reserveSpace(AtomicInteger atomicInteger, int i) {
            int i2;
            do {
                i2 = atomicInteger.get();
                if (i2 < i) {
                    return false;
                }
            } while (!atomicInteger.compareAndSet(i2, i2 - i));
            return true;
        }

        void add(DefaultHandle<?> defaultHandle) {
            ((DefaultHandle) defaultHandle).lastRecycledId = this.f40293id;
            Link link = this.tail;
            int i = link.get();
            if (i == Recycler.LINK_CAPACITY) {
                if (!reserveSpace(this.availableSharedCapacity, Recycler.LINK_CAPACITY)) {
                    return;
                }
                link = link.next = new Link();
                this.tail = link;
                i = link.get();
            }
            link.elements[i] = defaultHandle;
            ((DefaultHandle) defaultHandle).stack = null;
            link.lazySet(i + 1);
        }

        protected void finalize() throws Throwable {
            try {
                super.finalize();
            } finally {
                for (Link link = this.head; link != null; link = link.next) {
                    reclaimSpace(Recycler.LINK_CAPACITY);
                }
            }
        }

        boolean hasFinalData() {
            return this.tail.readIndex != this.tail.get();
        }

        boolean transfer(Stack<?> stack) {
            Link link = this.head;
            if (link == null) {
                return false;
            }
            if (link.readIndex == Recycler.LINK_CAPACITY) {
                if (link.next == null) {
                    return false;
                }
                link = link.next;
                this.head = link;
            }
            int i = link.readIndex;
            int i2 = link.get();
            int i3 = i2 - i;
            if (i3 == 0) {
                return false;
            }
            int i4 = ((Stack) stack).size;
            int i5 = i3 + i4;
            if (i5 > ((Stack) stack).elements.length) {
                i2 = Math.min((stack.increaseCapacity(i5) + i) - i4, i2);
            }
            if (i != i2) {
                DefaultHandle<?>[] defaultHandleArr = link.elements;
                DefaultHandle[] defaultHandleArr2 = ((Stack) stack).elements;
                while (i < i2) {
                    DefaultHandle<?> defaultHandle = defaultHandleArr[i];
                    if (((DefaultHandle) defaultHandle).recycleId == 0) {
                        ((DefaultHandle) defaultHandle).recycleId = ((DefaultHandle) defaultHandle).lastRecycledId;
                    } else if (((DefaultHandle) defaultHandle).recycleId != ((DefaultHandle) defaultHandle).lastRecycledId) {
                        throw new IllegalStateException("recycled already");
                    }
                    defaultHandleArr[i] = null;
                    if (!stack.dropHandle(defaultHandle)) {
                        ((DefaultHandle) defaultHandle).stack = stack;
                        defaultHandleArr2[i4] = defaultHandle;
                        i4++;
                    }
                    i++;
                }
                if (i2 == Recycler.LINK_CAPACITY && link.next != null) {
                    reclaimSpace(Recycler.LINK_CAPACITY);
                    this.head = link.next;
                }
                link.readIndex = i2;
                if (((Stack) stack).size == i4) {
                    return false;
                }
                ((Stack) stack).size = i4;
                return true;
            }
            return false;
        }

        private WeakOrderQueue(Stack<?> stack, Thread thread) {
            this.f40293id = Recycler.ID_GENERATOR.getAndIncrement();
            Link link = new Link();
            this.tail = link;
            this.head = link;
            this.owner = new WeakReference<>(thread);
            synchronized (stack) {
                this.next = ((Stack) stack).head;
                ((Stack) stack).head = this;
            }
            this.availableSharedCapacity = stack.availableSharedCapacity;
        }
    }

    protected Recycler(int i, int i2, int i3, int i4) {
        this.threadLocal = new FastThreadLocal<Stack<T>>() { // from class: io.netty.util.Recycler.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Stack<T> initialValue() {
                return new Stack<>(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacityPerThread, Recycler.this.maxSharedCapacityFactor, Recycler.this.ratioMask, Recycler.this.maxDelayedQueuesPerThread);
            }
        };
        this.ratioMask = MathUtil.safeFindNextPositivePowerOfTwo(i3) - 1;
        if (i <= 0) {
            this.maxCapacityPerThread = 0;
            this.maxSharedCapacityFactor = 1;
            this.maxDelayedQueuesPerThread = 0;
            return;
        }
        this.maxCapacityPerThread = i;
        this.maxSharedCapacityFactor = Math.max(1, i2);
        this.maxDelayedQueuesPerThread = Math.max(0, i4);
    }
}

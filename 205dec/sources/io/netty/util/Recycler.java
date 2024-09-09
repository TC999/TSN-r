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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Recycler<T> {
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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
                Stack<?> stack = this.stack;
                if (this.lastRecycledId == this.recycleId && stack != null) {
                    stack.push(this);
                    return;
                }
                throw new IllegalStateException("recycled already");
            }
            throw new IllegalArgumentException("object does not belong to handle");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface Handle<T> {
        void recycle(T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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
        final WeakReference<Thread> threadRef;

        Stack(Recycler<T> recycler, Thread thread, int i4, int i5, int i6, int i7) {
            this.parent = recycler;
            this.threadRef = new WeakReference<>(thread);
            this.maxCapacity = i4;
            this.availableSharedCapacity = new AtomicInteger(Math.max(i4 / i5, Recycler.LINK_CAPACITY));
            this.elements = new DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, i4)];
            this.ratioMask = i6;
            this.maxDelayedQueues = i7;
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
                int i4 = this.size;
                if (i4 >= this.maxCapacity || dropHandle(defaultHandle)) {
                    return;
                }
                DefaultHandle<?>[] defaultHandleArr = this.elements;
                if (i4 == defaultHandleArr.length) {
                    this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, Math.min(i4 << 1, this.maxCapacity));
                }
                this.elements[i4] = defaultHandle;
                this.size = i4 + 1;
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        boolean dropHandle(DefaultHandle<?> defaultHandle) {
            if (defaultHandle.hasBeenRecycled) {
                return false;
            }
            int i4 = this.handleRecycleCount + 1;
            this.handleRecycleCount = i4;
            if ((i4 & this.ratioMask) != 0) {
                return true;
            }
            defaultHandle.hasBeenRecycled = true;
            return false;
        }

        int increaseCapacity(int i4) {
            int length = this.elements.length;
            int i5 = this.maxCapacity;
            do {
                length <<= 1;
                if (length >= i4) {
                    break;
                }
            } while (length < i5);
            int min = Math.min(length, i5);
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
            int i4 = this.size;
            if (i4 == 0) {
                if (!scavenge()) {
                    return null;
                }
                i4 = this.size;
            }
            int i5 = i4 - 1;
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            DefaultHandle<T> defaultHandle = (DefaultHandle<T>) defaultHandleArr[i5];
            defaultHandleArr[i5] = null;
            if (((DefaultHandle) defaultHandle).lastRecycledId == ((DefaultHandle) defaultHandle).recycleId) {
                ((DefaultHandle) defaultHandle).recycleId = 0;
                ((DefaultHandle) defaultHandle).lastRecycledId = 0;
                this.size = i5;
                return defaultHandle;
            }
            throw new IllegalStateException("recycled multiple times");
        }

        void push(DefaultHandle<?> defaultHandle) {
            Thread currentThread = Thread.currentThread();
            if (this.threadRef.get() == currentThread) {
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
            WeakOrderQueue weakOrderQueue;
            WeakOrderQueue weakOrderQueue2;
            boolean z3;
            WeakOrderQueue weakOrderQueue3;
            WeakOrderQueue weakOrderQueue4 = this.cursor;
            boolean z4 = false;
            if (weakOrderQueue4 == null) {
                weakOrderQueue2 = null;
                weakOrderQueue = this.head;
                if (weakOrderQueue == null) {
                    return false;
                }
            } else {
                weakOrderQueue = weakOrderQueue4;
                weakOrderQueue2 = this.prev;
            }
            while (true) {
                z3 = true;
                if (weakOrderQueue.transfer(this)) {
                    break;
                }
                weakOrderQueue3 = weakOrderQueue.next;
                if (weakOrderQueue.owner.get() == null) {
                    if (weakOrderQueue.hasFinalData()) {
                        while (weakOrderQueue.transfer(this)) {
                            z4 = true;
                        }
                    }
                    if (weakOrderQueue2 != null) {
                        weakOrderQueue2.setNext(weakOrderQueue3);
                    }
                } else {
                    weakOrderQueue2 = weakOrderQueue;
                }
                if (weakOrderQueue3 == null || z4) {
                    break;
                }
                weakOrderQueue = weakOrderQueue3;
            }
            z3 = z4;
            weakOrderQueue = weakOrderQueue3;
            this.prev = weakOrderQueue2;
            this.cursor = weakOrderQueue;
            return z3;
        }

        synchronized void setHead(WeakOrderQueue weakOrderQueue) {
            weakOrderQueue.setNext(this.head);
            this.head = weakOrderQueue;
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
        int i4 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        int i5 = i4 >= 0 ? i4 : 4096;
        DEFAULT_MAX_CAPACITY_PER_THREAD = i5;
        int max = Math.max(2, SystemPropertyUtil.getInt("io.netty.recycler.maxSharedCapacityFactor", 2));
        MAX_SHARED_CAPACITY_FACTOR = max;
        MAX_DELAYED_QUEUES_PER_THREAD = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.maxDelayedQueuesPerThread", NettyRuntime.availableProcessors() * 2));
        int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(Math.max(SystemPropertyUtil.getInt("io.netty.recycler.linkCapacity", 16), 16));
        LINK_CAPACITY = safeFindNextPositivePowerOfTwo;
        int safeFindNextPositivePowerOfTwo2 = MathUtil.safeFindNextPositivePowerOfTwo(SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = safeFindNextPositivePowerOfTwo2;
        if (internalLoggerFactory.isDebugEnabled()) {
            if (i5 == 0) {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: disabled");
            } else {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i5));
                internalLoggerFactory.debug("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(max));
                internalLoggerFactory.debug("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo));
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo2));
            }
        }
        INITIAL_CAPACITY = Math.min(i5, 256);
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
    public final boolean recycle(T t3, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        DefaultHandle defaultHandle = (DefaultHandle) handle;
        if (defaultHandle.stack.parent != this) {
            return false;
        }
        defaultHandle.recycle(t3);
        return true;
    }

    final int threadLocalCapacity() {
        return ((Stack) this.threadLocal.get()).elements.length;
    }

    final int threadLocalSize() {
        return ((Stack) this.threadLocal.get()).size;
    }

    protected Recycler(int i4) {
        this(i4, MAX_SHARED_CAPACITY_FACTOR);
    }

    protected Recycler(int i4, int i5) {
        this(i4, i5, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class WeakOrderQueue {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final WeakOrderQueue DUMMY = new WeakOrderQueue();
        private final Head head;
        private final int id;
        private WeakOrderQueue next;
        private final WeakReference<Thread> owner;
        private Link tail;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class Head {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private final AtomicInteger availableSharedCapacity;
            Link link;

            Head(AtomicInteger atomicInteger) {
                this.availableSharedCapacity = atomicInteger;
            }

            protected void finalize() throws Throwable {
                try {
                    super.finalize();
                } finally {
                    Link link = this.link;
                    this.link = null;
                    while (link != null) {
                        reclaimSpace(Recycler.LINK_CAPACITY);
                        Link link2 = link.next;
                        link.next = null;
                        link = link2;
                    }
                }
            }

            void reclaimSpace(int i4) {
                this.availableSharedCapacity.addAndGet(i4);
            }

            boolean reserveSpace(int i4) {
                return reserveSpace(this.availableSharedCapacity, i4);
            }

            static boolean reserveSpace(AtomicInteger atomicInteger, int i4) {
                int i5;
                do {
                    i5 = atomicInteger.get();
                    if (i5 < i4) {
                        return false;
                    }
                } while (!atomicInteger.compareAndSet(i5, i5 - i4));
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class Link extends AtomicInteger {
            private final DefaultHandle<?>[] elements = new DefaultHandle[Recycler.LINK_CAPACITY];
            Link next;
            private int readIndex;

            Link() {
            }
        }

        private WeakOrderQueue() {
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.owner = null;
            this.head = new Head(null);
        }

        static WeakOrderQueue allocate(Stack<?> stack, Thread thread) {
            if (Head.reserveSpace(stack.availableSharedCapacity, Recycler.LINK_CAPACITY)) {
                return newQueue(stack, thread);
            }
            return null;
        }

        static WeakOrderQueue newQueue(Stack<?> stack, Thread thread) {
            WeakOrderQueue weakOrderQueue = new WeakOrderQueue(stack, thread);
            stack.setHead(weakOrderQueue);
            return weakOrderQueue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNext(WeakOrderQueue weakOrderQueue) {
            this.next = weakOrderQueue;
        }

        void add(DefaultHandle<?> defaultHandle) {
            ((DefaultHandle) defaultHandle).lastRecycledId = this.id;
            Link link = this.tail;
            int i4 = link.get();
            if (i4 == Recycler.LINK_CAPACITY) {
                if (!this.head.reserveSpace(Recycler.LINK_CAPACITY)) {
                    return;
                }
                Link link2 = new Link();
                link.next = link2;
                this.tail = link2;
                i4 = link2.get();
                link = link2;
            }
            link.elements[i4] = defaultHandle;
            ((DefaultHandle) defaultHandle).stack = null;
            link.lazySet(i4 + 1);
        }

        boolean hasFinalData() {
            return this.tail.readIndex != this.tail.get();
        }

        boolean transfer(Stack<?> stack) {
            Link link = this.head.link;
            if (link == null) {
                return false;
            }
            if (link.readIndex == Recycler.LINK_CAPACITY) {
                link = link.next;
                if (link == null) {
                    return false;
                }
                Head head = this.head;
                head.link = link;
                head.reclaimSpace(Recycler.LINK_CAPACITY);
            }
            int i4 = link.readIndex;
            int i5 = link.get();
            int i6 = i5 - i4;
            if (i6 == 0) {
                return false;
            }
            int i7 = ((Stack) stack).size;
            int i8 = i6 + i7;
            if (i8 > ((Stack) stack).elements.length) {
                i5 = Math.min((stack.increaseCapacity(i8) + i4) - i7, i5);
            }
            if (i4 != i5) {
                DefaultHandle<?>[] defaultHandleArr = link.elements;
                DefaultHandle[] defaultHandleArr2 = ((Stack) stack).elements;
                while (i4 < i5) {
                    DefaultHandle<?> defaultHandle = defaultHandleArr[i4];
                    if (((DefaultHandle) defaultHandle).recycleId == 0) {
                        ((DefaultHandle) defaultHandle).recycleId = ((DefaultHandle) defaultHandle).lastRecycledId;
                    } else if (((DefaultHandle) defaultHandle).recycleId != ((DefaultHandle) defaultHandle).lastRecycledId) {
                        throw new IllegalStateException("recycled already");
                    }
                    defaultHandleArr[i4] = null;
                    if (!stack.dropHandle(defaultHandle)) {
                        ((DefaultHandle) defaultHandle).stack = stack;
                        defaultHandleArr2[i7] = defaultHandle;
                        i7++;
                    }
                    i4++;
                }
                if (i5 == Recycler.LINK_CAPACITY && link.next != null) {
                    this.head.reclaimSpace(Recycler.LINK_CAPACITY);
                    this.head.link = link.next;
                }
                link.readIndex = i5;
                if (((Stack) stack).size == i7) {
                    return false;
                }
                ((Stack) stack).size = i7;
                return true;
            }
            return false;
        }

        private WeakOrderQueue(Stack<?> stack, Thread thread) {
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.tail = new Link();
            Head head = new Head(stack.availableSharedCapacity);
            this.head = head;
            head.link = this.tail;
            this.owner = new WeakReference<>(thread);
        }
    }

    protected Recycler(int i4, int i5, int i6, int i7) {
        this.threadLocal = new FastThreadLocal<Stack<T>>() { // from class: io.netty.util.Recycler.2
            @Override // io.netty.util.concurrent.FastThreadLocal
            protected /* bridge */ /* synthetic */ void onRemoval(Object obj) throws Exception {
                onRemoval((Stack) ((Stack) obj));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Stack<T> initialValue() {
                return new Stack<>(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacityPerThread, Recycler.this.maxSharedCapacityFactor, Recycler.this.ratioMask, Recycler.this.maxDelayedQueuesPerThread);
            }

            protected void onRemoval(Stack<T> stack) {
                if (stack.threadRef.get() == Thread.currentThread() && Recycler.DELAYED_RECYCLED.isSet()) {
                    ((Map) Recycler.DELAYED_RECYCLED.get()).remove(stack);
                }
            }
        };
        this.ratioMask = MathUtil.safeFindNextPositivePowerOfTwo(i6) - 1;
        if (i4 <= 0) {
            this.maxCapacityPerThread = 0;
            this.maxSharedCapacityFactor = 1;
            this.maxDelayedQueuesPerThread = 0;
            return;
        }
        this.maxCapacityPerThread = i4;
        this.maxSharedCapacityFactor = Math.max(1, i5);
        this.maxDelayedQueuesPerThread = Math.max(0, i7);
    }
}

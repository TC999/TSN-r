package io.netty.channel.kqueue;

import com.bykv.vk.component.ttvideo.player.C;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class KQueueEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int KQUEUE_WAKE_UP_IDENT = 0;
    private final boolean allowGrowing;
    private final KQueueEventArray changeList;
    private final IntObjectMap<AbstractKQueueChannel> channels;
    private final KQueueEventArray eventList;
    private volatile int ioRatio;
    private final IovArray iovArray;
    private final FileDescriptor kqueueFd;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(KQueueEventLoop.class);
    private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(KQueueEventLoop.class, "wakenUp");

    static {
        KQueue.ensureAvailability();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KQueueEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i4, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(eventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory), rejectedExecutionHandler);
        this.iovArray = new IovArray();
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.kqueue.KQueueEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return KQueueEventLoop.this.kqueueWaitNow();
            }
        };
        this.channels = new IntObjectHashMap(4096);
        this.ioRatio = 50;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        FileDescriptor newKQueue = Native.newKQueue();
        this.kqueueFd = newKQueue;
        if (i4 == 0) {
            this.allowGrowing = true;
            i4 = 4096;
        } else {
            this.allowGrowing = false;
        }
        this.changeList = new KQueueEventArray(i4);
        this.eventList = new KQueueEventArray(i4);
        int keventAddUserEvent = Native.keventAddUserEvent(newKQueue.intValue(), 0);
        if (keventAddUserEvent >= 0) {
            return;
        }
        cleanup();
        throw new IllegalStateException("kevent failed to add user event with errno: " + (-keventAddUserEvent));
    }

    private void closeAll() {
        AbstractKQueueChannel[] abstractKQueueChannelArr;
        try {
            kqueueWaitNow();
        } catch (IOException unused) {
        }
        for (AbstractKQueueChannel abstractKQueueChannel : (AbstractKQueueChannel[]) this.channels.values().toArray(new AbstractKQueueChannel[0])) {
            abstractKQueueChannel.unsafe().close(abstractKQueueChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private int kqueueWait(boolean z3) throws IOException {
        if (z3 && hasTasks()) {
            return kqueueWaitNow();
        }
        long delayNanos = delayNanos(System.nanoTime());
        int min = (int) Math.min(delayNanos / C.NANOS_PER_SECOND, 2147483647L);
        return kqueueWait(min, (int) Math.min(delayNanos - (min * C.NANOS_PER_SECOND), 2147483647L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kqueueWaitNow() throws IOException {
        return kqueueWait(0, 0);
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        if (eventLoopTaskQueueFactory == null) {
            return newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
        }
        return eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private static Queue<Runnable> newTaskQueue0(int i4) {
        if (i4 == Integer.MAX_VALUE) {
            return PlatformDependent.newMpscQueue();
        }
        return PlatformDependent.newMpscQueue(i4);
    }

    private void processReady(int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            short filter = this.eventList.filter(i5);
            short flags = this.eventList.flags(i5);
            int fd = this.eventList.fd(i5);
            if (filter != Native.EVFILT_USER && (Native.EV_ERROR & flags) == 0) {
                AbstractKQueueChannel abstractKQueueChannel = this.channels.get(fd);
                if (abstractKQueueChannel == null) {
                    logger.warn("events[{}]=[{}, {}] had no channel!", Integer.valueOf(i5), Integer.valueOf(this.eventList.fd(i5)), Short.valueOf(filter));
                } else {
                    AbstractKQueueChannel.AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueChannel.AbstractKQueueUnsafe) abstractKQueueChannel.unsafe();
                    if (filter == Native.EVFILT_WRITE) {
                        abstractKQueueUnsafe.writeReady();
                    } else if (filter == Native.EVFILT_READ) {
                        abstractKQueueUnsafe.readReady(this.eventList.data(i5));
                    } else if (filter == Native.EVFILT_SOCK && (this.eventList.fflags(i5) & Native.NOTE_RDHUP) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                    if ((Native.EV_EOF & flags) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(AbstractKQueueChannel abstractKQueueChannel) {
        this.channels.put(abstractKQueueChannel.fd().intValue(), (int) abstractKQueueChannel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IovArray cleanArray() {
        this.iovArray.clear();
        return this.iovArray;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            try {
                this.kqueueFd.close();
            } catch (IOException e4) {
                logger.warn("Failed to close the kqueue fd.", (Throwable) e4);
            }
        } finally {
            this.changeList.free();
            this.eventList.free();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evSet(AbstractKQueueChannel abstractKQueueChannel, short s3, short s4, int i4) {
        this.changeList.evSet(abstractKQueueChannel, s3, s4, i4);
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public int registeredChannels() {
        return this.channels.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(AbstractKQueueChannel abstractKQueueChannel) throws Exception {
        int intValue = abstractKQueueChannel.fd().intValue();
        AbstractKQueueChannel remove = this.channels.remove(intValue);
        if (remove != null && remove != abstractKQueueChannel) {
            this.channels.put(intValue, (int) remove);
        } else if (abstractKQueueChannel.isOpen()) {
            abstractKQueueChannel.unregisterFilters();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|2|(1:50)(2:4|(2:49|33)(3:6|7|(11:9|10|11|(2:(1:14)|15)(3:38|(1:40)|41)|16|(1:20)|21|22|24|(3:26|27|(2:29|30)(1:32))(1:34)|33)))|42|(1:44)(1:48)|45|(1:47)|10|11|(0)(0)|16|(2:18|20)|21|22|24|(0)(0)|33) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
        handleLoopException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043 A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #3 {all -> 0x007f, blocks: (B:2:0x0000, B:16:0x002e, B:25:0x003f, B:34:0x006d, B:36:0x0071, B:38:0x0079, B:26:0x0043, B:33:0x005e, B:9:0x0017, B:13:0x0023, B:15:0x002b, B:20:0x0036, B:28:0x0049), top: B:51:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0000 A[SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r7 = this;
        L0:
            io.netty.channel.SelectStrategy r0 = r7.selectStrategy     // Catch: java.lang.Throwable -> L7f
            io.netty.util.IntSupplier r1 = r7.selectNowSupplier     // Catch: java.lang.Throwable -> L7f
            boolean r2 = r7.hasTasks()     // Catch: java.lang.Throwable -> L7f
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: java.lang.Throwable -> L7f
            r1 = -3
            r2 = 0
            if (r0 == r1) goto L17
            r1 = -2
            if (r0 == r1) goto L0
            r1 = -1
            if (r0 == r1) goto L17
            goto L2e
        L17:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.channel.kqueue.KQueueEventLoop> r0 = io.netty.channel.kqueue.KQueueEventLoop.WAKEN_UP_UPDATER     // Catch: java.lang.Throwable -> L7f
            int r0 = r0.getAndSet(r7, r2)     // Catch: java.lang.Throwable -> L7f
            r1 = 1
            if (r0 != r1) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            int r0 = r7.kqueueWait(r0)     // Catch: java.lang.Throwable -> L7f
            int r3 = r7.wakenUp     // Catch: java.lang.Throwable -> L7f
            if (r3 != r1) goto L2e
            r7.wakeup()     // Catch: java.lang.Throwable -> L7f
        L2e:
            int r1 = r7.ioRatio     // Catch: java.lang.Throwable -> L7f
            r3 = 100
            if (r1 != r3) goto L43
            if (r0 <= 0) goto L3f
            r7.processReady(r0)     // Catch: java.lang.Throwable -> L3a
            goto L3f
        L3a:
            r0 = move-exception
            r7.runAllTasks()     // Catch: java.lang.Throwable -> L7f
            throw r0     // Catch: java.lang.Throwable -> L7f
        L3f:
            r7.runAllTasks()     // Catch: java.lang.Throwable -> L7f
            goto L6d
        L43:
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L7f
            if (r0 <= 0) goto L5e
            r7.processReady(r0)     // Catch: java.lang.Throwable -> L4d
            goto L5e
        L4d:
            r0 = move-exception
            long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 - r3
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 * r2
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 / r1
            r7.runAllTasks(r5)     // Catch: java.lang.Throwable -> L7f
            throw r0     // Catch: java.lang.Throwable -> L7f
        L5e:
            long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 - r3
            int r3 = 100 - r1
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 * r3
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 / r3
            r7.runAllTasks(r5)     // Catch: java.lang.Throwable -> L7f
        L6d:
            boolean r1 = r7.allowGrowing     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L83
            io.netty.channel.kqueue.KQueueEventArray r1 = r7.eventList     // Catch: java.lang.Throwable -> L7f
            int r1 = r1.capacity()     // Catch: java.lang.Throwable -> L7f
            if (r0 != r1) goto L83
            io.netty.channel.kqueue.KQueueEventArray r0 = r7.eventList     // Catch: java.lang.Throwable -> L7f
            r0.realloc(r2)     // Catch: java.lang.Throwable -> L7f
            goto L83
        L7f:
            r0 = move-exception
            handleLoopException(r0)
        L83:
            boolean r0 = r7.isShuttingDown()     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L0
            r7.closeAll()     // Catch: java.lang.Throwable -> L93
            boolean r0 = r7.confirmShutdown()     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L0
            return
        L93:
            r0 = move-exception
            handleLoopException(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueEventLoop.run():void");
    }

    public void setIoRatio(int i4) {
        if (i4 > 0 && i4 <= 100) {
            this.ioRatio = i4;
            return;
        }
        throw new IllegalArgumentException("ioRatio: " + i4 + " (expected: 0 < ioRatio <= 100)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z3) {
        if (z3 || !WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            return;
        }
        wakeup();
    }

    private void wakeup() {
        Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i4) {
        return newTaskQueue0(i4);
    }

    private int kqueueWait(int i4, int i5) throws IOException {
        int keventWait = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, i4, i5);
        this.changeList.clear();
        return keventWait;
    }
}

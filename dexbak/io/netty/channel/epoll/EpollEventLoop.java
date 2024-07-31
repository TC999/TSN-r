package io.netty.channel.epoll;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class EpollEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicIntegerFieldUpdater<EpollEventLoop> WAKEN_UP_UPDATER;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(EpollEventLoop.class);
    private final boolean allowGrowing;
    private final IntObjectMap<AbstractEpollChannel> channels;
    private final FileDescriptor epollFd;
    private final FileDescriptor eventFd;
    private final EpollEventArray events;
    private volatile int ioRatio;
    private final IovArray iovArray;
    private final Callable<Integer> pendingTasksCallable;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;

    static {
        AtomicIntegerFieldUpdater<EpollEventLoop> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(EpollEventLoop.class, "wakenUp");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(EpollEventLoop.class, "wakenUp");
        }
        WAKEN_UP_UPDATER = newAtomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, executor, false, SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS, rejectedExecutionHandler);
        FileDescriptor fileDescriptor;
        FileDescriptor newEpollCreate;
        this.channels = new IntObjectHashMap(4096);
        this.iovArray = new IovArray();
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.epoll.EpollEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return Native.epollWait(EpollEventLoop.this.epollFd.intValue(), EpollEventLoop.this.events, 0);
            }
        };
        this.pendingTasksCallable = new Callable<Integer>() { // from class: io.netty.channel.epoll.EpollEventLoop.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(EpollEventLoop.super.pendingTasks());
            }
        };
        this.ioRatio = 50;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        if (i == 0) {
            this.allowGrowing = true;
            this.events = new EpollEventArray(4096);
        } else {
            this.allowGrowing = false;
            this.events = new EpollEventArray(i);
        }
        FileDescriptor fileDescriptor2 = null;
        try {
            newEpollCreate = Native.newEpollCreate();
        } catch (Throwable th) {
            th = th;
            fileDescriptor = null;
        }
        try {
            this.epollFd = newEpollCreate;
            fileDescriptor2 = Native.newEventFd();
            this.eventFd = fileDescriptor2;
            try {
                Native.epollCtlAdd(newEpollCreate.intValue(), fileDescriptor2.intValue(), Native.EPOLLIN);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to add eventFd filedescriptor to epoll", e);
            }
        } catch (Throwable th2) {
            th = th2;
            fileDescriptor = fileDescriptor2;
            fileDescriptor2 = newEpollCreate;
            if (fileDescriptor2 != null) {
                try {
                    fileDescriptor2.close();
                } catch (Exception unused) {
                }
            }
            if (fileDescriptor != null) {
                try {
                    fileDescriptor.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private void closeAll() {
        try {
            Native.epollWait(this.epollFd.intValue(), this.events, 0);
        } catch (IOException unused) {
        }
        ArrayList<AbstractEpollChannel> arrayList = new ArrayList(this.channels.size());
        for (AbstractEpollChannel abstractEpollChannel : this.channels.values()) {
            arrayList.add(abstractEpollChannel);
        }
        for (AbstractEpollChannel abstractEpollChannel2 : arrayList) {
            abstractEpollChannel2.unsafe().close(abstractEpollChannel2.unsafe().voidPromise());
        }
    }

    private int epollWait(boolean z) throws IOException {
        int epollWait;
        int epollWait2;
        long nanoTime = System.nanoTime();
        long delayNanos = delayNanos(nanoTime) + nanoTime;
        int i = 0;
        while (true) {
            long j = ((delayNanos - nanoTime) + 500000) / 1000000;
            if (j <= 0) {
                if (i != 0 || (epollWait = Native.epollWait(this.epollFd.intValue(), this.events, 0)) <= 0) {
                    return 0;
                }
                return epollWait;
            } else if (hasTasks() && WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
                return Native.epollWait(this.epollFd.intValue(), this.events, 0);
            } else {
                epollWait2 = Native.epollWait(this.epollFd.intValue(), this.events, (int) j);
                i++;
                if (epollWait2 != 0 || z || this.wakenUp == 1 || hasTasks() || hasScheduledTasks()) {
                    break;
                }
                nanoTime = System.nanoTime();
            }
        }
        return epollWait2;
    }

    private void processReady(EpollEventArray epollEventArray, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int m12691fd = epollEventArray.m12691fd(i2);
            if (m12691fd == this.eventFd.intValue()) {
                Native.eventFdRead(this.eventFd.intValue());
            } else {
                long events = epollEventArray.events(i2);
                AbstractEpollChannel abstractEpollChannel = this.channels.get(m12691fd);
                if (abstractEpollChannel != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollChannel.AbstractEpollUnsafe) abstractEpollChannel.unsafe();
                    int i3 = Native.EPOLLERR;
                    if (((Native.EPOLLOUT | i3) & events) != 0) {
                        abstractEpollUnsafe.epollOutReady();
                    }
                    if (((i3 | Native.EPOLLIN) & events) != 0) {
                        abstractEpollUnsafe.epollInReady();
                    }
                    if ((events & Native.EPOLLRDHUP) != 0) {
                        abstractEpollUnsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), m12691fd);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.mo12687fd().intValue();
        Native.epollCtlAdd(this.epollFd.intValue(), intValue, abstractEpollChannel.flags);
        this.channels.put(intValue, (int) abstractEpollChannel);
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
                this.epollFd.close();
            } catch (IOException e) {
                logger.warn("Failed to close the epoll fd.", (Throwable) e);
            }
            try {
                this.eventFd.close();
            } catch (IOException e2) {
                logger.warn("Failed to close the event fd.", (Throwable) e2);
            }
        } finally {
            this.iovArray.release();
            this.events.free();
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void modify(AbstractEpollChannel abstractEpollChannel) throws IOException {
        Native.epollCtlMod(this.epollFd.intValue(), abstractEpollChannel.mo12687fd().intValue(), abstractEpollChannel.flags);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i) {
        return PlatformDependent.newMpscQueue(i);
    }

    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        if (inEventLoop()) {
            return super.pendingTasks();
        }
        return ((Integer) submit((Callable) this.pendingTasksCallable).syncUninterruptibly().getNow()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(AbstractEpollChannel abstractEpollChannel) throws IOException {
        if (abstractEpollChannel.isOpen()) {
            if (this.channels.remove(abstractEpollChannel.mo12687fd().intValue()) != null) {
                Native.epollCtlDel(this.epollFd.intValue(), abstractEpollChannel.mo12687fd().intValue());
            }
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        while (true) {
            try {
                int calculateStrategy = this.selectStrategy.calculateStrategy(this.selectNowSupplier, hasTasks());
                if (calculateStrategy == -2) {
                    continue;
                } else {
                    if (calculateStrategy == -1) {
                        calculateStrategy = epollWait(WAKEN_UP_UPDATER.getAndSet(this, 0) == 1);
                        if (this.wakenUp == 1) {
                            Native.eventFdWrite(this.eventFd.intValue(), 1L);
                        }
                    }
                    int i = this.ioRatio;
                    if (i == 100) {
                        if (calculateStrategy > 0) {
                            processReady(this.events, calculateStrategy);
                        }
                        runAllTasks();
                    } else {
                        long nanoTime = System.nanoTime();
                        if (calculateStrategy > 0) {
                            processReady(this.events, calculateStrategy);
                        }
                        runAllTasks(((System.nanoTime() - nanoTime) * (100 - i)) / i);
                    }
                    if (this.allowGrowing && calculateStrategy == this.events.length()) {
                        this.events.increase();
                    }
                    if (isShuttingDown()) {
                        closeAll();
                        if (confirmShutdown()) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            } catch (Throwable th) {
                logger.warn("Unexpected exception in the selector loop.", th);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void setIoRatio(int i) {
        if (i > 0 && i <= 100) {
            this.ioRatio = i;
            return;
        }
        throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z) {
        if (z || !WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            return;
        }
        Native.eventFdWrite(this.eventFd.intValue(), 1L);
    }
}

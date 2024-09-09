package io.netty.channel.epoll;

import com.bykv.vk.component.ttvideo.player.C;
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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    public EpollEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i4, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler) {
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
        if (i4 == 0) {
            this.allowGrowing = true;
            this.events = new EpollEventArray(4096);
        } else {
            this.allowGrowing = false;
            this.events = new EpollEventArray(i4);
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
            } catch (IOException e4) {
                throw new IllegalStateException("Unable to add eventFd filedescriptor to epoll", e4);
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

    private int epollWait(boolean z3) throws IOException {
        int epollWait;
        int epollWait2;
        long nanoTime = System.nanoTime();
        long delayNanos = delayNanos(nanoTime) + nanoTime;
        int i4 = 0;
        while (true) {
            long j4 = ((delayNanos - nanoTime) + 500000) / C.MICROS_PER_SECOND;
            if (j4 <= 0) {
                if (i4 != 0 || (epollWait = Native.epollWait(this.epollFd.intValue(), this.events, 0)) <= 0) {
                    return 0;
                }
                return epollWait;
            } else if (hasTasks() && WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
                return Native.epollWait(this.epollFd.intValue(), this.events, 0);
            } else {
                epollWait2 = Native.epollWait(this.epollFd.intValue(), this.events, (int) j4);
                i4++;
                if (epollWait2 != 0 || z3 || this.wakenUp == 1 || hasTasks() || hasScheduledTasks()) {
                    break;
                }
                nanoTime = System.nanoTime();
            }
        }
        return epollWait2;
    }

    private void processReady(EpollEventArray epollEventArray, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int fd = epollEventArray.fd(i5);
            if (fd == this.eventFd.intValue()) {
                Native.eventFdRead(this.eventFd.intValue());
            } else {
                long events = epollEventArray.events(i5);
                AbstractEpollChannel abstractEpollChannel = this.channels.get(fd);
                if (abstractEpollChannel != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollChannel.AbstractEpollUnsafe) abstractEpollChannel.unsafe();
                    int i6 = Native.EPOLLERR;
                    if (((Native.EPOLLOUT | i6) & events) != 0) {
                        abstractEpollUnsafe.epollOutReady();
                    }
                    if (((i6 | Native.EPOLLIN) & events) != 0) {
                        abstractEpollUnsafe.epollInReady();
                    }
                    if ((events & Native.EPOLLRDHUP) != 0) {
                        abstractEpollUnsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), fd);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.fd().intValue();
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
            } catch (IOException e4) {
                logger.warn("Failed to close the epoll fd.", (Throwable) e4);
            }
            try {
                this.eventFd.close();
            } catch (IOException e5) {
                logger.warn("Failed to close the event fd.", (Throwable) e5);
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
        Native.epollCtlMod(this.epollFd.intValue(), abstractEpollChannel.fd().intValue(), abstractEpollChannel.flags);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i4) {
        return PlatformDependent.newMpscQueue(i4);
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
            if (this.channels.remove(abstractEpollChannel.fd().intValue()) != null) {
                Native.epollCtlDel(this.epollFd.intValue(), abstractEpollChannel.fd().intValue());
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
                    int i4 = this.ioRatio;
                    if (i4 == 100) {
                        if (calculateStrategy > 0) {
                            processReady(this.events, calculateStrategy);
                        }
                        runAllTasks();
                    } else {
                        long nanoTime = System.nanoTime();
                        if (calculateStrategy > 0) {
                            processReady(this.events, calculateStrategy);
                        }
                        runAllTasks(((System.nanoTime() - nanoTime) * (100 - i4)) / i4);
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
        Native.eventFdWrite(this.eventFd.intValue(), 1L);
    }
}

package io.netty.channel.kqueue;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class KQueueEventLoopGroup extends MultithreadEventLoopGroup {
    public KQueueEventLoopGroup() {
        this(0);
    }

    public void setIoRatio(int i4) {
        Iterator<EventExecutor> it = iterator();
        while (it.hasNext()) {
            ((KQueueEventLoop) it.next()).setIoRatio(i4);
        }
    }

    public KQueueEventLoopGroup(int i4) {
        this(i4, (ThreadFactory) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) throws Exception {
        return new KQueueEventLoop(this, executor, ((Integer) objArr[0]).intValue(), ((SelectStrategyFactory) objArr[1]).newSelectStrategy(), (RejectedExecutionHandler) objArr[2], objArr.length == 4 ? (EventLoopTaskQueueFactory) objArr[3] : null);
    }

    public KQueueEventLoopGroup(int i4, SelectStrategyFactory selectStrategyFactory) {
        this(i4, (ThreadFactory) null, selectStrategyFactory);
    }

    public KQueueEventLoopGroup(int i4, ThreadFactory threadFactory) {
        this(i4, threadFactory, 0);
    }

    public KQueueEventLoopGroup(int i4, Executor executor) {
        this(i4, executor, DefaultSelectStrategyFactory.INSTANCE);
    }

    public KQueueEventLoopGroup(int i4, ThreadFactory threadFactory, SelectStrategyFactory selectStrategyFactory) {
        this(i4, threadFactory, 0, selectStrategyFactory);
    }

    @Deprecated
    public KQueueEventLoopGroup(int i4, ThreadFactory threadFactory, int i5) {
        this(i4, threadFactory, i5, DefaultSelectStrategyFactory.INSTANCE);
    }

    @Deprecated
    public KQueueEventLoopGroup(int i4, ThreadFactory threadFactory, int i5, SelectStrategyFactory selectStrategyFactory) {
        super(i4, threadFactory, Integer.valueOf(i5), selectStrategyFactory, RejectedExecutionHandlers.reject());
        KQueue.ensureAvailability();
    }

    public KQueueEventLoopGroup(int i4, Executor executor, SelectStrategyFactory selectStrategyFactory) {
        super(i4, executor, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
        KQueue.ensureAvailability();
    }

    public KQueueEventLoopGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory) {
        super(i4, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
        KQueue.ensureAvailability();
    }

    public KQueueEventLoopGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler);
        KQueue.ensureAvailability();
    }

    public KQueueEventLoopGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(i4, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler, eventLoopTaskQueueFactory);
        KQueue.ensureAvailability();
    }
}

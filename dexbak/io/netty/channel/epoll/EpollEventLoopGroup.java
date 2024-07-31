package io.netty.channel.epoll;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class EpollEventLoopGroup extends MultithreadEventLoopGroup {
    public EpollEventLoopGroup() {
        this(0);
    }

    public void setIoRatio(int i) {
        Iterator<EventExecutor> it = iterator();
        while (it.hasNext()) {
            ((EpollEventLoop) it.next()).setIoRatio(i);
        }
    }

    public EpollEventLoopGroup(int i) {
        this(i, (ThreadFactory) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) throws Exception {
        return new EpollEventLoop(this, executor, ((Integer) objArr[0]).intValue(), ((SelectStrategyFactory) objArr[1]).newSelectStrategy(), (RejectedExecutionHandler) objArr[2]);
    }

    public EpollEventLoopGroup(int i, SelectStrategyFactory selectStrategyFactory) {
        this(i, (ThreadFactory) null, selectStrategyFactory);
    }

    public EpollEventLoopGroup(int i, ThreadFactory threadFactory) {
        this(i, threadFactory, 0);
    }

    public EpollEventLoopGroup(int i, Executor executor) {
        this(i, executor, DefaultSelectStrategyFactory.INSTANCE);
    }

    public EpollEventLoopGroup(int i, ThreadFactory threadFactory, SelectStrategyFactory selectStrategyFactory) {
        this(i, threadFactory, 0, selectStrategyFactory);
    }

    @Deprecated
    public EpollEventLoopGroup(int i, ThreadFactory threadFactory, int i2) {
        this(i, threadFactory, i2, DefaultSelectStrategyFactory.INSTANCE);
    }

    @Deprecated
    public EpollEventLoopGroup(int i, ThreadFactory threadFactory, int i2, SelectStrategyFactory selectStrategyFactory) {
        super(i, threadFactory, Integer.valueOf(i2), selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public EpollEventLoopGroup(int i, Executor executor, SelectStrategyFactory selectStrategyFactory) {
        super(i, executor, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public EpollEventLoopGroup(int i, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory) {
        super(i, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public EpollEventLoopGroup(int i, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler);
    }
}

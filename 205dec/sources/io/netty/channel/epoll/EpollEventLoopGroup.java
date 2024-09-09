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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class EpollEventLoopGroup extends MultithreadEventLoopGroup {
    public EpollEventLoopGroup() {
        this(0);
    }

    public void setIoRatio(int i4) {
        Iterator<EventExecutor> it = iterator();
        while (it.hasNext()) {
            ((EpollEventLoop) it.next()).setIoRatio(i4);
        }
    }

    public EpollEventLoopGroup(int i4) {
        this(i4, (ThreadFactory) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) throws Exception {
        return new EpollEventLoop(this, executor, ((Integer) objArr[0]).intValue(), ((SelectStrategyFactory) objArr[1]).newSelectStrategy(), (RejectedExecutionHandler) objArr[2]);
    }

    public EpollEventLoopGroup(int i4, SelectStrategyFactory selectStrategyFactory) {
        this(i4, (ThreadFactory) null, selectStrategyFactory);
    }

    public EpollEventLoopGroup(int i4, ThreadFactory threadFactory) {
        this(i4, threadFactory, 0);
    }

    public EpollEventLoopGroup(int i4, Executor executor) {
        this(i4, executor, DefaultSelectStrategyFactory.INSTANCE);
    }

    public EpollEventLoopGroup(int i4, ThreadFactory threadFactory, SelectStrategyFactory selectStrategyFactory) {
        this(i4, threadFactory, 0, selectStrategyFactory);
    }

    @Deprecated
    public EpollEventLoopGroup(int i4, ThreadFactory threadFactory, int i5) {
        this(i4, threadFactory, i5, DefaultSelectStrategyFactory.INSTANCE);
    }

    @Deprecated
    public EpollEventLoopGroup(int i4, ThreadFactory threadFactory, int i5, SelectStrategyFactory selectStrategyFactory) {
        super(i4, threadFactory, Integer.valueOf(i5), selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public EpollEventLoopGroup(int i4, Executor executor, SelectStrategyFactory selectStrategyFactory) {
        super(i4, executor, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public EpollEventLoopGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory) {
        super(i4, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }

    public EpollEventLoopGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler);
    }
}

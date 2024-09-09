package io.netty.channel;

import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor implements EventLoop {
    protected static final int DEFAULT_MAX_PENDING_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));
    private final Queue<Runnable> tailTasks;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface NonWakeupRunnable extends Runnable {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean z3) {
        this(eventLoopGroup, threadFactory, z3, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void afterRunningAllTasks() {
        runAllTasksFrom(this.tailTasks);
    }

    public final void executeAfterEventLoopIteration(Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        if (isShutdown()) {
            SingleThreadEventExecutor.reject();
        }
        if (!this.tailTasks.offer(runnable)) {
            reject(runnable);
        }
        if (wakesUpForTask(runnable)) {
            wakeup(inEventLoop());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public boolean hasTasks() {
        return super.hasTasks() || !this.tailTasks.isEmpty();
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        return super.pendingTasks() + this.tailTasks.size();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return register(new DefaultChannelPromise(channel, this));
    }

    final boolean removeAfterEventLoopIterationTask(Runnable runnable) {
        return this.tailTasks.remove(ObjectUtil.checkNotNull(runnable, "task"));
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected boolean wakesUpForTask(Runnable runnable) {
        return !(runnable instanceof NonWakeupRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z3) {
        this(eventLoopGroup, executor, z3, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        channelPromise.channel().unsafe().register(this, channelPromise);
        return channelPromise;
    }

    protected SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean z3, int i4, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, threadFactory, z3, i4, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(i4);
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        if (channel != null) {
            if (channelPromise != null) {
                channel.unsafe().register(this, channelPromise);
                return channelPromise;
            }
            throw new NullPointerException("promise");
        }
        throw new NullPointerException("channel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z3, int i4, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventLoopGroup, executor, z3, i4, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(i4);
    }
}

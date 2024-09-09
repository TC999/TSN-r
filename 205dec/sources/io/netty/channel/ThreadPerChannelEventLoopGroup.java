package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import io.netty.util.internal.ThrowableUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ThreadPerChannelEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    final Set<EventLoop> activeChildren;
    private final Object[] childArgs;
    private final FutureListener<Object> childTerminationListener;
    final Executor executor;
    final Queue<EventLoop> idleChildren;
    private final int maxChannels;
    private volatile boolean shuttingDown;
    private final Promise<?> terminationFuture;
    private final ChannelException tooManyChannels;

    protected ThreadPerChannelEventLoopGroup() {
        this(0);
    }

    private EventLoop nextChild() throws Exception {
        if (!this.shuttingDown) {
            EventLoop poll = this.idleChildren.poll();
            if (poll == null) {
                if (this.maxChannels > 0 && this.activeChildren.size() >= this.maxChannels) {
                    throw this.tooManyChannels;
                }
                poll = newChild(this.childArgs);
                poll.terminationFuture().addListener(this.childTerminationListener);
            }
            this.activeChildren.add(poll);
            return poll;
        }
        throw new RejectedExecutionException("shutting down");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        long nanoTime;
        long nanoTime2;
        long nanoTime3 = System.nanoTime() + timeUnit.toNanos(j4);
        for (EventLoop eventLoop : this.activeChildren) {
            do {
                nanoTime2 = nanoTime3 - System.nanoTime();
                if (nanoTime2 <= 0) {
                    return isTerminated();
                }
            } while (!eventLoop.awaitTermination(nanoTime2, TimeUnit.NANOSECONDS));
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            do {
                nanoTime = nanoTime3 - System.nanoTime();
                if (nanoTime <= 0) {
                    return isTerminated();
                }
            } while (!eventLoop2.awaitTermination(nanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        for (EventLoop eventLoop : this.activeChildren) {
            if (!eventLoop.isShutdown()) {
                return false;
            }
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            if (!eventLoop2.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        for (EventLoop eventLoop : this.activeChildren) {
            if (!eventLoop.isShuttingDown()) {
                return false;
            }
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            if (!eventLoop2.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        for (EventLoop eventLoop : this.activeChildren) {
            if (!eventLoop.isTerminated()) {
                return false;
            }
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            if (!eventLoop2.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return new ReadOnlyIterator(this.activeChildren.iterator());
    }

    protected EventLoop newChild(Object... objArr) throws Exception {
        return new ThreadPerChannelEventLoop(this);
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        if (channel != null) {
            try {
                EventLoop nextChild = nextChild();
                return nextChild.register(new DefaultChannelPromise(channel, nextChild));
            } catch (Throwable th) {
                return new FailedChannelFuture(channel, GlobalEventExecutor.INSTANCE, th);
            }
        }
        throw new NullPointerException("channel");
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        this.shuttingDown = true;
        for (EventLoop eventLoop : this.activeChildren) {
            eventLoop.shutdown();
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            eventLoop2.shutdown();
        }
        if (isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j4, long j5, TimeUnit timeUnit) {
        this.shuttingDown = true;
        for (EventLoop eventLoop : this.activeChildren) {
            eventLoop.shutdownGracefully(j4, j5, timeUnit);
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            eventLoop2.shutdownGracefully(j4, j5, timeUnit);
        }
        if (isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    protected ThreadPerChannelEventLoopGroup(int i4) {
        this(i4, Executors.defaultThreadFactory(), new Object[0]);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ThreadPerChannelEventLoopGroup(int i4, ThreadFactory threadFactory, Object... objArr) {
        this(i4, new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ThreadPerChannelEventLoopGroup(int i4, Executor executor, Object... objArr) {
        this.activeChildren = Collections.newSetFromMap(PlatformDependent.newConcurrentHashMap());
        this.idleChildren = new ConcurrentLinkedQueue();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.childTerminationListener = new FutureListener<Object>() { // from class: io.netty.channel.ThreadPerChannelEventLoopGroup.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Object> future) throws Exception {
                if (ThreadPerChannelEventLoopGroup.this.isTerminated()) {
                    ThreadPerChannelEventLoopGroup.this.terminationFuture.trySuccess(null);
                }
            }
        };
        if (i4 < 0) {
            throw new IllegalArgumentException(String.format("maxChannels: %d (expected: >= 0)", Integer.valueOf(i4)));
        }
        if (executor != null) {
            if (objArr == null) {
                this.childArgs = EmptyArrays.EMPTY_OBJECTS;
            } else {
                this.childArgs = (Object[]) objArr.clone();
            }
            this.maxChannels = i4;
            this.executor = executor;
            this.tooManyChannels = (ChannelException) ThrowableUtil.unknownStackTrace(new ChannelException("too many channels (max: " + i4 + ')'), ThreadPerChannelEventLoopGroup.class, "nextChild()");
            return;
        }
        throw new NullPointerException("executor");
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        try {
            return nextChild().register(channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        if (channel != null) {
            try {
                return nextChild().register(channel, channelPromise);
            } catch (Throwable th) {
                channelPromise.setFailure(th);
                return channelPromise;
            }
        }
        throw new NullPointerException("channel");
    }
}

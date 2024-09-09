package io.netty.channel;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class MultithreadEventLoopGroup extends MultithreadEventExecutorGroup implements EventLoopGroup {
    private static final int DEFAULT_EVENT_LOOP_THREADS;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(MultithreadEventLoopGroup.class);
        logger = internalLoggerFactory;
        int max = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", Runtime.getRuntime().availableProcessors() * 2));
        DEFAULT_EVENT_LOOP_THREADS = max;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.eventLoopThreads: {}", Integer.valueOf(max));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventLoopGroup(int i4, Executor executor, Object... objArr) {
        super(i4 == 0 ? DEFAULT_EVENT_LOOP_THREADS : i4, executor, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public abstract EventLoop newChild(Executor executor, Object... objArr) throws Exception;

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass(), 10);
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return next().register(channel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventLoopGroup(int i4, ThreadFactory threadFactory, Object... objArr) {
        super(i4 == 0 ? DEFAULT_EVENT_LOOP_THREADS : i4, threadFactory, objArr);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        return next().register(channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventLoopGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        super(i4 == 0 ? DEFAULT_EVENT_LOOP_THREADS : i4, executor, eventExecutorChooserFactory, objArr);
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        return next().register(channel, channelPromise);
    }
}

package io.netty.channel;

import io.netty.util.concurrent.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultEventLoop extends SingleThreadEventLoop {
    public DefaultEventLoop() {
        this((EventLoopGroup) null);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        do {
            Runnable takeTask = takeTask();
            if (takeTask != null) {
                takeTask.run();
                updateLastExecutionTime();
            }
        } while (!confirmShutdown());
    }

    public DefaultEventLoop(ThreadFactory threadFactory) {
        this((EventLoopGroup) null, threadFactory);
    }

    public DefaultEventLoop(Executor executor) {
        this((EventLoopGroup) null, executor);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup) {
        this(eventLoopGroup, new DefaultThreadFactory(DefaultEventLoop.class));
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory) {
        super(eventLoopGroup, threadFactory, true);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup, Executor executor) {
        super(eventLoopGroup, executor, true);
    }
}

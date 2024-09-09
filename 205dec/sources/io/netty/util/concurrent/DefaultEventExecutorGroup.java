package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int i4) {
        this(i4, null);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    protected EventExecutor newChild(Executor executor, Object... objArr) throws Exception {
        return new DefaultEventExecutor(this, executor, ((Integer) objArr[0]).intValue(), (RejectedExecutionHandler) objArr[1]);
    }

    public DefaultEventExecutorGroup(int i4, ThreadFactory threadFactory) {
        this(i4, threadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public DefaultEventExecutorGroup(int i4, ThreadFactory threadFactory, int i5, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, threadFactory, Integer.valueOf(i5), rejectedExecutionHandler);
    }
}

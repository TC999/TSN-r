package io.netty.util.concurrent;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface RejectedExecutionHandler {
    void rejected(Runnable runnable, SingleThreadEventExecutor singleThreadEventExecutor);
}

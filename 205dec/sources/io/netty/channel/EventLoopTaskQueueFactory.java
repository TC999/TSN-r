package io.netty.channel;

import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface EventLoopTaskQueueFactory {
    Queue<Runnable> newTaskQueue(int i4);
}

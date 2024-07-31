package io.netty.util.concurrent;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface EventExecutorChooserFactory {

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface EventExecutorChooser {
        EventExecutor next();
    }

    EventExecutorChooser newChooser(EventExecutor[] eventExecutorArr);
}

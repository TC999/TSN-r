package com.kwad.components.offline.api.core.api;

import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IAsync {
    void execute(Runnable runnable);

    void runOnDefaultExecutor(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runOnUiThreadDelay(Runnable runnable, long j);

    void schedule(Runnable runnable, long j, TimeUnit timeUnit);
}

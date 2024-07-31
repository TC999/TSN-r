package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: com.kwad.sdk.core.network.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10402a<R extends InterfaceC10420f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.m25601FH();
    private Future<?> mTask;

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract R createRequest();

    /* JADX INFO: Access modifiers changed from: protected */
    public void fetch() {
        this.mTask = getExecutor().submit(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AbstractC10402a.this.fetchImpl();
            }
        });
    }

    @WorkerThread
    protected abstract void fetchImpl();

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected abstract void onResponse(R r, C10415c c10415c);
}

package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ay;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a<R extends f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.FH();
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
        this.mTask = getExecutor().submit(new ay() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.fetchImpl();
            }
        });
    }

    @WorkerThread
    protected abstract void fetchImpl();

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected abstract void onResponse(R r3, c cVar);
}

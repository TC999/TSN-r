package com.kwad.components.offline.api;

import androidx.annotation.WorkerThread;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InitCallBack {
    @WorkerThread
    void onError(int i);

    @WorkerThread
    void onSuccess(boolean z);
}

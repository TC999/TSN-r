package com.kwad.components.offline.api;

import androidx.annotation.WorkerThread;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface InitCallBack {
    @WorkerThread
    void onError(int i4);

    @WorkerThread
    void onSuccess(boolean z3);
}

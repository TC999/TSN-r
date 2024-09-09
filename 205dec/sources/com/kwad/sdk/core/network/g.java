package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface g<R extends f, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r3, int i4, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r3);

    @WorkerThread
    void onSuccess(@NonNull R r3, @NonNull T t3);
}

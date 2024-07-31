package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* renamed from: com.kwad.sdk.core.network.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10421g<R extends InterfaceC10420f, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r, int i, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r);

    @WorkerThread
    void onSuccess(@NonNull R r, @NonNull T t);
}

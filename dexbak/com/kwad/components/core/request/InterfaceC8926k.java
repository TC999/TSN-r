package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* renamed from: com.kwad.components.core.request.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC8926k<T extends AdResultData> {
    @WorkerThread
    /* renamed from: a */
    void mo29595a(@NonNull T t);

    @WorkerThread
    void onError(int i, String str);
}

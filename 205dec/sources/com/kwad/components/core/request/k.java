package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface k<T extends AdResultData> {
    @WorkerThread
    void a(@NonNull T t3);

    @WorkerThread
    void onError(int i4, String str);
}

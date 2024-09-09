package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IOfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void cancel();

    @NonNull
    R createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(R r3, c cVar);

    void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener);
}

package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.C10415c;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void cancel();

    @NonNull
    R createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(R r, C10415c c10415c);

    void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener);
}

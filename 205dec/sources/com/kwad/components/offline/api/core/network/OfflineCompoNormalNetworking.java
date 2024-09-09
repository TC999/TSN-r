package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.adapter.NormalNetworkingAdapter;
import com.kwad.components.offline.api.core.network.adapter.NormalRequestListenerAdapter;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class OfflineCompoNormalNetworking<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements IOfflineCompoNetworking<R, T> {
    private NormalNetworkingAdapter<R, T> mNetworking = new NormalNetworkingAdapter<>(this);

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void cancel() {
        this.mNetworking.cancel();
    }

    public abstract T createResponseData();

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean enableMonitorReport() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean isPostByJson() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void onResponse(R r3, c cVar) {
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mNetworking.request(new NormalRequestListenerAdapter(iOfflineCompoRequestListener));
    }
}

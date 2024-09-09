package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class NormalRequestListenerAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements g<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public NormalRequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onError(@NonNull f fVar, int i4, String str) {
        onError((NormalRequestAdapter) ((NormalRequestAdapter) fVar), i4, str);
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull f fVar) {
        onStartRequest((NormalRequestAdapter) ((NormalRequestAdapter) fVar));
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
        onSuccess((NormalRequestAdapter) ((NormalRequestAdapter) fVar), (NormalResultDataAdapter) ((NormalResultDataAdapter) baseResultData));
    }

    public void onError(@NonNull NormalRequestAdapter<R> normalRequestAdapter, int i4, String str) {
        this.mRequestListener.onError(normalRequestAdapter.getOfflineCompoRequest(), i4, str);
    }

    public void onStartRequest(@NonNull NormalRequestAdapter<R> normalRequestAdapter) {
        this.mRequestListener.onStartRequest(normalRequestAdapter.getOfflineCompoRequest());
    }

    public void onSuccess(@NonNull NormalRequestAdapter<R> normalRequestAdapter, @NonNull NormalResultDataAdapter<T> normalResultDataAdapter) {
        this.mRequestListener.onSuccess(normalRequestAdapter.getOfflineCompoRequest(), normalResultDataAdapter.getOfflineCompoResultData());
    }
}

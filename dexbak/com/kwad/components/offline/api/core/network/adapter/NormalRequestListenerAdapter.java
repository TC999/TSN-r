package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.network.InterfaceC10421g;
import com.kwad.sdk.core.response.model.BaseResultData;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NormalRequestListenerAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements InterfaceC10421g<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public NormalRequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public /* bridge */ /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
        onError((NormalRequestAdapter) ((NormalRequestAdapter) interfaceC10420f), i, str);
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull InterfaceC10420f interfaceC10420f) {
        onStartRequest((NormalRequestAdapter) ((NormalRequestAdapter) interfaceC10420f));
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
        onSuccess((NormalRequestAdapter) ((NormalRequestAdapter) interfaceC10420f), (NormalResultDataAdapter) ((NormalResultDataAdapter) baseResultData));
    }

    public void onError(@NonNull NormalRequestAdapter<R> normalRequestAdapter, int i, String str) {
        this.mRequestListener.onError(normalRequestAdapter.getOfflineCompoRequest(), i, str);
    }

    public void onStartRequest(@NonNull NormalRequestAdapter<R> normalRequestAdapter) {
        this.mRequestListener.onStartRequest(normalRequestAdapter.getOfflineCompoRequest());
    }

    public void onSuccess(@NonNull NormalRequestAdapter<R> normalRequestAdapter, @NonNull NormalResultDataAdapter<T> normalResultDataAdapter) {
        this.mRequestListener.onSuccess(normalRequestAdapter.getOfflineCompoRequest(), normalResultDataAdapter.getOfflineCompoResultData());
    }
}

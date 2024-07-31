package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.network.InterfaceC10421g;
import com.kwad.sdk.core.response.model.BaseResultData;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements InterfaceC10421g<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public /* bridge */ /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
        onError((RequestAdapter) ((RequestAdapter) interfaceC10420f), i, str);
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull InterfaceC10420f interfaceC10420f) {
        onStartRequest((RequestAdapter) ((RequestAdapter) interfaceC10420f));
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10421g
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
        onSuccess((RequestAdapter) ((RequestAdapter) interfaceC10420f), (ResultDataAdapter) ((ResultDataAdapter) baseResultData));
    }

    public void onError(@NonNull RequestAdapter<R> requestAdapter, int i, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
        }
    }

    public void onStartRequest(@NonNull RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
        }
    }

    public void onSuccess(@NonNull RequestAdapter<R> requestAdapter, @NonNull ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
        }
    }
}

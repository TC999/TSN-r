package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements g<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onError(@NonNull f fVar, int i4, String str) {
        onError((RequestAdapter) ((RequestAdapter) fVar), i4, str);
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull f fVar) {
        onStartRequest((RequestAdapter) ((RequestAdapter) fVar));
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
        onSuccess((RequestAdapter) ((RequestAdapter) fVar), (ResultDataAdapter) ((ResultDataAdapter) baseResultData));
    }

    public void onError(@NonNull RequestAdapter<R> requestAdapter, int i4, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i4, str);
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

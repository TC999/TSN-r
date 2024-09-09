package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNormalNetworking;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class NormalNetworkingAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> extends m<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final OfflineCompoNormalNetworking<R, T> mOfflineCompoNetworking;

    public NormalNetworkingAdapter(@NonNull OfflineCompoNormalNetworking<R, T> offlineCompoNormalNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNormalNetworking;
    }

    @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    @NonNull
    public NormalRequestAdapter<R> createRequest() {
        final R createRequest = this.mOfflineCompoNetworking.createRequest();
        return (NormalRequestAdapter<R>) new NormalRequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NormalNetworkingAdapter.1
            @Override // com.kwad.sdk.core.network.f
            public JSONObject getBody() {
                return createRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.f
            public Map<String, String> getBodyMap() {
                return createRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.f
            public Map<String, String> getHeader() {
                return createRequest.getHeader();
            }

            @Override // com.kwad.sdk.core.network.n
            public String getMethod() {
                return createRequest.getMethod();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.NormalRequestAdapter
            public R getOfflineCompoRequest() {
                return (R) createRequest;
            }

            @Override // com.kwad.sdk.core.network.f
            @Nullable
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.f
            public String getUrl() {
                return createRequest.getUrl();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.m
    public NormalResultDataAdapter<T> createResponseData() {
        return new NormalResultDataAdapter<>(this.mOfflineCompoNetworking.createResponseData());
    }
}

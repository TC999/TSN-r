package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NetworkingAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> extends AbstractC10436l<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final OfflineCompoNetworking<R, T> mOfflineCompoNetworking;

    public NetworkingAdapter(@NonNull OfflineCompoNetworking<R, T> offlineCompoNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNetworking;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10436l
    public boolean enableMonitorReport() {
        return this.mOfflineCompoNetworking.enableMonitorReport();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10436l
    public boolean isPostByJson() {
        return this.mOfflineCompoNetworking.isPostByJson();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10436l, com.kwad.sdk.core.network.AbstractC10402a
    public /* bridge */ /* synthetic */ void onResponse(InterfaceC10420f interfaceC10420f, C10415c c10415c) {
        onResponse((RequestAdapter) ((RequestAdapter) interfaceC10420f), c10415c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    @NonNull
    public RequestAdapter<R> createRequest() {
        final R createRequest = this.mOfflineCompoNetworking.createRequest();
        return (RequestAdapter<R>) new RequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter.1
            @Override // com.kwad.sdk.core.network.AbstractC10410b
            public boolean encryptDisable() {
                return createRequest.encryptDisable();
            }

            @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
            public JSONObject getBody() {
                return createRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
            public Map<String, String> getBodyMap() {
                return createRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
            public Map<String, String> getHeader() {
                return createRequest.getHeader();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.RequestAdapter
            public R getOfflineCompoRequest() {
                return (R) createRequest;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10410b
            public String getRequestHost() {
                return createRequest.getRequestHost();
            }

            @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
            @Nullable
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
            public String getUrl() {
                return createRequest.getUrl();
            }
        };
    }

    protected void onResponse(RequestAdapter<R> requestAdapter, C10415c c10415c) {
        super.onResponse((NetworkingAdapter<R, T>) requestAdapter, c10415c);
        this.mOfflineCompoNetworking.onResponse(requestAdapter.getOfflineCompoRequest(), c10415c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.AbstractC10436l
    @NonNull
    public ResultDataAdapter<T> parseData(String str) {
        return new ResultDataAdapter<>(this.mOfflineCompoNetworking.parseData(str));
    }
}

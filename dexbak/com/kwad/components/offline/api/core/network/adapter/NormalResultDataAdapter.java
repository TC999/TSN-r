package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.NormalResultData;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    private final T mOfflineCompoResultData;

    public NormalResultDataAdapter(T t) {
        this.mOfflineCompoResultData = t;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(C10415c c10415c) {
        super.parseResponse(c10415c);
        this.mOfflineCompoResultData.parseResponse(c10415c);
    }
}

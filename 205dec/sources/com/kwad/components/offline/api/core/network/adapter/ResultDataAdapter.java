package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ResultDataAdapter<T extends CommonOfflineCompoResultData> extends BaseResultData {
    private static final long serialVersionUID = -6920968714292152136L;
    private final T mOfflineCompoResultData;

    public ResultDataAdapter(T t3) {
        this.mOfflineCompoResultData = t3;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean hasData() {
        return this.mOfflineCompoResultData.hasData();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return this.mOfflineCompoResultData.isDataEmpty();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isResultOk() {
        return this.mOfflineCompoResultData.isResultOk();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean notifyFailOnResultError() {
        return this.mOfflineCompoResultData.notifyFailOnResultError();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        this.mOfflineCompoResultData.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.merge(json, this.mOfflineCompoResultData.toJson());
        return json;
    }
}

package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.C11126t;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BatchReportResult extends BaseResultData implements InterfaceC9914b {
    private long interval;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getResult() {
        return this.result;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.interval = jSONObject.optLong(UMCommonContent.f37794aX);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        C11126t.putValue(json, UMCommonContent.f37794aX, this.interval);
        return json;
    }
}

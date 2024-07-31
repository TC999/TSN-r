package com.kwad.sdk.crash.report.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CrashReportResult extends BaseResultData implements InterfaceC9914b {
    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getResult() {
        return this.result;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        return super.toJson();
    }
}

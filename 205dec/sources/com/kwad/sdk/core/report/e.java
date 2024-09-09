package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class e extends com.kwad.sdk.core.response.a.a {
    public String actionId;
    private JSONObject mMergeJsonData;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.mMergeJsonData = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mMergeJsonData;
        if (jSONObject2 != null) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }

    public JSONObject buildReportData() {
        JSONObject json = toJson();
        if (this.mMergeJsonData != null) {
            json.remove("mMergeJsonData");
            com.kwad.sdk.utils.u.merge(json, this.mMergeJsonData);
        }
        return json;
    }

    public void setJsonMergeData(JSONObject jSONObject) {
        this.mMergeJsonData = jSONObject;
    }
}

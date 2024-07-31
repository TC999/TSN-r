package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.C11127u;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.report.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10453e extends C10482a {
    public String actionId;
    private JSONObject mMergeJsonData;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.mMergeJsonData = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mMergeJsonData;
        if (jSONObject2 != null) {
            C11126t.putValue(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }

    public JSONObject buildReportData() {
        JSONObject json = toJson();
        if (this.mMergeJsonData != null) {
            json.remove("mMergeJsonData");
            C11127u.merge(json, this.mMergeJsonData);
        }
        return json;
    }

    public void setJsonMergeData(JSONObject jSONObject) {
        this.mMergeJsonData = jSONObject;
    }
}

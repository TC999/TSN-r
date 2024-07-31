package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class BaseRealData extends BaseResultData {
    protected abstract void parseData(@NonNull JSONObject jSONObject);

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = C9889d.getResponseData(jSONObject.optString("data"));
            if (responseData != null && !responseData.isEmpty()) {
                parseData(new JSONObject(responseData));
            } else {
                this.result = 0;
            }
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            this.result = 0;
            this.errorMsg = e.getMessage();
        }
    }
}

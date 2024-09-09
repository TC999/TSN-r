package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class BaseRealData extends BaseResultData {
    protected abstract void parseData(@NonNull JSONObject jSONObject);

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"));
            if (responseData != null && !responseData.isEmpty()) {
                parseData(new JSONObject(responseData));
            } else {
                this.result = 0;
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            this.result = 0;
            this.errorMsg = e4.getMessage();
        }
    }
}

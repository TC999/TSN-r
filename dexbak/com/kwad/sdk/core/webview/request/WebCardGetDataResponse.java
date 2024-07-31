package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WebCardGetDataResponse extends BaseResultData implements InterfaceC9914b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("impAdInfo");
            if (!C11053bg.isNullString(optString)) {
                String responseData = C9889d.getResponseData(optString);
                if (C11053bg.isNullString(responseData)) {
                    return;
                }
                this.impAdInfo = new JSONArray(responseData);
                return;
            }
            String optString2 = jSONObject.optString("data");
            if (C11053bg.isNullString(optString2)) {
                return;
            }
            this.data = new JSONObject(C9889d.getResponseData(optString2));
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            C11126t.putValue(json, "data", jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            C11126t.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}

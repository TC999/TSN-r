package com.kwad.sdk.kgeo;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KGeoResultData extends BaseResultData implements InterfaceC9914b {
    private static final long serialVersionUID = -4058631267047548112L;
    public KGeoInfo kGeoInfo = new KGeoInfo();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = C9889d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            this.kGeoInfo.parseJson(new JSONObject(responseData).optJSONObject("kGeoInfo"));
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        C11126t.m23678a(json, "kGeoInfo", this.kGeoInfo);
        return json;
    }
}

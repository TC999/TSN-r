package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdBitResultData extends AdResultData {
    private static final long serialVersionUID = -3932631606478587475L;
    public List<AdBid> adBidList;
    public String adxId;

    public AdBitResultData(SceneImpl sceneImpl) {
        super(sceneImpl);
        this.adBidList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData, com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            this.adxId = jSONObject.optString("adxId");
            String optString = jSONObject.optString("adBids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(optString);
            if (jSONArray.length() > 0) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        AdBid adBid = new AdBid();
                        adBid.parseJson(optJSONObject);
                        this.adBidList.add(adBid);
                    }
                }
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }
}

package com.kwad.components.p208ad.adbit;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.adbit.AdBitResultData */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdBitResultData extends AdResultData {
    private static final long serialVersionUID = -3932631606478587475L;
    public List<AdBid> adBidList;
    public String adxId;

    public AdBitResultData(SceneImpl sceneImpl) {
        super(sceneImpl);
        this.adBidList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData, com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
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
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AdBid adBid = new AdBid();
                        adBid.parseJson(optJSONObject);
                        this.adBidList.add(adBid);
                    }
                }
            }
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }
}

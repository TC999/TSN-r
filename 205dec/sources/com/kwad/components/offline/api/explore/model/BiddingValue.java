package com.kwad.components.offline.api.explore.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BiddingValue extends BaseOfflineCompoJsonParse<BiddingValue> implements Serializable {
    private static final long serialVersionUID = -6149616231567033423L;
    public double biddingRitCpm;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(BiddingValue biddingValue, JSONObject jSONObject) {
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BiddingValue biddingValue, JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BiddingValue biddingValue) {
        return toJson(biddingValue, (JSONObject) null);
    }
}

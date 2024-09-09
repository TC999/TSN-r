package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MediaModel {
    @JsonNode(key = "ad")
    private AdModel ad;

    public AdModel getAd() {
        return this.ad;
    }

    public void setAd(AdModel adModel) {
        this.ad = adModel;
    }

    public String toString() {
        return "{\"ad\":" + this.ad + '}';
    }
}

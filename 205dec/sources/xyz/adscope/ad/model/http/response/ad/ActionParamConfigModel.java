package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ActionParamConfigModel {
    @JsonNode(key = "cool")
    private String cool;
    @JsonNode(key = "normal")
    private String normal;
    @JsonNode(key = "passivation")
    private String passivation;

    public String getCool() {
        return this.cool;
    }

    public String getNormal() {
        return this.normal;
    }

    public String getPassivation() {
        return this.passivation;
    }

    public void setCool(String str) {
        this.cool = str;
    }

    public void setNormal(String str) {
        this.normal = str;
    }

    public void setPassivation(String str) {
        this.passivation = str;
    }
}

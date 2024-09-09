package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TemplateModel {
    private String adType;
    private String interactionId;
    private String renderId;

    public String getAdType() {
        return this.adType;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public String getRenderId() {
        return this.renderId;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }

    public void setRenderId(String str) {
        this.renderId = str;
    }

    public String toString() {
        return "{\"adType\":\"" + this.adType + "\", \"renderId\":\"" + this.renderId + "\", \"interactionId\":\"" + this.interactionId + "\"}";
    }
}

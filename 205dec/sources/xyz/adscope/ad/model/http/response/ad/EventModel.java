package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EventModel {
    @JsonNode(key = "method")
    private int method;
    @JsonNode(key = "type")
    private int type;
    @JsonNode(key = "url")
    private String url;

    public int getMethod() {
        return this.method;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMethod(int i4) {
        this.method = i4;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}

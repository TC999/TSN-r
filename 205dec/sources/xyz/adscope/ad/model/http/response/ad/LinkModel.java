package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class LinkModel {
    @JsonNode(key = "interact_type")
    private int interact_type;
    @JsonNode(key = "url")
    private String url;
    @JsonNode(key = "urldw")
    private String urldw;
    @JsonNode(key = "urlfb")
    private String urlfb;
    @JsonNode(key = "urlmk")
    private String urlmk;
    @JsonNode(key = "urlulk")
    private String urlulk;

    public int getStyle() {
        return this.interact_type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrldw() {
        return this.urldw;
    }

    public String getUrlfb() {
        return this.urlfb;
    }

    public String getUrlmk() {
        return this.urlmk;
    }

    public String getUrlulk() {
        return this.urlulk;
    }

    public void setStyle(int i4) {
        this.interact_type = i4;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrldw(String str) {
        this.urldw = str;
    }

    public void setUrlfb(String str) {
        this.urlfb = str;
    }

    public void setUrlmk(String str) {
        this.urlmk = str;
    }

    public void setUrlulk(String str) {
        this.urlulk = str;
    }
}

package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ImageModel {
    @JsonNode(key = "h")

    /* renamed from: h  reason: collision with root package name */
    private String f64527h;
    @JsonNode(key = "type")
    private String type;
    @JsonNode(key = "url")
    private String url;
    @JsonNode(key = "w")

    /* renamed from: w  reason: collision with root package name */
    private String f64528w;

    public String getH() {
        return this.f64527h;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getW() {
        return this.f64528w;
    }

    public void setH(String str) {
        this.f64527h = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setW(String str) {
        this.f64528w = str;
    }
}

package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TitleModel {
    @JsonNode(key = "len")
    private String len;
    @JsonNode(key = "text")
    private String text;

    public String getLen() {
        return this.len;
    }

    public String getText() {
        return this.text;
    }

    public void setLen(String str) {
        this.len = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}

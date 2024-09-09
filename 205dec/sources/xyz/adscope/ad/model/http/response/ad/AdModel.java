package xyz.adscope.ad.model.http.response.ad;

import java.util.List;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdModel {
    @JsonNode(key = "adType")
    private String adType;
    @JsonNode(key = "bundle")
    private List<String> bundle;
    @JsonNode(key = "display")
    private DisplayModel display;
    @JsonNode(key = "id")
    private String id;
    @JsonNode(key = "iurl")
    private String iurl;
    @JsonNode(key = "lang")
    private String lang;
    @JsonNode(key = "templateId")
    private int templateId;

    public String getAdType() {
        return this.adType;
    }

    public List<String> getBundle() {
        return this.bundle;
    }

    public DisplayModel getDisplay() {
        return this.display;
    }

    public String getId() {
        return this.id;
    }

    public String getIurl() {
        return this.iurl;
    }

    public String getLang() {
        return this.lang;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setBundle(List<String> list) {
        this.bundle = list;
    }

    public void setDisplay(DisplayModel displayModel) {
        this.display = displayModel;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIurl(String str) {
        this.iurl = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setTemplateId(int i4) {
        this.templateId = i4;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\", \"adType\":\"" + this.adType + "\", \"templateId\":" + this.templateId + ", \"lang\":\"" + this.lang + "\", \"bundle\":" + this.bundle + ", \"iurl\":\"" + this.iurl + "\", \"display\":" + this.display + '}';
    }
}

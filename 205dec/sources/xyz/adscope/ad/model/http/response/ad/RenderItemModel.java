package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RenderItemModel {
    @JsonNode(key = "layout")
    private String layout;
    @JsonNode(key = "reference")
    private String reference;
    private IAdView referenceView;
    @JsonNode(key = "size")
    private String size;

    public String getLayout() {
        return this.layout;
    }

    public String getReference() {
        return this.reference;
    }

    public IAdView getReferenceView() {
        return this.referenceView;
    }

    public String getSize() {
        return this.size;
    }

    public void setLayout(String str) {
        this.layout = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public void setReferenceView(IAdView iAdView) {
        this.referenceView = iAdView;
    }

    public void setSize(String str) {
        this.size = str;
    }
}

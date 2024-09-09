package xyz.adscope.ad.model.http.response.ad;

import java.util.List;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NativeModel {
    @JsonNode(key = "asset")
    private List<AssetModel> asset;
    @JsonNode(key = "dwinfo")
    private DwinfoModel dwinfo;
    @JsonNode(key = "interaction")
    private List<InteractionModel> interaction;
    @JsonNode(key = "interactionId")
    private String interactionId;
    @JsonNode(key = "link")
    private LinkModel link;
    @JsonNode(key = "render")
    private List<RenderModel> render;
    @JsonNode(key = "renderId")
    private String renderId;

    public List<AssetModel> getAsset() {
        return this.asset;
    }

    public DwinfoModel getDwinfo() {
        return this.dwinfo;
    }

    public List<InteractionModel> getInteraction() {
        return this.interaction;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public LinkModel getLink() {
        return this.link;
    }

    public List<RenderModel> getRender() {
        return this.render;
    }

    public String getRenderId() {
        return this.renderId;
    }

    public void setAsset(List<AssetModel> list) {
        this.asset = list;
    }

    public void setDwinfo(DwinfoModel dwinfoModel) {
        this.dwinfo = dwinfoModel;
    }

    public void setInteraction(List<InteractionModel> list) {
        this.interaction = list;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }

    public void setLink(LinkModel linkModel) {
        this.link = linkModel;
    }

    public void setRender(List<RenderModel> list) {
        this.render = list;
    }

    public void setRenderId(String str) {
        this.renderId = str;
    }
}

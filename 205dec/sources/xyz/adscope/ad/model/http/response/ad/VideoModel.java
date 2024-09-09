package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class VideoModel {
    @JsonNode(key = "adm")
    private String adm;
    @JsonNode(key = "curl")
    private String curl;
    @JsonNode(key = "h")

    /* renamed from: h  reason: collision with root package name */
    private String f64529h;
    @JsonNode(key = "replay")
    private String replay;
    @JsonNode(key = "type")
    private String type;
    @JsonNode(key = "url")
    private String url;
    @JsonNode(key = "videoCover")
    private String videoCover;
    @JsonNode(key = "videoDuration")
    private String videoDuration;
    @JsonNode(key = "voiceOn")
    private String voiceOn;
    @JsonNode(key = "w")

    /* renamed from: w  reason: collision with root package name */
    private String f64530w;

    public String getAdm() {
        return this.adm;
    }

    public String getCurl() {
        return this.curl;
    }

    public String getH() {
        return this.f64529h;
    }

    public String getReplay() {
        return this.replay;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVideoCover() {
        return this.videoCover;
    }

    public String getVideoDuration() {
        return this.videoDuration;
    }

    public String getVoiceOn() {
        return this.voiceOn;
    }

    public String getW() {
        return this.f64530w;
    }

    public void setAdm(String str) {
        this.adm = str;
    }

    public void setCurl(String str) {
        this.curl = str;
    }

    public void setH(String str) {
        this.f64529h = str;
    }

    public void setReplay(String str) {
        this.replay = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoCover(String str) {
        this.videoCover = str;
    }

    public void setVideoDuration(String str) {
        this.videoDuration = str;
    }

    public void setVoiceOn(String str) {
        this.voiceOn = str;
    }

    public void setW(String str) {
        this.f64530w = str;
    }
}

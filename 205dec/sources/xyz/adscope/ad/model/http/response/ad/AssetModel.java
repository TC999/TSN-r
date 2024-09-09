package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AssetModel {
    @JsonNode(key = "id")
    private String id;
    @JsonNode(key = "image")
    private ImageModel image;
    @JsonNode(key = "req")
    private int req;
    @JsonNode(key = "title")
    private TitleModel title;
    @JsonNode(key = "video")
    private VideoModel video;

    public String getId() {
        return this.id;
    }

    public ImageModel getImage() {
        return this.image;
    }

    public int getReq() {
        return this.req;
    }

    public TitleModel getTitle() {
        return this.title;
    }

    public VideoModel getVideo() {
        return this.video;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImage(ImageModel imageModel) {
        this.image = imageModel;
    }

    public void setReq(int i4) {
        this.req = i4;
    }

    public void setTitle(TitleModel titleModel) {
        this.title = titleModel;
    }

    public void setVideo(VideoModel videoModel) {
        this.video = videoModel;
    }
}

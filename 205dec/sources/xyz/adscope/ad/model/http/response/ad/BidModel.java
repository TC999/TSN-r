package xyz.adscope.ad.model.http.response.ad;

import com.mbridge.msdk.mbbid.out.BidResponsed;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BidModel {
    @JsonNode(key = "burl")
    private String burl;
    @JsonNode(key = "exp")
    private long exp;
    @JsonNode(key = "id")
    private String id;
    @JsonNode(key = "lurl")
    private String lurl;
    @JsonNode(key = "media")
    private MediaModel media;
    @JsonNode(key = "mid")
    private String mid;
    @JsonNode(key = BidResponsed.KEY_PRICE)
    private double price;
    @JsonNode(key = "purl")
    private String purl;

    public String getBurl() {
        return this.burl;
    }

    public long getExp() {
        return this.exp;
    }

    public String getId() {
        return this.id;
    }

    public String getLurl() {
        return this.lurl;
    }

    public MediaModel getMedia() {
        return this.media;
    }

    public String getMid() {
        return this.mid;
    }

    public double getPrice() {
        return this.price;
    }

    public String getPurl() {
        return this.purl;
    }

    public void setBurl(String str) {
        this.burl = str;
    }

    public void setExp(long j4) {
        this.exp = j4;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLurl(String str) {
        this.lurl = str;
    }

    public void setMedia(MediaModel mediaModel) {
        this.media = mediaModel;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public void setPrice(double d4) {
        this.price = d4;
    }

    public void setPurl(String str) {
        this.purl = str;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\", \"price\":" + this.price + ", \"purl\":\"" + this.purl + "\", \"burl\":\"" + this.burl + "\", \"lurl\":\"" + this.lurl + "\", \"mid\":\"" + this.mid + "\", \"exp\":" + this.exp + ", \"media\":" + this.media + '}';
    }
}

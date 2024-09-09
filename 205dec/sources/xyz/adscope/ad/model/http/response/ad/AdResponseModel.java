package xyz.adscope.ad.model.http.response.ad;

import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdResponseModel {
    @JsonNode(key = "bidid")
    private String bidid;
    @JsonNode(key = BidResponsed.KEY_CUR)
    private List<String> cur;
    @JsonNode(key = "ext")
    private AdResponseExtModel ext;
    @JsonNode(key = "id")
    private String id;
    @JsonNode(key = "nbr")
    private String nbr;
    @JsonNode(key = "seatbid")
    private List<SeatbidModel> seatbid;

    public String getBidid() {
        return this.bidid;
    }

    public List<String> getCur() {
        return this.cur;
    }

    public AdResponseExtModel getExt() {
        return this.ext;
    }

    public String getId() {
        return this.id;
    }

    public String getNbr() {
        return this.nbr;
    }

    public List<SeatbidModel> getSeatbid() {
        return this.seatbid;
    }

    public void setBidid(String str) {
        this.bidid = str;
    }

    public void setCur(List<String> list) {
        this.cur = list;
    }

    public void setExt(AdResponseExtModel adResponseExtModel) {
        this.ext = adResponseExtModel;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNbr(String str) {
        this.nbr = str;
    }

    public void setSeatbid(List<SeatbidModel> list) {
        this.seatbid = list;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\", \"bidid\":\"" + this.bidid + "\", \"nbr\":\"" + this.nbr + "\", \"cur\":" + this.cur + ", \"seatbid\":" + this.seatbid + ", \"ext\":" + this.ext + '}';
    }
}

package xyz.adscope.ad.model.http.response.ad;

import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SeatbidModel {
    @JsonNode(key = BidResponsed.KEY_BID_ID)
    private List<BidModel> bid;
    @JsonNode(key = "ext")
    private String ext;
    @JsonNode(key = "seat")
    private String seat;

    public List<BidModel> getBid() {
        return this.bid;
    }

    public String getExt() {
        return this.ext;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setBid(List<BidModel> list) {
        this.bid = list;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setSeat(String str) {
        this.seat = str;
    }

    public String toString() {
        return "{\"seat\":\"" + this.seat + "\", \"ext\":\"" + this.ext + "\", \"bid\":" + this.bid + '}';
    }
}

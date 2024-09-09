package xyz.adscope.ad.bidding;

import java.util.Map;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.ad.bidding.model.BidTrackModel;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdBidding implements IAdBidding {
    private AdScopeCycleModel adScopeCycleModel;
    private BidModel bidModel;

    public AdBidding(BidModel bidModel, AdScopeCycleModel adScopeCycleModel) {
        this.bidModel = bidModel;
        this.adScopeCycleModel = adScopeCycleModel;
    }

    private void requestGetWithURL(String str, BidTrackModel bidTrackModel) {
        new AdScopeHttpRequest().requestWithGetMethod(AdScopeBidTool.replaceM(str, bidTrackModel), new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.bidding.AdBidding.1
            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str2, int i4) {
                String str3 = Constants.TAG;
                LogUtil.i(str3, "requestGetWithURL failCallback : msg : " + str2 + " , code : " + i4);
            }

            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void successCallback(String str2) {
                String str3 = Constants.TAG;
                LogUtil.i(str3, "requestGetWithURL success : " + str2);
            }
        });
    }

    @Override // xyz.adscope.ad.bidding.inter.IAdBidding
    public int getECPM() {
        BidModel bidModel = this.bidModel;
        if (bidModel != null) {
            return (int) bidModel.getPrice();
        }
        return -1;
    }

    @Override // xyz.adscope.ad.bidding.inter.IAdBidding
    public void loss(Map<String, Object> map) {
        String str;
        String str2 = "";
        if (map == null || !map.containsKey("lossReason")) {
            str = "";
        } else {
            str = map.get("lossReason") + "";
        }
        if (map != null && map.containsKey("winPrice")) {
            str2 = map.get("winPrice") + "";
        }
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            adScopeCycleModel.setIsWin("0");
            this.adScopeCycleModel.setWinPrice(str2);
        }
        BidTrackModel bidTrackModel = new BidTrackModel();
        bidTrackModel.setAuctionLoss(str);
        bidTrackModel.setWinPrice(str2);
        requestGetWithURL(this.bidModel.getLurl(), bidTrackModel);
    }

    @Override // xyz.adscope.ad.bidding.inter.IAdBidding
    public void setBidEcpm(int i4) {
        BidModel bidModel = this.bidModel;
        if (bidModel != null) {
            bidModel.setPrice(i4);
        }
    }

    @Override // xyz.adscope.ad.bidding.inter.IAdBidding
    public void winNotice(Map<String, Object> map) {
        String str;
        String str2;
        if (map == null || !map.containsKey("winPrice")) {
            str = "";
        } else {
            str = map.get("winPrice") + "";
        }
        if (map == null || !map.containsKey("highestLossPrice")) {
            str2 = "";
        } else {
            str2 = map.get("highestLossPrice") + "";
        }
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            adScopeCycleModel.setIsWin("1");
            this.adScopeCycleModel.setWinPrice(str);
        }
        BidTrackModel bidTrackModel = new BidTrackModel();
        bidTrackModel.setWinPrice(str + "");
        bidTrackModel.setHighestLossPrice(str2);
        requestGetWithURL(this.bidModel.getBurl(), bidTrackModel);
    }
}

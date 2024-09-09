package xyz.adscope.ad.bidding;

import android.text.TextUtils;
import xyz.adscope.ad.bidding.model.BidTrackModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeBidTool {
    public static final String auctionLoss = "__AUCTION_LOSS__";
    public static final String highestLossPrice = "__HIGHEST_LOSS_PRICE__";
    public static final String winPrice = "__WIN_PRICE__";

    public static String replaceM(String str, BidTrackModel bidTrackModel) {
        if (TextUtils.isEmpty(str) || bidTrackModel == null) {
            return "";
        }
        if (!TextUtils.isEmpty(bidTrackModel.getAuctionLoss())) {
            str = str.replace(auctionLoss, bidTrackModel.getAuctionLoss());
        }
        if (!TextUtils.isEmpty(bidTrackModel.getWinPrice())) {
            str = str.replace(winPrice, bidTrackModel.getWinPrice());
        }
        return !TextUtils.isEmpty(bidTrackModel.getHighestLossPrice()) ? str.replace(highestLossPrice, bidTrackModel.getHighestLossPrice()) : str;
    }
}

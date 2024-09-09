package xyz.adscope.ad.bidding.inter;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdBidding {
    public static final String ADN_ID = "adnId";
    public static final String EXPECT_COST_PRICE = "expectCostPrice";
    public static final String HIGHEST_LOSS_PRICE = "highestLossPrice";
    public static final String LOSS_REASON = "lossReason";
    public static final String WIN_PRICE = "winPrice";

    int getECPM();

    void loss(Map<String, Object> map);

    void setBidEcpm(int i4);

    void winNotice(Map<String, Object> map);
}

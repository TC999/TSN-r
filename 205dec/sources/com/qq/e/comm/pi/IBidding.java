package com.qq.e.comm.pi;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface IBidding {
    public static final String ADN_ID = "adnId";
    public static final String EXPECT_COST_PRICE = "expectCostPrice";
    public static final String HIGHEST_LOSS_PRICE = "highestLossPrice";
    public static final String LOSS_REASON = "lossReason";
    public static final String WIN_PRICE = "winPrice";

    @Deprecated
    void sendLossNotification(int i4, int i5, String str);

    void sendLossNotification(Map<String, Object> map);

    @Deprecated
    void sendWinNotification(int i4);

    void sendWinNotification(Map<String, Object> map);

    void setBidECPM(int i4);
}

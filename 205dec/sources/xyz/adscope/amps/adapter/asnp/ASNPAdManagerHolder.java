package xyz.adscope.amps.adapter.asnp;

import java.util.HashMap;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPAdManagerHolder {
    public static void sendLossNotification(IAdBidding iAdBidding, int i4, int i5) {
        if (iAdBidding == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK sendLossNotification reason:" + i5);
        HashMap hashMap = new HashMap();
        hashMap.put("lossReason", Integer.valueOf(i5));
        hashMap.put("winPrice", Integer.valueOf(i4));
        hashMap.put("adnId", 2);
        iAdBidding.loss(hashMap);
    }

    public static void sendWinNotification(IAdBidding iAdBidding, int i4) {
        if (iAdBidding == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK sendWinNotification ecpm:" + i4);
        HashMap hashMap = new HashMap();
        hashMap.put("winPrice", Integer.valueOf(i4));
        iAdBidding.winNotice(hashMap);
    }
}

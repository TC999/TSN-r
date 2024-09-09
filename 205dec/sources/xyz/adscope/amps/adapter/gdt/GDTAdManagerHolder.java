package xyz.adscope.amps.adapter.gdt;

import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GDTAdManagerHolder {
    public static String getGDTBidSdkInfo(String str) {
        try {
            return GDTAdSdk.getGDTAdManger().getSDKInfo(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getGDTBidToken() {
        try {
            return GDTAdSdk.getGDTAdManger().getBuyerId(null);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static void sendLossNotification(IBidding iBidding, int i4) {
        if (iBidding == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK sendLossNotification reason:" + i4);
        int i5 = 2;
        if (i4 == 1) {
            i5 = 1;
        } else if (i4 != 2) {
            i5 = 10001;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lossReason", Integer.valueOf(i5));
        hashMap.put("adnId", 3);
        iBidding.sendWinNotification(hashMap);
    }

    public static void sendWinNotification(IBidding iBidding, int i4) {
        if (iBidding == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK sendWinNotification ecpm:" + i4);
        HashMap hashMap = new HashMap();
        hashMap.put("expectCostPrice", Integer.valueOf(i4));
        hashMap.put("highestLossPrice", Integer.valueOf(i4 + (-1)));
        iBidding.sendWinNotification(hashMap);
    }
}

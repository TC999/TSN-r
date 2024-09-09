package com.beizi.fusion.d;

import android.content.Context;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GDTAdManagerHolder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14664a;

    public static void a(Context context, String str) {
        try {
            if (BeiZis.getCustomController() != null) {
                boolean isCanUsePhoneState = BeiZis.getCustomController().isCanUsePhoneState();
                GlobalSetting.setAgreeReadAndroidId(isCanUsePhoneState);
                GlobalSetting.setAgreeReadDeviceId(isCanUsePhoneState);
                if (!BeiZis.getCustomController().isCanUseAppList()) {
                    GlobalSetting.setEnableCollectAppInstallStatus(false);
                }
            }
            if (BeiZis.isCloseShakeAd()) {
                HashMap hashMap = new HashMap();
                hashMap.put("shakable", "0");
                GlobalSetting.setExtraUserData(hashMap);
            }
            GDTAdSdk.initWithoutStart(context, str);
            GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.beizi.fusion.d.k.1
                @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                public void onStartFailed(Exception exc) {
                    af.c("BeiZis", "GDTAdManagerHolder initWith() onStartFailed e : " + exc);
                }

                @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                public void onStartSuccess() {
                    af.c("BeiZis", "GDTAdManagerHolder initWith() onStartSuccess ");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str) {
        d(context, str);
    }

    public static String c(Context context, String str) {
        try {
            if (aw.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
                b(context, str);
                return GDTAdSdk.getGDTAdManger().getBuyerId(null);
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static void d(Context context, String str) {
        if (f14664a) {
            return;
        }
        try {
            a(context, str);
            f14664a = true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void b(IBidding iBidding, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("lossReason", Integer.valueOf(i4));
        hashMap.put("adnId", 3);
        iBidding.sendWinNotification(hashMap);
    }

    public static String a(Context context, String str, String str2) {
        try {
            if (aw.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
                b(context, str);
                return GDTAdSdk.getGDTAdManger().getSDKInfo(str2);
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static void a(IBidding iBidding, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("expectCostPrice", Integer.valueOf(i4));
        hashMap.put("highestLossPrice", Integer.valueOf(i4 - 1));
        iBidding.sendWinNotification(hashMap);
    }
}

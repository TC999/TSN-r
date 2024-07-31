package com.beizi.fusion.p066d;

import android.content.Context;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.p518qq.p519e.comm.managers.GDTAdSdk;
import com.p518qq.p519e.comm.managers.setting.GlobalSetting;
import com.p518qq.p519e.comm.p520pi.IBidding;
import java.util.HashMap;

/* renamed from: com.beizi.fusion.d.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GDTAdManagerHolder {

    /* renamed from: a */
    private static boolean f11147a;

    /* renamed from: a */
    public static void m48638a(Context context, String str) {
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
                @Override // com.p518qq.p519e.comm.managers.GDTAdSdk.OnStartListener
                public void onStartFailed(Exception exc) {
                    C3116af.m48494c("BeiZis", "GDTAdManagerHolder initWith() onStartFailed e : " + exc);
                }

                @Override // com.p518qq.p519e.comm.managers.GDTAdSdk.OnStartListener
                public void onStartSuccess() {
                    C3116af.m48494c("BeiZis", "GDTAdManagerHolder initWith() onStartSuccess ");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m48635b(Context context, String str) {
        m48632d(context, str);
    }

    /* renamed from: c */
    public static String m48633c(Context context, String str) {
        try {
            if (C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
                m48635b(context, str);
                return GDTAdSdk.getGDTAdManger().getBuyerId(null);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static void m48632d(Context context, String str) {
        if (f11147a) {
            return;
        }
        try {
            m48638a(context, str);
            f11147a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m48634b(IBidding iBidding, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.LOSS_REASON, Integer.valueOf(i));
        hashMap.put(IBidding.ADN_ID, 3);
        iBidding.sendWinNotification(hashMap);
    }

    /* renamed from: a */
    public static String m48637a(Context context, String str, String str2) {
        try {
            if (C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
                m48635b(context, str);
                return GDTAdSdk.getGDTAdManger().getSDKInfo(str2);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m48636a(IBidding iBidding, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(i));
        hashMap.put(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf(i - 1));
        iBidding.sendWinNotification(hashMap);
    }
}

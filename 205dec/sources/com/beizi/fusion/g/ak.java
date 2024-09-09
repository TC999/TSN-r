package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.beizi.ad.BeiZi;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.kwad.sdk.api.KsAdSDK;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PersonalizedUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ak {
    public static void a(boolean z3) {
        try {
            if (!z3) {
                try {
                    GlobalSetting.setPersonalizedState(1);
                } catch (Throwable unused) {
                }
                try {
                    com.beizi.fusion.d.u.a(true);
                } catch (Throwable unused2) {
                }
                try {
                    KsAdSDK.setPersonalRecommend(false);
                } catch (Throwable unused3) {
                }
                try {
                    MobadsPermissionSettings.setLimitPersonalAds(true);
                } catch (Throwable unused4) {
                }
                try {
                    BeiZi.setLimitPersonalAds(true);
                } catch (Throwable unused5) {
                }
                BeiZis.setLimitPersonalAds(true);
                if (com.beizi.fusion.d.b.a().e() == null || !b()) {
                    return;
                }
                if (RequestInfo.getInstance(com.beizi.fusion.d.b.a().e()).getDevInfo() != null && !TextUtils.isEmpty(RequestInfo.getInstance(com.beizi.fusion.d.b.a().e()).getDevInfo().getOaid())) {
                    RequestInfo.getInstance(com.beizi.fusion.d.b.a().e()).getDevInfo().setOaid("");
                }
                if (RequestInfo.getInstance(com.beizi.fusion.d.b.a().e()).getDevInfo() == null || TextUtils.isEmpty(RequestInfo.getInstance(com.beizi.fusion.d.b.a().e()).getDevInfo().getHonorOaid())) {
                    return;
                }
                RequestInfo.getInstance(com.beizi.fusion.d.b.a().e()).getDevInfo().setHonorOaid("");
                return;
            }
            try {
                GlobalSetting.setPersonalizedState(0);
            } catch (Throwable unused6) {
            }
            try {
                com.beizi.fusion.d.u.a(false);
            } catch (Throwable unused7) {
            }
            try {
                KsAdSDK.setPersonalRecommend(true);
            } catch (Throwable unused8) {
            }
            try {
                MobadsPermissionSettings.setLimitPersonalAds(false);
            } catch (Throwable unused9) {
            }
            try {
                BeiZi.setLimitPersonalAds(false);
            } catch (Throwable unused10) {
            }
            BeiZis.setLimitPersonalAds(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean b() {
        int c4 = c();
        return c4 == 0 || c4 == 2;
    }

    private static int c() {
        Context e4 = com.beizi.fusion.d.b.a().e();
        if (e4 != null) {
            if (!ResponseInfo.getInstance(e4).isInit()) {
                ResponseInfo.getInstance(e4).init();
            }
            Manager manager = ResponseInfo.getInstance(e4).getManager();
            if (manager != null) {
                return manager.getPersonalRecommend();
            }
        }
        return 0;
    }

    public static boolean a() {
        int c4 = c();
        boolean isLimitPersonalAds = BeiZis.isLimitPersonalAds();
        if (c4 == 0 || c4 == 2) {
            return isLimitPersonalAds;
        }
        return false;
    }
}

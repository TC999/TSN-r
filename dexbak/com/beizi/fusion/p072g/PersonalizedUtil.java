package com.beizi.fusion.p072g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.p051ad.BeiZi;
import com.kwad.sdk.api.KsAdSDK;
import com.p518qq.p519e.comm.managers.setting.GlobalSetting;

/* renamed from: com.beizi.fusion.g.aj */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PersonalizedUtil {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007c -> B:28:0x007f). Please submit an issue!!! */
    /* renamed from: a */
    public static void m48443a(boolean z) {
        try {
            if (!z) {
                try {
                    GlobalSetting.setPersonalizedState(1);
                } catch (Throwable unused) {
                }
                try {
                    TTAdManagerHolder.m48589a(true);
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
                if (AdManager.m48786a().m48778e() == null || !m48442b() || RequestInfo.getInstance(AdManager.m48786a().m48778e()).getDevInfo() == null || TextUtils.isEmpty(RequestInfo.getInstance(AdManager.m48786a().m48778e()).getDevInfo().getOaid())) {
                    return;
                }
                RequestInfo.getInstance(AdManager.m48786a().m48778e()).getDevInfo().setOaid("");
                return;
            }
            try {
                GlobalSetting.setPersonalizedState(0);
            } catch (Throwable unused6) {
            }
            try {
                TTAdManagerHolder.m48589a(false);
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
            while (true) {
                th.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: b */
    public static boolean m48442b() {
        int m48441c = m48441c();
        return m48441c == 0 || m48441c == 2;
    }

    /* renamed from: c */
    private static int m48441c() {
        Context m48778e = AdManager.m48786a().m48778e();
        if (m48778e != null) {
            if (!ResponseInfo.getInstance(m48778e).isInit()) {
                ResponseInfo.getInstance(m48778e).init();
            }
            Manager manager = ResponseInfo.getInstance(m48778e).getManager();
            if (manager != null) {
                return manager.getPersonalRecommend();
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static boolean m48444a() {
        int m48441c = m48441c();
        boolean isLimitPersonalAds = BeiZis.isLimitPersonalAds();
        if (m48441c == 0 || m48441c == 2) {
            return isLimitPersonalAds;
        }
        return false;
    }
}

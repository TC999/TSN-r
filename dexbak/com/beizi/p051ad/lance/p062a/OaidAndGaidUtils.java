package com.beizi.p051ad.lance.p062a;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.p051ad.BeiZi;
import com.beizi.p051ad.internal.utilities.SPUtils;

/* renamed from: com.beizi.ad.lance.a.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OaidAndGaidUtils {
    /* renamed from: a */
    public static String m49042a(Context context) {
        String stringFromFusionSdk;
        if (context == null) {
            return "";
        }
        String devOaid = BeiZi.getCustomController() != null ? BeiZi.getCustomController().getDevOaid() : null;
        return !TextUtils.isEmpty(devOaid) ? devOaid : ((BeiZi.getCustomController() == null || (!BeiZi.isLimitPersonalAds() && BeiZi.getCustomController().isCanUseOaid())) && (stringFromFusionSdk = SPUtils.getStringFromFusionSdk(context, "__OAID__")) != null) ? stringFromFusionSdk : "";
    }

    /* renamed from: b */
    public static String m49041b(Context context) {
        String stringFromFusionSdk;
        return context == null ? "" : ((BeiZi.getCustomController() == null || (!BeiZi.isLimitPersonalAds() && BeiZi.getCustomController().isCanUseGaid())) && (stringFromFusionSdk = SPUtils.getStringFromFusionSdk(context, "__GAID__")) != null) ? stringFromFusionSdk : "";
    }
}

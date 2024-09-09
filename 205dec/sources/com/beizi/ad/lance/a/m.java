package com.beizi.ad.lance.a;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.BeiZi;
import com.beizi.ad.internal.utilities.SPUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OaidAndGaidUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class m {
    public static String a(Context context) {
        String stringFromFusionSdk;
        if (context == null) {
            return "";
        }
        String devOaid = BeiZi.getCustomController() != null ? BeiZi.getCustomController().getDevOaid() : null;
        return !TextUtils.isEmpty(devOaid) ? devOaid : ((BeiZi.getCustomController() == null || (!BeiZi.isLimitPersonalAds() && BeiZi.getCustomController().isCanUseOaid())) && (stringFromFusionSdk = SPUtils.getStringFromFusionSdk(context, "__OAID__")) != null) ? stringFromFusionSdk : "";
    }

    public static String b(Context context) {
        String stringFromFusionSdk;
        return context == null ? "" : ((BeiZi.getCustomController() == null || (!BeiZi.isLimitPersonalAds() && BeiZi.getCustomController().isCanUseOaid())) && (stringFromFusionSdk = SPUtils.getStringFromFusionSdk(context, "__HONOROAID__")) != null) ? stringFromFusionSdk : "";
    }

    public static String c(Context context) {
        String stringFromFusionSdk;
        return context == null ? "" : ((BeiZi.getCustomController() == null || (!BeiZi.isLimitPersonalAds() && BeiZi.getCustomController().isCanUseGaid())) && (stringFromFusionSdk = SPUtils.getStringFromFusionSdk(context, "__GAID__")) != null) ? stringFromFusionSdk : "";
    }
}

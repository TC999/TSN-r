package com.beizi.fusion.p066d;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.AdPlusConfig;
import com.beizi.fusion.model.IncentiveConfig;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.C3144f;
import com.beizi.fusion.p072g.PersonalizedUtil;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.p051ad.BeiZi;
import com.beizi.p051ad.BeiZiAdSdkController;
import com.stub.StubApp;
import java.util.HashMap;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.fusion.d.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class selfAdManagerHolder {

    /* renamed from: a */
    private static boolean f11166a;

    /* renamed from: a */
    public static void m48575a(Context context, String str) {
        try {
            m48574b(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private static void m48574b(final Context context, String str) {
        if (f11166a) {
            return;
        }
        try {
            m48577a(context);
            BeiZi.init(context, str, new BeiZiAdSdkController() { // from class: com.beizi.fusion.d.w.1
                @Override // com.beizi.p051ad.BeiZiAdSdkController
                public String getDevOaid() {
                    try {
                        if (RequestInfo.getInstance(context).getDevInfo() != null) {
                            String oaid = RequestInfo.getInstance(context).getDevInfo().getOaid();
                            if (!TextUtils.isEmpty(oaid)) {
                                return oaid;
                            }
                            String customOaid = RequestInfo.getInstance(context).getCustomOaid();
                            if (!TextUtils.isEmpty(customOaid)) {
                                return customOaid;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return super.getDevOaid();
                }

                @Override // com.beizi.p051ad.BeiZiAdSdkController
                public boolean isCanUseGaid() {
                    if (BeiZis.getCustomController() != null) {
                        return !PersonalizedUtil.m48444a() && BeiZis.getCustomController().isCanUseGaid();
                    }
                    return super.isCanUseGaid();
                }

                @Override // com.beizi.p051ad.BeiZiAdSdkController
                public boolean isCanUseLocation() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseLocation();
                    }
                    return super.isCanUseLocation();
                }

                @Override // com.beizi.p051ad.BeiZiAdSdkController
                public boolean isCanUseOaid() {
                    if (BeiZis.getCustomController() != null) {
                        return !PersonalizedUtil.m48444a() && BeiZis.getCustomController().isCanUseOaid();
                    }
                    return super.isCanUseOaid();
                }

                @Override // com.beizi.p051ad.BeiZiAdSdkController
                public boolean isCanUsePhoneState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUsePhoneState();
                    }
                    return super.isCanUsePhoneState();
                }

                @Override // com.beizi.p051ad.BeiZiAdSdkController
                public boolean isCanUseWifiState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseWifiState();
                    }
                    return super.isCanUseWifiState();
                }
            });
            f11166a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m48577a(Context context) {
        String m48267a;
        try {
            if (C3138av.m48301a("com.beizi.ad.BeiZi")) {
                AdPlusConfig adPlusConfig = ResponseInfo.getInstance(context).getAdPlusConfig();
                if (adPlusConfig != null && !TextUtils.isEmpty(adPlusConfig.getAdUrl()) && adPlusConfig.getAdUrl().startsWith(IDataSource.f43971a)) {
                    m48267a = adPlusConfig.getAdUrl();
                } else {
                    m48267a = C3144f.m48267a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGswL2pzb24=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3NkazAvanNvbg==");
                    if (TextUtils.isEmpty(m48267a)) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(m48267a)) {
                    return;
                }
                BeiZi.setAdRequestUrl(m48267a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m48576a(Context context, IncentiveConfig incentiveConfig) {
        if (incentiveConfig != null) {
            HashMap hashMap = new HashMap();
            String m48311a = StringUtil.m48311a(context, incentiveConfig.getMacro());
            hashMap.put("configVersion", incentiveConfig.getConfigVersion());
            hashMap.put("macro", m48311a);
            hashMap.put("rtaUrl", incentiveConfig.getRtaUrl());
            hashMap.put("userInfoUrl", incentiveConfig.getUserInfoUrl());
            hashMap.put("authUrl", incentiveConfig.getAuthUrl());
            hashMap.put("transferUrl", incentiveConfig.getTransferUrl());
            hashMap.put("appId", AdManager.m48786a().m48782b());
            BeiZi.setIncentiveConfig(hashMap);
        }
    }
}

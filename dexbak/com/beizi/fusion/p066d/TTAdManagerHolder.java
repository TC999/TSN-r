package com.beizi.fusion.p066d;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.d.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TTAdManagerHolder {

    /* renamed from: a */
    private static boolean f11163a;

    /* renamed from: b */
    private static ConcurrentHashMap<String, AdWorker> f11164b;

    /* renamed from: a */
    public static TTAdManager m48594a() {
        if (!TTAdSdk.isSdkReady()) {
            C3116af.m48494c("BeiZis", "TTAdSdk is not init or init fail, please check.");
        }
        return TTAdSdk.getAdManager();
    }

    /* renamed from: c */
    private static String m48585c() {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            if (f11163a) {
                jSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, "0");
            } else {
                jSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, "1");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "is_shake_ads");
            if (BeiZis.isCloseShakeAd()) {
                jSONObject2.put(DomainCampaignEx.LOOPBACK_VALUE, "0");
            } else {
                jSONObject2.put(DomainCampaignEx.LOOPBACK_VALUE, "1");
            }
            jSONArray.put(jSONObject);
            jSONArray.put(jSONObject2);
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public static void m48587b(AdWorker adWorker, Context context, String str, int i) {
        m48591a(adWorker, context, str, i, true);
    }

    /* renamed from: b */
    private static String m48586b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "is_shake_ads");
            if (BeiZis.isCloseShakeAd()) {
                jSONObject2.put(DomainCampaignEx.LOOPBACK_VALUE, "0");
            } else {
                jSONObject2.put(DomainCampaignEx.LOOPBACK_VALUE, "1");
            }
            jSONArray.put(jSONObject2);
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static void m48592a(AdWorker adWorker, Context context, String str, int i) {
        m48591a(adWorker, context, str, i, false);
    }

    /* renamed from: a */
    private static void m48591a(AdWorker adWorker, Context context, String str, int i, boolean z) {
        try {
            if (TTAdSdk.isSdkReady()) {
                if (adWorker != null) {
                    C3116af.m48495b("BeiZis", "TTAdManagerHolder.isInitSuccess success ");
                    adWorker.mo46297ay();
                    return;
                }
                return;
            }
            if (f11164b == null) {
                f11164b = new ConcurrentHashMap<>();
            }
            if (adWorker != null) {
                AdSpacesBean.BuyerBean mo46052k = adWorker.mo46052k();
                f11164b.put(mo46052k != null ? mo46052k.getSpaceId() : null, adWorker);
            }
            TTAdSdk.init(context, m48593a(context, str, i, z));
            TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.beizi.fusion.d.u.1
                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void fail(int i2, String str2) {
                    try {
                        for (AdWorker adWorker2 : TTAdManagerHolder.f11164b.values()) {
                            adWorker2.m47926ax();
                            String str3 = null;
                            AdSpacesBean.BuyerBean mo46052k2 = adWorker2.mo46052k();
                            if (mo46052k2 != null) {
                                str3 = mo46052k2.getSpaceId();
                            }
                            TTAdManagerHolder.f11164b.remove(str3);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    Log.i("BeiZis", "TTAdManagerHolder.doInit().init() i:" + i2 + " s:" + str2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void success() {
                    C3116af.m48494c("BeiZis", "TTAdManagerHolder.doInit().init() success ");
                    synchronized (this) {
                        try {
                            for (AdWorker adWorker2 : TTAdManagerHolder.f11164b.values()) {
                                adWorker2.mo46297ay();
                                String str2 = null;
                                AdSpacesBean.BuyerBean mo46052k2 = adWorker2.mo46052k();
                                if (mo46052k2 != null) {
                                    str2 = mo46052k2.getSpaceId();
                                }
                                TTAdManagerHolder.f11164b.remove(str2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static TTAdConfig m48593a(Context context, String str, int i, boolean z) {
        try {
            return new TTAdConfig.Builder().appId(str).useTextureView(true).appName(C3138av.m48292f(context)).titleBarTheme(1).allowShowNotify(true).data(m48585c()).useMediation(z).customController(new TTCustomController() { // from class: com.beizi.fusion.d.u.2
                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean alist() {
                    if (BeiZis.getCustomController() == null || BeiZis.getCustomController().isCanUseAppList()) {
                        return super.alist();
                    }
                    return false;
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUseLocation() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseLocation();
                    }
                    return super.isCanUseLocation();
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUsePhoneState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUsePhoneState();
                    }
                    return super.isCanUsePhoneState();
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUseWifiState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseWifiState();
                    }
                    return super.isCanUseWifiState();
                }
            }).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m48589a(boolean z) {
        f11163a = z;
        if (z) {
            m48590a("0");
        } else {
            m48590a("1");
        }
    }

    /* renamed from: a */
    private static void m48590a(String str) {
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(m48586b(str)).build());
    }
}

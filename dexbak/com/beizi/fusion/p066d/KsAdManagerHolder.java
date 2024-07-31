package com.beizi.fusion.p066d;

import android.content.Context;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.p072g.C3138av;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;

/* renamed from: com.beizi.fusion.d.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsAdManagerHolder {

    /* renamed from: a */
    private static boolean f11152a;

    /* renamed from: a */
    public static void m48622a(Context context, String str) {
        m48620c(context, str);
    }

    /* renamed from: b */
    public static String m48621b(Context context, String str) {
        try {
            if (C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
                m48622a(context, str);
                KsScene build = new KsScene.Builder(Long.parseLong(str)).build();
                KsLoadManager loadManager = KsAdSDK.getLoadManager();
                if (loadManager == null) {
                    return null;
                }
                return loadManager.getBidRequestToken(build);
            }
            return null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private static void m48620c(Context context, String str) {
        if (f11152a) {
            return;
        }
        try {
            KsAdSDK.init(context, new SdkConfig.Builder().appId(str).canReadNearbyWifiList(BeiZis.getCustomController() != null ? BeiZis.getCustomController().isCanUseWifiState() : true).customController(new KsCustomController() { // from class: com.beizi.fusion.d.n.1
                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canReadInstalledPackages() {
                    if (BeiZis.getCustomController() == null || BeiZis.getCustomController().isCanUseAppList()) {
                        return super.canReadInstalledPackages();
                    }
                    return false;
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canReadLocation() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseLocation();
                    }
                    return super.canReadLocation();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseMacAddress() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseWifiState();
                    }
                    return super.canUseMacAddress();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseNetworkState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseWifiState();
                    }
                    return super.canUseNetworkState();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseOaid() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseOaid();
                    }
                    return super.canUseOaid();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUsePhoneState() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUsePhoneState();
                    }
                    return super.canUsePhoneState();
                }
            }).showNotification(true).build());
            f11152a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

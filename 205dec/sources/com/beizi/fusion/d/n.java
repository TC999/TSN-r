package com.beizi.fusion.d;

import android.content.Context;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.aw;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: KsAdManagerHolder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14669a;

    public static void a(Context context, String str) {
        c(context, str);
    }

    public static String b(Context context, String str) {
        try {
            if (aw.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
                a(context, str);
                KsScene build = new KsScene.Builder(Long.parseLong(str)).build();
                KsLoadManager loadManager = KsAdSDK.getLoadManager();
                if (loadManager == null) {
                    return null;
                }
                return loadManager.getBidRequestToken(build);
            }
            return null;
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static void c(Context context, String str) {
        if (f14669a) {
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
            f14669a = true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}

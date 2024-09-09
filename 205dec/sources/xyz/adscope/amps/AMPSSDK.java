package xyz.adscope.amps;

import android.content.Context;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.manager.AMPSSDKManager;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMPSSDK {
    public static Context getContext() {
        return AMPSSDKManager.getInstance().getContext();
    }

    public static AMPSInitConfig getInitConfig() {
        return AMPSSDKManager.getInstance().getAMPSAdConfig();
    }

    public static String getSdkVersion() {
        return AMPSSDKManager.getInstance().getSdkVersion();
    }

    public static void init(Context context, AMPSInitConfig aMPSInitConfig, IAMPSInitCallback iAMPSInitCallback) {
        AMPSSDKManager.getInstance().initialize(context, aMPSInitConfig, iAMPSInitCallback);
    }

    public static AMPSEnum.AMPSSDKInitStatus sdkInitStatus() {
        return AMPSSDKManager.getInstance().sdkInitStatus();
    }

    public static void setPersonalRecommend(boolean z3) {
        AMPSInitConfig aMPSAdConfig = AMPSSDKManager.getInstance().getAMPSAdConfig();
        if (aMPSAdConfig != null) {
            aMPSAdConfig.setPersonalRecommend(z3);
        }
    }

    public static void updatePrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        AMPSSDKManager.getInstance().setAMPSPrivacyConfig(aMPSPrivacyConfig);
    }
}

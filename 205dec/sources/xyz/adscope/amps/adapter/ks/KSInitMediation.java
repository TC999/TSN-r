package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class KSInitMediation extends AMPSChannelInitMediation {
    private static KSInitMediation instance;
    private boolean isInit = false;
    private boolean isCanUseShakeAd = true;

    public static synchronized KSInitMediation getInstance() {
        KSInitMediation kSInitMediation;
        synchronized (KSInitMediation.class) {
            if (instance == null) {
                synchronized (KSInitMediation.class) {
                    instance = new KSInitMediation();
                }
            }
            kSInitMediation = instance;
        }
        return kSInitMediation;
    }

    private void initKSSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        boolean z3;
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        final AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
        if (privacyConfig != null) {
            z3 = privacyConfig.isCanUseWifiState();
            this.isCanUseShakeAd = privacyConfig.isCanUseShakeAd();
        } else {
            z3 = true;
        }
        if (!aMPSInitAdapterConfig.isPersonalRecommend()) {
            KsAdSDK.setPersonalRecommend(false);
        }
        KsAdSDK.init(context, new SdkConfig.Builder().appId(aMPSInitAdapterConfig.getAppId()).appName(aMPSInitAdapterConfig.getAppName()).canReadNearbyWifiList(z3).customController(new KsCustomController() { // from class: xyz.adscope.amps.adapter.ks.KSInitMediation.1
            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseAppList() : super.canReadInstalledPackages();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseLocation() : super.canReadLocation();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWifiState() : super.canUseMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWifiState() : super.canUseNetworkState();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseOaid() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseOaid() : super.canUseOaid();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUsePhoneState() : super.canUsePhoneState();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWriteExternal() : super.canUseStoragePermission();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getAndroidId() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.getAndroidId() : super.getAndroidId();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public List<String> getInstalledPackages() {
                try {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null) {
                        List<PackageInfo> appList = aMPSPrivacyConfig.getAppList();
                        ArrayList arrayList = new ArrayList();
                        if (appList != null && appList.size() > 0) {
                            for (int i4 = 0; i4 < appList.size(); i4++) {
                                arrayList.add(appList.get(i4).packageName);
                            }
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return super.getInstalledPackages();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getMacAddress() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.getMacAddress() : super.getMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getOaid() {
                AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.getDevOaid() : super.getOaid();
            }
        }).showNotification(true).build());
        KsAdSDK.start();
        this.isInit = true;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK init success");
        initSDKSuccess(iAMPSChannelInitCallBack);
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return "KS";
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return KsAdSDK.getSDKVersion();
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initKSSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    public boolean isCanUseShakeAd() {
        return this.isCanUseShakeAd;
    }
}

package xyz.adscope.amps.adapter.bz;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZiCustomController;
import com.beizi.fusion.BeiZis;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BZInitMediation extends AMPSChannelInitMediation {
    private static BZInitMediation instance;
    private boolean isInit = false;

    public static synchronized BZInitMediation getInstance() {
        BZInitMediation bZInitMediation;
        synchronized (BZInitMediation.class) {
            if (instance == null) {
                synchronized (BZInitMediation.class) {
                    instance = new BZInitMediation();
                }
            }
            bZInitMediation = instance;
        }
        return bZInitMediation;
    }

    private void initBZSDK(final AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        BeiZis.init(context, aMPSInitAdapterConfig.getAppId(), new BeiZiCustomController() { // from class: xyz.adscope.amps.adapter.bz.BZInitMediation.1
            @Override // com.beizi.fusion.BeiZiCustomController
            public String getDevOaid() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().getDevOaid() : super.getDevOaid();
            }

            @Override // com.beizi.fusion.BeiZiCustomController
            public boolean isCanUseLocation() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUseLocation() : super.isCanUseLocation();
            }

            @Override // com.beizi.fusion.BeiZiCustomController
            public boolean isCanUseOaid() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUseOaid() : super.isCanUseOaid();
            }

            @Override // com.beizi.fusion.BeiZiCustomController
            public boolean isCanUsePhoneState() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUsePhoneState() : super.isCanUsePhoneState();
            }

            @Override // com.beizi.fusion.BeiZiCustomController
            public boolean isCanUseWifiState() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUseWifiState() : super.isCanUseWifiState();
            }
        });
        if (!aMPSInitAdapterConfig.isPersonalRecommend()) {
            BeiZis.setLimitPersonalAds(false);
        }
        this.isInit = true;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK init success");
        initSDKSuccess(iAMPSChannelInitCallBack);
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_BZ;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return BeiZis.getSdkVersion();
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_BZ_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initBZSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }
}

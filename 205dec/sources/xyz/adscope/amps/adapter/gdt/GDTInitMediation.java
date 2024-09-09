package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.HashMap;
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
public class GDTInitMediation extends AMPSChannelInitMediation {
    private static final int GDT_PERSONAL_RECOMMEND_CLOSE = 1;
    private static final int GDT_PERSONAL_RECOMMEND_OPEN = 0;
    private static GDTInitMediation instance;
    private boolean isInit = false;

    public static synchronized GDTInitMediation getInstance() {
        GDTInitMediation gDTInitMediation;
        synchronized (GDTInitMediation.class) {
            if (instance == null) {
                synchronized (GDTInitMediation.class) {
                    instance = new GDTInitMediation();
                }
            }
            gDTInitMediation = instance;
        }
        return gDTInitMediation;
    }

    private void initGDTSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
        if (privacyConfig != null) {
            boolean isCanUseAndroidId = privacyConfig.isCanUseAndroidId();
            GlobalSetting.setAgreeReadAndroidId(isCanUseAndroidId);
            GlobalSetting.setAgreeReadDeviceId(isCanUseAndroidId);
            GlobalSetting.setEnableCollectAppInstallStatus(privacyConfig.isCanUseAppList());
            if (!privacyConfig.isCanUseShakeAd()) {
                HashMap hashMap = new HashMap();
                hashMap.put("shakable", "0");
                GlobalSetting.setExtraUserData(hashMap);
            }
        }
        String appId = aMPSInitAdapterConfig.getAppId();
        GlobalSetting.setPersonalizedState(!aMPSInitAdapterConfig.isPersonalRecommend());
        GDTAdSdk.initWithoutStart(context, appId);
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTInitMediation.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
            }
        });
        this.isInit = true;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK init success");
        initSDKSuccess(iAMPSChannelInitCallBack);
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return SDKStatus.getIntegrationSDKVersion();
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initGDTSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }
}

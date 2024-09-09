package xyz.adscope.amps.adapter.asnp;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.config.AdscopeCustomController;
import xyz.adscope.ad.init.inter.InitCallback;
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
public class ASNPInitMediation extends AMPSChannelInitMediation {
    private static ASNPInitMediation instance;
    private static List<IAMPSChannelInitCallBack> mCallBackList = new ArrayList();
    private boolean isInit = false;
    private boolean isInitIng = false;

    public static synchronized ASNPInitMediation getInstance() {
        ASNPInitMediation aSNPInitMediation;
        synchronized (ASNPInitMediation.class) {
            if (instance == null) {
                synchronized (ASNPInitMediation.class) {
                    instance = new ASNPInitMediation();
                }
            }
            aSNPInitMediation = instance;
        }
        return aSNPInitMediation;
    }

    private void initASNPSDK(final AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            this.isInitIng = false;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        String appId = aMPSInitAdapterConfig.getAppId();
        HashMap hashMap = new HashMap();
        hashMap.put("school", "university");
        AdScopeSDK.Singleton.INSTANCE.init(context, new AdInitConfig.Builder().appId(appId).apiKey("AdScopeADN").isSyncInit(false).userId(aMPSInitAdapterConfig.getUserId()).optionalFields(hashMap).setAdscopeCustomController(new AdscopeCustomController() { // from class: xyz.adscope.amps.adapter.asnp.ASNPInitMediation.1
            @Override // xyz.adscope.ad.config.AdscopeCustomController
            public String getOaid() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().getDevOaid() : super.getOaid();
            }

            @Override // xyz.adscope.ad.config.AdscopeCustomController
            public boolean isCanUsePhoneState() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUsePhoneState() : super.isCanUsePhoneState();
            }

            @Override // xyz.adscope.ad.config.AdscopeCustomController
            public boolean isSupportPersonalized() {
                AMPSInitAdapterConfig aMPSInitAdapterConfig2 = aMPSInitAdapterConfig;
                return aMPSInitAdapterConfig2 != null ? aMPSInitAdapterConfig2.isPersonalRecommend() : super.isSupportPersonalized();
            }
        }).build(), new InitCallback() { // from class: xyz.adscope.amps.adapter.asnp.ASNPInitMediation.2
            @Override // xyz.adscope.ad.init.inter.InitCallback
            public void fail(int i4, String str) {
                try {
                    ASNPInitMediation.this.isInitIng = false;
                    synchronized (this) {
                        if (ASNPInitMediation.mCallBackList != null && ASNPInitMediation.mCallBackList.size() > 0) {
                            for (IAMPSChannelInitCallBack iAMPSChannelInitCallBack2 : ASNPInitMediation.mCallBackList) {
                                ASNPInitMediation.this.initSDKFail(iAMPSChannelInitCallBack2, new AMPSError(String.valueOf(i4), str));
                            }
                        }
                        ASNPInitMediation.mCallBackList.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // xyz.adscope.ad.init.inter.InitCallback
            public void success() {
                ASNPInitMediation.this.isInitIng = false;
                ASNPInitMediation.this.isInit = true;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK init success");
                synchronized (this) {
                    if (ASNPInitMediation.mCallBackList != null && ASNPInitMediation.mCallBackList.size() > 0) {
                        for (IAMPSChannelInitCallBack iAMPSChannelInitCallBack2 : ASNPInitMediation.mCallBackList) {
                            ASNPInitMediation.this.initSDKSuccess(iAMPSChannelInitCallBack2);
                        }
                    }
                    ASNPInitMediation.mCallBackList.clear();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_ASNP;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return AdScopeSDK.getSDKVersion();
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_ASNP_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            if (iAMPSChannelInitCallBack != null) {
                mCallBackList.add(iAMPSChannelInitCallBack);
            }
            if (this.isInitIng) {
                return;
            }
            this.isInitIng = true;
            initASNPSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }
}

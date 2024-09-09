package xyz.adscope.amps.adapter.csj;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
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
public class CSJInitMediation extends AMPSChannelInitMediation {
    private static CSJInitMediation instance;
    private static List<IAMPSChannelInitCallBack> mCallBackList = new ArrayList();
    private boolean isInit = false;
    private boolean isInitIng = false;

    private static TTAdConfig buildConfig(final AMPSInitAdapterConfig aMPSInitAdapterConfig) {
        return new TTAdConfig.Builder().appId(aMPSInitAdapterConfig.getAppId()).debug(aMPSInitAdapterConfig.isDebug()).supportMultiProcess(false).useMediation(false).data(getData(aMPSInitAdapterConfig)).customController(new TTCustomController() { // from class: xyz.adscope.amps.adapter.csj.CSJInitMediation.2
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUseAppList() : super.alist();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getAndroidId() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().getAndroidId() : super.getAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().getDevOaid() : super.getDevOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            @Nullable
            public String getMacAddress() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().getMacAddress() : super.getMacAddress();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public MediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: xyz.adscope.amps.adapter.csj.CSJInitMediation.2.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isCanUseOaid() {
                        return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUseOaid() : super.isCanUseOaid();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        AMPSInitAdapterConfig aMPSInitAdapterConfig2 = AMPSInitAdapterConfig.this;
                        return aMPSInitAdapterConfig2 != null ? !aMPSInitAdapterConfig2.isPersonalRecommend() : super.isLimitPersonalAds();
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUseAndroidId() : super.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUseLocation() : super.isCanUseLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUsePhoneState() : super.isCanUsePhoneState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUseWifiState() : super.isCanUseWifiState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return AMPSInitAdapterConfig.this.getPrivacyConfig() != null ? AMPSInitAdapterConfig.this.getPrivacyConfig().isCanUseWriteExternal() : super.isCanUseWriteExternal();
            }
        }).build();
    }

    public static TTAdManager get() {
        return TTAdSdk.getAdManager();
    }

    private static String getData(AMPSInitAdapterConfig aMPSInitAdapterConfig) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            if (aMPSInitAdapterConfig != null) {
                if (aMPSInitAdapterConfig.isPersonalRecommend()) {
                    jSONObject.put("value", "1");
                } else {
                    jSONObject.put("value", "0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", "is_shake_ads");
                AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
                if (privacyConfig != null) {
                    jSONObject2.put("value", privacyConfig.isCanUseShakeAd() ? "1" : "0");
                }
                jSONArray.put(jSONObject);
                jSONArray.put(jSONObject2);
            }
            return jSONArray.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static synchronized CSJInitMediation getInstance() {
        CSJInitMediation cSJInitMediation;
        synchronized (CSJInitMediation.class) {
            if (instance == null) {
                synchronized (CSJInitMediation.class) {
                    instance = new CSJInitMediation();
                }
            }
            cSJInitMediation = instance;
        }
        return cSJInitMediation;
    }

    private void initCSJSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (context != null && aMPSInitAdapterConfig != null && !TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            TTAdSdk.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), buildConfig(aMPSInitAdapterConfig));
            TTAdSdk.start(new TTAdSdk.Callback() { // from class: xyz.adscope.amps.adapter.csj.CSJInitMediation.1
                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void fail(int i4, String str) {
                    try {
                        CSJInitMediation.this.isInitIng = false;
                        synchronized (this) {
                            if (CSJInitMediation.mCallBackList != null && CSJInitMediation.mCallBackList.size() > 0) {
                                for (IAMPSChannelInitCallBack iAMPSChannelInitCallBack2 : CSJInitMediation.mCallBackList) {
                                    CSJInitMediation.this.initSDKFail(iAMPSChannelInitCallBack2, new AMPSError(String.valueOf(i4), str));
                                }
                            }
                            CSJInitMediation.mCallBackList.clear();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void success() {
                    try {
                        CSJInitMediation.this.isInitIng = false;
                        CSJInitMediation.this.isInit = true;
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK init success");
                        synchronized (this) {
                            if (CSJInitMediation.mCallBackList != null && CSJInitMediation.mCallBackList.size() > 0) {
                                for (IAMPSChannelInitCallBack iAMPSChannelInitCallBack2 : CSJInitMediation.mCallBackList) {
                                    CSJInitMediation.this.initSDKSuccess(iAMPSChannelInitCallBack2);
                                }
                            }
                            CSJInitMediation.mCallBackList.clear();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        this.isInitIng = false;
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
        initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return TTAdSdk.getAdManager() != null ? TTAdSdk.getAdManager().getSDKVersion() : "6.1.0.6";
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk("com.bytedance.sdk.openadsdk.TTAdSdk")) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (TTAdSdk.isSdkReady() || this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            if (iAMPSChannelInitCallBack != null) {
                mCallBackList.add(iAMPSChannelInitCallBack);
            }
            if (this.isInitIng) {
                return;
            }
            this.isInitIng = true;
            initCSJSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }
}

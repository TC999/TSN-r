package xyz.adscope.amps.init;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSConfigManager;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.config.inter.IConfigInfoCallback;
import xyz.adscope.amps.config.inter.IConfigInterface;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.init.inter.IAMPSInitInterface;
import xyz.adscope.amps.manager.AMPSAdSourceDataProvider;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.report.AMPSEventReportCode;
import xyz.adscope.amps.report.AMPSReportLoader;
import xyz.adscope.amps.tool.AMPSAdapterFactory;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.crash.AMPSCrashHandler;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.network.JsonConverter;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.KalleConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSInitImplement implements IAMPSInitInterface {
    private AMPSGlobalModel ampsGlobalModel;
    private Context context;
    private IConfigInterface iAdConfig = new AMPSConfigManager();
    private AMPSInitUserAgent initUserAgent = new AMPSInitUserAgent();
    private AMPSInitConfig mAMPSAdConfig;
    private AMPSPrivacyConfig mAMPSPrivacyConfig;

    private void asyncGetDb() {
    }

    private void asyncUpdateInfo(Context context, final IAMPSInitCallback iAMPSInitCallback) {
        asyncGetDb();
        this.iAdConfig.setContext(context);
        this.iAdConfig.initConfigureFile(this.ampsGlobalModel, new IConfigInfoCallback() { // from class: xyz.adscope.amps.init.AMPSInitImplement.1
            @Override // xyz.adscope.amps.config.inter.IConfigInfoCallback
            public void failCallBack(AMPSError aMPSError) {
                long currentTimeMillis = System.currentTimeMillis() - AMPSSDKManager.initStartTime;
                AMPSReportLoader aMPSReportLoader = AMPSReportLoader.getInstance();
                String codeStr = AMPSEventReportCode.EVENT_INIT_FAIL_CODE.getCodeStr();
                aMPSReportLoader.reportInitLog(codeStr, currentTimeMillis + "");
                AMPSSDKManager.initStartTime = 0L;
                AMPSReportLoader.getInstance().loadLogModelFromConfig();
                AMPSReportLoader.getInstance().loadLogsFromDatabase();
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "initialize failCallback");
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_CRASH_CODE.getCodeStr(), "");
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_START_CODE.getCodeStr(), "0");
                IAMPSInitCallback iAMPSInitCallback2 = iAMPSInitCallback;
                if (iAMPSInitCallback2 != null) {
                    iAMPSInitCallback2.failCallback(aMPSError);
                    if (AMPSInitImplement.this.ampsGlobalModel != null) {
                        AMPSInitImplement.this.ampsGlobalModel.setErrorCode(aMPSError.getCode());
                        AMPSInitImplement.this.ampsGlobalModel.setErrorMsg(aMPSError.getMessage());
                    }
                }
                AMPSSDKManager.getInstance().setInitStatus(AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail);
            }

            @Override // xyz.adscope.amps.config.inter.IConfigInfoCallback
            public void successCallBack() {
                long currentTimeMillis = System.currentTimeMillis() - AMPSSDKManager.initStartTime;
                AMPSSDKManager.getInstance().setInitStatus(AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusSuccess);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "initialize success " + (System.currentTimeMillis() - AMPSSDKManager.initStartTime));
                AMPSSDKManager.initStartTime = 0L;
                AMPSReportLoader aMPSReportLoader = AMPSReportLoader.getInstance();
                String codeStr = AMPSEventReportCode.EVENT_INIT_SUCCESS_CODE.getCodeStr();
                aMPSReportLoader.reportInitLog(codeStr, currentTimeMillis + "");
                AMPSReportLoader.getInstance().loadLogModelFromConfig();
                AMPSReportLoader.getInstance().loadLogsFromDatabase();
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_START_CODE.getCodeStr(), "0");
                IAMPSInitCallback iAMPSInitCallback2 = iAMPSInitCallback;
                if (iAMPSInitCallback2 != null) {
                    iAMPSInitCallback2.successCallback();
                }
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_CRASH_CODE.getCodeStr(), "0");
                AMPSInitImplement aMPSInitImplement = AMPSInitImplement.this;
                aMPSInitImplement.preInitAdSource(aMPSInitImplement.ampsGlobalModel.getAmpsInitConfig());
                AMPSInitImplement.this.updateNetWorkConfig();
            }
        });
    }

    private void initNetWork() {
        Kalle.setConfig(KalleConfig.newBuilder().converter(new JsonConverter(this.context)).build());
        if (Kalle.getConfig() != null) {
            Kalle.getConfig().getHeaders().add("Accept-Encrypt", "101,1001");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preInitAdSource(AMPSInitConfig aMPSInitConfig) {
        if (aMPSInitConfig == null || aMPSInitConfig.getAdapterNameList() == null || aMPSInitConfig.getAdapterNameList().size() < 1) {
            return;
        }
        List<String> adapterNameList = aMPSInitConfig.getAdapterNameList();
        for (int i4 = 0; i4 < adapterNameList.size(); i4++) {
            String str = adapterNameList.get(i4);
            AdSourceModel adSourceByAdapterName = AMPSAdSourceDataProvider.getInstance().getAdSourceByAdapterName(str);
            AMPSChannelInitMediation createAdapterInit = AMPSAdapterFactory.createAdapterInit(str);
            if (adSourceByAdapterName != null && createAdapterInit != null) {
                String appId = adSourceByAdapterName.getAppId();
                if (!TextUtils.isEmpty(appId)) {
                    AMPSInitAdapterConfig aMPSInitAdapterConfig = new AMPSInitAdapterConfig();
                    aMPSInitAdapterConfig.setAppId(appId);
                    createAdapterInit.initSDK(aMPSInitAdapterConfig, null);
                }
            }
        }
    }

    private void syncStartService() {
        initNetWork();
        AMPSCrashHandler.getInstance().init(AMPSSDKManager.getInstance().getContext());
        this.initUserAgent.getUserAgent(AMPSSDKManager.getInstance().getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetWorkConfig() {
        AMPSGlobalModel aMPSGlobalModel;
        if (Kalle.getConfig() == null || (aMPSGlobalModel = this.ampsGlobalModel) == null || aMPSGlobalModel.getConfigureResponseModel() == null || this.ampsGlobalModel.getConfigureResponseModel().getConfig() == null) {
            return;
        }
        Kalle.getConfig().getHeaders().remove("Accept-Encrypt");
        Kalle.getConfig().getHeaders().add("Accept-Encrypt", this.ampsGlobalModel.getAcceptEncrypt());
    }

    public AMPSPrivacyConfig getAMPSPrivacyConfig() {
        return this.mAMPSPrivacyConfig;
    }

    @Override // xyz.adscope.amps.init.inter.IAMPSInitInterface
    public AMPSGlobalModel getGlobalModel() {
        return this.ampsGlobalModel;
    }

    @Override // xyz.adscope.amps.init.inter.IAMPSInitInterface
    public void init(Context context, AMPSInitConfig aMPSInitConfig, AMPSGlobalModel aMPSGlobalModel, IAMPSInitCallback iAMPSInitCallback) {
        this.context = context;
        this.ampsGlobalModel = aMPSGlobalModel;
        if (aMPSInitConfig != null && !TextUtils.isEmpty(aMPSInitConfig.getAppId())) {
            this.ampsGlobalModel.setAppId(aMPSInitConfig.getAppId());
        }
        this.ampsGlobalModel.setStartId(AMPSStringUtil.createRequestId());
        this.ampsGlobalModel.setAmpsInitConfig(aMPSInitConfig);
        AMPSLogUtil.i(AMPSConstants.AMPS_LOG_TAG, " init execute appId:" + aMPSInitConfig.getAppId() + ", sdkVersion:" + AMPSSDK.getSdkVersion());
        syncStartService();
        asyncUpdateInfo(context, iAMPSInitCallback);
    }

    @Override // xyz.adscope.amps.init.inter.IAMPSInitInterface
    public boolean isInitSuccess() {
        return false;
    }

    public void setAMPSAdConfig(AMPSInitConfig aMPSInitConfig) {
        this.mAMPSAdConfig = aMPSInitConfig;
    }
}

package xyz.adscope.amps.manager;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.AMPSInitImplement;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.init.inter.IAMPSInitInterface;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.report.AMPSEventReportCode;
import xyz.adscope.amps.report.AMPSReportLoader;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSSDKManager {
    public static long initStartTime;
    private static AMPSSDKManager instance;
    private AMPSGlobalModel ampsGlobalModel;
    private AMPSInitConfig mAMPSAdConfig;
    private AMPSPrivacyConfig mAMPSPrivacyConfig;
    private String mAppId;
    private Context mContext;
    private String userAgent;
    private AMPSEnum.AMPSSDKInitStatus initStatus = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusNormal;
    private IAMPSInitInterface iampsInitInterface = new AMPSInitImplement();

    private AMPSSDKManager() {
    }

    public static synchronized AMPSSDKManager getInstance() {
        AMPSSDKManager aMPSSDKManager;
        synchronized (AMPSSDKManager.class) {
            if (instance == null) {
                synchronized (AMPSSDKManager.class) {
                    instance = new AMPSSDKManager();
                }
            }
            aMPSSDKManager = instance;
        }
        return aMPSSDKManager;
    }

    public AMPSInitConfig getAMPSAdConfig() {
        return this.mAMPSAdConfig;
    }

    public AMPSPrivacyConfig getAMPSPrivacyConfig() {
        return this.mAMPSPrivacyConfig;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public Context getContext() {
        return this.mContext;
    }

    public IAMPSInitInterface getIAMPSInitInterface() {
        return this.iampsInitInterface;
    }

    public String getSdkVersion() {
        return "5.1.0.13";
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void initialize(Context context, AMPSInitConfig aMPSInitConfig, IAMPSInitCallback iAMPSInitCallback) {
        try {
            if (sdkInitStatus() == AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusSuccess) {
                iAMPSInitCallback.successCallback();
                return;
            }
            this.ampsGlobalModel = new AMPSGlobalModel();
            setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            initStartTime = System.currentTimeMillis();
            this.ampsGlobalModel.setInitStartTime(System.currentTimeMillis());
            if (aMPSInitConfig == null) {
                StringBuilder sb = new StringBuilder();
                AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail;
                sb.append(aMPSSDKInitStatus.getCode());
                sb.append("");
                iAMPSInitCallback.failCallback(new AMPSError(sb.toString(), aMPSSDKInitStatus.getMsg()));
                AMPSGlobalModel aMPSGlobalModel = this.ampsGlobalModel;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_INIT_FAIL_CONFIG_NULL;
                aMPSGlobalModel.setErrorCode(reportLogErrorEnum.getErrorCode());
                this.ampsGlobalModel.setErrorMsg(reportLogErrorEnum.getErrorMsg());
                long currentTimeMillis = System.currentTimeMillis() - initStartTime;
                AMPSReportLoader aMPSReportLoader = AMPSReportLoader.getInstance();
                String codeStr = AMPSEventReportCode.EVENT_INIT_FAIL_CODE.getCodeStr();
                aMPSReportLoader.reportInitLog(codeStr, currentTimeMillis + "");
                this.initStatus = aMPSSDKInitStatus;
                initStartTime = 0L;
                return;
            }
            String appId = aMPSInitConfig.getAppId();
            if (TextUtils.isEmpty(appId)) {
                StringBuilder sb2 = new StringBuilder();
                AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus2 = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail;
                sb2.append(aMPSSDKInitStatus2.getCode());
                sb2.append("");
                iAMPSInitCallback.failCallback(new AMPSError(sb2.toString(), aMPSSDKInitStatus2.getMsg()));
                AMPSGlobalModel aMPSGlobalModel2 = this.ampsGlobalModel;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum2 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_INIT_FAIL_APPID_NULL;
                aMPSGlobalModel2.setErrorCode(reportLogErrorEnum2.getErrorCode());
                this.ampsGlobalModel.setErrorMsg(reportLogErrorEnum2.getErrorMsg());
                long currentTimeMillis2 = System.currentTimeMillis() - initStartTime;
                AMPSReportLoader aMPSReportLoader2 = AMPSReportLoader.getInstance();
                String codeStr2 = AMPSEventReportCode.EVENT_INIT_FAIL_CODE.getCodeStr();
                aMPSReportLoader2.reportInitLog(codeStr2, currentTimeMillis2 + "");
                this.initStatus = aMPSSDKInitStatus2;
                initStartTime = 0L;
                return;
            }
            this.initStatus = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusLoading;
            this.mAMPSAdConfig = aMPSInitConfig;
            setAppId(appId);
            setAMPSAdConfig(aMPSInitConfig);
            this.iampsInitInterface.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), aMPSInitConfig, this.ampsGlobalModel, iAMPSInitCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMPSEnum.AMPSSDKInitStatus sdkInitStatus() {
        return this.initStatus;
    }

    public void setAMPSAdConfig(AMPSInitConfig aMPSInitConfig) {
        this.mAMPSAdConfig = aMPSInitConfig;
    }

    public void setAMPSPrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        this.mAMPSPrivacyConfig = aMPSPrivacyConfig;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setInitStatus(AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus) {
        this.initStatus = aMPSSDKInitStatus;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}

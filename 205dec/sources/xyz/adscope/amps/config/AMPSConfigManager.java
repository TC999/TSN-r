package xyz.adscope.amps.config;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.inter.IConfigInfoCallback;
import xyz.adscope.amps.config.inter.IConfigInterface;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.tool.AMPSSecurityUtil;
import xyz.adscope.amps.tool.crash.AMPSCrashRouter;
import xyz.adscope.amps.tool.crash.inter.ICrashRouter;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;
import xyz.adscope.amps.tool.request.AMPSHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.amps.tool.task.AMPSTimerOutTask;
import xyz.adscope.amps.tool.task.scheduler.AMPSConfigSchedulerTask;
import xyz.adscope.amps.tool.thread.AMPSThreadPool;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSConfigManager implements IConfigInterface {
    private AMPSConfigSchedulerTask adConfigSchedulerTask;
    private AMPSGlobalModel ampsGlobalModel;
    private Context context;
    private AMPSConfigResponseInfo responseInfo;
    private ICrashRouter iCrashRouter = new AMPSCrashRouter();
    private IHttpRequest iHttpRequest = new AMPSHttpRequest();
    private AMPSTimerOutTask ampsTimerOutTask = new AMPSTimerOutTask();

    /* JADX INFO: Access modifiers changed from: private */
    public void failResultCallback(IConfigInfoCallback iConfigInfoCallback, String str) {
        if (iConfigInfoCallback != null) {
            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_INIT_FAIL;
            iConfigInfoCallback.failCallBack(new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg()));
            this.ampsTimerOutTask.setIsExecuteConfig(true);
            this.ampsTimerOutTask.cancelTimerTask();
        }
        LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "e : " + str);
    }

    private boolean isUseHttps() {
        AMPSInitConfig ampsInitConfig;
        AMPSGlobalModel aMPSGlobalModel = this.ampsGlobalModel;
        if (aMPSGlobalModel == null || (ampsInitConfig = aMPSGlobalModel.getAmpsInitConfig()) == null) {
            return false;
        }
        return ampsInitConfig.isUseHttps();
    }

    private void syncLocalOrCacheConfig(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback) {
        if (checkConfig()) {
            requestConfigureFile(aMPSGlobalModel, iConfigInfoCallback);
            return;
        }
        AMPSConfigResponseModel configureResponseModel = this.responseInfo.getConfigureResponseModel();
        aMPSGlobalModel.setConfigureResponseModel(configureResponseModel);
        aMPSGlobalModel.setSdkInitEndTime(DeviceInfo.getInstance(this.context).getTimeStamp());
        if (configureResponseModel != null) {
            if (iConfigInfoCallback != null) {
                iConfigInfoCallback.successCallBack();
                this.ampsTimerOutTask.cancelTimerTask();
            }
        } else if (iConfigInfoCallback != null) {
            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_INIT_FAIL;
            iConfigInfoCallback.failCallBack(new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg()));
            this.ampsTimerOutTask.cancelTimerTask();
        }
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public boolean checkConfig() {
        long j4;
        AMPSConfigResponseModel configureResponseModel = this.responseInfo.getConfigureResponseModel();
        if (configureResponseModel != null) {
            long timeStamp = DeviceInfoUtil.getTimeStamp();
            long lastUpdateTime = configureResponseModel.getLastUpdateTime();
            long j5 = 0;
            if (configureResponseModel.getConfig() != null) {
                j5 = configureResponseModel.getConfig().getMaxExpireTime();
                j4 = configureResponseModel.getConfig().getExpireTime();
            } else {
                j4 = 0;
            }
            if (timeStamp <= lastUpdateTime || timeStamp - lastUpdateTime <= j5) {
                return timeStamp > lastUpdateTime && timeStamp - lastUpdateTime > j4;
            }
            return true;
        }
        LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "first launch and heartConfig is null return true!");
        return false;
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void initConfigureFile(final AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback) {
        this.ampsGlobalModel = aMPSGlobalModel;
        LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "initConfigureFile() execute");
        if (this.responseInfo == null) {
            this.responseInfo = AMPSConfigResponseInfo.getInstance();
        }
        if (!this.responseInfo.isInit()) {
            this.responseInfo.init(isUseHttps());
        }
        AMPSThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.amps.config.AMPSConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                AMPSGlobalModel aMPSGlobalModel2 = aMPSGlobalModel;
                if (aMPSGlobalModel2 != null) {
                    AMPSInitConfig ampsInitConfig = aMPSGlobalModel2.getAmpsInitConfig();
                    if (ampsInitConfig != null) {
                        if (ampsInitConfig.isPersonalRecommend()) {
                            DeviceInfoUtil.initOaid(AMPSConfigManager.this.context);
                            return;
                        }
                        return;
                    }
                    DeviceInfoUtil.initOaid(AMPSConfigManager.this.context);
                }
            }
        });
        if (this.iCrashRouter.lastLaunchCrashedBecauseOfSDK()) {
            requestConfigureFile(aMPSGlobalModel, iConfigInfoCallback);
            return;
        }
        syncLocalOrCacheConfig(aMPSGlobalModel, iConfigInfoCallback);
        schedulerUpdateConfigureFile();
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void requestConfigureFile(final AMPSGlobalModel aMPSGlobalModel, final IConfigInfoCallback iConfigInfoCallback) {
        String decode;
        AMPSConfigResponseInfo aMPSConfigResponseInfo = this.responseInfo;
        if (aMPSConfigResponseInfo != null && aMPSConfigResponseInfo.getConfigureResponseModel() != null && this.responseInfo.getConfigureResponseModel().getConfig() != null && !TextUtils.isEmpty(this.responseInfo.getConfigureResponseModel().getConfig().getConfigURL())) {
            decode = this.responseInfo.getConfigureResponseModel().getConfig().getConfigURL();
        } else {
            decode = Base64Util.decode(isUseHttps() ? AMPSConstants.AMPS_CONFIG_URL_TRANSFER_PROTOCOL : AMPSConstants.AMPS_CONFIG_URL);
            if (TextUtils.isEmpty(decode)) {
                return;
            }
        }
        AMPSConfigRequestInfo aMPSConfigRequestInfo = AMPSConfigRequestInfo.getInstance(this.context);
        if (!aMPSConfigRequestInfo.isInit) {
            aMPSConfigRequestInfo.init(aMPSGlobalModel.getAmpsInitConfig());
        }
        this.iHttpRequest.doRequestWithJson(decode, new JSONParse().toJson(aMPSConfigRequestInfo.getConfigureRequestModel()), new IHttpResponseCallback<String>() { // from class: xyz.adscope.amps.config.AMPSConfigManager.2
            @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str, int i4) {
                AMPSConfigManager.this.failResultCallback(iConfigInfoCallback, str);
                AMPSGlobalModel aMPSGlobalModel2 = aMPSGlobalModel;
                AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_REQUEST_ERROR;
                aMPSGlobalModel2.setErrorCode(aSMPLogicErrorEnum.getErrorCode());
                aMPSGlobalModel.setErrorMsg(aSMPLogicErrorEnum.getErrorMsg());
            }

            @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
            public void successCallback(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("code") == 200) {
                        String optString = jSONObject.optString("data");
                        AMPSGlobalModel aMPSGlobalModel2 = aMPSGlobalModel;
                        String processUnCompressAndDecrypt = AMPSSecurityUtil.processUnCompressAndDecrypt(optString, aMPSGlobalModel2 != null ? aMPSGlobalModel2.getAcceptEncrypt() : "101,1001");
                        if (!TextUtils.isEmpty(processUnCompressAndDecrypt) && !processUnCompressAndDecrypt.equals("null") && !processUnCompressAndDecrypt.equals("{}")) {
                            LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "AdConfig successCallback ");
                            AMPSConfigManager.this.updateConfigureFile(aMPSGlobalModel, processUnCompressAndDecrypt);
                            IConfigInfoCallback iConfigInfoCallback2 = iConfigInfoCallback;
                            if (iConfigInfoCallback2 != null) {
                                iConfigInfoCallback2.successCallBack();
                                AMPSConfigManager.this.ampsTimerOutTask.setIsExecuteConfig(true);
                                AMPSConfigManager.this.ampsTimerOutTask.cancelTimerTask();
                                return;
                            }
                            return;
                        }
                        AMPSConfigManager.this.failResultCallback(iConfigInfoCallback, "error");
                        AMPSGlobalModel aMPSGlobalModel3 = aMPSGlobalModel;
                        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_RESPONSE_ERROR;
                        aMPSGlobalModel3.setErrorCode(aSMPLogicErrorEnum.getErrorCode());
                        aMPSGlobalModel.setErrorMsg(aSMPLogicErrorEnum.getErrorMsg());
                    }
                } catch (Exception e4) {
                    AMPSConfigManager.this.failResultCallback(iConfigInfoCallback, e4.toString());
                    AMPSGlobalModel aMPSGlobalModel4 = aMPSGlobalModel;
                    AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum2 = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_PARSE_ERROR;
                    aMPSGlobalModel4.setErrorCode(aSMPLogicErrorEnum2.getErrorCode());
                    aMPSGlobalModel.setErrorMsg(aSMPLogicErrorEnum2.getErrorMsg());
                }
            }
        });
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void schedulerUpdateConfigureFile() {
        if (this.adConfigSchedulerTask == null) {
            AMPSConfigSchedulerTask aMPSConfigSchedulerTask = new AMPSConfigSchedulerTask(this);
            this.adConfigSchedulerTask = aMPSConfigSchedulerTask;
            aMPSConfigSchedulerTask.setAdScopeGlobalModel(this.ampsGlobalModel);
        }
        this.adConfigSchedulerTask.startSchedulerTask();
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void updateConfigureFile(AMPSGlobalModel aMPSGlobalModel, String str) {
        this.responseInfo.parseResponse(str);
        AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REASON_KEY, Boolean.FALSE);
        aMPSGlobalModel.setConfigureResponseModel(this.responseInfo.getConfigureResponseModel());
        schedulerUpdateConfigureFile();
    }
}

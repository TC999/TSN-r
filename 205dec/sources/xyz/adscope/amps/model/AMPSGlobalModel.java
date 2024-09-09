package xyz.adscope.amps.model;

import android.text.TextUtils;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSGlobalModel extends AMPSBaseModel {
    private AMPSInitConfig ampsInitConfig;
    private AMPSConfigResponseModel configureResponseModel;
    private long initStartTime;
    private AMPSEnum.AMPSSDKInitStatus initStatus;
    private long sdkInitEndTime;
    private String appId = "";
    private String errorCode = "";
    private String errorMsg = "";
    private String acceptEncrypt = "101,1001";
    private String startId = "";
    private String sessionId = "";

    public String getAcceptEncrypt() {
        AMPSConfigResponseModel aMPSConfigResponseModel = this.configureResponseModel;
        if (aMPSConfigResponseModel != null && aMPSConfigResponseModel.getConfig() != null && !TextUtils.isEmpty(this.configureResponseModel.getConfig().getAcceptEncrypt())) {
            return this.configureResponseModel.getConfig().getAcceptEncrypt();
        }
        return this.acceptEncrypt;
    }

    public AMPSInitConfig getAmpsInitConfig() {
        return this.ampsInitConfig;
    }

    public String getAppId() {
        return this.appId;
    }

    public AMPSConfigResponseModel getConfigureResponseModel() {
        return this.configureResponseModel;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getEventId() {
        return AMPSStringUtil.createRequestId();
    }

    public long getEventTime() {
        return DeviceInfoUtil.getTimeStamp();
    }

    public long getInitStartTime() {
        return this.initStartTime;
    }

    public AMPSEnum.AMPSSDKInitStatus getInitStatus() {
        return this.initStatus;
    }

    public long getLogTime() {
        return DeviceInfoUtil.getTimeStamp();
    }

    public String getRequestId() {
        return "";
    }

    public long getSdkInitEndTime() {
        return this.sdkInitEndTime;
    }

    public String getStartId() {
        return this.startId;
    }

    public void setAmpsInitConfig(AMPSInitConfig aMPSInitConfig) {
        this.ampsInitConfig = aMPSInitConfig;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setConfigureResponseModel(AMPSConfigResponseModel aMPSConfigResponseModel) {
        this.configureResponseModel = aMPSConfigResponseModel;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setInitStartTime(long j4) {
        this.initStartTime = j4;
    }

    public void setInitStatus(AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus) {
        this.initStatus = aMPSSDKInitStatus;
    }

    public void setSdkInitEndTime(long j4) {
        this.sdkInitEndTime = j4;
    }

    public void setStartId(String str) {
        this.startId = str;
    }
}

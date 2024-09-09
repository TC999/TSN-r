package xyz.adscope.amps.config;

import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.config.request.AMPSConfigRequestModel;
import xyz.adscope.amps.model.config.request.AppModel;
import xyz.adscope.amps.model.config.request.DeviceModel;
import xyz.adscope.amps.model.config.request.SdkModel;
import xyz.adscope.amps.model.config.request.UserModel;
import xyz.adscope.common.info.AppInfo;
import xyz.adscope.common.info.DeviceInfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSConfigRequestInfo {
    private static AMPSConfigRequestInfo mInstance;
    private AMPSConfigRequestModel configureRequestModel;
    private Context context;
    public boolean isInit = false;

    private AMPSConfigRequestInfo(Context context) {
        this.context = context;
    }

    public static AMPSConfigRequestInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AMPSConfigRequestInfo.class) {
                if (mInstance == null) {
                    mInstance = new AMPSConfigRequestInfo(context);
                }
            }
        }
        return mInstance;
    }

    public AMPSConfigRequestModel getConfigureRequestModel() {
        return this.configureRequestModel;
    }

    public AMPSConfigRequestInfo init(AMPSInitConfig aMPSInitConfig) {
        if (aMPSInitConfig == null) {
            return null;
        }
        this.configureRequestModel = new AMPSConfigRequestModel();
        AppModel appModel = new AppModel();
        if (!TextUtils.isEmpty(aMPSInitConfig.getAppId())) {
            appModel.setAppId(aMPSInitConfig.getAppId());
        }
        appModel.setName(aMPSInitConfig.getAppName());
        if (AMPSSDKManager.getInstance().getContext() != null) {
            appModel.setVersion(AppInfo.getAppVersionName(AMPSSDKManager.getInstance().getContext()));
            appModel.setInstall(AppInfo.getInstallDate(AMPSSDKManager.getInstance().getContext()) + "");
            appModel.setUpdate(AppInfo.getLastUpdateTime(AMPSSDKManager.getInstance().getContext()) + "");
            appModel.setBundleid(AppInfo.getPackName(AMPSSDKManager.getInstance().getContext()));
        }
        this.configureRequestModel.setApp(appModel);
        DeviceInfo deviceInfo = DeviceInfo.getInstance(this.context);
        DeviceModel deviceModel = new DeviceModel();
        if (deviceInfo != null) {
            deviceModel.setType(deviceInfo.getDeviceType() + "");
            deviceModel.setName(deviceInfo.getDeviceName());
            deviceModel.setSaid(deviceInfo.getSdkid());
            deviceModel.setOs(deviceInfo.getOs());
            deviceModel.setCountry(deviceInfo.getCountry());
            deviceModel.setZone(deviceInfo.getTimeZone());
            deviceModel.setLang(deviceInfo.getLanguage());
            deviceModel.setContype(deviceInfo.getConnectType());
            deviceModel.setCarrier(deviceInfo.getCarrier());
            deviceModel.setOsv(deviceInfo.getOsVersion());
            deviceModel.setCoaid(aMPSInitConfig.getCustomOAID());
            deviceModel.setCgaid(aMPSInitConfig.getCustomGAID());
            deviceModel.setW(deviceInfo.getResolutionWidth() + "");
            deviceModel.setH(deviceInfo.getResolutionHeight() + "");
            deviceModel.setMake(deviceInfo.getManufacturer());
            deviceModel.setBrand(deviceInfo.getBrand());
            deviceModel.setModel(deviceModel.getModel());
            deviceModel.setBootMark(deviceInfo.getBootMark());
            deviceModel.setUpdateMark(deviceInfo.getUpdateMark());
            deviceModel.setSysUpdateMark("");
            deviceModel.setFileMark(deviceInfo.getFileMark());
            deviceModel.setHarddiskSize(deviceInfo.getHardDiskSize());
            deviceModel.setPhysicalMemory(deviceInfo.getPhysicalMemory());
            if (aMPSInitConfig.isPersonalRecommend()) {
                deviceModel.setLmt("1");
                deviceModel.setOaid(deviceInfo.getOaid());
                deviceModel.setGaid(deviceInfo.getGaid());
            } else {
                deviceModel.setLmt("0");
            }
        }
        this.configureRequestModel.setDevice(deviceModel);
        UserModel userModel = new UserModel();
        userModel.setId(aMPSInitConfig.getUserId());
        userModel.setCity(aMPSInitConfig.getCity());
        userModel.setProvince(aMPSInitConfig.getProvince());
        userModel.setRegion(aMPSInitConfig.getRegion());
        userModel.setCustomData(aMPSInitConfig.getOptionInfo());
        this.configureRequestModel.setUser(userModel);
        SdkModel sdkModel = new SdkModel();
        sdkModel.setVersion("5.1.0.13");
        this.configureRequestModel.setSdk(sdkModel);
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }
}

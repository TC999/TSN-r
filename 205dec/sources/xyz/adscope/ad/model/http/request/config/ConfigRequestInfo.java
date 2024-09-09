package xyz.adscope.ad.model.http.request.config;

import android.content.Context;
import android.text.TextUtils;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.config.model.ConfigResponseInfo;
import xyz.adscope.ad.constants.ConstantConfig;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.security.MD5Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ConfigRequestInfo {
    private static ConfigRequestInfo mInstance;
    private ConfigureRequestModel configureRequestModel;
    public boolean isInit = false;

    private ConfigRequestInfo() {
    }

    private String generateCurrentTimeMillis() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.clear();
        calendar.set(2020, 0, 1, 0, 0, 0);
        return String.valueOf(System.currentTimeMillis() - calendar.getTimeInMillis());
    }

    private String generateFourDigitRandom() {
        Random random = new Random();
        return "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

    private String generateSdkUID(Context context, String str, String str2) {
        String generateFourDigitRandom = generateFourDigitRandom();
        String generateCurrentTimeMillis = generateCurrentTimeMillis();
        String str3 = str + "_" + str2 + "___" + generateFourDigitRandom + "_" + generateCurrentTimeMillis;
        String str4 = MD5Util.md5(str3) + "_" + generateFourDigitRandom + "_" + generateCurrentTimeMillis;
        AdScopeSpUtil.putString(ConstantConfig.SDK_UID_KEY, str4);
        return str4;
    }

    public static ConfigRequestInfo getInstance() {
        if (mInstance == null) {
            synchronized (ConfigRequestInfo.class) {
                if (mInstance == null) {
                    mInstance = new ConfigRequestInfo();
                }
            }
        }
        return mInstance;
    }

    public String getAdCacheMd5() {
        return ConfigResponseInfo.getInstance().getAdCacheConfigModelList() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getAdCacheConfigModelList())) : "";
    }

    public ConfigureRequestModel getConfigureRequestModel() {
        return this.configureRequestModel;
    }

    public String getGaid() {
        return DeviceInfo.getInstance(AdScopeSDK.getContext()).getGaid();
    }

    public String getOaid() {
        return DeviceInfo.getInstance(AdScopeSDK.getContext()).getOaid();
    }

    public String getPreloadMd5() {
        return ConfigResponseInfo.getInstance().getPreloadModelList() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getPreloadModelList())) : "";
    }

    public String getRequestUrlMd5() {
        return ConfigResponseInfo.getInstance().getRequestUrlModel() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getRequestUrlModel())) : "";
    }

    public String getSdkId() {
        return DeviceInfo.getInstance(AdScopeSDK.getContext()).getSdkid();
    }

    public String getStatisticsMd5() {
        return ConfigResponseInfo.getInstance().getStatisticsModel() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getStatisticsModel())) : "";
    }

    public String getStrategyMd5() {
        return ConfigResponseInfo.getInstance().getStrategyModel() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getStrategyModel())) : "";
    }

    public String getTemplateMd5() {
        return ConfigResponseInfo.getInstance().getTemplateModelList() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getTemplateModelList())) : "";
    }

    public String getUpdateMd5() {
        return ConfigResponseInfo.getInstance().getUpdateModel() != null ? MD5Util.md5(new JSONParse().toJson(ConfigResponseInfo.getInstance().getUpdateModel())) : "";
    }

    public String getUserAgent() {
        return DeviceInfoUtil.getUserAgent(AdScopeSDK.getContext());
    }

    public ConfigRequestInfo init(AdInitConfig adInitConfig) {
        this.configureRequestModel = new ConfigureRequestModel();
        DeviceInfo deviceInfo = DeviceInfo.getInstance(AdScopeSDK.getContext());
        if (deviceInfo != null) {
            this.configureRequestModel.setTimeStamp(deviceInfo.getTimeStamp());
            this.configureRequestModel.setUserAgent(getUserAgent());
            this.configureRequestModel.setDeviceType(deviceInfo.getDeviceType());
            this.configureRequestModel.setManufacturer(deviceInfo.getManufacturer());
            this.configureRequestModel.setBrand(deviceInfo.getBrand());
            this.configureRequestModel.setModel(deviceInfo.getModel());
            if (!TextUtils.isEmpty(deviceInfo.getOs())) {
                this.configureRequestModel.setOs(Integer.parseInt(deviceInfo.getOs()));
            }
            this.configureRequestModel.setOsVersion(deviceInfo.getOsVersion());
            this.configureRequestModel.setCarrier(deviceInfo.getCarrier());
            if (!TextUtils.isEmpty(deviceInfo.getConnectType())) {
                this.configureRequestModel.setConnectType(Integer.parseInt(deviceInfo.getConnectType()));
            }
            this.configureRequestModel.setLanguage(deviceInfo.getLanguage());
            this.configureRequestModel.setScreenHeight(deviceInfo.getScreenHeight());
            this.configureRequestModel.setScreenWidth(deviceInfo.getScreenWidth());
            this.configureRequestModel.setResolutionWidth(deviceInfo.getScreenWidth());
            this.configureRequestModel.setResolutionHeight(deviceInfo.getScreenHeight());
            this.configureRequestModel.setOrientation(deviceInfo.getOrientation());
            if (!TextUtils.isEmpty(deviceInfo.getDensity())) {
                this.configureRequestModel.setDensity(Float.parseFloat(deviceInfo.getDensity()));
            }
            this.configureRequestModel.setPpi(deviceInfo.getPpi());
            this.configureRequestModel.setBootMark(deviceInfo.getBootMark());
            this.configureRequestModel.setUpdateMark(deviceInfo.getUpdateMark());
            this.configureRequestModel.setPhysicalMemory(deviceInfo.getPhysicalMemory());
            this.configureRequestModel.setHarddiskSize(deviceInfo.getHardDiskSize());
            this.configureRequestModel.setDeviceName(deviceInfo.getDeviceName());
            this.configureRequestModel.setCountry(deviceInfo.getCountry());
            this.configureRequestModel.setFileMark(deviceInfo.getFileMark());
            if (adInitConfig != null) {
                this.configureRequestModel.setCountry_CN(adInitConfig.countryCN());
            } else {
                this.configureRequestModel.setCountry_CN(deviceInfo.getCountry_CN());
            }
        }
        if (adInitConfig != null && adInitConfig.getPersonalRecommend()) {
            this.configureRequestModel.setOaid(getOaid());
            this.configureRequestModel.setGaid(getGaid());
        }
        this.configureRequestModel.setSdkuid(getSdkId());
        this.configureRequestModel.setSaid(getSdkId());
        this.configureRequestModel.setUpdateMd5(getUpdateMd5());
        this.configureRequestModel.setRequestUrlMD5(getRequestUrlMd5());
        this.configureRequestModel.setStrategyMD5(getStrategyMd5());
        this.configureRequestModel.setTemplateMD5(getTemplateMd5());
        this.configureRequestModel.setAdCacheMD5(getAdCacheMd5());
        this.configureRequestModel.setPreloadMD5(getPreloadMd5());
        this.configureRequestModel.setStatisticsMD5(getStatisticsMd5());
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }
}

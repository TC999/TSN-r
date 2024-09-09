package xyz.adscope.ad.config.model;

import android.text.TextUtils;
import java.util.List;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.constants.ConstantConfig;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.model.http.response.config.AdCacheConfigModel;
import xyz.adscope.ad.model.http.response.config.ConfigureResponseModel;
import xyz.adscope.ad.model.http.response.config.PreloadModel;
import xyz.adscope.ad.model.http.response.config.RequestUrlModel;
import xyz.adscope.ad.model.http.response.config.StatisticsModel;
import xyz.adscope.ad.model.http.response.config.StrategyModel;
import xyz.adscope.ad.model.http.response.config.TemplateModel;
import xyz.adscope.ad.model.http.response.config.UpdateModel;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.KeyGenerator;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ConfigResponseInfo {
    private static volatile ConfigResponseInfo mInstance;
    private List<AdCacheConfigModel> adCacheConfigModelList;
    private ConfigureResponseModel configureResponseModel;
    private String crashUrl;
    private long expireTime;
    private long lastUpdateTime;
    private long maxValidTime;
    private List<PreloadModel> preloadModelList;
    private RequestUrlModel requestUrlModel;
    private StatisticsModel statisticsModel;
    private StrategyModel strategyModel;
    private List<TemplateModel> templateModelList;
    private UpdateModel updateModel;
    private long checkTime = 60000;
    private volatile boolean isInit = false;

    private ConfigResponseInfo() {
    }

    public static ConfigResponseInfo getInstance() {
        if (mInstance == null) {
            synchronized (ConfigResponseInfo.class) {
                if (mInstance == null) {
                    mInstance = new ConfigResponseInfo();
                }
            }
        }
        return mInstance;
    }

    private void initFail() {
        this.isInit = false;
    }

    public List<AdCacheConfigModel> getAdCacheConfigModelList() {
        return this.adCacheConfigModelList;
    }

    public long getCheckTime() {
        return this.checkTime;
    }

    public ConfigureResponseModel getConfigureResponseModel() {
        return this.configureResponseModel;
    }

    public String getCrashUrl() {
        return this.crashUrl;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public long getMaxValidTime() {
        return this.maxValidTime;
    }

    public List<PreloadModel> getPreloadModelList() {
        return this.preloadModelList;
    }

    public RequestUrlModel getRequestUrlModel() {
        return this.requestUrlModel;
    }

    public StatisticsModel getStatisticsModel() {
        return this.statisticsModel;
    }

    public StrategyModel getStrategyModel() {
        return this.strategyModel;
    }

    public List<TemplateModel> getTemplateModelList() {
        return this.templateModelList;
    }

    public UpdateModel getUpdateModel() {
        return this.updateModel;
    }

    public synchronized ConfigResponseInfo init() {
        if (this.isInit && mInstance != null) {
            return mInstance;
        }
        String str = (String) AdScopeSpUtil.get(ConstantConfig.GLOBALCONFIG, InitImplement.getInstance().isUseHttps() ? ConstantConfig.DEFAULT_HTTPS_CONFIG_FILE : ConstantConfig.DEFAULT_CONFIG_FILE);
        if (!TextUtils.isEmpty(str)) {
            String decrypt = AesUtil.decrypt(KeyGenerator.generateAesKey(), str);
            if (decrypt != null) {
                ConfigureResponseModel objectFromData = ConfigureResponseModel.objectFromData(decrypt);
                this.configureResponseModel = objectFromData;
                if (objectFromData != null) {
                    this.lastUpdateTime = objectFromData.getLastUpdateTime();
                    UpdateModel update = this.configureResponseModel.getUpdate();
                    this.updateModel = update;
                    if (update != null) {
                        this.expireTime = update.getExpireTime();
                        this.maxValidTime = this.updateModel.getMaxExpireTime();
                        this.checkTime = this.updateModel.getCheckInterval();
                    }
                    this.requestUrlModel = this.configureResponseModel.getRequestUrl();
                    this.strategyModel = this.configureResponseModel.getStrategy();
                    this.preloadModelList = this.configureResponseModel.getPreload();
                    this.templateModelList = this.configureResponseModel.getTemplate();
                    this.adCacheConfigModelList = this.configureResponseModel.getAdCache();
                    this.statisticsModel = this.configureResponseModel.getStatistics();
                    this.isInit = true;
                } else {
                    initFail();
                }
            } else {
                initFail();
            }
        } else {
            initFail();
        }
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void parseResponse(String str) {
        String str2 = Constants.TAG;
        LogUtil.i(str2, "ConfigResponseInfo parseResponse serverResponse : " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if ("".equals((String) AdScopeSpUtil.get(ConstantConfig.GLOBALCONFIG, ""))) {
                AdScopeSpUtil.putString(ConstantConfig.GLOBALCONFIG, AesUtil.encrypt(KeyGenerator.generateAesKey(), str));
            }
            ConfigureResponseModel objectFromData = ConfigureResponseModel.objectFromData(str);
            if (objectFromData != null) {
                mInstance.setConfigureResponseModel(objectFromData);
                long timeStamp = DeviceInfo.getInstance(AdScopeSDK.getContext()).getTimeStamp() / 1000;
                objectFromData.setLastUpdateTime(timeStamp);
                mInstance.setLastUpdateTime(timeStamp);
                if (objectFromData.getUpdate() != null) {
                    mInstance.setUpdateModel(objectFromData.getUpdate());
                    mInstance.setMaxValidTime(objectFromData.getUpdate().getMaxExpireTime());
                    mInstance.setExpireTime(objectFromData.getUpdate().getExpireTime());
                }
                if (objectFromData.getPreload() != null) {
                    mInstance.setPreloadModelList(objectFromData.getPreload());
                }
                if (objectFromData.getRequestUrl() != null) {
                    mInstance.setRequestUrlModel(objectFromData.getRequestUrl());
                }
                if (objectFromData.getStrategy() != null) {
                    mInstance.setStrategyModel(objectFromData.getStrategy());
                }
                if (objectFromData.getTemplate() != null) {
                    mInstance.setTemplateModelList(objectFromData.getTemplate());
                }
                if (objectFromData.getAdCache() != null) {
                    mInstance.setAdCacheConfigModelList(objectFromData.getAdCache());
                }
                if (objectFromData.getStatistics() != null) {
                    mInstance.setStatisticsModel(objectFromData.getStatistics());
                }
                String json = new JSONParse().toJson(objectFromData);
                if (TextUtils.isEmpty(json)) {
                    return;
                }
                AdScopeSpUtil.putString(ConstantConfig.GLOBALCONFIG, AesUtil.encrypt(KeyGenerator.generateAesKey(), json));
            }
        } catch (Exception e4) {
            String str3 = Constants.TAG;
            LogUtil.e(str3, "e : " + e4);
        }
    }

    public void setAdCacheConfigModelList(List<AdCacheConfigModel> list) {
        this.adCacheConfigModelList = list;
    }

    public void setCheckTime(long j4) {
        this.checkTime = j4;
    }

    public void setConfigureResponseModel(ConfigureResponseModel configureResponseModel) {
        this.configureResponseModel = configureResponseModel;
    }

    public void setCrashUrl(String str) {
        this.crashUrl = str;
    }

    public void setExpireTime(long j4) {
        this.expireTime = j4;
    }

    public void setLastUpdateTime(long j4) {
        this.lastUpdateTime = j4;
    }

    public void setMaxValidTime(long j4) {
        this.maxValidTime = j4;
    }

    public void setPreloadModelList(List<PreloadModel> list) {
        this.preloadModelList = list;
    }

    public void setRequestUrlModel(RequestUrlModel requestUrlModel) {
        this.requestUrlModel = requestUrlModel;
    }

    public void setStatisticsModel(StatisticsModel statisticsModel) {
        this.statisticsModel = statisticsModel;
    }

    public void setStrategyModel(StrategyModel strategyModel) {
        this.strategyModel = strategyModel;
    }

    public void setTemplateModelList(List<TemplateModel> list) {
        this.templateModelList = list;
    }

    public void setUpdateModel(UpdateModel updateModel) {
        this.updateModel = updateModel;
    }
}

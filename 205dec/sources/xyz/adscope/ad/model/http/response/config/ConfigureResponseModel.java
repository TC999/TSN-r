package xyz.adscope.ad.model.http.response.config;

import java.util.List;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.model.BaseModel;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ConfigureResponseModel extends BaseModel {
    private List<AdCacheConfigModel> adCache;
    private String adCacheMD5;
    private long lastUpdateTime;
    private List<PreloadModel> preload;
    private String preloadMD5;
    private RequestUrlModel requestUrl;
    private String requestUrlMD5;
    private StatisticsModel statistics;
    private String statisticsMD5;
    private StrategyModel strategy;
    private String strategyMD5;
    private List<TemplateModel> template;
    private String templateMD5;
    private UpdateModel update;
    private String updateMD5;

    public static ConfigureResponseModel objectFromData(String str) {
        try {
            return (ConfigureResponseModel) new JSONParse().fromJson(str, ConfigureResponseModel.class);
        } catch (Exception e4) {
            String str2 = Constants.TAG;
            LogUtil.e(str2, "e : " + e4);
            return null;
        }
    }

    public List<AdCacheConfigModel> getAdCache() {
        return this.adCache;
    }

    public String getAdCacheMD5() {
        return this.adCacheMD5;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public List<PreloadModel> getPreload() {
        return this.preload;
    }

    public String getPreloadMD5() {
        return this.preloadMD5;
    }

    public RequestUrlModel getRequestUrl() {
        return this.requestUrl;
    }

    public String getRequestUrlMD5() {
        return this.requestUrlMD5;
    }

    public StatisticsModel getStatistics() {
        return this.statistics;
    }

    public String getStatisticsMD5() {
        return this.statisticsMD5;
    }

    public StrategyModel getStrategy() {
        return this.strategy;
    }

    public String getStrategyMD5() {
        return this.strategyMD5;
    }

    public List<TemplateModel> getTemplate() {
        return this.template;
    }

    public String getTemplateMD5() {
        return this.templateMD5;
    }

    public UpdateModel getUpdate() {
        return this.update;
    }

    public String getUpdateMD5() {
        return this.updateMD5;
    }

    public void setAdCache(List<AdCacheConfigModel> list) {
        this.adCache = list;
    }

    public void setAdCacheMD5(String str) {
        this.adCacheMD5 = str;
    }

    public void setLastUpdateTime(long j4) {
        this.lastUpdateTime = j4;
    }

    public void setPreload(List<PreloadModel> list) {
        this.preload = list;
    }

    public void setPreloadMD5(String str) {
        this.preloadMD5 = str;
    }

    public void setRequestUrl(RequestUrlModel requestUrlModel) {
        this.requestUrl = requestUrlModel;
    }

    public void setRequestUrlMD5(String str) {
        this.requestUrlMD5 = str;
    }

    public void setStatistics(StatisticsModel statisticsModel) {
        this.statistics = statisticsModel;
    }

    public void setStatisticsMD5(String str) {
        this.statisticsMD5 = str;
    }

    public void setStrategy(StrategyModel strategyModel) {
        this.strategy = strategyModel;
    }

    public void setStrategyMD5(String str) {
        this.strategyMD5 = str;
    }

    public void setTemplate(List<TemplateModel> list) {
        this.template = list;
    }

    public void setTemplateMD5(String str) {
        this.templateMD5 = str;
    }

    public void setUpdate(UpdateModel updateModel) {
        this.update = updateModel;
    }

    public void setUpdateMD5(String str) {
        this.updateMD5 = str;
    }

    public String toString() {
        return "{\"lastUpdateTime\":" + this.lastUpdateTime + ", \"updateMD5\":\"" + this.updateMD5 + "\", \"update\":" + this.update + ", \"requestUrlMD5\":\"" + this.requestUrlMD5 + "\", \"requestUrl\":" + this.requestUrl + ", \"strategyMD5\":\"" + this.strategyMD5 + "\", \"strategy\":" + this.strategy + ", \"preloadMD5\":\"" + this.preloadMD5 + "\", \"preload\":" + this.preload + ", \"templateMD5\":\"" + this.templateMD5 + "\", \"adCacheMD5\":\"" + this.adCacheMD5 + "\", \"adCache\":" + this.adCache + ", \"template\":" + this.template + ", \"statisticsMD5\":\"" + this.statisticsMD5 + "\", \"statistics\":" + this.statistics + "} ";
    }
}

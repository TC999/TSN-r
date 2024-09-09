package xyz.adscope.ad.control.strategy;

import java.util.List;
import xyz.adscope.ad.control.strategy.model.AdScopeHistoryEventModel;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.config.FrequencyModel;
import xyz.adscope.ad.model.http.response.config.StrategyFrequencyModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StrategyQuality extends BaseStrategyFrequency {
    @Override // xyz.adscope.ad.control.strategy.inter.IStrategy
    public boolean frequencyStrategyControl(int i4, AdScopeCycleModel adScopeCycleModel) {
        return false;
    }

    public List<AdScopeHistoryEventModel> getArrayWithApiKey(String str, String str2, String str3) {
        return StrategyEventCacheManager.getInstance().getArrayWithApiKey(str, str2, str3);
    }

    @Override // xyz.adscope.ad.control.strategy.inter.IStrategy
    public boolean qualityStrategyControl(StrategyFrequencyModel strategyFrequencyModel, AdScopeCycleModel adScopeCycleModel) {
        if (strategyFrequencyModel != null && strategyFrequencyModel.getFrequency() != null && strategyFrequencyModel.getFrequency().size() > 0) {
            for (FrequencyModel frequencyModel : strategyFrequencyModel.getFrequency()) {
                long relativeTime = frequencyModel.getRelativeTime();
                long[] absoluteTime = frequencyModel.getAbsoluteTime();
                int i4 = (relativeTime > 0L ? 1 : (relativeTime == 0L ? 0 : -1));
                if (i4 != 0 && absoluteTime != null && absoluteTime.length != 0) {
                    break;
                }
                List<AdScopeHistoryEventModel> arrayWithApiKey = getArrayWithApiKey(adScopeCycleModel.getApiKey(), adScopeCycleModel.getSpaceId(), frequencyModel.getEventCode());
                if (i4 != 0 && arrayWithApiKey.size() > frequencyModel.getCount() && arrayWithApiKey.get(frequencyModel.getCount() - 1).getEventTime() + frequencyModel.getRelativeTime() > DeviceInfoUtil.getTimeStamp()) {
                    return false;
                }
                if (absoluteTime != null && absoluteTime.length != 0 && arrayWithApiKey.size() > frequencyModel.getCount()) {
                    AdScopeHistoryEventModel adScopeHistoryEventModel = arrayWithApiKey.get(frequencyModel.getCount() - 1);
                    if (absoluteTime[0] <= DeviceInfoUtil.getTimeStamp() && absoluteTime[1] >= DeviceInfoUtil.getTimeStamp() && adScopeHistoryEventModel.getEventTime() > absoluteTime[0]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

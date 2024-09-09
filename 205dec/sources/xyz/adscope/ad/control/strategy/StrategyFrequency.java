package xyz.adscope.ad.control.strategy;

import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.config.StrategyFrequencyModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StrategyFrequency extends BaseStrategyFrequency {
    @Override // xyz.adscope.ad.control.strategy.inter.IStrategy
    public boolean frequencyStrategyControl(int i4, AdScopeCycleModel adScopeCycleModel) {
        return adScopeCycleModel != null && adScopeCycleModel.getTimeoutInterval() >= ((long) i4);
    }

    @Override // xyz.adscope.ad.control.strategy.inter.IStrategy
    public boolean qualityStrategyControl(StrategyFrequencyModel strategyFrequencyModel, AdScopeCycleModel adScopeCycleModel) {
        return false;
    }
}

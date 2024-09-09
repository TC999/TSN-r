package xyz.adscope.ad.control.strategy.inter;

import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.config.StrategyFrequencyModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IStrategy {
    boolean frequencyStrategyControl(int i4, AdScopeCycleModel adScopeCycleModel);

    boolean qualityStrategyControl(StrategyFrequencyModel strategyFrequencyModel, AdScopeCycleModel adScopeCycleModel);
}

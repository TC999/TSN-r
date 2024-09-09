package xyz.adscope.ad.config.inter;

import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.init.inter.InitCallback;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdConfig {
    void initConfigureFileWithChannel(AdInitConfig adInitConfig, InitCallback initCallback);

    void requestConfigureWithChannel(AdScopeGlobalModel adScopeGlobalModel, InitCallback initCallback);

    void startConfigureServerWithChannel(AdScopeGlobalModel adScopeGlobalModel);

    void updateConfigureWithChannel(AdScopeGlobalModel adScopeGlobalModel, String str);
}

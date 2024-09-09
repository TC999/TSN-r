package xyz.adscope.ad.init.inter;

import android.content.Context;
import java.util.Map;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface InitInterface {
    Map<String, AdScopeGlobalModel> getAdScopeGlobalMap();

    String getApiKey();

    AdScopeGlobalModel getApiModelWithApiKey(String str);

    AdInitConfig getGlobalAdInitConfig(String str);

    AdScopeGlobalModel getGlobalModel();

    void init(Context context, AdInitConfig adInitConfig, InitCallback initCallback);

    boolean isInitSuccess(String str);

    boolean isUseHttps();

    void startAsyncWithAppId(Context context, AdInitConfig adInitConfig, InitCallback initCallback);

    void startSyncWithAppId(Context context, AdInitConfig adInitConfig, InitCallback initCallback);
}

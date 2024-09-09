package xyz.adscope.ad.init;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.config.AdConfigManager;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.config.inter.IAdConfig;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.config.model.ConfigResponseInfo;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.control.strategy.StrategyUserProtection;
import xyz.adscope.ad.init.constant.InitError;
import xyz.adscope.ad.init.inter.InitCallback;
import xyz.adscope.ad.init.inter.InitInterface;
import xyz.adscope.ad.tool.crash.CrashHandler;
import xyz.adscope.ad.tool.event.ASNPUtil;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.common.cache.CacheManager;
import xyz.adscope.common.network.JsonConverter;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.KalleConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InitImplement implements InitInterface {
    private static IAdConfig iAdConfig = new AdConfigManager();
    private static String oaid;
    private static InitImplement sInstance;
    private AdScopeGlobalModel adScopeGlobalModel;
    private AdInitConfig config;
    private InitUserAgent initUserAgent = new InitUserAgent();
    private Map<String, AdInitConfig> adInitConfigMap = new HashMap();
    private Map<String, AdScopeGlobalModel> adScopeGlobalModelMap = new HashMap();

    private InitImplement() {
    }

    private void cleanCacheImage() {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.ad.init.c
            @Override // java.lang.Runnable
            public final void run() {
                InitImplement.lambda$cleanCacheImage$2();
            }
        });
    }

    public static InitImplement getInstance() {
        if (sInstance == null) {
            synchronized (InitImplement.class) {
                if (sInstance == null) {
                    sInstance = new InitImplement();
                }
            }
        }
        return sInstance;
    }

    private void initConfig(Context context) {
        if (this.config == null) {
            this.config = new AdInitConfig();
        }
        if (TextUtils.isEmpty(this.config.getApiKey()) && this.config.getBuilder() != null) {
            this.config.getBuilder().apiKey("AdScopeADN");
        }
        getDataBaseConfig();
        AdScopeGlobalModel apiModelWithApiKey = getApiModelWithApiKey(this.config.getApiKey());
        this.adScopeGlobalModel = apiModelWithApiKey;
        if (apiModelWithApiKey == null) {
            this.adScopeGlobalModel = new AdScopeGlobalModel();
        }
        this.adScopeGlobalModel.setSettings(this.config);
        this.adScopeGlobalModel.setSdkInitStartTime(System.currentTimeMillis());
        this.adScopeGlobalModel.setStartId(ASNPUtil.createRequestId());
        this.adScopeGlobalModel.setAppId(this.config.getAppId());
        this.adInitConfigMap.put(this.config.getApiKey(), this.config);
        this.adScopeGlobalModelMap.put(this.config.getApiKey(), this.adScopeGlobalModel);
        oaid = this.config.getCoaid();
        getUserAgent(context);
        CrashHandler.getInstance().init(context);
        asyncUpdateInfo();
        initNetWork(context);
        StrategyUserProtection.getInstance().init(this.config.getApiKey());
    }

    private void initNetWork(Context context) {
        Kalle.setConfig(KalleConfig.newBuilder().converter(new JsonConverter(context)).build());
        if (Kalle.getConfig() != null) {
            Kalle.getConfig().getHeaders().set("Accept-Encrypt", "101,1001");
        }
    }

    private boolean isNeedInit() {
        if (this.adScopeGlobalModel != null || TextUtils.isEmpty(this.config.getAppId())) {
            AdScopeGlobalModel adScopeGlobalModel = this.adScopeGlobalModel;
            return (adScopeGlobalModel == null || adScopeGlobalModel.isInitSuccess()) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cleanCacheImage$2() {
        CacheManager.getInstance(StubApp.getOrigApplicationContext(AdScopeSDK.getContext().getApplicationContext())).performCacheCleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDataBaseConfig$1() {
        if (ConfigResponseInfo.getInstance().isInit()) {
            return;
        }
        ConfigResponseInfo.getInstance().init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startAsyncWithAppId$0(AdInitConfig adInitConfig, InitCallback initCallback) {
        if (TextUtils.isEmpty(adInitConfig.getApiKey())) {
            return;
        }
        iAdConfig.initConfigureFileWithChannel(adInitConfig, initCallback);
    }

    public void asyncUpdateInfo() {
        cleanCacheImage();
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public Map<String, AdScopeGlobalModel> getAdScopeGlobalMap() {
        return this.adScopeGlobalModelMap;
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public String getApiKey() {
        AdInitConfig adInitConfig = this.config;
        return (adInitConfig == null || TextUtils.isEmpty(adInitConfig.getApiKey())) ? "" : this.config.getApiKey();
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public AdScopeGlobalModel getApiModelWithApiKey(String str) {
        Map<String, AdScopeGlobalModel> map = this.adScopeGlobalModelMap;
        if (map != null) {
            for (Map.Entry<String, AdScopeGlobalModel> entry : map.entrySet()) {
                if (entry.getKey().equals(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
        return null;
    }

    public String getChannel() {
        return getApiKey() + "_" + this.config.getAppId();
    }

    public void getDataBaseConfig() {
        AdScopeThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.ad.init.b
            @Override // java.lang.Runnable
            public final void run() {
                InitImplement.lambda$getDataBaseConfig$1();
            }
        });
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public AdInitConfig getGlobalAdInitConfig(String str) {
        Map<String, AdInitConfig> map = this.adInitConfigMap;
        if (map != null) {
            for (Map.Entry<String, AdInitConfig> entry : map.entrySet()) {
                if (entry.getKey().equals(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public AdScopeGlobalModel getGlobalModel() {
        AdInitConfig adInitConfig = this.config;
        if (adInitConfig == null || TextUtils.isEmpty(adInitConfig.getApiKey())) {
            return null;
        }
        return getApiModelWithApiKey(this.config.getApiKey());
    }

    public String getOaid() {
        return oaid;
    }

    public void getUserAgent(Context context) {
        this.initUserAgent.getUserAgent(context);
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public void init(Context context, AdInitConfig adInitConfig, InitCallback initCallback) {
        AdScopeGlobalModel adScopeGlobalModel;
        this.config = adInitConfig;
        initConfig(context);
        if (isNeedInit()) {
            if (adInitConfig.isSyncInit()) {
                startSyncWithAppId(context, adInitConfig, initCallback);
            } else {
                startAsyncWithAppId(context, adInitConfig, initCallback);
            }
        } else if (initCallback != null && (adScopeGlobalModel = this.adScopeGlobalModel) != null) {
            if (adScopeGlobalModel.isInitSuccess()) {
                initCallback.success();
            } else {
                InitError.INIT_ERROR init_error = InitError.INIT_ERROR.ERROR_UNKNOWN;
                initCallback.fail(init_error.getCode(), init_error.getValue());
            }
        }
        if (adInitConfig != null) {
            UIAdapterUtil.getInstance().setUiStyle(adInitConfig.getUiMode(), adInitConfig.getLightColor(), adInitConfig.getDarkColor());
        }
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public boolean isInitSuccess(String str) {
        for (Map.Entry<String, AdInitConfig> entry : this.adInitConfigMap.entrySet()) {
            if (entry.getKey().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public boolean isUseHttps() {
        AdInitConfig adInitConfig = this.config;
        if (adInitConfig != null) {
            return adInitConfig.isUseHttps();
        }
        return false;
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public void startAsyncWithAppId(Context context, final AdInitConfig adInitConfig, final InitCallback initCallback) {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.ad.init.a
            @Override // java.lang.Runnable
            public final void run() {
                InitImplement.lambda$startAsyncWithAppId$0(AdInitConfig.this, initCallback);
            }
        });
    }

    @Override // xyz.adscope.ad.init.inter.InitInterface
    public void startSyncWithAppId(Context context, AdInitConfig adInitConfig, InitCallback initCallback) {
        iAdConfig.initConfigureFileWithChannel(adInitConfig, initCallback);
    }
}

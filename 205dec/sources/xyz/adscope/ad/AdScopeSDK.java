package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.init.inter.InitCallback;
import xyz.adscope.ad.init.inter.InitInterface;
import xyz.adscope.ad.tool.request.AdScopeNetWorkInit;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeSDK {
    private static InitInterface initInterface = null;
    private static String mApplicationCode = null;
    private static Context mContext = null;
    public static String userAgent = "";

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum Singleton {
        INSTANCE;

        public String getAppId() {
            return AdScopeSDK.mApplicationCode;
        }

        public InitInterface getInitInterface() {
            return AdScopeSDK.initInterface;
        }

        public void init(Context context, AdInitConfig adInitConfig, InitCallback initCallback) {
            Context unused = AdScopeSDK.mContext = context.getApplicationContext();
            InitInterface unused2 = AdScopeSDK.initInterface = InitImplement.getInstance();
            if (AdScopeSDK.initInterface.isInitSuccess(adInitConfig.getApiKey())) {
                if (initCallback != null) {
                    initCallback.success();
                    return;
                }
                return;
            }
            AdScopeNetWorkInit.init(context);
            AdScopeSDK.initInterface.init(context, adInitConfig, initCallback);
            String unused3 = AdScopeSDK.mApplicationCode = adInitConfig.getAppId();
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getSDKVersion() {
        return "5.1.0.13";
    }
}

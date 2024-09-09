package xyz.adscope.ad.config.inter;

import java.util.Map;
import xyz.adscope.ad.config.AdscopeCustomController;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdInitConfig {
    int CCPA();

    int GDPR();

    int coppa();

    int countryCN();

    AdscopeCustomController getAdscopeCustomController();

    String getApiKey();

    String getAppId();

    String getAppName();

    String getCgaid();

    String getChannel();

    String getCoaid();

    String getCurrency();

    boolean getDebugSetting();

    Map<String, String> getOptionalFields();

    boolean getPersonalRecommend();

    int getTestAd();

    String getUserId();

    boolean isSyncInit();

    boolean isUseHttps();
}

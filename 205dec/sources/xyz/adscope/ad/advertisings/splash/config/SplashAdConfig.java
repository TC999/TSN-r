package xyz.adscope.ad.advertisings.splash.config;

import xyz.adscope.ad.advertisings.base.BaseAdConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SplashAdConfig extends BaseAdConfig {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder extends BaseAdConfig.Builder<SplashAdConfig, Builder> {
        @Override // xyz.adscope.ad.advertisings.base.BaseAdConfig.Builder
        public SplashAdConfig build() {
            SplashAdConfig splashAdConfig = new SplashAdConfig();
            splashAdConfig.setIntervalTime(this.intervalTime);
            splashAdConfig.setSpaceId(this.spaceId);
            splashAdConfig.setBidToken(this.bidToken);
            splashAdConfig.setCountryCN(this.countryCN);
            splashAdConfig.setTestAd(this.testAd);
            splashAdConfig.setApiKey(this.apiKey);
            return splashAdConfig;
        }
    }
}

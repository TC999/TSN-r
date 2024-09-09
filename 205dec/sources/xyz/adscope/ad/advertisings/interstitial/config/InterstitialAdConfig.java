package xyz.adscope.ad.advertisings.interstitial.config;

import xyz.adscope.ad.advertisings.base.BaseAdConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InterstitialAdConfig extends BaseAdConfig {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder extends BaseAdConfig.Builder<InterstitialAdConfig, Builder> {
        @Override // xyz.adscope.ad.advertisings.base.BaseAdConfig.Builder
        public InterstitialAdConfig build() {
            InterstitialAdConfig interstitialAdConfig = new InterstitialAdConfig();
            interstitialAdConfig.setIntervalTime(this.intervalTime);
            interstitialAdConfig.setSpaceId(this.spaceId);
            interstitialAdConfig.setBidToken(this.bidToken);
            interstitialAdConfig.setCountryCN(this.countryCN);
            interstitialAdConfig.setTestAd(this.testAd);
            interstitialAdConfig.setApiKey(this.apiKey);
            interstitialAdConfig.setMuted(this.isMuted);
            return interstitialAdConfig;
        }
    }
}

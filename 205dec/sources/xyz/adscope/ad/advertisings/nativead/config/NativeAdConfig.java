package xyz.adscope.ad.advertisings.nativead.config;

import xyz.adscope.ad.advertisings.base.BaseAdConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NativeAdConfig extends BaseAdConfig {
    public int adCount = 1;
    public float nativeAdViewHeight;
    public float nativeAdViewWidth;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder extends BaseAdConfig.Builder<NativeAdConfig, Builder> {
        private int adCount;
        private float nativeAdViewHeight;
        private float nativeAdViewWidth;

        public Builder adCount(int i4) {
            this.adCount = i4;
            return this;
        }

        public Builder expressViewAcceptedSize(float f4, float f5) {
            this.nativeAdViewWidth = f4;
            this.nativeAdViewHeight = f5;
            return this;
        }

        @Override // xyz.adscope.ad.advertisings.base.BaseAdConfig.Builder
        public NativeAdConfig build() {
            NativeAdConfig nativeAdConfig = new NativeAdConfig();
            nativeAdConfig.setAdCount(this.adCount);
            nativeAdConfig.setIntervalTime(this.intervalTime);
            nativeAdConfig.setSpaceId(this.spaceId);
            nativeAdConfig.setBidToken(this.bidToken);
            nativeAdConfig.setExpressViewAcceptedSize(this.nativeAdViewWidth, this.nativeAdViewHeight);
            nativeAdConfig.setCountryCN(this.countryCN);
            nativeAdConfig.setTestAd(this.testAd);
            nativeAdConfig.setApiKey(this.apiKey);
            nativeAdConfig.setMuted(this.isMuted);
            return nativeAdConfig;
        }
    }

    public int getAdCount() {
        return this.adCount;
    }

    public float getNativeAdViewHeight() {
        return this.nativeAdViewHeight;
    }

    public float getNativeAdViewWidth() {
        return this.nativeAdViewWidth;
    }

    public void setAdCount(int i4) {
        this.adCount = i4;
    }

    public void setExpressViewAcceptedSize(float f4, float f5) {
        this.nativeAdViewWidth = f4;
        this.nativeAdViewHeight = f5;
    }
}

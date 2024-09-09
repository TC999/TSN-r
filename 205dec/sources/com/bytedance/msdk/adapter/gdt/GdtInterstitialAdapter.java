package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTGlobalConfig;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtInterstitialAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private Context f26960s;

    /* renamed from: t  reason: collision with root package name */
    private TTVideoOption f26961t;

    /* renamed from: u  reason: collision with root package name */
    private GDTExtraOption f26962u;

    /* renamed from: v  reason: collision with root package name */
    private int f26963v;

    /* renamed from: w  reason: collision with root package name */
    private int f26964w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class GdtIntersitialAd extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private UnifiedInterstitialAD f26965a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26966b;

        /* renamed from: c  reason: collision with root package name */
        UnifiedInterstitialADListener f26967c = new UnifiedInterstitialADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.d().onInterstitialAdClick();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.d().onInterstitialClosed();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.d().onInterstitialShow();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.d().onAdLeftApplication();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.d().onAdOpened();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                GdtIntersitialAd gdtIntersitialAd;
                int i4;
                GdtIntersitialAd.this.f26966b = true;
                if (GdtInterstitialAdapter.this.isClientBidding()) {
                    GdtIntersitialAd gdtIntersitialAd2 = GdtIntersitialAd.this;
                    gdtIntersitialAd2.setCpm(gdtIntersitialAd2.f26965a.getECPM() != -1 ? GdtIntersitialAd.this.f26965a.getECPM() : 0.0d);
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(GdtInterstitialAdapter.this.getAdapterRit(), GdtInterstitialAdapter.this.getAdSlotId()) + "GDT \u63d2\u5c4f \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + GdtIntersitialAd.this.getCpm());
                }
                if (GdtIntersitialAd.this.f26965a.getAdPatternType() == 2) {
                    gdtIntersitialAd = GdtIntersitialAd.this;
                    i4 = 5;
                } else {
                    gdtIntersitialAd = GdtIntersitialAd.this;
                    i4 = 3;
                }
                gdtIntersitialAd.setImageMode(i4);
                GdtIntersitialAd gdtIntersitialAd3 = GdtIntersitialAd.this;
                GdtInterstitialAdapter.this.notifyAdLoaded(gdtIntersitialAd3);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                GdtIntersitialAd.this.f26966b = false;
                if (adError != null) {
                    GdtInterstitialAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtInterstitialAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, com.bytedance.msdk.api.AdError.getMessage(0)));
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        };

        GdtIntersitialAd(ITTAdapterInterstitialListener iTTAdapterInterstitialListener) {
            this.mTTAdatperCallback = iTTAdapterInterstitialListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterInterstitialListener d() {
            return (ITTAdapterInterstitialListener) this.mTTAdatperCallback;
        }

        void b() {
            Logger.d("TTMediationSDK", "GdtIntersitialAd load");
            if (!(GdtInterstitialAdapter.this.f26960s instanceof Activity)) {
                Logger.d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(GdtInterstitialAdapter.this.getAdapterRit(), GdtInterstitialAdapter.this.getAdSlotId()) + "GDT--\u63d2\u5c4f-\u4f20\u5165mContext \u4e0d\u662f Activity \u8bf7\u6c42\u4e2d\u65ad");
                return;
            }
            this.f26965a = new UnifiedInterstitialAD((Activity) GdtInterstitialAdapter.this.f26960s, GdtInterstitialAdapter.this.getAdSlotId(), this.f26967c);
            VideoOption videoOption = GDTAdapterUtils.getVideoOption(GdtInterstitialAdapter.this.f26962u);
            this.f26965a.setVideoOption(videoOption);
            if (GdtInterstitialAdapter.this.f26964w > 0) {
                this.f26965a.setMaxVideoDuration(GdtInterstitialAdapter.this.f26964w);
            }
            if (GdtInterstitialAdapter.this.f26963v > 0) {
                this.f26965a.setMinVideoDuration(GdtInterstitialAdapter.this.f26963v);
            }
            this.f26965a.setVideoPlayPolicy(GDTAdapterUtils.getVideoPlayPolicy(videoOption.getAutoPlayPolicy(), GdtInterstitialAdapter.this.f26960s));
            this.f26965a.loadAD();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 2;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f26965a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdCacheReady() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f26965a;
            return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f26966b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f26965a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
                this.f26965a = null;
            }
            this.mTTAdatperCallback = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.f26965a == null || activity == null || activity.isFinishing()) {
                return;
            }
            this.f26965a.show(activity);
        }
    }

    private void C(ITTAdapterInterstitialListener iTTAdapterInterstitialListener) {
        new GdtIntersitialAd(iTTAdapterInterstitialListener).b();
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        return SDKStatus.getSDKVersion();
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        this.f26960s = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            this.f26963v = map.get(TTGlobalConfig.MIN_VIDEO_DURATION) != null ? ((Integer) map.get(TTGlobalConfig.MIN_VIDEO_DURATION)).intValue() : 0;
            this.f26964w = map.get(TTGlobalConfig.MAX_VIDEO_DURATION) != null ? ((Integer) map.get(TTGlobalConfig.MAX_VIDEO_DURATION)).intValue() : 0;
            ITTAdapterInterstitialListener iTTAdapterInterstitialListener = obj instanceof ITTAdapterInterstitialListener ? (ITTAdapterInterstitialListener) obj : null;
            TTVideoOption tTVideoOption = this.mAdSlot.getTTVideoOption();
            this.f26961t = tTVideoOption;
            if (tTVideoOption != null) {
                this.f26962u = tTVideoOption.getGDTExtraOption();
            }
            C(iTTAdapterInterstitialListener);
        }
    }
}

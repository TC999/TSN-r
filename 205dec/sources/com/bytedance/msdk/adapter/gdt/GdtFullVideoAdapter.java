package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtFullVideoAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private Context f26948s;

    /* renamed from: t  reason: collision with root package name */
    private TTVideoOption f26949t;

    /* renamed from: u  reason: collision with root package name */
    private GDTExtraOption f26950u;

    /* renamed from: v  reason: collision with root package name */
    private int f26951v;

    /* renamed from: w  reason: collision with root package name */
    private int f26952w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class GdtFullVideoAd extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private UnifiedInterstitialAD f26953a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26954b;

        /* renamed from: c  reason: collision with root package name */
        UnifiedInterstitialADListener f26955c = new UnifiedInterstitialADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.d().onFullVideoAdClick();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.d().onFullVideoAdClosed();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.d().onFullVideoAdShow();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                GdtFullVideoAd.this.f26954b = true;
                if (GdtFullVideoAdapter.this.isClientBidding()) {
                    GdtFullVideoAd gdtFullVideoAd = GdtFullVideoAd.this;
                    gdtFullVideoAd.setCpm(gdtFullVideoAd.f26953a.getECPM() != -1 ? GdtFullVideoAd.this.f26953a.getECPM() : 0.0d);
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(GdtFullVideoAdapter.this.getAdapterRit(), GdtFullVideoAdapter.this.getAdSlotId()) + "GDT FullVideo \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + GdtFullVideoAd.this.getCpm());
                }
                if (GdtFullVideoAd.this.f26953a.getAdPatternType() == 2) {
                    GdtFullVideoAd.this.setImageMode(5);
                    GdtFullVideoAd.this.f26953a.setMediaListener(GdtFullVideoAd.this.f26956d);
                }
                GdtFullVideoAd gdtFullVideoAd2 = GdtFullVideoAd.this;
                GdtFullVideoAdapter.this.notifyAdLoaded(gdtFullVideoAd2);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                GdtFullVideoAd.this.f26954b = false;
                if (adError != null) {
                    GdtFullVideoAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtFullVideoAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, com.bytedance.msdk.api.AdError.getMessage(0)));
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
                GdtFullVideoAd gdtFullVideoAd = GdtFullVideoAd.this;
                GdtFullVideoAdapter.this.notifyAdVideoCache(gdtFullVideoAd, null);
            }
        };

        /* renamed from: d  reason: collision with root package name */
        UnifiedInterstitialMediaListener f26956d = new UnifiedInterstitialMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.2
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.d().onVideoComplete();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.d().onVideoError();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j4) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
            }
        };

        GdtFullVideoAd(ITTAdapterFullVideoAdListener iTTAdapterFullVideoAdListener) {
            this.mTTAdatperCallback = iTTAdapterFullVideoAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterFullVideoAdListener d() {
            return (ITTAdapterFullVideoAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        void b() {
            if (GdtFullVideoAdapter.this.f26948s instanceof Activity) {
                this.f26953a = new UnifiedInterstitialAD((Activity) GdtFullVideoAdapter.this.f26948s, GdtFullVideoAdapter.this.getAdSlotId(), this.f26955c);
                VideoOption videoOption = GDTAdapterUtils.getVideoOption(GdtFullVideoAdapter.this.f26950u);
                this.f26953a.setVideoOption(videoOption);
                if (GdtFullVideoAdapter.this.f26952w > 0) {
                    this.f26953a.setMaxVideoDuration(GdtFullVideoAdapter.this.f26952w);
                }
                if (GdtFullVideoAdapter.this.f26951v > 0) {
                    this.f26953a.setMinVideoDuration(GdtFullVideoAdapter.this.f26951v);
                }
                this.f26953a.setVideoPlayPolicy(GDTAdapterUtils.getVideoPlayPolicy(videoOption.getAutoPlayPolicy(), GdtFullVideoAdapter.this.f26948s));
                this.f26953a.loadFullScreenAD();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 8;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f26953a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdCacheReady() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f26953a;
            return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f26954b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f26953a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
                this.f26953a = null;
            }
            this.mTTAdatperCallback = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f26953a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.showFullScreenAD(activity);
            }
        }
    }

    private void C(ITTAdapterFullVideoAdListener iTTAdapterFullVideoAdListener) {
        new GdtFullVideoAd(iTTAdapterFullVideoAdListener).b();
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
        this.f26948s = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            TTVideoOption tTVideoOption = this.mAdSlot.getTTVideoOption();
            this.f26949t = tTVideoOption;
            if (tTVideoOption != null) {
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                this.f26950u = gDTExtraOption;
                if (gDTExtraOption != null) {
                    this.f26951v = gDTExtraOption.getGDTMinVideoDuration();
                    this.f26952w = this.f26950u.getGDTMaxVideoDuration();
                }
            }
            C(obj instanceof ITTAdapterFullVideoAdListener ? (ITTAdapterFullVideoAdListener) obj : null);
        }
    }
}

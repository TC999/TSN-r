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
import com.github.mikephil.charting.utils.Utils;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialAD;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtFullVideoAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21338s;

    /* renamed from: t */
    private TTVideoOption f21339t;

    /* renamed from: u */
    private GDTExtraOption f21340u;

    /* renamed from: v */
    private int f21341v;

    /* renamed from: w */
    private int f21342w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class GdtFullVideoAd extends TTBaseAd {

        /* renamed from: a */
        private UnifiedInterstitialAD f21343a;

        /* renamed from: b */
        private boolean f21344b;

        /* renamed from: c */
        UnifiedInterstitialADListener f21345c = new UnifiedInterstitialADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.1
            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.m37833d().onFullVideoAdClick();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.m37833d().onFullVideoAdClosed();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.m37833d().onFullVideoAdShow();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                GdtFullVideoAd.this.f21344b = true;
                if (GdtFullVideoAdapter.this.isClientBidding()) {
                    GdtFullVideoAd gdtFullVideoAd = GdtFullVideoAd.this;
                    gdtFullVideoAd.setCpm(gdtFullVideoAd.f21343a.getECPM() != -1 ? GdtFullVideoAd.this.f21343a.getECPM() : Utils.DOUBLE_EPSILON);
                    Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(GdtFullVideoAdapter.this.getAdapterRit(), GdtFullVideoAdapter.this.getAdSlotId()) + "GDT FullVideo 返回的 cpm价格：" + GdtFullVideoAd.this.getCpm());
                }
                if (GdtFullVideoAd.this.f21343a.getAdPatternType() == 2) {
                    GdtFullVideoAd.this.setImageMode(5);
                    GdtFullVideoAd.this.f21343a.setMediaListener(GdtFullVideoAd.this.f21346d);
                }
                GdtFullVideoAd gdtFullVideoAd2 = GdtFullVideoAd.this;
                GdtFullVideoAdapter.this.notifyAdLoaded(gdtFullVideoAd2);
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                GdtFullVideoAd.this.f21344b = false;
                if (adError != null) {
                    GdtFullVideoAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtFullVideoAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, com.bytedance.msdk.api.AdError.getMessage(0)));
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                GdtFullVideoAd gdtFullVideoAd = GdtFullVideoAd.this;
                GdtFullVideoAdapter.this.notifyAdVideoCache(gdtFullVideoAd, null);
            }
        };

        /* renamed from: d */
        UnifiedInterstitialMediaListener f21346d = new UnifiedInterstitialMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.2
            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.m37833d().onVideoComplete();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
                if (((TTBaseAd) GdtFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.m37833d().onVideoError();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j) {
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
            }
        };

        GdtFullVideoAd(ITTAdapterFullVideoAdListener iTTAdapterFullVideoAdListener) {
            this.mTTAdatperCallback = iTTAdapterFullVideoAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public ITTAdapterFullVideoAdListener m37833d() {
            return (ITTAdapterFullVideoAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        /* renamed from: b */
        void m37835b() {
            if (GdtFullVideoAdapter.this.f21338s instanceof Activity) {
                this.f21343a = new UnifiedInterstitialAD((Activity) GdtFullVideoAdapter.this.f21338s, GdtFullVideoAdapter.this.getAdSlotId(), this.f21345c);
                VideoOption videoOption = GDTAdapterUtils.getVideoOption(GdtFullVideoAdapter.this.f21340u);
                this.f21343a.setVideoOption(videoOption);
                if (GdtFullVideoAdapter.this.f21342w > 0) {
                    this.f21343a.setMaxVideoDuration(GdtFullVideoAdapter.this.f21342w);
                }
                if (GdtFullVideoAdapter.this.f21341v > 0) {
                    this.f21343a.setMinVideoDuration(GdtFullVideoAdapter.this.f21341v);
                }
                this.f21343a.setVideoPlayPolicy(GDTAdapterUtils.getVideoPlayPolicy(videoOption.getAutoPlayPolicy(), GdtFullVideoAdapter.this.f21338s));
                this.f21343a.loadFullScreenAD();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 8;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21343a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdCacheReady() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f21343a;
            return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f21344b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f21343a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
                this.f21343a = null;
            }
            this.mTTAdatperCallback = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f21343a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.showFullScreenAD(activity);
            }
        }
    }

    /* renamed from: C */
    private void m37840C(ITTAdapterFullVideoAdListener iTTAdapterFullVideoAdListener) {
        new GdtFullVideoAd(iTTAdapterFullVideoAdListener).m37835b();
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
        this.f21338s = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            TTVideoOption tTVideoOption = this.mAdSlot.getTTVideoOption();
            this.f21339t = tTVideoOption;
            if (tTVideoOption != null) {
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                this.f21340u = gDTExtraOption;
                if (gDTExtraOption != null) {
                    this.f21341v = gDTExtraOption.getGDTMinVideoDuration();
                    this.f21342w = this.f21340u.getGDTMaxVideoDuration();
                }
            }
            m37840C(obj instanceof ITTAdapterFullVideoAdListener ? (ITTAdapterFullVideoAdListener) obj : null);
        }
    }
}

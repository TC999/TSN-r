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
import com.github.mikephil.charting.utils.Utils;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialAD;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtInterstitialAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21350s;

    /* renamed from: t */
    private TTVideoOption f21351t;

    /* renamed from: u */
    private GDTExtraOption f21352u;

    /* renamed from: v */
    private int f21353v;

    /* renamed from: w */
    private int f21354w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class GdtIntersitialAd extends TTBaseAd {

        /* renamed from: a */
        private UnifiedInterstitialAD f21355a;

        /* renamed from: b */
        private boolean f21356b;

        /* renamed from: c */
        UnifiedInterstitialADListener f21357c = new UnifiedInterstitialADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.1
            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.m37818d().onInterstitialAdClick();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.m37818d().onInterstitialClosed();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.m37818d().onInterstitialShow();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.m37818d().onAdLeftApplication();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                if (((TTBaseAd) GdtIntersitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.m37818d().onAdOpened();
                }
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                GdtIntersitialAd gdtIntersitialAd;
                int i;
                GdtIntersitialAd.this.f21356b = true;
                if (GdtInterstitialAdapter.this.isClientBidding()) {
                    GdtIntersitialAd gdtIntersitialAd2 = GdtIntersitialAd.this;
                    gdtIntersitialAd2.setCpm(gdtIntersitialAd2.f21355a.getECPM() != -1 ? GdtIntersitialAd.this.f21355a.getECPM() : Utils.DOUBLE_EPSILON);
                    Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(GdtInterstitialAdapter.this.getAdapterRit(), GdtInterstitialAdapter.this.getAdSlotId()) + "GDT 插屏 返回的 cpm价格：" + GdtIntersitialAd.this.getCpm());
                }
                if (GdtIntersitialAd.this.f21355a.getAdPatternType() == 2) {
                    gdtIntersitialAd = GdtIntersitialAd.this;
                    i = 5;
                } else {
                    gdtIntersitialAd = GdtIntersitialAd.this;
                    i = 3;
                }
                gdtIntersitialAd.setImageMode(i);
                GdtIntersitialAd gdtIntersitialAd3 = GdtIntersitialAd.this;
                GdtInterstitialAdapter.this.notifyAdLoaded(gdtIntersitialAd3);
            }

            @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                GdtIntersitialAd.this.f21356b = false;
                if (adError != null) {
                    GdtInterstitialAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtInterstitialAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, com.bytedance.msdk.api.AdError.getMessage(0)));
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
            }
        };

        GdtIntersitialAd(ITTAdapterInterstitialListener iTTAdapterInterstitialListener) {
            this.mTTAdatperCallback = iTTAdapterInterstitialListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public ITTAdapterInterstitialListener m37818d() {
            return (ITTAdapterInterstitialListener) this.mTTAdatperCallback;
        }

        /* renamed from: b */
        void m37820b() {
            Logger.m37562d("TTMediationSDK", "GdtIntersitialAd load");
            if (!(GdtInterstitialAdapter.this.f21350s instanceof Activity)) {
                Logger.m37562d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(GdtInterstitialAdapter.this.getAdapterRit(), GdtInterstitialAdapter.this.getAdSlotId()) + "GDT--插屏-传入mContext 不是 Activity 请求中断");
                return;
            }
            this.f21355a = new UnifiedInterstitialAD((Activity) GdtInterstitialAdapter.this.f21350s, GdtInterstitialAdapter.this.getAdSlotId(), this.f21357c);
            VideoOption videoOption = GDTAdapterUtils.getVideoOption(GdtInterstitialAdapter.this.f21352u);
            this.f21355a.setVideoOption(videoOption);
            if (GdtInterstitialAdapter.this.f21354w > 0) {
                this.f21355a.setMaxVideoDuration(GdtInterstitialAdapter.this.f21354w);
            }
            if (GdtInterstitialAdapter.this.f21353v > 0) {
                this.f21355a.setMinVideoDuration(GdtInterstitialAdapter.this.f21353v);
            }
            this.f21355a.setVideoPlayPolicy(GDTAdapterUtils.getVideoPlayPolicy(videoOption.getAutoPlayPolicy(), GdtInterstitialAdapter.this.f21350s));
            this.f21355a.loadAD();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 2;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21355a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdCacheReady() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f21355a;
            return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f21356b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f21355a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
                this.f21355a = null;
            }
            this.mTTAdatperCallback = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.f21355a == null || activity == null || activity.isFinishing()) {
                return;
            }
            this.f21355a.show(activity);
        }
    }

    /* renamed from: C */
    private void m37825C(ITTAdapterInterstitialListener iTTAdapterInterstitialListener) {
        new GdtIntersitialAd(iTTAdapterInterstitialListener).m37820b();
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
        this.f21350s = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            this.f21353v = map.get(TTGlobalConfig.MIN_VIDEO_DURATION) != null ? ((Integer) map.get(TTGlobalConfig.MIN_VIDEO_DURATION)).intValue() : 0;
            this.f21354w = map.get(TTGlobalConfig.MAX_VIDEO_DURATION) != null ? ((Integer) map.get(TTGlobalConfig.MAX_VIDEO_DURATION)).intValue() : 0;
            ITTAdapterInterstitialListener iTTAdapterInterstitialListener = obj instanceof ITTAdapterInterstitialListener ? (ITTAdapterInterstitialListener) obj : null;
            TTVideoOption tTVideoOption = this.mAdSlot.getTTVideoOption();
            this.f21351t = tTVideoOption;
            if (tTVideoOption != null) {
                this.f21352u = tTVideoOption.getGDTExtraOption();
            }
            m37825C(iTTAdapterInterstitialListener);
        }
    }
}

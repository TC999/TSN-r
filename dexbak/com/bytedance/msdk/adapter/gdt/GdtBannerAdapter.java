package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.TTBaseAd;
import com.p518qq.p519e.ads.banner2.UnifiedBannerADListener;
import com.p518qq.p519e.ads.banner2.UnifiedBannerView;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtBannerAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private int f21331s = 30;

    /* renamed from: t */
    private Context f21332t;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class GdtBanner extends TTBaseAd {

        /* renamed from: a */
        private UnifiedBannerView f21333a;

        /* renamed from: b */
        private boolean f21334b = false;

        /* renamed from: c */
        private UnifiedBannerADListener f21335c = new UnifiedBannerADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtBanner.1
            @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.m37848d().onAdClicked();
                }
            }

            public void onADCloseOverlay() {
            }

            @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.m37848d().onAdClosed();
                }
            }

            @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.m37848d().onAdShow();
                }
            }

            @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.m37848d().onAdLeftApplication();
                }
            }

            public void onADOpenOverlay() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.m37848d().onAdOpened();
                }
            }

            @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                if (GdtBanner.this.f21334b) {
                    return;
                }
                GdtBanner gdtBanner = GdtBanner.this;
                GdtBannerAdapter.this.notifyAdLoaded(gdtBanner);
                GdtBanner.this.f21334b = true;
            }

            @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                if (GdtBanner.this.f21334b) {
                    return;
                }
                GdtBanner.this.f21334b = true;
                if (adError != null) {
                    GdtBannerAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtBannerAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, com.bytedance.msdk.api.AdError.getMessage(0)));
                }
            }
        };

        GdtBanner(ITTAdapterBannerAdListener iTTAdapterBannerAdListener) {
            this.mTTAdatperCallback = iTTAdapterBannerAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public ITTAdapterBannerAdListener m37848d() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        /* renamed from: a */
        void m37851a() {
            if (GdtBannerAdapter.this.f21332t instanceof Activity) {
                UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) GdtBannerAdapter.this.f21332t, GdtBannerAdapter.this.getAdSlotId(), this.f21335c);
                this.f21333a = unifiedBannerView;
                unifiedBannerView.setRefresh(GdtBannerAdapter.this.f21331s);
                this.f21333a.loadAD();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 1;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public View getAdView() {
            return this.f21333a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21333a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedBannerView unifiedBannerView = this.f21333a;
            if (unifiedBannerView != null) {
                unifiedBannerView.destroy();
            }
            this.mTTAdatperCallback = null;
            this.f21333a = null;
            super.onDestroy();
        }
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
        this.f21332t = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            ITTAdapterBannerAdListener iTTAdapterBannerAdListener = obj instanceof ITTAdapterBannerAdListener ? (ITTAdapterBannerAdListener) obj : null;
            int intValue = map.containsKey(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME) ? ((Integer) map.get(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME)).intValue() : 30;
            this.f21331s = intValue;
            if (intValue < 0) {
                this.f21331s = 30;
            } else if (intValue > 120) {
                this.f21331s = 120;
            }
            new GdtBanner(iTTAdapterBannerAdListener).m37851a();
        }
    }
}

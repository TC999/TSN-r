package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtBannerAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private int f26941s = 30;

    /* renamed from: t  reason: collision with root package name */
    private Context f26942t;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class GdtBanner extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private UnifiedBannerView f26943a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26944b = false;

        /* renamed from: c  reason: collision with root package name */
        private UnifiedBannerADListener f26945c = new UnifiedBannerADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtBanner.1
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.d().onAdClicked();
                }
            }

            public void onADCloseOverlay() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.d().onAdClosed();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.d().onAdShow();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.d().onAdLeftApplication();
                }
            }

            public void onADOpenOverlay() {
                if (((TTBaseAd) GdtBanner.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.d().onAdOpened();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                if (GdtBanner.this.f26944b) {
                    return;
                }
                GdtBanner gdtBanner = GdtBanner.this;
                GdtBannerAdapter.this.notifyAdLoaded(gdtBanner);
                GdtBanner.this.f26944b = true;
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                if (GdtBanner.this.f26944b) {
                    return;
                }
                GdtBanner.this.f26944b = true;
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
        public ITTAdapterBannerAdListener d() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        void a() {
            if (GdtBannerAdapter.this.f26942t instanceof Activity) {
                UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) GdtBannerAdapter.this.f26942t, GdtBannerAdapter.this.getAdSlotId(), this.f26945c);
                this.f26943a = unifiedBannerView;
                unifiedBannerView.setRefresh(GdtBannerAdapter.this.f26941s);
                this.f26943a.loadAD();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 1;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public View getAdView() {
            return this.f26943a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f26943a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedBannerView unifiedBannerView = this.f26943a;
            if (unifiedBannerView != null) {
                unifiedBannerView.destroy();
            }
            this.mTTAdatperCallback = null;
            this.f26943a = null;
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
        this.f26942t = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            ITTAdapterBannerAdListener iTTAdapterBannerAdListener = obj instanceof ITTAdapterBannerAdListener ? (ITTAdapterBannerAdListener) obj : null;
            int intValue = map.containsKey(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME) ? ((Integer) map.get(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME)).intValue() : 30;
            this.f26941s = intValue;
            if (intValue < 0) {
                this.f26941s = 30;
            } else if (intValue > 120) {
                this.f26941s = 120;
            }
            new GdtBanner(iTTAdapterBannerAdListener).a();
        }
    }
}

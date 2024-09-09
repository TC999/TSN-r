package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.bytedance.msdk.adapter.SplashDismissController;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtSplashAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private Context f27017s;

    /* renamed from: u  reason: collision with root package name */
    private GDTSplashAd f27019u;

    /* renamed from: w  reason: collision with root package name */
    private SplashDismissController f27021w;

    /* renamed from: t  reason: collision with root package name */
    private int f27018t = 3000;

    /* renamed from: v  reason: collision with root package name */
    boolean f27020v = false;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class GDTSplashAd extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private SplashAD f27022a;

        /* renamed from: b  reason: collision with root package name */
        private RelativeLayout f27023b;

        /* renamed from: c  reason: collision with root package name */
        private FrameLayout f27024c;

        /* renamed from: d  reason: collision with root package name */
        SplashADZoomOutListener f27025d = new SplashADZoomOutListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.1
            public long millisUntilFinished;

            @Override // com.qq.e.ads.splash.SplashADZoomOutListener
            public boolean isSupportZoomOut() {
                Log.d("TTMediationSDK", "GDT-\u5f00\u5c4f\u5e7f\u544a--isSupportZoomOut");
                return true;
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                Log.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(GdtSplashAdapter.this.getAdapterRit(), GdtSplashAdapter.this.getAdSlotId()) + "GDT-\u5f00\u5c4f\u5e7f\u544a--onADClicked....");
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    if (GdtSplashAdapter.this.f27021w != null) {
                        GdtSplashAdapter.this.f27021w.setClick(true);
                        GdtSplashAdapter.this.f27021w.setCallBack(new SplashDismissController.CallBack() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.1.1
                            @Override // com.bytedance.msdk.adapter.SplashDismissController.CallBack
                            public void onResume() {
                                if (GdtSplashAdapter.this.f27021w == null || !GdtSplashAdapter.this.f27021w.jumpToAdPage() || GdtSplashAdapter.this.f27021w.isCallDismiss() || !(((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                                    return;
                                }
                                GDTSplashAd.this.a().onAdDismiss();
                            }
                        });
                    }
                    GDTSplashAd.this.a().onAdClicked();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    if (GdtSplashAdapter.this.f27021w == null || !GdtSplashAdapter.this.f27021w.jumpToAdPage()) {
                        if (GdtSplashAdapter.this.f27021w != null) {
                            GdtSplashAdapter.this.f27021w.setCallDismiss(true);
                        }
                        GDTSplashAd.this.a().onAdDismiss();
                    }
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.a().onAdShow();
                }
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(GdtSplashAdapter.this.getAdapterRit(), GdtSplashAdapter.this.getAdSlotId()) + "GDT-\u5f00\u5c4f\u5e7f\u544a_onADExposure......onADExposure.....");
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long j4) {
                int i4 = ((j4 - SystemClock.elapsedRealtime()) > 1000L ? 1 : ((j4 - SystemClock.elapsedRealtime()) == 1000L ? 0 : -1));
                GDTSplashAd gDTSplashAd = GDTSplashAd.this;
                if (i4 > 0) {
                    GdtSplashAdapter.this.notifyAdLoaded(gDTSplashAd);
                } else {
                    GdtSplashAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(20001, "Ad has expired !"));
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j4) {
                this.millisUntilFinished = j4;
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                GdtSplashAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.qq.e.ads.splash.SplashADZoomOutListener
            public void onZoomOut() {
                Log.d("TTMediationSDK", "GDT-\u5f00\u5c4f\u5e7f\u544a--onZoomOut");
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.a().onMinWindowStart();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADZoomOutListener
            public void onZoomOutPlayFinish() {
                Log.d("TTMediationSDK", "GDT-\u5f00\u5c4f\u5e7f\u544a--onZoomOutPlayFinish");
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.a().onMinWindowPlayFinish();
                }
            }
        };

        @RequiresApi(api = 16)
        GDTSplashAd(ITTAdapterSplashAdListener iTTAdapterSplashAdListener) {
            this.mTTAdatperCallback = iTTAdapterSplashAdListener;
            RelativeLayout relativeLayout = new RelativeLayout(GdtSplashAdapter.this.f27017s);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout = new FrameLayout(GdtSplashAdapter.this.f27017s);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            relativeLayout.addView(frameLayout);
            this.f27024c = frameLayout;
            this.f27023b = relativeLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterSplashAdListener a() {
            return (ITTAdapterSplashAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 3;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Bitmap getSplashBitMap() {
            SplashAD splashAD = this.f27022a;
            if (splashAD != null) {
                splashAD.getZoomOutBitmap();
                return null;
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f27022a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void loadAd() {
            /*
                r5 = this;
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                android.content.Context r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.C(r0)
                boolean r0 = r0 instanceof android.app.Activity
                if (r0 == 0) goto L50
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.F(r0)
                if (r0 >= 0) goto L1a
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                r1 = 3000(0xbb8, float:4.204E-42)
            L16:
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.B(r0, r1)
                goto L27
            L1a:
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.F(r0)
                r1 = 5000(0x1388, float:7.006E-42)
                if (r0 <= r1) goto L27
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                goto L16
            L27:
                com.qq.e.ads.splash.SplashAD r0 = new com.qq.e.ads.splash.SplashAD
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.C(r1)
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                com.qq.e.ads.splash.SplashADZoomOutListener r3 = r5.f27025d
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.F(r4)
                r0.<init>(r1, r2, r3, r4)
                r5.f27022a = r0
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                boolean r1 = r1.f27020v
                if (r1 == 0) goto L4b
                r0.preLoad()
            L4b:
                com.qq.e.ads.splash.SplashAD r0 = r5.f27022a
                r0.fetchAdOnly()
            L50:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.loadAd():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f27022a = null;
            this.f27025d = null;
            this.mTTAdatperCallback = null;
            GdtSplashAdapter.this.f27017s = null;
            GdtSplashAdapter.this.f27021w = null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashAd(ViewGroup viewGroup) {
            if (this.f27022a == null || viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            RelativeLayout relativeLayout = this.f27023b;
            if (relativeLayout == null || this.f27024c == null) {
                return;
            }
            ViewParent parent = relativeLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f27023b);
            }
            viewGroup.addView(this.f27023b, -1, -1);
            this.f27022a.showAd(this.f27024c);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void splashMinWindowAnimationFinish() {
            SplashAD splashAD = this.f27022a;
            if (splashAD != null) {
                splashAD.zoomOutAnimationFinish();
            }
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
        GDTExtraOption gDTExtraOption;
        this.f27017s = context;
        if (map != null) {
            this.f27018t = map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) != null ? ((Integer) map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : 0;
            String str = (String) map.get("tt_ad_network_config_appid");
            Context context2 = this.f27017s;
            if (context2 instanceof Activity) {
                this.f27021w = new SplashDismissController((Activity) context2);
            }
            Object obj = map.get("tt_ad_network_callback");
            ITTAdapterSplashAdListener iTTAdapterSplashAdListener = obj instanceof ITTAdapterSplashAdListener ? (ITTAdapterSplashAdListener) obj : null;
            TTVideoOption tTVideoOption = this.mAdSlot.getTTVideoOption();
            if (tTVideoOption != null && (gDTExtraOption = tTVideoOption.getGDTExtraOption()) != null) {
                this.f27020v = gDTExtraOption.isSplashPreLoad();
            }
            GDTSplashAd gDTSplashAd = new GDTSplashAd(iTTAdapterSplashAdListener);
            this.f27019u = gDTSplashAd;
            gDTSplashAd.loadAd();
        }
    }
}

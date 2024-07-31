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
import com.p518qq.p519e.ads.splash.SplashAD;
import com.p518qq.p519e.ads.splash.SplashADZoomOutListener;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtSplashAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21407s;

    /* renamed from: u */
    private GDTSplashAd f21409u;

    /* renamed from: w */
    private SplashDismissController f21411w;

    /* renamed from: t */
    private int f21408t = 3000;

    /* renamed from: v */
    boolean f21410v = false;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class GDTSplashAd extends TTBaseAd {

        /* renamed from: a */
        private SplashAD f21412a;

        /* renamed from: b */
        private RelativeLayout f21413b;

        /* renamed from: c */
        private FrameLayout f21414c;

        /* renamed from: d */
        SplashADZoomOutListener f21415d = new SplashADZoomOutListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.1
            public long millisUntilFinished;

            @Override // com.p518qq.p519e.ads.splash.SplashADZoomOutListener
            public boolean isSupportZoomOut() {
                Log.d("TTMediationSDK", "GDT-开屏广告--isSupportZoomOut");
                return true;
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onADClicked() {
                Log.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(GdtSplashAdapter.this.getAdapterRit(), GdtSplashAdapter.this.getAdSlotId()) + "GDT-开屏广告--onADClicked....");
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    if (GdtSplashAdapter.this.f21411w != null) {
                        GdtSplashAdapter.this.f21411w.setClick(true);
                        GdtSplashAdapter.this.f21411w.setCallBack(new SplashDismissController.CallBack() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.1.1
                            @Override // com.bytedance.msdk.adapter.SplashDismissController.CallBack
                            public void onResume() {
                                if (GdtSplashAdapter.this.f21411w == null || !GdtSplashAdapter.this.f21411w.jumpToAdPage() || GdtSplashAdapter.this.f21411w.isCallDismiss() || !(((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                                    return;
                                }
                                GDTSplashAd.this.m37739a().onAdDismiss();
                            }
                        });
                    }
                    GDTSplashAd.this.m37739a().onAdClicked();
                }
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onADDismissed() {
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    if (GdtSplashAdapter.this.f21411w == null || !GdtSplashAdapter.this.f21411w.jumpToAdPage()) {
                        if (GdtSplashAdapter.this.f21411w != null) {
                            GdtSplashAdapter.this.f21411w.setCallDismiss(true);
                        }
                        GDTSplashAd.this.m37739a().onAdDismiss();
                    }
                }
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onADExposure() {
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.m37739a().onAdShow();
                }
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(GdtSplashAdapter.this.getAdapterRit(), GdtSplashAdapter.this.getAdSlotId()) + "GDT-开屏广告_onADExposure......onADExposure.....");
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onADLoaded(long j) {
                int i = ((j - SystemClock.elapsedRealtime()) > 1000L ? 1 : ((j - SystemClock.elapsedRealtime()) == 1000L ? 0 : -1));
                GDTSplashAd gDTSplashAd = GDTSplashAd.this;
                if (i > 0) {
                    GdtSplashAdapter.this.notifyAdLoaded(gDTSplashAd);
                } else {
                    GdtSplashAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(20001, "Ad has expired !"));
                }
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onADPresent() {
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onADTick(long j) {
                this.millisUntilFinished = j;
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                GdtSplashAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADZoomOutListener
            public void onZoomOut() {
                Log.d("TTMediationSDK", "GDT-开屏广告--onZoomOut");
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.m37739a().onMinWindowStart();
                }
            }

            @Override // com.p518qq.p519e.ads.splash.SplashADZoomOutListener
            public void onZoomOutPlayFinish() {
                Log.d("TTMediationSDK", "GDT-开屏广告--onZoomOutPlayFinish");
                if (((TTBaseAd) GDTSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.m37739a().onMinWindowPlayFinish();
                }
            }
        };

        @RequiresApi(api = 16)
        GDTSplashAd(ITTAdapterSplashAdListener iTTAdapterSplashAdListener) {
            this.mTTAdatperCallback = iTTAdapterSplashAdListener;
            RelativeLayout relativeLayout = new RelativeLayout(GdtSplashAdapter.this.f21407s);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout = new FrameLayout(GdtSplashAdapter.this.f21407s);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            relativeLayout.addView(frameLayout);
            this.f21414c = frameLayout;
            this.f21413b = relativeLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public ITTAdapterSplashAdListener m37739a() {
            return (ITTAdapterSplashAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 3;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Bitmap getSplashBitMap() {
            SplashAD splashAD = this.f21412a;
            if (splashAD != null) {
                splashAD.getZoomOutBitmap();
                return null;
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21412a == null;
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
                android.content.Context r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.m37744C(r0)
                boolean r0 = r0 instanceof android.app.Activity
                if (r0 == 0) goto L50
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.m37741F(r0)
                if (r0 >= 0) goto L1a
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                r1 = 3000(0xbb8, float:4.204E-42)
            L16:
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.m37745B(r0, r1)
                goto L27
            L1a:
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.m37741F(r0)
                r1 = 5000(0x1388, float:7.006E-42)
                if (r0 <= r1) goto L27
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                goto L16
            L27:
                com.qq.e.ads.splash.SplashAD r0 = new com.qq.e.ads.splash.SplashAD
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.m37744C(r1)
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                com.qq.e.ads.splash.SplashADZoomOutListener r3 = r5.f21415d
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.m37741F(r4)
                r0.<init>(r1, r2, r3, r4)
                r5.f21412a = r0
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                boolean r1 = r1.f21410v
                if (r1 == 0) goto L4b
                r0.preLoad()
            L4b:
                com.qq.e.ads.splash.SplashAD r0 = r5.f21412a
                r0.fetchAdOnly()
            L50:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.loadAd():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f21412a = null;
            this.f21415d = null;
            this.mTTAdatperCallback = null;
            GdtSplashAdapter.this.f21407s = null;
            GdtSplashAdapter.this.f21411w = null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashAd(ViewGroup viewGroup) {
            if (this.f21412a == null || viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            RelativeLayout relativeLayout = this.f21413b;
            if (relativeLayout == null || this.f21414c == null) {
                return;
            }
            ViewParent parent = relativeLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f21413b);
            }
            viewGroup.addView(this.f21413b, -1, -1);
            this.f21412a.showAd(this.f21414c);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void splashMinWindowAnimationFinish() {
            SplashAD splashAD = this.f21412a;
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
        this.f21407s = context;
        if (map != null) {
            this.f21408t = map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) != null ? ((Integer) map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : 0;
            String str = (String) map.get("tt_ad_network_config_appid");
            Context context2 = this.f21407s;
            if (context2 instanceof Activity) {
                this.f21411w = new SplashDismissController((Activity) context2);
            }
            Object obj = map.get("tt_ad_network_callback");
            ITTAdapterSplashAdListener iTTAdapterSplashAdListener = obj instanceof ITTAdapterSplashAdListener ? (ITTAdapterSplashAdListener) obj : null;
            TTVideoOption tTVideoOption = this.mAdSlot.getTTVideoOption();
            if (tTVideoOption != null && (gDTExtraOption = tTVideoOption.getGDTExtraOption()) != null) {
                this.f21410v = gDTExtraOption.isSplashPreLoad();
            }
            GDTSplashAd gDTSplashAd = new GDTSplashAd(iTTAdapterSplashAdListener);
            this.f21409u = gDTSplashAd;
            gDTSplashAd.loadAd();
        }
    }
}

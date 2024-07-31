package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.MainThread;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleSplashAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21485s;

    /* renamed from: t */
    private int f21486t = 3000;

    /* renamed from: u */
    private PangleSplashAd f21487u;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class PangleSplashAd extends TTBaseAd {

        /* renamed from: a */
        private TTSplashAd f21488a;

        /* renamed from: b */
        boolean f21489b;

        /* renamed from: c */
        TTAdNative.SplashAdListener f21490c = new TTAdNative.SplashAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
            @MainThread
            public void onError(int i, String str) {
                PangleSplashAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
            @MainThread
            public void onSplashAdLoad(TTSplashAd tTSplashAd) {
                Map<String, Object> mediaExtraInfo;
                if (tTSplashAd == null) {
                    PangleSplashAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.AD_NO_FILL));
                    return;
                }
                PangleSplashAd.this.f21488a = tTSplashAd;
                PangleSplashAd.this.setExpressAd(true);
                PangleSplashAd pangleSplashAd = PangleSplashAd.this;
                pangleSplashAd.setInteractionType(pangleSplashAd.f21488a.getInteractionType());
                if (PangleSplashAdapter.this.isClientBidding() && (mediaExtraInfo = PangleSplashAd.this.f21488a.getMediaExtraInfo()) != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                    Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleSplashAdapter.this.getAdapterRit(), PangleSplashAdapter.this.getAdSlotId()) + "pangle Splash 返回的 cpm价格：" + value);
                    PangleSplashAd pangleSplashAd2 = PangleSplashAd.this;
                    if (value <= Utils.DOUBLE_EPSILON) {
                        value = 0.0d;
                    }
                    pangleSplashAd2.setCpm(value);
                }
                PangleSplashAd.this.f21488a.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdClicked(View view, int i) {
                        if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                            PangleSplashAd.this.m37591a().onAdClicked();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdShow(View view, int i) {
                        if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                            PangleSplashAd.this.m37591a().onAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdSkip() {
                        Logger.m37557e("TTMediationSDK", "穿山甲_splash_onAdSkip");
                        if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                            PangleSplashAd.this.m37591a().onAdSkip();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdTimeOver() {
                        Logger.m37557e("TTMediationSDK", "穿山甲_splash_onAdTimeOver");
                        if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                            PangleSplashAd.this.m37591a().onAdDismiss();
                        }
                    }
                });
                PangleSplashAd.this.f21488a.setSplashClickEyeListener(new ISplashClickEyeListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1.2
                    @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                    public boolean isSupportSplashClickEye(boolean z) {
                        Logger.m37557e("TTMediationSDK", "穿山甲_splash_isSupportSplashClickEye:" + z);
                        PangleSplashAd.this.f21489b = z;
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                    public void onSplashClickEyeAnimationFinish() {
                        Logger.m37557e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeAnimationFinish");
                        if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                            PangleSplashAd.this.m37591a().onMinWindowPlayFinish();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                    public void onSplashClickEyeAnimationStart() {
                        Logger.m37557e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeAnimationStart");
                        PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                        if (pangleSplashAd3.f21489b && (((TTBaseAd) pangleSplashAd3).mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                            PangleSplashAd.this.m37591a().onMinWindowStart();
                        }
                    }
                });
                PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                PangleSplashAdapter.this.notifyAdLoaded(pangleSplashAd3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
            @MainThread
            public void onTimeout() {
                PangleSplashAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(4011, "splash ad load timeout !"));
            }
        };

        PangleSplashAd(ITTAdapterSplashAdListener iTTAdapterSplashAdListener) {
            this.mTTAdatperCallback = iTTAdapterSplashAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public ITTAdapterSplashAdListener m37591a() {
            return (ITTAdapterSplashAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd != null) {
                return PangleAdapterUtils.getAdId(tTSplashAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return ((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getAdType();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd != null) {
                return PangleAdapterUtils.getCreativeId(tTSplashAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int[] getMinWindowSize() {
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd != null) {
                tTSplashAd.getSplashClickEyeSizeToDp();
                return null;
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd != null) {
                return PangleAdapterUtils.getReqId(tTSplashAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21488a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return true;
        }

        void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleSplashAdapter.this.f21485s);
            AdSlot.Builder downloadType = new AdSlot.Builder().setCodeId(PangleSplashAdapter.this.getAdSlotId()).setSupportDeepLink(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.isSupportDeepLink()).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getAdUnitId()).setImageAcceptedSize(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getImgAcceptedWidth(), ((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getImgAcceptedHeight()).setExpressViewAcceptedSize(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getImgAcceptedWidth(), ((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getImgAcceptedHeight()).setSplashButtonType(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getSplashButtonType()).setDownloadType(((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mAdSlot.getDownloadType());
            if (!TextUtils.isEmpty(PangleSplashAdapter.this.getAdm())) {
                downloadType.withBid(PangleSplashAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(downloadType, ((TTAbsAdLoaderAdapter) PangleSplashAdapter.this).mWaterfallAbTestParam, PangleSplashAdapter.this.getClientReqId(), false);
            createAdNative.loadSplashAd(downloadType.build(), this.f21490c, PangleSplashAdapter.this.f21486t);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd != null) {
                tTSplashAd.setSplashInteractionListener(null);
                this.f21488a.setDownloadListener(null);
                this.f21488a.renderExpressAd(null);
                this.f21488a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashAd(ViewGroup viewGroup) {
            View splashView;
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd == null || viewGroup == null || (splashView = tTSplashAd.getSplashView()) == null) {
                return;
            }
            ViewParent parent = splashView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(splashView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(splashView);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void splashMinWindowAnimationFinish() {
            TTSplashAd tTSplashAd = this.f21488a;
            if (tTSplashAd != null) {
                tTSplashAd.splashClickEyeAnimationFinish();
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        return TTPangleSDKInitManager.get().getSDKVersion();
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        this.f21485s = context;
        if (map != null) {
            this.f21486t = map.containsKey(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) ? ((Integer) map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : this.f21486t;
            Object obj = map.get("tt_ad_network_callback");
            PangleSplashAd pangleSplashAd = new PangleSplashAd(obj instanceof ITTAdapterSplashAdListener ? (ITTAdapterSplashAdListener) obj : null);
            this.f21487u = pangleSplashAd;
            pangleSplashAd.loadAd();
        }
    }
}

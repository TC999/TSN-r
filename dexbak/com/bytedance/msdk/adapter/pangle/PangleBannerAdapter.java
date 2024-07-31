package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleBannerAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21423s;

    /* renamed from: t */
    private int f21424t = 30;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class TTBannerView extends TTBaseAd {

        /* renamed from: a */
        TTNativeExpressAd f21425a;

        /* renamed from: b */
        View f21426b;

        /* renamed from: d */
        private boolean f21428d;

        /* renamed from: c */
        final Object f21427c = new Object();

        /* renamed from: e */
        TTNativeExpressAd.ExpressAdInteractionListener f21429e = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (((TTBaseAd) TTBannerView.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    TTBannerView.this.m37715a().onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                if (((TTBaseAd) TTBannerView.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    TTBannerView.this.m37715a().onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                TTBannerView.this.f21428d = false;
                Logger.m37557e("TTMediationSDK_banner", TTLogUtil.getTagThirdLevelById(PangleBannerAdapter.this.getAdapterRit(), PangleBannerAdapter.this.getAdSlotId()) + "TTBannerView onRenderFail -> code=" + i + ",msg=" + str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                Logger.m37557e("TTMediationSDK_banner", TTLogUtil.getTagThirdLevelById(PangleBannerAdapter.this.getAdapterRit(), PangleBannerAdapter.this.getAdSlotId()) + "TTBannerView onRenderSuccess 渲染成功！！");
                TTBannerView tTBannerView = TTBannerView.this;
                if (tTBannerView.f21426b instanceof FrameLayout) {
                    PangleBannerAdapter.this.removeFromParent(view);
                    ((FrameLayout) TTBannerView.this.f21426b).addView(view, new ViewGroup.LayoutParams(-1, -1));
                }
                TTBannerView.this.f21428d = true;
            }
        };

        TTBannerView(ITTAdapterBannerAdListener iTTAdapterBannerAdListener) {
            this.mTTAdatperCallback = iTTAdapterBannerAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public ITTAdapterBannerAdListener m37715a() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* renamed from: d */
        private int[] m37712d(int i) {
            switch (i) {
                case 1:
                    return new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 50};
                case 2:
                    return new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 100};
                case 3:
                    return new int[]{300, 250};
                case 4:
                    return new int[]{468, 60};
                case 5:
                    return new int[]{728, 90};
                case 6:
                    if (((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getImgAcceptedWidth() > 0 && ((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getImgAcceptedHeight() > 0) {
                        return new int[]{((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getImgAcceptedWidth(), ((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getImgAcceptedHeight()};
                    }
                    break;
            }
            return new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 50};
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21425a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return ((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getAdType();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public synchronized View getAdView() {
            synchronized (this.f21427c) {
                if (this.f21426b == null) {
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        long j = 2000 + uptimeMillis;
                        while (!this.f21428d && uptimeMillis < j) {
                            this.f21427c.wait(j - uptimeMillis);
                            uptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return this.f21426b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21425a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getCreativeId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21425a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21425a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        public void loadAd() {
            int[] m37712d = m37712d(((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getBannerSize());
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleBannerAdapter.this.f21423s);
            AdSlot.Builder expressViewAcceptedSize = new AdSlot.Builder().setCodeId(PangleBannerAdapter.this.getAdSlotId()).setSupportDeepLink(true).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getAdUnitId()).setAdCount(1).setDownloadType(((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mAdSlot.getDownloadType()).setExpressViewAcceptedSize(m37712d[0], m37712d[1]);
            if (!TextUtils.isEmpty(PangleBannerAdapter.this.getAdm())) {
                expressViewAcceptedSize.withBid(PangleBannerAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(expressViewAcceptedSize, ((TTAbsAdLoaderAdapter) PangleBannerAdapter.this).mWaterfallAbTestParam, PangleBannerAdapter.this.getClientReqId(), false);
            createAdNative.loadBannerExpressAd(expressViewAcceptedSize.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onError(int i, String str) {
                    PangleBannerAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    Map<String, Object> mediaExtraInfo;
                    if (list != null && list.size() != 0 && PangleBannerAdapter.this.f21423s != null) {
                        TTBannerView.this.f21425a = list.get(0);
                        TTBannerView tTBannerView = TTBannerView.this;
                        tTBannerView.f21425a.setSlideIntervalTime(PangleBannerAdapter.this.f21424t * 1000);
                        TTBannerView.this.setExpressAd(true);
                        TTBannerView tTBannerView2 = TTBannerView.this;
                        tTBannerView2.setInteractionType(tTBannerView2.f21425a.getInteractionType());
                        TTBannerView tTBannerView3 = TTBannerView.this;
                        tTBannerView3.setImageMode(tTBannerView3.f21425a.getImageMode());
                        if (PangleBannerAdapter.this.isClientBidding() && (mediaExtraInfo = TTBannerView.this.f21425a.getMediaExtraInfo()) != null) {
                            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                            Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleBannerAdapter.this.getAdapterRit(), PangleBannerAdapter.this.getAdSlotId()) + "pangle banner 返回的 cpm价格：" + value);
                            TTBannerView tTBannerView4 = TTBannerView.this;
                            if (value <= Utils.DOUBLE_EPSILON) {
                                value = 0.0d;
                            }
                            tTBannerView4.setCpm(value);
                        }
                        TTBannerView tTBannerView5 = TTBannerView.this;
                        tTBannerView5.f21425a.setExpressInteractionListener(tTBannerView5.f21429e);
                        TTBannerView.this.f21425a.render();
                        TTBannerView tTBannerView6 = TTBannerView.this;
                        tTBannerView6.f21426b = new FrameLayout(PangleBannerAdapter.this.f21423s);
                        TTBannerView tTBannerView7 = TTBannerView.this;
                        PangleBannerAdapter.this.notifyAdLoaded(tTBannerView7);
                        return;
                    }
                    PangleBannerAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.getMessage(20001)));
                }
            });
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            super.onDestroy();
            TTNativeExpressAd tTNativeExpressAd = this.f21425a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        TTNativeExpressAd tTNativeExpressAd2 = TTBannerView.this.f21425a;
                        if (tTNativeExpressAd2 != null) {
                            tTNativeExpressAd2.destroy();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final TTDislikeCallback tTDislikeCallback) {
            TTNativeExpressAd tTNativeExpressAd = this.f21425a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        TTDislikeCallback tTDislikeCallback2 = tTDislikeCallback;
                        if (tTDislikeCallback2 != null) {
                            tTDislikeCallback2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        TTDislikeCallback tTDislikeCallback2 = tTDislikeCallback;
                        if (tTDislikeCallback2 != null) {
                            tTDislikeCallback2.onSelected(i, str);
                            if (((TTBaseAd) TTBannerView.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                                TTBannerView.this.m37715a().onAdClosed();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        TTDislikeCallback tTDislikeCallback2 = tTDislikeCallback;
                        if (tTDislikeCallback2 != null) {
                            tTDislikeCallback2.onShow();
                        }
                    }
                });
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
        this.f21423s = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            ITTAdapterBannerAdListener iTTAdapterBannerAdListener = obj instanceof ITTAdapterBannerAdListener ? (ITTAdapterBannerAdListener) obj : null;
            int intValue = map.containsKey(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME) ? ((Integer) map.get(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME)).intValue() : 30;
            this.f21424t = intValue;
            if (intValue < 0) {
                this.f21424t = 30;
            } else if (intValue > 120) {
                this.f21424t = 120;
            }
            new TTBannerView(iTTAdapterBannerAdListener).loadAd();
        }
    }
}

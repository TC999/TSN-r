package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleInterstitialAdapter extends TTAbsAdLoaderAdapter {
    public static final String TAG = "PangleInterstitialAdapter";

    /* renamed from: s */
    private PangleExpressInterstitialAd f21443s;

    /* renamed from: t */
    private Context f21444t;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class PangleExpressInterstitialAd extends TTBaseAd {

        /* renamed from: a */
        private TTNativeExpressAd f21445a;

        /* renamed from: b */
        private boolean f21446b;

        /* renamed from: c */
        TTNativeExpressAd.AdInteractionListener f21447c = new TTNativeExpressAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (((TTBaseAd) PangleExpressInterstitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.m37682a().onInterstitialAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
            public void onAdDismiss() {
                if (((TTBaseAd) PangleExpressInterstitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.m37682a().onInterstitialClosed();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                if (((TTBaseAd) PangleExpressInterstitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.m37682a().onInterstitialShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                Logger.m37557e("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "PangleExpressInterstitialAd onRenderFail -> code=" + i + ",msg=" + str);
                PangleInterstitialAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                PangleExpressInterstitialAd.this.f21446b = true;
                Logger.m37562d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "穿山甲SDK--插屏-onRenderSucces");
                PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                PangleInterstitialAdapter.this.notifyAdLoaded(pangleExpressInterstitialAd);
            }
        };

        PangleExpressInterstitialAd(ITTAdapterInterstitialListener iTTAdapterInterstitialListener) {
            this.mTTAdatperCallback = iTTAdapterInterstitialListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public ITTAdapterInterstitialListener m37682a() {
            return (ITTAdapterInterstitialListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21445a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getAdType();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21445a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getCreativeId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTNativeExpressAd tTNativeExpressAd = this.f21445a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21445a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f21446b;
        }

        public void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleInterstitialAdapter.this.f21444t);
            AdSlot.Builder expressViewAcceptedSize = new AdSlot.Builder().setCodeId(PangleInterstitialAdapter.this.getAdSlotId()).setSupportDeepLink(true).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getAdUnitId()).setAdCount(1).setDownloadType(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getDownloadType()).setExpressViewAcceptedSize(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getImgAcceptedWidth(), ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getImgAcceptedHeight());
            if (!TextUtils.isEmpty(PangleInterstitialAdapter.this.getAdm())) {
                expressViewAcceptedSize.withBid(PangleInterstitialAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(expressViewAcceptedSize, ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mWaterfallAbTestParam, PangleInterstitialAdapter.this.getClientReqId(), false);
            createAdNative.loadInteractionExpressAd(expressViewAcceptedSize.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onError(int i, String str) {
                    PangleInterstitialAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    Map<String, Object> mediaExtraInfo;
                    if (list != null && list.size() != 0) {
                        Logger.m37562d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "穿山甲SDK--插屏-onNativeExpressAdLoad");
                        PangleExpressInterstitialAd.this.f21445a = list.get(0);
                        PangleExpressInterstitialAd.this.setExpressAd(true);
                        PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                        pangleExpressInterstitialAd.setInteractionType(pangleExpressInterstitialAd.f21445a.getInteractionType());
                        if (PangleInterstitialAdapter.this.isClientBidding() && (mediaExtraInfo = PangleExpressInterstitialAd.this.f21445a.getMediaExtraInfo()) != null) {
                            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                            Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "pangle 插屏 返回的 cpm价格：" + value);
                            PangleExpressInterstitialAd pangleExpressInterstitialAd2 = PangleExpressInterstitialAd.this;
                            if (value <= Utils.DOUBLE_EPSILON) {
                                value = 0.0d;
                            }
                            pangleExpressInterstitialAd2.setCpm(value);
                        }
                        PangleExpressInterstitialAd.this.f21445a.setExpressInteractionListener(PangleExpressInterstitialAd.this.f21447c);
                        PangleExpressInterstitialAd.this.f21445a.render();
                        return;
                    }
                    PangleInterstitialAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.getMessage(20001)));
                }
            });
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTNativeExpressAd tTNativeExpressAd = this.f21445a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                this.f21445a.setDownloadListener(null);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            TTNativeExpressAd tTNativeExpressAd = this.f21445a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.showInteractionExpressAd(activity);
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
        this.f21444t = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            PangleExpressInterstitialAd pangleExpressInterstitialAd = new PangleExpressInterstitialAd(obj instanceof ITTAdapterInterstitialListener ? (ITTAdapterInterstitialListener) obj : null);
            this.f21443s = pangleExpressInterstitialAd;
            pangleExpressInterstitialAd.loadAd();
        }
    }
}

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
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PangleInterstitialAdapter extends TTAbsAdLoaderAdapter {
    public static final String TAG = "PangleInterstitialAdapter";

    /* renamed from: s  reason: collision with root package name */
    private PangleExpressInterstitialAd f27053s;

    /* renamed from: t  reason: collision with root package name */
    private Context f27054t;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class PangleExpressInterstitialAd extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private TTNativeExpressAd f27055a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27056b;

        /* renamed from: c  reason: collision with root package name */
        TTNativeExpressAd.AdInteractionListener f27057c = new TTNativeExpressAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i4) {
                if (((TTBaseAd) PangleExpressInterstitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.a().onInterstitialAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
            public void onAdDismiss() {
                if (((TTBaseAd) PangleExpressInterstitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.a().onInterstitialClosed();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i4) {
                if (((TTBaseAd) PangleExpressInterstitialAd.this).mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.a().onInterstitialShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i4) {
                Logger.e("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "PangleExpressInterstitialAd onRenderFail -> code=" + i4 + ",msg=" + str);
                PangleInterstitialAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f4, float f5) {
                PangleExpressInterstitialAd.this.f27056b = true;
                Logger.d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "\u7a7f\u5c71\u7532SDK--\u63d2\u5c4f-onRenderSucces");
                PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                PangleInterstitialAdapter.this.notifyAdLoaded(pangleExpressInterstitialAd);
            }
        };

        PangleExpressInterstitialAd(ITTAdapterInterstitialListener iTTAdapterInterstitialListener) {
            this.mTTAdatperCallback = iTTAdapterInterstitialListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterInterstitialListener a() {
            return (ITTAdapterInterstitialListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.f27055a;
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
            TTNativeExpressAd tTNativeExpressAd = this.f27055a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getCreativeId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTNativeExpressAd tTNativeExpressAd = this.f27055a;
            if (tTNativeExpressAd != null) {
                return PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f27055a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f27056b;
        }

        public void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleInterstitialAdapter.this.f27054t);
            AdSlot.Builder expressViewAcceptedSize = new AdSlot.Builder().setCodeId(PangleInterstitialAdapter.this.getAdSlotId()).setSupportDeepLink(true).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getAdUnitId()).setAdCount(1).setDownloadType(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getDownloadType()).setExpressViewAcceptedSize(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getImgAcceptedWidth(), ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot.getImgAcceptedHeight());
            if (!TextUtils.isEmpty(PangleInterstitialAdapter.this.getAdm())) {
                expressViewAcceptedSize.withBid(PangleInterstitialAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(expressViewAcceptedSize, ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mWaterfallAbTestParam, PangleInterstitialAdapter.this.getClientReqId(), false);
            createAdNative.loadInteractionExpressAd(expressViewAcceptedSize.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onError(int i4, String str) {
                    PangleInterstitialAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i4, str));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    Map<String, Object> mediaExtraInfo;
                    if (list != null && list.size() != 0) {
                        Logger.d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "\u7a7f\u5c71\u7532SDK--\u63d2\u5c4f-onNativeExpressAdLoad");
                        PangleExpressInterstitialAd.this.f27055a = list.get(0);
                        PangleExpressInterstitialAd.this.setExpressAd(true);
                        PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                        pangleExpressInterstitialAd.setInteractionType(pangleExpressInterstitialAd.f27055a.getInteractionType());
                        if (PangleInterstitialAdapter.this.isClientBidding() && (mediaExtraInfo = PangleExpressInterstitialAd.this.f27055a.getMediaExtraInfo()) != null) {
                            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                            Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "pangle \u63d2\u5c4f \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                            PangleExpressInterstitialAd pangleExpressInterstitialAd2 = PangleExpressInterstitialAd.this;
                            if (value <= 0.0d) {
                                value = 0.0d;
                            }
                            pangleExpressInterstitialAd2.setCpm(value);
                        }
                        PangleExpressInterstitialAd.this.f27055a.setExpressInteractionListener(PangleExpressInterstitialAd.this.f27057c);
                        PangleExpressInterstitialAd.this.f27055a.render();
                        return;
                    }
                    PangleInterstitialAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.getMessage(20001)));
                }
            });
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTNativeExpressAd tTNativeExpressAd = this.f27055a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                this.f27055a.setDownloadListener(null);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            TTNativeExpressAd tTNativeExpressAd = this.f27055a;
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
        this.f27054t = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            PangleExpressInterstitialAd pangleExpressInterstitialAd = new PangleExpressInterstitialAd(obj instanceof ITTAdapterInterstitialListener ? (ITTAdapterInterstitialListener) obj : null);
            this.f27053s = pangleExpressInterstitialAd;
            pangleExpressInterstitialAd.loadAd();
        }
    }
}

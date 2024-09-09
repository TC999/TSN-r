package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PangleFullVideoAdapter extends TTAbsAdLoaderAdapter {
    public static final String TAG = "PangleFullVideoAdapter";

    /* renamed from: s  reason: collision with root package name */
    private Context f27046s;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class PangleFullVideoAd extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private TTFullScreenVideoAd f27047a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27048b;

        /* renamed from: c  reason: collision with root package name */
        TTAdNative.FullScreenVideoAdListener f27049c = new TTAdNative.FullScreenVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i4, String str) {
                PangleFullVideoAd.this.f27048b = false;
                PangleFullVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                Map<String, Object> mediaExtraInfo;
                if (tTFullScreenVideoAd == null) {
                    PangleFullVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.AD_NO_FILL));
                    return;
                }
                PangleFullVideoAd.this.f27047a = tTFullScreenVideoAd;
                PangleFullVideoAd.this.setExpressAd(true);
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                pangleFullVideoAd.setInteractionType(pangleFullVideoAd.f27047a.getInteractionType());
                if (PangleFullVideoAdapter.this.isClientBidding() && (mediaExtraInfo = PangleFullVideoAd.this.f27047a.getMediaExtraInfo()) != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleFullVideoAdapter.this.getAdapterRit(), PangleFullVideoAdapter.this.getAdSlotId()) + "pangle \u5168\u5c4f \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                    PangleFullVideoAd pangleFullVideoAd2 = PangleFullVideoAd.this;
                    if (value <= 0.0d) {
                        value = 0.0d;
                    }
                    pangleFullVideoAd2.setCpm(value);
                }
                PangleFullVideoAd.this.f27047a.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onFullVideoAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onFullVideoAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onFullVideoAdClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onVideoComplete();
                        }
                    }
                });
                PangleFullVideoAd.this.f27048b = true;
                PangleFullVideoAd pangleFullVideoAd3 = PangleFullVideoAd.this;
                PangleFullVideoAdapter.this.notifyAdLoaded(pangleFullVideoAd3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                PangleFullVideoAd.this.f27048b = true;
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                PangleFullVideoAdapter.this.notifyAdVideoCache(pangleFullVideoAd, null);
            }
        };

        PangleFullVideoAd(ITTAdapterFullVideoAdListener iTTAdapterFullVideoAdListener) {
            this.mTTAdatperCallback = iTTAdapterFullVideoAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterFullVideoAdListener a() {
            return (ITTAdapterFullVideoAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdExpiredApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f27047a;
            if (tTFullScreenVideoAd != null) {
                return PangleAdapterUtils.getAdId(tTFullScreenVideoAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return ((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getAdType();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f27047a;
            if (tTFullScreenVideoAd != null) {
                return PangleAdapterUtils.getCreativeId(tTFullScreenVideoAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f27047a;
            if (tTFullScreenVideoAd != null) {
                return PangleAdapterUtils.getReqId(tTFullScreenVideoAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f27047a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdExpired() {
            long currentTimeMillis = System.currentTimeMillis();
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f27047a;
            return tTFullScreenVideoAd == null || currentTimeMillis > tTFullScreenVideoAd.getExpirationTimestamp();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f27048b;
        }

        public void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleFullVideoAdapter.this.f27046s);
            AdSlot.Builder orientation = new AdSlot.Builder().setCodeId(PangleFullVideoAdapter.this.getAdSlotId()).setSupportDeepLink(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.isSupportDeepLink()).setImageAcceptedSize(1080, 1920).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getAdUnitId()).setDownloadType(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getDownloadType()).setOrientation(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getOrientation());
            if (!TextUtils.isEmpty(PangleFullVideoAdapter.this.getAdm())) {
                orientation.withBid(PangleFullVideoAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(orientation, ((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mWaterfallAbTestParam, PangleFullVideoAdapter.this.getClientReqId(), false);
            createAdNative.loadFullScreenVideoAd(orientation.build(), this.f27049c);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f27047a;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.f27047a.setDownloadListener(null);
                this.f27047a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (!isReady() || this.f27047a == null) {
                return;
            }
            TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
            String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
            if (ritScenes != null) {
                this.f27047a.showFullScreenVideoAd(activity, ritScenes, customRitScenes);
            } else {
                this.f27047a.showFullScreenVideoAd(activity);
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
        this.f27046s = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            new PangleFullVideoAd(obj instanceof ITTAdapterFullVideoAdListener ? (ITTAdapterFullVideoAdListener) obj : null).loadAd();
        }
    }
}

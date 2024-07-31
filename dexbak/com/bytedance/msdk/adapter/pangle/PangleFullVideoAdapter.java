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
import com.github.mikephil.charting.utils.Utils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleFullVideoAdapter extends TTAbsAdLoaderAdapter {
    public static final String TAG = "PangleFullVideoAdapter";

    /* renamed from: s */
    private Context f21436s;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class PangleFullVideoAd extends TTBaseAd {

        /* renamed from: a */
        private TTFullScreenVideoAd f21437a;

        /* renamed from: b */
        private boolean f21438b;

        /* renamed from: c */
        TTAdNative.FullScreenVideoAdListener f21439c = new TTAdNative.FullScreenVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i, String str) {
                PangleFullVideoAd.this.f21438b = false;
                PangleFullVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                Map<String, Object> mediaExtraInfo;
                if (tTFullScreenVideoAd == null) {
                    PangleFullVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.AD_NO_FILL));
                    return;
                }
                PangleFullVideoAd.this.f21437a = tTFullScreenVideoAd;
                PangleFullVideoAd.this.setExpressAd(true);
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                pangleFullVideoAd.setInteractionType(pangleFullVideoAd.f21437a.getInteractionType());
                if (PangleFullVideoAdapter.this.isClientBidding() && (mediaExtraInfo = PangleFullVideoAd.this.f21437a.getMediaExtraInfo()) != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                    Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleFullVideoAdapter.this.getAdapterRit(), PangleFullVideoAdapter.this.getAdSlotId()) + "pangle 全屏 返回的 cpm价格：" + value);
                    PangleFullVideoAd pangleFullVideoAd2 = PangleFullVideoAd.this;
                    if (value <= Utils.DOUBLE_EPSILON) {
                        value = 0.0d;
                    }
                    pangleFullVideoAd2.setCpm(value);
                }
                PangleFullVideoAd.this.f21437a.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.m37700a().onFullVideoAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.m37700a().onFullVideoAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.m37700a().onFullVideoAdClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.m37700a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                        if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.m37700a().onVideoComplete();
                        }
                    }
                });
                PangleFullVideoAd.this.f21438b = true;
                PangleFullVideoAd pangleFullVideoAd3 = PangleFullVideoAd.this;
                PangleFullVideoAdapter.this.notifyAdLoaded(pangleFullVideoAd3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                PangleFullVideoAd.this.f21438b = true;
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                PangleFullVideoAdapter.this.notifyAdVideoCache(pangleFullVideoAd, null);
            }
        };

        PangleFullVideoAd(ITTAdapterFullVideoAdListener iTTAdapterFullVideoAdListener) {
            this.mTTAdatperCallback = iTTAdapterFullVideoAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public ITTAdapterFullVideoAdListener m37700a() {
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
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f21437a;
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
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f21437a;
            if (tTFullScreenVideoAd != null) {
                return PangleAdapterUtils.getCreativeId(tTFullScreenVideoAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f21437a;
            if (tTFullScreenVideoAd != null) {
                return PangleAdapterUtils.getReqId(tTFullScreenVideoAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21437a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdExpired() {
            long currentTimeMillis = System.currentTimeMillis();
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f21437a;
            return tTFullScreenVideoAd == null || currentTimeMillis > tTFullScreenVideoAd.getExpirationTimestamp();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f21438b;
        }

        public void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleFullVideoAdapter.this.f21436s);
            AdSlot.Builder orientation = new AdSlot.Builder().setCodeId(PangleFullVideoAdapter.this.getAdSlotId()).setSupportDeepLink(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.isSupportDeepLink()).setImageAcceptedSize(PredefinedCaptureConfigurations.f24409s, PredefinedCaptureConfigurations.f24410t).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getAdUnitId()).setDownloadType(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getDownloadType()).setOrientation(((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot.getOrientation());
            if (!TextUtils.isEmpty(PangleFullVideoAdapter.this.getAdm())) {
                orientation.withBid(PangleFullVideoAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(orientation, ((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mWaterfallAbTestParam, PangleFullVideoAdapter.this.getClientReqId(), false);
            createAdNative.loadFullScreenVideoAd(orientation.build(), this.f21439c);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.f21437a;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.f21437a.setDownloadListener(null);
                this.f21437a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (!isReady() || this.f21437a == null) {
                return;
            }
            TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
            String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
            if (ritScenes != null) {
                this.f21437a.showFullScreenVideoAd(activity, ritScenes, customRitScenes);
            } else {
                this.f21437a.showFullScreenVideoAd(activity);
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
        this.f21436s = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            new PangleFullVideoAd(obj instanceof ITTAdapterFullVideoAdListener ? (ITTAdapterFullVideoAdListener) obj : null).loadAd();
        }
    }
}

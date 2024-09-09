package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.reward.TTRewardedAdListener;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PangleRewardVideoAdapter extends TTAbsAdLoaderAdapter {
    public static final String TAG = "PgRewardVideoAdapter";

    /* renamed from: s  reason: collision with root package name */
    private PangleRewardVideo f27083s;

    /* renamed from: t  reason: collision with root package name */
    private Context f27084t;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class PangleRewardVideo extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private TTRewardVideoAd f27085a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27086b;

        /* renamed from: c  reason: collision with root package name */
        TTAdNative.RewardVideoAdListener f27087c = new AnonymousClass1();

        /* renamed from: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter$PangleRewardVideo$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class AnonymousClass1 implements TTAdNative.RewardVideoAdListener {
            AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i4, String str) {
                Logger.e("TTMediationSDK", "pangle_reward_onError code:" + i4 + "  message:" + str);
                PangleRewardVideo.this.f27086b = false;
                PangleRewardVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (tTRewardVideoAd == null) {
                    PangleRewardVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.AD_NO_FILL));
                    return;
                }
                PangleRewardVideo.this.f27085a = tTRewardVideoAd;
                PangleRewardVideo.this.setExpressAd(true);
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                pangleRewardVideo.setInteractionType(pangleRewardVideo.f27085a.getInteractionType());
                Map<String, Object> mediaExtraInfo = PangleRewardVideo.this.f27085a.getMediaExtraInfo();
                if (PangleRewardVideoAdapter.this.isClientBidding() && mediaExtraInfo != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleRewardVideoAdapter.this.getAdapterRit(), PangleRewardVideoAdapter.this.getAdSlotId()) + "pangle reward \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                    PangleRewardVideo pangleRewardVideo2 = PangleRewardVideo.this;
                    if (value <= 0.0d) {
                        value = 0.0d;
                    }
                    pangleRewardVideo2.setCpm(value);
                }
                PangleRewardVideo.this.f27086b = true;
                PangleRewardVideo.this.f27085a.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdClose");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardedAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdShow");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardedAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(final boolean z3, final int i4, final String str, int i5, String str2) {
                        Logger.e("TTMediationSDK", "pangle_reward:onRewardVerify");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1.1
                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public float getAmount() {
                                    int i6 = i4;
                                    if (i6 >= 0) {
                                        return i6;
                                    }
                                    if (((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot != null) {
                                        return ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardAmount();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public Map<String, Object> getCustomData() {
                                    return null;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public String getRewardName() {
                                    if (TextUtils.isEmpty(str)) {
                                        return ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot != null ? ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardName() : "";
                                    }
                                    return str;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public boolean rewardVerify() {
                                    return z3;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Logger.e("TTMediationSDK", "pangle_reward:onSkippedVideo");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoComplete");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onVideoComplete();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoError");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.a().onVideoError();
                        }
                    }
                });
                PangleRewardVideo pangleRewardVideo3 = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdLoaded(pangleRewardVideo3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdVideoCache(pangleRewardVideo, null);
            }
        }

        public PangleRewardVideo(TTRewardedAdListener tTRewardedAdListener, Map<String, Object> map) {
            this.mTTAdatperCallback = tTRewardedAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TTRewardedAdListener a() {
            return (TTRewardedAdListener) this.mTTAdatperCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleRewardVideoAdapter.this.f27084t);
            String mediaExtra = ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getMediaExtra();
            Map<String, String> customData = ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getCustomData();
            if (customData != null) {
                String str = customData.get("pangle");
                if (!TextUtils.isEmpty(str)) {
                    mediaExtra = str;
                }
            }
            AdSlot.Builder orientation = new AdSlot.Builder().setCodeId(PangleRewardVideoAdapter.this.getAdSlotId()).setSupportDeepLink(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.isSupportDeepLink()).setRewardName(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardName()).setUserID(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getUserID()).setRewardAmount(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardAmount()).setMediaExtra(mediaExtra).setImageAcceptedSize(1080, 1920).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getAdUnitId()).setDownloadType(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getDownloadType()).setOrientation(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getOrientation());
            if (!TextUtils.isEmpty(PangleRewardVideoAdapter.this.getAdm())) {
                orientation.withBid(PangleRewardVideoAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(orientation, ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mWaterfallAbTestParam, PangleRewardVideoAdapter.this.getClientReqId(), false);
            createAdNative.loadRewardVideoAd(orientation.build(), this.f27087c);
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
            TTRewardVideoAd tTRewardVideoAd = this.f27085a;
            if (tTRewardVideoAd != null) {
                return PangleAdapterUtils.getAdId(tTRewardVideoAd.getMediaExtraInfo());
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getAdType();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTRewardVideoAd tTRewardVideoAd = this.f27085a;
            if (tTRewardVideoAd != null) {
                return PangleAdapterUtils.getCreativeId(tTRewardVideoAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTRewardVideoAd tTRewardVideoAd = this.f27085a;
            if (tTRewardVideoAd != null) {
                return PangleAdapterUtils.getReqId(tTRewardVideoAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f27085a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdExpired() {
            long currentTimeMillis = System.currentTimeMillis();
            TTRewardVideoAd tTRewardVideoAd = this.f27085a;
            return tTRewardVideoAd == null || currentTimeMillis > tTRewardVideoAd.getExpirationTimestamp();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f27086b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTRewardVideoAd tTRewardVideoAd = this.f27085a;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setDownloadListener(null);
                this.f27085a.setRewardAdInteractionListener(null);
                this.f27085a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.f27085a != null) {
                TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
                String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
                if (ritScenes != null) {
                    this.f27085a.showRewardVideoAd(activity, ritScenes, customRitScenes);
                } else {
                    this.f27085a.showRewardVideoAd(activity);
                }
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
        this.f27084t = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            PangleRewardVideo pangleRewardVideo = new PangleRewardVideo(obj instanceof TTRewardedAdListener ? (TTRewardedAdListener) obj : null, map);
            this.f27083s = pangleRewardVideo;
            pangleRewardVideo.loadAd();
        }
    }
}

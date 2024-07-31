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
import com.github.mikephil.charting.utils.Utils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleRewardVideoAdapter extends TTAbsAdLoaderAdapter {
    public static final String TAG = "PgRewardVideoAdapter";

    /* renamed from: s */
    private PangleRewardVideo f21473s;

    /* renamed from: t */
    private Context f21474t;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class PangleRewardVideo extends TTBaseAd {

        /* renamed from: a */
        private TTRewardVideoAd f21475a;

        /* renamed from: b */
        private boolean f21476b;

        /* renamed from: c */
        TTAdNative.RewardVideoAdListener f21477c = new C60091();

        /* renamed from: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter$PangleRewardVideo$1 */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C60091 implements TTAdNative.RewardVideoAdListener {
            C60091() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i, String str) {
                Logger.m37557e("TTMediationSDK", "pangle_reward_onError code:" + i + "  message:" + str);
                PangleRewardVideo.this.f21476b = false;
                PangleRewardVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Logger.m37557e("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (tTRewardVideoAd == null) {
                    PangleRewardVideoAdapter.this.notifyAdFailed(PangleAdapterUtils.buildAdError(20001, AdError.AD_NO_FILL));
                    return;
                }
                PangleRewardVideo.this.f21475a = tTRewardVideoAd;
                PangleRewardVideo.this.setExpressAd(true);
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                pangleRewardVideo.setInteractionType(pangleRewardVideo.f21475a.getInteractionType());
                Map<String, Object> mediaExtraInfo = PangleRewardVideo.this.f21475a.getMediaExtraInfo();
                if (PangleRewardVideoAdapter.this.isClientBidding() && mediaExtraInfo != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get(BidResponsed.KEY_PRICE));
                    Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleRewardVideoAdapter.this.getAdapterRit(), PangleRewardVideoAdapter.this.getAdSlotId()) + "pangle reward 返回的 cpm价格：" + value);
                    PangleRewardVideo pangleRewardVideo2 = PangleRewardVideo.this;
                    if (value <= Utils.DOUBLE_EPSILON) {
                        value = 0.0d;
                    }
                    pangleRewardVideo2.setCpm(value);
                }
                PangleRewardVideo.this.f21476b = true;
                PangleRewardVideo.this.f21475a.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onAdClose");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onRewardedAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onAdShow");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onRewardedAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onRewardClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(final boolean z, final int i, final String str, int i2, String str2) {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onRewardVerify");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1.1
                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public float getAmount() {
                                    int i3 = i;
                                    if (i3 >= 0) {
                                        return i3;
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
                                    return z;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onSkippedVideo");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onVideoComplete");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onVideoComplete();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Logger.m37557e("TTMediationSDK", "pangle_reward:onVideoError");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof TTRewardedAdListener) {
                            PangleRewardVideo.this.m37617a().onVideoError();
                        }
                    }
                });
                PangleRewardVideo pangleRewardVideo3 = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdLoaded(pangleRewardVideo3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Logger.m37557e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                Logger.m37557e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdVideoCache(pangleRewardVideo, null);
            }
        }

        public PangleRewardVideo(TTRewardedAdListener tTRewardedAdListener, Map<String, Object> map) {
            this.mTTAdatperCallback = tTRewardedAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public TTRewardedAdListener m37617a() {
            return (TTRewardedAdListener) this.mTTAdatperCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadAd() {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(PangleRewardVideoAdapter.this.f21474t);
            String mediaExtra = ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getMediaExtra();
            Map<String, String> customData = ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getCustomData();
            if (customData != null) {
                String str = customData.get("pangle");
                if (!TextUtils.isEmpty(str)) {
                    mediaExtra = str;
                }
            }
            AdSlot.Builder orientation = new AdSlot.Builder().setCodeId(PangleRewardVideoAdapter.this.getAdSlotId()).setSupportDeepLink(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.isSupportDeepLink()).setRewardName(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardName()).setUserID(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getUserID()).setRewardAmount(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardAmount()).setMediaExtra(mediaExtra).setImageAcceptedSize(PredefinedCaptureConfigurations.f24409s, PredefinedCaptureConfigurations.f24410t).setAdloadSeq(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getAdloadSeq()).setPrimeRit(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getAdUnitId()).setDownloadType(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getDownloadType()).setOrientation(((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getOrientation());
            if (!TextUtils.isEmpty(PangleRewardVideoAdapter.this.getAdm())) {
                orientation.withBid(PangleRewardVideoAdapter.this.getAdm());
            }
            PangleAdapterUtils.updateData(orientation, ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mWaterfallAbTestParam, PangleRewardVideoAdapter.this.getClientReqId(), false);
            createAdNative.loadRewardVideoAd(orientation.build(), this.f21477c);
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
            TTRewardVideoAd tTRewardVideoAd = this.f21475a;
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
            TTRewardVideoAd tTRewardVideoAd = this.f21475a;
            if (tTRewardVideoAd != null) {
                return PangleAdapterUtils.getCreativeId(tTRewardVideoAd.getMediaExtraInfo());
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTRewardVideoAd tTRewardVideoAd = this.f21475a;
            if (tTRewardVideoAd != null) {
                return PangleAdapterUtils.getReqId(tTRewardVideoAd.getMediaExtraInfo());
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21475a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdExpired() {
            long currentTimeMillis = System.currentTimeMillis();
            TTRewardVideoAd tTRewardVideoAd = this.f21475a;
            return tTRewardVideoAd == null || currentTimeMillis > tTRewardVideoAd.getExpirationTimestamp();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            return this.f21476b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTRewardVideoAd tTRewardVideoAd = this.f21475a;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setDownloadListener(null);
                this.f21475a.setRewardAdInteractionListener(null);
                this.f21475a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.f21475a != null) {
                TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
                String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
                if (ritScenes != null) {
                    this.f21475a.showRewardVideoAd(activity, ritScenes, customRitScenes);
                } else {
                    this.f21475a.showRewardVideoAd(activity);
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
        this.f21474t = context;
        if (map != null) {
            Object obj = map.get("tt_ad_network_callback");
            PangleRewardVideo pangleRewardVideo = new PangleRewardVideo(obj instanceof TTRewardedAdListener ? (TTRewardedAdListener) obj : null, map);
            this.f21473s = pangleRewardVideo;
            pangleRewardVideo.loadAd();
        }
    }
}
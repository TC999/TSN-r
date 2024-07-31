package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.base.TTBaseAd;
import com.github.mikephil.charting.utils.Utils;
import com.p518qq.p519e.ads.rewardvideo.RewardVideoAD;
import com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtRewardVideoAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21398s;

    /* renamed from: t */
    private TTVideoOption f21399t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class GdtRewardVideo extends TTBaseAd {

        /* renamed from: a */
        private RewardVideoAD f21400a;

        /* renamed from: b */
        private boolean f21401b;

        /* renamed from: c */
        RewardVideoADListener f21402c = new RewardVideoADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.1
            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.m37752d().onRewardClick();
                }
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.m37752d().onRewardedAdClosed();
                }
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                GdtRewardVideo.this.f21401b = true;
                if (GdtRewardVideo.this.f21400a == null) {
                    GdtRewardVideoAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, AdError.getMessage(0)));
                    return;
                }
                if (GdtRewardVideoAdapter.this.isClientBidding()) {
                    GdtRewardVideo gdtRewardVideo = GdtRewardVideo.this;
                    gdtRewardVideo.setCpm(gdtRewardVideo.f21400a.getECPM() != -1 ? GdtRewardVideo.this.f21400a.getECPM() : Utils.DOUBLE_EPSILON);
                    Logger.m37562d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()) + "GDT Reward 返回的 cpm价格：" + GdtRewardVideo.this.getCpm());
                }
                if (SystemClock.elapsedRealtime() < GdtRewardVideo.this.f21400a.getExpireTimestamp() - 1000) {
                    GdtRewardVideo gdtRewardVideo2 = GdtRewardVideo.this;
                    GdtRewardVideoAdapter.this.notifyAdLoaded(gdtRewardVideo2);
                }
                Logger.m37562d("GdtRewardVideoAdapter", TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()) + "eCPM = " + GdtRewardVideo.this.f21400a.getECPM() + " , eCPMLevel = " + GdtRewardVideo.this.f21400a.getECPMLevel());
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.m37752d().onRewardedAdShow();
                }
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onError(com.p518qq.p519e.comm.util.AdError adError) {
                GdtRewardVideo.this.f21401b = false;
                if (adError != null) {
                    GdtRewardVideoAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtRewardVideoAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, AdError.getMessage(0)));
                }
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onReward(final Map<String, Object> map) {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.m37752d().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.1.1
                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public float getAmount() {
                            if (((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot != null) {
                                return ((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot.getRewardAmount();
                            }
                            return 0.0f;
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public Map<String, Object> getCustomData() {
                            Map map2 = map;
                            if (map2 == null || map2.isEmpty()) {
                                return null;
                            }
                            map.put("adnName", "gdt");
                            return map;
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public String getRewardName() {
                            return ((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot != null ? ((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot.getRewardName() : "";
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public boolean rewardVerify() {
                            return true;
                        }
                    });
                }
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                GdtRewardVideo gdtRewardVideo = GdtRewardVideo.this;
                GdtRewardVideoAdapter.this.notifyAdVideoCache(gdtRewardVideo, null);
            }

            @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.m37752d().onVideoComplete();
                }
            }
        };

        GdtRewardVideo(ITTAdapterRewardedAdListener iTTAdapterRewardedAdListener) {
            this.mTTAdatperCallback = iTTAdapterRewardedAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public ITTAdapterRewardedAdListener m37752d() {
            return (ITTAdapterRewardedAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdExpiredApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        /* renamed from: b */
        void m37754b() {
            String str;
            this.f21400a = new RewardVideoAD(GdtRewardVideoAdapter.this.f21398s, GdtRewardVideoAdapter.this.getAdSlotId(), this.f21402c, (GdtRewardVideoAdapter.this.f21399t == null || GdtRewardVideoAdapter.this.f21399t.isMuted()) ? false : true);
            if (((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot != null) {
                ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
                String userID = ((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot.getUserID();
                if (userID != null) {
                    builder.setUserId(userID);
                }
                Map<String, String> customData = ((TTAbsAdLoaderAdapter) GdtRewardVideoAdapter.this).mAdSlot.getCustomData();
                if (customData != null && (str = customData.get("gdt")) != null) {
                    builder.setCustomData(str);
                }
                if (userID != null || customData != null) {
                    this.f21400a.setServerSideVerificationOptions(builder.build());
                }
            }
            this.f21400a.loadAD();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 7;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21400a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdCacheReady() {
            return isReady();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdExpired() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            RewardVideoAD rewardVideoAD = this.f21400a;
            return rewardVideoAD == null || elapsedRealtime > rewardVideoAD.getExpireTimestamp();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            RewardVideoAD rewardVideoAD;
            if (!this.f21401b || (rewardVideoAD = this.f21400a) == null || rewardVideoAD.hasShown()) {
                return false;
            }
            return this.f21401b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            if (this.f21400a != null) {
                this.f21400a = null;
                this.mTTAdatperCallback = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            RewardVideoAD rewardVideoAD = this.f21400a;
            if (rewardVideoAD != null) {
                rewardVideoAD.showAD(activity);
            }
        }
    }

    /* renamed from: C */
    private void m37764C(ITTAdapterRewardedAdListener iTTAdapterRewardedAdListener) {
        new GdtRewardVideo(iTTAdapterRewardedAdListener).m37754b();
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
        this.f21398s = context;
        this.f21399t = this.mAdSlot.getTTVideoOption();
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            m37764C(obj instanceof ITTAdapterRewardedAdListener ? (ITTAdapterRewardedAdListener) obj : null);
        }
    }
}

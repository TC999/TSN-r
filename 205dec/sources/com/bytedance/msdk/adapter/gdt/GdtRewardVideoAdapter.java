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
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtRewardVideoAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private Context f27008s;

    /* renamed from: t  reason: collision with root package name */
    private TTVideoOption f27009t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class GdtRewardVideo extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        private RewardVideoAD f27010a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27011b;

        /* renamed from: c  reason: collision with root package name */
        RewardVideoADListener f27012c = new RewardVideoADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.d().onRewardClick();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.d().onRewardedAdClosed();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                GdtRewardVideo.this.f27011b = true;
                if (GdtRewardVideo.this.f27010a == null) {
                    GdtRewardVideoAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, AdError.getMessage(0)));
                    return;
                }
                if (GdtRewardVideoAdapter.this.isClientBidding()) {
                    GdtRewardVideo gdtRewardVideo = GdtRewardVideo.this;
                    gdtRewardVideo.setCpm(gdtRewardVideo.f27010a.getECPM() != -1 ? GdtRewardVideo.this.f27010a.getECPM() : 0.0d);
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()) + "GDT Reward \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + GdtRewardVideo.this.getCpm());
                }
                if (SystemClock.elapsedRealtime() < GdtRewardVideo.this.f27010a.getExpireTimestamp() - 1000) {
                    GdtRewardVideo gdtRewardVideo2 = GdtRewardVideo.this;
                    GdtRewardVideoAdapter.this.notifyAdLoaded(gdtRewardVideo2);
                }
                Logger.d("GdtRewardVideoAdapter", TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()) + "eCPM = " + GdtRewardVideo.this.f27010a.getECPM() + " , eCPMLevel = " + GdtRewardVideo.this.f27010a.getECPMLevel());
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.d().onRewardedAdShow();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(com.qq.e.comm.util.AdError adError) {
                GdtRewardVideo.this.f27011b = false;
                if (adError != null) {
                    GdtRewardVideoAdapter.this.notifyAdFailed(AdErrorUtil.getGdtError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtRewardVideoAdapter.this.notifyAdFailed(AdErrorUtil.obtainAdError(0, AdError.getMessage(0)));
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(final Map<String, Object> map) {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.d().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.1.1
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

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                GdtRewardVideo gdtRewardVideo = GdtRewardVideo.this;
                GdtRewardVideoAdapter.this.notifyAdVideoCache(gdtRewardVideo, null);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                if (((TTBaseAd) GdtRewardVideo.this).mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.d().onVideoComplete();
                }
            }
        };

        GdtRewardVideo(ITTAdapterRewardedAdListener iTTAdapterRewardedAdListener) {
            this.mTTAdatperCallback = iTTAdapterRewardedAdListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterRewardedAdListener d() {
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

        void b() {
            String str;
            this.f27010a = new RewardVideoAD(GdtRewardVideoAdapter.this.f27008s, GdtRewardVideoAdapter.this.getAdSlotId(), this.f27012c, (GdtRewardVideoAdapter.this.f27009t == null || GdtRewardVideoAdapter.this.f27009t.isMuted()) ? false : true);
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
                    this.f27010a.setServerSideVerificationOptions(builder.build());
                }
            }
            this.f27010a.loadAD();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 7;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f27010a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdCacheReady() {
            return isReady();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdExpired() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            RewardVideoAD rewardVideoAD = this.f27010a;
            return rewardVideoAD == null || elapsedRealtime > rewardVideoAD.getExpireTimestamp();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isReady() {
            RewardVideoAD rewardVideoAD;
            if (!this.f27011b || (rewardVideoAD = this.f27010a) == null || rewardVideoAD.hasShown()) {
                return false;
            }
            return this.f27011b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            if (this.f27010a != null) {
                this.f27010a = null;
                this.mTTAdatperCallback = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            RewardVideoAD rewardVideoAD = this.f27010a;
            if (rewardVideoAD != null) {
                rewardVideoAD.showAD(activity);
            }
        }
    }

    private void C(ITTAdapterRewardedAdListener iTTAdapterRewardedAdListener) {
        new GdtRewardVideo(iTTAdapterRewardedAdListener).b();
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
        this.f27008s = context;
        this.f27009t = this.mAdSlot.getTTVideoOption();
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            Object obj = map.get("tt_ad_network_callback");
            C(obj instanceof ITTAdapterRewardedAdListener ? (ITTAdapterRewardedAdListener) obj : null);
        }
    }
}

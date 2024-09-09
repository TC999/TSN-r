package com.bytedance.sdk.openadsdk.ys.c.c;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class fp implements TTRewardVideoAd {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36410c;

    public fp(Bridge bridge) {
        this.f36410c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.f36410c.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.f36410c.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f36410c.values().objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public MediationRewardManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.c.c.c.ux((Bridge) this.f36410c.call(121109, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.f36410c.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d4, String str, String str2) {
        b b4 = b.b(3);
        b4.h(0, d4);
        b4.i(1, str);
        b4.i(2, str2);
        this.f36410c.call(210102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.c(tTAdInteractionListener));
        this.f36410c.call(210104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.w(tTAppDownloadListener));
        this.f36410c.call(120104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36410c.call(210103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.gb.c.c.c.c(rewardAdInteractionListener));
        this.f36410c.call(120101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.gb.c.c.c.w(rewardAdPlayAgainController));
        this.f36410c.call(120103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.gb.c.c.c.c(rewardAdInteractionListener));
        this.f36410c.call(120102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36410c.call(120107, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        this.f36410c.call(120105, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36410c.call(210101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        b b4 = b.b(3);
        b4.h(0, activity);
        b4.h(1, ritScenes);
        b4.i(2, str);
        this.f36410c.call(120106, b4.l(), Void.class);
    }
}

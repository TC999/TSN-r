package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import android.app.Activity;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok.C6472n;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6340a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6341ok;
import com.bytedance.sdk.openadsdk.p194z.p195ok.p196ok.p197ok.C6511a;
import com.bytedance.sdk.openadsdk.p194z.p195ok.p196ok.p197ok.C6512ok;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6375i implements TTRewardVideoAd {

    /* renamed from: ok */
    private final Bridge f22516ok;

    public C6375i(Bridge bridge) {
        this.f22516ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.f22516ok.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.f22516ok.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f22516ok.values().objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public MediationRewardManager getMediationManager() {
        return new C6472n((Bridge) this.f22516ok.call(121109, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.f22516ok.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, d);
        m37924c.m37918i(1, str);
        m37924c.m37918i(2, str2);
        this.f22516ok.call(210102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6341ok(tTAdInteractionListener));
        this.f22516ok.call(210104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6340a(tTAppDownloadListener));
        this.f22516ok.call(120104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22516ok.call(210103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6512ok(rewardAdInteractionListener));
        this.f22516ok.call(120101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6511a(rewardAdPlayAgainController));
        this.f22516ok.call(120103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6512ok(rewardAdInteractionListener));
        this.f22516ok.call(120102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37917j(0, z);
        this.f22516ok.call(120107, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        this.f22516ok.call(120105, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22516ok.call(210101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, ritScenes);
        m37924c.m37918i(2, str);
        this.f22516ok.call(120106, m37924c.m37926a(), Void.class);
    }
}

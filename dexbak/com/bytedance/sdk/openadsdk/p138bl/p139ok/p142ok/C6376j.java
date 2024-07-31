package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import android.app.Activity;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok.C6470bl;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6340a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6341ok;
import com.bytedance.sdk.openadsdk.p151k.p152ok.p153ok.p154ok.C6422ok;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.j */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6376j implements TTFullScreenVideoAd {

    /* renamed from: ok */
    private final Bridge f22517ok;

    public C6376j(Bridge bridge) {
        this.f22517ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.f22517ok.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.f22517ok.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.f22517ok.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f22517ok.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        return new C6470bl((Bridge) this.f22517ok.call(130106, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, d);
        m37924c.m37918i(1, str);
        m37924c.m37918i(2, str2);
        this.f22517ok.call(210102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6341ok(tTAdInteractionListener));
        this.f22517ok.call(210104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6340a(tTAppDownloadListener));
        this.f22517ok.call(130102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6422ok(fullScreenVideoAdInteractionListener));
        this.f22517ok.call(130101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22517ok.call(210103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37917j(0, z);
        this.f22517ok.call(130105, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        this.f22517ok.call(130103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22517ok.call(210101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, ritScenes);
        m37924c.m37918i(2, str);
        this.f22517ok.call(130104, m37924c.m37926a(), Void.class);
    }
}

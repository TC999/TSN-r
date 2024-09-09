package com.bytedance.sdk.openadsdk.bl.ok.ok;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class j implements TTFullScreenVideoAd {
    private final Bridge ok;

    public j(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.ok.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.ok.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.ok.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.ok.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.bl((Bridge) this.ok.call(130106, com.bykv.ok.ok.ok.ok.a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d4, String str, String str2) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(3);
        c4.h(0, d4);
        c4.i(1, str);
        c4.i(2, str2);
        this.ok.call(210102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.bl.ok.a.ok(tTAdInteractionListener));
        this.ok.call(210104, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.bl.ok.a.a(tTAppDownloadListener));
        this.ok.call(130102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.k.ok.ok.ok.ok(fullScreenVideoAdInteractionListener));
        this.ok.call(130101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d4) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, d4);
        this.ok.call(210103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z3) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.j(0, z3);
        this.ok.call(130105, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, activity);
        this.ok.call(130103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d4) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, d4);
        this.ok.call(210101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(3);
        c4.h(0, activity);
        c4.h(1, ritScenes);
        c4.i(2, str);
        this.ok.call(130104, c4.a(), Void.class);
    }
}

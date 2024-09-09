package com.bytedance.sdk.openadsdk.ys.c.c;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a implements TTFullScreenVideoAd {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36401c;

    public a(Bridge bridge) {
        this.f36401c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.f36401c.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.f36401c.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.f36401c.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f36401c.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.c.c.c.xv((Bridge) this.f36401c.call(130106, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d4, String str, String str2) {
        b b4 = b.b(3);
        b4.h(0, d4);
        b4.i(1, str);
        b4.i(2, str2);
        this.f36401c.call(210102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.c(tTAdInteractionListener));
        this.f36401c.call(210104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.w(tTAppDownloadListener));
        this.f36401c.call(130102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.q.c.c.c.c(fullScreenVideoAdInteractionListener));
        this.f36401c.call(130101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36401c.call(210103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36401c.call(130105, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        this.f36401c.call(130103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36401c.call(210101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        b b4 = b.b(3);
        b4.h(0, activity);
        b4.h(1, ritScenes);
        b4.i(2, str);
        this.f36401c.call(130104, b4.l(), Void.class);
    }
}

package com.bytedance.sdk.openadsdk.ys.c.c;

import android.app.Activity;
import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ys implements TTNativeExpressAd {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36422c;

    public ys(Bridge bridge) {
        this.f36422c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        this.f36422c.call(150105, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        return new ev((Bridge) this.f36422c.call(150108, b4.l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return new sr((Bridge) this.f36422c.values().objectValue(150003, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return (View) this.f36422c.values().objectValue(150001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.f36422c.values().intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.f36422c.values().intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f36422c.values().objectValue(150005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public MediationNativeManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.c.c.c.sr((Bridge) this.f36422c.call(150113, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d4, String str, String str2) {
        b b4 = b.b(3);
        b4.h(0, d4);
        b4.i(1, str);
        b4.i(2, str2);
        this.f36422c.call(210102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f36422c.call(150104, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.c(tTAdInteractionListener));
        this.f36422c.call(210104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36422c.call(150112, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b b4 = b.b(2);
        b4.h(0, activity);
        b4.h(1, new com.bytedance.sdk.openadsdk.s.c.c.c.c(dislikeInteractionCallback));
        this.f36422c.call(150106, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        b b4 = b.b(1);
        b4.h(0, tTDislikeDialogAbstract);
        this.f36422c.call(150107, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.w(tTAppDownloadListener));
        this.f36422c.call(150103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ls.c.c.c.w(expressAdInteractionListener));
        this.f36422c.call(150101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36422c.call(210103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i4) {
        b b4 = b.b(1);
        b4.e(0, i4);
        this.f36422c.call(150110, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ls.c.c.c.xv(expressVideoAdListener));
        this.f36422c.call(150111, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        this.f36422c.call(150109, b4.l(), Void.class);
    }

    public void uploadDislikeEvent(String str) {
        b b4 = b.b(1);
        b4.i(0, str);
        this.f36422c.call(150114, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36422c.call(210101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ls.c.c.c.c(adInteractionListener));
        this.f36422c.call(150102, b4.l(), Void.class);
    }
}

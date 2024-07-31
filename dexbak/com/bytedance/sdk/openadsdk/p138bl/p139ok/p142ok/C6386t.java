package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import android.app.Activity;
import android.view.View;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok.C6474s;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6340a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6341ok;
import com.bytedance.sdk.openadsdk.p147j.p148ok.p149ok.p150ok.C6419a;
import com.bytedance.sdk.openadsdk.p147j.p148ok.p149ok.p150ok.C6420bl;
import com.bytedance.sdk.openadsdk.p147j.p148ok.p149ok.p150ok.C6421ok;
import com.bytedance.sdk.openadsdk.p155kf.p156ok.p157ok.p158ok.C6423ok;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.t */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6386t implements TTNativeExpressAd {

    /* renamed from: ok */
    private final Bridge f22529ok;

    public C6386t(Bridge bridge) {
        this.f22529ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        this.f22529ok.call(150105, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        return new C6381p((Bridge) this.f22529ok.call(150108, m37924c.m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return new C6385s((Bridge) this.f22529ok.values().objectValue(150003, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return (View) this.f22529ok.values().objectValue(150001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.f22529ok.values().intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.f22529ok.values().intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f22529ok.values().objectValue(150005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public MediationNativeManager getMediationManager() {
        return new C6474s((Bridge) this.f22529ok.call(150113, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, d);
        m37924c.m37918i(1, str);
        m37924c.m37918i(2, str2);
        this.f22529ok.call(210102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f22529ok.call(150104, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6341ok(tTAdInteractionListener));
        this.f22529ok.call(210104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37917j(0, z);
        this.f22529ok.call(150112, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, new C6423ok(dislikeInteractionCallback));
        this.f22529ok.call(150106, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, tTDislikeDialogAbstract);
        this.f22529ok.call(150107, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6340a(tTAppDownloadListener));
        this.f22529ok.call(150103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6419a(expressAdInteractionListener));
        this.f22529ok.call(150101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22529ok.call(210103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37921f(0, i);
        this.f22529ok.call(150110, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6420bl(expressVideoAdListener));
        this.f22529ok.call(150111, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        this.f22529ok.call(150109, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22529ok.call(210101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6421ok(adInteractionListener));
        this.f22529ok.call(150102, m37924c.m37926a(), Void.class);
    }
}

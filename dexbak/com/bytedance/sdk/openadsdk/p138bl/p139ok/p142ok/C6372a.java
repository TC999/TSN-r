package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok.C6471kf;
import com.bytedance.sdk.openadsdk.p130a.p131ok.p132ok.p133ok.C6276a;
import com.bytedance.sdk.openadsdk.p130a.p131ok.p132ok.p133ok.C6277bl;
import com.bytedance.sdk.openadsdk.p130a.p131ok.p132ok.p133ok.C6278ok;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6340a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6341ok;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6372a implements CSJSplashAd {

    /* renamed from: ok */
    private final Bridge f22513ok;

    public C6372a(Bridge bridge) {
        this.f22513ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.f22513ok.values().intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f22513ok.values().objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public MediationSplashManager getMediationManager() {
        return new C6471kf((Bridge) this.f22513ok.call(110110, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.f22513ok.values().objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return (int[]) this.f22513ok.values().objectValue(110006, int[].class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashClickEyeView() {
        return (View) this.f22513ok.values().objectValue(110002, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.f22513ok.values().objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        this.f22513ok.call(110101, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, d);
        m37924c.m37918i(1, str);
        m37924c.m37918i(2, str2);
        this.f22513ok.call(210102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6341ok(tTAdInteractionListener));
        this.f22513ok.call(210104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6340a(tTAppDownloadListener));
        this.f22513ok.call(110102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22513ok.call(210103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6278ok(splashAdListener));
        this.f22513ok.call(110103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6276a(splashCardListener));
        this.f22513ok.call(110106, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashClickEyeListener(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6277bl(splashClickEyeListener));
        this.f22513ok.call(110105, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37919h(0, viewGroup);
        m37924c.m37919h(1, activity);
        this.f22513ok.call(110109, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashClickEyeView(ViewGroup viewGroup) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, viewGroup);
        this.f22513ok.call(110107, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, viewGroup);
        this.f22513ok.call(110108, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void startClickEye() {
        this.f22513ok.call(110104, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22513ok.call(210101, m37924c.m37926a(), Void.class);
    }
}

package com.bytedance.sdk.openadsdk.ys.c.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements CSJSplashAd {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36420c;

    public w(Bridge bridge) {
        this.f36420c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.f36420c.values().intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f36420c.values().objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public MediationSplashManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.c.c.c.f((Bridge) this.f36420c.call(110110, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.f36420c.values().objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return (int[]) this.f36420c.values().objectValue(110006, int[].class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashClickEyeView() {
        return (View) this.f36420c.values().objectValue(110002, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.f36420c.values().objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        this.f36420c.call(110101, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d4, String str, String str2) {
        b b4 = b.b(3);
        b4.h(0, d4);
        b4.i(1, str);
        b4.i(2, str2);
        this.f36420c.call(210102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.c(tTAdInteractionListener));
        this.f36420c.call(210104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.w(tTAppDownloadListener));
        this.f36420c.call(110102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36420c.call(210103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.sr.c.c.c.c(splashAdListener));
        this.f36420c.call(110103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.sr.c.c.c.w(splashCardListener));
        this.f36420c.call(110106, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashClickEyeListener(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.sr.c.c.c.xv(splashClickEyeListener));
        this.f36420c.call(110105, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        b b4 = b.b(2);
        b4.h(0, viewGroup);
        b4.h(1, activity);
        this.f36420c.call(110109, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashClickEyeView(ViewGroup viewGroup) {
        b b4 = b.b(1);
        b4.h(0, viewGroup);
        this.f36420c.call(110107, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        b b4 = b.b(1);
        b4.h(0, viewGroup);
        this.f36420c.call(110108, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void startClickEye() {
        this.f36420c.call(110104, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36420c.call(210101, b4.l(), Void.class);
    }
}

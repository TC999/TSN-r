package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p163ok;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6441n;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6446ok implements IMediationNativeAdInfo {

    /* renamed from: ok */
    private final Bridge f22706ok;

    public C6446ok(Bridge bridge) {
        this.f22706ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public String getActionText() {
        return (String) this.f22706ok.call(268005, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        return ((Integer) this.f22706ok.call(268009, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public String getDescription() {
        return (String) this.f22706ok.call(268002, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        return new C6444a((Bridge) this.f22706ok.call(268102, m37924c.m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public String getIconUrl() {
        return (String) this.f22706ok.call(268003, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        return (List) this.f22706ok.call(268007, C5930a.m37924c(0).m37926a(), List.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public String getImageUrl() {
        return (String) this.f22706ok.call(268004, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public int getInteractionType() {
        return ((Integer) this.f22706ok.call(268010, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new C6445bl((Bridge) this.f22706ok.values().objectValue(268101, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public String getSource() {
        return (String) this.f22706ok.call(268008, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public double getStarRating() {
        return ((Double) this.f22706ok.call(268006, C5930a.m37924c(0).m37926a(), Double.TYPE)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public String getTitle() {
        return (String) this.f22706ok.call(268001, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        return ((Boolean) this.f22706ok.call(268012, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        C5930a m37924c = C5930a.m37924c(6);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, viewGroup);
        m37924c.m37919h(2, list);
        m37924c.m37919h(3, list2);
        m37924c.m37919h(4, list3);
        m37924c.m37919h(5, new C6441n(iMediationViewBinder));
        this.f22706ok.call(268011, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, map);
        return new C6444a((Bridge) this.f22706ok.call(268103, m37924c.m37926a(), Bridge.class));
    }
}

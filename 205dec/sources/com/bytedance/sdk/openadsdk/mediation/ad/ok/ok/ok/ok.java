package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.n;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements IMediationNativeAdInfo {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        return (String) this.ok.call(268005, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        return ((Integer) this.ok.call(268009, com.bykv.ok.ok.ok.ok.a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        return (String) this.ok.call(268002, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, activity);
        return new a((Bridge) this.ok.call(268102, c4.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        return (String) this.ok.call(268003, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        return (List) this.ok.call(268007, com.bykv.ok.ok.ok.ok.a.c(0).a(), List.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        return (String) this.ok.call(268004, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        return ((Integer) this.ok.call(268010, com.bykv.ok.ok.ok.ok.a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new bl((Bridge) this.ok.values().objectValue(268101, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        return (String) this.ok.call(268008, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        return ((Double) this.ok.call(268006, com.bykv.ok.ok.ok.ok.a.c(0).a(), Double.TYPE)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        return (String) this.ok.call(268001, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        return ((Boolean) this.ok.call(268012, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(6);
        c4.h(0, activity);
        c4.h(1, viewGroup);
        c4.h(2, list);
        c4.h(3, list2);
        c4.h(4, list3);
        c4.h(5, new n(iMediationViewBinder));
        this.ok.call(268011, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(2);
        c4.h(0, activity);
        c4.h(1, map);
        return new a((Bridge) this.ok.call(268103, c4.a(), Bridge.class));
    }
}

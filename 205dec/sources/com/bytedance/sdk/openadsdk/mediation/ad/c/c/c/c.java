package com.bytedance.sdk.openadsdk.mediation.ad.c.c.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.ux;
import com.bytedance.sdk.openadsdk.ys.c.c.ev;
import com.bytedance.sdk.openadsdk.ys.c.c.sr;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements IMediationNativeAdInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36022c;

    public c(Bridge bridge) {
        this.f36022c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        return (String) this.f36022c.call(268005, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        return ((Integer) this.f36022c.call(268009, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        return (String) this.f36022c.call(268002, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        return new w((Bridge) this.f36022c.call(268102, b4.l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog2(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        return new ev((Bridge) this.f36022c.call(268018, b4.l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public DislikeInfo getDislikeInfo() {
        return new sr((Bridge) this.f36022c.call(268020, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        return (String) this.f36022c.call(268003, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        return (List) this.f36022c.call(268007, b.b(0).l(), List.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        return (String) this.f36022c.call(268004, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        return ((Integer) this.f36022c.call(268010, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new xv((Bridge) this.f36022c.values().objectValue(268101, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        return (String) this.f36022c.call(268008, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        return ((Double) this.f36022c.call(268006, b.b(0).l(), Double.TYPE)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        return (String) this.f36022c.call(268001, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        return ((Boolean) this.f36022c.call(268012, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        b b4 = b.b(6);
        b4.h(0, activity);
        b4.h(1, viewGroup);
        b4.h(2, list);
        b4.h(3, list2);
        b4.h(4, list3);
        b4.h(5, new ux(iMediationViewBinder));
        this.f36022c.call(268011, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b b4 = b.b(2);
        b4.h(0, activity);
        b4.h(1, new com.bytedance.sdk.openadsdk.s.c.c.c.c(dislikeInteractionCallback));
        this.f36022c.call(268016, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        b b4 = b.b(1);
        b4.h(0, tTDislikeDialogAbstract);
        this.f36022c.call(268017, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        b b4 = b.b(2);
        b4.h(0, activity);
        b4.h(1, map);
        return new w((Bridge) this.f36022c.call(268103, b4.l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        b b4 = b.b(1);
        b4.h(0, tTDislikeDialogAbstract);
        return new ev((Bridge) this.f36022c.call(268019, b4.l(), Bridge.class));
    }
}

package com.bytedance.sdk.openadsdk.ys.c.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class p implements TTDrawFeedAd {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36415c;

    public p(Bridge bridge) {
        this.f36415c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        this.f36415c.call(140114, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.f36415c.values().objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.f36415c.values().objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.f36415c.values().intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.f36415c.values().intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.f36415c.values().intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.f36415c.values().intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.f36415c.values().intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return (String) this.f36415c.values().objectValue(140018, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new xv((Bridge) this.f36415c.values().objectValue(140014, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.i.c.c.c.c((Bridge) this.f36415c.values().objectValue(160002, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return (String) this.f36415c.values().objectValue(140004, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        return new ev((Bridge) this.f36415c.call(140101, b4.l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new sr((Bridge) this.f36415c.values().objectValue(140013, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new ux((Bridge) this.f36415c.values().objectValue(140015, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new bk((Bridge) this.f36415c.values().objectValue(140009, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List<Bridge> list = (List) this.f36415c.values().objectValue(140010, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new bk(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.f36415c.values().intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.f36415c.values().intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f36415c.values().objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.c.c.c.sr((Bridge) this.f36415c.call(140116, b.b(0).l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return (String) this.f36415c.values().objectValue(140008, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return (String) this.f36415c.values().objectValue(140003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new bk((Bridge) this.f36415c.values().objectValue(140001, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.f36415c.values().doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d4, String str, String str2) {
        b b4 = b.b(3);
        b4.h(0, d4);
        b4.i(1, str);
        b4.i(2, str2);
        this.f36415c.call(210102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        b b4 = b.b(3);
        b4.h(0, viewGroup);
        b4.h(1, view);
        b4.h(2, new com.bytedance.sdk.openadsdk.j.c.c.c.c(adInteractionListener));
        this.f36415c.call(140103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        this.f36415c.call(140110, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        this.f36415c.call(140109, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.c(tTAdInteractionListener));
        this.f36415c.call(210104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36415c.call(170101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b b4 = b.b(2);
        b4.h(0, activity);
        b4.h(1, new com.bytedance.sdk.openadsdk.s.c.c.c.c(dislikeInteractionCallback));
        this.f36415c.call(140112, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        b b4 = b.b(1);
        b4.h(0, tTDislikeDialogAbstract);
        this.f36415c.call(140113, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.ys.c.w.w(tTAppDownloadListener));
        this.f36415c.call(140108, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.u.c.c.c.c(drawVideoListener));
        this.f36415c.call(170103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.j.c.c.c.w(expressRenderListener));
        this.f36415c.call(140111, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i4) {
        b b4 = b.b(2);
        b4.h(0, bitmap);
        b4.e(1, i4);
        this.f36415c.call(170102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36415c.call(210103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.i.c.c.w.c(videoAdListener));
        this.f36415c.call(160101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(TTFeedAd.VideoRewardListener videoRewardListener) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.i.c.c.w.w(videoRewardListener));
        this.f36415c.call(160102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        b b4 = b.b(1);
        b4.h(0, activity);
        this.f36415c.call(140115, b4.l(), Void.class);
    }

    public void uploadDislikeEvent(String str) {
        b b4 = b.b(1);
        b4.i(0, str);
        this.f36415c.call(140118, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d4) {
        b b4 = b.b(1);
        b4.h(0, d4);
        this.f36415c.call(210101, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        b b4 = b.b(1);
        b4.h(0, tTDislikeDialogAbstract);
        return new ev((Bridge) this.f36415c.call(140102, b4.l(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        b b4 = b.b(4);
        b4.h(0, viewGroup);
        b4.h(1, list);
        b4.h(2, list2);
        b4.h(3, new com.bytedance.sdk.openadsdk.j.c.c.c.c(adInteractionListener));
        this.f36415c.call(140104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        b b4 = b.b(5);
        b4.h(0, viewGroup);
        b4.h(1, list);
        b4.h(2, list2);
        b4.h(3, view);
        b4.h(4, new com.bytedance.sdk.openadsdk.j.c.c.c.c(adInteractionListener));
        this.f36415c.call(140105, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        b b4 = b.b(6);
        b4.h(0, viewGroup);
        b4.h(1, list);
        b4.h(2, list2);
        b4.h(3, list3);
        b4.h(4, view);
        b4.h(5, new com.bytedance.sdk.openadsdk.j.c.c.c.c(adInteractionListener));
        this.f36415c.call(140106, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        b b4 = b.b(7);
        b4.h(0, viewGroup);
        b4.h(1, list);
        b4.h(2, list2);
        b4.h(3, list3);
        b4.h(4, list4);
        b4.h(5, view);
        b4.h(6, new com.bytedance.sdk.openadsdk.j.c.c.c.c(adInteractionListener));
        this.f36415c.call(140107, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, TTNativeAd.AdInteractionListener adInteractionListener, IMediationViewBinder iMediationViewBinder) {
        b b4 = b.b(7);
        b4.h(0, activity);
        b4.h(1, viewGroup);
        b4.h(2, list);
        b4.h(3, list2);
        b4.h(4, list3);
        b4.h(5, new com.bytedance.sdk.openadsdk.j.c.c.c.c(adInteractionListener));
        b4.h(6, new com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.ux(iMediationViewBinder));
        this.f36415c.call(140117, b4.l(), Void.class);
    }
}

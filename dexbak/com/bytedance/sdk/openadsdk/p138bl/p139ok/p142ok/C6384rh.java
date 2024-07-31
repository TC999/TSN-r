package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok.C6474s;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6441n;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6340a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a.C6341ok;
import com.bytedance.sdk.openadsdk.p155kf.p156ok.p157ok.p158ok.C6423ok;
import com.bytedance.sdk.openadsdk.p185r.p186ok.p187ok.p188ok.C6508a;
import com.bytedance.sdk.openadsdk.p185r.p186ok.p187ok.p188ok.C6509ok;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.rh */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6384rh implements TTNativeAd {

    /* renamed from: ok */
    private final Bridge f22527ok;

    public C6384rh(Bridge bridge) {
        this.f22527ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        this.f22527ok.call(140114, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.f22527ok.values().objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.f22527ok.values().objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.f22527ok.values().intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.f22527ok.values().intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.f22527ok.values().intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return (String) this.f22527ok.values().objectValue(140018, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new C6373bl((Bridge) this.f22527ok.values().objectValue(140014, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return (String) this.f22527ok.values().objectValue(140004, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        return new C6381p((Bridge) this.f22527ok.call(140101, m37924c.m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new C6385s((Bridge) this.f22527ok.values().objectValue(140013, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new C6379n((Bridge) this.f22527ok.values().objectValue(140015, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new C6388z((Bridge) this.f22527ok.values().objectValue(140009, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List<Bridge> list = (List) this.f22527ok.values().objectValue(140010, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new C6388z(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.f22527ok.values().intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.f22527ok.values().intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f22527ok.values().objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        return new C6474s((Bridge) this.f22527ok.call(140116, C5930a.m37924c(0).m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return (String) this.f22527ok.values().objectValue(140008, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return (String) this.f22527ok.values().objectValue(140003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new C6388z((Bridge) this.f22527ok.values().objectValue(140001, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, d);
        m37924c.m37918i(1, str);
        m37924c.m37918i(2, str2);
        this.f22527ok.call(210102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, viewGroup);
        m37924c.m37919h(1, view);
        m37924c.m37919h(2, new C6509ok(adInteractionListener));
        this.f22527ok.call(140103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        this.f22527ok.call(140110, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        this.f22527ok.call(140109, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6341ok(tTAdInteractionListener));
        this.f22527ok.call(210104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, new C6423ok(dislikeInteractionCallback));
        this.f22527ok.call(140112, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, tTDislikeDialogAbstract);
        this.f22527ok.call(140113, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6340a(tTAppDownloadListener));
        this.f22527ok.call(140108, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6508a(expressRenderListener));
        this.f22527ok.call(140111, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22527ok.call(210103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, activity);
        this.f22527ok.call(140115, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, d);
        this.f22527ok.call(210101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, tTDislikeDialogAbstract);
        return new C6381p((Bridge) this.f22527ok.call(140102, m37924c.m37926a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        C5930a m37924c = C5930a.m37924c(4);
        m37924c.m37919h(0, viewGroup);
        m37924c.m37919h(1, list);
        m37924c.m37919h(2, list2);
        m37924c.m37919h(3, new C6509ok(adInteractionListener));
        this.f22527ok.call(140104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        C5930a m37924c = C5930a.m37924c(5);
        m37924c.m37919h(0, viewGroup);
        m37924c.m37919h(1, list);
        m37924c.m37919h(2, list2);
        m37924c.m37919h(3, view);
        m37924c.m37919h(4, new C6509ok(adInteractionListener));
        this.f22527ok.call(140105, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        C5930a m37924c = C5930a.m37924c(6);
        m37924c.m37919h(0, viewGroup);
        m37924c.m37919h(1, list);
        m37924c.m37919h(2, list2);
        m37924c.m37919h(3, list3);
        m37924c.m37919h(4, view);
        m37924c.m37919h(5, new C6509ok(adInteractionListener));
        this.f22527ok.call(140106, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        C5930a m37924c = C5930a.m37924c(7);
        m37924c.m37919h(0, viewGroup);
        m37924c.m37919h(1, list);
        m37924c.m37919h(2, list2);
        m37924c.m37919h(3, list3);
        m37924c.m37919h(4, list4);
        m37924c.m37919h(5, view);
        m37924c.m37919h(6, new C6509ok(adInteractionListener));
        this.f22527ok.call(140107, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, TTNativeAd.AdInteractionListener adInteractionListener, IMediationViewBinder iMediationViewBinder) {
        C5930a m37924c = C5930a.m37924c(7);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, viewGroup);
        m37924c.m37919h(2, list);
        m37924c.m37919h(3, list2);
        m37924c.m37919h(4, list3);
        m37924c.m37919h(5, new C6509ok(adInteractionListener));
        m37924c.m37919h(6, new C6441n(iMediationViewBinder));
        this.f22527ok.call(140117, m37924c.m37926a(), Void.class);
    }
}

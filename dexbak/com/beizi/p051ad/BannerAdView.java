package com.beizi.p051ad;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.annotation.RequiresPermission;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.animation.TransitionDirection;
import com.beizi.p051ad.internal.animation.TransitionType;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.lance.p062a.ExpandTouchAreaUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.ProbabilityUtil;
import com.kuaishou.weapon.p205p0.C7282g;
import java.util.List;

/* renamed from: com.beizi.ad.BannerAdView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BannerAdView extends BaseAdView {

    /* renamed from: b */
    private int f9339b;

    /* renamed from: c */
    private int f9340c;

    /* renamed from: d */
    private String f9341d;

    /* renamed from: e */
    private int f9342e;

    /* renamed from: f */
    private String f9343f;

    /* renamed from: g */
    private List<Pair<String, Integer>> f9344g;

    /* renamed from: h */
    private View f9345h;

    public BannerAdView(Context context) {
        super(context, EnumC2888k.BANNER);
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    public int getAdOptimizePercent() {
        return this.f9339b;
    }

    public int getAdOptimizeSize() {
        return this.f9340c;
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    public String getDirection() {
        return this.f9343f;
    }

    public List<Pair<String, Integer>> getOrderOptimizeList() {
        return this.f9344g;
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ String getPrice() {
        return super.getPrice();
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ boolean getResizeAdToFitContainer() {
        return super.getResizeAdToFitContainer();
    }

    public String getScrollDistance() {
        return this.f9341d;
    }

    public int getScrollDistancePercent() {
        return this.f9342e;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getValidOptimizePercent() {
        /*
            r6 = this;
            com.beizi.ad.internal.view.BannerAdViewImpl r0 = r6.f9550a
            r1 = -1
            if (r0 == 0) goto L39
            java.lang.String r0 = r0.getLandingPageUrl()
            if (r0 == 0) goto L39
            com.beizi.ad.internal.view.BannerAdViewImpl r0 = r6.f9550a
            java.lang.String r0 = r0.getLandingPageUrl()
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r6.f9344g
            if (r2 == 0) goto L39
            java.util.Iterator r2 = r2.iterator()
            r3 = -1
        L1a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r2.next()
            android.util.Pair r4 = (android.util.Pair) r4
            java.lang.Object r5 = r4.first
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L1a
            java.lang.Object r3 = r4.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L1a
        L39:
            r3 = -1
        L3a:
            if (r3 != r1) goto L3e
            int r3 = r6.f9339b
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.BannerAdView.getValidOptimizePercent():int");
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void isAutoRefresh() {
        super.isAutoRefresh();
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    @Override // com.beizi.p051ad.BaseAdView
    @RequiresPermission(C7282g.f24943a)
    public /* bridge */ /* synthetic */ void loadAd(AdRequest adRequest) {
        super.loadAd(adRequest);
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onCreateLifeCycle() {
        super.onCreateLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onDestoryLifeCycle() {
        super.onDestoryLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onPauseLifeCycle() {
        super.onPauseLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onRestartLifeCycle() {
        super.onRestartLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onResumeLifeCycle() {
        super.onResumeLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onStartLifeCycle() {
        super.onStartLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void onStopLifeCycle() {
        super.onStopLifeCycle();
    }

    @Override // com.beizi.p051ad.BaseAdView, com.beizi.p051ad.AdLifeControl
    public /* bridge */ /* synthetic */ void openAdInNativeBrowser(boolean z) {
        super.openAdInNativeBrowser(z);
    }

    public void optimizeClickArea(int i, View view, View view2, String str) {
        int validOptimizePercent = getValidOptimizePercent();
        boolean m49039a = ProbabilityUtil.m49039a(validOptimizePercent);
        LogUtil.m49044c("BeiZisAd", "percent = " + validOptimizePercent + ",isPass = " + m49039a);
        if (m49039a) {
            this.f9345h = ExpandTouchAreaUtil.m49065a(i, view, view2, str);
        }
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    public void setAdOptimizePercent(int i) {
        this.f9339b = i;
    }

    public void setAdOptimizeSize(int i) {
        this.f9340c = i;
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setAutoRefresh(boolean z) {
        super.setAutoRefresh(z);
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setCloseMarketDialog(boolean z) {
        super.setCloseMarketDialog(z);
    }

    public void setDirection(String str) {
        this.f9343f = str;
    }

    public void setOrderOptimizeList(List<Pair<String, Integer>> list) {
        this.f9344g = list;
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setResizeAdToFitContainer(boolean z) {
        super.setResizeAdToFitContainer(z);
    }

    public void setScrollDistance(String str) {
        this.f9341d = str;
    }

    public void setScrollDistancePercent(int i) {
        this.f9342e = i;
    }

    public void setTouchAreaNormal() {
        View view = this.f9345h;
        if (view != null) {
            ViewUtil.removeChildFromParent(view);
        }
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setTransitionDerection(TransitionDirection transitionDirection) {
        super.setTransitionDerection(transitionDirection);
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setTransitionDuration(int i) {
        super.setTransitionDuration(i);
    }

    @Override // com.beizi.p051ad.BaseAdView
    public /* bridge */ /* synthetic */ void setTransitionType(TransitionType transitionType) {
        super.setTransitionType(transitionType);
    }

    public BannerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, EnumC2888k.BANNER);
    }

    public BannerAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, EnumC2888k.BANNER);
    }
}

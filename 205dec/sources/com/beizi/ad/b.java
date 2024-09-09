package com.beizi.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.internal.animation.TransitionDirection;
import com.beizi.ad.internal.animation.TransitionType;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.view.BannerAdViewImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseAdView.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends FrameLayout implements AdLifeControl {

    /* renamed from: a  reason: collision with root package name */
    protected final BannerAdViewImpl f13245a;

    public b(Context context, k kVar) {
        super(context);
        this.f13245a = new BannerAdViewImpl(context);
        a();
    }

    private void a() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, 0);
        addView(this.f13245a);
    }

    public void cancel() {
        BannerAdViewImpl bannerAdViewImpl = this.f13245a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    public AdListener getAdListener() {
        return this.f13245a.getAdListener();
    }

    public a getAdSize() {
        return this.f13245a.getAdSize();
    }

    public String getAdUnitId() {
        return this.f13245a.getAdUnitId();
    }

    public String getPrice() {
        return this.f13245a.getPrice();
    }

    public boolean getResizeAdToFitContainer() {
        return this.f13245a.getResizeAdToFitContainer();
    }

    public void isAutoRefresh() {
        this.f13245a.isAutoRefresh();
    }

    public boolean isDownloadApp() {
        BannerAdViewImpl bannerAdViewImpl = this.f13245a;
        if (bannerAdViewImpl == null) {
            return false;
        }
        return bannerAdViewImpl.isDownloadApp();
    }

    public boolean isLoading() {
        return this.f13245a.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.f13245a.loadAd(adRequest.impl());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onCreateLifeCycle() {
    }

    public void onDestoryLifeCycle() {
        BannerAdViewImpl bannerAdViewImpl = this.f13245a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.onDestoryLifeCycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BannerAdViewImpl bannerAdViewImpl = this.f13245a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.activityOnDestroy();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        if (getResizeAdToFitContainer()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), 1073741824);
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(makeMeasureSpec) / 6, 1073741824));
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        View.MeasureSpec.getSize(i5);
        int i7 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i4, i5);
            i7 = childAt.getMeasuredWidth();
            i6 = childAt.getMeasuredHeight();
        } else {
            a aVar = null;
            try {
                aVar = getAdSize();
            } catch (NullPointerException e4) {
                HaoboLog.e(HaoboLog.baseLogTag, "Unable to retrieve ad size.", e4);
            }
            if (aVar != null) {
                Context context = getContext();
                int b4 = aVar.b(context);
                i6 = aVar.a(context);
                i7 = b4;
            } else {
                i6 = 0;
            }
        }
        int max = Math.max(i7, getSuggestedMinimumWidth());
        int max2 = Math.max(i6, getSuggestedMinimumHeight());
        if (mode == 1073741824) {
            max = View.MeasureSpec.getSize(i4);
        }
        if (mode2 == 1073741824) {
            max2 = View.MeasureSpec.getSize(i5);
        }
        setMeasuredDimension(View.resolveSize(max, i4), View.resolveSize(max2, i5));
    }

    public void onPauseLifeCycle() {
    }

    public void onRestartLifeCycle() {
    }

    public void onResumeLifeCycle() {
    }

    public void onStartLifeCycle() {
    }

    public void onStopLifeCycle() {
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        if (i4 == 8) {
            this.f13245a.activityOnPause();
        } else {
            this.f13245a.activityOnResume();
        }
    }

    public void openAdInNativeBrowser(boolean z3) {
        this.f13245a.openAdInNativeBrowser(z3);
    }

    public void resume() {
        this.f13245a.activityOnResume();
    }

    public void setAdListener(AdListener adListener) {
        this.f13245a.setAdListener(adListener);
    }

    void setAdSize(a aVar) {
        this.f13245a.setAdSize(aVar.b(), aVar.a());
    }

    public void setAdUnitId(String str) {
        this.f13245a.setAdUnitId(str);
    }

    public void setAutoRefresh(boolean z3) {
        this.f13245a.setAutoRefresh(z3);
    }

    public void setCloseMarketDialog(boolean z3) {
        BannerAdViewImpl bannerAdViewImpl = this.f13245a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.setCloseMarketDialog(z3);
        }
    }

    public void setResizeAdToFitContainer(boolean z3) {
        this.f13245a.setResizeAdToFitContainer(z3);
        if (getResizeAdToFitContainer()) {
            this.f13245a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setTransitionDerection(TransitionDirection transitionDirection) {
        this.f13245a.setTransitionDirection(transitionDirection);
    }

    public void setTransitionDuration(int i4) {
        this.f13245a.setTransitionDuration(i4);
    }

    public void setTransitionType(TransitionType transitionType) {
        this.f13245a.setTransitionType(transitionType);
    }

    public b(Context context, AttributeSet attributeSet, k kVar) {
        super(context, attributeSet);
        this.f13245a = new BannerAdViewImpl(context, attributeSet);
        a();
    }

    public b(Context context, AttributeSet attributeSet, int i4, k kVar) {
        super(context, attributeSet, i4);
        this.f13245a = new BannerAdViewImpl(context, attributeSet, i4);
        a();
    }
}

package com.beizi.p051ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.animation.TransitionDirection;
import com.beizi.p051ad.internal.animation.TransitionType;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.view.BannerAdViewImpl;
import com.kuaishou.weapon.p205p0.C7282g;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseAdView extends FrameLayout implements AdLifeControl {

    /* renamed from: a */
    protected final BannerAdViewImpl f9550a;

    public BaseAdView(Context context, EnumC2888k enumC2888k) {
        super(context);
        this.f9550a = new BannerAdViewImpl(context);
        m50090a();
    }

    /* renamed from: a */
    private void m50090a() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, 0);
        addView(this.f9550a);
    }

    public void cancel() {
        BannerAdViewImpl bannerAdViewImpl = this.f9550a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    public AdListener getAdListener() {
        return this.f9550a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f9550a.getAdSize();
    }

    public String getAdUnitId() {
        return this.f9550a.getAdUnitId();
    }

    public String getPrice() {
        return this.f9550a.getPrice();
    }

    public boolean getResizeAdToFitContainer() {
        return this.f9550a.getResizeAdToFitContainer();
    }

    public void isAutoRefresh() {
        this.f9550a.isAutoRefresh();
    }

    public boolean isLoading() {
        return this.f9550a.isLoading();
    }

    @RequiresPermission(C7282g.f24943a)
    public void loadAd(AdRequest adRequest) {
        this.f9550a.loadAd(adRequest.impl());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onCreateLifeCycle() {
    }

    public void onDestoryLifeCycle() {
        BannerAdViewImpl bannerAdViewImpl = this.f9550a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.onDestoryLifeCycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BannerAdViewImpl bannerAdViewImpl = this.f9550a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.activityOnDestroy();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        if (getResizeAdToFitContainer()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(makeMeasureSpec) / 6, 1073741824));
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i2);
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                HaoboLog.m49289e(HaoboLog.baseLogTag, "Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int m50189b = adSize.m50189b(context);
                i3 = adSize.m50191a(context);
                i4 = m50189b;
            } else {
                i3 = 0;
            }
        }
        int max = Math.max(i4, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (mode == 1073741824) {
            max = View.MeasureSpec.getSize(i);
        }
        if (mode2 == 1073741824) {
            max2 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(View.resolveSize(max, i), View.resolveSize(max2, i2));
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
    protected void onWindowVisibilityChanged(int i) {
        if (i == 8) {
            this.f9550a.activityOnPause();
        } else {
            this.f9550a.activityOnResume();
        }
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f9550a.openAdInNativeBrowser(z);
    }

    public void resume() {
        this.f9550a.activityOnResume();
    }

    public void setAdListener(AdListener adListener) {
        this.f9550a.setAdListener(adListener);
    }

    void setAdSize(AdSize adSize) {
        this.f9550a.setAdSize(adSize.m50190b(), adSize.m50192a());
    }

    public void setAdUnitId(String str) {
        this.f9550a.setAdUnitId(str);
    }

    public void setAutoRefresh(boolean z) {
        this.f9550a.setAutoRefresh(z);
    }

    public void setCloseMarketDialog(boolean z) {
        BannerAdViewImpl bannerAdViewImpl = this.f9550a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.setCloseMarketDialog(z);
        }
    }

    public void setResizeAdToFitContainer(boolean z) {
        this.f9550a.setResizeAdToFitContainer(z);
        if (getResizeAdToFitContainer()) {
            this.f9550a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setTransitionDerection(TransitionDirection transitionDirection) {
        this.f9550a.setTransitionDirection(transitionDirection);
    }

    public void setTransitionDuration(int i) {
        this.f9550a.setTransitionDuration(i);
    }

    public void setTransitionType(TransitionType transitionType) {
        this.f9550a.setTransitionType(transitionType);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, EnumC2888k enumC2888k) {
        super(context, attributeSet);
        this.f9550a = new BannerAdViewImpl(context, attributeSet);
        m50090a();
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, EnumC2888k enumC2888k) {
        super(context, attributeSet, i);
        this.f9550a = new BannerAdViewImpl(context, attributeSet, i);
        m50090a();
    }
}
